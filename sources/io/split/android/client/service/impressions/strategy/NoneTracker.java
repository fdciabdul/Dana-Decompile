package io.split.android.client.service.impressions.strategy;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskSerialWrapper;
import io.split.android.client.service.impressions.ImpressionsCounter;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.impressions.unique.UniqueKeysTracker;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class NoneTracker implements PeriodicTracker {
    private final RetryBackoffCounterTimer mImpressionsCountRetryTimer;
    private final ImpressionsCounter mImpressionsCounter;
    private final int mImpressionsCounterRefreshRate;
    private String mImpressionsRecorderCountTaskId;
    private final SplitTaskExecutor mTaskExecutor;
    private final ImpressionsTaskFactory mTaskFactory;
    private final AtomicBoolean mTrackingIsEnabled;
    private String mUniqueKeysRecorderTaskId;
    private final int mUniqueKeysRefreshRate;
    private final RetryBackoffCounterTimer mUniqueKeysRetryTimer;
    private final UniqueKeysTracker mUniqueKeysTracker;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NoneTracker(SplitTaskExecutor splitTaskExecutor, ImpressionsTaskFactory impressionsTaskFactory, ImpressionsCounter impressionsCounter, UniqueKeysTracker uniqueKeysTracker, RetryBackoffCounterTimer retryBackoffCounterTimer, RetryBackoffCounterTimer retryBackoffCounterTimer2, int i, int i2, boolean z) {
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mTaskFactory = (ImpressionsTaskFactory) Preconditions.checkNotNull(impressionsTaskFactory);
        this.mImpressionsCounter = (ImpressionsCounter) Preconditions.checkNotNull(impressionsCounter);
        this.mUniqueKeysTracker = (UniqueKeysTracker) Preconditions.checkNotNull(uniqueKeysTracker);
        this.mImpressionsCountRetryTimer = (RetryBackoffCounterTimer) Preconditions.checkNotNull(retryBackoffCounterTimer);
        this.mUniqueKeysRetryTimer = (RetryBackoffCounterTimer) Preconditions.checkNotNull(retryBackoffCounterTimer2);
        this.mImpressionsCounterRefreshRate = i;
        this.mUniqueKeysRefreshRate = i2;
        this.mTrackingIsEnabled = new AtomicBoolean(z);
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void flush() {
        flushImpressionsCount();
        flushUniqueKeys();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void startPeriodicRecording() {
        scheduleImpressionsCountRecorderTask();
        scheduleUniqueKeysRecorderTask();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void stopPeriodicRecording() {
        saveImpressionsCount();
        saveUniqueKeys();
        this.mTaskExecutor.stopTask(this.mImpressionsRecorderCountTaskId);
        this.mTaskExecutor.stopTask(this.mUniqueKeysRecorderTaskId);
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void enableTracking(boolean z) {
        this.mTrackingIsEnabled.set(z);
    }

    private void flushImpressionsCount() {
        this.mImpressionsCountRetryTimer.setTask(new SplitTaskSerialWrapper(this.mTaskFactory.createSaveImpressionsCountTask(this.mImpressionsCounter.popAll()), this.mTaskFactory.createImpressionsCountRecorderTask()));
        this.mImpressionsCountRetryTimer.start();
    }

    private void flushUniqueKeys() {
        this.mUniqueKeysRetryTimer.setTask(new SplitTaskSerialWrapper(this.mTaskFactory.createSaveUniqueImpressionsTask(this.mUniqueKeysTracker.popAll()), this.mTaskFactory.createUniqueImpressionsRecorderTask()));
        this.mUniqueKeysRetryTimer.start();
    }

    private void scheduleImpressionsCountRecorderTask() {
        this.mImpressionsRecorderCountTaskId = this.mTaskExecutor.schedule(this.mTaskFactory.createImpressionsCountRecorderTask(), 0L, this.mImpressionsCounterRefreshRate, null);
    }

    private void scheduleUniqueKeysRecorderTask() {
        this.mUniqueKeysRecorderTaskId = this.mTaskExecutor.schedule(this.mTaskFactory.createUniqueImpressionsRecorderTask(), 0L, this.mUniqueKeysRefreshRate, null);
    }

    private void saveImpressionsCount() {
        if (this.mTrackingIsEnabled.get()) {
            this.mTaskExecutor.submit(this.mTaskFactory.createSaveImpressionsCountTask(this.mImpressionsCounter.popAll()), null);
        }
    }

    private void saveUniqueKeys() {
        if (this.mTrackingIsEnabled.get()) {
            this.mTaskExecutor.submit(this.mTaskFactory.createSaveUniqueImpressionsTask(this.mUniqueKeysTracker.popAll()), null);
        }
    }
}

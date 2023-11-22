package io.split.android.client.service.impressions.strategy;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskSerialWrapper;
import io.split.android.client.service.impressions.ImpressionsCounter;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.service.synchronizer.RecorderSyncHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class OptimizedTracker implements PeriodicTracker {
    private final RetryBackoffCounterTimer mImpressionsCountRetryTimer;
    private final ImpressionsCounter mImpressionsCounter;
    private final int mImpressionsCounterRefreshRate;
    private String mImpressionsRecorderCountTaskId;
    private String mImpressionsRecorderTaskId;
    private final int mImpressionsRefreshRate;
    private final RecorderSyncHelper<KeyImpression> mImpressionsSyncHelper;
    private final ImpressionsTaskFactory mImpressionsTaskFactory;
    private final RetryBackoffCounterTimer mRetryTimer;
    private final SplitTaskExecutor mTaskExecutor;
    private final AtomicBoolean mTrackingIsEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OptimizedTracker(ImpressionsCounter impressionsCounter, RecorderSyncHelper<KeyImpression> recorderSyncHelper, SplitTaskExecutor splitTaskExecutor, ImpressionsTaskFactory impressionsTaskFactory, RetryBackoffCounterTimer retryBackoffCounterTimer, RetryBackoffCounterTimer retryBackoffCounterTimer2, int i, int i2, boolean z) {
        this.mImpressionsCounter = (ImpressionsCounter) Preconditions.checkNotNull(impressionsCounter);
        this.mImpressionsSyncHelper = (RecorderSyncHelper) Preconditions.checkNotNull(recorderSyncHelper);
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mImpressionsTaskFactory = (ImpressionsTaskFactory) Preconditions.checkNotNull(impressionsTaskFactory);
        this.mRetryTimer = (RetryBackoffCounterTimer) Preconditions.checkNotNull(retryBackoffCounterTimer);
        this.mImpressionsCountRetryTimer = (RetryBackoffCounterTimer) Preconditions.checkNotNull(retryBackoffCounterTimer2);
        this.mImpressionsRefreshRate = i;
        this.mImpressionsCounterRefreshRate = i2;
        this.mTrackingIsEnabled = new AtomicBoolean(z);
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void flush() {
        flushImpressions();
        flushImpressionsCount();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void startPeriodicRecording() {
        scheduleImpressionsRecorderTask();
        scheduleImpressionsCountRecorderTask();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void stopPeriodicRecording() {
        saveImpressionsCount();
        this.mTaskExecutor.stopTask(this.mImpressionsRecorderTaskId);
        this.mTaskExecutor.stopTask(this.mImpressionsRecorderCountTaskId);
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void enableTracking(boolean z) {
        this.mTrackingIsEnabled.set(z);
    }

    private void flushImpressions() {
        this.mRetryTimer.setTask(this.mImpressionsTaskFactory.createImpressionsRecorderTask(), this.mImpressionsSyncHelper);
        this.mRetryTimer.start();
    }

    private void flushImpressionsCount() {
        this.mImpressionsCountRetryTimer.setTask(new SplitTaskSerialWrapper(this.mImpressionsTaskFactory.createSaveImpressionsCountTask(this.mImpressionsCounter.popAll()), this.mImpressionsTaskFactory.createImpressionsCountRecorderTask()));
        this.mImpressionsCountRetryTimer.start();
    }

    private void scheduleImpressionsRecorderTask() {
        this.mImpressionsRecorderTaskId = this.mTaskExecutor.schedule(this.mImpressionsTaskFactory.createImpressionsRecorderTask(), 0L, this.mImpressionsRefreshRate, this.mImpressionsSyncHelper);
    }

    private void scheduleImpressionsCountRecorderTask() {
        this.mImpressionsRecorderCountTaskId = this.mTaskExecutor.schedule(this.mImpressionsTaskFactory.createImpressionsCountRecorderTask(), 0L, this.mImpressionsCounterRefreshRate, null);
    }

    private void saveImpressionsCount() {
        if (this.mTrackingIsEnabled.get()) {
            this.mTaskExecutor.submit(this.mImpressionsTaskFactory.createSaveImpressionsCountTask(this.mImpressionsCounter.popAll()), null);
        }
    }
}

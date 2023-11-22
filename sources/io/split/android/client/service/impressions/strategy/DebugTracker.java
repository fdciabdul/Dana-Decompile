package io.split.android.client.service.impressions.strategy;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.service.synchronizer.RecorderSyncHelper;

/* loaded from: classes6.dex */
public class DebugTracker implements PeriodicTracker {
    private String mImpressionsRecorderTaskId;
    private final int mImpressionsRefreshRate;
    private final RecorderSyncHelper<KeyImpression> mImpressionsSyncHelper;
    private final ImpressionsTaskFactory mImpressionsTaskFactory;
    private final RetryBackoffCounterTimer mRetryTimer;
    private final SplitTaskExecutor mTaskExecutor;

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void enableTracking(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DebugTracker(RecorderSyncHelper<KeyImpression> recorderSyncHelper, SplitTaskExecutor splitTaskExecutor, ImpressionsTaskFactory impressionsTaskFactory, RetryBackoffCounterTimer retryBackoffCounterTimer, int i) {
        this.mImpressionsSyncHelper = (RecorderSyncHelper) Preconditions.checkNotNull(recorderSyncHelper);
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mImpressionsTaskFactory = (ImpressionsTaskFactory) Preconditions.checkNotNull(impressionsTaskFactory);
        this.mRetryTimer = retryBackoffCounterTimer;
        this.mImpressionsRefreshRate = i;
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void flush() {
        flushImpressions();
    }

    private void flushImpressions() {
        this.mRetryTimer.setTask(this.mImpressionsTaskFactory.createImpressionsRecorderTask(), this.mImpressionsSyncHelper);
        this.mRetryTimer.start();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void startPeriodicRecording() {
        scheduleImpressionsRecorderTask();
    }

    private void scheduleImpressionsRecorderTask() {
        this.mImpressionsRecorderTaskId = this.mTaskExecutor.schedule(this.mImpressionsTaskFactory.createImpressionsRecorderTask(), 0L, this.mImpressionsRefreshRate, this.mImpressionsSyncHelper);
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void stopPeriodicRecording() {
        this.mTaskExecutor.stopTask(this.mImpressionsRecorderTaskId);
    }
}

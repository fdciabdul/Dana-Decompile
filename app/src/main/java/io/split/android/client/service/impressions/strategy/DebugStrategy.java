package io.split.android.client.service.impressions.strategy;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.impressions.Impression;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.service.synchronizer.RecorderSyncHelper;
import io.split.android.client.telemetry.model.ImpressionsDataType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;

/* loaded from: classes6.dex */
class DebugStrategy implements ProcessStrategy {
    private final PeriodicTracker mDebugTracker;
    private final RecorderSyncHelper<KeyImpression> mImpressionsSyncHelper;
    private final ImpressionsTaskFactory mImpressionsTaskFactory;
    private final SplitTaskExecutor mTaskExecutor;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DebugStrategy(RecorderSyncHelper<KeyImpression> recorderSyncHelper, SplitTaskExecutor splitTaskExecutor, ImpressionsTaskFactory impressionsTaskFactory, TelemetryRuntimeProducer telemetryRuntimeProducer, RetryBackoffCounterTimer retryBackoffCounterTimer, int i) {
        this(recorderSyncHelper, splitTaskExecutor, impressionsTaskFactory, telemetryRuntimeProducer, new DebugTracker(recorderSyncHelper, splitTaskExecutor, impressionsTaskFactory, retryBackoffCounterTimer, i));
    }

    DebugStrategy(RecorderSyncHelper<KeyImpression> recorderSyncHelper, SplitTaskExecutor splitTaskExecutor, ImpressionsTaskFactory impressionsTaskFactory, TelemetryRuntimeProducer telemetryRuntimeProducer, PeriodicTracker periodicTracker) {
        this.mImpressionsSyncHelper = (RecorderSyncHelper) Preconditions.checkNotNull(recorderSyncHelper);
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mImpressionsTaskFactory = (ImpressionsTaskFactory) Preconditions.checkNotNull(impressionsTaskFactory);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
        this.mDebugTracker = (PeriodicTracker) Preconditions.checkNotNull(periodicTracker);
    }

    @Override // io.split.android.client.service.impressions.strategy.ProcessStrategy
    public void apply(Impression impression) {
        if (this.mImpressionsSyncHelper.pushAndCheckIfFlushNeeded(KeyImpression.fromImpression(impression))) {
            this.mTaskExecutor.submit(this.mImpressionsTaskFactory.createImpressionsRecorderTask(), this.mImpressionsSyncHelper);
        }
        this.mTelemetryRuntimeProducer.recordImpressionStats(ImpressionsDataType.IMPRESSIONS_QUEUED, 1L);
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void flush() {
        this.mDebugTracker.flush();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void startPeriodicRecording() {
        this.mDebugTracker.startPeriodicRecording();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void stopPeriodicRecording() {
        this.mDebugTracker.stopPeriodicRecording();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void enableTracking(boolean z) {
        this.mDebugTracker.enableTracking(z);
    }
}

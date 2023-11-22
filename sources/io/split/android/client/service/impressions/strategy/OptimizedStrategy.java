package io.split.android.client.service.impressions.strategy;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.impressions.Impression;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.impressions.ImpressionUtils;
import io.split.android.client.service.impressions.ImpressionsCounter;
import io.split.android.client.service.impressions.ImpressionsObserver;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.service.synchronizer.RecorderSyncHelper;
import io.split.android.client.telemetry.model.ImpressionsDataType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
class OptimizedStrategy implements ProcessStrategy {
    private final ImpressionsCounter mImpressionsCounter;
    private final ImpressionsObserver mImpressionsObserver;
    private final RecorderSyncHelper<KeyImpression> mImpressionsSyncHelper;
    private final ImpressionsTaskFactory mImpressionsTaskFactory;
    private final PeriodicTracker mOptimizedTracker;
    private final SplitTaskExecutor mTaskExecutor;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    private final AtomicBoolean mTrackingIsEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OptimizedStrategy(ImpressionsObserver impressionsObserver, ImpressionsCounter impressionsCounter, RecorderSyncHelper<KeyImpression> recorderSyncHelper, SplitTaskExecutor splitTaskExecutor, ImpressionsTaskFactory impressionsTaskFactory, TelemetryRuntimeProducer telemetryRuntimeProducer, RetryBackoffCounterTimer retryBackoffCounterTimer, RetryBackoffCounterTimer retryBackoffCounterTimer2, int i, int i2, boolean z) {
        this(impressionsObserver, impressionsCounter, recorderSyncHelper, splitTaskExecutor, impressionsTaskFactory, telemetryRuntimeProducer, z, new OptimizedTracker(impressionsCounter, recorderSyncHelper, splitTaskExecutor, impressionsTaskFactory, retryBackoffCounterTimer, retryBackoffCounterTimer2, i, i2, z));
    }

    OptimizedStrategy(ImpressionsObserver impressionsObserver, ImpressionsCounter impressionsCounter, RecorderSyncHelper<KeyImpression> recorderSyncHelper, SplitTaskExecutor splitTaskExecutor, ImpressionsTaskFactory impressionsTaskFactory, TelemetryRuntimeProducer telemetryRuntimeProducer, boolean z, PeriodicTracker periodicTracker) {
        this.mImpressionsObserver = (ImpressionsObserver) Preconditions.checkNotNull(impressionsObserver);
        this.mImpressionsCounter = (ImpressionsCounter) Preconditions.checkNotNull(impressionsCounter);
        this.mImpressionsSyncHelper = (RecorderSyncHelper) Preconditions.checkNotNull(recorderSyncHelper);
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mImpressionsTaskFactory = (ImpressionsTaskFactory) Preconditions.checkNotNull(impressionsTaskFactory);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
        this.mTrackingIsEnabled = new AtomicBoolean(z);
        this.mOptimizedTracker = (PeriodicTracker) Preconditions.checkNotNull(periodicTracker);
    }

    @Override // io.split.android.client.service.impressions.strategy.ProcessStrategy
    public void apply(Impression impression) {
        Long testAndSet = this.mImpressionsObserver.testAndSet(impression);
        Impression withPreviousTime = impression.withPreviousTime(testAndSet);
        if (previousTimeIsValid(testAndSet)) {
            this.mImpressionsCounter.inc(withPreviousTime.split(), withPreviousTime.time(), 1);
        }
        KeyImpression fromImpression = KeyImpression.fromImpression(withPreviousTime);
        if (shouldPushImpression(fromImpression)) {
            if (this.mImpressionsSyncHelper.pushAndCheckIfFlushNeeded(fromImpression)) {
                this.mTaskExecutor.submit(this.mImpressionsTaskFactory.createImpressionsRecorderTask(), this.mImpressionsSyncHelper);
            }
            this.mTelemetryRuntimeProducer.recordImpressionStats(ImpressionsDataType.IMPRESSIONS_QUEUED, 1L);
            return;
        }
        this.mTelemetryRuntimeProducer.recordImpressionStats(ImpressionsDataType.IMPRESSIONS_DEDUPED, 1L);
    }

    private static boolean shouldPushImpression(KeyImpression keyImpression) {
        return keyImpression.previousTime == null || ImpressionUtils.truncateTimeframe(keyImpression.previousTime.longValue()) != ImpressionUtils.truncateTimeframe(keyImpression.time);
    }

    private static boolean previousTimeIsValid(Long l) {
        return (l == null || l.longValue() == 0) ? false : true;
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void flush() {
        this.mOptimizedTracker.flush();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void startPeriodicRecording() {
        this.mOptimizedTracker.startPeriodicRecording();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void stopPeriodicRecording() {
        this.mOptimizedTracker.stopPeriodicRecording();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void enableTracking(boolean z) {
        this.mTrackingIsEnabled.set(z);
        this.mOptimizedTracker.enableTracking(z);
    }
}

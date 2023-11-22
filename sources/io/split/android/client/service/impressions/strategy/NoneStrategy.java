package io.split.android.client.service.impressions.strategy;

import com.google.common.base.Preconditions;
import io.split.android.client.impressions.Impression;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.impressions.ImpressionsCounter;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.impressions.unique.UniqueKeysTracker;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
class NoneStrategy implements ProcessStrategy {
    private final ImpressionsCounter mImpressionsCounter;
    private final PeriodicTracker mNoneTracker;
    private final SplitTaskExecutor mTaskExecutor;
    private final ImpressionsTaskFactory mTaskFactory;
    private final AtomicBoolean mTrackingIsEnabled;
    private final UniqueKeysTracker mUniqueKeysTracker;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NoneStrategy(SplitTaskExecutor splitTaskExecutor, ImpressionsTaskFactory impressionsTaskFactory, ImpressionsCounter impressionsCounter, UniqueKeysTracker uniqueKeysTracker, RetryBackoffCounterTimer retryBackoffCounterTimer, RetryBackoffCounterTimer retryBackoffCounterTimer2, int i, int i2, boolean z) {
        this(splitTaskExecutor, impressionsTaskFactory, impressionsCounter, uniqueKeysTracker, z, new NoneTracker(splitTaskExecutor, impressionsTaskFactory, impressionsCounter, uniqueKeysTracker, retryBackoffCounterTimer, retryBackoffCounterTimer2, i, i2, z));
    }

    NoneStrategy(SplitTaskExecutor splitTaskExecutor, ImpressionsTaskFactory impressionsTaskFactory, ImpressionsCounter impressionsCounter, UniqueKeysTracker uniqueKeysTracker, boolean z, PeriodicTracker periodicTracker) {
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mTaskFactory = (ImpressionsTaskFactory) Preconditions.checkNotNull(impressionsTaskFactory);
        this.mImpressionsCounter = (ImpressionsCounter) Preconditions.checkNotNull(impressionsCounter);
        this.mUniqueKeysTracker = (UniqueKeysTracker) Preconditions.checkNotNull(uniqueKeysTracker);
        this.mTrackingIsEnabled = new AtomicBoolean(z);
        this.mNoneTracker = (PeriodicTracker) Preconditions.checkNotNull(periodicTracker);
    }

    @Override // io.split.android.client.service.impressions.strategy.ProcessStrategy
    public void apply(Impression impression) {
        this.mImpressionsCounter.inc(impression.split(), impression.time(), 1);
        this.mUniqueKeysTracker.track(impression.key(), impression.split());
        if (this.mUniqueKeysTracker.isFull()) {
            saveUniqueKeys();
        }
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void flush() {
        this.mNoneTracker.flush();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void startPeriodicRecording() {
        this.mNoneTracker.startPeriodicRecording();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void stopPeriodicRecording() {
        this.mNoneTracker.stopPeriodicRecording();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void enableTracking(boolean z) {
        this.mTrackingIsEnabled.set(z);
        this.mNoneTracker.enableTracking(z);
    }

    private void saveUniqueKeys() {
        if (this.mTrackingIsEnabled.get()) {
            this.mTaskExecutor.submit(this.mTaskFactory.createSaveUniqueImpressionsTask(this.mUniqueKeysTracker.popAll()), null);
        }
    }
}

package io.split.android.client.service.impressions;

import com.google.common.base.Preconditions;
import io.split.android.client.impressions.Impression;
import io.split.android.client.service.impressions.strategy.PeriodicTracker;
import io.split.android.client.service.impressions.strategy.ProcessStrategy;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class StrategyImpressionManager implements ImpressionManager {
    private final AtomicBoolean isTrackingEnabled;
    private final PeriodicTracker mPeriodicTracker;
    private final ProcessStrategy mProcessStrategy;

    public StrategyImpressionManager(ProcessStrategy processStrategy) {
        this(processStrategy, processStrategy);
    }

    StrategyImpressionManager(ProcessStrategy processStrategy, PeriodicTracker periodicTracker) {
        this.isTrackingEnabled = new AtomicBoolean(true);
        this.mProcessStrategy = (ProcessStrategy) Preconditions.checkNotNull(processStrategy);
        this.mPeriodicTracker = (PeriodicTracker) Preconditions.checkNotNull(periodicTracker);
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void enableTracking(boolean z) {
        this.isTrackingEnabled.set(z);
    }

    @Override // io.split.android.client.service.impressions.ImpressionManager
    public void pushImpression(Impression impression) {
        if (!this.isTrackingEnabled.get()) {
            Logger.v("Impression not tracked because tracking is disabled");
        } else {
            this.mProcessStrategy.apply(impression);
        }
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void flush() {
        this.mPeriodicTracker.flush();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void startPeriodicRecording() {
        this.mPeriodicTracker.startPeriodicRecording();
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void stopPeriodicRecording() {
        this.mPeriodicTracker.stopPeriodicRecording();
    }
}

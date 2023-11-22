package io.split.android.client.service.impressions;

import io.split.android.client.impressions.Impression;
import io.split.android.client.service.impressions.strategy.PeriodicTracker;

/* loaded from: classes6.dex */
public interface ImpressionManager extends PeriodicTracker {
    void pushImpression(Impression impression);
}

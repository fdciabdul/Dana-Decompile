package io.split.android.client.service.impressions.strategy;

import io.split.android.client.impressions.Impression;

/* loaded from: classes6.dex */
public interface ProcessStrategy extends PeriodicTracker {
    void apply(Impression impression);
}

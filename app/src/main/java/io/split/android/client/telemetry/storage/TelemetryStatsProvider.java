package io.split.android.client.telemetry.storage;

import io.split.android.client.telemetry.model.Stats;

/* loaded from: classes6.dex */
public interface TelemetryStatsProvider {
    void clearStats();

    Stats getTelemetryStats();
}

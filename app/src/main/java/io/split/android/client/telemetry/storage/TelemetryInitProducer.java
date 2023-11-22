package io.split.android.client.telemetry.storage;

/* loaded from: classes6.dex */
public interface TelemetryInitProducer {
    void recordActiveFactories(int i);

    void recordNonReadyUsage();

    void recordRedundantFactories(int i);

    void recordTimeUntilReady(long j);

    void recordTimeUntilReadyFromCache(long j);
}

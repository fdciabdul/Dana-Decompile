package io.split.android.client.telemetry.storage;

/* loaded from: classes6.dex */
public interface TelemetryInitConsumer {
    long getActiveFactories();

    long getNonReadyUsage();

    long getRedundantFactories();

    long getTimeUntilReady();

    long getTimeUntilReadyFromCache();
}

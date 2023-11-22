package io.split.android.client.telemetry;

/* loaded from: classes6.dex */
public interface TelemetrySynchronizer {
    void destroy();

    void flush();

    void synchronizeConfig();

    void synchronizeStats();
}

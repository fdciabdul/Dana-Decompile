package io.split.android.client.service.impressions.strategy;

/* loaded from: classes6.dex */
public interface PeriodicTracker {
    void enableTracking(boolean z);

    void flush();

    void startPeriodicRecording();

    void stopPeriodicRecording();
}

package io.split.android.client.service.synchronizer;

/* loaded from: classes6.dex */
public interface SyncGuardian {
    void initialize();

    boolean mustSync();

    void setMaxSyncPeriod(long j);

    void updateLastSyncTimestamp();
}

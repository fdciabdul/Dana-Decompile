package com.iap.ac.android.common.timesync.component;

/* loaded from: classes3.dex */
public interface ITimeSyncService {
    public static final long DEFAULT_LAST_SYNC_TIME = -1;

    long getLastSyncTime();

    long getServerTime();

    void setServerTime(long j, long j2);

    void syncTime(ITimeSyncCallback iTimeSyncCallback);
}

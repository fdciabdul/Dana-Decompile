package com.iap.ac.android.common.timesync.component;

/* loaded from: classes8.dex */
public interface ITimeSyncCallback {
    public static final int TIME_SYNC_RPC_ERROR = 5001;
    public static final int TIME_SYNC_SUCCESS = 0;

    void onComplete(int i);
}

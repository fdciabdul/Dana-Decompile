package com.alipay.iap.android.common.timesync;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.timesync.component.ITimeSyncCallback;
import com.alipay.iap.android.common.timesync.component.ITimeSyncService;
import com.alipay.iap.android.common.timesync.component.defaults.DefaultTimeSyncServiceImpl;

/* loaded from: classes3.dex */
public class TimeSyncManager {
    private static final String TAG = "com.alipay.iap.android.common.timesync.TimeSyncManager";
    private static volatile TimeSyncManager instance;
    private ITimeSyncService timeSyncComponent;

    private TimeSyncManager(Context context) {
        this.timeSyncComponent = createTimeSyncComponent(context);
    }

    private ITimeSyncService createTimeSyncComponent(Context context) {
        return new DefaultTimeSyncServiceImpl(context);
    }

    public static TimeSyncManager getInstance(Context context) {
        if (instance == null) {
            if (context == null) {
                LoggerWrapper.e(TAG, "context is null, can not create TimeSyncManager instance");
                return null;
            }
            synchronized (TimeSyncManager.class) {
                if (instance == null) {
                    instance = new TimeSyncManager(context);
                }
            }
        }
        return instance;
    }

    public void setServerTime(long j, long j2) {
        synchronized (this) {
            ITimeSyncService iTimeSyncService = this.timeSyncComponent;
            if (iTimeSyncService == null) {
                LoggerWrapper.e(TAG, "set server time failed because timeSyncComponent is null");
            } else {
                iTimeSyncService.setServerTime(j, j2);
            }
        }
    }

    public void syncTime(ITimeSyncCallback iTimeSyncCallback) {
        synchronized (this) {
            if (this.timeSyncComponent == null) {
                LoggerWrapper.e(TAG, "set server time failed because timeSyncComponent is null");
                return;
            }
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("syncTime begin, callback is:");
            sb.append(iTimeSyncCallback);
            LoggerWrapper.i(str, sb.toString());
            this.timeSyncComponent.syncTime(iTimeSyncCallback);
        }
    }

    public long getServerTime() {
        ITimeSyncService iTimeSyncService = this.timeSyncComponent;
        if (iTimeSyncService == null) {
            LoggerWrapper.e(TAG, "can not get server time because timeSyncComponent is null, return local time");
            return System.currentTimeMillis();
        }
        return iTimeSyncService.getServerTime();
    }

    public long getLastSyncTime() {
        ITimeSyncService iTimeSyncService = this.timeSyncComponent;
        if (iTimeSyncService == null) {
            LoggerWrapper.e(TAG, "can not get server time because timeSyncComponent is null, return local time");
            return -1L;
        }
        return iTimeSyncService.getLastSyncTime();
    }
}

package com.iap.ac.android.common.timesync;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.timesync.component.ITimeSyncCallback;
import com.iap.ac.android.common.timesync.component.ITimeSyncService;
import com.iap.ac.android.common.timesync.component.defaults.DefaultTimeSyncServiceImpl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class TimeSyncManager {
    public static final String TAG = "com.iap.ac.android.common.timesync.TimeSyncManager";
    public static volatile Map<String, TimeSyncManager> instanceMap = new HashMap();
    public ITimeSyncService timeSyncComponent;

    public TimeSyncManager(Context context) {
        this.timeSyncComponent = createTimeSyncComponent(context);
    }

    private ITimeSyncService createTimeSyncComponent(Context context) {
        return new DefaultTimeSyncServiceImpl(context);
    }

    public static TimeSyncManager getInstance(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        TimeSyncManager timeSyncManager = instanceMap.get(str);
        if (timeSyncManager == null) {
            if (context == null) {
                ACLog.e(TAG, "context is null, can not create TimeSyncManager instance");
                return null;
            }
            synchronized (TimeSyncManager.class) {
                if (timeSyncManager == null) {
                    timeSyncManager = new TimeSyncManager(context);
                    instanceMap.put(str, timeSyncManager);
                }
            }
        }
        return timeSyncManager;
    }

    public long getLastSyncTime() {
        ITimeSyncService iTimeSyncService = this.timeSyncComponent;
        if (iTimeSyncService == null) {
            ACLog.e(TAG, "can not get server time because timeSyncComponent is null, return local time");
            return -1L;
        }
        return iTimeSyncService.getLastSyncTime();
    }

    public long getServerTime() {
        ITimeSyncService iTimeSyncService = this.timeSyncComponent;
        if (iTimeSyncService == null) {
            ACLog.e(TAG, "can not get server time because timeSyncComponent is null, return local time");
            return System.currentTimeMillis();
        }
        return iTimeSyncService.getServerTime();
    }

    public void setServerTime(long j, long j2) {
        synchronized (this) {
            ITimeSyncService iTimeSyncService = this.timeSyncComponent;
            if (iTimeSyncService == null) {
                ACLog.e(TAG, "set server time failed because timeSyncComponent is null");
            } else {
                iTimeSyncService.setServerTime(j, j2);
            }
        }
    }

    public void syncTime(ITimeSyncCallback iTimeSyncCallback) {
        synchronized (this) {
            if (this.timeSyncComponent == null) {
                ACLog.e(TAG, "set server time failed because timeSyncComponent is null");
                return;
            }
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("syncTime begin, callback is:");
            sb.append(iTimeSyncCallback);
            ACLog.i(str, sb.toString());
            this.timeSyncComponent.syncTime(iTimeSyncCallback);
        }
    }
}

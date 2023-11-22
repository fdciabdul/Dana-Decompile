package com.alipay.iap.android.common.syncintegration.monitor;

import android.os.SystemClock;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.log.MonitorWrapper;
import com.alipay.mobile.rome.longlinkservice.ConnectionListenerAdapter;
import com.alipay.mobile.rome.longlinkservice.LongLinkSyncService;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class SyncMonitor {
    private static final String SYNC_FAIL = "sync_fail";
    private static final String SYNC_START = "sync_start";
    private static final String TAG = "SyncMonitor";
    private static long lastSyncConnectionFailedTime;
    private static boolean syncMonitorRegistered;

    public static void monitorSyncConnectState() {
        monitorSyncConnectState(10000L);
    }

    public static void monitorSyncConnectState(final long j) {
        LoggerWrapper.d(TAG, "monitorSyncConnectState");
        if (syncMonitorRegistered) {
            LoggerWrapper.d(TAG, "monitorSyncConnectState. already registered!");
            return;
        }
        MonitorWrapper.behaviour(SYNC_START, null);
        syncMonitorRegistered = true;
        LongLinkSyncService.getInstance().addConnectionListener(new ConnectionListenerAdapter() { // from class: com.alipay.iap.android.common.syncintegration.monitor.SyncMonitor.1
            @Override // com.alipay.mobile.rome.longlinkservice.ConnectionListenerAdapter
            public final void onConnecting() {
                LoggerWrapper.d(SyncMonitor.TAG, "onConnecting");
            }

            @Override // com.alipay.mobile.rome.longlinkservice.ConnectionListenerAdapter
            public final void onConnected(long j2) {
                StringBuilder sb = new StringBuilder();
                sb.append("onConnected. totalDuration = ");
                sb.append(j2);
                LoggerWrapper.d(SyncMonitor.TAG, sb.toString());
                long unused = SyncMonitor.lastSyncConnectionFailedTime = 0L;
            }

            @Override // com.alipay.mobile.rome.longlinkservice.ConnectionListenerAdapter
            public final void onConnectFailed(String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("onConnectFailed. errorMessage = ");
                sb.append(str);
                LoggerWrapper.e(SyncMonitor.TAG, sb.toString());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - SyncMonitor.lastSyncConnectionFailedTime > j) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("errorMessage", str);
                    MonitorWrapper.behaviour(SyncMonitor.SYNC_FAIL, hashMap);
                } else {
                    LoggerWrapper.i(SyncMonitor.TAG, "Sync connect failed during 10s, will skip report this failure");
                }
                long unused = SyncMonitor.lastSyncConnectionFailedTime = elapsedRealtime;
            }

            @Override // com.alipay.mobile.rome.longlinkservice.ConnectionListenerAdapter
            public final void onDisconnected() {
                LoggerWrapper.d(SyncMonitor.TAG, "onDisconnected");
            }
        });
    }
}

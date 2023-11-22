package id.dana.data.foundation.amcs;

import android.os.SystemClock;
import com.alipay.iap.android.common.log.MonitorWrapper;
import com.alipay.mobile.rome.longlinkservice.ConnectionListenerAdapter;
import com.alipay.mobile.rome.longlinkservice.LongLinkSyncService;
import com.iap.ac.config.lite.common.KVBuilder;
import id.dana.utils.foundation.logger.log.DanaLog;

/* loaded from: classes2.dex */
public class SyncTriggerMonitor {
    private static boolean BuiltInFictitiousFunctionClassFactory;
    private static long PlaceComponentResult;

    public static void getAuthRequestContext() {
        DanaLog.MyBillsEntityDataFactory("SyncTriggerMonitor", "monitorSyncConnectState");
        if (BuiltInFictitiousFunctionClassFactory) {
            DanaLog.MyBillsEntityDataFactory("SyncTriggerMonitor", "monitorSyncConnectState. already registered!");
            return;
        }
        MonitorWrapper.behaviour("sync_start", null);
        BuiltInFictitiousFunctionClassFactory = true;
        LongLinkSyncService.getInstance().addConnectionListener(new ConnectionListenerAdapter() { // from class: id.dana.data.foundation.amcs.SyncTriggerMonitor.1
            final /* synthetic */ long MyBillsEntityDataFactory = 10000;

            @Override // com.alipay.mobile.rome.longlinkservice.ConnectionListenerAdapter
            public void onConnecting() {
                DanaLog.MyBillsEntityDataFactory("SyncTriggerMonitor", "onConnecting");
            }

            @Override // com.alipay.mobile.rome.longlinkservice.ConnectionListenerAdapter
            public void onConnected(long j) {
                StringBuilder sb = new StringBuilder();
                sb.append("onConnected. totalDuration = ");
                sb.append(j);
                DanaLog.MyBillsEntityDataFactory("SyncTriggerMonitor", sb.toString());
                long unused = SyncTriggerMonitor.PlaceComponentResult = 0L;
            }

            @Override // com.alipay.mobile.rome.longlinkservice.ConnectionListenerAdapter
            public void onConnectFailed(String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("onConnectFailed. errorMessage = ");
                sb.append(str);
                DanaLog.BuiltInFictitiousFunctionClassFactory("SyncTriggerMonitor", sb.toString());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - SyncTriggerMonitor.PlaceComponentResult > this.MyBillsEntityDataFactory) {
                    MonitorWrapper.behaviour("sync_fail", KVBuilder.newBuilder().put("errorMessage", str).build());
                } else {
                    DanaLog.getAuthRequestContext("SyncTriggerMonitor", "Sync connect failed during 10s, will skip report this failure");
                }
                long unused = SyncTriggerMonitor.PlaceComponentResult = elapsedRealtime;
            }

            @Override // com.alipay.mobile.rome.longlinkservice.ConnectionListenerAdapter
            public void onDisconnected() {
                DanaLog.MyBillsEntityDataFactory("SyncTriggerMonitor", "onDisconnected");
            }
        });
    }
}

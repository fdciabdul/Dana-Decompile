package com.alibaba.griver.base.common.monitor;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorProxy;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.TrackingCodeManager;
import com.alibaba.griver.base.common.constants.GriverBaseConstants;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.base.resource.appcenter.storage.GriverAppInfoStorage;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class GriverMonitor {
    static /* synthetic */ GriverMonitorProxy access$500() {
        return a();
    }

    public static void event(final String str, final String str2, final Map<String, String> map) {
        GriverExecutors.getSingleMonitorThreadExecutor().execute(new Runnable() { // from class: com.alibaba.griver.base.common.monitor.GriverMonitor.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!MonitorManager.shouldNotMonitor(str, map)) {
                    GriverMonitor.a(map);
                    GriverMonitor.d(map);
                    GriverMonitor.b(map);
                    GriverMonitor.c(map);
                    GriverMonitor.a("EVENT", str, str2, map);
                    GriverMonitor.access$500().event(str, str2, map);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("monitor do not upload: ");
                sb.append(str);
                GriverLogger.w("GriverMonitor", sb.toString());
            }
        });
    }

    public static void performance(final String str, final String str2, final Map<String, String> map) {
        GriverExecutors.getSingleMonitorThreadExecutor().execute(new Runnable() { // from class: com.alibaba.griver.base.common.monitor.GriverMonitor.2
            @Override // java.lang.Runnable
            public final void run() {
                if (!MonitorManager.shouldNotMonitor(str, map)) {
                    GriverMonitor.a(map);
                    GriverMonitor.d(map);
                    GriverMonitor.b(map);
                    GriverMonitor.c(map);
                    GriverMonitor.a("PERFORMANCE", str, str2, map);
                    DebugMonitor.writeDebugMonitor(str, str2, map);
                    GriverMonitor.access$500().performance(str, str2, map);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("monitor do not upload: ");
                sb.append(str);
                GriverLogger.w("GriverMonitor", sb.toString());
            }
        });
    }

    public static void error(final String str, final String str2, final Map<String, String> map) {
        GriverExecutors.getSingleMonitorThreadExecutor().execute(new Runnable() { // from class: com.alibaba.griver.base.common.monitor.GriverMonitor.3
            @Override // java.lang.Runnable
            public final void run() {
                if (!MonitorManager.shouldNotMonitor(str, map)) {
                    GriverMonitor.a(map);
                    GriverMonitor.d(map);
                    GriverMonitor.b(map);
                    GriverMonitor.c(map);
                    GriverMonitor.a("Error", str, str2, map);
                    GriverMonitor.access$500().error(str, str2, map);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("monitor do not upload: ");
                sb.append(str);
                GriverLogger.w("GriverMonitor", sb.toString());
            }
        });
    }

    public static void commonException(final String str, final String str2, final String str3, final String str4, final Map<String, String> map) {
        GriverExecutors.getSingleMonitorThreadExecutor().execute(new Runnable() { // from class: com.alibaba.griver.base.common.monitor.GriverMonitor.4
            @Override // java.lang.Runnable
            public final void run() {
                GriverMonitor.a(map);
                GriverMonitor.d(map);
                GriverMonitor.b(map);
                GriverMonitor.c(map);
                map.put("exception_id", str);
                GriverMonitor.a(map, str3, str4);
                GriverMonitor.a(GriverMonitorConstants.KEY_COMMON_EXCEPTION, str, str2, map);
                GriverMonitor.access$500().error(GriverMonitorConstants.KEY_COMMON_EXCEPTION, str2, map);
            }
        });
    }

    public static void pageStart(final Object obj, final String str) {
        GriverExecutors.getSingleMonitorThreadExecutor().execute(new Runnable() { // from class: com.alibaba.griver.base.common.monitor.GriverMonitor.5
            @Override // java.lang.Runnable
            public final void run() {
                if (MonitorManager.shouldNotMonitor(GriverMonitorConstants.EVENT_NATIVE_PAGE_START, null)) {
                    GriverLogger.w("GriverMonitor", "monitor not enabled, do not upload native page start");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("page start monitor: ");
                sb.append(str);
                GriverLogger.d("GriverMonitor", sb.toString());
                GriverMonitor.access$500().pageStart(obj, str);
            }
        });
    }

    public static void pageExit(final Object obj, final String str, final String str2, final Map<String, String> map) {
        GriverExecutors.getSingleMonitorThreadExecutor().execute(new Runnable() { // from class: com.alibaba.griver.base.common.monitor.GriverMonitor.6
            @Override // java.lang.Runnable
            public final void run() {
                if (MonitorManager.shouldNotMonitor(GriverMonitorConstants.EVENT_NATIVE_PAGE_END, null)) {
                    GriverLogger.w("GriverMonitor", "monitor not enabled, do not upload native page exit");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("page exit monitor: ");
                sb.append(str);
                GriverLogger.d("GriverMonitor", sb.toString());
                GriverMonitor.access$500().pageExit(obj, str, str2, map);
            }
        });
    }

    public static void pageDestroy(final Object obj) {
        GriverExecutors.getSingleMonitorThreadExecutor().execute(new Runnable() { // from class: com.alibaba.griver.base.common.monitor.GriverMonitor.7
            @Override // java.lang.Runnable
            public final void run() {
                if (MonitorManager.shouldNotMonitor(GriverMonitorConstants.EVENT_NATIVE_PAGE_DESTROY, null)) {
                    GriverLogger.w("GriverMonitor", "monitor not enabled, do not upload native page destroy");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("page destroy monitor: ");
                sb.append(obj);
                GriverLogger.d("GriverMonitor", sb.toString());
                GriverMonitor.access$500().pageDestroy(obj);
                Map event = GriverAppInfoStorage.getEvent();
                if (event == null || event.keySet().size() <= 0) {
                    return;
                }
                GriverMonitor.event(GriverMonitorConstants.EVENT_MEMORY_QUERY_APP, "GriverAppContainer", event);
            }
        });
    }

    public static void upload() {
        GriverExecutors.getSingleMonitorThreadExecutor().execute(new Runnable() { // from class: com.alibaba.griver.base.common.monitor.GriverMonitor.8
            @Override // java.lang.Runnable
            public final void run() {
                GriverMonitor.access$500().upload();
            }
        });
    }

    private static GriverMonitorProxy a() {
        return (GriverMonitorProxy) RVProxy.get(GriverMonitorProxy.class);
    }

    public static Map<String, String> getCommonExceptionMap(Throwable th) {
        HashMap hashMap = new HashMap();
        if (th == null) {
            GriverLogger.w("GriverMonitor", "exception is null, return empty map");
            return hashMap;
        }
        hashMap.put(GriverMonitorConstants.KEY_EXCEPTION_CLASS, th.getClass().getName());
        hashMap.put(GriverMonitorConstants.KEY_EXCEPTION_MESSAGE, th.getLocalizedMessage());
        return hashMap;
    }

    public static HashMap<String, String> convertObjectToString(Map<String, ? extends Object> map) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue() == null ? "" : entry.getValue().toString());
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, String str2, String str3, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("MONITOR ");
        sb.append(str);
        sb.append("\n");
        sb.append("monitorId: ");
        sb.append(str2);
        sb.append("\n");
        sb.append("bizType: ");
        sb.append(str3);
        sb.append("\n");
        sb.append("extras: \n");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(entry.getValue());
                sb.append("\n");
            }
        }
        GriverLogger.d("GriverMonitor", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (SummaryActivity.CHECKED.equalsIgnoreCase(map.get(GriverMonitorConstants.KEY_NEED_ASYNC_APP_TYPE)) && map.containsKey("appId")) {
            List<AppModel> queryAppInfo = GriverAppCenter.queryAppInfo(map.get("appId"));
            String str = GriverMonitorConstants.APP_TYPE_H5;
            if (queryAppInfo != null && queryAppInfo.size() > 0) {
                if (AppInfoUtils.isTinyApp(queryAppInfo.get(0))) {
                    if (AppInfoUtils.isEmbeddedApp(queryAppInfo.get(0))) {
                        map.put(GriverMonitorConstants.KEY_MINI_PROGRAM_TYPE, GriverMonitorConstants.MINI_PROGRAM_TYPE_PWA);
                    } else {
                        map.put(GriverMonitorConstants.KEY_MINI_PROGRAM_TYPE, GriverMonitorConstants.MINI_PROGRAM_TYPE_DSL);
                    }
                    map.put("appType", GriverMonitorConstants.APP_TYPE_MINI);
                    if (GriverAppxNgRuntimeChecker.isUseAppxNg(queryAppInfo.get(0))) {
                        map.put("appxVersion", "2");
                    } else {
                        map.put("appxVersion", "1");
                    }
                } else {
                    map.put("appType", GriverMonitorConstants.APP_TYPE_H5);
                }
            } else {
                String str2 = map.get("appId");
                if (!(TextUtils.isEmpty(str2) || str2.endsWith(GriverBaseConstants.H5_ONLINE_SUFFIX))) {
                    str = GriverMonitorConstants.APP_TYPE_MINI;
                }
                map.put("appType", str);
            }
        }
        map.remove(GriverMonitorConstants.KEY_NEED_ASYNC_APP_TYPE);
        if (map.containsKey("appId")) {
            String trackingCode = TrackingCodeManager.getInstance().getTrackingCode(map.get("appId"));
            if (TextUtils.isEmpty(trackingCode)) {
                return;
            }
            map.put("trackingCode", trackingCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map<String, String> map) {
        if (map == null || map.size() == 0 || !map.containsKey("appId") || map.get("appId") == null) {
            return;
        }
        String str = map.get("appId");
        if (TextUtils.equals("null_online", str)) {
            map.put("appId", "");
            map.put(GriverMonitorConstants.KEY_LOAD_TYPE, "online");
        } else if (str.contains(GriverBaseConstants.H5_ONLINE_SUFFIX)) {
            map.put("appId", str.replace(GriverBaseConstants.H5_ONLINE_SUFFIX, ""));
            map.put(GriverMonitorConstants.KEY_LOAD_TYPE, "online");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Map<String, String> map) {
        AppModel queryHighestAppInfo;
        if (map == null || map.size() == 0 || !GriverMonitorConstants.APP_TYPE_MINI.equals(map.get("appType")) || TextUtils.isEmpty(map.get("appId")) || (queryHighestAppInfo = GriverAppCenter.queryHighestAppInfo(map.get("appId"))) == null || queryHighestAppInfo.getAppInfoModel() == null) {
            return;
        }
        if (!map.containsKey("version") && !TextUtils.isEmpty(queryHighestAppInfo.getAppInfoModel().getDeveloperVersion())) {
            map.put("version", queryHighestAppInfo.getAppInfoModel().getDeveloperVersion());
        }
        if (map.containsKey("deployVersion") || TextUtils.isEmpty(queryHighestAppInfo.getAppInfoModel().getVersion())) {
            return;
        }
        map.put("deployVersion", queryHighestAppInfo.getAppInfoModel().getVersion());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Map<String, String> map, String str, String str2) {
        if (map == null || map.size() == 0) {
            return;
        }
        map.put("errorCode", str);
        map.put("errorMessage", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        String environment = GriverEnv.getEnvironment();
        if (TextUtils.isEmpty(environment)) {
            environment = "prod";
        }
        map.put("env", environment);
    }
}

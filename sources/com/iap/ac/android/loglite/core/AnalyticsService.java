package com.iap.ac.android.loglite.core;

import android.text.TextUtils;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.DynamicLayerModel;
import com.alipay.iap.android.aplog.log.behavior.BehaviorID;
import com.iap.ac.android.loglite.core.pageMonitor.PageMonitorLifecycleCallbacks;
import com.iap.ac.android.loglite.log.AntEvent;
import com.iap.ac.android.loglite.log.KeyBizExceptionLog;
import com.iap.ac.android.loglite.log.LogEvent;
import com.iap.ac.android.loglite.log.PerformanceLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class AnalyticsService {

    /* renamed from: a */
    public static final List<String> f7589a = Arrays.asList("pageview", BehaviorID.EXPOSURE, DynamicLayerModel.TYPE_CLICK);
    public static PageMonitorLifecycleCallbacks b;

    public static Map<String, String> a(Map<String, String> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key)) {
                    if (value == null) {
                        value = "";
                    }
                    concurrentHashMap.put(key, value);
                }
            }
        }
        return concurrentHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            java.util.Map r7 = a(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r1 = "TinyAppBiz-"
            if (r0 != 0) goto L43
            boolean r0 = r5.startsWith(r1)
            if (r0 == 0) goto L43
            r0 = r7
            j$.util.concurrent.ConcurrentHashMap r0 = (j$.util.concurrent.ConcurrentHashMap) r0
            java.lang.String r2 = "spmId"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.util.List<java.lang.String> r2 = com.iap.ac.android.loglite.core.AnalyticsService.f7589a
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L2c
            android.util.Pair r2 = new android.util.Pair
            r2.<init>(r4, r0)
            goto L33
        L2c:
            android.util.Pair r2 = new android.util.Pair
            java.lang.String r0 = "event"
            r2.<init>(r0, r4)
        L33:
            java.lang.Object r0 = r2.first
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r2.second
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L44
            r4 = r2
            goto L44
        L43:
            r0 = 0
        L44:
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 != 0) goto L72
            boolean r1 = r5.startsWith(r1)
            if (r1 == 0) goto L72
            r1 = r7
            j$.util.concurrent.ConcurrentHashMap r1 = (j$.util.concurrent.ConcurrentHashMap) r1
            java.lang.String r2 = "isEventLink"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r3 = "true"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L72
            java.lang.String r2 = "eventId"
            java.lang.Object r1 = r1.get(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L72
            r1 = 1
            goto L73
        L72:
            r1 = 0
        L73:
            if (r1 == 0) goto L7b
            com.iap.ac.android.loglite.log.AntEvent r0 = new com.iap.ac.android.loglite.log.AntEvent
            r0.<init>(r4, r7)
            goto L83
        L7b:
            com.iap.ac.android.loglite.log.BehaviorLog r1 = new com.iap.ac.android.loglite.log.BehaviorLog
            r1.<init>(r4, r7)
            r1.g = r0
            r0 = r1
        L83:
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 != 0) goto L8b
            r0.c = r5
        L8b:
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 != 0) goto L93
            r0.e = r6
        L93:
            com.iap.ac.android.loglite.core.AnalyticsContext r4 = com.iap.ac.android.loglite.core.AnalyticsContext.getInstance()
            com.iap.ac.android.loglite.storage.AnalyticsStorageManager r4 = r4.getStorageManager()
            r4.a(r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.loglite.core.AnalyticsService.b(java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public static void c(String str, String str2, String str3, Map<String, String> map) {
        LogEvent keyBizExceptionLog;
        Map<String, String> a2 = a(map);
        if (TextUtils.equals(str2, GriverMonitorConstants.APPX_PERFORMANCE_ERROR_BIZ_TYPE)) {
            keyBizExceptionLog = new AntEvent(str, a2);
        } else {
            keyBizExceptionLog = new KeyBizExceptionLog(str, a2);
        }
        if (!TextUtils.isEmpty(str2)) {
            keyBizExceptionLog.c = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            keyBizExceptionLog.e = str3;
        }
        AnalyticsContext.getInstance().getStorageManager().a(keyBizExceptionLog, str3);
    }

    public static void d(String str, String str2, String str3, Map<String, String> map) {
        LogEvent performanceLog;
        Map<String, String> a2 = a(map);
        if (TextUtils.equals(str2, GriverMonitorConstants.APPX_PERFORMANCE_ERROR_BIZ_TYPE)) {
            performanceLog = new AntEvent(str, a2);
        } else {
            performanceLog = new PerformanceLog(str, a2);
        }
        if (!TextUtils.isEmpty(str2)) {
            performanceLog.c = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            performanceLog.e = str3;
        }
        AnalyticsContext.getInstance().getStorageManager().a(performanceLog, str3);
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        AntEvent antEvent = new AntEvent(str, a(map));
        if (!TextUtils.isEmpty(str2)) {
            antEvent.c = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            antEvent.e = str3;
        }
        AnalyticsContext.getInstance().getStorageManager().a(antEvent, str3);
    }
}

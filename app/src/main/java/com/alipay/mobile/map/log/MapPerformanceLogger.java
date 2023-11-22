package com.alipay.mobile.map.log;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.embedview.mapbiz.core.controller.ReportController;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class MapPerformanceLogger {
    public static final MapPerformanceLogger INSTANCE = new MapPerformanceLogger();

    private MapPerformanceLogger() {
    }

    public void logJsApiExecutionTime(Context context, String str, String str2, long j) {
        if (j < 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("JSAPI", str2);
        logEventTime(context, str, "JSAPI", j, hashMap);
    }

    public void logJsApiLaunchTime(Context context, String str, String str2, long j) {
        if (j < 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("JSAPI", str2);
        logEventTime(context, str, "launchJSAPI", j, hashMap);
    }

    public void logCreateMapTime(Context context, String str, boolean z, long j) {
        if (j < 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ReportController.PARAM_MAP_2D, z ? "1" : "0");
        logEventTime(context, str, "createMap", j, hashMap);
    }

    public void logDoLocationTime(Context context, String str, long j) {
        if (j < 0) {
            return;
        }
        logEventTime(context, str, "location", j, null);
    }

    public void logMarkerLimit(Context context, String str, long j) {
        if (j <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("perfCount", String.valueOf(j));
        logEventTime(context, str, "markerLimit", hashMap);
    }

    public void logEventTime(Context context, String str, String str2, Map<String, String> map) {
        logEventTime(context, str, str2, -1L, map);
    }

    public void logEventTime(Context context, String str, String str2, long j, Map<String, String> map) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("appId", str);
        hashMap.put("mapPerf", str2);
        if (j >= 0) {
            hashMap.put("perfCost", String.valueOf(j));
        }
        MapLoggerFactory.expose(context, "a565.b11414.c27269.d51587", hashMap);
    }
}

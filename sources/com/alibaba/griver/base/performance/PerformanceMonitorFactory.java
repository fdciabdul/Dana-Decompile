package com.alibaba.griver.base.performance;

import com.alibaba.ariver.app.api.App;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.performance.jsapi.PerformanceJSAPIMonitor;
import com.alibaba.griver.base.performance.network.PerformanceNetworkMonitor;
import com.alibaba.griver.base.performance.network7.PerformanceNetwork7Monitor;
import com.alibaba.griver.base.performance.pdstrackers.PdsTrackersMonitor;
import com.alibaba.griver.base.performance.setdata.PerformanceSetDataMonitor;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class PerformanceMonitorFactory {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, ConcurrentHashMap<PerformanceType, PerformanceMonitor>> f6327a = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    public enum PerformanceType {
        JSAPI,
        NETWORK,
        SET_DATA,
        NETWORK_7,
        PDS_TRACKERS
    }

    private PerformanceMonitorFactory() {
    }

    public static void register(String str) {
        unRegister(str);
        ConcurrentHashMap<PerformanceType, PerformanceMonitor> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(PerformanceType.JSAPI, new PerformanceJSAPIMonitor());
        concurrentHashMap.put(PerformanceType.SET_DATA, new PerformanceSetDataMonitor());
        concurrentHashMap.put(PerformanceType.NETWORK, new PerformanceNetworkMonitor());
        concurrentHashMap.put(PerformanceType.NETWORK_7, new PerformanceNetwork7Monitor());
        concurrentHashMap.put(PerformanceType.PDS_TRACKERS, new PdsTrackersMonitor());
        f6327a.put(str, concurrentHashMap);
    }

    public static void unRegister(String str) {
        ConcurrentHashMap<PerformanceType, PerformanceMonitor> concurrentHashMap = f6327a.get(str);
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        f6327a.remove(str);
    }

    public static <T extends PerformanceMonitor> T getPerformanceMonitor(String str, PerformanceType performanceType) {
        ConcurrentHashMap<PerformanceType, PerformanceMonitor> concurrentHashMap = f6327a.get(str);
        T t = concurrentHashMap != null ? (T) concurrentHashMap.get(performanceType) : null;
        if (t != null) {
            return t;
        }
        return null;
    }

    public static JSONObject getPerformance(String str) {
        JSONObject data;
        JSONObject jSONObject = new JSONObject();
        ConcurrentHashMap<PerformanceType, PerformanceMonitor> concurrentHashMap = f6327a.get(str);
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<PerformanceType, PerformanceMonitor>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                PerformanceMonitor value = it.next().getValue();
                if (value != null && (data = value.getData()) != null) {
                    jSONObject.putAll(data);
                }
            }
        }
        return jSONObject;
    }

    public static void upload(App app) {
        ConcurrentHashMap<PerformanceType, PerformanceMonitor> concurrentHashMap = f6327a.get(app.getAppId());
        if (concurrentHashMap != null) {
            Iterator<PerformanceMonitor> it = concurrentHashMap.values().iterator();
            while (it.hasNext()) {
                it.next().upload(app);
            }
        }
    }
}

package com.alibaba.griver.base.performance.jsapi;

import android.os.SystemClock;
import android.util.LruCache;
import com.alibaba.ariver.app.api.App;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.utils.MapBuilder;
import com.alibaba.griver.base.performance.PerformanceAmcsManager;
import com.alibaba.griver.base.performance.PerformanceBaseMonitor;
import com.iap.ac.android.acs.plugin.utils.Constants;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class PerformanceJSAPIMonitor extends PerformanceBaseMonitor {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, LruCache<String, Long>> f6329a = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, PerformanceJsApiModel> b = new ConcurrentHashMap<>();
    private final PerformanceAuthCodeModel c = new PerformanceAuthCodeModel();
    private int d;

    private PerformanceJsApiModel a(String str) {
        if (this.b.get(str) == null) {
            this.b.put(str, new PerformanceJsApiModel());
        }
        return this.b.get(str);
    }

    private LruCache<String, Long> b(String str) {
        if (this.f6329a.get(str) == null) {
            this.f6329a.put(str, new LruCache<>(100));
        }
        return this.f6329a.get(str);
    }

    public void begin(String str, String str2) {
        this.d++;
        if (Constants.JS_API_GET_AUTH_CODE.equals(str)) {
            this.c.begin(str2, SystemClock.elapsedRealtime());
        }
        List<String> apiBlackList = PerformanceAmcsManager.getInstance().getApiBlackList();
        if (apiBlackList == null || !apiBlackList.contains(str)) {
            b(str).put(str2, Long.valueOf(System.currentTimeMillis()));
            a(str).beginAdd();
        }
    }

    public void end(String str, String str2) {
        Long l;
        if (Constants.JS_API_GET_AUTH_CODE.equals(str)) {
            this.c.end(str2, SystemClock.elapsedRealtime());
        }
        List<String> apiBlackList = PerformanceAmcsManager.getInstance().getApiBlackList();
        if ((apiBlackList != null && apiBlackList.contains(str)) || (l = b(str).get(str2)) == null || l.longValue() == 0) {
            return;
        }
        PerformanceJsApiModel a2 = a(str);
        a2.endAdd();
        long currentTimeMillis = System.currentTimeMillis() - l.longValue();
        a2.processAdd(currentTimeMillis);
        a(str, a2, currentTimeMillis);
        b(str).remove(str2);
    }

    private void a(String str, PerformanceJsApiModel performanceJsApiModel, long j) {
        Map<String, Long> apiThresholdMap;
        PerformanceJsApiTimeOutConfig performanceJsApiTimeOutConfig = PerformanceAmcsManager.getInstance().getPerformanceJsApiTimeOutConfig();
        if (performanceJsApiTimeOutConfig != null) {
            if ((performanceJsApiTimeOutConfig.blackJsApiList == null || !performanceJsApiTimeOutConfig.blackJsApiList.contains(str)) && (apiThresholdMap = performanceJsApiTimeOutConfig.getApiThresholdMap()) != null) {
                Long l = apiThresholdMap.get(str);
                if (j > ((l == null || l.longValue() <= 0) ? performanceJsApiTimeOutConfig.timeThreshold : l.longValue())) {
                    performanceJsApiModel.timeOutAdd();
                }
            }
        }
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public void clear() {
        this.b.clear();
        this.f6329a.clear();
        this.c.clear();
        this.d = 0;
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public void upload(App app) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, PerformanceJsApiModel> entry : this.b.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().getUploadMap());
            if (entry.getValue().getTimeOutCount() > 0) {
                String key = entry.getKey();
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getValue().getTimeOutCount());
                hashMap2.put(key, sb.toString());
            }
        }
        if (hashMap.size() > 0) {
            GriverMonitor.event("griver_mini_program_performance_jsapi", "GriverAppContainer", getExtendInfo(app, hashMap));
        }
        if (hashMap2.size() > 0) {
            GriverMonitor.event("griver_mini_program_performance_jsapi_error_timeout", "GriverAppContainer", getExtendInfo(app, hashMap2));
        }
        if (this.d > 0) {
            GriverMonitor.event("mpp_jsapi_total", "GriverAppContainer", new MapBuilder.Builder().map("total", String.valueOf(this.d)).map(GriverMonitorConstants.KEY_NEED_ASYNC_APP_TYPE, Boolean.TRUE.toString()).map("appId", app.getAppId()).build());
        }
    }

    public String getAuthCodeEncodeString() {
        Map<String, Object> uploadMap = this.c.getUploadMap();
        if (uploadMap != null) {
            return encodeMap(uploadMap);
        }
        return null;
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public JSONObject getData() {
        Map<String, Object> hashMap = new HashMap<>();
        Map<String, Object> hashMap2 = new HashMap<>();
        for (Map.Entry<String, PerformanceJsApiModel> entry : this.b.entrySet()) {
            Map<String, String> uploadMap = entry.getValue().getUploadMap();
            JSONObject jSONObject = new JSONObject();
            jSONObject.putAll(uploadMap);
            hashMap.put(entry.getKey(), jSONObject);
            if (entry.getValue().getTimeOutCount() > 0) {
                String key = entry.getKey();
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getValue().getTimeOutCount());
                hashMap2.put(key, sb.toString());
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(InvoiceConstant.SUMMARY, (Object) encodeMap(hashMap));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(InvoiceConstant.SUMMARY, (Object) encodeMap(hashMap2));
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("griver_mini_program_performance_jsapi", (Object) jSONObject2);
        jSONObject4.put("griver_mini_program_performance_jsapi_error_timeout", (Object) jSONObject3);
        return jSONObject4;
    }
}

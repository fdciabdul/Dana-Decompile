package com.alibaba.griver.base.performance.network;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.performance.PerformanceAmcsManager;
import com.alibaba.griver.base.performance.PerformanceBaseMonitor;
import com.alibaba.griver.base.performance.network.PerformanceNetworkTimeConfig;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import java.util.Map;

/* loaded from: classes6.dex */
public class PerformanceNetworkMonitor extends PerformanceBaseMonitor {
    public static final String KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_RESOURCE = "griver_mini_program_performance_network_resource";
    public static final String KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_RESPONSE_SIZE_ERROR = "griver_mini_program_performance_network_response_size_error";
    public static final String KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_STATUS_ERROR = "griver_mini_program_performance_network_status_error";
    public static final String KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_TIMEOUT_ERROR = "griver_mini_program_performance_network_timeout_error";

    /* renamed from: a  reason: collision with root package name */
    private final PerformanceNetworkResourceModel f6332a = new PerformanceNetworkResourceModel();
    private final PerformanceNetworkResourceErrorModel b = new PerformanceNetworkResourceErrorModel();
    private final PerformanceNetworkResourceErrorModel c = new PerformanceNetworkResourceErrorModel();
    private final PerformanceNetworkResourceStatusErrorModel d = new PerformanceNetworkResourceStatusErrorModel();

    public void setNetworkResourceModel(String str, String str2, long j, long j2) {
        PerformanceNetworkTimeConfig.MineTypeConfig config;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j < 0 || j2 < 0) {
            return;
        }
        this.f6332a.setNetworkResourceModel(str2, j, j2);
        PerformanceNetworkTimeConfig performanceNetworkTimeOutConfig = PerformanceAmcsManager.getInstance().getPerformanceNetworkTimeOutConfig();
        if (performanceNetworkTimeOutConfig == null || (config = performanceNetworkTimeOutConfig.getConfig(str2)) == null) {
            return;
        }
        if (j2 > config.size) {
            this.b.add(str);
        }
        if (j > config.time) {
            this.c.add(str);
        }
    }

    public void setNetworkResourceStatusErrorModel(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.startsWith("3") || str2.startsWith("2")) {
            return;
        }
        this.d.add(str, str2);
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public void clear() {
        this.f6332a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public void upload(App app) {
        Map<String, Map<String, String>> uploadMap = this.f6332a.getUploadMap();
        if (uploadMap != null && uploadMap.size() > 0) {
            GriverMonitor.event(KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_RESOURCE, "GriverAppContainer", getExtendInfo(app, uploadMap));
        }
        Map<String, String> uploadMap2 = this.b.getUploadMap();
        if (uploadMap2 != null && uploadMap2.size() > 0) {
            GriverMonitor.event(KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_RESPONSE_SIZE_ERROR, "GriverAppContainer", getExtendInfo(app, uploadMap2));
        }
        Map<String, String> uploadMap3 = this.c.getUploadMap();
        if (uploadMap2 != null && uploadMap2.size() > 0) {
            GriverMonitor.event(KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_TIMEOUT_ERROR, "GriverAppContainer", getExtendInfo(app, uploadMap3));
        }
        Map<String, Map<String, Integer>> uploadMap4 = this.d.getUploadMap();
        if (uploadMap2 == null || uploadMap2.size() <= 0) {
            return;
        }
        GriverMonitor.event(KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_STATUS_ERROR, "GriverAppContainer", getExtendInfo(app, uploadMap4));
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public JSONObject getData() {
        JSONObject jSONObject = new JSONObject();
        Map<String, Map<String, String>> uploadMap = this.f6332a.getUploadMap();
        if (uploadMap != null) {
            jSONObject.put(InvoiceConstant.SUMMARY, (Object) encodeMap(uploadMap));
        }
        JSONObject jSONObject2 = new JSONObject();
        if (this.b.getUploadMap() != null) {
            jSONObject2.put(InvoiceConstant.SUMMARY, (Object) encodeMap(jSONObject2));
        }
        JSONObject jSONObject3 = new JSONObject();
        Map<String, Map<String, Integer>> uploadMap2 = this.d.getUploadMap();
        if (uploadMap2 != null) {
            jSONObject3.put(InvoiceConstant.SUMMARY, (Object) encodeMap(uploadMap2));
        }
        JSONObject jSONObject4 = new JSONObject();
        Map<String, String> uploadMap3 = this.c.getUploadMap();
        if (uploadMap3 != null) {
            jSONObject4.put(InvoiceConstant.SUMMARY, (Object) encodeMap(uploadMap3));
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put(KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_RESOURCE, (Object) jSONObject);
        jSONObject5.put(KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_RESPONSE_SIZE_ERROR, (Object) jSONObject2);
        jSONObject5.put(KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_TIMEOUT_ERROR, (Object) jSONObject4);
        jSONObject5.put(KEY_GRIVER_MINI_PROGRAM_PERFORMANCE_NETWORK_STATUS_ERROR, (Object) jSONObject3);
        return jSONObject5;
    }
}

package com.iap.ac.android.container.adapter.griver.event;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.bridge.GriverBridgeCallEvent;
import com.alibaba.griver.base.performance.PerformanceAmcsManager;
import com.alibaba.griver.base.performance.PerformanceMonitorFactory;
import com.alibaba.griver.base.performance.jsapi.PerformanceJSAPIMonitor;

/* loaded from: classes3.dex */
public class GriverJSAPICallEventHandler implements GriverBridgeCallEvent {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.griver.api.bridge.GriverBridgeCallEvent
    public void onBridgeCall(String str, JSONObject jSONObject, JSONObject jSONObject2, String str2, String str3) {
        PerformanceJSAPIMonitor performanceJSAPIMonitor;
        if (!PerformanceAmcsManager.getInstance().canMonitorJSAPI() || TextUtils.isEmpty(str3) || (performanceJSAPIMonitor = (PerformanceJSAPIMonitor) PerformanceMonitorFactory.getPerformanceMonitor(str3, PerformanceMonitorFactory.PerformanceType.JSAPI)) == null) {
            return;
        }
        performanceJSAPIMonitor.end(str, str2);
    }

    @Override // com.alibaba.griver.api.bridge.GriverBridgeCallEvent
    public void apiDispatch(String str, String str2, String str3) {
        PerformanceJSAPIMonitor performanceJSAPIMonitor;
        if (!PerformanceAmcsManager.getInstance().canMonitorJSAPI() || TextUtils.isEmpty(str3) || (performanceJSAPIMonitor = (PerformanceJSAPIMonitor) PerformanceMonitorFactory.getPerformanceMonitor(str3, PerformanceMonitorFactory.PerformanceType.JSAPI)) == null) {
            return;
        }
        performanceJSAPIMonitor.begin(str, str2);
    }
}

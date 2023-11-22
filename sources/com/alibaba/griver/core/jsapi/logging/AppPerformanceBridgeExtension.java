package com.alibaba.griver.core.jsapi.logging;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.api.track.Event;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.api.GriverPerformanceStages;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import java.util.Map;

/* loaded from: classes6.dex */
public class AppPerformanceBridgeExtension implements BridgeExtension {

    /* loaded from: classes6.dex */
    public static class PerformanceEntry {
        public String name;
        public long value;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse onAppPerfEvent(@BindingNode(Page.class) Page page, @BindingParam({"state"}) String str, @BindingParam(intDefault = -1, name = {"loadTime"}) int i, @BindingParam(longDefault = -1, name = {"time"}) long j, @BindingParam({"data"}) Map<String, Object> map) {
        return a(page, str, i, j, map);
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse onCubeAppPerfEvent(@BindingNode(Page.class) Page page, @BindingParam({"state"}) String str, @BindingParam(intDefault = -1, name = {"loadTime"}) int i, @BindingParam(longDefault = -1, name = {"time"}) long j, @BindingParam({"data"}) Map<String, Object> map) {
        return a(page, str, i, j, map);
    }

    @ActionFilter("monitorH5Performance")
    public BridgeResponse onBizPerfEvent(@BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext) {
        if (jSONObject == null) {
            return BridgeResponse.SUCCESS;
        }
        JSONArray jSONArray = JSONUtils.getJSONArray(jSONObject, "data", null);
        if (jSONArray == null || jSONArray.size() <= 0) {
            return BridgeResponse.SUCCESS;
        }
        if (page == null) {
            return BridgeResponse.SUCCESS;
        }
        for (int i = 0; i < jSONArray.size(); i++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if ("availableTime".equals(JSONUtils.getString(jSONObject2, "name"))) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = JSONUtils.getLong(jSONObject2, "value");
                    if (j > 0) {
                        elapsedRealtime = j - (System.currentTimeMillis() - SystemClock.elapsedRealtime());
                    }
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(page, TrackId.Stub_AvailableTime);
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(page, TrackId.Stub_Page_Biz_Ready, elapsedRealtime);
                }
            } catch (Throwable th) {
                RVLogger.e("AriverAPI:AppPerformanceBridgeExtension", "monitorH5Performance error!", th);
            }
        }
        return BridgeResponse.SUCCESS;
    }

    private BridgeResponse a(Page page, String str, int i, long j, Map<String, Object> map) {
        App app;
        StringBuilder sb = new StringBuilder();
        sb.append("handleAppPerfEvent: state = ");
        sb.append(str);
        sb.append(" loadTime = ");
        sb.append(j);
        RVLogger.d("AriverAPI:AppPerformanceBridgeExtension", sb.toString());
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        if (j > 0) {
            elapsedRealtime = j - (currentTimeMillis - elapsedRealtime2);
        }
        if (TextUtils.isEmpty(str)) {
            return BridgeResponse.INVALID_PARAM;
        }
        if ("pageLoaded".equals(str)) {
            RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_appxPhase_pageLoaded);
            RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_bizPhase_t2);
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(page, TrackId.Stub_PageLoad);
            page.setPageLoaded();
            if (TextUtils.isEmpty(str)) {
                return BridgeResponse.INVALID_PARAM;
            }
            App app2 = page.getApp();
            if (app2 != null) {
                GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app2.getAppId(), String.valueOf(app2.getStartToken()))).transitToNext("appxPageLoaded", elapsedRealtime);
            }
        }
        if ("renderFrameworkLoaded".equals(str)) {
            RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_appxPhase_renderFrameworkLoaded);
            RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_appxPhase_appLoaded);
        }
        if ("workerFrameworkLoaded".equals(str) && (app = page.getApp()) != null) {
            GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app.getAppId(), String.valueOf(app.getStartToken()))).transitToNext("appxWorkerFrameworkLoaded", elapsedRealtime);
        }
        if ("appLoaded".equals(str)) {
            RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_appxPhase_appLoaded);
            RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_appxPhase_pageLoaded);
            App app3 = page.getApp();
            if (app3 != null) {
                GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app3.getAppId(), String.valueOf(app3.getStartToken()))).transitToNext(GriverPerformanceStages.KEY_APPX_APP_LOADED, elapsedRealtime);
            }
        }
        Event.Stub stub = new Event.Stub(elapsedRealtime);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("js_");
        sb2.append(str);
        Event trackId = stub.setTrackId(sb2.toString());
        if (map != null) {
            for (String str2 : map.keySet()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("js_");
                sb3.append(str2);
                trackId.putAttr(sb3.toString(), map.get(str2));
            }
        }
        ((EventTracker) RVProxy.get(EventTracker.class)).event(page, trackId);
        if (i > 0) {
            Event.Cost cost = new Event.Cost(i);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("js_");
            sb4.append(str);
            sb4.append("_cost");
            ((EventTracker) RVProxy.get(EventTracker.class)).event(page, cost.setTrackId(sb4.toString()));
        }
        return BridgeResponse.SUCCESS;
    }
}

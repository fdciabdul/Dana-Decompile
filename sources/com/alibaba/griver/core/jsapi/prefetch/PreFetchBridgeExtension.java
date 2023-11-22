package com.alibaba.griver.core.jsapi.prefetch;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.core.prefetch.CheckParamStatus;
import com.alibaba.griver.core.prefetch.PrefetchInfo;
import com.alibaba.griver.core.prefetch.PrefetchInner;
import com.alibaba.griver.core.prefetch.PrefetchManager;
import com.alibaba.griver.core.prefetch.PrefetchUtils;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.sendmoney.summary.SummaryActivity;

/* loaded from: classes2.dex */
public class PreFetchBridgeExtension extends SimpleBridgeExtension {
    public static final String DEFAULT_NAME = "main";

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    @AutoCallback
    public void getBackgroundFetchData(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam({"type"}) String str, @BindingParam({"name"}) String str2, @BindingParam({"checkParams"}) JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"params"}) JSONObject jSONObject2) {
        String path;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("status", (Object) 3);
        String appId = app.getAppId();
        if (!PrefetchUtils.isPrefetchAllowed(appId)) {
            bridgeCallback.sendJSONResponse(jSONObject3);
            a("No prefetch access", appId, null, 106);
            a(app, 2);
            return;
        }
        String originalURI = page.getOriginalURI();
        AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
        if (appModel == null) {
            bridgeCallback.sendJSONResponse(jSONObject3);
            return;
        }
        String mainUrl = appModel.getAppInfoModel().getMainUrl();
        if (originalURI.endsWith(mainUrl)) {
            path = mainUrl.split("#")[1];
        } else {
            path = PrefetchManager.getInstance().getPath(appId, originalURI);
        }
        String str3 = TextUtils.isEmpty(str) ? "rpc" : str;
        PrefetchInfo prefetchInfo = PrefetchManager.getInstance().getPrefetchInfo(new PrefetchInner(appId, path, str3));
        if (prefetchInfo == null) {
            bridgeCallback.sendJSONResponse(jSONObject3);
            a("path check fail", appId, null, 102);
            a(app, 3);
            return;
        }
        String str4 = TextUtils.isEmpty(str2) ? "main" : str2;
        JSONObject fetchData = prefetchInfo.fetchData(str4);
        if (fetchData == null) {
            bridgeCallback.sendJSONResponse(jSONObject3);
            a("no fetcher", appId, null, 101);
            a(app, 3);
            return;
        }
        CheckParamStatus checkPara = prefetchInfo.checkPara(jSONObject2, jSONObject, str4);
        if (checkPara == CheckParamStatus.CHECK_PARAM_ERROR) {
            bridgeCallback.sendJSONResponse(jSONObject3);
            a("checkParams check fail", appId, null, 104);
            a(app, 2);
        } else if (checkPara == CheckParamStatus.PARAM_ERROR) {
            bridgeCallback.sendJSONResponse(jSONObject3);
            a("params check fail", appId, null, 105);
            a(app, 2);
        } else {
            if (fetchData.containsKey("success")) {
                jSONObject3.put("fetchedData", (Object) fetchData.getJSONObject("success"));
                jSONObject3.put("status", (Object) 0);
                a("success", appId, prefetchInfo, 0);
                a(app, 0);
                prefetchInfo.setInfo("success", SummaryActivity.CHECKED);
            } else {
                jSONObject3.put("fetchedData", (Object) fetchData.getJSONObject("fail"));
                jSONObject3.put("status", (Object) 2);
                a(app, 2);
                prefetchInfo.setInfo("success", "false");
            }
            jSONObject3.put("timestamp", (Object) Long.valueOf(prefetchInfo.getTime()));
            bridgeCallback.sendJSONResponse(jSONObject3);
            if (TextUtils.isEmpty(str4) || "main".equals(str4)) {
                PrefetchManager.getInstance().removePrefetchInfo(appId, path, str3);
            }
            prefetchInfo.setTimeStamp("get", String.valueOf(SystemClock.elapsedRealtime()));
            prefetchInfo.uploadInfo();
        }
    }

    private void a(String str, String str2, PrefetchInfo prefetchInfo, int i) {
        MonitorMap.Builder needAsynAppType = new MonitorMap.Builder().appId(str2).needAsynAppType(true);
        needAsynAppType.append(TrackerKey.Property.ERROR_MESSAGE_FIREBASE, str);
        needAsynAppType.append(TrackerKey.Property.ERROR_CODE_FIREBASE, String.valueOf(i));
        if (prefetchInfo != null) {
            needAsynAppType.append("get", String.valueOf(prefetchInfo.getTime()));
            needAsynAppType.append("start", String.valueOf(prefetchInfo.getStartTime()));
            needAsynAppType.append("end", String.valueOf(prefetchInfo.getEndTime()));
            needAsynAppType.append("optimize", String.valueOf(prefetchInfo.getOpTime()));
            needAsynAppType.append("APIS", prefetchInfo.getAPIS());
        }
        GriverMonitor.event("prefetch_infos", "GriverAppContainer", needAsynAppType.build());
    }

    private void a(App app, int i) {
        GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app));
        if (app != null) {
            stageMonitor.addParam("prefetch_result", Integer.valueOf(i));
        }
    }
}

package com.alibaba.griver.core.jsapi.logging;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.Record;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alibaba.griver.api.jsapi.diagnostic.RecordReportConstants;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.GriverMonitorAnalyticsConfigManager;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.SystemUtils;
import com.alibaba.griver.base.performance.PerformanceAmcsManager;
import com.alibaba.griver.base.performance.PerformanceMonitorFactory;
import com.alibaba.griver.base.performance.setdata.PerformanceSetDataMonitor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class HandleLoggingActionBridgeExtension implements BridgeExtension {
    private static final int LOG_LIMIT = 1000;
    private static final String LOG_TYPE_BEHAVIOR = "behavior";
    private static final String LOG_TYPE_ERROR = "error";
    private static final String LOG_TYPE_PERFORMANCE = "performance";
    private static final String TAG = RVLogger.makeLogTag("HandleLoggingActionBridgeExtension");
    private int mLogCount;

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

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void handleLoggingAction(@BindingRequest final JSONObject jSONObject, @BindingNode(Page.class) final Page page, @BindingCallback BridgeCallback bridgeCallback) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("handleLoggingAction invoke params : ");
        sb.append(jSONObject);
        RVLogger.d(str, sb.toString());
        if (jSONObject == null || jSONObject.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("invalid params ");
            sb2.append(jSONObject);
            RVLogger.w(str, sb2.toString());
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "params is null"));
            }
        }
        if (jSONObject.containsKey("subType") && "grvOnSetData".equals(jSONObject.getString("subType"))) {
            GriverExecutors.getSingleMonitorThreadExecutor().execute(new Runnable() { // from class: com.alibaba.griver.core.jsapi.logging.HandleLoggingActionBridgeExtension.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    PerformanceSetDataMonitor performanceSetDataMonitor;
                    if (!PerformanceAmcsManager.getInstance().canMonitorSetData() || (jSONObject2 = JSONUtils.getJSONObject(jSONObject, "commonData", null)) == null) {
                        return;
                    }
                    String string = JSONUtils.getString(jSONObject2, "page", "");
                    int i = JSONUtils.getInt(jSONObject2, "viewId", 0);
                    int i2 = JSONUtils.getInt(jSONObject2, "dataLength", 0);
                    if (TextUtils.isEmpty(string) || i2 == 0 || (performanceSetDataMonitor = (PerformanceSetDataMonitor) PerformanceMonitorFactory.getPerformanceMonitor(page.getApp().getAppId(), PerformanceMonitorFactory.PerformanceType.SET_DATA)) == null) {
                        return;
                    }
                    performanceSetDataMonitor.setData(string, i, i2);
                }
            });
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                return;
            }
            return;
        }
        int i = this.mLogCount + 1;
        this.mLogCount = i;
        boolean z = i > 1000;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("handleLoggingAction mLogCount: ");
        sb3.append(this.mLogCount);
        RVLogger.d(str, sb3.toString());
        if (z) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("handleLoggingAction over limit, LogCount : ");
            sb4.append(this.mLogCount);
            RVLogger.d(str, sb4.toString());
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                return;
            }
        }
        doCommonLog(page, jSONObject, bridgeCallback);
    }

    private void doCommonLog(Page page, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        String string = JSONUtils.getString(jSONObject, "type");
        String string2 = JSONUtils.getString(jSONObject, "subType");
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "commonData", new JSONObject());
        JSONObject jSONObject3 = JSONUtils.getJSONObject(jSONObject, "extData", new JSONObject());
        Map jsonToMap = JSONUtils.jsonToMap(jSONObject2, new HashMap());
        Map jsonToMap2 = JSONUtils.jsonToMap(jSONObject3, new HashMap());
        MonitorMap.Builder builder = new MonitorMap.Builder();
        builder.appendAll(GriverMonitor.convertObjectToString(jsonToMap)).appendAll(GriverMonitor.convertObjectToString(jsonToMap2));
        AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
        if (appModel != null) {
            builder.append(GriverMonitorConstants.KEY_MONITOR_SOURCE_SITE, JSONUtils.getString(appModel.getExtendInfos(), "acquirerId"));
        }
        builder.version(page.getApp());
        Map<String, String> build = builder.build();
        if (LOG_TYPE_BEHAVIOR.equals(string)) {
            if (appModel != null) {
                try {
                    JSONObject parseObject = JSONUtils.parseObject(GriverMonitorAnalyticsConfigManager.getAnalyticsMonitorConfig(appModel.getAppId()));
                    if (parseObject != null && TextUtils.equals("test", JSONUtils.getString(parseObject, "configStatus"))) {
                        build.put("debugLogToken", JSONUtils.getString(parseObject, "debugLogToken"));
                    }
                } catch (Exception e) {
                    GriverLogger.w(TAG, "parse analytics monitor failed, do not put debugLogToken", e);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(GriverMonitorConstants.APPX_BEHAVIOR_BIZ_TYPE_PREFIX);
            sb.append(page.getApp().getAppId());
            GriverMonitor.event(string2, sb.toString(), build);
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        } else if ("error".equals(string)) {
            GriverMonitor.error(string2, GriverMonitorConstants.APPX_PERFORMANCE_ERROR_BIZ_TYPE, build);
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
            if (TextUtils.equals(RecordReportConstants.RV_JSFRAMEWORK_ERROR, string2)) {
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_JSAPI_JSFRAMEWORK_ERROR).append("appId", appModel != null ? appModel.getAppId() : "").append(RecordError.KEY_DEVELOP_VERSION, appModel != null ? appModel.getAppVersion() : "").append("page", page.getPageURI()).append(RecordError.KEY_ERROR_STACK, JSONUtils.getString(jSONObject3, RecordError.KEY_ERROR_STACK)).append("errorCode", JSONUtils.getString(jSONObject3, "errorCode")).append("errorType", string).append("errorMsg", JSONUtils.getString(jSONObject3, "msg")).build());
            } else if (TextUtils.equals(ErrId.RV_TYPE_JSAPI_RESULT_ERROR, string2)) {
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_JSAPI_RESULT_ERROR).append("appId", appModel != null ? appModel.getAppId() : "").append(RecordError.KEY_DEVELOP_VERSION, appModel != null ? appModel.getAppVersion() : "").append("page", page.getPageURI()).append(RecordError.KEY_JSAPI_NAME, JSONUtils.getString(jSONObject3, RecordError.KEY_JSAPI_NAME)).append("errorCode", JSONUtils.getString(jSONObject3, "errorCode")).append("errorMsg", JSONUtils.getString(jSONObject3, "msg")).build());
            }
        } else if ("performance".equals(string)) {
            try {
                if (TextUtils.equals(string2, "workerFrameworkLoaded")) {
                    ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(page.getApp(), page.getOriginalURI(), "appxWorkerFrameworkLoaded", SystemUtils.convert2ElapseTime(Long.parseLong(build.get("time"))));
                } else if (TextUtils.equals(string2, "appLoaded")) {
                    ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(page.getApp(), page.getOriginalURI(), PerfId.appxLoaded, SystemUtils.convert2ElapseTime(Long.parseLong(build.get("time"))));
                } else if (TextUtils.equals(string2, "pageLoaded")) {
                    ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(page.getApp(), page.getOriginalURI(), "appxPageLoaded", SystemUtils.convert2ElapseTime(Long.parseLong(build.get("time"))));
                    page.setPageLoaded();
                }
            } catch (Exception e2) {
                GriverLogger.e(TAG, "track performance from appx failed", e2);
            }
            GriverMonitor.performance(string2, GriverMonitorConstants.APPX_PERFORMANCE_ERROR_BIZ_TYPE, build);
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        } else {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "type invalid"));
        }
    }
}

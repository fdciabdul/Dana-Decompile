package com.alibaba.griver.core.extensions;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.point.NativeCallResultPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorManager;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.MonitorUtils;
import com.alibaba.griver.core.common.monitor.KeyJSAPIMonitor;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: classes6.dex */
public class JSAPIMonitorExtension implements NativeCallResultPoint {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f6409a;
    private Random b;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    static {
        ArrayList arrayList = new ArrayList();
        f6409a = arrayList;
        arrayList.add("internalAPI");
        arrayList.add(NXEmbedWebView.POST_MESSAGE_ACTION_TYPE);
        arrayList.add("onAppPerfEvent");
        arrayList.add("getAppInfo");
        arrayList.add("remoteLog");
        arrayList.add("tinyAppConfig");
        arrayList.add("setAppxVersion");
        arrayList.add("getConfig4Appx");
        arrayList.add("registerWorker");
        arrayList.add("handleLoggingAction");
        arrayList.add("NBComponent.render");
        arrayList.add("NBComponent.sendMessage");
        arrayList.add("postWebViewMessage");
        arrayList.add("onCubeAppPerfEvent");
        arrayList.add("monitorH5Performance");
        arrayList.add("loadSubPackage");
        arrayList.add("setInputTextChanged");
        arrayList.add("hideCustomKeyBoard");
        arrayList.add(RDConstant.TINY_DEBUG_CONSOLE);
    }

    @Override // com.alibaba.ariver.engine.api.point.NativeCallResultPoint
    public void onSendBack(NativeCallContext nativeCallContext, JSONObject jSONObject) {
        Page page;
        Page page2;
        MonitorMap.Builder builder = new MonitorMap.Builder();
        String name = nativeCallContext.getName();
        builder.apiName(name);
        if (KeyJSAPIMonitor.isKeyAPI(name)) {
            KeyJSAPIMonitor.monitorKeyAPIResult(nativeCallContext, jSONObject);
        }
        if (!f6409a.contains(name) && a()) {
            if (jSONObject != null) {
                Integer integer = jSONObject.getInteger("error");
                if (integer != null && integer.intValue() != 0) {
                    builder.append("status", "error").code(String.valueOf(integer)).message(jSONObject.getString("errorMessage"));
                } else {
                    builder.append("status", "success");
                }
            } else {
                builder.append("status", "success");
            }
            if ((nativeCallContext.getNode() instanceof Page) && (page2 = (Page) nativeCallContext.getNode()) != null && page2.getApp() != null) {
                App app = page2.getApp();
                builder.appId(app.getAppId()).version(app).needAsynAppType(true).append("sourceInfo", MonitorUtils.getSourceInfoFromStartupParams(app.getStartParams()));
            }
            Map<String, String> build = builder.build();
            if ("error".equals(build.get("status"))) {
                GriverMonitor.event(GriverMonitorConstants.EVENT_API_CALL, "GriverAppContainer", build);
                if (!(nativeCallContext.getNode() instanceof Page) || (page = (Page) nativeCallContext.getNode()) == null || page.getApp() == null) {
                    return;
                }
                App app2 = page.getApp();
                GriverAllRecordsExtension griverAllRecordsExtension = (GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class);
                if (griverAllRecordsExtension.canUseRecords(app2)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(RecordError.KEY_JSAPI_NAME, (Object) name);
                    if (jSONObject != null) {
                        jSONObject2.put("errorCode", (Object) jSONObject.getInteger("error"));
                        jSONObject2.put("errorMessage", (Object) jSONObject.getString("errorMessage"));
                    }
                    griverAllRecordsExtension.reportJSAPIError(app2, jSONObject2);
                }
            }
        }
    }

    private boolean a() {
        if (MonitorManager.jsapiEnabled()) {
            return true;
        }
        GriverLogger.d("JSAPIMonitorExtension", "jsapi monitor is not enable");
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        this.b = new Random(System.currentTimeMillis());
    }
}

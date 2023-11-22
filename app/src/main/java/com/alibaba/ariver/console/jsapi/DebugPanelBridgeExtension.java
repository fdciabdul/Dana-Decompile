package com.alibaba.ariver.console.jsapi;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.console.DebugConsolePoint;
import com.alibaba.ariver.console.ShowToggleButtonPoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public class DebugPanelBridgeExtension implements BridgeExtension {
    private static final String TAG = "AriverRemoteDebug:DebugPanelBridgeExtension";
    private DebugConsolePoint mConsolePoint;

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

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse shouldShowConsoleBtn(@BindingNode(App.class) App app, @BindingParam({"showBtn"}) boolean z) {
        if (!app.isTinyApp()) {
            return BridgeResponse.newError(1, "only tiny app can show console view");
        }
        DebugConsolePoint point = getPoint(app);
        if (point == null) {
            return BridgeResponse.NATIVE_NODE_NULL;
        }
        point.showToggleButton(z);
        ShowToggleButtonPoint showToggleButtonPoint = (ShowToggleButtonPoint) ExtensionPoint.as(ShowToggleButtonPoint.class).node(app).create();
        if (showToggleButtonPoint != null) {
            showToggleButtonPoint.showToggleButton(z);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse toggleDebugPanel(@BindingNode(App.class) App app) {
        long j = BundleUtils.getLong(app.getStartParams(), RDConstant.KEY_CONSOLE_HOST_APP_START_TOKEN, -1L);
        if (j < 0) {
            return BridgeResponse.INVALID_PARAM;
        }
        App findAppByToken = ((AppManager) RVProxy.get(AppManager.class)).findAppByToken(j);
        if (findAppByToken == null) {
            return BridgeResponse.INVALID_PARAM;
        }
        DebugConsolePoint point = getPoint(findAppByToken);
        if (point == null) {
            return BridgeResponse.NATIVE_NODE_NULL;
        }
        point.toggleConsoleView();
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showToggleButton(@BindingNode(App.class) App app) {
        if (!app.isTinyApp()) {
            return BridgeResponse.newError(1, "only tiny app can show console view");
        }
        DebugConsolePoint point = getPoint(app);
        if (point == null) {
            return BridgeResponse.NATIVE_NODE_NULL;
        }
        point.showToggleButton(true);
        ShowToggleButtonPoint showToggleButtonPoint = (ShowToggleButtonPoint) ExtensionPoint.as(ShowToggleButtonPoint.class).node(app).create();
        if (showToggleButtonPoint != null) {
            showToggleButtonPoint.showToggleButton(true);
        }
        return BridgeResponse.SUCCESS;
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse sendMsgFromVConsoleToAppx(@BindingNode(App.class) App app, @BindingParam({"data"}) String str) {
        try {
            long j = BundleUtils.getLong(app.getStartParams(), RDConstant.KEY_CONSOLE_HOST_APP_START_TOKEN, -1L);
            if (j < 0) {
                RVLogger.d(TAG, "sendMessageFromVConsoleToAppx hostStartToken is empty");
                return BridgeResponse.INVALID_PARAM;
            }
            App findAppByToken = ((AppManager) RVProxy.get(AppManager.class)).findAppByToken(j);
            if (findAppByToken == null) {
                RVLogger.d(TAG, "sendMessageFromVConsoleToAppx appByToken is null");
                return BridgeResponse.INVALID_PARAM;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content", (Object) str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            Page activePage = findAppByToken.getActivePage();
            if (activePage == null) {
                RVLogger.d(TAG, "sendMessageFromVConsoleToAppx activePage is null");
                return BridgeResponse.INVALID_PARAM;
            }
            EngineUtils.sendToRender(activePage.getRender(), RDConstant.ON_MESSAGE_FROM_VCONSOLE, jSONObject2, null);
            return BridgeResponse.SUCCESS;
        } catch (Exception e) {
            RVLogger.e(TAG, "exception detail: ", e);
            return BridgeResponse.UNKNOWN_ERROR;
        }
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse tinyDebugConsole(@BindingNode(App.class) App app, @BindingRequest JSONObject jSONObject) {
        if (!app.isTinyApp()) {
            return BridgeResponse.newError(1, "only tiny app can show console view");
        }
        DebugConsolePoint point = getPoint(app);
        if (point == null) {
            return BridgeResponse.NATIVE_NODE_NULL;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        point.sendMsgToConsoleView(jSONObject2);
        return BridgeResponse.SUCCESS;
    }

    private DebugConsolePoint getPoint(App app) {
        if (app == null) {
            return null;
        }
        if (this.mConsolePoint == null) {
            this.mConsolePoint = (DebugConsolePoint) ExtensionPoint.as(DebugConsolePoint.class).node(app).create();
        }
        return this.mConsolePoint;
    }
}

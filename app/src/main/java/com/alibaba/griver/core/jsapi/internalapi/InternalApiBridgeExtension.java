package com.alibaba.griver.core.jsapi.internalapi;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingId;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.iap.ac.android.acs.plugin.utils.Constants;

/* loaded from: classes6.dex */
public class InternalApiBridgeExtension implements BridgeExtension {
    public static final String[] API_INIT_LIST = {"setOptionMenu", "showOptionMenu", "inputFocus4Android", "getConfig", "getLifestyleInfo", "addFollow", "startApp", "requestTemplateData", "getAppType", "onAppPerfEvent", "getShareImageUrl", "hideCustomKeyBoard", "resetNativeKeyBoardInput", "updateNativeKeyBoardInput", "getStartupParams", "getConfig4Appx", RDConstant.TINY_DEBUG_CONSOLE, "add2Favorite", "cancelKeepFavorite", "shareTinyAppMsg", "setAppxVersion", "showBackHome", Constants.JS_API_GET_COMPONENT_AUTH, "getBusinessAuth", "getAuthorize", "appxrpc", "launchApp", "goBackThirdPartApp", TinyAppLogUtil.TINY_APP_STANDARD_LOG, "shareToAlipayContact", "startMiniService", TinyAppLogUtil.TINY_APP_STANDARD_LOG, "addPkgRes", "saveSnapshot", "executeDefaultBehavior", "initialTraceDebug", "postMethodTrace", "handleLoggingAction", "makePhoneCall", "getExtConfig", "healthKitRequest", "resizeNativeKeyBoardInput", "showBackHome", "rpc", "getClientConfig", "cdpFeedback", "getCdpSpaceInfo", "shouldShowAddComponent", "questionaireApp2HomeShow", "addNotifyListener", "closeAddComponentAction", "addToHomeWithComponent", "getSharedData", "setSharedData", "makePhoneCall", "disablePageMonitor", "handleLoggingAction", "reportTinyData", "antUIGetCascadePicker", "loadPlugin", "exitTinyApp", "getUserInfo"};
    private static final String INTERNAL_API_ID_PREFIX = "InternalAPI_";
    private static final String TAG = "AriverAPI:InternalApiBridgeExtension";

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

    public boolean hasPermission(String str) {
        for (String str2 : API_INIT_LIST) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    @ActionFilter
    public void internalAPI(@BindingRequest JSONObject jSONObject, @BindingCallback final BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page, @BindingApiContext ApiContext apiContext, @BindingId String str) {
        if (page == null) {
            RVLogger.d(TAG, "page is null");
            return;
        }
        NativeCallContext.Builder builder = new NativeCallContext.Builder();
        String string = JSONUtils.getString(jSONObject, "method", "");
        if (!hasPermission(string)) {
            StringBuilder sb = new StringBuilder();
            sb.append("not allowed to use internalAPI: ");
            sb.append(string);
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, sb.toString()));
            return;
        }
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "param", new JSONObject());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("internalAPI...method: ");
        sb2.append(string);
        sb2.append(" params: ");
        sb2.append(jSONObject2);
        GriverLogger.d(TAG, sb2.toString());
        NativeCallContext.Builder params = builder.node(page).name(string).params(jSONObject2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(INTERNAL_API_ID_PREFIX);
        sb3.append(NativeCallContext.generateUniqueId());
        apiContext.callBridgeApi(params.id(sb3.toString()).render(page.getRender()).build(), new SendToNativeCallback() { // from class: com.alibaba.griver.core.jsapi.internalapi.InternalApiBridgeExtension.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject3, boolean z) {
                bridgeCallback.sendJSONResponse(jSONObject3, z);
            }
        }, false);
    }
}

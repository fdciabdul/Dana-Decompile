package com.alibaba.griver.device.jsapi.auth;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.ui.auth.GriverOpenAuthExtension;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.utils.APIContextUtils;
import com.alibaba.griver.device.proxy.GriverOpenSettingExtension;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ProgramSettingExtension implements BridgeExtension {
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

    private boolean a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "miniservice".equals(BundleUtils.getString(bundle, "tinySource"));
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getSetting(@BindingParam({"platform"}) String str, @BindingNode(App.class) final App app, @BindingCallback final BridgeCallback bridgeCallback) {
        String string;
        final String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId();
        RVLogger.d("ProgramSettingExtension", "[getSetting] enter.");
        if (TextUtils.isEmpty(userId)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            RVLogger.d("ProgramSettingExtension", "[getSetting] userId is null");
            return;
        }
        if (a(app.getStartParams())) {
            string = BundleUtils.getString(app.getStartParams(), RVConstants.EXTRA_PARENT_APP_ID);
        } else {
            string = BundleUtils.getString(app.getStartParams(), "appId");
        }
        final String str2 = string;
        if (TextUtils.isEmpty(str2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            RVLogger.d("ProgramSettingExtension", "[getSetting] appId is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[getSetting] userId = ");
        sb.append(userId);
        sb.append(", appId = ");
        sb.append(str2);
        RVLogger.d("ProgramSettingExtension", sb.toString());
        ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alibaba.griver.device.jsapi.auth.ProgramSettingExtension.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                Map a2 = ProgramSettingExtension.this.a(userId, str2, app.getActivePage());
                if (a2 != null && a2.size() > 0) {
                    hashMap.putAll(a2);
                }
                Map<String, Boolean> openAuthStatus = ((GriverOpenAuthExtension) RVProxy.get(GriverOpenAuthExtension.class)).getOpenAuthStatus(str2, APIContextUtils.createApiContext(app.getActivePage()));
                if (openAuthStatus != null && openAuthStatus.size() > 0) {
                    hashMap.putAll(openAuthStatus);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("authSetting", (Object) JSONObject.parseObject(JSON.toJSONString(hashMap)));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[getSetting] result= ");
                sb2.append(jSONObject.toString());
                RVLogger.d("ProgramSettingExtension", sb2.toString());
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Boolean> a(String str, String str2, Page page) {
        HashMap hashMap = new HashMap();
        AuthenticationProxy authenticationProxy = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
        if (authenticationProxy == null) {
            RVLogger.d("ProgramSettingExtension", "getSetting, service is null");
            return hashMap;
        }
        return authenticationProxy.getAllPermissions(str, str2, (AppModel) null, page);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void openSetting(@BindingParam({"platform"}) final String str, @BindingNode(App.class) final App app, @BindingCallback final BridgeCallback bridgeCallback) {
        if (app != null) {
            ((GriverOpenSettingExtension) RVProxy.get(GriverOpenSettingExtension.class)).showOpenSettingView(app.getActivePage().getPageContext().getActivity(), a(GriverAccount.getUserId(), app.getAppId(), app.getActivePage()), (AppModel) app.getData(AppModel.class), new GriverOpenSettingExtension.SettingChangeCallback() { // from class: com.alibaba.griver.device.jsapi.auth.ProgramSettingExtension.2
                @Override // com.alibaba.griver.device.proxy.GriverOpenSettingExtension.SettingChangeCallback
                public void onSettingChange(Map<String, Boolean> map) {
                    ProgramSettingExtension.this.getSetting(str, app, bridgeCallback);
                }
            });
        } else if (bridgeCallback != null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
    }
}

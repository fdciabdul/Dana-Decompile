package com.iap.ac.android.acs.plugin.downgrade.jsapi.interceptor;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.amcs.JSAPICompatibilityConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.amcs.NotFoundJSAPIConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.acs.plugin.downgrade.utils.DowngradeJSAPIInterceptorHandler;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.utils.AcBizUtils;
import com.iap.ac.android.common.container.interceptor.BridgeCallback;
import com.iap.ac.android.common.container.interceptor.NotFoundJSAPIInterceptor;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IAPNotFoundJSAPIInterceptor implements NotFoundJSAPIInterceptor {
    public static final String DOWNGRADE_TYPE_NOT_FOUND_JSAPI = "notFoundJSAPI";
    public static final String FILENAME_NOT_FOUND_JSAPI_MAP;
    public static final String TAG = ApiDowngradeUtils.logTag("IAPNotFoundJSAPIInterceptor");

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiDowngradeUtils.dirInAssets());
        sb.append("acs_not_found_jsapi_downgrade_config.json");
        FILENAME_NOT_FOUND_JSAPI_MAP = sb.toString();
    }

    private IAPConnectPluginCallback convertCallback(final BridgeCallback bridgeCallback) {
        return new IAPConnectPluginCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.jsapi.interceptor.IAPNotFoundJSAPIInterceptor.1
            @Override // com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback
            public void onResult(JSONObject jSONObject) {
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
    }

    private IAPConnectPluginContext convertContext(NotFoundJSAPIInterceptor.NotFoundJSAPIContext notFoundJSAPIContext) {
        IAPConnectPluginContext iAPConnectPluginContext = new IAPConnectPluginContext(notFoundJSAPIContext.context);
        iAPConnectPluginContext.jsParameters = notFoundJSAPIContext.jsParameters;
        iAPConnectPluginContext.miniProgramAppID = notFoundJSAPIContext.miniProgramAppID;
        iAPConnectPluginContext.miniProgramName = notFoundJSAPIContext.miniProgramName;
        iAPConnectPluginContext.miniProgramPageURL = notFoundJSAPIContext.miniProgramPageURL;
        iAPConnectPluginContext.acParams = notFoundJSAPIContext.acParams;
        iAPConnectPluginContext.isMiniProgram = notFoundJSAPIContext.isMiniProgram;
        iAPConnectPluginContext.sourceSite = notFoundJSAPIContext.sourceSite;
        iAPConnectPluginContext.setActivity(notFoundJSAPIContext.activity);
        iAPConnectPluginContext.startParams = notFoundJSAPIContext.startParams;
        return iAPConnectPluginContext;
    }

    @Override // com.iap.ac.android.common.container.interceptor.NotFoundJSAPIInterceptor
    public boolean handleNotFoundJSAPI(NotFoundJSAPIInterceptor.NotFoundJSAPIContext notFoundJSAPIContext, BridgeCallback bridgeCallback) {
        ConfigCenter.INSTANCE.refreshConfigs();
        IAPConnectPluginContext convertContext = convertContext(notFoundJSAPIContext);
        IAPConnectPluginCallback convertCallback = convertCallback(bridgeCallback);
        if (!JSAPICompatibilityConfigManager.getInstance().isJSAPICompatibilityEnabled()) {
            ACLog.d(TAG, "IAPNotFoundJSAPIInterceptor#handleNotFoundJSAPI cancelled, for jsapi downgrade is not enabled");
            return false;
        }
        String channel = AcBizUtils.getChannel(convertContext.acParams, "not found jsApi");
        if (TextUtils.isEmpty(channel)) {
            if (!AcBizUtils.isAcBizMiniProgram(convertContext.miniProgramAppID, convertContext.sourceSite, convertContext.newSourceSite) && JSAPICompatibilityConfigManager.getInstance().isOnlyInterceptAPlusMiniProgramJSAPI()) {
                ACLog.d(TAG, String.format("IAPNotFoundJSAPIInterceptor#handleNotFoundJSAPI cancelled, for appId: %s is not A+ mp", convertContext.miniProgramAppID));
                return false;
            }
        } else if (!"B15".equals(channel)) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("IAPConnectInterceptor#willHandleJSAPI, channel");
            sb.append(channel);
            ACLog.d(str, sb.toString());
            return false;
        }
        JSONObject notFoundJSAPIConfig = NotFoundJSAPIConfigManager.getInstance().getNotFoundJSAPIConfig();
        String str2 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleNotFoundJSAPI() get the config from server, json: ");
        sb2.append(notFoundJSAPIConfig);
        ACLog.d(str2, sb2.toString());
        return DowngradeJSAPIInterceptorHandler.handleJSAPI(convertContext, DOWNGRADE_TYPE_NOT_FOUND_JSAPI, notFoundJSAPIConfig, notFoundJSAPIContext.jsapiName, FILENAME_NOT_FOUND_JSAPI_MAP, convertCallback);
    }
}

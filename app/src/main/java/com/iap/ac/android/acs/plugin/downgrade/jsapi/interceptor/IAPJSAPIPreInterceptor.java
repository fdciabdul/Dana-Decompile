package com.iap.ac.android.acs.plugin.downgrade.jsapi.interceptor;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.amcs.ImplementedJSAPIConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.amcs.JSAPICompatibilityConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.acs.plugin.downgrade.utils.DowngradeJSAPIInterceptorHandler;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.utils.AcBizUtils;
import com.iap.ac.android.common.container.interceptor.BridgeCallback;
import com.iap.ac.android.common.container.interceptor.BridgeJSAPIPreInterceptor;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IAPJSAPIPreInterceptor implements BridgeJSAPIPreInterceptor {
    public static final String DOWNGRADE_TYPE_IMPLEMENTED_JSAPI = "implementedJSAPI";
    public static final String FILENAME_IMPLEMENTED_JSAPI_DOWNGRADE_MAP;
    public static final String TAG = ApiDowngradeUtils.logTag("IAPJSAPIPreInterceptor");

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiDowngradeUtils.dirInAssets());
        sb.append("acs_implemented_jsapi_intercept_config.json");
        FILENAME_IMPLEMENTED_JSAPI_DOWNGRADE_MAP = sb.toString();
    }

    private IAPConnectPluginCallback convertCallback(final BridgeCallback bridgeCallback) {
        return new IAPConnectPluginCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.jsapi.interceptor.IAPJSAPIPreInterceptor.1
            @Override // com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback
            public void onResult(JSONObject jSONObject) {
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        };
    }

    private IAPConnectPluginContext convertContext(BridgeJSAPIPreInterceptor.JSAPIPreInterceptContext jSAPIPreInterceptContext) {
        IAPConnectPluginContext iAPConnectPluginContext = new IAPConnectPluginContext(jSAPIPreInterceptContext.context);
        iAPConnectPluginContext.jsParameters = jSAPIPreInterceptContext.jsParameters;
        iAPConnectPluginContext.miniProgramAppID = jSAPIPreInterceptContext.miniProgramAppID;
        iAPConnectPluginContext.miniProgramName = jSAPIPreInterceptContext.miniProgramName;
        iAPConnectPluginContext.miniProgramPageURL = jSAPIPreInterceptContext.miniProgramPageURL;
        iAPConnectPluginContext.acParams = jSAPIPreInterceptContext.acParams;
        iAPConnectPluginContext.isMiniProgram = jSAPIPreInterceptContext.isMiniProgram;
        iAPConnectPluginContext.sourceSite = jSAPIPreInterceptContext.sourceSite;
        iAPConnectPluginContext.newSourceSite = jSAPIPreInterceptContext.newSourceSite;
        iAPConnectPluginContext.acquireSite = jSAPIPreInterceptContext.acquireSite;
        iAPConnectPluginContext.setActivity(jSAPIPreInterceptContext.activity);
        iAPConnectPluginContext.startParams = jSAPIPreInterceptContext.startParams;
        return iAPConnectPluginContext;
    }

    @Override // com.iap.ac.android.common.container.interceptor.BridgeJSAPIPreInterceptor
    public boolean handleJSAPIPreIntercept(BridgeJSAPIPreInterceptor.JSAPIPreInterceptContext jSAPIPreInterceptContext, BridgeCallback bridgeCallback) {
        JSONObject implementedJSAPIConfig;
        ConfigCenter.INSTANCE.refreshConfigs();
        IAPConnectPluginContext convertContext = convertContext(jSAPIPreInterceptContext);
        IAPConnectPluginCallback convertCallback = convertCallback(bridgeCallback);
        if (!JSAPICompatibilityConfigManager.getInstance().isJSAPICompatibilityEnabled()) {
            ACLog.d(TAG, "IAPJSAPIPreInterceptor#handleJSAPIPreIntercept cancelled, for jsapi downgrade is not enabled");
            return false;
        }
        String str = jSAPIPreInterceptContext.jsapiName;
        String channel = AcBizUtils.getChannel(convertContext.acParams, str);
        if (TextUtils.isEmpty(channel)) {
            if (!AcBizUtils.isAcBizMiniProgram(convertContext.miniProgramAppID, convertContext.sourceSite, convertContext.newSourceSite) && JSAPICompatibilityConfigManager.getInstance().isOnlyInterceptAPlusMiniProgramJSAPI()) {
                ACLog.d(TAG, String.format("IAPJSAPIPreInterceptor#handleJSAPIPreIntercept cancelled, for appId: %s is not A+ mp", convertContext.miniProgramAppID));
                return false;
            }
        } else if (!"B15".equals(channel)) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("IAPJSAPIPreInterceptor#handleJSAPIPreIntercept is ");
            sb.append(channel);
            ACLog.d(str2, sb.toString());
            return false;
        }
        if (ApiDowngradeUtils.isScenePreview(convertContext.startParams) && JSAPICompatibilityConfigManager.getInstance().isConfigPreviewEnabled()) {
            implementedJSAPIConfig = ImplementedJSAPIConfigManager.getInstance().getImplementedJSAPIPreviewConfig(ApiDowngradeUtils.findValueFromBundle(convertContext.startParams, ApiDowngradeUtils.KEY_PREVIEW_ID));
            ACLog.d(TAG, "IAPJSAPIPreInterceptor#handleJSAPIPreIntercept, in config preview scene.");
        } else {
            implementedJSAPIConfig = ImplementedJSAPIConfigManager.getInstance().getImplementedJSAPIConfig();
        }
        JSONObject jSONObject = implementedJSAPIConfig;
        String str3 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("IAPJSAPIPreInterceptor#handleJSAPIPreIntercept, the jsapi interceptor config:");
        sb2.append(jSONObject);
        ACLog.d(str3, sb2.toString());
        if (DowngradeJSAPIInterceptorHandler.handleJSAPI(convertContext, DOWNGRADE_TYPE_IMPLEMENTED_JSAPI, jSONObject, str, FILENAME_IMPLEMENTED_JSAPI_DOWNGRADE_MAP, convertCallback)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("IAPJSAPIPreInterceptor#handleJSAPIPreIntercept, ");
            sb3.append(str);
            sb3.append(" is intercepted");
            ACLog.d(str3, sb3.toString());
            return true;
        }
        return false;
    }
}

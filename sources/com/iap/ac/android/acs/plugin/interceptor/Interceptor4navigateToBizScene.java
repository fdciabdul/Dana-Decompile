package com.iap.ac.android.acs.plugin.interceptor;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.amcs.JSAPICompatibilityConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.downgrade.router.BizSceneNavigateManager;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeLogger;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4navigateToBizScene extends BaseInterceptor {
    public static final String CONFIG_KEY_AC_SCENE_CODE_ALLOWED_LIST = "ac_scene_code_allowed_list";
    public static final String ERROR_CODE_NOT_ALLOWED = "4";
    public static final String ERROR_MESSAGE_NOT_ALLOWED = "Not allowed to navigate to %s";
    public static final String LOGGER_KEY_DENIED = "denied";
    public static final String LOGGER_KEY_EMPTY_CONFIG = "emptyConfig";
    public static final String LOGGER_KEY_FROM_APPID = "fromAppId";
    public static final String LOGGER_KEY_FROM_DEFAULT = "fromDefault";
    public static final String PARAM_SCENE_CODE = "sceneCode";
    public static final String TAG = "IAPConnectPlugin";

    private boolean isAllowedNavigateToScene(String str, String str2) {
        JSONObject jSONObject = (JSONObject) ConfigCenter.INSTANCE.getKeyOrDefault(CONFIG_KEY_AC_SCENE_CODE_ALLOWED_LIST, new JSONObject());
        if (jSONObject != null && jSONObject.length() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Interceptor4navigateToBizScene#allowNavigateToScene start,appId: ");
            sb.append(str);
            sb.append(",sceneCode: ");
            sb.append(str2);
            sb.append(",config: ");
            sb.append(jSONObject);
            ACLog.d("IAPConnectPlugin", sb.toString());
            if (isSceneCodeInConfig(str2, jSONObject.optJSONArray(str))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Interceptor4navigateToBizScene#allowNavigateToScene, permission is allowed for matched in appId: ");
                sb2.append(str);
                ACLog.d("IAPConnectPlugin", sb2.toString());
                logAllowedType(str, str2, "fromAppId", jSONObject.toString());
                return true;
            }
            boolean isSceneCodeInConfig = isSceneCodeInConfig(str2, jSONObject.optJSONArray("default"));
            logAllowedType(str, str2, isSceneCodeInConfig ? "fromDefault" : "denied", jSONObject.toString());
            return isSceneCodeInConfig;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Interceptor4navigateToBizScene#allowNavigateToScene, ");
        sb3.append("the allowed list config is not configured or is empty.");
        ACLog.d("IAPConnectPlugin", sb3.toString());
        logAllowedType(str, str2, LOGGER_KEY_EMPTY_CONFIG, "the allowed list config is not configured or is empty.");
        return false;
    }

    private boolean isSceneCodeInConfig(String str, JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (TextUtils.equals(jSONArray.optString(i), str)) {
                return true;
            }
        }
        return false;
    }

    private void logAllowedType(String str, String str2, String str3, String str4) {
        ApiDowngradeLogger.newLoggerInScene(ApiDowngradeLogger.BL_ACS_NAVIGATE_SCENE_CODE_ALLOWED_LIST_CHECK, str, str2).addParams(ApiDowngradeLogger.EXT_KEY_ALLOWED_TYPE, str3).addParams(ApiDowngradeLogger.EXT_KEY_EXT_PARAMS, str4).event();
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (!JSAPICompatibilityConfigManager.getInstance().isJSAPICompatibilityEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Interceptor4navigateToBizScene#handle, ");
            sb.append("cancel apidowngrade, for it is not enabled");
            ACLog.d("IAPConnectPlugin", sb.toString());
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError(Constants.JS_API_NAVIGATE_TO_BIZ_SCENE, "cancel apidowngrade, for it is not enabled"));
            return;
        }
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Interceptor4navigateToBizScene#handle, ");
            sb2.append("jsParameters is null");
            ACLog.e("IAPConnectPlugin", sb2.toString());
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError(Constants.JS_API_NAVIGATE_TO_BIZ_SCENE, "jsParameters is null"));
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Interceptor4navigateToBizScene#handle, start, jsParam: ");
        sb3.append(jSONObject);
        ACLog.d("IAPConnectPlugin", sb3.toString());
        String optString = jSONObject.optString("sceneCode");
        if (TextUtils.isEmpty(optString)) {
            ACLog.e("IAPConnectPlugin", "Interceptor4navigateToBizScene#handle, sceneCode is empty");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError(Constants.JS_API_NAVIGATE_TO_BIZ_SCENE, "sceneCode is empty"));
        } else if (!isAllowedNavigateToScene(iAPConnectPluginContext.miniProgramAppID, optString)) {
            String format = String.format(ERROR_MESSAGE_NOT_ALLOWED, optString);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Interceptor4navigateToBizScene#handle, ");
            sb4.append(format);
            ACLog.e("IAPConnectPlugin", sb4.toString());
            iAPConnectPluginCallback.onResult(CallbackUtil.getError(Constants.JS_API_NAVIGATE_TO_BIZ_SCENE, "4", format));
        } else if (UIUtils.isActivityDisabled(iAPConnectPluginContext.getActivity())) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Interceptor4navigateToBizScene#handle, ");
            sb5.append("activity is null or disabled");
            ACLog.e("IAPConnectPlugin", sb5.toString());
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError(Constants.JS_API_NAVIGATE_TO_BIZ_SCENE, "activity is null or disabled"));
        } else {
            ACLog.d("IAPConnectPlugin", String.format("before BizSceneNavigateManager#navigate, sceneCode: %s, jsParameters: %s", optString, jSONObject));
            BizSceneNavigateManager.getInstance().navigate(iAPConnectPluginContext, optString, new IActionHandlerCallback() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4navigateToBizScene.1
                @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback
                public void onHandleFailure(JSONObject jSONObject2) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Interceptor4navigateToBizScene#handle, onHandleFailure, result: ");
                    sb6.append(jSONObject2);
                    ACLog.d("IAPConnectPlugin", sb6.toString());
                    iAPConnectPluginCallback.onResult(jSONObject2);
                }

                @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback
                public void onHandleSuccess(JSONObject jSONObject2) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Interceptor4navigateToBizScene#handle, onHandleSuccess, result: ");
                    sb6.append(jSONObject2);
                    ACLog.d("IAPConnectPlugin", sb6.toString());
                    iAPConnectPluginCallback.onResult(jSONObject2);
                }
            });
        }
    }
}

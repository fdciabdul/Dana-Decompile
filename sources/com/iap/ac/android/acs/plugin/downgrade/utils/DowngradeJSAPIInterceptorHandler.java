package com.iap.ac.android.acs.plugin.downgrade.utils;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.ActionExecutor;
import com.iap.ac.android.acs.plugin.downgrade.amcs.JSAPICompatibilityConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class DowngradeJSAPIInterceptorHandler {
    public static final String TAG = ApiDowngradeUtils.logTag("DowngradeJSAPIInterceptorHandler");

    public static boolean handleJSAPI(IAPConnectPluginContext iAPConnectPluginContext, String str, JSONObject jSONObject, String str2, String str3, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject readJSONFromAssets;
        JSONObject optJSONObject;
        String str4 = TAG;
        ACLog.d(str4, String.format("handleJSAPI start, downgradeType = %s, jsapi = %s, appId = %s, params = %s", str, str2, iAPConnectPluginContext.miniProgramAppID, iAPConnectPluginContext.jsParameters));
        StringBuilder sb = new StringBuilder();
        sb.append("get config from server: ");
        sb.append(jSONObject);
        ACLog.d(str4, sb.toString());
        if (!JSAPICompatibilityConfigManager.getInstance().isJSAPICompatibilityEnabled()) {
            ACLog.d(str4, "handle() handle cancelled, for apidowngrade is not enabled");
            return false;
        } else if (UIUtils.isActivityDisabled(iAPConnectPluginContext.getActivity())) {
            ACLog.e(str4, "handle error, activity is null or disabled");
            return false;
        } else {
            String str5 = iAPConnectPluginContext.miniProgramAppID;
            if (TextUtils.isEmpty(str5)) {
                ACLog.e(str4, "handle error, appId is empty ,it may be a H5 page.");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                ACLog.e(str4, "handle error, jsapiName is empty");
                ApiDowngradeLogger.newExceptionLogger(ApiDowngradeLogger.EVENT_JSAPI_DOWNGRADE_AND_INTERCEPT_INVALID, str5).addParams("errorMessage", "handle error, jsapiName is empty").addParams("apiName", str2).addParams(ApiDowngradeLogger.EXT_KEY_DOWNGRADE_TYPE, str).event();
                return false;
            } else {
                if (jSONObject != null) {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject(iAPConnectPluginContext.miniProgramAppID);
                    r0 = optJSONObject2 != null ? optJSONObject2.optJSONObject(str2) : null;
                    if (r0 == null && (optJSONObject = jSONObject.optJSONObject("default")) != null) {
                        r0 = optJSONObject.optJSONObject(str2);
                    }
                }
                if (r0 == null && (readJSONFromAssets = ApiDowngradeUtils.readJSONFromAssets(iAPConnectPluginContext.getContext(), str3)) != null) {
                    r0 = readJSONFromAssets.optJSONObject(str2);
                }
                if (r0 == null) {
                    return false;
                }
                String optString = r0.optString("actionType");
                ApiDowngradeLogger.newBehaviorLogger(ApiDowngradeLogger.EVENT_JSAPI_DOWNGRADE_AND_INTERCEPT_HANDLED, str5).addParams("actionType", optString).addParams("apiName", str2).addParams(ApiDowngradeLogger.EXT_KEY_DOWNGRADE_TYPE, str).event();
                if (!ActionExecutor.getInstance().handleAction(iAPConnectPluginContext, r0, new IActionHandlerCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.utils.DowngradeJSAPIInterceptorHandler.1
                    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback
                    public final void onHandleFailure(JSONObject jSONObject2) {
                        IAPConnectPluginCallback.this.onResult(jSONObject2);
                    }

                    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback
                    public final void onHandleSuccess(JSONObject jSONObject2) {
                        IAPConnectPluginCallback.this.onResult(jSONObject2);
                    }
                })) {
                    ApiDowngradeLogger.newBehaviorLogger(ApiDowngradeLogger.EVENT_JSAPI_DOWNGRADE_AND_INTERCEPT_HANDLED_FAIL, str5).addParams("actionType", optString).addParams("apiName", str2).addParams(ApiDowngradeLogger.EXT_KEY_DOWNGRADE_TYPE, str).addParams("errorMessage", "ActionExecutor#handleAction returns false.").event();
                }
                return true;
            }
        }
    }
}

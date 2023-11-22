package com.iap.ac.android.acs.plugin.interceptor;

import android.net.Uri;
import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.ActionExecutor;
import com.iap.ac.android.acs.plugin.downgrade.amcs.JSAPICompatibilityConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.amcs.StartAppConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeLogger;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.acs.plugin.utils.AclAPIContextUtils;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4startApp extends BaseInterceptor {
    public static final String ERROR_CODE = "11";
    public static final String ERROR_MESSAGE = "Start app fail";
    public static final String PARAM_APPID = "appId";
    public static final String PARAM_SCHEME = "scheme";
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4startApp#handle, jsParameters is null");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError("startApp", "jsParameters is null"));
            return;
        }
        String optString = jSONObject.optString("scheme");
        if (!TextUtils.isEmpty(optString)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Interceptor4startApp#handle, start app, scheme: ");
            sb.append(optString);
            ACLog.d("IAPConnectPlugin", sb.toString());
            boolean openScheme = SPIManager.getInstance().openScheme(Uri.parse(optString), AclAPIContextUtils.createAclAPIContext(iAPConnectPluginContext));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Interceptor4startApp#handle, start app result: ");
            sb2.append(openScheme);
            ACLog.d("IAPConnectPlugin", sb2.toString());
            if (openScheme) {
                iAPConnectPluginCallback.onResult(CallbackUtil.getSuccess("startApp"));
            } else {
                iAPConnectPluginCallback.onResult(CallbackUtil.getError("startApp", "11", ERROR_MESSAGE));
            }
        } else if (!JSAPICompatibilityConfigManager.getInstance().isJSAPICompatibilityEnabled()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Interceptor4startApp#handle, ");
            sb3.append("cancel apidowngrade, for it is not enabled");
            ACLog.d("IAPConnectPlugin", sb3.toString());
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError("startApp", "cancel apidowngrade, for it is not enabled"));
        } else if (UIUtils.isActivityDisabled(iAPConnectPluginContext.getActivity())) {
            ACLog.e("IAPConnectPlugin", "Interceptor4startApp#handle, activity is null or disabled");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError("startApp", "activity is null or disabled"));
        } else {
            String optString2 = jSONObject.optString("appId");
            if (TextUtils.isEmpty(optString2)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Interceptor4startApp#handle, the dist appId is null.  miniProgramName: ");
                sb4.append(iAPConnectPluginContext.miniProgramName);
                sb4.append("pageUrl: ");
                sb4.append(iAPConnectPluginContext.miniProgramPageURL);
                String obj = sb4.toString();
                ACLog.e("IAPConnectPlugin", obj);
                ApiDowngradeLogger.logException(ApiDowngradeLogger.EVENT_JSAPI_DOWNGRADE_APPID_IS_NULL, obj);
                iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError("startApp", obj));
                return;
            }
            JSONObject startAppMap = StartAppConfigManager.getInstance().getStartAppMap();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Interceptor4startApp#handle, before action executor, jsonStartAppMap: ");
            sb5.append(startAppMap);
            ACLog.d("IAPConnectPlugin", sb5.toString());
            if (startAppMap == null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Interceptor4startApp#handle, before action executor, ");
                sb6.append("jsonStartAppMap in amcs is null");
                ACLog.e("IAPConnectPlugin", sb6.toString());
                iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError("startApp", "jsonStartAppMap in amcs is null"));
                return;
            }
            JSONObject optJSONObject = startAppMap.optJSONObject(optString2);
            if (optJSONObject == null) {
                String format = String.format("jsonStartAppMapForDistAppId in appId %s is null", optString2);
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Interceptor4startApp#handle, before action executor, ");
                sb7.append(format);
                ACLog.e("IAPConnectPlugin", sb7.toString());
                iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError("startApp", format));
                return;
            }
            ActionExecutor.getInstance().handleAction(iAPConnectPluginContext, optJSONObject, new IActionHandlerCallback() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4startApp.1
                @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback
                public void onHandleFailure(JSONObject jSONObject2) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("Interceptor4startApp#handle, onHandleFailure, result: ");
                    sb8.append(jSONObject2);
                    ACLog.d("IAPConnectPlugin", sb8.toString());
                    iAPConnectPluginCallback.onResult(jSONObject2);
                }

                @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback
                public void onHandleSuccess(JSONObject jSONObject2) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("Interceptor4startApp#handle, onHandleSuccess, result: ");
                    sb8.append(jSONObject2);
                    ACLog.d("IAPConnectPlugin", sb8.toString());
                    iAPConnectPluginCallback.onResult(jSONObject2);
                }
            });
        }
    }
}

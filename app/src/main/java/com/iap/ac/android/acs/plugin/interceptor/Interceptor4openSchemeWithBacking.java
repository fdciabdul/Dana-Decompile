package com.iap.ac.android.acs.plugin.interceptor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.acs.plugin.utils.SchemeUtil;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4openSchemeWithBacking extends BaseInterceptor {
    public static final String DEFAULT_BACKING_PARAM_NAME = "backURL";
    public static final String ERROR_CODE_THIRD_APP_UNSUPPORTED = "10002";
    public static final String ERROR_CODE_URI_NOT_IN_WHITE_LIST = "10003";
    public static final String PARAM_BACKING_PARAM_NAME = "backingParamName";
    public static final String PARAM_URI = "uri";
    public static final String TAG = "IAPConnectPlugin";

    private JSONObject buildErrorCallbackResult(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", false);
            jSONObject.put("error", str2);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":");
            sb.append(str3);
            jSONObject.put("errorMessage", sb.toString());
            HashMap hashMap = new HashMap();
            hashMap.put("uri", str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(":");
            sb2.append(str3);
            MonitorUtil.monitorError(Constants.JS_API_OPEN_SCHEME_WITH_BACKING, str2, sb2.toString(), hashMap);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4openSchemeWithBacking#buildError JSONException");
            MonitorUtil.monitorJSONError(Constants.JS_API_OPEN_SCHEME_WITH_BACKING, e);
        }
        return jSONObject;
    }

    private void invokeCallbackSuccess(IAPConnectPluginCallback iAPConnectPluginCallback) {
        ACLog.d("IAPConnectPlugin", "Interceptor4openSchemeWithBacking#invokeCallbackSuccess");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", true);
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4openSchemeWithBacking#buildSuccessResult, build JSON result error");
            MonitorUtil.monitorJSONError(Constants.JS_API_OPEN_SCHEME_WITH_BACKING, e);
        } catch (Exception e2) {
            ACLog.e("IAPConnectPlugin", "Interceptor4openSchemeWithBacking#invokeSuccessResult, invoke callback error");
            MonitorUtil.monitorError(Constants.JS_API_OPEN_SCHEME_WITH_BACKING, "", e2.toString());
        }
    }

    private void openScheme(Activity activity, String str, String str2, IAPConnectPluginCallback iAPConnectPluginCallback) {
        try {
            Uri buildSchemeWithBacking = SchemeUtil.buildSchemeWithBacking(str, str2);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(buildSchemeWithBacking);
            activity.startActivity(intent);
            invokeCallbackSuccess(iAPConnectPluginCallback);
        } catch (Exception e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4openSchemeWithBacking#openScheme Exception", e);
            iAPConnectPluginCallback.onResult(CallbackUtil.getInternalError(Constants.JS_API_OPEN_SCHEME_WITH_BACKING, "Invoke scheme failed."));
        }
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4openSchemeWithBacking#handle, jsParameters is null", Constants.JS_API_OPEN_SCHEME_WITH_BACKING, "parameter is null", iAPConnectPluginCallback);
            return;
        }
        String optString = jSONObject.optString("uri");
        String optString2 = jSONObject.optString(PARAM_BACKING_PARAM_NAME, DEFAULT_BACKING_PARAM_NAME);
        if (TextUtils.isEmpty(optString)) {
            a.a("IAPConnectPlugin", "Interceptor4openSchemeWithBacking#handle, URI is empty", Constants.JS_API_OPEN_SCHEME_WITH_BACKING, "URI is empty", iAPConnectPluginCallback);
            return;
        }
        Activity activity = iAPConnectPluginContext.getActivity();
        if (activity == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4openSchemeWithBacking#handle, activity is null");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInternalError(Constants.JS_API_OPEN_SCHEME_WITH_BACKING, "activity is null"));
        } else if (!SchemeUtil.checkUriInWhiteList(optString)) {
            iAPConnectPluginCallback.onResult(buildErrorCallbackResult(optString, "10003", "URI is not in white list."));
        } else if (!SchemeUtil.checkUriCanBeProcessed(activity, optString)) {
            iAPConnectPluginCallback.onResult(buildErrorCallbackResult(optString, "10002", "No app can process this scheme."));
        } else {
            openScheme(activity, optString, optString2, iAPConnectPluginCallback);
        }
    }
}

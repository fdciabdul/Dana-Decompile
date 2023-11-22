package com.iap.ac.android.acs.plugin.interceptor;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.ui.activity.ThirdPartyAuthActivity;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.acs.plugin.utils.SchemeUtil;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4thirdPartyAuthForAc extends BaseInterceptor {
    public static final String ERROR_CODE_DUPLICATED_INVOKE = "10001";
    public static final String ERROR_CODE_THIRD_APP_UNSUPPORTED = "10002";
    public static final String ERROR_CODE_URI_NOT_IN_WHITE_LIST = "10003";
    public static final String ERROR_CODE_USER_CANCEL = "10004";
    public static final String PARAM_ANDROID_ACTION = "androidAction";
    public static final String PARAM_APP_NAME = "appName";
    public static final String PARAM_URI = "uri";
    public static final String TAG = "IAPConnectPlugin";
    public ResultReceiver currentResultReceiver;

    /* loaded from: classes8.dex */
    public static abstract class ResultReceiver extends BroadcastReceiver {
        public String action;
        public String appName;
        public IAPConnectPluginCallback callback;
        public String uri;

        public ResultReceiver(String str, String str2, String str3, IAPConnectPluginCallback iAPConnectPluginCallback) {
            this.appName = str;
            this.uri = str2;
            this.action = str3;
            this.callback = iAPConnectPluginCallback;
        }
    }

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
            hashMap.put("appName", str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(":");
            sb2.append(str3);
            MonitorUtil.monitorError(Constants.JS_API_THIRD_PARTY_AUTH_FOR_AC, str2, sb2.toString(), hashMap);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4thirdPartyAuthForAc#buildError JSONException");
            MonitorUtil.monitorJSONError(Constants.JS_API_THIRD_PARTY_AUTH_FOR_AC, e);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeCallback(String str, int i, String str2, String str3, IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (i == 0) {
            iAPConnectPluginCallback.onResult(buildErrorCallbackResult(str, "10004", "User cancel auth."));
        } else if (TextUtils.isEmpty(str2)) {
            ACLog.d("IAPConnectPlugin", "Interceptor4thirdPartyAuthForAc#invokeCallback, authCode is empty");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInternalError(Constants.JS_API_THIRD_PARTY_AUTH_FOR_AC, "No authCode returned by third-party App"));
        } else {
            invokeCallbackSuccess(str2, str3, iAPConnectPluginCallback);
        }
    }

    private void invokeCallbackSuccess(String str, String str2, IAPConnectPluginCallback iAPConnectPluginCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4thirdPartyAuthForAc#invokeCallbackSuccess, authCode: ");
        sb.append(str);
        sb.append(", authState: ");
        sb.append(str2);
        ACLog.d("IAPConnectPlugin", sb.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", true);
            jSONObject.put("authCode", str);
            jSONObject.put("authState", str2);
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4thirdPartyAuthForAc#buildSuccessResult, build JSON result error");
            MonitorUtil.monitorJSONError(Constants.JS_API_THIRD_PARTY_AUTH_FOR_AC, e);
        } catch (Exception e2) {
            ACLog.e("IAPConnectPlugin", "Interceptor4thirdPartyAuthForAc#invokeSuccessResult, invoke callback error");
            MonitorUtil.monitorError(Constants.JS_API_THIRD_PARTY_AUTH_FOR_AC, "", e2.toString());
        }
    }

    private void invokeThirdPartyAuth(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, ThirdPartyAuthActivity.class);
        intent.putExtra("ACTION", str2);
        intent.putExtra(ThirdPartyAuthActivity.KEY_URI, str3);
        intent.putExtra("APP_NAME", str);
        activity.startActivity(intent);
    }

    private ResultReceiver registerResultReceiver(Activity activity, String str, String str2, String str3, IAPConnectPluginCallback iAPConnectPluginCallback) {
        ResultReceiver resultReceiver = new ResultReceiver(str, str2, str3, iAPConnectPluginCallback) { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4thirdPartyAuthForAc.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptor4thirdPartyAuthForAc.this.currentResultReceiver = null;
                int intExtra = intent.getIntExtra("authResultCode", -1);
                String stringExtra = intent.getStringExtra("authCode");
                String stringExtra2 = intent.getStringExtra("authState");
                StringBuilder sb = new StringBuilder();
                sb.append("Interceptor4thirdPartyAuthForAc#onReceive broadcast, authCode: ");
                sb.append(stringExtra);
                sb.append(", authState: ");
                sb.append(stringExtra2);
                ACLog.d("IAPConnectPlugin", sb.toString());
                Interceptor4thirdPartyAuthForAc.this.invokeCallback(this.appName, intExtra, stringExtra, stringExtra2, this.callback);
                ACLog.d("IAPConnectPlugin", "Interceptor4thirdPartyAuthForAc#onReceive broadcast, unregister broadcast receiver");
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            }
        };
        LocalBroadcastManager.getInstance(activity).registerReceiver(resultReceiver, new IntentFilter("com.iap.ac.android.acs.plugin.action.THIRD_PARTY_AUTH_FOR_AC"));
        ACLog.d("IAPConnectPlugin", "Interceptor4thirdPartyAuthForAc#onReceive broadcast, register broadcast receiver");
        return resultReceiver;
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4thirdPartyAuthForAc#handle, jsParameters is null", Constants.JS_API_THIRD_PARTY_AUTH_FOR_AC, "parameter is null", iAPConnectPluginCallback);
            return;
        }
        String optString = jSONObject.optString("appName");
        String optString2 = jSONObject.optString("uri");
        String optString3 = jSONObject.optString(PARAM_ANDROID_ACTION);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            Activity activity = iAPConnectPluginContext.getActivity();
            if (activity == null) {
                ACLog.e("IAPConnectPlugin", "Interceptor4thirdPartyAuthForAc#handle, activity is null");
                iAPConnectPluginCallback.onResult(CallbackUtil.getInternalError(Constants.JS_API_THIRD_PARTY_AUTH_FOR_AC, "activity is null"));
                return;
            } else if (!SchemeUtil.checkUriInWhiteList(optString2)) {
                iAPConnectPluginCallback.onResult(buildErrorCallbackResult(optString, "10003", "URI is not in white list."));
                return;
            } else if (!SchemeUtil.checkUriCanBeProcessed(activity, optString2, optString3)) {
                iAPConnectPluginCallback.onResult(buildErrorCallbackResult(optString, "10002", "No app can process this scheme."));
                return;
            } else {
                if (this.currentResultReceiver != null) {
                    LocalBroadcastManager.getInstance(activity).unregisterReceiver(this.currentResultReceiver);
                    ResultReceiver resultReceiver = this.currentResultReceiver;
                    resultReceiver.callback.onResult(buildErrorCallbackResult(resultReceiver.appName, "10001", "Canceled caused by duplicated invoking."));
                }
                this.currentResultReceiver = registerResultReceiver(activity, optString, optString2, optString3, iAPConnectPluginCallback);
                invokeThirdPartyAuth(activity, optString, optString3, optString2);
                return;
            }
        }
        a.a("IAPConnectPlugin", "Interceptor4thirdPartyAuthForAc#handle, appName or URI is empty", Constants.JS_API_THIRD_PARTY_AUTH_FOR_AC, "appName or URI is empty", iAPConnectPluginCallback);
    }
}

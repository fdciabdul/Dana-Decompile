package com.iap.ac.android.acs.plugin.interceptor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity;
import com.iap.ac.android.acs.plugin.ui.utils.UIConstants;
import com.iap.ac.android.acs.plugin.utils.AuthCodeUtil;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4getPhoneNumber extends BaseInterceptor {
    public static final String PARAM_LOCALE = "locale";
    public static final String TAG = "IAPConnectPlugin";

    /* JADX INFO: Access modifiers changed from: private */
    public void convertResult(String str, String str2, IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (TextUtils.isEmpty(str2)) {
            iAPConnectPluginCallback.onResult(CallbackUtil.getError("getPhoneNumber", "-1", "User cancel"));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("regionCode", str);
            jSONObject.put("phoneNumber", str2);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            jSONObject.put(UploadTaskStatusCallback.NETWORK_MOBILE, sb.toString());
            iAPConnectPluginCallback.onResult(jSONObject);
            MonitorUtil.monitorGetPhoneNumber(str, str2);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getPhoneNumber#convertResult, convert result to JSON error");
            MonitorUtil.monitorJSONError("getPhoneNumber", e);
        }
    }

    private String getLocale(IAPConnectPluginContext iAPConnectPluginContext) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getPhoneNumber#getLocale, jsParameters is null");
            return null;
        }
        String optString = jSONObject.optString("locale");
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4getPhoneNumber#getLocale, locale from jsParameters: ");
        sb.append(optString);
        ACLog.d("IAPConnectPlugin", sb.toString());
        return optString;
    }

    private void getPhoneNumber(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        BroadcastReceiver initBroadcastReceiver = initBroadcastReceiver(iAPConnectPluginCallback);
        ACLog.d("IAPConnectPlugin", "Interceptor4getPhoneNumber#getPhoneNumber, register broadcast");
        iAPConnectPluginContext.getContext().registerReceiver(initBroadcastReceiver, new IntentFilter("com.iap.ac.android.acs.plugin.action.GET_PHONE_NUMBER"));
        if (iAPConnectPluginContext.getActivity() != null) {
            ACLog.d("IAPConnectPlugin", "Interceptor4getPhoneNumber#getPhoneNumber, start activity");
            Intent intent = new Intent(iAPConnectPluginContext.getActivity(), GetPhoneNumberActivity.class);
            intent.putExtra("locale", getLocale(iAPConnectPluginContext));
            intent.putExtra(UIConstants.KEY_MINI_PROGRAM_NAME, iAPConnectPluginContext.miniProgramName);
            iAPConnectPluginContext.getActivity().startActivity(intent);
            return;
        }
        iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError("getPhoneNumber", "activity is null"));
    }

    private BroadcastReceiver initBroadcastReceiver(final IAPConnectPluginCallback iAPConnectPluginCallback) {
        return new BroadcastReceiver() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4getPhoneNumber.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra("regionCode");
                String stringExtra2 = intent.getStringExtra("phoneNumber");
                StringBuilder sb = new StringBuilder();
                sb.append("Interceptor4getPhoneNumber#onReceive broadcast, regionCode: ");
                sb.append(stringExtra);
                sb.append(", phoneNumber: ");
                sb.append(stringExtra2);
                ACLog.d("IAPConnectPlugin", sb.toString());
                Interceptor4getPhoneNumber.this.convertResult(stringExtra, stringExtra2, iAPConnectPluginCallback);
                ACLog.d("IAPConnectPlugin", "Interceptor4getPhoneNumber#onReceive broadcast, unregister broadcast");
                context.unregisterReceiver(this);
            }
        };
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (!AuthCodeUtil.getAuthenticationResult(iAPConnectPluginContext.getContext(), iAPConnectPluginContext.miniProgramAppID, "phoneNumber")) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getPhoneNumber#handle, not authenticated before");
            iAPConnectPluginCallback.onResult(CallbackUtil.getAuthorizedError("getPhoneNumber"));
            return;
        }
        getPhoneNumber(iAPConnectPluginContext, iAPConnectPluginCallback);
    }
}

package com.iap.ac.android.acs.plugin.interceptor;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.IPaymentCodeListener;
import com.iap.ac.android.biz.common.model.remoteconfig.cpm.CPMConfig;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.cpm.online.manager.OnlinePaymentCodeManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4getPaymentCode extends BaseInterceptor {
    public static final String ERROR_CODE_UNSUPPORTED = "40004";
    public static final String ERROR_MESSAGE_UNSUPPORTED = "Offline code not supported";
    public static final String PARAM_REGION = "region";
    public static final String TAG = "IAPConnectPlugin";

    /* JADX INFO: Access modifiers changed from: private */
    public void convertError(String str, String str2, IAPConnectPluginCallback iAPConnectPluginCallback) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", str);
            jSONObject.put("errorMessage", str2);
            MonitorUtil.monitorError("getPaymentCode", str, str2);
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getPaymentCode#convertError, convert error to JSON error");
            MonitorUtil.monitorJSONError("getPaymentCode", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void convertResult(String str, IAPConnectPluginCallback iAPConnectPluginCallback) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paymentCode", str);
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getPaymentCode#convertResult, convert result to JSON error");
            MonitorUtil.monitorJSONError("getPaymentCode", e);
        }
    }

    private void getPaymentCode(String str, String str2, CPMConfig cPMConfig, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (cPMConfig.onlineCode) {
            ACLog.d("IAPConnectPlugin", "Interceptor4getPaymentCode#getPaymentCode, online code");
            OnlinePaymentCodeManager.getInstance().setRegion(str2);
            OnlinePaymentCodeManager.getInstance().getPaymentCode(str, cPMConfig, new IPaymentCodeListener() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4getPaymentCode.1
                @Override // com.iap.ac.android.biz.common.callback.IPaymentCodeListener
                public void onPaymentCodeUpdateFailed(String str3, String str4) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Interceptor4getPaymentCode#onPaymentCodeUpdateFailed, errorCode: ");
                    sb.append(str3);
                    sb.append(", errorMessage: ");
                    sb.append(str4);
                    ACLog.d("IAPConnectPlugin", sb.toString());
                    Interceptor4getPaymentCode.this.convertError(str3, str4, iAPConnectPluginCallback);
                }

                @Override // com.iap.ac.android.biz.common.callback.IPaymentCodeListener
                public void onPaymentCodeUpdated(String str3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Interceptor4getPaymentCode#onPaymentCodeUpdated, paymentCode: ");
                    sb.append(str3);
                    ACLog.d("IAPConnectPlugin", sb.toString());
                    Interceptor4getPaymentCode.this.convertResult(str3, iAPConnectPluginCallback);
                }
            });
            return;
        }
        ACLog.e("IAPConnectPlugin", "Interceptor4getPaymentCode#getPaymentCode, try to get offline code");
        iAPConnectPluginCallback.onResult(CallbackUtil.getError("getPaymentCode", "40004", ERROR_MESSAGE_UNSUPPORTED));
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4getPaymentCode#handle, jsParameters is null", "getPaymentCode", "parameter is null", iAPConnectPluginCallback);
            return;
        }
        String optString = jSONObject.optString("region");
        if (TextUtils.isEmpty(optString)) {
            a.a("IAPConnectPlugin", "Interceptor4getPaymentCode#handle, region is empty", "getPaymentCode", "region is empty", iAPConnectPluginCallback);
            return;
        }
        ACManager.getInstance().fetchConfigAsync(null);
        String codeType = ACManager.getInstance().getCodeType(optString);
        CPMConfig cpmConfig = ACManager.getInstance().getCpmConfig(codeType);
        if (cpmConfig == null) {
            a.a("IAPConnectPlugin", "Interceptor4getPaymentCode#handle, CPM config is null", "getPaymentCode", "CPM config is null", iAPConnectPluginCallback);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4getPaymentCode#handle, start to get payment code, codeType: ");
        sb.append(codeType);
        sb.append(", region: ");
        sb.append(optString);
        ACLog.d("IAPConnectPlugin", sb.toString());
        getPaymentCode(codeType, optString, cpmConfig, iAPConnectPluginCallback);
    }
}

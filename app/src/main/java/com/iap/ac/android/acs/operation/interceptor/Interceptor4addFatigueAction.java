package com.iap.ac.android.acs.operation.interceptor;

import android.text.TextUtils;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.operation.utils.CallbackUtil;
import com.iap.ac.android.acs.operation.utils.Constants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.region.cdp.WalletCdpKit;
import com.iap.ac.android.region.cdp.component.callback.AddFatigueActionCallback;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4addFatigueAction extends BaseInterceptor {
    public static final String PARAM_ACTION = "action";
    public static final String PARAM_DELIVER_ID = "deliverId";
    public static final String PARAM_SPACE_CODE = "spaceCode";
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.operation.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4addFatigueAction#handle, jsParameters is null");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError(Constants.JS_API_ADD_FATIGUE_ACTION, "jsParameters is null"));
            return;
        }
        String optString = jSONObject.optString("spaceCode");
        String optString2 = jSONObject.optString(PARAM_DELIVER_ID);
        String optString3 = jSONObject.optString("action");
        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString3)) {
            WalletCdpKit.getInstance().addFatigueAction(iAPConnectPluginContext.getContext(), optString, optString2, optString3, true, new AddFatigueActionCallback() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4addFatigueAction.1
                @Override // com.iap.ac.android.region.cdp.component.callback.AddFatigueActionCallback
                public void onFailure(Exception exc) {
                    iAPConnectPluginCallback.onResult(CallbackUtil.getInternalError(Constants.JS_API_ADD_FATIGUE_ACTION, exc.getMessage()));
                    StringBuilder sb = new StringBuilder();
                    sb.append("Interceptor4addFatigueAction#handle, error: ");
                    sb.append(exc.getMessage());
                    ACLog.e("IAPConnectPlugin", sb.toString());
                }

                @Override // com.iap.ac.android.region.cdp.component.callback.AddFatigueActionCallback
                public void onSuccess(boolean z) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("fatigueExhausted", z);
                        iAPConnectPluginCallback.onResult(jSONObject2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("Interceptor4addFatigueAction#handle, result: ");
                        sb.append(jSONObject2);
                        ACLog.d("IAPConnectPlugin", sb.toString());
                    } catch (Throwable th) {
                        onFailure(new Exception(th));
                    }
                }
            });
            return;
        }
        String format = String.format("the params can't be empty, spaceCode: %s, deliverId: %s, action: %s.", optString, optString2, optString3);
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4addFatigueAction#handle, ");
        sb.append(format);
        ACLog.e("IAPConnectPlugin", sb.toString());
        iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError(Constants.JS_API_ADD_FATIGUE_ACTION, format));
    }
}

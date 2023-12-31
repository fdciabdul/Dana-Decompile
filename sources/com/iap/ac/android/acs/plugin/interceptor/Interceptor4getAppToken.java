package com.iap.ac.android.acs.plugin.interceptor;

import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.risk.RiskControlManager;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4getAppToken extends BaseInterceptor {
    public static final String APP_TOKEN = "appToken";

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        String tokenId = RiskControlManager.getInstance().getTokenId();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(APP_TOKEN, tokenId);
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getAppToken#handle, convert result to JSON error");
            MonitorUtil.monitorJSONError(Constants.JS_API_GET_APP_TOKEN, e);
        }
    }
}

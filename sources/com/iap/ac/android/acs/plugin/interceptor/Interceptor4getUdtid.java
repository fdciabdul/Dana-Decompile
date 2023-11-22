package com.iap.ac.android.acs.plugin.interceptor;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.ErrorCode;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4getUdtid extends BaseInterceptor {
    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        String str;
        try {
            str = InstanceInfo.getInstanceId(iAPConnectPluginContext.getContext());
        } catch (Exception e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getUdtid", e);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            iAPConnectPluginCallback.onResult(CallbackUtil.getError(Constants.JS_API_GET_UDTID, "3", ErrorCode.ERROR_UNKNOWN_ERROR_MESSAGE));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("utdid", str);
        } catch (JSONException e2) {
            ACLog.e("IAPConnectPlugin", "json error", e2);
        }
        iAPConnectPluginCallback.onResult(jSONObject);
    }
}

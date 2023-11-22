package com.iap.ac.android.acs.plugin.interceptor;

import android.content.Context;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.AuthCodeUtil;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.auth.IContainerAuth;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4getSetting extends BaseInterceptor {
    public static final String TAG = "IAPConnectPlugin";

    private JSONObject convertAuthSetting(Map<String, Boolean> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    private void convertResult(Map<String, Boolean> map, IAPConnectPluginCallback iAPConnectPluginCallback) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("authSetting", convertAuthSetting(map));
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getSetting#convertResult, convert result to JSON error");
            MonitorUtil.monitorJSONError(Constants.JS_API_GET_SETTING, e);
        }
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        HashMap hashMap = new HashMap();
        String str = iAPConnectPluginContext.miniProgramAppID;
        String openId = SPIManager.getInstance().getOpenId();
        Context context = iAPConnectPluginContext.getContext();
        IContainerAuth containerAuth = WebContainer.getInstance("ac_biz").getContainerAuth();
        if (containerAuth != null) {
            Map<String, Boolean> deviceAuthSetting = containerAuth.getDeviceAuthSetting(str, openId);
            StringBuilder sb = new StringBuilder();
            sb.append("Interceptor4getSetting#handle, deviceAuthSetting: ");
            sb.append(deviceAuthSetting);
            ACLog.d("IAPConnectPlugin", sb.toString());
            if (deviceAuthSetting != null && !deviceAuthSetting.isEmpty()) {
                hashMap.putAll(deviceAuthSetting);
            }
        }
        boolean authenticationResult = AuthCodeUtil.getAuthenticationResult(context, str, "userInfo");
        boolean authenticationResult2 = AuthCodeUtil.getAuthenticationResult(context, str, "phoneNumber");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Interceptor4getSetting#handle, userInfoAuthResult: ");
        sb2.append(authenticationResult);
        sb2.append(", phoneNumberAuthResult: ");
        sb2.append(authenticationResult2);
        ACLog.d("IAPConnectPlugin", sb2.toString());
        hashMap.put("userInfo", Boolean.valueOf(authenticationResult || authenticationResult2));
        convertResult(hashMap, iAPConnectPluginCallback);
    }
}

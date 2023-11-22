package com.iap.ac.android.acs.plugin.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.model.ContainerParams;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConfigInterceptor {
    public static final String CONFIG_INTERCEPT = "INTERCEPT";
    public static final String CONFIG_INTERCEPT_APP_ID = "appId";
    public static final String CONFIG_INTERCEPT_RESULT = "result";
    public static final String CONFIG_INTERCEPT_STRATEGY = "strategy";
    public static final String CONFIG_INTERCEPT_URL = "url";
    public static final String CONFIG_KEY = "acs_jsapi_intercept_strategy";
    public static final String CONFIG_NOT_INTERCEPT = "NOT_INTERCEPT";
    public static final String TAG = "IAPConnectPlugin";

    public static Boolean handle(String str, IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        String optString;
        JSONObject jSONObject = (JSONObject) ConfigCenter.INSTANCE.getKeyOrDefault("acs_jsapi_intercept_strategy", new JSONObject());
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ConfigInterceptor#handle, config interceptor strategy json is null for: ");
            sb.append(str);
            ACLog.d("IAPConnectPlugin", sb.toString());
            MonitorUtil.monitorInterceptConfig(str, "CONFIG_NONE");
            return null;
        }
        try {
            optString = optJSONObject.optString("strategy");
        } catch (JSONException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ConfigInterceptor#handle error, config interceptor json: ");
            sb2.append(jSONObject);
            ACLog.e("IAPConnectPlugin", sb2.toString());
        }
        if ("NOT_INTERCEPT".equals(optString)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ConfigInterceptor#handle, NOT_INTERCEPT ");
            sb3.append(str);
            ACLog.d("IAPConnectPlugin", sb3.toString());
            MonitorUtil.monitorInterceptConfig(str, "CONFIG_NOT_INTERCEPT");
            return Boolean.FALSE;
        }
        if ("INTERCEPT".equals(optString)) {
            handleIntercept(optJSONObject, str, iAPConnectPluginContext, iAPConnectPluginCallback);
            return Boolean.TRUE;
        }
        MonitorUtil.monitorInterceptConfig(str, "CONFIG_NONE");
        return null;
    }

    public static void handleIntercept(JSONObject jSONObject, String str, IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) throws JSONException {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("result");
        StringBuilder sb = new StringBuilder();
        sb.append("ConfigInterceptor#handleIntercept, INTERCEPT ");
        sb.append(str);
        sb.append(", appId: ");
        sb.append(optString);
        sb.append(", url: ");
        sb.append(optString2);
        sb.append(", result: ");
        sb.append(optString3);
        ACLog.d("IAPConnectPlugin", sb.toString());
        if (!TextUtils.isEmpty(optString)) {
            iAPConnectPluginCallback.onResult(new JSONObject());
            ContainerParams createForMniProgram = ContainerParams.createForMniProgram(optString);
            createForMniProgram.containerBundle = new Bundle();
            createForMniProgram.containerBundle.putString("result", optString3);
            WebContainer.getInstance("ac_biz").startContainer(iAPConnectPluginContext.getContext(), createForMniProgram);
            MonitorUtil.monitorInterceptConfig(str, "CONFIG_INTERCEPT_BY_APP_ID");
        } else if (!TextUtils.isEmpty(optString2)) {
            iAPConnectPluginCallback.onResult(new JSONObject());
            WebContainer.getInstance("ac_biz").startContainer(iAPConnectPluginContext.getContext(), optString2);
            MonitorUtil.monitorInterceptConfig(str, "CONFIG_INTERCEPT_BY_URL");
        } else if (!TextUtils.isEmpty(optString3)) {
            iAPConnectPluginCallback.onResult(new JSONObject(optString3));
            MonitorUtil.monitorInterceptConfig(str, "CONFIG_INTERCEPT_BY_RESULT");
        } else {
            iAPConnectPluginCallback.onResult(new JSONObject());
        }
    }
}

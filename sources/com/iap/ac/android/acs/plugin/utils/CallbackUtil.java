package com.iap.ac.android.acs.plugin.utils;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipay.mobile.security.zim.biz.ZimPlatform;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CallbackUtil {
    public static final String ERROR_CODE_INTERNAL_ERROR = "40004";
    public static final String ERROR_CODE_INVALID_PARAM = "40002";
    public static final String ERROR_CODE_NOT_AUTHORIZED = "40003";
    public static final String ERROR_MESSAGE_INTERNAL_ERROR = "Internal error";
    public static final String ERROR_MESSAGE_INVALID_PARAM = "Invalid parameter";

    public static JSONObject getAuthorizedError(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", "40003");
            jSONObject2.put("msg", "Insufficient Conditions");
            jSONObject2.put("subCode", "isv.invalid-auth-relations");
            jSONObject2.put(ZimPlatform.KEY_SUB_MSG, "not authorized");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("response", jSONObject2);
            jSONObject.put("response", jSONObject3);
            MonitorUtil.monitorError(str, "40003", jSONObject.toString());
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "CallbackUtil#getAuthorizedError JSONException");
            MonitorUtil.monitorJSONError(str, e);
        }
        return jSONObject;
    }

    public static JSONObject getError(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", str2);
            jSONObject.put("errorMessage", str3);
            MonitorUtil.monitorError(str, str2, str3);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "CallbackUtil#getError JSONException");
            MonitorUtil.monitorJSONError(str, e);
        }
        return jSONObject;
    }

    public static JSONObject getInternalError(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", false);
            jSONObject.put("error", "40004");
            jSONObject.put("errorMessage", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("Internal error, ");
            sb.append(str2);
            MonitorUtil.monitorError(str, "40004", sb.toString());
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "CallbackUtil#getInternalErrorError JSONException");
            MonitorUtil.monitorJSONError(str, e);
        }
        return jSONObject;
    }

    public static JSONObject getInvalidParamError(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", false);
            jSONObject.put("error", "40002");
            jSONObject.put("errorMessage", "Invalid parameter");
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid parameter, ");
            sb.append(str2);
            MonitorUtil.monitorError(str, "40002", sb.toString());
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "CallbackUtil#getInvalidParamError JSONException");
            MonitorUtil.monitorJSONError(str, e);
        }
        return jSONObject;
    }

    public static JSONObject getSuccess(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", true);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "CallbackUtil#getSuccess JSONException");
            MonitorUtil.monitorJSONError(str, e);
        }
        return jSONObject;
    }

    public static JSONObject getError(String str, String str2, String str3, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", str2);
            jSONObject.put("errorMessage", str3);
            jSONObject.put(GriverMonitorConstants.KEY_SHOW_AUTH_PAGE_FIRED, z);
            MonitorUtil.monitorError(str, str2, str3);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "CallbackUtil#getError JSONException");
            MonitorUtil.monitorJSONError(str, e);
        }
        return jSONObject;
    }
}

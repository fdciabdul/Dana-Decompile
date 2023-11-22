package com.iap.ac.android.acs.plugin.interceptor;

import android.text.TextUtils;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.AclAPIContextUtils;
import com.iap.ac.android.acs.plugin.utils.AuthCodeUtil;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.acs.plugin.utils.Utils;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.model.auth.AuthPageRequest;
import com.iap.ac.android.biz.common.model.auth.AuthPageResult;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4getAuthCode extends BaseInterceptor {
    public static final String ERROR_CODE_EMPTY = "10";
    public static final String ERROR_CODE_SYSTEM_ERROR = "1005";
    public static final String ERROR_CODE_UNKNOWN_ERROR = "1000";
    public static final String ERROR_CODE_USER_CANCEL = "1001";
    public static final String ERROR_MESSAGE_EMPTY = "Empty authCode";
    public static final String ERROR_UNKNOW = "3";
    public static final String ERROR_UNKNOW_MESSAGE = "Unknown error!";
    public static final String KEY_SHOW_AUTHPAGE_DISABLE = "ac_showauthpage_disable";
    public static final String PARAM_SCOPE_NICKS = "scopeNicks";
    public static final String TAG = "IAPConnectPlugin";
    public static final String USER_CANCEL = "11";
    public static final String USER_CANCEL_MESSAGE = "Unauthorized to get user info ";
    public Map<String, String> params = new HashMap();

    private void convertAuthResult(AuthResult authResult, IAPConnectPluginCallback iAPConnectPluginCallback, boolean z) {
        StringBuilder a2 = a.a("Interceptor4getAuthCode#convertAuthResult, authCode: ");
        a2.append(authResult.authCode);
        a2.append(", authSuccessScopes: ");
        a2.append(authResult.authSuccessScopes);
        a2.append(", authErrorScopes: ");
        a2.append(authResult.authErrorScopes);
        ACLog.d("IAPConnectPlugin", a2.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("authCode", authResult.authCode);
            jSONObject.put("authSuccessScopes", convertSuccessScopes(authResult.authSuccessScopes));
            jSONObject.put("authErrorScopes", convertErrorScopes(authResult.authErrorScopes));
            jSONObject.put(GriverMonitorConstants.KEY_SHOW_AUTH_PAGE_FIRED, z);
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getAuthCode#convertAuthResult, convert auth result to JSON error");
            MonitorUtil.monitorJSONError(Constants.JS_API_GET_AUTH_CODE, e);
        }
    }

    private JSONObject convertErrorScopes(Map<String, String> map) throws JSONException {
        Map<String, String> convertGNErrorScopes2Alipay = AuthCodeUtil.convertGNErrorScopes2Alipay(map);
        if (!convertGNErrorScopes2Alipay.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Interceptor4getAuthCode#convertErrorScopes, resultMap: ");
            sb.append(convertGNErrorScopes2Alipay);
            ACLog.e("IAPConnectPlugin", sb.toString());
            MonitorUtil.monitorError(Constants.JS_API_GET_AUTH_CODE, "", convertGNErrorScopes2Alipay.toString());
        }
        return Utils.stringMap2Json(convertGNErrorScopes2Alipay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void convertResult(AuthResult authResult, IAPConnectPluginCallback iAPConnectPluginCallback, boolean z) {
        if (authResult == null) {
            ACLog.d("IAPConnectPlugin", "Interceptor4getAuthCode#convertResult, authResult is null");
            iAPConnectPluginCallback.onResult(CallbackUtil.getError(Constants.JS_API_GET_AUTH_CODE, "10", "Empty authCode", z));
        } else if (TextUtils.isEmpty(authResult.authCode)) {
            ACLog.d("IAPConnectPlugin", "Interceptor4getAuthCode#convertResult, authCode is empty");
            iAPConnectPluginCallback.onResult(CallbackUtil.getError(Constants.JS_API_GET_AUTH_CODE, authResult.errorCode, authResult.errorMessage, z));
        } else {
            convertAuthResult(authResult, iAPConnectPluginCallback, z);
        }
    }

    private JSONArray convertSuccessScopes(List<String> list) {
        return Utils.stringList2JsonArray(AuthCodeUtil.convertScopes(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeGetAuthCode(final String str, final String str2, final List<String> list, final String str3, final String str4, final AclAPIContext aclAPIContext, final IAPConnectPluginCallback iAPConnectPluginCallback, final int i, final boolean z) {
        SPIManager.getInstance().getAuthCode(str, str2, list, aclAPIContext, new IAuthCallback() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4getAuthCode.1
            @Override // com.iap.ac.android.biz.common.callback.IAuthCallback
            public void onResult(AuthResult authResult) {
                if (Interceptor4getAuthCode.this.showAuthPageDisable() || authResult == null || !"2001".equals(authResult.errorCode)) {
                    Interceptor4getAuthCode.this.convertResult(authResult, iAPConnectPluginCallback, z);
                    return;
                }
                HashSet hashSet = new HashSet();
                hashSet.addAll(list);
                AuthPageRequest authPageRequest = new AuthPageRequest();
                authPageRequest.authClientLogo = str3;
                authPageRequest.authClientName = str4;
                authPageRequest.clientId = str;
                authPageRequest.scopes = hashSet;
                SPIManager.getInstance().showAuthPage(authPageRequest, aclAPIContext, new AcCallback<AuthPageResult>() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4getAuthCode.1.1
                    @Override // com.iap.ac.android.biz.common.model.AcCallback
                    public void onResult(AuthPageResult authPageResult) {
                        if (authPageResult.success) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            int i2 = i;
                            if (i2 > 0) {
                                Interceptor4getAuthCode.this.executeGetAuthCode(str, str2, list, str3, str4, aclAPIContext, iAPConnectPluginCallback, i2 - 1, true);
                            } else {
                                iAPConnectPluginCallback.onResult(CallbackUtil.getError(Constants.JS_API_GET_AUTH_CODE, "3", Interceptor4getAuthCode.ERROR_UNKNOW_MESSAGE, true));
                            }
                        } else if ("1001".equals(authPageResult.errorCode)) {
                            iAPConnectPluginCallback.onResult(CallbackUtil.getError(Constants.JS_API_GET_AUTH_CODE, "11", Interceptor4getAuthCode.USER_CANCEL_MESSAGE, true));
                        } else if ("1005".equals(authPageResult.errorCode)) {
                            iAPConnectPluginCallback.onResult(CallbackUtil.getError(Constants.JS_API_GET_AUTH_CODE, "10", "Empty authCode", true));
                        } else {
                            iAPConnectPluginCallback.onResult(CallbackUtil.getError(Constants.JS_API_GET_AUTH_CODE, "3", Interceptor4getAuthCode.ERROR_UNKNOW_MESSAGE, true));
                        }
                    }
                });
            }
        });
    }

    private void getAuthCode(JSONArray jSONArray, IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        String str;
        String str2 = "";
        List<String> convertScopes = AuthCodeUtil.convertScopes(Utils.jsonArray2StringList(jSONArray));
        String clientId = AuthCodeUtil.getClientId();
        String authClientId = AuthCodeUtil.getAuthClientId(iAPConnectPluginContext);
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4getAuthCode#getAuthCode, clientId: ");
        sb.append(clientId);
        sb.append(", authClientId: ");
        sb.append(authClientId);
        sb.append(", scopeList: ");
        sb.append(convertScopes);
        ACLog.d("IAPConnectPlugin", sb.toString());
        AclAPIContext createAclAPIContext = AclAPIContextUtils.createAclAPIContext(iAPConnectPluginContext);
        JSONObject jSONObject = iAPConnectPluginContext.acParams;
        try {
            str = jSONObject.getString("logo");
            try {
                str2 = jSONObject.getString("name");
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            str = "";
        }
        executeGetAuthCode(clientId, authClientId, convertScopes, str, str2, createAclAPIContext, iAPConnectPluginCallback, 3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean showAuthPageDisable() {
        return ((Boolean) ConfigCenter.INSTANCE.getKeyOrDefault(KEY_SHOW_AUTHPAGE_DISABLE, Boolean.FALSE)).booleanValue();
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4getAuthCode#handle, jsParameters is null", Constants.JS_API_GET_AUTH_CODE, "parameter is null", iAPConnectPluginCallback);
            return;
        }
        try {
            String str = iAPConnectPluginContext.miniProgramAppID;
            String str2 = iAPConnectPluginContext.miniProgramPageURL;
            String string = iAPConnectPluginContext.acParams.getString("developerVersion");
            String string2 = iAPConnectPluginContext.acParams.getString("deployVersion");
            this.params.put("version", string);
            this.params.put("deployVersion", string2);
            this.params.put("env", "prod");
            this.params.put("url", str2);
            this.params.put("appId", str);
        } catch (JSONException unused) {
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scopeNicks");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            getAuthCode(optJSONArray, iAPConnectPluginContext, iAPConnectPluginCallback);
        } else {
            a.a("IAPConnectPlugin", "Interceptor4getAuthCode#handle, scopes is empty", Constants.JS_API_GET_AUTH_CODE, "scopes is empty", iAPConnectPluginCallback);
        }
    }
}

package com.iap.ac.android.acs.plugin.interceptor;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.AclAPIContextUtils;
import com.iap.ac.android.acs.plugin.utils.AuthCodeUtil;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.acs.plugin.utils.Utils;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.log.ACLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4getComponentAuth extends BaseInterceptor {
    public static final String PARAM_SCOPE_NICKS = "scopeNicks";
    public static final String TAG = "IAPConnectPlugin";

    private List<String> getScopes(JSONObject jSONObject, IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4getComponentAuth#getScopes, jsParameters is null", Constants.JS_API_GET_COMPONENT_AUTH, "parameter is null", iAPConnectPluginCallback);
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scopeNicks");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            List<String> jsonArray2StringList = Utils.jsonArray2StringList(optJSONArray);
            StringBuilder sb = new StringBuilder();
            sb.append("Interceptor4getComponentAuth#getScopes: ");
            sb.append(jsonArray2StringList);
            ACLog.d("IAPConnectPlugin", sb.toString());
            return jsonArray2StringList;
        }
        a.a("IAPConnectPlugin", "Interceptor4getComponentAuth#getScopes, scopeNicks is empty", Constants.JS_API_GET_COMPONENT_AUTH, "scopeNicks is empty", iAPConnectPluginCallback);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAuthenticationResult(Context context, String str, List<String> list, AuthResult authResult, IAPConnectPluginCallback iAPConnectPluginCallback) {
        boolean z = true;
        if (authResult != null && !TextUtils.isEmpty(authResult.authCode)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Interceptor4getComponentAuth#saveAuthenticationResult, appId: ");
            sb.append(str);
            sb.append(", scopeList: ");
            sb.append(list);
            sb.append(", authCode: ");
            sb.append(authResult.authCode);
            ACLog.d("IAPConnectPlugin", sb.toString());
            for (String str2 : list) {
                AuthCodeUtil.saveAuthCode(str, str2, authResult.authCode);
                AuthCodeUtil.saveAuthenticationResult(context, str, str2, true);
            }
        } else {
            ACLog.d("IAPConnectPlugin", "Interceptor4getComponentAuth#saveAuthenticationResult, auth code is empty");
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                AuthCodeUtil.saveAuthenticationResult(context, str, it.next(), false);
            }
            z = false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", z);
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getComponentAuth#saveAuthenticationResult, convert result to JSON error");
            MonitorUtil.monitorJSONError(Constants.JS_API_GET_COMPONENT_AUTH, e);
        }
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(final IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        final List<String> scopes = getScopes(iAPConnectPluginContext.jsParameters, iAPConnectPluginCallback);
        if (scopes != null && !scopes.isEmpty()) {
            String clientId = AuthCodeUtil.getClientId();
            String authClientId = AuthCodeUtil.getAuthClientId(iAPConnectPluginContext);
            StringBuilder sb = new StringBuilder();
            sb.append("Interceptor4getComponentAuth#handle, start to get auth code, clientId: ");
            sb.append(clientId);
            sb.append(", authClientId: ");
            sb.append(authClientId);
            sb.append(", scopeList: ");
            sb.append(scopes);
            ACLog.d("IAPConnectPlugin", sb.toString());
            SPIManager.getInstance().getAuthCode(clientId, authClientId, scopes, AclAPIContextUtils.createAclAPIContext(iAPConnectPluginContext), new IAuthCallback() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4getComponentAuth.1
                @Override // com.iap.ac.android.biz.common.callback.IAuthCallback
                public void onResult(AuthResult authResult) {
                    Interceptor4getComponentAuth.this.saveAuthenticationResult(iAPConnectPluginContext.getContext(), iAPConnectPluginContext.miniProgramAppID, scopes, authResult, iAPConnectPluginCallback);
                }
            });
            return;
        }
        ACLog.d("IAPConnectPlugin", "Interceptor4getComponentAuth#handle, scope list is empty");
    }
}

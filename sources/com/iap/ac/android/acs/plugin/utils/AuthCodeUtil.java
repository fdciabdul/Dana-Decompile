package com.iap.ac.android.acs.plugin.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.iap.android.wallet.acl.oauth.OAuthService;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AuthCodeUtil {
    public static final String CONFIG_KEY_GN_SCOPES_MAP = "acs_alipay_gn_scopes_map";
    public static final Map<String, String> DEFAULT_SCOPE_CONVERSION_MAP;
    public static final String PARAM_AUTH_CLIENT_ID = "authClientId";
    public static final String SCOPE_PHONE_NUMBER = "phoneNumber";
    public static final String SCOPE_USER_INFO = "userInfo";
    public static final String SP_KEY_PREF = "authentication_";
    public static final String SP_NAME = "IAPConnectPlugin";
    public static final String TAG = "IAPConnectPlugin";
    public static Map<String, String> authCodeMap;

    static {
        HashMap hashMap = new HashMap(4);
        DEFAULT_SCOPE_CONVERSION_MAP = hashMap;
        hashMap.put(OAuthService.SCOPE_AUTH_BASE, OAuthService.SCOPE_BASE_USER_INFO);
        hashMap.put("SCOPE_BASE", OAuthService.SCOPE_BASE_USER_INFO);
        hashMap.put(OAuthService.SCOPE_AUTH_USER, OAuthService.SCOPE_USER_INFO);
        hashMap.put(OAuthService.SCOPE_BASE_USER_INFO, OAuthService.SCOPE_AUTH_BASE);
        hashMap.put(OAuthService.SCOPE_USER_INFO, OAuthService.SCOPE_AUTH_USER);
        authCodeMap = new HashMap();
    }

    public static Map<String, String> convertGNErrorScopes2Alipay(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            Map<String, String> scopeConversionMap = getScopeConversionMap();
            HashMap hashMap = new HashMap(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (scopeConversionMap.containsKey(key)) {
                    hashMap.put(scopeConversionMap.get(key), entry.getValue());
                } else {
                    hashMap.put(key, entry.getValue());
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AuthCodeUtil#convertGNErrorScopes2Alipay: ");
            sb.append(hashMap);
            ACLog.d("IAPConnectPlugin", sb.toString());
            return hashMap;
        }
        ACLog.e("IAPConnectPlugin", "AuthCodeUtil#convertGNErrorScopes2Alipay, error GN scope map is empty, return empty map");
        return new HashMap();
    }

    public static List<String> convertScopes(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Map<String, String> scopeConversionMap = getScopeConversionMap();
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                if (scopeConversionMap.containsKey(str)) {
                    arrayList.add(scopeConversionMap.get(str));
                } else {
                    arrayList.add(str);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AuthCodeUtil#convertScopes: ");
            sb.append(arrayList);
            ACLog.d("IAPConnectPlugin", sb.toString());
            return arrayList;
        }
        ACLog.e("IAPConnectPlugin", "AuthCodeUtil#convertScopes, scopes is empty, return empty list");
        return new ArrayList();
    }

    public static String getAuthClientId(IAPConnectPluginContext iAPConnectPluginContext) {
        JSONObject jSONObject = iAPConnectPluginContext.acParams;
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "AuthCodeUtil#getAuthClientId, acParams is null, return app id");
            return iAPConnectPluginContext.miniProgramAppID;
        }
        String optString = jSONObject.optString("authClientId");
        if (TextUtils.isEmpty(optString)) {
            ACLog.d("IAPConnectPlugin", "AuthCodeUtil#getAuthClientId, auth client id in acParams is empty, return app id");
            return iAPConnectPluginContext.miniProgramAppID;
        }
        return optString;
    }

    public static boolean getAuthenticationResult(Context context, String str, String str2) {
        String sPKey = getSPKey(str, str2, SPIManager.getInstance().getOpenId());
        boolean z = context.getSharedPreferences("IAPConnectPlugin", 0).getBoolean(sPKey, false);
        StringBuilder sb = new StringBuilder();
        sb.append("AuthCodeUtil#getAuthenticationResult, key: ");
        sb.append(sPKey);
        sb.append(", isAuthenticated: ");
        sb.append(z);
        ACLog.d("IAPConnectPlugin", sb.toString());
        return z;
    }

    public static String getClientId() {
        OAuthConfig oAuthConfig = ACManager.getInstance().getOAuthConfig();
        return oAuthConfig == null ? "" : oAuthConfig.clientId;
    }

    public static String getSPKey(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(SP_KEY_PREF);
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("_");
        sb.append(str3);
        return sb.toString();
    }

    public static Map<String, String> getScopeConversionMap() {
        JSONObject jSONObject = (JSONObject) ConfigCenter.INSTANCE.getKeyOrDefault(CONFIG_KEY_GN_SCOPES_MAP, new JSONObject());
        StringBuilder sb = new StringBuilder();
        sb.append("AuthCodeUtil#getScopeConversionMap, get remote config: ");
        sb.append(jSONObject);
        ACLog.d("IAPConnectPlugin", sb.toString());
        Map<String, String> json2StringMap = Utils.json2StringMap(jSONObject);
        if (json2StringMap.isEmpty()) {
            json2StringMap = DEFAULT_SCOPE_CONVERSION_MAP;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AuthCodeUtil#getScopeConversionMap: ");
        sb2.append(json2StringMap);
        ACLog.d("IAPConnectPlugin", sb2.toString());
        return json2StringMap;
    }

    public static String removeAuthCode(String str, String str2) {
        String openId = SPIManager.getInstance().getOpenId();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("_");
        sb.append(openId);
        String obj = sb.toString();
        String remove = authCodeMap.remove(obj);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AuthCodeUtil#removeAuthCode, key: ");
        sb2.append(obj);
        sb2.append(", authCode: ");
        sb2.append(remove);
        ACLog.d("IAPConnectPlugin", sb2.toString());
        return remove;
    }

    public static void saveAuthCode(String str, String str2, String str3) {
        String openId = SPIManager.getInstance().getOpenId();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("_");
        sb.append(openId);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AuthCodeUtil#saveAuthCode, key: ");
        sb2.append(obj);
        sb2.append(", authCode: ");
        sb2.append(str3);
        ACLog.d("IAPConnectPlugin", sb2.toString());
        authCodeMap.put(obj, str3);
    }

    public static void saveAuthenticationResult(Context context, String str, String str2, boolean z) {
        String sPKey = getSPKey(str, str2, SPIManager.getInstance().getOpenId());
        StringBuilder sb = new StringBuilder();
        sb.append("AuthCodeUtil#saveAuthenticationResult, key: ");
        sb.append(sPKey);
        sb.append(", isAuthenticated: ");
        sb.append(z);
        ACLog.d("IAPConnectPlugin", sb.toString());
        SharedPreferences.Editor edit = context.getSharedPreferences("IAPConnectPlugin", 0).edit();
        edit.putBoolean(sPKey, z);
        edit.apply();
    }
}

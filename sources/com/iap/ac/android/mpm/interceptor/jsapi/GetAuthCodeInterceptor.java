package com.iap.ac.android.mpm.interceptor.jsapi;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.iap.android.wallet.acl.oauth.OAuthService;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.model.acl.AclMiniProgramMetaData;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.container.interceptor.BridgeCallback;
import com.iap.ac.android.common.container.interceptor.BridgeInterceptor;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.utils.EntryCodeData;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GetAuthCodeInterceptor implements BridgeInterceptor {
    private static final String AC_MERCHANT_ID = "merchantId";
    private static final String ERROR_AUTHCODE_EMPTY = "10";
    private static final String ERROR_AUTHCODE_EMPTY_MESSAGE = "Empty authCode";
    private static final String ERROR_PARAM_ILLEGAL_CODE = "2";
    private static final String ERROR_PARAM_ILLEGAL_MESSAGE = "Invalid parameter";
    private static final String KEY_AUTH_CODE = "authCode";
    private static final String PARAM_APP_ID = "appId";
    private static final String PARAM_SCOPE_NICKS = "scopeNicks";
    private static final String TAG = "GetAuthCodeInterceptor";
    private final String cnAcquireId = "1022088000000000001";

    @Override // com.iap.ac.android.common.container.interceptor.BridgeInterceptor
    public boolean willHandleJSAPI(String str, BridgeInterceptor.InterceptContext interceptContext, final BridgeCallback bridgeCallback) {
        JSONObject jSONObject = interceptContext.jsParameters;
        if (jSONObject == null) {
            sendResult(bridgeCallback, "2", "Invalid parameter");
            return true;
        } else if (!(jSONObject.opt("appId") instanceof String)) {
            sendResult(bridgeCallback, "2", "Invalid parameter");
            return true;
        } else {
            String optString = jSONObject.optString("appId");
            if (TextUtils.isEmpty(optString)) {
                sendResult(bridgeCallback, "2", "Invalid parameter");
                return true;
            }
            String clientId = getClientId();
            StringBuilder sb = new StringBuilder();
            sb.append("1022088000000000001_");
            sb.append(optString);
            String obj = sb.toString();
            ArrayList arrayList = new ArrayList();
            arrayList.add(OAuthService.SCOPE_BASE_USER_INFO);
            AclAPIContext createAclAPIContext = createAclAPIContext(interceptContext);
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            SPIManager.getInstance().getAuthCode(clientId, obj, arrayList, createAclAPIContext, new IAuthCallback() { // from class: com.iap.ac.android.mpm.interceptor.jsapi.GetAuthCodeInterceptor.1
                @Override // com.iap.ac.android.biz.common.callback.IAuthCallback
                public void onResult(AuthResult authResult) {
                    boolean z = (authResult == null || TextUtils.isEmpty(authResult.authCode)) ? false : true;
                    ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_GET_AUTHCODE).addParams("result", z ? "T" : LogConstants.RESULT_FALSE).addParams("timeCost", String.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)).addParams(LogConstants.KEY_TIME_STAPM, Long.valueOf(System.currentTimeMillis())).addParams("codeValue", EntryCodeData.getInstance().codeValue).addParams("authCode", z ? Integer.valueOf(authResult.authCode.hashCode()) : "").addParams(LogConstants.KEY_AUTH_METHOD, "JSAPI").addParams("scene", "entry_code").event();
                    if (authResult == null) {
                        GetAuthCodeInterceptor.this.sendResult(bridgeCallback, "10", "Empty authCode");
                    } else if (TextUtils.isEmpty(authResult.authCode)) {
                        GetAuthCodeInterceptor.this.sendResult(bridgeCallback, authResult.errorCode, authResult.errorMessage);
                    } else {
                        String str2 = authResult.authCode;
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("authCode", str2);
                        } catch (JSONException unused) {
                        }
                        BridgeCallback bridgeCallback2 = bridgeCallback;
                        if (bridgeCallback2 != null) {
                            bridgeCallback2.sendJSONResponse(jSONObject2);
                        }
                    }
                }
            });
            return true;
        }
    }

    private String getClientId() {
        OAuthConfig oAuthConfig = ACManager.getInstance().getOAuthConfig();
        return oAuthConfig == null ? "" : oAuthConfig.clientId;
    }

    private AclAPIContext createAclAPIContext(BridgeInterceptor.InterceptContext interceptContext) {
        return new AclAPIContext("AlipayConnect", new AclMiniProgramMetaData(interceptContext.miniProgramAppID, interceptContext.acParams != null ? interceptContext.acParams.optString("merchantId") : null), new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResult(BridgeCallback bridgeCallback, String str, String str2) {
        if (bridgeCallback != null) {
            bridgeCallback.sendJSONResponse(getError(str, str2));
        }
    }

    private JSONObject getError(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", str);
            jSONObject.put("errorMessage", str2);
        } catch (JSONException unused) {
            ACLog.e(TAG, "CallbackUtil#getError JSONException");
        }
        return jSONObject;
    }
}

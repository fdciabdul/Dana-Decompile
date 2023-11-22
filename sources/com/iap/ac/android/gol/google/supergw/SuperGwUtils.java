package com.iap.ac.android.gol.google.supergw;

import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.config.utils.ConfigUtils;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.gol.google.supergw.SuperGwRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class SuperGwUtils {
    private static final String GATEWAY_SECRET = "secret";
    public static final String KEY_AUTHENTICATION_RESPONSE = "gspAuthenticationResponse";
    private static final String KEY_MERCHANT_CLIENT_ID = "merchantClientId";
    private static final String MERCHANT_CLIENT_ID = "3200000A50000001";
    private static final String MERCHANT_ID = "2188400000001035";
    private static final String PREPARE_FUNCTION = "alipaynet.site.oauth.auth.extension.prepare";
    private static final String REQUEST_VERSION = "3.0.1";
    private static final String RESULT_CODE_OK = "00000000";
    private static final String SIGN_TYPE = "RSA";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());

    public static boolean parseResultInfo(SuperGwResultInfo superGwResultInfo) {
        return RESULT_CODE_OK.equals(superGwResultInfo.resultCodeId);
    }

    private static String getAuthSiteId() {
        CommonConfig commonConfig = ACManager.getInstance().getCommonConfig();
        if (commonConfig != null) {
            return commonConfig.pspId;
        }
        return null;
    }

    private static String getClientId() {
        OAuthConfig oAuthConfig = ACManager.getInstance().getOAuthConfig();
        if (oAuthConfig != null) {
            return oAuthConfig.clientId;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.iap.ac.android.gol.google.supergw.SuperGwPrepareRequestBody, U] */
    public static SuperGwRequest<SuperGwPrepareRequestBody> generatePrepareRequest(Map<String, String> map) {
        SuperGwRequest<SuperGwPrepareRequestBody> superGwRequest = new SuperGwRequest<>();
        SuperGwRequest.Request<T> request = new SuperGwRequest.Request<>();
        ?? superGwPrepareRequestBody = new SuperGwPrepareRequestBody();
        superGwPrepareRequestBody.authSiteId = getAuthSiteId();
        superGwPrepareRequestBody.merchantId = MERCHANT_ID;
        superGwPrepareRequestBody.merchantOriginalRequest = map;
        superGwPrepareRequestBody.extendInfo = ConfigUtils.toJson(new HashMap());
        SuperGwHead superGwHead = new SuperGwHead();
        superGwHead.version = REQUEST_VERSION;
        superGwHead.function = PREPARE_FUNCTION;
        superGwHead.clientId = getClientId();
        superGwHead.reqTime = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        superGwHead.clientSecret = GATEWAY_SECRET;
        superGwHead.reqMsgId = UUID.randomUUID().toString().replace("-", "");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_MERCHANT_CLIENT_ID, MERCHANT_CLIENT_ID);
            superGwHead.reserve = jSONObject.toString();
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("SuperGwUtils, json exception for head utils: ");
            sb.append(e);
            ACLog.e(Constants.TAG, sb.toString());
        }
        request.body = superGwPrepareRequestBody;
        request.head = superGwHead;
        superGwRequest.request = request;
        return superGwRequest;
    }
}

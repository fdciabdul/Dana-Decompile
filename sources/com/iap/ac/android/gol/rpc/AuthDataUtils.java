package com.iap.ac.android.gol.rpc;

import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.internal.config.utils.ConfigUtils;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.gol.google.supergw.SuperGwResultInfo;
import com.iap.ac.android.gol.rpc.request.AuthPrepareRequest;
import com.iap.ac.android.gol.rpc.request.AuthPrepareRequestBody;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class AuthDataUtils {
    private static final String KEY_MERCHANT_CLIENT_ID = "merchantClientId";
    private static final String MERCHANT_CLIENT_ID = "3200000A50000001";
    private static final String MERCHANT_ID = "2188400000001035";
    private static final String RESULT_CODE_OK = "00000000";
    private static final String TAG = "AuthDataUtils";

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

    public static AuthPrepareRequest generatePrepareRequest(Map<String, String> map) {
        AuthPrepareRequest authPrepareRequest = new AuthPrepareRequest();
        authPrepareRequest.clientId = getClientId();
        AuthPrepareRequestBody authPrepareRequestBody = new AuthPrepareRequestBody();
        authPrepareRequestBody.authSiteId = getAuthSiteId();
        authPrepareRequestBody.merchantId = MERCHANT_ID;
        authPrepareRequestBody.merchantOriginalRequest = map;
        authPrepareRequestBody.extendInfo = ConfigUtils.toJson(new HashMap());
        String json = ConfigUtils.toJson(authPrepareRequestBody);
        if (json == null) {
            ACLog.e(TAG, "GolGooglePrepareProcessor prepare error, null body");
            return authPrepareRequest;
        }
        authPrepareRequest.content = json;
        return authPrepareRequest;
    }
}

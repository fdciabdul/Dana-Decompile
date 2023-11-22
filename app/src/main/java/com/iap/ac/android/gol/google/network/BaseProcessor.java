package com.iap.ac.android.gol.google.network;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.http.HttpClient;
import com.iap.ac.android.biz.common.model.http.HttpMethod;
import com.iap.ac.android.biz.common.model.http.HttpRequest;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.gol.AlipayPlusClientAutoDebit;
import id.dana.data.constant.BranchLinkConstant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class BaseProcessor<Request, Response> {
    private static final int DEFAULT_TIMEOUT_MS = 5000;
    private static final String ENVTYPE_DEV = "DEV";
    private static final String ENVTYPE_PROD = "PROD";
    private static final String GOOGLE_TOPUP_GATEWAY_DEV = "http://alipayconnect.dl.alipaydev.com";
    private static final String GOOGLE_TOPUP_GATEWAY_PROD = "https://open-sea.alipayplus.com";
    protected static final String PATH_DECRYPT = "/api/open/common_json/extensions/prepareTopUpInfo";
    protected static final String PATH_ENCRYPT = "/api/open/common_json/extensions/finishTopUpInfo";
    protected HttpClient httpClient;
    protected HttpRequest httpRequest;

    abstract String getPath();

    public BaseProcessor(Context context) {
        this.httpClient = new HttpClient(false, context);
        HttpRequest httpRequest = new HttpRequest(getUrl(), HttpMethod.POST, null);
        this.httpRequest = httpRequest;
        httpRequest.timeoutMilliseconds = 5000;
        HashMap hashMap = new HashMap();
        hashMap.put("Client-Id", getClientId());
        hashMap.put(BranchLinkConstant.OauthParams.SIGNATURE, "algorithm=RSA256, keyVersion=2, signature=testing_signature");
        hashMap.put("Content-Type", "application/json");
        hashMap.put("request-time", getCurrentTime());
        this.httpRequest.headers = hashMap;
    }

    public Response execute(Request request, Class<Response> cls) {
        this.httpRequest.data = JsonUtils.toJson(request);
        try {
            return (Response) JsonUtils.fromJson(new JSONObject(new String(this.httpClient.newCall(this.httpRequest).execute().data)), cls);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getClientId() {
        String clientId = AlipayPlusClientAutoDebit.getInstance().getClientId();
        if (TextUtils.isEmpty(clientId)) {
            OAuthConfig oAuthConfig = ACManager.getInstance().getOAuthConfig();
            if (oAuthConfig != null) {
                return oAuthConfig.clientId;
            }
            return null;
        }
        return clientId;
    }

    private String getUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(getGateWay());
        sb.append(getPath());
        return sb.toString();
    }

    private String getGateWay() {
        String envType = AlipayPlusClientAutoDebit.getInstance().getEnvType();
        if (TextUtils.isEmpty(envType)) {
            return GOOGLE_TOPUP_GATEWAY_PROD;
        }
        envType.hashCode();
        if (envType.equals("DEV")) {
            return GOOGLE_TOPUP_GATEWAY_DEV;
        }
        envType.equals("PROD");
        return GOOGLE_TOPUP_GATEWAY_PROD;
    }

    private String getCurrentTime() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }
}

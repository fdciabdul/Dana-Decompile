package com.iap.ac.android.gol.google.network;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.http.HttpClient;
import com.iap.ac.android.biz.common.internal.config.utils.ConfigUtils;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.model.http.HttpMethod;
import com.iap.ac.android.biz.common.model.http.HttpRequest;
import com.iap.ac.android.biz.common.model.http.HttpResponse;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.gol.google.supergw.SuperGwExtendInfo;
import com.iap.ac.android.gol.google.supergw.SuperGwPrepareResponse;
import com.iap.ac.android.gol.google.supergw.SuperGwUtils;
import java.util.Map;

/* loaded from: classes8.dex */
public class GolGooglePrepareProcessor {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_TYPE_JSON = "application/json";
    private static final String KEY_AUTHENTICATION_RESPONSE = "gspAuthenticationResponse";
    private static final String KEY_CALLBACK_URL = "gspCallbackUrl";
    CommonConfig config = ACManager.getInstance().getCommonConfig();
    private Context mContext;
    HttpClient mHttpClient;

    public GolGooglePrepareProcessor(Context context) {
        this.mContext = context;
        this.mHttpClient = new HttpClient(false, context);
    }

    public GolGooglePrepareResponse prepare(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("GolGooglePrepareProcessor prepare begin: ");
        sb.append(map);
        ACLog.i(Constants.TAG, sb.toString());
        String json = ConfigUtils.toJson(SuperGwUtils.generatePrepareRequest(map));
        if (json == null) {
            reportError("GolGooglePrepareProcessor prepare error, null body");
            return null;
        }
        HttpRequest httpRequest = new HttpRequest(getGatewayUrl(), HttpMethod.POST, json);
        httpRequest.addHeader("Content-Type", "application/json");
        try {
            HttpResponse execute = this.mHttpClient.newCall(httpRequest).execute();
            if (isSuccess(execute)) {
                SuperGwPrepareResponse superGwPrepareResponse = (SuperGwPrepareResponse) ConfigUtils.fromJson(new String(execute.data), SuperGwPrepareResponse.class);
                GolGooglePrepareResponse parseResponse = parseResponse(superGwPrepareResponse);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("GolGooglePrepareProcessor prepare response: ");
                sb2.append(superGwPrepareResponse);
                sb2.append(", callbackUrl: ");
                sb2.append(parseResponse == null ? "" : parseResponse.authUrl);
                ACLog.i(Constants.TAG, sb2.toString());
                if (parseResponse == null || TextUtils.isEmpty(parseResponse.authUrl)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("callback url from server is empty: ");
                    sb3.append(superGwPrepareResponse);
                    reportError(sb3.toString());
                }
                return parseResponse;
            }
        } catch (Throwable th) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("GolGooglePrepareProcessor prepare exception,  errorCode is: ");
            sb4.append(th);
            reportError(sb4.toString());
        }
        return null;
    }

    private void reportError(String str) {
        ACLog.i(Constants.TAG, str);
    }

    private String getGatewayUrl() {
        return this.config.golGoogleUrl;
    }

    public boolean isSuccess(HttpResponse httpResponse) {
        return (httpResponse == null || httpResponse.statusCode != 200 || httpResponse.data == null) ? false : true;
    }

    private static GolGooglePrepareResponse parseResponse(SuperGwPrepareResponse superGwPrepareResponse) {
        if (superGwPrepareResponse == null || superGwPrepareResponse.response == null || superGwPrepareResponse.response.body == null || !SuperGwUtils.parseResultInfo(superGwPrepareResponse.response.body.resultInfo) || superGwPrepareResponse.response.body.merchantAuthenticationResponse == null) {
            return null;
        }
        Map<String, String> map = superGwPrepareResponse.response.body.merchantAuthenticationResponse;
        String str = superGwPrepareResponse.response.body.extendInfo;
        SuperGwExtendInfo superGwExtendInfo = str != null ? (SuperGwExtendInfo) ConfigUtils.fromJson(str, SuperGwExtendInfo.class) : null;
        GolGooglePrepareResponse golGooglePrepareResponse = new GolGooglePrepareResponse();
        golGooglePrepareResponse.authUrl = superGwExtendInfo != null ? superGwExtendInfo.authUrl : null;
        golGooglePrepareResponse.gspAuthenticationResponse = map.get("gspAuthenticationResponse");
        return golGooglePrepareResponse;
    }
}

package com.alipay.mobile.verifyidentity.http;

import com.alipay.mobile.verifyidentity.base.message.MessageConstants;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICInitRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HttpGetTaskUtil {
    private static String TAG = "HttpTaskUtil";
    public static String Test_IP = "30.50.146.97";
    private static String initUrl;
    private static String verifyUrl;
    private static String viewUrl;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(Test_IP);
        sb.append(":7088/mgw.htm?operationType=alipay.ap.risk.authentication.initVerifyTask");
        initUrl = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("http://");
        sb2.append(Test_IP);
        sb2.append(":7088/mgw.htm?operationType=alipay.ap.risk.authentication.view");
        viewUrl = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("http://");
        sb3.append(Test_IP);
        sb3.append(":7088/mgw.htm?operationType=alipay.ap.risk.authentication.view");
        verifyUrl = sb3.toString();
    }

    public static void setIp() {
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(Test_IP);
        sb.append(":7088/mgw.htm?operationType=alipay.ap.risk.authentication.initVerifyTask");
        initUrl = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("http://");
        sb2.append(Test_IP);
        sb2.append(":7088/mgw.htm?operationType=alipay.ap.risk.authentication.view");
        viewUrl = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("http://");
        sb3.append(Test_IP);
        sb3.append(":7088/mgw.htm?operationType=alipay.ap.risk.authentication.view");
        verifyUrl = sb3.toString();
    }

    public static MICRpcResponse getHttpResponse(MICRpcRequest mICRpcRequest) {
        if (mICRpcRequest instanceof MICInitRequest) {
            String buildInitReQuestJson = buildInitReQuestJson(mICRpcRequest);
            StringBuilder sb = new StringBuilder();
            sb.append(initUrl);
            sb.append("&requestData=[");
            sb.append(buildInitReQuestJson);
            sb.append("]");
            return getHttpTask(sb.toString());
        } else if (mICRpcRequest.action.equals(RequestConstants.VIEW)) {
            String buildRequest = buildRequest(mICRpcRequest);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(viewUrl);
            sb2.append("&requestData=[");
            sb2.append(buildRequest);
            sb2.append("]");
            return getHttpTask(sb2.toString());
        } else if (mICRpcRequest.action.equals(RequestConstants.VERIFY)) {
            String buildRequest2 = buildRequest(mICRpcRequest);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(verifyUrl);
            sb3.append("&requestData=[");
            sb3.append(buildRequest2);
            sb3.append("]");
            return getHttpTask(sb3.toString());
        } else {
            return null;
        }
    }

    private static String buildRequest(MICRpcRequest mICRpcRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", mICRpcRequest.action);
            jSONObject.put("module", mICRpcRequest.module);
            jSONObject.put("verifyId", mICRpcRequest.verifyId);
            jSONObject.put("data", mICRpcRequest.data);
            StringBuilder sb = new StringBuilder();
            sb.append(" requestData  ");
            sb.append(jSONObject.toString());
            InstrumentInjector.log_e("king", sb.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public static String buildInitReQuestJson(MICRpcRequest mICRpcRequest) {
        if (mICRpcRequest instanceof MICInitRequest) {
            MICInitRequest mICInitRequest = (MICInitRequest) mICRpcRequest;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isDisplaySensitiveField", 0);
                MICInitRequest mICInitRequest2 = mICInitRequest;
                jSONObject.put("sceneId", mICInitRequest.sceneId);
                MICInitRequest mICInitRequest3 = mICInitRequest;
                jSONObject.put("bizId", mICInitRequest.bizId);
                MICInitRequest mICInitRequest4 = mICInitRequest;
                jSONObject.put("externParams", new JSONObject(mICInitRequest.externParams));
                return jSONObject.toString();
            } catch (JSONException unused) {
                return "";
            }
        }
        return "";
    }

    private static MICRpcResponse getHttpTask(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection())));
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                    } else {
                        inputStream.close();
                        bufferedReader.close();
                        httpURLConnection.disconnect();
                        return parseJson(stringBuffer.toString());
                    }
                }
            } else {
                InstrumentInjector.log_d("TAG", "ERROR CONNECTED");
                return null;
            }
        } catch (MalformedURLException | IOException unused) {
            return null;
        }
    }

    private static MICRpcResponse parseJson(String str) {
        MICRpcResponse mICRpcResponse = new MICRpcResponse();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("result");
            mICRpcResponse.success = true;
            mICRpcResponse.sysErrCode = optJSONObject.getString("sysErrCode");
            mICRpcResponse.verifyCode = optJSONObject.getString(MessageConstants.KEY_VERIFYCODE);
            mICRpcResponse.verifyMessage = optJSONObject.getString(MessageConstants.KEY_VERIFYMESSAGE);
            mICRpcResponse.verifySuccess = optJSONObject.optBoolean("success");
            mICRpcResponse.finish = optJSONObject.optBoolean("finish");
            if (optJSONObject.has("verifyId")) {
                mICRpcResponse.verifyId = optJSONObject.optString("verifyId");
            }
            if (optJSONObject.has("method")) {
                mICRpcResponse.nextStep = optJSONObject.optString("method");
            } else if (optJSONObject.has(MessageConstants.KEY_NEXTSTEP)) {
                mICRpcResponse.nextStep = optJSONObject.optString(MessageConstants.KEY_NEXTSTEP);
            }
            if (optJSONObject.has("data")) {
                mICRpcResponse.data = optJSONObject.getString("data");
            }
            if (optJSONObject.has("isFinish")) {
                mICRpcResponse.finish = optJSONObject.optBoolean("isFinish");
            }
        } catch (Exception unused) {
        }
        return mICRpcResponse;
    }
}

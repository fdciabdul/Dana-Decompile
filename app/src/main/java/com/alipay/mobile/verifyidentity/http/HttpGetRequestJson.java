package com.alipay.mobile.verifyidentity.http;

import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICInitRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import id.dana.data.constant.BranchLinkConstant;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class HttpGetRequestJson {
    public static String buildInitReQuestJson(MICRpcRequest mICRpcRequest) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("head", getHeadData(mICRpcRequest));
            jSONObject2.put("body", getInitBodyData(mICRpcRequest));
            jSONObject.put("request", jSONObject2);
            jSONObject.put(BranchLinkConstant.OauthParams.SIGNATURE, "signature string");
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String buildVerifyRequestJson(MICRpcRequest mICRpcRequest) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("head", getHeadData(mICRpcRequest));
            jSONObject2.put("body", getVerifyBodyData(mICRpcRequest));
            jSONObject.put("request", jSONObject2);
            jSONObject.put(BranchLinkConstant.OauthParams.SIGNATURE, "signature string");
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private static JSONObject getHeadData(MICRpcRequest mICRpcRequest) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("reqTime", getISO8601Timestamp());
        jSONObject.put("reqMsgId", UUID.randomUUID().toString());
        jSONObject.put("clientId", "2018040508184500175622");
        jSONObject.put("clientSecret", "HNkkbmqyXD2IWyO1QhObMCWDWnSLfqTA");
        jSONObject.put("version", "fixed-a");
        if (mICRpcRequest instanceof MICInitRequest) {
            jSONObject.put("function", "alipayplus.risk.identify.doInit");
        } else if (mICRpcRequest.action.equals(RequestConstants.VIEW)) {
            jSONObject.put("function", "alipayplus.risk.identify.doView");
            jSONObject.put("accessToken", "234567a");
        } else if (mICRpcRequest.action.equals(RequestConstants.VERIFY)) {
            jSONObject.put("function", "alipayplus.risk.identify.doVerify");
            jSONObject.put("accessToken", "234567a");
        }
        return jSONObject;
    }

    private static JSONObject getInitBodyData(MICRpcRequest mICRpcRequest) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (mICRpcRequest instanceof MICInitRequest) {
            MICInitRequest mICInitRequest = (MICInitRequest) mICRpcRequest;
            jSONObject.put("sceneId", "BANK_TEST");
            jSONObject.put("bizId", mICInitRequest.bizId);
            jSONObject.put("userId", mICInitRequest.externParams.get("userId"));
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(mICInitRequest.action);
            sb.append("]");
            jSONObject.put("verificationMethods", new JSONArray(sb.toString()));
            jSONObject.put("envInfo", new JSONObject().put("websiteLanguage", "en-IN"));
        } else {
            jSONObject.put("method", mICRpcRequest.module);
            jSONObject.put("verifyId", mICRpcRequest.verifyId);
        }
        return jSONObject;
    }

    private static JSONObject getVerifyBodyData(MICRpcRequest mICRpcRequest) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("verifyId", mICRpcRequest.verifyId);
        jSONObject.put("method", mICRpcRequest.module);
        jSONObject.put("validateData", new JSONObject(mICRpcRequest.data));
        return jSONObject;
    }

    public static String getISO8601Timestamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'+'HH:mm");
        simpleDateFormat.setTimeZone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("UTC"));
        return simpleDateFormat.format(new Date());
    }
}

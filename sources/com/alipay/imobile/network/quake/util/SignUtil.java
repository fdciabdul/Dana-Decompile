package com.alipay.imobile.network.quake.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.Request;
import com.alipay.imobile.network.quake.exception.ClientException;
import com.alipay.mobile.common.rpc.RpcException;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class SignUtil {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7076a;

    /* loaded from: classes3.dex */
    public static class SignInfo {
        public String appKey;
        public String authCode;

        public SignInfo() {
        }

        public SignInfo(String str, String str2) {
            this.appKey = str;
            this.authCode = str2;
        }
    }

    public static void a() {
        try {
            Class<?> cls = Class.forName(SecurityConstants.SG_CLASS);
            Class<?> cls2 = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent");
            if (cls == null || cls2 == null) {
                return;
            }
            f7076a = true;
        } catch (Exception unused) {
            LoggerWrapper.w(Quake.TAG, "could not find security guard dependence, ignore trace stack");
        }
    }

    public static String a(Request request, Context context, SignInfo signInfo) throws RpcException {
        if (f7076a) {
            if (request != null) {
                if (context != null) {
                    if (signInfo != null && !TextUtils.isEmpty(signInfo.appKey)) {
                        byte[] serialize = request.getProtocol().serialize(request);
                        if (serialize == null) {
                            return "";
                        }
                        String url = request.getUrl();
                        String a2 = c.a();
                        StringBuilder sb = new StringBuilder();
                        String actionType = request.getActionType();
                        if (actionType == null) {
                            String str = Quake.TAG;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("getSignData with null operationType and url is ");
                            sb2.append(url);
                            LoggerWrapper.d(str, sb2.toString());
                        } else {
                            sb.append("operationType");
                            sb.append("=");
                            sb.append(actionType);
                            sb.append(ContainerUtils.FIELD_DELIMITER);
                        }
                        sb.append("requestData");
                        sb.append("=");
                        sb.append(Base64.encodeToString(serialize, 2));
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                        sb.append("ts");
                        sb.append("=");
                        sb.append(a2);
                        return a(context, signInfo, e.d(url), sb.toString());
                    }
                    LoggerWrapper.w(Quake.TAG, "the appkey is empty, will not do signing.");
                    return "";
                }
                throw new ClientException((Integer) 0, "the input context can not be null");
            }
            throw new ClientException((Integer) 0, "the input request can not be null");
        }
        return "";
    }

    public static String a(Context context, SignInfo signInfo, String str, String str2) {
        if (f7076a && !TextUtils.isEmpty(str2)) {
            if (signInfo == null || TextUtils.isEmpty(signInfo.appKey)) {
                LoggerWrapper.w(Quake.TAG, "the appkey is empty, will not do signing.");
                return "";
            } else if (context != null) {
                return a(context, signInfo, e.d(str), str2);
            } else {
                throw new ClientException((Integer) 0, "the input context can not be null");
            }
        }
        return "";
    }

    private static String a(Context context, SignInfo signInfo, boolean z, String str) {
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            if (securityGuardManager == null) {
                LoggerWrapper.w(Quake.TAG, "request data sign fail, sgMng is null");
                return "";
            }
            ISecureSignatureComponent secureSignatureComp = securityGuardManager.getSecureSignatureComp();
            if (secureSignatureComp == null) {
                LoggerWrapper.w(Quake.TAG, "request data sign fail, ssComp is null");
                return "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("INPUT", str);
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            a(securityGuardParamContext, signInfo.appKey, z, context);
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 4;
            String str2 = signInfo.authCode;
            if (str2 == null) {
                str2 = "";
            }
            LoggerWrapper.v(Quake.TAG, String.format("Before security sign. appKey = %s, authCode = %s", signInfo.appKey, str2));
            String signRequest = secureSignatureComp.signRequest(securityGuardParamContext, str2);
            LoggerWrapper.v(Quake.TAG, String.format("Get security signed string: %s. appKey = %s, authCode = %s", signRequest, signInfo.appKey, str2));
            return signRequest;
        } catch (Exception e) {
            LoggerWrapper.e(Quake.TAG, "signature FAILED", e);
            return "";
        }
    }

    private static void a(SecurityGuardParamContext securityGuardParamContext, String str, boolean z, Context context) {
        boolean b;
        try {
            if (!TextUtils.isEmpty(str)) {
                securityGuardParamContext.appKey = str;
                if (b) {
                    return;
                }
                return;
            }
            if (z) {
                securityGuardParamContext.appKey = "rpc-sdk-online";
            } else {
                securityGuardParamContext.appKey = "rpc-sdk";
            }
            if (e.b(context)) {
                String str2 = Quake.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("appKey:");
                sb.append(securityGuardParamContext.appKey);
                LoggerWrapper.v(str2, sb.toString());
            }
        } finally {
            if (e.b(context)) {
                String str3 = Quake.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("appKey:");
                sb2.append(securityGuardParamContext.appKey);
                LoggerWrapper.v(str3, sb2.toString());
            }
        }
    }
}

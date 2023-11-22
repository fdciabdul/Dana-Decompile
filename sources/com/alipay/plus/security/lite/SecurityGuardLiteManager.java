package com.alipay.plus.security.lite;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.plus.security.lite.a.a;
import com.alipay.plus.security.lite.b.c;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class SecurityGuardLiteManager implements ISecurityGuardLiteManager {
    public static final Map<String, ISecurityGuardLiteManager> c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final SecurityGuardLiteNative f7404a;
    public a b;

    public SecurityGuardLiteManager(Context context, String str) throws SecLiteException {
        SecurityGuardLiteNative securityGuardLiteNative = new SecurityGuardLiteNative();
        this.f7404a = securityGuardLiteNative;
        String b = c.b(context);
        String a2 = com.alipay.plus.security.lite.b.a.a(context, str, "");
        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(a2)) {
            int init = securityGuardLiteNative.init(str, b, a2);
            if (init != 0) {
                throw new SecLiteException(init);
            }
            return;
        }
        throw new SecLiteException("error apiKey or sign", (int) SecLiteException.ERROR_API_KEY_OR_SIGN);
    }

    public static ISecurityGuardLiteManager getInstance(Context context, String str) throws SecLiteException {
        Map<String, ISecurityGuardLiteManager> map = c;
        if (map.get(str) == null) {
            synchronized (SecurityGuardLiteManager.class) {
                if (map.get(str) == null) {
                    map.put(str, new SecurityGuardLiteManager(context, str));
                }
            }
        }
        return map.get(str);
    }

    @Override // com.alipay.plus.security.lite.ISecurityGuardLiteManager
    public String decrypt(String str) throws SecLiteException {
        if (!TextUtils.isEmpty(str)) {
            return this.b.a(str);
        }
        throw SecLiteException.ENCRYPT_PARAMS_ERROR;
    }

    @Override // com.alipay.plus.security.lite.ISecurityGuardLiteManager
    public String encrypt(String str) throws SecLiteException {
        if (!TextUtils.isEmpty(str)) {
            return this.b.b(str);
        }
        throw SecLiteException.ENCRYPT_PARAMS_ERROR;
    }

    @Override // com.alipay.plus.security.lite.ISecurityGuardLiteManager
    public String signRequest(SecurityGuardLiteParamContext securityGuardLiteParamContext, String str) throws SecLiteException {
        Map<String, String> map = securityGuardLiteParamContext.paramMap;
        if (map != null && map.containsKey("INPUT")) {
            if (!TextUtils.isEmpty(securityGuardLiteParamContext.appKey)) {
                return this.f7404a.signRequest(str, securityGuardLiteParamContext.paramMap.get("INPUT"), securityGuardLiteParamContext.appKey, securityGuardLiteParamContext.requestType);
            }
            throw new SecLiteException("authCode is null", -100);
        }
        throw new SecLiteException(HummerZCodeConstant.CONTEXT_ERROR_MSG, -100);
    }

    public static ISecurityGuardLiteManager getInstance(Context context) throws SecLiteException {
        Map<String, ISecurityGuardLiteManager> map = c;
        if (map.get("") == null) {
            synchronized (SecurityGuardLiteManager.class) {
                if (map.get("") == null) {
                    map.put("", new SecurityGuardLiteManager(context));
                }
            }
        }
        return map.get("");
    }

    public SecurityGuardLiteManager(Context context) throws SecLiteException {
        if (context != null) {
            SecurityGuardLiteNative securityGuardLiteNative = new SecurityGuardLiteNative();
            this.f7404a = securityGuardLiteNative;
            this.b = new a(context, securityGuardLiteNative);
            return;
        }
        throw SecLiteException.ENCRYPT_PARAMS_ERROR;
    }
}

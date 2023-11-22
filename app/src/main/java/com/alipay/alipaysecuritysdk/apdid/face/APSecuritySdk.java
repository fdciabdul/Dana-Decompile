package com.alipay.alipaysecuritysdk.apdid.face;

import android.content.Context;
import com.alipay.alipaysecuritysdk.apdid.a.a;
import com.alipay.alipaysecuritysdk.apdid.face.Configuration;
import com.alipay.alipaysecuritysdk.apdid.g.d;
import com.alipay.alipaysecuritysdk.common.c.b;
import com.alipay.alipaysecuritysdk.common.e.c;
import com.alipay.alipaysecuritysdk.common.e.e;
import com.alipay.alipaysecuritysdk.common.e.f;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class APSecuritySdk {
    public static final String KEY_ENCODE_UMID = "encodeUmid";
    public static final String KEY_TID = "tid";
    public static final String KEY_USER_ID = "userId";
    public static final String KEY_UTDID = "utdid";
    private static APSecuritySdk mInstance;
    private Context mContext;
    private boolean mInited = false;

    /* loaded from: classes3.dex */
    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    private APSecuritySdk(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("APSecuritySdk initialization error: mContext is null.");
        }
        this.mContext = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (mInstance == null) {
            synchronized (APSecuritySdk.class) {
                if (mInstance == null) {
                    mInstance = new APSecuritySdk(context);
                }
            }
        }
        return mInstance;
    }

    public void setConfiguration(Configuration configuration) {
        StringBuilder sb = new StringBuilder("set local: ");
        sb.append(configuration.locale);
        sb.append(", gateway:");
        sb.append(configuration.gateway);
        sb.append(", env:");
        sb.append(configuration.envMode);
        b.a("SEC_SDK-apdid", sb.toString());
        a.a(configuration);
    }

    public void setConfiguration(Configuration.Locale locale, int i) {
        StringBuilder sb = new StringBuilder("set local: ");
        sb.append(locale);
        sb.append(", env:");
        sb.append(i);
        b.a("SEC_SDK-apdid", sb.toString());
        a.a(Configuration.getConfiguration(locale, i));
    }

    public void initToken(Map<String, String> map, InitResultListener initResultListener) {
        baseInitToken(map, false, initResultListener);
    }

    public void updateToken(Map<String, String> map, InitResultListener initResultListener) {
        baseInitToken(map, true, initResultListener);
    }

    private void baseInitToken(Map<String, String> map, final boolean z, final InitResultListener initResultListener) {
        b.a("SEC_SDK-apdid", "start init sec token -> APSecuritySdk");
        a.b();
        final long currentTimeMillis = System.currentTimeMillis();
        this.mInited = true;
        String a2 = c.a(map, "tid");
        String a3 = c.a(map, "utdid");
        String a4 = c.a(map, "userId");
        String a5 = c.a(map, KEY_ENCODE_UMID);
        if (e.c(a3)) {
            a3 = com.alipay.alipaysecuritysdk.apdid.f.b.a(this.mContext);
        }
        final HashMap hashMap = new HashMap(8);
        hashMap.put("utdid", a3);
        hashMap.put("tid", a2);
        hashMap.put("userId", a4);
        hashMap.put("appName", "");
        hashMap.put("appKeyClient", "");
        hashMap.put("appchannel", "");
        hashMap.put("rpcVersion", "");
        hashMap.put(KEY_ENCODE_UMID, a5);
        f.a().a(new Runnable() { // from class: com.alipay.alipaysecuritysdk.apdid.face.APSecuritySdk.1
            @Override // java.lang.Runnable
            public void run() {
                int a6 = new com.alipay.alipaysecuritysdk.apdid.d.a(APSecuritySdk.this.mContext).a(hashMap, z);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(APSecuritySdk.this.getTokenResult());
                }
                StringBuilder sb = new StringBuilder("callback finished, return code:");
                sb.append(a6);
                b.a("SEC_SDK-apdid", sb.toString());
                com.alipay.alipaysecuritysdk.common.c.a.a("client_init", "callback_time", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        });
        b.a("SEC_SDK-apdid", "initToken finished, waiting for callback.");
        com.alipay.alipaysecuritysdk.common.c.a.a("client_init", "ent_time", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public String getApdidToken() {
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = com.alipay.alipaysecuritysdk.apdid.d.a.a(this.mContext, "");
        if (e.c(a2) || !this.mInited) {
            b.a("SEC_SDK-apdid", "token in cache is null, recall init");
            try {
                initToken(null, null);
            } catch (Exception e) {
                b.a("SEC_SDK-apdid", "recall init error", e);
            }
        }
        StringBuilder sb = new StringBuilder("apdidToken:  ");
        sb.append(a2);
        b.a("SEC_SDK-apdid", sb.toString());
        com.alipay.alipaysecuritysdk.common.c.a.a("client_token", "string_time", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return a2;
    }

    public TokenResult getTokenResult() {
        TokenResult tokenResult;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            tokenResult = new TokenResult();
            try {
                tokenResult.apdidToken = com.alipay.alipaysecuritysdk.apdid.d.a.a(this.mContext, "");
                tokenResult.clientKey = com.alipay.alipaysecuritysdk.apdid.c.b.a(this.mContext);
                tokenResult.apdid = com.alipay.alipaysecuritysdk.apdid.d.a.a(this.mContext);
                if (e.c(tokenResult.apdid) || e.c(tokenResult.apdidToken) || e.c(tokenResult.clientKey)) {
                    b.a("SEC_SDK-apdid", "token in cache is null, recall init");
                    try {
                        initToken(null, null);
                    } catch (Exception e) {
                        b.a("SEC_SDK-apdid", "recall init error", e);
                    }
                }
                if (e.c(tokenResult.apdid)) {
                    tokenResult.apdid = d.f(this.mContext);
                }
                if (a.a().needUmid) {
                    tokenResult.umidToken = com.alipay.alipaysecuritysdk.apdid.f.a.a(this.mContext);
                }
            } catch (Throwable th) {
                b.a("SEC_SDK-apdid", th);
            }
            StringBuilder sb = new StringBuilder("apdidToken:  ");
            sb.append(tokenResult.apdidToken);
            b.a("SEC_SDK-apdid", sb.toString());
            StringBuilder sb2 = new StringBuilder("apdid:       ");
            sb2.append(tokenResult.apdid);
            b.a("SEC_SDK-apdid", sb2.toString());
            StringBuilder sb3 = new StringBuilder("clientKey:   ");
            sb3.append(tokenResult.clientKey);
            b.a("SEC_SDK-apdid", sb3.toString());
            StringBuilder sb4 = new StringBuilder("umidToken:   ");
            sb4.append(tokenResult.umidToken);
            b.a("SEC_SDK-apdid", sb4.toString());
            com.alipay.alipaysecuritysdk.common.c.a.a("client_token", "object_time", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return tokenResult;
    }

    /* loaded from: classes3.dex */
    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }
}

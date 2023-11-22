package com.alipay.alipaysecuritysdk.apdid.face;

import android.content.Context;
import com.alipay.alipaysecuritysdk.apdid.d.a;
import com.alipay.alipaysecuritysdk.apdid.f.b;
import com.alipay.alipaysecuritysdk.common.e.e;
import com.alipay.alipaysecuritysdk.common.e.f;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class TMNTokenClient {
    private static TMNTokenClient tmnTokenClientIns;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface InitResultListener {
        void onResult(String str, int i);
    }

    private TMNTokenClient(Context context) {
        this.mContext = null;
        if (context == null) {
            throw new IllegalArgumentException("TMNTokenClient initialization error: mContext is null.");
        }
        this.mContext = context;
    }

    public static TMNTokenClient getInstance(Context context) {
        if (tmnTokenClientIns == null) {
            synchronized (TMNTokenClient.class) {
                if (tmnTokenClientIns == null) {
                    tmnTokenClientIns = new TMNTokenClient(context);
                }
            }
        }
        return tmnTokenClientIns;
    }

    public void intiToken(final String str, String str2, String str3, final InitResultListener initResultListener) {
        if (e.c(str) && initResultListener != null) {
            initResultListener.onResult("", 2);
        }
        if (e.c(str2) && initResultListener != null) {
            initResultListener.onResult("", 3);
        }
        final HashMap hashMap = new HashMap(8);
        hashMap.put("utdid", b.a(this.mContext));
        hashMap.put("tid", "");
        hashMap.put("userId", "");
        hashMap.put("appName", str);
        hashMap.put("appKeyClient", str2);
        hashMap.put("appchannel", "openapi");
        hashMap.put("sessionId", str3);
        hashMap.put("rpcVersion", "");
        f.a().a(new Runnable() { // from class: com.alipay.alipaysecuritysdk.apdid.face.TMNTokenClient.1
            @Override // java.lang.Runnable
            public void run() {
                int a2 = new a(TMNTokenClient.this.mContext).a(hashMap, false);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 == null) {
                    return;
                }
                if (a2 == 0) {
                    initResultListener.onResult(a.a(TMNTokenClient.this.mContext, str), 0);
                    return;
                }
                initResultListener2.onResult("", a2);
            }
        });
    }
}

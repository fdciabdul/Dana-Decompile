package com.alipay.alipaysecuritysdk.apdid.e;

import android.content.Context;
import com.alipay.alipaysecuritysdk.apdid.face.APSecuritySdk;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b {
    public static Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (b.class) {
            hashMap = new HashMap(10);
            String a2 = com.alipay.alipaysecuritysdk.common.e.c.a(map, "tid");
            String a3 = com.alipay.alipaysecuritysdk.common.e.c.a(map, "utdid");
            String a4 = com.alipay.alipaysecuritysdk.common.e.c.a(map, "userId");
            String a5 = com.alipay.alipaysecuritysdk.common.e.c.a(map, "appName");
            String a6 = com.alipay.alipaysecuritysdk.common.e.c.a(map, "appKeyClient");
            String a7 = com.alipay.alipaysecuritysdk.common.e.c.a(map, "tmxSessionId");
            String a8 = com.alipay.alipaysecuritysdk.common.e.c.a(map, "sessionId");
            String a9 = com.alipay.alipaysecuritysdk.common.e.c.a(map, APSecuritySdk.KEY_ENCODE_UMID);
            String a10 = com.alipay.alipaysecuritysdk.common.e.c.a(map, "forceReport");
            String f = com.alipay.alipaysecuritysdk.apdid.g.d.f(context);
            hashMap.put("AC1", a2);
            hashMap.put("AC2", a3);
            hashMap.put("AC3", "");
            hashMap.put("AC4", f);
            hashMap.put("AC5", a4);
            hashMap.put("AC6", a7);
            hashMap.put("AC7", com.alipay.alipaysecuritysdk.apdid.c.b.a(context));
            hashMap.put("AC8", a5);
            hashMap.put("AC9", a6);
            hashMap.put("AC10", a8);
            hashMap.put("AC13", a10);
            hashMap.put("AC14", a9);
        }
        return hashMap;
    }
}

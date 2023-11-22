package com.alipay.alipaysecuritysdk.apdid.e;

import android.content.Context;
import com.alipay.alipaysecuritysdk.apdid.bridge.JNIBridge;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a {
    public static Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (a.class) {
            String a2 = com.alipay.alipaysecuritysdk.common.e.c.a(map, "appchannel");
            hashMap = new HashMap(5);
            hashMap.put("AA1", context.getPackageName());
            hashMap.put("AA2", com.alipay.alipaysecuritysdk.common.collector.a.a(context));
            StringBuilder sb = new StringBuilder("APPSecuritySDK-");
            sb.append(com.alipay.alipaysecuritysdk.apdid.a.a.a().locale.getName());
            hashMap.put("AA3", sb.toString());
            hashMap.put("AA4", "P5.0.6.20200506");
            hashMap.put("AA6", a2);
            hashMap.put("AA13", JNIBridge.getNativeProp(context, "AA13", null));
        }
        return hashMap;
    }
}

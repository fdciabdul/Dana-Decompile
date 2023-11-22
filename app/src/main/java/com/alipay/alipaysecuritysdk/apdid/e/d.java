package com.alipay.alipaysecuritysdk.apdid.e;

import android.content.Context;
import com.alipay.alipaysecuritysdk.apdid.bridge.JNIBridge;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class d {
    public static Map<String, String> a(Context context) {
        HashMap hashMap;
        synchronized (d.class) {
            hashMap = new HashMap(18);
            hashMap.put("AE1", com.alipay.alipaysecuritysdk.common.collector.c.a());
            hashMap.put("AE2", com.alipay.alipaysecuritysdk.common.collector.c.b() ? "1" : "0");
            hashMap.put("AE3", com.alipay.alipaysecuritysdk.common.collector.c.a(context) ? "1" : "0");
            hashMap.put("AE4", com.alipay.alipaysecuritysdk.common.collector.c.c());
            hashMap.put("AE5", com.alipay.alipaysecuritysdk.common.collector.c.d());
            hashMap.put("AE6", com.alipay.alipaysecuritysdk.common.collector.c.e());
            hashMap.put("AE7", com.alipay.alipaysecuritysdk.common.collector.c.f());
            hashMap.put("AE8", com.alipay.alipaysecuritysdk.common.collector.c.g());
            hashMap.put("AE9", com.alipay.alipaysecuritysdk.common.collector.c.h());
            hashMap.put("AE10", com.alipay.alipaysecuritysdk.common.collector.c.i());
            hashMap.put("AE11", com.alipay.alipaysecuritysdk.common.collector.c.j());
            hashMap.put("AE12", com.alipay.alipaysecuritysdk.common.collector.c.k());
            hashMap.put("AE13", com.alipay.alipaysecuritysdk.common.collector.c.l());
            hashMap.put("AE14", com.alipay.alipaysecuritysdk.common.collector.c.m());
            hashMap.put("AE15", com.alipay.alipaysecuritysdk.common.collector.c.n());
            hashMap.put("AE20", JNIBridge.getNativeProp(context, "AE20", null));
            hashMap.put("AE21", com.alipay.alipaysecuritysdk.common.collector.c.s());
        }
        return hashMap;
    }
}

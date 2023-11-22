package com.alipay.alipaysecuritysdk.apdid.e;

import android.content.Context;
import com.alipay.alipaysecuritysdk.apdid.bridge.JNIBridge;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c {
    public static Map<String, String> a(Context context) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        com.alipay.alipaysecuritysdk.apdid.g.a.b a2 = com.alipay.alipaysecuritysdk.apdid.g.b.a(context);
        String a3 = com.alipay.alipaysecuritysdk.common.collector.b.a(context);
        String b = com.alipay.alipaysecuritysdk.common.collector.b.b(context);
        String l = com.alipay.alipaysecuritysdk.common.collector.b.l(context);
        String o2 = com.alipay.alipaysecuritysdk.common.collector.b.o(context);
        String n = com.alipay.alipaysecuritysdk.common.collector.b.n(context);
        String nativeProp = JNIBridge.getNativeProp(context, "AD102", null);
        String nativeProp2 = JNIBridge.getNativeProp(context, "AD104", "");
        String nativeProp3 = JNIBridge.getNativeProp(context, "AD108", null);
        String nativeProp4 = JNIBridge.getNativeProp(context, "dynData", "145");
        if (a2 != null) {
            if (com.alipay.alipaysecuritysdk.common.e.e.c(a3)) {
                a3 = com.alipay.alipaysecuritysdk.common.e.e.e(a2.f6860a);
            }
            if (com.alipay.alipaysecuritysdk.common.e.e.c(b)) {
                b = com.alipay.alipaysecuritysdk.common.e.e.e(a2.b);
            }
            if (com.alipay.alipaysecuritysdk.common.e.e.c(l)) {
                l = com.alipay.alipaysecuritysdk.common.e.e.e(a2.c);
            }
            if (com.alipay.alipaysecuritysdk.common.e.e.c(o2)) {
                o2 = com.alipay.alipaysecuritysdk.common.e.e.e(a2.d);
            }
            if (com.alipay.alipaysecuritysdk.common.e.e.c(n)) {
                n = com.alipay.alipaysecuritysdk.common.e.e.e(a2.e);
            }
        }
        com.alipay.alipaysecuritysdk.apdid.g.a.b bVar = new com.alipay.alipaysecuritysdk.apdid.g.a.b(a3, b, l, o2, n);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                str2 = nativeProp4;
                try {
                    str = nativeProp3;
                    try {
                        jSONObject.put("imei", com.alipay.alipaysecuritysdk.common.e.e.e(bVar.f6860a));
                        jSONObject.put("imsi", com.alipay.alipaysecuritysdk.common.e.e.e(bVar.b));
                        jSONObject.put("mac", com.alipay.alipaysecuritysdk.common.e.e.e(bVar.c));
                        jSONObject.put("bluetoothmac", com.alipay.alipaysecuritysdk.common.e.e.e(bVar.d));
                        jSONObject.put("gsi", com.alipay.alipaysecuritysdk.common.e.e.e(bVar.e));
                        com.alipay.alipaysecuritysdk.common.d.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", jSONObject.toString());
                    } catch (Exception e) {
                        e = e;
                        com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", e);
                        hashMap.put("AD1", a3);
                        hashMap.put("AD2", b);
                        hashMap.put("AD3", com.alipay.alipaysecuritysdk.common.collector.b.g(context));
                        hashMap.put("AD5", com.alipay.alipaysecuritysdk.common.collector.b.i(context));
                        hashMap.put("AD6", com.alipay.alipaysecuritysdk.common.collector.b.j(context));
                        hashMap.put("AD7", com.alipay.alipaysecuritysdk.common.collector.b.k(context));
                        hashMap.put("AD8", l);
                        hashMap.put("AD9", com.alipay.alipaysecuritysdk.common.collector.b.m(context));
                        hashMap.put("AD10", n);
                        hashMap.put("AD11", com.alipay.alipaysecuritysdk.common.collector.b.c());
                        hashMap.put("AD12", com.alipay.alipaysecuritysdk.common.collector.b.e());
                        hashMap.put("AD13", com.alipay.alipaysecuritysdk.common.collector.b.f());
                        hashMap.put("AD14", com.alipay.alipaysecuritysdk.common.collector.b.h());
                        hashMap.put("AD15", com.alipay.alipaysecuritysdk.common.collector.b.i());
                        hashMap.put("AD16", com.alipay.alipaysecuritysdk.common.collector.b.j());
                        hashMap.put("AD18", o2);
                        hashMap.put("AD19", com.alipay.alipaysecuritysdk.common.collector.b.p(context));
                        hashMap.put("AD20", com.alipay.alipaysecuritysdk.common.collector.b.k());
                        hashMap.put("AD23", com.alipay.alipaysecuritysdk.common.collector.b.r(context));
                        hashMap.put("AD24", com.alipay.alipaysecuritysdk.common.b.c.a(com.alipay.alipaysecuritysdk.common.collector.b.h(context)));
                        hashMap.put("AD26", com.alipay.alipaysecuritysdk.common.collector.b.f(context));
                        hashMap.put("AD27", com.alipay.alipaysecuritysdk.common.collector.b.p());
                        hashMap.put("AD28", com.alipay.alipaysecuritysdk.common.collector.b.r());
                        hashMap.put("AD29", com.alipay.alipaysecuritysdk.common.collector.b.t());
                        hashMap.put("AD30", com.alipay.alipaysecuritysdk.common.collector.b.q());
                        hashMap.put("AD31", com.alipay.alipaysecuritysdk.common.collector.b.s());
                        hashMap.put("AD32", String.valueOf(com.alipay.alipaysecuritysdk.common.collector.b.u()));
                        hashMap.put("AD33", com.alipay.alipaysecuritysdk.common.collector.b.o());
                        hashMap.put("AD34", com.alipay.alipaysecuritysdk.common.collector.b.t(context));
                        hashMap.put("AD35", com.alipay.alipaysecuritysdk.common.collector.b.u(context));
                        hashMap.put("AD36", com.alipay.alipaysecuritysdk.common.collector.b.s(context));
                        hashMap.put("AD37", com.alipay.alipaysecuritysdk.common.collector.b.n());
                        hashMap.put("AD38", com.alipay.alipaysecuritysdk.common.collector.b.m());
                        hashMap.put("AD39", com.alipay.alipaysecuritysdk.common.collector.b.c(context));
                        hashMap.put("AD40", com.alipay.alipaysecuritysdk.common.collector.b.d(context));
                        hashMap.put("AD41", com.alipay.alipaysecuritysdk.common.collector.b.a());
                        hashMap.put("AD42", com.alipay.alipaysecuritysdk.common.collector.b.b());
                        hashMap.put("AD100", com.alipay.alipaysecuritysdk.common.collector.b.d());
                        hashMap.put("AD102", nativeProp);
                        hashMap.put("AD104", nativeProp2);
                        hashMap.put("AD107", b(context));
                        hashMap.put("AD108", str);
                        hashMap.put("AD111", str2);
                        hashMap.put("AL3", com.alipay.alipaysecuritysdk.common.collector.b.q(context));
                        return hashMap;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = nativeProp3;
                }
            } catch (Exception e3) {
                e = e3;
                str = nativeProp3;
                str2 = nativeProp4;
            }
        } else {
            str = nativeProp3;
            str2 = nativeProp4;
        }
        hashMap.put("AD1", a3);
        hashMap.put("AD2", b);
        hashMap.put("AD3", com.alipay.alipaysecuritysdk.common.collector.b.g(context));
        hashMap.put("AD5", com.alipay.alipaysecuritysdk.common.collector.b.i(context));
        hashMap.put("AD6", com.alipay.alipaysecuritysdk.common.collector.b.j(context));
        hashMap.put("AD7", com.alipay.alipaysecuritysdk.common.collector.b.k(context));
        hashMap.put("AD8", l);
        hashMap.put("AD9", com.alipay.alipaysecuritysdk.common.collector.b.m(context));
        hashMap.put("AD10", n);
        hashMap.put("AD11", com.alipay.alipaysecuritysdk.common.collector.b.c());
        hashMap.put("AD12", com.alipay.alipaysecuritysdk.common.collector.b.e());
        hashMap.put("AD13", com.alipay.alipaysecuritysdk.common.collector.b.f());
        hashMap.put("AD14", com.alipay.alipaysecuritysdk.common.collector.b.h());
        hashMap.put("AD15", com.alipay.alipaysecuritysdk.common.collector.b.i());
        hashMap.put("AD16", com.alipay.alipaysecuritysdk.common.collector.b.j());
        hashMap.put("AD18", o2);
        hashMap.put("AD19", com.alipay.alipaysecuritysdk.common.collector.b.p(context));
        hashMap.put("AD20", com.alipay.alipaysecuritysdk.common.collector.b.k());
        hashMap.put("AD23", com.alipay.alipaysecuritysdk.common.collector.b.r(context));
        hashMap.put("AD24", com.alipay.alipaysecuritysdk.common.b.c.a(com.alipay.alipaysecuritysdk.common.collector.b.h(context)));
        hashMap.put("AD26", com.alipay.alipaysecuritysdk.common.collector.b.f(context));
        hashMap.put("AD27", com.alipay.alipaysecuritysdk.common.collector.b.p());
        hashMap.put("AD28", com.alipay.alipaysecuritysdk.common.collector.b.r());
        hashMap.put("AD29", com.alipay.alipaysecuritysdk.common.collector.b.t());
        hashMap.put("AD30", com.alipay.alipaysecuritysdk.common.collector.b.q());
        hashMap.put("AD31", com.alipay.alipaysecuritysdk.common.collector.b.s());
        hashMap.put("AD32", String.valueOf(com.alipay.alipaysecuritysdk.common.collector.b.u()));
        hashMap.put("AD33", com.alipay.alipaysecuritysdk.common.collector.b.o());
        hashMap.put("AD34", com.alipay.alipaysecuritysdk.common.collector.b.t(context));
        hashMap.put("AD35", com.alipay.alipaysecuritysdk.common.collector.b.u(context));
        hashMap.put("AD36", com.alipay.alipaysecuritysdk.common.collector.b.s(context));
        hashMap.put("AD37", com.alipay.alipaysecuritysdk.common.collector.b.n());
        hashMap.put("AD38", com.alipay.alipaysecuritysdk.common.collector.b.m());
        hashMap.put("AD39", com.alipay.alipaysecuritysdk.common.collector.b.c(context));
        hashMap.put("AD40", com.alipay.alipaysecuritysdk.common.collector.b.d(context));
        hashMap.put("AD41", com.alipay.alipaysecuritysdk.common.collector.b.a());
        hashMap.put("AD42", com.alipay.alipaysecuritysdk.common.collector.b.b());
        hashMap.put("AD100", com.alipay.alipaysecuritysdk.common.collector.b.d());
        hashMap.put("AD102", nativeProp);
        hashMap.put("AD104", nativeProp2);
        hashMap.put("AD107", b(context));
        hashMap.put("AD108", str);
        hashMap.put("AD111", str2);
        hashMap.put("AL3", com.alipay.alipaysecuritysdk.common.collector.b.q(context));
        return hashMap;
    }

    private static String b(Context context) {
        try {
            return String.valueOf(com.alipay.alipaysecuritysdk.common.e.e.a(JNIBridge.getNativeProp(context, "AD107", null)));
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", th);
            return "0";
        }
    }
}

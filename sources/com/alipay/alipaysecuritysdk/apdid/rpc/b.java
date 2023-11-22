package com.alipay.alipaysecuritysdk.apdid.rpc;

import android.content.Context;
import com.alipay.alipaysecuritysdk.apdid.bridge.JNIBridge;
import com.alipay.alipaysecuritysdk.apdid.face.Configuration;
import com.alipay.alipaysecuritysdk.apdid.g.d;
import com.alipay.alipaysecuritysdk.common.e.c;
import com.alipay.alipaysecuritysdk.common.e.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b {
    public static com.alipay.alipaysecuritysdk.apdid.rpc.model.a.b a(Context context, int i, Map<String, String> map) {
        com.alipay.alipaysecuritysdk.apdid.rpc.model.a.a a2;
        Configuration a3 = com.alipay.alipaysecuritysdk.apdid.a.a.a();
        com.alipay.alipaysecuritysdk.apdid.rpc.a.a aVar = new com.alipay.alipaysecuritysdk.apdid.rpc.a.a(context, a3.gateway, a3.headers);
        if (i == 0) {
            try {
                a2 = a(context, map);
            } catch (Exception e) {
                com.alipay.alipaysecuritysdk.common.c.a.a("rpc_request", "failed", e.getMessage());
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", "send device data error", e);
                return null;
            }
        } else {
            a2 = null;
        }
        if (i == 1) {
            if (map == null) {
                a2 = null;
            } else {
                a2 = new com.alipay.alipaysecuritysdk.apdid.rpc.model.a.a();
                a2.f6865a = "android";
                a2.c = com.alipay.alipaysecuritysdk.apdid.d.a.a(context, map.get("appName"));
                HashMap hashMap = new HashMap(2);
                hashMap.put("dynamicTrace", map.get("dynamicTrace"));
                hashMap.put("dynamicNum", map.get("dynamicNum"));
                a2.k = hashMap;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("dynamicData", map.get("dynamicData"));
                a2.j = hashMap2;
            }
        }
        return aVar.a(a2);
    }

    private static com.alipay.alipaysecuritysdk.apdid.rpc.model.a.a a(Context context, Map<String, String> map) {
        com.alipay.alipaysecuritysdk.apdid.rpc.model.a.a aVar = new com.alipay.alipaysecuritysdk.apdid.rpc.model.a.a();
        String a2 = c.a(map, "appName");
        String a3 = c.a(map, "sessionId");
        String a4 = c.a(map, "rpcVersion");
        String a5 = com.alipay.alipaysecuritysdk.apdid.d.a.a(context, a2);
        String d = d.d(context);
        aVar.d = com.alipay.alipaysecuritysdk.apdid.a.a.a().needUmid ? com.alipay.alipaysecuritysdk.apdid.f.a.a(context) : "";
        aVar.e = d;
        aVar.f6865a = "android";
        aVar.i = a4;
        if (e.d(a3)) {
            aVar.c = a3;
        } else {
            aVar.c = a5;
        }
        com.alipay.alipaysecuritysdk.apdid.g.a.a c = com.alipay.alipaysecuritysdk.apdid.g.a.c(context);
        if (c != null) {
            aVar.b = c.f6859a;
            aVar.g = c.f6859a;
            aVar.h = c.c;
        }
        Map<String, String> a6 = com.alipay.alipaysecuritysdk.apdid.e.e.a(context, map);
        if (com.alipay.alipaysecuritysdk.apdid.a.a.a().secret != null) {
            try {
                String e = e.e(JNIBridge.aesEncrypt(c.a(a6).toString()));
                HashMap hashMap = new HashMap(2);
                hashMap.put("default", e);
                hashMap.put("wbType", com.alipay.alipaysecuritysdk.apdid.a.a.a().secret);
                aVar.j = hashMap;
            } catch (Throwable th) {
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", th);
            }
            return aVar;
        }
        aVar.j = a6;
        return aVar;
    }
}

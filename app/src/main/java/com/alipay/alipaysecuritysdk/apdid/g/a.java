package com.alipay.alipaysecuritysdk.apdid.g;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    public static void a(Context context) {
        synchronized (a.class) {
            com.alipay.alipaysecuritysdk.common.d.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
        }
    }

    public static void b(Context context) {
        synchronized (a.class) {
            com.alipay.alipaysecuritysdk.apdid.g.a.a c = c(context);
            if (c != null) {
                String str = c.f6859a;
                String str2 = c.b;
                String str3 = c.c;
                String str4 = c.d;
                String str5 = c.e;
            }
        }
    }

    public static void a(Context context, com.alipay.alipaysecuritysdk.apdid.g.a.a aVar) {
        synchronized (a.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", aVar.f6859a);
                jSONObject.put("deviceInfoHash", aVar.b);
                jSONObject.put("timestamp", aVar.c);
                jSONObject.put("tid", aVar.d);
                jSONObject.put("utdid", aVar.e);
                com.alipay.alipaysecuritysdk.common.d.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", jSONObject.toString());
            } catch (Exception e) {
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", "V4 saveStorageModelV4 happed exception:", e);
            }
        }
    }

    public static com.alipay.alipaysecuritysdk.apdid.g.a.a c(Context context) {
        com.alipay.alipaysecuritysdk.apdid.g.a.a a2;
        synchronized (a.class) {
            a2 = a(com.alipay.alipaysecuritysdk.common.d.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4"));
        }
        return a2;
    }

    private static com.alipay.alipaysecuritysdk.apdid.g.a.a a(String str) {
        try {
            if (com.alipay.alipaysecuritysdk.common.e.e.c(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            return new com.alipay.alipaysecuritysdk.apdid.g.a.a(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"), jSONObject.optString("tid"), jSONObject.optString("utdid"));
        } catch (Exception e) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", e);
            return null;
        }
    }
}

package com.alipay.alipaysecuritysdk.apdid.g;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f6861a = "";

    public static void a(Context context, String str) {
        a(context, "update_time_interval", str);
    }

    public static void b(Context context, String str) {
        a(context, "last_machine_boot_time", str);
    }

    public static void c(Context context, String str) {
        a(context, "last_apdid_env", str);
    }

    public static void a(Context context, boolean z) {
        a(context, "log_switch", z ? "1" : "0");
    }

    public static void d(Context context, String str) {
        a(context, "dynamic_key", str);
    }

    public static void e(Context context, String str) {
        a(context, "webrtc_url", str);
    }

    public static void f(Context context, String str) {
        a(context, "apse_degrade", str);
    }

    private static void a(Context context, String str, String str2) {
        com.alipay.alipaysecuritysdk.common.d.a.a(context, "vkeyid_settings", str, str2);
    }

    public static long g(Context context, String str) {
        try {
            StringBuilder sb = new StringBuilder("vkey_valid");
            sb.append(str);
            String a2 = com.alipay.alipaysecuritysdk.common.d.a.a(context, "vkeyid_settings", sb.toString());
            if (com.alipay.alipaysecuritysdk.common.e.e.c(a2)) {
                return 0L;
            }
            return Long.parseLong(a2);
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return 0L;
        }
    }

    public static void a(Context context, String str, long j) {
        StringBuilder sb = new StringBuilder("vkey_valid");
        sb.append(str);
        com.alipay.alipaysecuritysdk.common.d.a.a(context, "vkeyid_settings", sb.toString(), String.valueOf(j));
    }

    public static String f(Context context) {
        String str;
        SharedPreferences.Editor edit;
        synchronized (d.class) {
            if (com.alipay.alipaysecuritysdk.common.e.e.c(f6861a)) {
                String a2 = com.alipay.alipaysecuritysdk.common.d.b.a(context, "alipay_vkey_random", "random", "");
                f6861a = a2;
                if (com.alipay.alipaysecuritysdk.common.e.e.c(a2)) {
                    String a3 = com.alipay.alipaysecuritysdk.common.b.b.a(UUID.randomUUID().toString());
                    f6861a = a3;
                    if (a3 != null && (edit = context.getSharedPreferences("alipay_vkey_random", 0).edit()) != null) {
                        edit.putString("random", a3);
                        try {
                            edit.apply();
                        } catch (Throwable th) {
                            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", th);
                        }
                    }
                }
            }
            str = f6861a;
        }
        return str;
    }

    public static void a(Context context, Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (map.containsKey("timeInternal")) {
            a(context, "update_time_interval", map.get("timeInternal"));
        } else {
            a(context, "update_time_interval", "");
        }
        if (map.containsKey("webrtcUrl")) {
            a(context, "webrtc_url", map.get("webrtcUrl"));
        } else {
            a(context, "webrtc_url", "");
        }
        if (map.containsKey("agentUrl")) {
            a(context, "agent_switch", map.get("agentUrl"));
        } else {
            a(context, "agent_switch", "");
        }
        if (map.containsKey("apse_degrade")) {
            a(context, "apse_degrade", map.get("apse_degrade"));
        } else {
            a(context, "apse_degrade", "");
        }
    }

    public static long a(Context context) {
        String a2 = com.alipay.alipaysecuritysdk.common.d.a.a(context, "vkeyid_settings", "update_time_interval");
        if (com.alipay.alipaysecuritysdk.common.e.e.d(a2)) {
            try {
                return Long.parseLong(a2);
            } catch (Exception e) {
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
                return 86400000L;
            }
        }
        return 86400000L;
    }

    public static String b(Context context) {
        return com.alipay.alipaysecuritysdk.common.d.a.a(context, "vkeyid_settings", "last_apdid_env");
    }

    public static String c(Context context) {
        return com.alipay.alipaysecuritysdk.common.d.a.a(context, "vkeyid_settings", "agent_switch");
    }

    public static String d(Context context) {
        return com.alipay.alipaysecuritysdk.common.d.a.a(context, "vkeyid_settings", "dynamic_key");
    }

    public static String e(Context context) {
        return com.alipay.alipaysecuritysdk.common.d.a.a(context, "vkeyid_settings", "apse_degrade");
    }
}

package com.alipay.alipaysecuritysdk.apdid.g;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: classes3.dex */
public final class c {
    public static void a(Context context, String str, String str2) {
        synchronized (c.class) {
            StringBuilder sb = new StringBuilder("openApi");
            sb.append(str);
            com.alipay.alipaysecuritysdk.common.d.a.a(context, "openapi_file_pri", sb.toString(), str2);
        }
    }

    public static String a(Context context, String str) {
        String a2;
        synchronized (c.class) {
            StringBuilder sb = new StringBuilder("openApi");
            sb.append(str);
            a2 = com.alipay.alipaysecuritysdk.common.d.a.a(context, "openapi_file_pri", sb.toString());
        }
        return a2;
    }

    public static void a(Context context) {
        synchronized (c.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (edit != null) {
                edit.clear();
                try {
                    edit.apply();
                } catch (Throwable th) {
                    com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", th);
                }
            }
        }
    }

    public static void b(Context context) {
        synchronized (c.class) {
            Map<String, ?> all = context.getSharedPreferences("openapi_file_pri", 0).getAll();
            for (String str : all.keySet()) {
                String a2 = com.alipay.alipaysecuritysdk.common.a.a.a();
                String str2 = (String) all.get(str);
                String str3 = str2;
                com.alipay.alipaysecuritysdk.common.a.a.b(a2, str2);
            }
        }
    }
}

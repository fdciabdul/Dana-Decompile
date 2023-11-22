package com.alipay.alipaysecuritysdk.common.d;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b {
    public static void a(Context context, String str, Map<String, String> map) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if (edit != null) {
            for (String str2 : map.keySet()) {
                edit.putString(str2, map.get(str2));
            }
            try {
                edit.apply();
            } catch (Throwable th) {
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", th);
            }
        }
    }

    public static String a(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }
}

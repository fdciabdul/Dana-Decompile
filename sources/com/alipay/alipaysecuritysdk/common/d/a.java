package com.alipay.alipaysecuritysdk.common.d;

import android.content.Context;
import com.alipay.alipaysecuritysdk.common.e.e;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class a {
    public static String a(Context context, String str, String str2) {
        synchronized (a.class) {
            if (context != null) {
                if (!e.c(str) && !e.c(str2)) {
                    try {
                        String a2 = b.a(context, str, str2, "");
                        if (e.c(a2)) {
                            return null;
                        }
                        return com.alipay.alipaysecuritysdk.common.a.a.b(com.alipay.alipaysecuritysdk.common.a.a.a(), a2);
                    } catch (Throwable th) {
                        com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
                        return null;
                    }
                }
            }
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            if (e.c(str) || e.c(str2) || context == null) {
                return;
            }
            try {
                String a2 = com.alipay.alipaysecuritysdk.common.a.a.a(com.alipay.alipaysecuritysdk.common.a.a.a(), str3);
                HashMap hashMap = new HashMap(1);
                hashMap.put(str2, a2);
                b.a(context, str, hashMap);
            } catch (Throwable th) {
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            }
        }
    }
}

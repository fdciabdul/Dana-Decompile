package com.ta.audid.d;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public class d {
    public static boolean h(Context context) {
        return a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean i(Context context) {
        return a(context, "android.permission.READ_PHONE_STATE");
    }

    public static boolean j(Context context) {
        return a(context, "android.permission.ACCESS_WIFI_STATE");
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        int b = com.ta.audid.g.a.b(context);
        if (Build.VERSION.SDK_INT >= 23) {
            if (b >= 23) {
                if (context.checkSelfPermission(str) != 0) {
                    return false;
                }
            } else if (c.a(context, str) != 0) {
                return false;
            }
        } else if (c.a(context, str) != 0) {
            return false;
        }
        return true;
    }
}

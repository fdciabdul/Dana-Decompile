package com.alipay.androidinter.app.safepaybase.alikeyboard;

import android.os.Build;

/* loaded from: classes6.dex */
public class TaoHelper {
    public static boolean isSpecialManuFacturer(String str) {
        String str2 = Build.MANUFACTURER;
        String str3 = Build.BRAND;
        if (str2 == null || !str2.trim().equalsIgnoreCase(str)) {
            return str3 != null && str3.trim().equalsIgnoreCase(str);
        }
        return true;
    }
}

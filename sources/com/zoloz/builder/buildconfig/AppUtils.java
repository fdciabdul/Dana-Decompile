package com.zoloz.builder.buildconfig;

import android.content.Context;

/* loaded from: classes8.dex */
public class AppUtils {
    public static boolean isDebug(Context context) {
        try {
            return (context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}

package com.ta.audid.d;

import android.app.AppOpsManager;
import android.content.Context;

/* loaded from: classes.dex */
class b {
    public static String permissionToOp(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    public static int a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }
}

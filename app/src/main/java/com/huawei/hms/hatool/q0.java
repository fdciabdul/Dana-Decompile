package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes8.dex */
public class q0 {
    public static boolean BuiltInFictitiousFunctionClassFactory(Context context, String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(g0.KClassImpl$Data$declaredNonStaticMembers$2(context, str));
        sb.append(".xml");
        String obj = sb.toString();
        File filesDir = context.getFilesDir();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("../shared_prefs/");
        sb2.append(obj);
        long length = new File(filesDir, sb2.toString()).length();
        if (length > i) {
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i)));
            return true;
        }
        return false;
    }

    public static boolean MyBillsEntityDataFactory(Context context) {
        return System.currentTimeMillis() - g0.getAuthRequestContext(context, "Privacy_MY", "flashKeyTime") > 43200000;
    }

    public static boolean MyBillsEntityDataFactory(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
                y.moveToNextValue("hmsSdk", "not have read phone permission!");
                return true;
            }
            return false;
        } else if (context.checkSelfPermission(str) != 0) {
            y.moveToNextValue("hmsSdk", "not have read phone permission!");
            return true;
        } else {
            return false;
        }
    }

    public static boolean getAuthRequestContext(String str, long j, long j2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j - Long.parseLong(str) > j2;
        } catch (NumberFormatException unused) {
            y.moveToNextValue("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}

package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes8.dex */
public class i {
    private static SharedPreferences KClassImpl$Data$declaredNonStaticMembers$2;

    private static SharedPreferences getAuthRequestContext(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (i.class) {
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    KClassImpl$Data$declaredNonStaticMembers$2 = context.createDeviceProtectedStorageContext().getSharedPreferences("aegis", 0);
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2 = context.getApplicationContext().getSharedPreferences("aegis", 0);
                }
            }
            sharedPreferences = KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return sharedPreferences;
    }

    public static String MyBillsEntityDataFactory(String str, String str2, Context context) {
        return getAuthRequestContext(context).getString(str, str2);
    }
}

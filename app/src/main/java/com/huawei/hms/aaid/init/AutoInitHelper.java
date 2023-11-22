package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes7.dex */
public class AutoInitHelper {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        try {
            if (getAuthRequestContext(context)) {
                HMSLog.i("AutoInit", "Push init start");
                new Thread(new f(context)).start();
            }
        } catch (Exception e) {
            HMSLog.e("AutoInit", "Push init failed", e);
        }
    }

    private static boolean getAuthRequestContext(Context context) {
        i BuiltInFictitiousFunctionClassFactory = i.BuiltInFictitiousFunctionClassFactory(context);
        if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext("push_kit_auto_init_enabled")) {
            return BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2("push_kit_auto_init_enabled");
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}

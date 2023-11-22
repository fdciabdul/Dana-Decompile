package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;

/* loaded from: classes8.dex */
public class HWPushHelper {
    private static boolean BuiltInFictitiousFunctionClassFactory;

    public static void BuiltInFictitiousFunctionClassFactory(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static boolean MyBillsEntityDataFactory(Context context) {
        boolean z;
        synchronized (HWPushHelper.class) {
            z = Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L)) > RangedBeacon.DEFAULT_MAX_TRACKING_AGE;
        }
        return z;
    }

    public static boolean getAuthRequestContext() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static void PlaceComponentResult(Context context) {
        d MyBillsEntityDataFactory = d.MyBillsEntityDataFactory(context);
        AbstractPushManager abstractPushManager = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get(c.ASSEMBLE_PUSH_HUAWEI);
        if (abstractPushManager != null) {
            abstractPushManager.PlaceComponentResult();
        }
    }
}

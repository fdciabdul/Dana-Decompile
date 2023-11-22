package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: classes8.dex */
public class COSPushHelper {
    private static long KClassImpl$Data$declaredNonStaticMembers$2;
    private static volatile boolean getAuthRequestContext;

    private static boolean PlaceComponentResult() {
        return getAuthRequestContext;
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (PlaceComponentResult()) {
            long j = KClassImpl$Data$declaredNonStaticMembers$2;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                KClassImpl$Data$declaredNonStaticMembers$2 = elapsedRealtime;
                d MyBillsEntityDataFactory = d.MyBillsEntityDataFactory(context);
                AbstractPushManager abstractPushManager = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get(c.ASSEMBLE_PUSH_COS);
                if (abstractPushManager != null) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("ASSEMBLE_PUSH :  register cos when network change!");
                    abstractPushManager.PlaceComponentResult();
                }
            }
        }
    }
}

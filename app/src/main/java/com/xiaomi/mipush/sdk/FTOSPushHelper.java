package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: classes8.dex */
public class FTOSPushHelper {
    private static volatile boolean BuiltInFictitiousFunctionClassFactory;
    private static long getAuthRequestContext;

    public static void MyBillsEntityDataFactory(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (BuiltInFictitiousFunctionClassFactory) {
            long j = getAuthRequestContext;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                getAuthRequestContext = elapsedRealtime;
                d MyBillsEntityDataFactory = d.MyBillsEntityDataFactory(context);
                AbstractPushManager abstractPushManager = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get(c.ASSEMBLE_PUSH_FTOS);
                if (abstractPushManager != null) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("ASSEMBLE_PUSH :  register fun touch os when network change!");
                    abstractPushManager.PlaceComponentResult();
                }
            }
        }
    }
}

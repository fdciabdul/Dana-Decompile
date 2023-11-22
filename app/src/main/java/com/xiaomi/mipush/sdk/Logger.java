package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* loaded from: classes8.dex */
public class Logger {
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private static LoggerInterface PlaceComponentResult;

    private static boolean MyBillsEntityDataFactory(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        if (MyBillsEntityDataFactory(r3) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void PlaceComponentResult(android.content.Context r3, com.xiaomi.channel.commonutils.logger.LoggerInterface r4) {
        /*
            com.xiaomi.mipush.sdk.Logger.PlaceComponentResult = r4
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L8
            r4 = 1
            goto L9
        L8:
            r4 = 0
        L9:
            boolean r2 = com.xiaomi.mipush.sdk.Logger.KClassImpl$Data$declaredNonStaticMembers$2
            if (r2 != 0) goto L14
            boolean r2 = MyBillsEntityDataFactory(r3)
            if (r2 == 0) goto L15
            goto L16
        L14:
            r4 = 0
        L15:
            r0 = 0
        L16:
            r1 = 0
            if (r4 == 0) goto L1c
            com.xiaomi.channel.commonutils.logger.LoggerInterface r4 = com.xiaomi.mipush.sdk.Logger.PlaceComponentResult
            goto L1d
        L1c:
            r4 = r1
        L1d:
            if (r0 == 0) goto L23
            com.xiaomi.push.ar r1 = com.xiaomi.push.ar.BuiltInFictitiousFunctionClassFactory(r3)
        L23:
            com.xiaomi.push.aq r3 = new com.xiaomi.push.aq
            r3.<init>(r4, r1)
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.Logger.PlaceComponentResult(android.content.Context, com.xiaomi.channel.commonutils.logger.LoggerInterface):void");
    }
}

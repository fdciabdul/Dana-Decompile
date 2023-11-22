package com.xiaomi.mipush.sdk;

import android.content.Context;

/* loaded from: classes8.dex */
public class l {
    private static int BuiltInFictitiousFunctionClassFactory = -1;

    public static boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        boolean z = false;
        Object PlaceComponentResult = com.xiaomi.push.z.PlaceComponentResult("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (PlaceComponentResult != null && (PlaceComponentResult instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(PlaceComponentResult)).booleanValue();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("color os push  is avaliable ? :");
        sb.append(z);
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
        return z;
    }

    public static boolean MyBillsEntityDataFactory(Context context) {
        boolean z = false;
        Object PlaceComponentResult = com.xiaomi.push.z.PlaceComponentResult("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (PlaceComponentResult != null && (PlaceComponentResult instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(PlaceComponentResult)).booleanValue();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("fun touch os push  is avaliable ? :");
        sb.append(z);
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
        return z;
    }

    public static y PlaceComponentResult() {
        return y.OTHER;
    }

    public static boolean PlaceComponentResult(Context context) {
        return getAuthRequestContext(context, "com.google.android.gms.common.GoogleApiAvailability") || getAuthRequestContext(context, "com.google.android.gms.common.GoogleApiAvailabilityLight");
    }

    private static boolean getAuthRequestContext(Context context, String str) {
        Object authRequestContext = com.xiaomi.push.z.getAuthRequestContext(com.xiaomi.push.z.PlaceComponentResult(str, "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object MyBillsEntityDataFactory = com.xiaomi.push.z.MyBillsEntityDataFactory("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        if (MyBillsEntityDataFactory == null || !(MyBillsEntityDataFactory instanceof Integer)) {
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("google service is not avaliable");
            BuiltInFictitiousFunctionClassFactory = 0;
            return false;
        }
        int intValue = ((Integer) Integer.class.cast(MyBillsEntityDataFactory)).intValue();
        if (authRequestContext != null) {
            if (authRequestContext instanceof Integer) {
                BuiltInFictitiousFunctionClassFactory = ((Integer) Integer.class.cast(authRequestContext)).intValue() == intValue ? 1 : 0;
            } else {
                BuiltInFictitiousFunctionClassFactory = 0;
                com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("google service is not avaliable");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("is google service can be used");
        sb.append(BuiltInFictitiousFunctionClassFactory > 0);
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
        return BuiltInFictitiousFunctionClassFactory > 0;
    }
}

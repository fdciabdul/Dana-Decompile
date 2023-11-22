package com.xiaomi.push.service;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public class aw {
    private static String BuiltInFictitiousFunctionClassFactory = "";
    private static long PlaceComponentResult;

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return str;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("BlockId_");
            sb.append(str.substring(8));
            return sb.toString();
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Exception occurred when filtering registration packet id for log. ");
            sb2.append(e);
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString());
            return "UnexpectedId";
        }
    }

    public static String MyBillsEntityDataFactory() {
        if (TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory)) {
            BuiltInFictitiousFunctionClassFactory = com.xiaomi.push.ad.KClassImpl$Data$declaredNonStaticMembers$2(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(BuiltInFictitiousFunctionClassFactory);
        long j = PlaceComponentResult;
        PlaceComponentResult = 1 + j;
        sb.append(j);
        return sb.toString();
    }

    public static String getAuthRequestContext() {
        return com.xiaomi.push.ad.KClassImpl$Data$declaredNonStaticMembers$2(32);
    }
}

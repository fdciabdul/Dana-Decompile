package com.huawei.hms.hatool;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public abstract class a1 {
    public abstract String BuiltInFictitiousFunctionClassFactory();

    public abstract String KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract String KClassImpl$Data$declaredNonStaticMembers$2(String str);

    public abstract String MyBillsEntityDataFactory();

    public abstract int PlaceComponentResult();

    public static boolean getAuthRequestContext() {
        l lVar = i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory;
        if (TextUtils.isEmpty(lVar.getAuthRequestContext)) {
            lVar.getAuthRequestContext = f.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return !TextUtils.isEmpty(lVar.getAuthRequestContext);
    }

    public static String scheduleImpl() {
        l lVar = i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory;
        if (TextUtils.isEmpty(lVar.KClassImpl$Data$declaredNonStaticMembers$2)) {
            lVar.KClassImpl$Data$declaredNonStaticMembers$2 = b1.getAuthRequestContext();
        }
        return lVar.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

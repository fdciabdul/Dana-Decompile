package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public abstract class g {
    public static String MyBillsEntityDataFactory(Context context, String str, String str2) {
        if (!str2.equals("oper") && !str2.equals("maint") && !str2.equals("diffprivacy") && !str2.equals("preins")) {
            StringBuilder sb = new StringBuilder();
            sb.append("getChannel(): Invalid type: ");
            sb.append(str2);
            y.moveToNextValue("hmsSdk", sb.toString());
            return "";
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(context, str, str2);
    }

    public static String getAuthRequestContext(Context context, String str, String str2) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(a.BuiltInFictitiousFunctionClassFactory(str, str2))) {
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "getAndroidId(): to getConfigByType()");
            if (a.KClassImpl$Data$declaredNonStaticMembers$2(str, str2)) {
                str3 = i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.PlaceComponentResult;
                if (TextUtils.isEmpty(str3)) {
                    i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.PlaceComponentResult = f.getAuthRequestContext(context);
                }
                str4 = i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.PlaceComponentResult;
                return str4;
            }
            return "";
        }
        return a.BuiltInFictitiousFunctionClassFactory(str, str2);
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2) {
        if (TextUtils.isEmpty(c.KClassImpl$Data$declaredNonStaticMembers$2(str, str2))) {
            l lVar = i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory;
            if (TextUtils.isEmpty(lVar.DatabaseTableConfigUtil)) {
                String MyBillsEntityDataFactory = f.MyBillsEntityDataFactory(context);
                if (!s0.KClassImpl$Data$declaredNonStaticMembers$2("channel", MyBillsEntityDataFactory, 256)) {
                    MyBillsEntityDataFactory = "";
                }
                lVar.DatabaseTableConfigUtil = MyBillsEntityDataFactory;
            }
            return lVar.DatabaseTableConfigUtil;
        }
        return c.KClassImpl$Data$declaredNonStaticMembers$2(str, str2);
    }
}

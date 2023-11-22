package com.huawei.hms.hatool;

/* loaded from: classes8.dex */
public class m {
    public k BuiltInFictitiousFunctionClassFactory;
    public k KClassImpl$Data$declaredNonStaticMembers$2;
    public k PlaceComponentResult;
    public k getAuthRequestContext;

    public final k MyBillsEntityDataFactory(String str) {
        if (str.equals("oper")) {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
        if (str.equals("maint")) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (str.equals("diffprivacy")) {
            return this.getAuthRequestContext;
        }
        if (str.equals("preins")) {
            return this.PlaceComponentResult;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("HiAnalyticsInstData.getConfig(type): wrong type: ");
        sb.append(str);
        y.moveToNextValue("hmsSdk", sb.toString());
        return null;
    }
}

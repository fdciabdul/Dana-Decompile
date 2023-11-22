package com.mixpanel.android.viewcrawler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PropertyDescription {
    public final Caller BuiltInFictitiousFunctionClassFactory;
    final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String MyBillsEntityDataFactory;
    public final Class<?> PlaceComponentResult;

    public PropertyDescription(String str, Class<?> cls, Caller caller, String str2) {
        this.MyBillsEntityDataFactory = str;
        this.PlaceComponentResult = cls;
        this.BuiltInFictitiousFunctionClassFactory = caller;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[PropertyDescription ");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(",");
        sb.append(this.PlaceComponentResult);
        sb.append(", ");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append("/");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append("]");
        return sb.toString();
    }
}

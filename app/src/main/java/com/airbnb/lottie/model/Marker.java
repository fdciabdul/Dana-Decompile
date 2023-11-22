package com.airbnb.lottie.model;

/* loaded from: classes3.dex */
public class Marker {
    private final String BuiltInFictitiousFunctionClassFactory;
    public final float KClassImpl$Data$declaredNonStaticMembers$2;
    public final float PlaceComponentResult;

    public Marker(String str, float f, float f2) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f2;
        this.PlaceComponentResult = f;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String str) {
        if (this.BuiltInFictitiousFunctionClassFactory.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.BuiltInFictitiousFunctionClassFactory.endsWith("\r")) {
            String str2 = this.BuiltInFictitiousFunctionClassFactory;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}

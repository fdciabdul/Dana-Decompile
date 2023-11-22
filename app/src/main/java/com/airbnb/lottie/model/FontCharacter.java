package com.airbnb.lottie.model;

import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

/* loaded from: classes3.dex */
public class FontCharacter {
    public final double BuiltInFictitiousFunctionClassFactory;
    public final List<ShapeGroup> KClassImpl$Data$declaredNonStaticMembers$2;
    private final String MyBillsEntityDataFactory;
    private final double PlaceComponentResult;
    private final char getAuthRequestContext;
    private final String getErrorConfigVersion;

    public static int MyBillsEntityDataFactory(char c, String str, String str2) {
        return ((((c + 0) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public FontCharacter(List<ShapeGroup> list, char c, double d, double d2, String str, String str2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.getAuthRequestContext = c;
        this.PlaceComponentResult = d;
        this.BuiltInFictitiousFunctionClassFactory = d2;
        this.getErrorConfigVersion = str;
        this.MyBillsEntityDataFactory = str2;
    }

    public int hashCode() {
        char c = this.getAuthRequestContext;
        return ((((c + 0) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.getErrorConfigVersion.hashCode();
    }
}

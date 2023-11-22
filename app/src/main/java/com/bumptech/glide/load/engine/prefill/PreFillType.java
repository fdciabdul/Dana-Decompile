package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;

/* loaded from: classes7.dex */
public final class PreFillType {
    static final Bitmap.Config MyBillsEntityDataFactory = Bitmap.Config.RGB_565;
    final Bitmap.Config BuiltInFictitiousFunctionClassFactory;
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    final int PlaceComponentResult;
    final int getAuthRequestContext;

    /* loaded from: classes7.dex */
    public static class Builder {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PreFillType) {
            PreFillType preFillType = (PreFillType) obj;
            return this.PlaceComponentResult == preFillType.PlaceComponentResult && this.getAuthRequestContext == preFillType.getAuthRequestContext && this.KClassImpl$Data$declaredNonStaticMembers$2 == preFillType.KClassImpl$Data$declaredNonStaticMembers$2 && this.BuiltInFictitiousFunctionClassFactory == preFillType.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.getAuthRequestContext;
        return (((((i * 31) + this.PlaceComponentResult) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreFillSize{width=");
        sb.append(this.getAuthRequestContext);
        sb.append(", height=");
        sb.append(this.PlaceComponentResult);
        sb.append(", config=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", weight=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append('}');
        return sb.toString();
    }
}

package com.airbnb.lottie.model;

import android.graphics.PointF;

/* loaded from: classes3.dex */
public class CubicCurveData {
    public final PointF BuiltInFictitiousFunctionClassFactory;
    public final PointF KClassImpl$Data$declaredNonStaticMembers$2;
    public final PointF getAuthRequestContext;

    public CubicCurveData() {
        this.BuiltInFictitiousFunctionClassFactory = new PointF();
        this.getAuthRequestContext = new PointF();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new PointF();
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.BuiltInFictitiousFunctionClassFactory = pointF;
        this.getAuthRequestContext = pointF2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pointF3;
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.x), Float.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.y), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.x), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.y), Float.valueOf(this.getAuthRequestContext.x), Float.valueOf(this.getAuthRequestContext.y));
    }
}

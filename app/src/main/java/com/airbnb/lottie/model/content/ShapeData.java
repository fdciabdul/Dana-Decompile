package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeData {
    public final List<CubicCurveData> MyBillsEntityDataFactory;
    public boolean PlaceComponentResult;
    public PointF getAuthRequestContext;

    public ShapeData(PointF pointF, boolean z, List<CubicCurveData> list) {
        this.getAuthRequestContext = pointF;
        this.PlaceComponentResult = z;
        this.MyBillsEntityDataFactory = new ArrayList(list);
    }

    public ShapeData() {
        this.MyBillsEntityDataFactory = new ArrayList();
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeData{numCurves=");
        sb.append(this.MyBillsEntityDataFactory.size());
        sb.append("closed=");
        sb.append(this.PlaceComponentResult);
        sb.append('}');
        return sb.toString();
    }
}

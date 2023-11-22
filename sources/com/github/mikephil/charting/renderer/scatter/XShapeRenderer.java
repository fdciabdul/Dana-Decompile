package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes7.dex */
public class XShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public final void PlaceComponentResult(Canvas canvas, IScatterDataSet iScatterDataSet, float f, float f2, Paint paint) {
        float BuiltInFictitiousFunctionClassFactory = iScatterDataSet.BuiltInFictitiousFunctionClassFactory() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.PlaceComponentResult(1.0f));
        float f3 = f - BuiltInFictitiousFunctionClassFactory;
        float f4 = f2 - BuiltInFictitiousFunctionClassFactory;
        float f5 = f + BuiltInFictitiousFunctionClassFactory;
        float f6 = BuiltInFictitiousFunctionClassFactory + f2;
        canvas.drawLine(f3, f4, f5, f6, paint);
        canvas.drawLine(f5, f4, f3, f6, paint);
    }
}

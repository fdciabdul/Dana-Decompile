package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes7.dex */
public class CrossShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public final void PlaceComponentResult(Canvas canvas, IScatterDataSet iScatterDataSet, float f, float f2, Paint paint) {
        float BuiltInFictitiousFunctionClassFactory = iScatterDataSet.BuiltInFictitiousFunctionClassFactory() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.PlaceComponentResult(1.0f));
        canvas.drawLine(f - BuiltInFictitiousFunctionClassFactory, f2, f + BuiltInFictitiousFunctionClassFactory, f2, paint);
        canvas.drawLine(f, f2 - BuiltInFictitiousFunctionClassFactory, f, f2 + BuiltInFictitiousFunctionClassFactory, paint);
    }
}

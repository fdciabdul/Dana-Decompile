package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes7.dex */
public class ChevronUpShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public final void PlaceComponentResult(Canvas canvas, IScatterDataSet iScatterDataSet, float f, float f2, Paint paint) {
        float BuiltInFictitiousFunctionClassFactory = iScatterDataSet.BuiltInFictitiousFunctionClassFactory() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.PlaceComponentResult(1.0f));
        float f3 = BuiltInFictitiousFunctionClassFactory * 2.0f;
        float f4 = f2 - f3;
        canvas.drawLine(f, f4, f + f3, f2, paint);
        canvas.drawLine(f, f4, f - f3, f2, paint);
    }
}

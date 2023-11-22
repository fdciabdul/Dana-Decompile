package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes7.dex */
public class CircleShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public final void PlaceComponentResult(Canvas canvas, IScatterDataSet iScatterDataSet, float f, float f2, Paint paint) {
        float BuiltInFictitiousFunctionClassFactory = iScatterDataSet.BuiltInFictitiousFunctionClassFactory();
        float f3 = BuiltInFictitiousFunctionClassFactory / 2.0f;
        float PlaceComponentResult = Utils.PlaceComponentResult(iScatterDataSet.KClassImpl$Data$declaredNonStaticMembers$2());
        float f4 = (BuiltInFictitiousFunctionClassFactory - (PlaceComponentResult * 2.0f)) / 2.0f;
        float f5 = f4 / 2.0f;
        int authRequestContext = iScatterDataSet.getAuthRequestContext();
        if (BuiltInFictitiousFunctionClassFactory > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f4);
            canvas.drawCircle(f, f2, f5 + PlaceComponentResult, paint);
            if (authRequestContext != 1122867) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(authRequestContext);
                canvas.drawCircle(f, f2, PlaceComponentResult, paint);
                return;
            }
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f, f2, f3, paint);
    }
}

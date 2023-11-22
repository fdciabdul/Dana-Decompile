package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes7.dex */
public class TriangleShapeRenderer implements IShapeRenderer {
    protected Path PlaceComponentResult = new Path();

    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public final void PlaceComponentResult(Canvas canvas, IScatterDataSet iScatterDataSet, float f, float f2, Paint paint) {
        float BuiltInFictitiousFunctionClassFactory = iScatterDataSet.BuiltInFictitiousFunctionClassFactory();
        float f3 = BuiltInFictitiousFunctionClassFactory / 2.0f;
        float PlaceComponentResult = (BuiltInFictitiousFunctionClassFactory - (Utils.PlaceComponentResult(iScatterDataSet.KClassImpl$Data$declaredNonStaticMembers$2()) * 2.0f)) / 2.0f;
        int authRequestContext = iScatterDataSet.getAuthRequestContext();
        paint.setStyle(Paint.Style.FILL);
        Path path = this.PlaceComponentResult;
        path.reset();
        float f4 = f2 - f3;
        path.moveTo(f, f4);
        float f5 = f + f3;
        float f6 = f2 + f3;
        path.lineTo(f5, f6);
        float f7 = f - f3;
        path.lineTo(f7, f6);
        double d = BuiltInFictitiousFunctionClassFactory;
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            path.lineTo(f, f4);
            float f8 = f7 + PlaceComponentResult;
            float f9 = f6 - PlaceComponentResult;
            path.moveTo(f8, f9);
            path.lineTo(f5 - PlaceComponentResult, f9);
            path.lineTo(f, f4 + PlaceComponentResult);
            path.lineTo(f8, f9);
        }
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || authRequestContext == 1122867) {
            return;
        }
        paint.setColor(authRequestContext);
        path.moveTo(f, f4 + PlaceComponentResult);
        float f10 = f6 - PlaceComponentResult;
        path.lineTo(f5 - PlaceComponentResult, f10);
        path.lineTo(f7 + PlaceComponentResult, f10);
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
    }
}

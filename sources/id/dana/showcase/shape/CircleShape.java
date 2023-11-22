package id.dana.showcase.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import id.dana.utils.SizeUtil;

/* loaded from: classes5.dex */
public class CircleShape implements Shape {
    private static final float PlaceComponentResult = SizeUtil.getAuthRequestContext(36);
    private float BuiltInFictitiousFunctionClassFactory;

    public CircleShape() {
        this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
    }

    public CircleShape(float f) {
        this.BuiltInFictitiousFunctionClassFactory = f;
    }

    @Override // id.dana.showcase.shape.Shape
    public final void getAuthRequestContext(Canvas canvas, Paint paint, PointF pointF, float f) {
        canvas.drawCircle(pointF.x, pointF.y, f * this.BuiltInFictitiousFunctionClassFactory, paint);
    }

    @Override // id.dana.showcase.shape.Shape
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory * 2.0f;
    }

    @Override // id.dana.showcase.shape.Shape
    public final float PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory * 2.0f;
    }
}

package id.dana.core.ui.showcase.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import id.dana.component.utils.SizeUtil;

/* loaded from: classes4.dex */
public class CircleShape implements Shape {
    private static final float BuiltInFictitiousFunctionClassFactory = SizeUtil.PlaceComponentResult(36);
    private float getAuthRequestContext;

    public CircleShape() {
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
    }

    public CircleShape(float f) {
        this.getAuthRequestContext = f;
    }

    @Override // id.dana.core.ui.showcase.shape.Shape
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas, Paint paint, PointF pointF, float f) {
        canvas.drawCircle(pointF.x, pointF.y, f * this.getAuthRequestContext, paint);
    }

    @Override // id.dana.core.ui.showcase.shape.Shape
    public final float PlaceComponentResult() {
        return this.getAuthRequestContext * 2.0f;
    }

    @Override // id.dana.core.ui.showcase.shape.Shape
    public final float getAuthRequestContext() {
        return this.getAuthRequestContext * 2.0f;
    }
}

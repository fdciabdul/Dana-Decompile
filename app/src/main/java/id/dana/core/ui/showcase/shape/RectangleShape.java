package id.dana.core.ui.showcase.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes8.dex */
public class RectangleShape implements Shape {
    private int BuiltInFictitiousFunctionClassFactory;
    private final RectF KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private final float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private int getAuthRequestContext;
    private View lookAheadTest;
    private final RectF moveToNextValue;
    private final float scheduleImpl;

    @Override // id.dana.core.ui.showcase.shape.Shape
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas, Paint paint, PointF pointF, float f) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.left = (this.moveToNextValue.left * f) - this.PlaceComponentResult;
        this.KClassImpl$Data$declaredNonStaticMembers$2.top = (this.moveToNextValue.top * f) - this.getAuthRequestContext;
        this.KClassImpl$Data$declaredNonStaticMembers$2.right = (this.moveToNextValue.right * f) + this.MyBillsEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2.bottom = (this.moveToNextValue.bottom * f) + this.BuiltInFictitiousFunctionClassFactory;
        canvas.drawRoundRect(this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda0, paint);
    }

    @Override // id.dana.core.ui.showcase.shape.Shape
    public final float PlaceComponentResult() {
        return this.lookAheadTest.getHeight();
    }

    @Override // id.dana.core.ui.showcase.shape.Shape
    public final float getAuthRequestContext() {
        return this.lookAheadTest.getWidth();
    }
}

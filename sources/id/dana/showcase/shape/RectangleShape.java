package id.dana.showcase.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes3.dex */
public class RectangleShape implements Shape {
    private int BuiltInFictitiousFunctionClassFactory;
    private final RectF KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private View NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private int getAuthRequestContext;
    private final float getErrorConfigVersion;
    private final float lookAheadTest;
    private final RectF scheduleImpl;

    public RectangleShape(View view, float f, float f2) {
        RectF rectF = new RectF();
        this.scheduleImpl = rectF;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new RectF();
        this.MyBillsEntityDataFactory = 0;
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.getAuthRequestContext = 0;
        this.PlaceComponentResult = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.lookAheadTest = f;
        this.getErrorConfigVersion = f2;
        view.getLocationInWindow(new int[2]);
        rectF.left = r4[0];
        rectF.top = r4[1];
        rectF.bottom = rectF.top + view.getHeight();
        rectF.right = rectF.left + view.getWidth();
    }

    public RectangleShape(View view, float f, float f2, int i, int i2, int i3, int i4) {
        this(view, f, f2);
        this.PlaceComponentResult = i;
        this.MyBillsEntityDataFactory = i2;
        this.getAuthRequestContext = i3;
        this.BuiltInFictitiousFunctionClassFactory = i4;
    }

    @Override // id.dana.showcase.shape.Shape
    public final void getAuthRequestContext(Canvas canvas, Paint paint, PointF pointF, float f) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.left = (this.scheduleImpl.left * f) - this.PlaceComponentResult;
        this.KClassImpl$Data$declaredNonStaticMembers$2.top = (this.scheduleImpl.top * f) - this.MyBillsEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2.right = (this.scheduleImpl.right * f) + this.getAuthRequestContext;
        this.KClassImpl$Data$declaredNonStaticMembers$2.bottom = (this.scheduleImpl.bottom * f) + this.BuiltInFictitiousFunctionClassFactory;
        canvas.drawRoundRect(this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, this.getErrorConfigVersion, paint);
    }

    @Override // id.dana.showcase.shape.Shape
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getHeight();
    }

    @Override // id.dana.showcase.shape.Shape
    public final float PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getWidth();
    }
}

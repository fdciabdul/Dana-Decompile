package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.WormAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

/* loaded from: classes3.dex */
public class WormDrawer extends BaseDrawer {
    public RectF BuiltInFictitiousFunctionClassFactory;

    public WormDrawer(Paint paint, Indicator indicator) {
        super(paint, indicator);
        this.BuiltInFictitiousFunctionClassFactory = new RectF();
    }

    public void MyBillsEntityDataFactory(Canvas canvas, Value value, int i, int i2) {
        if (value instanceof WormAnimationValue) {
            WormAnimationValue wormAnimationValue = (WormAnimationValue) value;
            int i3 = wormAnimationValue.MyBillsEntityDataFactory;
            int i4 = wormAnimationValue.BuiltInFictitiousFunctionClassFactory;
            int i5 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8;
            int i6 = this.KClassImpl$Data$declaredNonStaticMembers$2.FragmentBottomSheetPaymentSettingBinding;
            int i7 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6;
            Indicator indicator = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 = Orientation.HORIZONTAL;
            }
            if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == Orientation.HORIZONTAL) {
                this.BuiltInFictitiousFunctionClassFactory.left = i3;
                this.BuiltInFictitiousFunctionClassFactory.right = i4;
                this.BuiltInFictitiousFunctionClassFactory.top = i2 - i5;
                this.BuiltInFictitiousFunctionClassFactory.bottom = i2 + i5;
            } else {
                this.BuiltInFictitiousFunctionClassFactory.left = i - i5;
                this.BuiltInFictitiousFunctionClassFactory.right = i + i5;
                this.BuiltInFictitiousFunctionClassFactory.top = i3;
                this.BuiltInFictitiousFunctionClassFactory.bottom = i4;
            }
            this.PlaceComponentResult.setColor(i6);
            float f = i;
            float f2 = i2;
            float f3 = i5;
            canvas.drawCircle(f, f2, f3, this.PlaceComponentResult);
            this.PlaceComponentResult.setColor(i7);
            canvas.drawRoundRect(this.BuiltInFictitiousFunctionClassFactory, f3, f3, this.PlaceComponentResult);
        }
    }
}

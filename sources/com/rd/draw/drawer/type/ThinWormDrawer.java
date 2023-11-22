package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.ThinWormAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

/* loaded from: classes3.dex */
public class ThinWormDrawer extends WormDrawer {
    public ThinWormDrawer(Paint paint, Indicator indicator) {
        super(paint, indicator);
    }

    @Override // com.rd.draw.drawer.type.WormDrawer
    public final void MyBillsEntityDataFactory(Canvas canvas, Value value, int i, int i2) {
        if (value instanceof ThinWormAnimationValue) {
            ThinWormAnimationValue thinWormAnimationValue = (ThinWormAnimationValue) value;
            int i3 = thinWormAnimationValue.MyBillsEntityDataFactory;
            int i4 = thinWormAnimationValue.BuiltInFictitiousFunctionClassFactory;
            int i5 = thinWormAnimationValue.getAuthRequestContext / 2;
            int i6 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8;
            int i7 = this.KClassImpl$Data$declaredNonStaticMembers$2.FragmentBottomSheetPaymentSettingBinding;
            int i8 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6;
            Indicator indicator = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 = Orientation.HORIZONTAL;
            }
            if (indicator.NetworkUserEntityData$$ExternalSyntheticLambda2 == Orientation.HORIZONTAL) {
                this.BuiltInFictitiousFunctionClassFactory.left = i3;
                this.BuiltInFictitiousFunctionClassFactory.right = i4;
                this.BuiltInFictitiousFunctionClassFactory.top = i2 - i5;
                this.BuiltInFictitiousFunctionClassFactory.bottom = i5 + i2;
            } else {
                this.BuiltInFictitiousFunctionClassFactory.left = i - i5;
                this.BuiltInFictitiousFunctionClassFactory.right = i5 + i;
                this.BuiltInFictitiousFunctionClassFactory.top = i3;
                this.BuiltInFictitiousFunctionClassFactory.bottom = i4;
            }
            this.PlaceComponentResult.setColor(i7);
            float f = i;
            float f2 = i2;
            float f3 = i6;
            canvas.drawCircle(f, f2, f3, this.PlaceComponentResult);
            this.PlaceComponentResult.setColor(i8);
            canvas.drawRoundRect(this.BuiltInFictitiousFunctionClassFactory, f3, f3, this.PlaceComponentResult);
        }
    }
}

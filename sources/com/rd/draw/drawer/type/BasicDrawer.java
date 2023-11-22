package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;

/* loaded from: classes3.dex */
public class BasicDrawer extends BaseDrawer {
    private Paint BuiltInFictitiousFunctionClassFactory;

    public BasicDrawer(Paint paint, Indicator indicator) {
        super(paint, indicator);
        Paint paint2 = new Paint();
        this.BuiltInFictitiousFunctionClassFactory = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.BuiltInFictitiousFunctionClassFactory.setAntiAlias(true);
        this.BuiltInFictitiousFunctionClassFactory.setStrokeWidth(indicator.NetworkUserEntityData$$ExternalSyntheticLambda5);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas, int i, boolean z, int i2, int i3) {
        Paint paint;
        float f = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5;
        float f2 = this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext;
        int i5 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6;
        int i6 = this.KClassImpl$Data$declaredNonStaticMembers$2.FragmentBottomSheetPaymentSettingBinding;
        int i7 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4;
        Indicator indicator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (indicator.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            indicator.KClassImpl$Data$declaredNonStaticMembers$2 = AnimationType.NONE;
        }
        AnimationType animationType = indicator.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((animationType == AnimationType.SCALE && !z) || (animationType == AnimationType.SCALE_DOWN && z)) {
            f *= f2;
        }
        if (i != i7) {
            i5 = i6;
        }
        if (animationType == AnimationType.FILL && i != i7) {
            paint = this.BuiltInFictitiousFunctionClassFactory;
            paint.setStrokeWidth(i4);
        } else {
            paint = this.PlaceComponentResult;
        }
        paint.setColor(i5);
        canvas.drawCircle(i2, i3, f, paint);
    }
}

package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.FillAnimationValue;

/* loaded from: classes3.dex */
public class FillAnimation extends ColorAnimation {
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int lookAheadTest;
    private FillAnimationValue scheduleImpl;

    @Override // com.rd.animation.type.ColorAnimation, com.rd.animation.type.BaseAnimation
    public final /* synthetic */ ValueAnimator KClassImpl$Data$declaredNonStaticMembers$2() {
        return KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public FillAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.scheduleImpl = new FillAnimationValue();
    }

    @Override // com.rd.animation.type.ColorAnimation
    /* renamed from: getAuthRequestContext */
    public final ValueAnimator KClassImpl$Data$declaredNonStaticMembers$2() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.rd.animation.type.FillAnimation.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                FillAnimation.MyBillsEntityDataFactory(FillAnimation.this, valueAnimator2);
            }
        });
        return valueAnimator;
    }

    public final FillAnimation BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, int i4) {
        if (this.PlaceComponentResult != 0 && MyBillsEntityDataFactory(i, i2, i3, i4)) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.getAuthRequestContext = i2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i3;
            this.lookAheadTest = i4;
            ((ValueAnimator) this.PlaceComponentResult).setValues(PlaceComponentResult(false), PlaceComponentResult(true), BuiltInFictitiousFunctionClassFactory(false), BuiltInFictitiousFunctionClassFactory(true), MyBillsEntityDataFactory(false), MyBillsEntityDataFactory(true));
        }
        return this;
    }

    private PropertyValuesHolder BuiltInFictitiousFunctionClassFactory(boolean z) {
        int i;
        int i2;
        String str;
        if (z) {
            i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            i = i2 / 2;
            str = "ANIMATION_RADIUS_REVERSE";
        } else {
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            i2 = i / 2;
            str = "ANIMATION_RADIUS";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i, i2);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private PropertyValuesHolder MyBillsEntityDataFactory(boolean z) {
        String str;
        int i;
        int i2;
        if (z) {
            i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            str = "ANIMATION_STROKE_REVERSE";
            i = 0;
        } else {
            str = "ANIMATION_STROKE";
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            i2 = 0;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean MyBillsEntityDataFactory(int i, int i2, int i3, int i4) {
        return (this.BuiltInFictitiousFunctionClassFactory == i && this.getAuthRequestContext == i2 && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == i3 && this.lookAheadTest == i4) ? false : true;
    }

    static /* synthetic */ void MyBillsEntityDataFactory(FillAnimation fillAnimation, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS")).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS_REVERSE")).intValue();
        int intValue5 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE")).intValue();
        int intValue6 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE_REVERSE")).intValue();
        fillAnimation.scheduleImpl.PlaceComponentResult = intValue;
        fillAnimation.scheduleImpl.MyBillsEntityDataFactory = intValue2;
        fillAnimation.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 = intValue3;
        fillAnimation.scheduleImpl.getAuthRequestContext = intValue4;
        fillAnimation.scheduleImpl.BuiltInFictitiousFunctionClassFactory = intValue5;
        fillAnimation.scheduleImpl.getErrorConfigVersion = intValue6;
        if (fillAnimation.MyBillsEntityDataFactory != null) {
            fillAnimation.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(fillAnimation.scheduleImpl);
        }
    }
}

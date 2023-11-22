package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ScaleAnimationValue;

/* loaded from: classes3.dex */
public class ScaleAnimation extends ColorAnimation {
    float NetworkUserEntityData$$ExternalSyntheticLambda0;
    int getErrorConfigVersion;
    private ScaleAnimationValue scheduleImpl;

    @Override // com.rd.animation.type.ColorAnimation, com.rd.animation.type.BaseAnimation
    public final /* synthetic */ ValueAnimator KClassImpl$Data$declaredNonStaticMembers$2() {
        return KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public ScaleAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.scheduleImpl = new ScaleAnimationValue();
    }

    @Override // com.rd.animation.type.ColorAnimation
    /* renamed from: getAuthRequestContext */
    public final ValueAnimator KClassImpl$Data$declaredNonStaticMembers$2() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.rd.animation.type.ScaleAnimation.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ScaleAnimation.MyBillsEntityDataFactory(ScaleAnimation.this, valueAnimator2);
            }
        });
        return valueAnimator;
    }

    public final ScaleAnimation KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, float f) {
        if (this.PlaceComponentResult != 0 && getAuthRequestContext(i, i2, i3, f)) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.getAuthRequestContext = i2;
            this.getErrorConfigVersion = i3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
            ((ValueAnimator) this.PlaceComponentResult).setValues(PlaceComponentResult(false), PlaceComponentResult(true), getAuthRequestContext(false), getAuthRequestContext(true));
        }
        return this;
    }

    protected PropertyValuesHolder getAuthRequestContext(boolean z) {
        int i;
        int i2;
        String str;
        if (z) {
            i2 = this.getErrorConfigVersion;
            i = (int) (i2 * this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            str = "ANIMATION_SCALE_REVERSE";
        } else {
            i = this.getErrorConfigVersion;
            i2 = (int) (i * this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            str = "ANIMATION_SCALE";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean getAuthRequestContext(int i, int i2, int i3, float f) {
        return (this.BuiltInFictitiousFunctionClassFactory == i && this.getAuthRequestContext == i2 && this.getErrorConfigVersion == i3 && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == f) ? false : true;
    }

    static /* synthetic */ void MyBillsEntityDataFactory(ScaleAnimation scaleAnimation, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE")).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE_REVERSE")).intValue();
        scaleAnimation.scheduleImpl.PlaceComponentResult = intValue;
        scaleAnimation.scheduleImpl.MyBillsEntityDataFactory = intValue2;
        scaleAnimation.scheduleImpl.BuiltInFictitiousFunctionClassFactory = intValue3;
        scaleAnimation.scheduleImpl.getAuthRequestContext = intValue4;
        if (scaleAnimation.MyBillsEntityDataFactory != null) {
            scaleAnimation.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(scaleAnimation.scheduleImpl);
        }
    }
}

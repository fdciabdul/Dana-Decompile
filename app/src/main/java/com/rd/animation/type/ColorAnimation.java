package com.rd.animation.type;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ColorAnimationValue;

/* loaded from: classes3.dex */
public class ColorAnimation extends BaseAnimation<ValueAnimator> {
    int BuiltInFictitiousFunctionClassFactory;
    int getAuthRequestContext;
    private ColorAnimationValue moveToNextValue;

    public ColorAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.moveToNextValue = new ColorAnimationValue();
    }

    @Override // com.rd.animation.type.BaseAnimation
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public ValueAnimator KClassImpl$Data$declaredNonStaticMembers$2() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.rd.animation.type.ColorAnimation.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ColorAnimation.KClassImpl$Data$declaredNonStaticMembers$2(ColorAnimation.this, valueAnimator2);
            }
        });
        return valueAnimator;
    }

    public final ColorAnimation BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        if (this.PlaceComponentResult != 0 && getAuthRequestContext(i, i2)) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.getAuthRequestContext = i2;
            ((ValueAnimator) this.PlaceComponentResult).setValues(PlaceComponentResult(false), PlaceComponentResult(true));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PropertyValuesHolder PlaceComponentResult(boolean z) {
        int i;
        int i2;
        String str;
        if (z) {
            i = this.getAuthRequestContext;
            i2 = this.BuiltInFictitiousFunctionClassFactory;
            str = "ANIMATION_COLOR_REVERSE";
        } else {
            i = this.BuiltInFictitiousFunctionClassFactory;
            i2 = this.getAuthRequestContext;
            str = "ANIMATION_COLOR";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i, i2);
        ofInt.setEvaluator(new ArgbEvaluator());
        return ofInt;
    }

    private boolean getAuthRequestContext(int i, int i2) {
        return (this.BuiltInFictitiousFunctionClassFactory == i && this.getAuthRequestContext == i2) ? false : true;
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ColorAnimation colorAnimation, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        colorAnimation.moveToNextValue.PlaceComponentResult = intValue;
        colorAnimation.moveToNextValue.MyBillsEntityDataFactory = intValue2;
        if (colorAnimation.MyBillsEntityDataFactory != null) {
            colorAnimation.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(colorAnimation.moveToNextValue);
        }
    }

    @Override // com.rd.animation.type.BaseAnimation
    public final /* synthetic */ BaseAnimation getAuthRequestContext(float f) {
        if (this.PlaceComponentResult != 0) {
            long j = f * ((float) this.KClassImpl$Data$declaredNonStaticMembers$2);
            if (((ValueAnimator) this.PlaceComponentResult).getValues() != null && ((ValueAnimator) this.PlaceComponentResult).getValues().length > 0) {
                ((ValueAnimator) this.PlaceComponentResult).setCurrentPlayTime(j);
            }
        }
        return this;
    }
}

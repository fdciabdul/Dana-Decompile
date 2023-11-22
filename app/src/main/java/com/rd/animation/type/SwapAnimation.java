package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.SwapAnimationValue;

/* loaded from: classes3.dex */
public class SwapAnimation extends BaseAnimation<ValueAnimator> {
    private int BuiltInFictitiousFunctionClassFactory;
    private int getAuthRequestContext;
    private SwapAnimationValue lookAheadTest;

    public SwapAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.getAuthRequestContext = -1;
        this.BuiltInFictitiousFunctionClassFactory = -1;
        this.lookAheadTest = new SwapAnimationValue();
    }

    public final SwapAnimation BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        if (this.PlaceComponentResult != 0 && KClassImpl$Data$declaredNonStaticMembers$2(i, i2)) {
            this.getAuthRequestContext = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("ANIMATION_COORDINATE", i, i2);
            ofInt.setEvaluator(new IntEvaluator());
            PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("ANIMATION_COORDINATE_REVERSE", i2, i);
            ofInt2.setEvaluator(new IntEvaluator());
            ((ValueAnimator) this.PlaceComponentResult).setValues(ofInt, ofInt2);
        }
        return this;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        return (this.getAuthRequestContext == i && this.BuiltInFictitiousFunctionClassFactory == i2) ? false : true;
    }

    static /* synthetic */ void PlaceComponentResult(SwapAnimation swapAnimation, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE_REVERSE")).intValue();
        swapAnimation.lookAheadTest.BuiltInFictitiousFunctionClassFactory = intValue;
        swapAnimation.lookAheadTest.getAuthRequestContext = intValue2;
        if (swapAnimation.MyBillsEntityDataFactory != null) {
            swapAnimation.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(swapAnimation.lookAheadTest);
        }
    }

    @Override // com.rd.animation.type.BaseAnimation
    public final /* synthetic */ ValueAnimator KClassImpl$Data$declaredNonStaticMembers$2() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.rd.animation.type.SwapAnimation.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SwapAnimation.PlaceComponentResult(SwapAnimation.this, valueAnimator2);
            }
        });
        return valueAnimator;
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

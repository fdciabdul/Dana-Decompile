package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.SlideAnimationValue;

/* loaded from: classes3.dex */
public class SlideAnimation extends BaseAnimation<ValueAnimator> {
    private int BuiltInFictitiousFunctionClassFactory;
    private int getAuthRequestContext;
    private SlideAnimationValue lookAheadTest;

    public SlideAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.BuiltInFictitiousFunctionClassFactory = -1;
        this.getAuthRequestContext = -1;
        this.lookAheadTest = new SlideAnimationValue();
    }

    public final SlideAnimation BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        if (this.PlaceComponentResult != 0 && KClassImpl$Data$declaredNonStaticMembers$2(i, i2)) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.getAuthRequestContext = i2;
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("ANIMATION_COORDINATE", i, i2);
            ofInt.setEvaluator(new IntEvaluator());
            ((ValueAnimator) this.PlaceComponentResult).setValues(ofInt);
        }
        return this;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        return (this.BuiltInFictitiousFunctionClassFactory == i && this.getAuthRequestContext == i2) ? false : true;
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SlideAnimation slideAnimation, ValueAnimator valueAnimator) {
        slideAnimation.lookAheadTest.PlaceComponentResult = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE")).intValue();
        if (slideAnimation.MyBillsEntityDataFactory != null) {
            slideAnimation.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(slideAnimation.lookAheadTest);
        }
    }

    @Override // com.rd.animation.type.BaseAnimation
    public final /* synthetic */ ValueAnimator KClassImpl$Data$declaredNonStaticMembers$2() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.rd.animation.type.SlideAnimation.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SlideAnimation.BuiltInFictitiousFunctionClassFactory(SlideAnimation.this, valueAnimator2);
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

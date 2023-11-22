package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.github.mikephil.charting.animation.Easing;

/* loaded from: classes3.dex */
public class ChartAnimator {
    public ValueAnimator.AnimatorUpdateListener MyBillsEntityDataFactory;
    protected float PlaceComponentResult = 1.0f;
    protected float getAuthRequestContext = 1.0f;

    public ChartAnimator() {
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.MyBillsEntityDataFactory = animatorUpdateListener;
    }

    public final void MyBillsEntityDataFactory(int i, int i2, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        ofFloat2.setInterpolator(easingFunction2);
        ofFloat2.setDuration(i2);
        if (i > i2) {
            ofFloat.addUpdateListener(this.MyBillsEntityDataFactory);
        } else {
            ofFloat2.addUpdateListener(this.MyBillsEntityDataFactory);
        }
        ofFloat.start();
        ofFloat2.start();
    }

    public final float MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }

    public final float PlaceComponentResult() {
        return this.getAuthRequestContext;
    }
}

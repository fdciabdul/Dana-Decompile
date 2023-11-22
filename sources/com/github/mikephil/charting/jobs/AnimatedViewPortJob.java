package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import id.dana.domain.foundation.logger.PerformanceConstant;

/* loaded from: classes7.dex */
public abstract class AnimatedViewPortJob extends ViewPortJob implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    protected float BuiltInFictitiousFunctionClassFactory;
    protected ObjectAnimator KClassImpl$Data$declaredNonStaticMembers$2;
    protected float MyBillsEntityDataFactory;
    protected float getAuthRequestContext;

    public abstract void PlaceComponentResult();

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
    }

    public AnimatedViewPortJob() {
        super(null, 0.0f, 0.0f, null, null);
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.MyBillsEntityDataFactory = 0.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, PerformanceConstant.PERFORMANCE_PHASE, 0.0f, 1.0f);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ofFloat;
        ofFloat.setDuration(0L);
        this.KClassImpl$Data$declaredNonStaticMembers$2.addUpdateListener(this);
        this.KClassImpl$Data$declaredNonStaticMembers$2.addListener(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.removeAllListeners();
        this.KClassImpl$Data$declaredNonStaticMembers$2.removeAllUpdateListeners();
        this.KClassImpl$Data$declaredNonStaticMembers$2.reverse();
        this.KClassImpl$Data$declaredNonStaticMembers$2.addUpdateListener(this);
        this.KClassImpl$Data$declaredNonStaticMembers$2.addListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        try {
            PlaceComponentResult();
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        try {
            PlaceComponentResult();
        } catch (IllegalArgumentException unused) {
        }
    }
}

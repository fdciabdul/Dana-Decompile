package com.zhuinden.simplestack.navigator.changehandlers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.zhuinden.simplestack.navigator.ViewChangeHandler;
import com.zhuinden.simplestack.navigator.changehandlers.ViewUtils;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class AnimatorViewChangeHandler implements ViewChangeHandler {
    private Long startDelay = null;
    private Interpolator interpolator = null;
    private Long duration = null;

    protected abstract Animator createAnimator(@Nonnull View view, @Nonnull View view2, int i);

    protected void resetPreviousViewValues(View view) {
    }

    @Override // com.zhuinden.simplestack.navigator.ViewChangeHandler
    public void performViewChange(@Nonnull final ViewGroup viewGroup, @Nonnull final View view, @Nonnull final View view2, final int i, @Nonnull final ViewChangeHandler.ViewChangeCallback viewChangeCallback) {
        viewGroup.addView(view2);
        ViewUtils.waitForMeasure(view2, new ViewUtils.OnMeasuredCallback() { // from class: com.zhuinden.simplestack.navigator.changehandlers.AnimatorViewChangeHandler.1
            @Override // com.zhuinden.simplestack.navigator.changehandlers.ViewUtils.OnMeasuredCallback
            public void onMeasured(View view3, int i2, int i3) {
                AnimatorViewChangeHandler.this.runAnimation(view, view2, i, new AnimatorListenerAdapter() { // from class: com.zhuinden.simplestack.navigator.changehandlers.AnimatorViewChangeHandler.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        viewGroup.removeView(view);
                        AnimatorViewChangeHandler.this.resetPreviousViewValues(view);
                        viewChangeCallback.onCompleted();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runAnimation(View view, View view2, int i, AnimatorListenerAdapter animatorListenerAdapter) {
        Animator createAnimator = createAnimator(view, view2, i);
        createAnimator.addListener(animatorListenerAdapter);
        Long l = this.duration;
        if (l != null) {
            createAnimator.setDuration(l.longValue());
        }
        Interpolator interpolator = this.interpolator;
        if (interpolator != null) {
            createAnimator.setInterpolator(interpolator);
        }
        Long l2 = this.startDelay;
        if (l2 != null) {
            createAnimator.setStartDelay(l2.longValue());
        }
        createAnimator.start();
    }

    @Nullable
    public Long getStartDelay() {
        return this.startDelay;
    }

    public AnimatorViewChangeHandler setStartDelay(@Nullable Long l) {
        this.startDelay = l;
        return this;
    }

    @Nullable
    public Interpolator getInterpolator() {
        return this.interpolator;
    }

    public AnimatorViewChangeHandler setInterpolator(@Nullable Interpolator interpolator) {
        this.interpolator = interpolator;
        return this;
    }

    @Nullable
    public Long getDuration() {
        return this.duration;
    }

    public AnimatorViewChangeHandler setDuration(@Nullable Long l) {
        this.duration = l;
        return this;
    }
}

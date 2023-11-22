package com.zhuinden.simplestack.navigator.changehandlers;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public final class SegueViewChangeHandler extends AnimatorViewChangeHandler {
    @Override // com.zhuinden.simplestack.navigator.changehandlers.AnimatorViewChangeHandler
    protected final Animator createAnimator(@Nonnull View view, @Nonnull View view2, int i) {
        int width = view.getWidth();
        int width2 = view2.getWidth();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(view, "translationX", i * (-1) * width));
        animatorSet.play(ObjectAnimator.ofFloat(view2, "translationX", i * width2, 0.0f));
        return animatorSet;
    }

    @Override // com.zhuinden.simplestack.navigator.changehandlers.AnimatorViewChangeHandler
    protected final void resetPreviousViewValues(View view) {
        view.setTranslationX(0.0f);
    }
}

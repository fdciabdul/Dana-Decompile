package com.zhuinden.simplestack.navigator.changehandlers;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public final class FadeViewChangeHandler extends AnimatorViewChangeHandler {
    @Override // com.zhuinden.simplestack.navigator.changehandlers.AnimatorViewChangeHandler
    protected final Animator createAnimator(@Nonnull View view, @Nonnull View view2, int i) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f));
        animatorSet.play(ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f));
        return animatorSet;
    }

    @Override // com.zhuinden.simplestack.navigator.changehandlers.AnimatorViewChangeHandler
    protected final void resetPreviousViewValues(View view) {
        view.setAlpha(1.0f);
    }
}

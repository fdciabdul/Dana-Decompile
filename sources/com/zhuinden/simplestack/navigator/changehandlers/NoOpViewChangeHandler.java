package com.zhuinden.simplestack.navigator.changehandlers;

import android.view.View;
import android.view.ViewGroup;
import com.zhuinden.simplestack.navigator.ViewChangeHandler;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public final class NoOpViewChangeHandler implements ViewChangeHandler {
    @Override // com.zhuinden.simplestack.navigator.ViewChangeHandler
    public final void performViewChange(@Nonnull ViewGroup viewGroup, @Nonnull View view, @Nonnull View view2, int i, @Nonnull ViewChangeHandler.ViewChangeCallback viewChangeCallback) {
        viewGroup.removeView(view);
        viewGroup.addView(view2);
        viewChangeCallback.onCompleted();
    }
}

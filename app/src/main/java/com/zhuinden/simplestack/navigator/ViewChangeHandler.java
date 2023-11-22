package com.zhuinden.simplestack.navigator;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public interface ViewChangeHandler {

    /* loaded from: classes2.dex */
    public interface ViewChangeCallback {
        void onCompleted();
    }

    void performViewChange(@Nonnull ViewGroup viewGroup, @Nonnull View view, @Nonnull View view2, int i, @Nonnull ViewChangeCallback viewChangeCallback);
}

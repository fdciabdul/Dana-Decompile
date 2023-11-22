package com.zhuinden.simplestack.navigator;

import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public interface DefaultViewKey {
    int layout();

    @Nonnull
    ViewChangeHandler viewChangeHandler();
}

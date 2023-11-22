package com.zhuinden.simplestack;

import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public interface StateChanger {

    /* loaded from: classes2.dex */
    public interface Callback {
        void stateChangeComplete();
    }

    void handleStateChange(@Nonnull StateChange stateChange, @Nonnull Callback callback);
}

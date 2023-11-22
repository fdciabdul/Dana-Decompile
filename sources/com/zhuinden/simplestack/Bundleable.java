package com.zhuinden.simplestack;

import com.zhuinden.statebundle.StateBundle;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface Bundleable {
    void fromBundle(@Nullable StateBundle stateBundle);

    @Nonnull
    StateBundle toBundle();
}

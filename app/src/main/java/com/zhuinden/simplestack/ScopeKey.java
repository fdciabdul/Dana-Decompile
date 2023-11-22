package com.zhuinden.simplestack;

import java.util.List;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public interface ScopeKey {

    /* loaded from: classes2.dex */
    public interface Child {
        @Nonnull
        List<String> getParentScopes();
    }

    @Nonnull
    String getScopeTag();
}

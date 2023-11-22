package com.zhuinden.simplestack;

import java.util.List;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public interface KeyFilter {
    @Nonnull
    List<Object> filterHistory(@Nonnull List<Object> list);
}

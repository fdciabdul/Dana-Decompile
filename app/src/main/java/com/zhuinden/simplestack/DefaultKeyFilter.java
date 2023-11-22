package com.zhuinden.simplestack;

import java.util.List;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public class DefaultKeyFilter implements KeyFilter {
    @Override // com.zhuinden.simplestack.KeyFilter
    @Nonnull
    public List<Object> filterHistory(@Nonnull List<Object> list) {
        return list;
    }
}

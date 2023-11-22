package org.yaml.snakeyaml.util;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class ArrayStack<T> {
    public final ArrayList<T> getAuthRequestContext;

    public ArrayStack(int i) {
        this.getAuthRequestContext = new ArrayList<>(i);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext.isEmpty();
    }
}

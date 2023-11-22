package com.google.android.gms.internal.common;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import org.jspecify.nullness.NullMarked;

@NullMarked
/* loaded from: classes7.dex */
public abstract class zzaj implements Iterator, j$.util.Iterator {
    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

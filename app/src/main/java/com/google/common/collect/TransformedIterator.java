package com.google.common.collect;

import com.google.common.base.Preconditions;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes3.dex */
public abstract class TransformedIterator<F, T> implements Iterator<T>, j$.util.Iterator {
    final Iterator<? extends F> backingIterator;

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ParametricNullness
    public abstract T transform(@ParametricNullness F f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformedIterator(java.util.Iterator<? extends F> it) {
        this.backingIterator = (java.util.Iterator) Preconditions.checkNotNull(it);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.backingIterator.hasNext();
    }

    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        return transform(this.backingIterator.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.backingIterator.remove();
    }
}

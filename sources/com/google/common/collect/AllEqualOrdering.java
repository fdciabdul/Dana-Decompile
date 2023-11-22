package com.google.common.collect;

import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
final class AllEqualOrdering extends Ordering<Object> implements Serializable {
    static final AllEqualOrdering INSTANCE = new AllEqualOrdering();
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return 0;
    }

    @Override // com.google.common.collect.Ordering
    public final <S> Ordering<S> reverse() {
        return this;
    }

    public final String toString() {
        return "Ordering.allEqual()";
    }

    AllEqualOrdering() {
    }

    @Override // com.google.common.collect.Ordering
    public final <E> List<E> sortedCopy(Iterable<E> iterable) {
        return Lists.newArrayList(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public final <E> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.copyOf(iterable);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

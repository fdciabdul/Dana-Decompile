package com.alibaba.ariver.kernel.common.immutable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes6.dex */
public class ImmutableSet<E> extends ImmutableCollection<E> implements Immutable<Set<E>> {
    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ boolean containsAll(Collection collection) {
        return super.containsAll(collection);
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.ImmutableCollection
    public /* bridge */ /* synthetic */ Object[] toArray() {
        return super.toArray();
    }

    public ImmutableSet(Collection<E> collection) {
        super(collection);
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.Immutable
    public Set<E> mutable() {
        return new HashSet(this.immutableCollection);
    }
}

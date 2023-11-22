package com.alibaba.ariver.kernel.common.immutable;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
class ImmutableCollection<E> implements Iterable<E> {

    /* renamed from: a  reason: collision with root package name */
    private static Iterator f6119a = new AnonymousClass1();
    protected Collection<E> immutableCollection;

    /* renamed from: com.alibaba.ariver.kernel.common.immutable.ImmutableCollection$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass1 implements Iterator, j$.util.Iterator {
        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            return null;
        }

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("removing is unsupported");
        }
    }

    /* loaded from: classes3.dex */
    static class ImmutableIterator implements java.util.Iterator, j$.util.Iterator {

        /* renamed from: a  reason: collision with root package name */
        private java.util.Iterator f6120a;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        public ImmutableIterator(java.util.Iterator it) {
            this.f6120a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            java.util.Iterator it = this.f6120a;
            return it != null && it.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            java.util.Iterator it = this.f6120a;
            if (it != null) {
                return it.next();
            }
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("removing is unsupported");
        }
    }

    public ImmutableCollection(Collection<E> collection) {
        this.immutableCollection = collection;
    }

    public ImmutableCollection() {
    }

    public int size() {
        Collection<E> collection = this.immutableCollection;
        if (collection != null) {
            return collection.size();
        }
        return 0;
    }

    public boolean isEmpty() {
        Collection<E> collection = this.immutableCollection;
        return collection == null || collection.isEmpty();
    }

    public boolean contains(Object obj) {
        Collection<E> collection = this.immutableCollection;
        return collection != null && collection.contains(obj);
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<E> iterator() {
        Collection<E> collection = this.immutableCollection;
        if (collection == null) {
            return f6119a;
        }
        return new ImmutableIterator(collection.iterator());
    }

    public Object[] toArray() {
        Collection<E> collection = this.immutableCollection;
        if (collection != null) {
            return collection.toArray();
        }
        return null;
    }

    public boolean containsAll(Collection<?> collection) {
        Collection<E> collection2 = this.immutableCollection;
        return collection2 != null && collection2.containsAll(collection);
    }
}

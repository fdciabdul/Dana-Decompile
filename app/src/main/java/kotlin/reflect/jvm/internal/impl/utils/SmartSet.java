package kotlin.reflect.jvm.internal.impl.utils;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes.dex */
public final class SmartSet<T> extends AbstractSet<T> {
    public static final Companion Companion = new Companion(null);
    private Object data;
    private int size;

    public /* synthetic */ SmartSet(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final <T> SmartSet<T> create() {
        return Companion.create();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return getSize();
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <T> SmartSet<T> create() {
            return new SmartSet<>(null);
        }

        @JvmStatic
        public final <T> SmartSet<T> create(Collection<? extends T> collection) {
            Intrinsics.checkNotNullParameter(collection, "");
            SmartSet<T> smartSet = new SmartSet<>(null);
            smartSet.addAll(collection);
            return smartSet;
        }
    }

    private SmartSet() {
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new SingletonIterator(this.data);
        }
        if (size() < 5) {
            Object obj = this.data;
            Intrinsics.checkNotNull(obj);
            return new ArrayIterator((Object[]) obj);
        }
        Object obj2 = this.data;
        Intrinsics.checkNotNull(obj2);
        return TypeIntrinsics.asMutableSet(obj2).iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.AbstractCollection, java.util.LinkedHashSet] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(T t) {
        Object[] objArr;
        if (size() == 0) {
            this.data = t;
        } else if (size() == 1) {
            if (Intrinsics.areEqual(this.data, t)) {
                return false;
            }
            this.data = new Object[]{this.data, t};
        } else if (size() < 5) {
            Object obj = this.data;
            Intrinsics.checkNotNull(obj);
            Object[] objArr2 = (Object[]) obj;
            if (ArraysKt.contains(objArr2, t)) {
                return false;
            }
            if (size() == 4) {
                ?? linkedSetOf = SetsKt.linkedSetOf(Arrays.copyOf(objArr2, objArr2.length));
                linkedSetOf.add(t);
                objArr = linkedSetOf;
            } else {
                Object[] copyOf = Arrays.copyOf(objArr2, size() + 1);
                Intrinsics.checkNotNullExpressionValue(copyOf, "");
                copyOf[copyOf.length - 1] = t;
                objArr = copyOf;
            }
            this.data = objArr;
        } else {
            Object obj2 = this.data;
            Intrinsics.checkNotNull(obj2);
            if (!TypeIntrinsics.asMutableSet(obj2).add(t)) {
                return false;
            }
        }
        setSize(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.data = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return Intrinsics.areEqual(this.data, obj);
        }
        if (size() < 5) {
            Object obj2 = this.data;
            Intrinsics.checkNotNull(obj2);
            return ArraysKt.contains((Object[]) obj2, obj);
        }
        Object obj3 = this.data;
        Intrinsics.checkNotNull(obj3);
        return ((Set) obj3).contains(obj);
    }

    /* loaded from: classes.dex */
    static final class SingletonIterator<T> implements Iterator<T>, KMutableIterator, j$.util.Iterator {
        private final T element;
        private boolean hasNext = true;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        public SingletonIterator(T t) {
            this.element = t;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.hasNext) {
                this.hasNext = false;
                return this.element;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public final Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    static final class ArrayIterator<T> implements java.util.Iterator<T>, KMutableIterator, j$.util.Iterator {
        private final java.util.Iterator<T> arrayIterator;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        public ArrayIterator(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "");
            this.arrayIterator = ArrayIteratorKt.iterator(tArr);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.arrayIterator.hasNext();
        }

        @Override // java.util.Iterator
        public final T next() {
            return this.arrayIterator.next();
        }

        @Override // java.util.Iterator
        public final Void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

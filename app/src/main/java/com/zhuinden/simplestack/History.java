package com.zhuinden.simplestack;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class History<T> extends AbstractList<T> implements List<T>, j$.util.List {
    private final List<T> elements;

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    @Override // java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Stream.Wrapper.MyBillsEntityDataFactory(parallelStream());
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return removeIf(Predicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(predicate));
    }

    @Override // java.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        replaceAll(UnaryOperator.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(unaryOperator));
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.BuiltInFictitiousFunctionClassFactory(spliterator());
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream stream() {
        return Stream.Wrapper.MyBillsEntityDataFactory(stream());
    }

    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.MyBillsEntityDataFactory(this, intFunction);
    }

    @Override // java.util.Collection
    public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
        return toArray(IntFunction.VivifiedWrapper.MyBillsEntityDataFactory(intFunction));
    }

    History() {
        this(Collections.emptyList());
    }

    History(List<T> list) {
        this.elements = Collections.unmodifiableList(new ArrayList(list));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, K] */
    @Nullable
    public <K> K top() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object, K] */
    @Nonnull
    public <K> K fromTop(int i) {
        int size = size();
        if (size > 0) {
            int i2 = -size;
            if (i < i2 || i >= size) {
                StringBuilder sb = new StringBuilder();
                sb.append("The provided offset value [");
                sb.append(i);
                sb.append("] was out of range: [");
                sb.append(i2);
                sb.append("; ");
                sb.append(size);
                sb.append(")");
                throw new IllegalArgumentException(sb.toString());
            }
            while (i < 0) {
                i += size;
            }
            return get(((size - 1) - (i % size)) % size);
        }
        throw new IllegalStateException("Cannot obtain elements from an uninitialized history.");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, K] */
    @Nullable
    public <K> K root() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    @Nonnull
    public Builder buildUpon() {
        return builderFrom(this);
    }

    @Nonnull
    public static <T> History<T> of(T... tArr) {
        if (tArr == null) {
            throw new IllegalArgumentException("Cannot provide `null` as a key!");
        }
        for (T t : tArr) {
            if (t == null) {
                throw new IllegalArgumentException("Cannot provide `null` as a key!");
            }
        }
        return builderFrom(Arrays.asList(tArr)).build();
    }

    @Nonnull
    public static <T> History<T> from(@Nonnull List<? extends T> list) {
        return builderFrom(list).build();
    }

    @Nonnull
    public static Builder builderFrom(@Nonnull Backstack backstack) {
        if (backstack == null) {
            throw new IllegalArgumentException("Backstack cannot be null!");
        }
        return newBuilder().addAll(backstack.getHistory());
    }

    @Nonnull
    public static Builder builderFrom(@Nonnull BackstackDelegate backstackDelegate) {
        if (backstackDelegate == null) {
            throw new IllegalArgumentException("BackstackDelegate cannot be null!");
        }
        return builderFrom(backstackDelegate.getBackstack());
    }

    @Nonnull
    public static Builder builderOf(Object... objArr) {
        return builderFrom(Arrays.asList(objArr));
    }

    @Nonnull
    public static Builder builderFrom(@Nonnull List<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("Cannot provide `null` as a key!");
            }
        }
        return newBuilder().addAll(list);
    }

    @Nonnull
    public static Builder newBuilder() {
        return new Builder();
    }

    @Nonnull
    public static <T> History<T> single(@Nonnull T t) {
        return newBuilder().add(t).build();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t) {
        return this.elements.add(t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        return this.elements.set(i, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        this.elements.add(i, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i) {
        return this.elements.remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return this.elements.indexOf(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        return this.elements.lastIndexOf(obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.elements.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, java.util.Collection<? extends T> collection) {
        return this.elements.addAll(i, collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @Nonnull
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }

    @Override // java.util.AbstractList, java.util.List
    @Nonnull
    public ListIterator<T> listIterator() {
        return this.elements.listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    @Nonnull
    public ListIterator<T> listIterator(int i) {
        return this.elements.listIterator(i);
    }

    @Override // java.util.AbstractList, java.util.List
    @Nonnull
    public List<T> subList(int i, int i2) {
        return this.elements.subList(i, i2);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof History)) {
            return this.elements.equals(((History) obj).elements);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return (super.hashCode() * 31) + this.elements.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.elements.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @Nonnull
    public Object[] toArray() {
        return this.elements.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @Nonnull
    public <T1> T1[] toArray(@Nonnull T1[] t1Arr) {
        return (T1[]) this.elements.toArray(t1Arr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        return this.elements.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(@Nonnull java.util.Collection<?> collection) {
        return this.elements.containsAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@Nonnull java.util.Collection<? extends T> collection) {
        return this.elements.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@Nonnull java.util.Collection<?> collection) {
        return this.elements.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@Nonnull java.util.Collection<?> collection) {
        return this.elements.retainAll(collection);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return Arrays.toString(this.elements.toArray());
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.elements.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.elements.size();
    }

    @Override // j$.util.Collection
    public boolean removeIf(j$.util.function.Predicate<? super T> predicate) {
        return Collection.EL.BuiltInFictitiousFunctionClassFactory(this.elements, predicate);
    }

    @Override // j$.util.List
    public void replaceAll(j$.util.function.UnaryOperator<T> unaryOperator) {
        List.EL.MyBillsEntityDataFactory(this.elements, unaryOperator);
    }

    @Override // java.util.List, j$.util.List
    public void sort(Comparator<? super T> comparator) {
        List.EL.PlaceComponentResult(this.elements, comparator);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List, j$.util.List, j$.util.Collection
    public j$.util.Spliterator<T> spliterator() {
        return List.EL.BuiltInFictitiousFunctionClassFactory(this.elements);
    }

    @Override // java.util.Collection, j$.util.Collection
    public j$.util.stream.Stream<T> stream() {
        return Collection.EL.getAuthRequestContext(this.elements);
    }

    @Override // java.util.Collection, j$.util.Collection
    public j$.util.stream.Stream<T> parallelStream() {
        return Collection.EL.BuiltInFictitiousFunctionClassFactory(this.elements);
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public void forEach(j$.util.function.Consumer<? super T> consumer) {
        Iterable.EL.MyBillsEntityDataFactory(this.elements, consumer);
    }

    /* loaded from: classes2.dex */
    public static class Builder implements Iterable<Object> {
        private ArrayList<Object> list = new ArrayList<>();

        Builder() {
        }

        @Nonnull
        public Builder addAll(@Nonnull java.util.List<?> list) {
            if (list == null) {
                throw new IllegalArgumentException("Provided collection cannot be null");
            }
            this.list.addAll(list);
            return this;
        }

        @Nonnull
        public Builder addAllAt(@Nonnull java.util.List<?> list, int i) {
            if (list == null) {
                throw new IllegalArgumentException("Provided collection cannot be null");
            }
            this.list.addAll(i, list);
            return this;
        }

        @Nonnull
        public Builder clear() {
            this.list.clear();
            return this;
        }

        public boolean contains(@Nonnull Object obj) {
            checkKey(obj);
            return this.list.contains(obj);
        }

        public boolean containsAll(@Nonnull java.util.Collection<?> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("Keys cannot be null!");
            }
            return this.list.containsAll(collection);
        }

        public int size() {
            return this.list.size();
        }

        @Nonnull
        public Builder remove(@Nonnull Object obj) {
            checkKey(obj);
            this.list.remove(obj);
            return this;
        }

        @Nonnull
        public Builder removeAt(int i) {
            this.list.remove(i);
            return this;
        }

        @Nonnull
        public Builder retainAll(@Nonnull java.util.Collection<?> collection) {
            checkKeys(collection);
            this.list.retainAll(collection);
            return this;
        }

        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Nonnull
        public Builder removeLast() {
            if (this.list.isEmpty()) {
                throw new IllegalStateException("Cannot remove element from empty builder");
            }
            this.list.remove(r0.size() - 1);
            return this;
        }

        @Nonnull
        public Builder removeUntil(@Nonnull Object obj) {
            checkKey(obj);
            while (!this.list.isEmpty() && !getLast().equals(obj)) {
                removeLast();
            }
            if (this.list.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                sb.append(obj);
                sb.append("] was not found in history!");
                throw new IllegalArgumentException(sb.toString());
            }
            return this;
        }

        public int indexOf(@Nonnull Object obj) {
            checkKey(obj);
            return this.list.indexOf(obj);
        }

        @Nonnull
        public <T> T get(int i) {
            return (T) this.list.get(i);
        }

        @Nullable
        public <T> T getLast() {
            if (this.list.isEmpty()) {
                return null;
            }
            return (T) this.list.get(r0.size() - 1);
        }

        @Nonnull
        public Builder add(@Nonnull Object obj) {
            checkKey(obj);
            this.list.add(obj);
            return this;
        }

        @Nonnull
        public Builder add(@Nonnull Object obj, int i) {
            checkKey(obj);
            this.list.add(i, obj);
            return this;
        }

        @Override // java.lang.Iterable
        @Nonnull
        public Iterator<Object> iterator() {
            return this.list.iterator();
        }

        @Nonnull
        public <T> History<T> build() {
            LinkedList linkedList = new LinkedList();
            Iterator<Object> it = this.list.iterator();
            while (it.hasNext()) {
                linkedList.add(it.next());
            }
            return new History<>(linkedList);
        }

        private void checkKey(Object obj) {
            if (obj == null) {
                throw new IllegalArgumentException("History key cannot be null!");
            }
        }

        private void checkKeys(java.util.Collection<?> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("Keys cannot be null!");
            }
        }
    }
}

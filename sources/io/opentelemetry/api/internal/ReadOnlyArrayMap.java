package io.opentelemetry.api.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class ReadOnlyArrayMap<K, V> extends AbstractMap<K, V> {
    private final List<Object> array;
    private final int size;

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return false;
    }

    public static <K, V> Map<K, V> wrap(List<Object> list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        return new ReadOnlyArrayMap(list);
    }

    private ReadOnlyArrayMap(List<Object> list) {
        this.array = list;
        this.size = list.size() / 2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return (obj == null || arrayIndexOfKey(obj) == -1) ? false : true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        for (int i = 0; i < this.array.size(); i += 2) {
            if (value(i + 1).equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public final V get(Object obj) {
        int arrayIndexOfKey;
        if (obj == null || (arrayIndexOfKey = arrayIndexOfKey(obj)) == -1) {
            return null;
        }
        return value(arrayIndexOfKey + 1);
    }

    final int arrayIndexOfKey(Object obj) {
        for (int i = 0; i < this.array.size(); i += 2) {
            if (obj.equals(key(i))) {
                return i;
            }
        }
        return -1;
    }

    final K key(int i) {
        return (K) this.array.get(i);
    }

    final V value(int i) {
        return (V) this.array.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        return new KeySetView();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        return new ValuesView();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new EntrySetView();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* loaded from: classes6.dex */
    final class KeySetView extends SetView {
        KeySetView() {
            super();
        }

        @Override // io.opentelemetry.api.internal.ReadOnlyArrayMap.SetView
        final K elementAtArrayIndex(int i) {
            return (K) ReadOnlyArrayMap.this.key(i);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            return ReadOnlyArrayMap.this.containsKey(obj);
        }
    }

    /* loaded from: classes6.dex */
    final class ValuesView extends SetView {
        ValuesView() {
            super();
        }

        @Override // io.opentelemetry.api.internal.ReadOnlyArrayMap.SetView
        final V elementAtArrayIndex(int i) {
            return (V) ReadOnlyArrayMap.this.value(i + 1);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            return ReadOnlyArrayMap.this.containsValue(obj);
        }
    }

    /* loaded from: classes6.dex */
    final class EntrySetView extends SetView {
        EntrySetView() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.opentelemetry.api.internal.ReadOnlyArrayMap.SetView
        public final Map.Entry<K, V> elementAtArrayIndex(int i) {
            return new AbstractMap.SimpleImmutableEntry(ReadOnlyArrayMap.this.key(i), ReadOnlyArrayMap.this.value(i + 1));
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            int arrayIndexOfKey;
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getKey() == null || (arrayIndexOfKey = ReadOnlyArrayMap.this.arrayIndexOfKey(entry.getKey())) == -1) {
                    return false;
                }
                return ReadOnlyArrayMap.this.value(arrayIndexOfKey + 1).equals(entry.getValue());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public abstract class SetView<E> implements Set<E> {
        abstract E elementAtArrayIndex(int i);

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        SetView() {
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return ReadOnlyArrayMap.this.size;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return new ReadOnlyIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return copyTo(new Object[ReadOnlyArrayMap.this.size]);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            if (tArr.length < ReadOnlyArrayMap.this.size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size()));
            }
            return (T[]) copyTo(tArr);
        }

        <T> T[] copyTo(T[] tArr) {
            int i = 0;
            int i2 = 0;
            while (i < ReadOnlyArrayMap.this.array.size()) {
                tArr[i2] = elementAtArrayIndex(i);
                i += 2;
                i2++;
            }
            return tArr;
        }

        /* loaded from: classes6.dex */
        final class ReadOnlyIterator implements Iterator<E>, j$.util.Iterator {
            int current = 0;

            @Override // j$.util.Iterator
            public final /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.getAuthRequestContext(this, consumer);
            }

            @Override // java.util.Iterator
            public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            ReadOnlyIterator() {
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.current < ReadOnlyArrayMap.this.array.size();
            }

            @Override // java.util.Iterator
            public final E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E e = (E) SetView.this.elementAtArrayIndex(this.current);
                this.current += 2;
                return e;
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            if (collection == null) {
                return false;
            }
            if (collection.isEmpty()) {
                return true;
            }
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReadOnlyArrayMap{");
        for (int i = 0; i < this.array.size(); i += 2) {
            sb.append(key(i));
            sb.append('=');
            sb.append(value(i + 1));
            sb.append(',');
        }
        sb.setLength(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}

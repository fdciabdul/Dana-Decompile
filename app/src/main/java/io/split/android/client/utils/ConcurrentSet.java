package io.split.android.client.utils;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class ConcurrentSet<E> implements Set<E> {
    private final Map<E, Integer> mValues = new ConcurrentHashMap();

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return new Object[0];
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return null;
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.mValues.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.mValues.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.mValues.get(obj) != null;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.mValues.keySet().iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(E e) {
        this.mValues.put(e, 1);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.mValues.remove(obj) != null;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.mValues.keySet().containsAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        HashMap hashMap = new HashMap();
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            hashMap.put(it.next(), 1);
        }
        this.mValues.putAll(hashMap);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.mValues.keySet().removeAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.mValues.clear();
    }
}

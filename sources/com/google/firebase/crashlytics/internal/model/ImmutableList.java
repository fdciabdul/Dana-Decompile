package com.google.firebase.crashlytics.internal.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class ImmutableList<E> implements List<E>, RandomAccess {
    private final List<E> immutableList;

    public static <E> ImmutableList<E> from(E... eArr) {
        return new ImmutableList<>(Arrays.asList(eArr));
    }

    public static <E> ImmutableList<E> from(List<E> list) {
        return new ImmutableList<>(list);
    }

    private ImmutableList(List<E> list) {
        this.immutableList = Collections.unmodifiableList(list);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.immutableList.size();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.immutableList.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.immutableList.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return this.immutableList.iterator();
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return this.immutableList.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        return (T[]) this.immutableList.toArray(tArr);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(E e) {
        return this.immutableList.add(e);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        return this.immutableList.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        return this.immutableList.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        return this.immutableList.addAll(collection);
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection<? extends E> collection) {
        return this.immutableList.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        return this.immutableList.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return this.immutableList.retainAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.immutableList.clear();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        return this.immutableList.equals(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.immutableList.hashCode();
    }

    @Override // java.util.List
    public final E get(int i) {
        return this.immutableList.get(i);
    }

    @Override // java.util.List
    public final E set(int i, E e) {
        return this.immutableList.set(i, e);
    }

    @Override // java.util.List
    public final void add(int i, E e) {
        this.immutableList.add(i, e);
    }

    @Override // java.util.List
    public final E remove(int i) {
        return this.immutableList.remove(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.immutableList.indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.immutableList.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator<E> listIterator() {
        return this.immutableList.listIterator();
    }

    @Override // java.util.List
    public final ListIterator<E> listIterator(int i) {
        return this.immutableList.listIterator(i);
    }

    @Override // java.util.List
    public final List<E> subList(int i, int i2) {
        return this.immutableList.subList(i, i2);
    }
}

package com.alibaba.ariver.kernel.common.immutable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ImmutableList<E> extends ImmutableCollection<E> implements Immutable<List<E>> {

    /* renamed from: a  reason: collision with root package name */
    private List<E> f6121a;

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

    public ImmutableList(List<E> list) {
        super(list);
        this.f6121a = list;
    }

    public ImmutableList(E e) {
        ArrayList arrayList = new ArrayList();
        this.f6121a = arrayList;
        arrayList.add(e);
        this.immutableCollection = this.f6121a;
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.Immutable
    public List<E> mutable() {
        return new ArrayList(this.f6121a);
    }

    public E get(int i) {
        List<E> list = this.f6121a;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public int indexOf(E e) {
        List<E> list = this.f6121a;
        if (list != null) {
            return list.indexOf(e);
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        List<E> list = this.f6121a;
        if (list != null) {
            return list.lastIndexOf(obj);
        }
        return -1;
    }

    public String toString() {
        return this.f6121a.toString();
    }
}

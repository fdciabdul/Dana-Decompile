package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* loaded from: classes3.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
    private int scheduleImpl;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final void clear() {
        this.scheduleImpl = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap
    public final V KClassImpl$Data$declaredNonStaticMembers$2(int i, V v) {
        this.scheduleImpl = 0;
        return (V) super.KClassImpl$Data$declaredNonStaticMembers$2(i, (int) v);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final V put(K k, V v) {
        this.scheduleImpl = 0;
        return (V) super.put(k, v);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final void KClassImpl$Data$declaredNonStaticMembers$2(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.scheduleImpl = 0;
        super.KClassImpl$Data$declaredNonStaticMembers$2(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final V MyBillsEntityDataFactory(int i) {
        this.scheduleImpl = 0;
        return (V) super.MyBillsEntityDataFactory(i);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final int hashCode() {
        if (this.scheduleImpl == 0) {
            this.scheduleImpl = super.hashCode();
        }
        return this.scheduleImpl;
    }
}

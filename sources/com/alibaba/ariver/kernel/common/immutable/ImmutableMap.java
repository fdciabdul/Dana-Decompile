package com.alibaba.ariver.kernel.common.immutable;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class ImmutableMap<K, V> implements Immutable<Map<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private Map<K, V> f6122a;

    public ImmutableMap(Map<K, V> map) {
        this.f6122a = map;
    }

    public int size() {
        Map<K, V> map = this.f6122a;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public boolean isEmpty() {
        Map<K, V> map = this.f6122a;
        return map == null || map.isEmpty();
    }

    public boolean containsKey(K k) {
        Map<K, V> map = this.f6122a;
        return map != null && map.containsKey(k);
    }

    public boolean containsValue(V v) {
        Map<K, V> map = this.f6122a;
        return map != null && map.containsValue(v);
    }

    public V get(K k, V v) {
        Map<K, V> map = this.f6122a;
        return map != null ? map.get(k) : v;
    }

    public ImmutableSet<K> keySet() {
        if (this.f6122a != null) {
            return new ImmutableSet<>(this.f6122a.keySet());
        }
        return null;
    }

    public ImmutableSet<V> values() {
        if (this.f6122a != null) {
            return new ImmutableSet<>(this.f6122a.values());
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.Immutable
    public Map<K, V> mutable() {
        return new HashMap(this.f6122a);
    }
}

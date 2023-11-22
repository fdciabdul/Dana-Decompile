package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes7.dex */
public final class MapBuilder<K, V> {
    private final Map<K, V> contributions;

    private MapBuilder(int i) {
        this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
    }

    public static <K, V> MapBuilder<K, V> newMapBuilder(int i) {
        return new MapBuilder<>(i);
    }

    public final MapBuilder<K, V> put(K k, V v) {
        this.contributions.put(k, v);
        return this;
    }

    public final MapBuilder<K, V> putAll(Map<K, V> map) {
        this.contributions.putAll(map);
        return this;
    }

    public final Map<K, V> build() {
        if (this.contributions.size() == 0) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(this.contributions);
    }
}

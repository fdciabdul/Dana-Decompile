package io.opentelemetry.instrumentation.api.internal.cache;

import j$.util.concurrent.ConcurrentMap;
import j$.util.function.Function;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class MapBackedCache<K, V> implements Cache<K, V> {
    private final ConcurrentMap<K, V> delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapBackedCache(ConcurrentMap<K, V> concurrentMap) {
        this.delegate = concurrentMap;
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    public final V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
        return (V) ConcurrentMap.EL.MyBillsEntityDataFactory(this.delegate, k, function);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    @Nullable
    public final V get(K k) {
        return this.delegate.get(k);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    public final void put(K k, V v) {
        this.delegate.put(k, v);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    public final void remove(K k) {
        this.delegate.remove(k);
    }

    final int size() {
        return this.delegate.size();
    }
}

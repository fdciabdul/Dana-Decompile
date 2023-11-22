package io.opentelemetry.instrumentation.api.internal.cache;

import io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap;
import j$.util.function.Function;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class WeakLockFreeCache<K, V> implements Cache<K, V> {
    private final WeakConcurrentMap<K, V> delegate = new WeakConcurrentMap.WithInlinedExpunction();

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    public final V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
        return (V) this.delegate.computeIfAbsent(k, function);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    public final V get(K k) {
        return (V) this.delegate.getIfPresent(k);
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
        return this.delegate.approximateSize();
    }
}

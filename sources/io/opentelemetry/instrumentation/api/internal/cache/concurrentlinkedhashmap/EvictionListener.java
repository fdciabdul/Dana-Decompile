package io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap;

/* loaded from: classes9.dex */
public interface EvictionListener<K, V> {
    void onEviction(K k, V v);
}

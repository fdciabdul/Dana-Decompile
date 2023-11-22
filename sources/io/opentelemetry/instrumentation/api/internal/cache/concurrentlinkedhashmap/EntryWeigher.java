package io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap;

/* loaded from: classes9.dex */
public interface EntryWeigher<K, V> {
    int weightOf(K k, V v);
}

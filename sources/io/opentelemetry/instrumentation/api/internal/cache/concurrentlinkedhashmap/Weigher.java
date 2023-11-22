package io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap;

/* loaded from: classes9.dex */
public interface Weigher<V> {
    int weightOf(V v);
}

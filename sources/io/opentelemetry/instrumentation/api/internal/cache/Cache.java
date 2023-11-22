package io.opentelemetry.instrumentation.api.internal.cache;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import j$.util.function.Function;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface Cache<K, V> {
    V computeIfAbsent(K k, Function<? super K, ? extends V> function);

    @Nullable
    V get(K k);

    void put(K k, V v);

    void remove(K k);

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.instrumentation.api.internal.cache.Cache$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC<K, V> {
        public static <K, V> Cache<K, V> weak() {
            return new WeakLockFreeCache();
        }

        public static <K, V> Cache<K, V> bounded(int i) {
            return new MapBackedCache(new ConcurrentLinkedHashMap.Builder().maximumWeightedCapacity(i).build());
        }
    }
}

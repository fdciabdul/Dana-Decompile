package io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes9.dex */
public final class Weighers {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public enum SingletonEntryWeigher implements EntryWeigher<Object, Object> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.EntryWeigher
        public final int weightOf(Object obj, Object obj2) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public enum SingletonWeigher implements Weigher<Object> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public final int weightOf(Object obj) {
            return 1;
        }
    }

    private Weighers() {
        throw new AssertionError();
    }

    public static <K, V> EntryWeigher<K, V> asEntryWeigher(Weigher<? super V> weigher) {
        if (weigher == singleton()) {
            return entrySingleton();
        }
        return new EntryWeigherView(weigher);
    }

    public static <K, V> EntryWeigher<K, V> entrySingleton() {
        return SingletonEntryWeigher.INSTANCE;
    }

    public static <V> Weigher<V> singleton() {
        return SingletonWeigher.INSTANCE;
    }

    public static Weigher<byte[]> byteArray() {
        return ByteArrayWeigher.INSTANCE;
    }

    public static <E> Weigher<? super Iterable<E>> iterable() {
        return IterableWeigher.INSTANCE;
    }

    public static <E> Weigher<? super Collection<E>> collection() {
        return CollectionWeigher.INSTANCE;
    }

    public static <E> Weigher<? super List<E>> list() {
        return ListWeigher.INSTANCE;
    }

    public static <E> Weigher<? super Set<E>> set() {
        return SetWeigher.INSTANCE;
    }

    public static <A, B> Weigher<? super Map<A, B>> map() {
        return MapWeigher.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class EntryWeigherView<K, V> implements EntryWeigher<K, V>, Serializable {
        static final long serialVersionUID = 1;
        final Weigher<? super V> weigher;

        EntryWeigherView(Weigher<? super V> weigher) {
            ConcurrentLinkedHashMap.checkNotNull(weigher);
            this.weigher = weigher;
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.EntryWeigher
        public final int weightOf(K k, V v) {
            return this.weigher.weightOf(v);
        }
    }

    /* loaded from: classes9.dex */
    enum ByteArrayWeigher implements Weigher<byte[]> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public final int weightOf(byte[] bArr) {
            return bArr.length;
        }
    }

    /* loaded from: classes9.dex */
    enum IterableWeigher implements Weigher<Iterable<?>> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public final int weightOf(Iterable<?> iterable) {
            if (iterable instanceof Collection) {
                return ((Collection) iterable).size();
            }
            int i = 0;
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                i++;
            }
            return i;
        }
    }

    /* loaded from: classes9.dex */
    enum CollectionWeigher implements Weigher<Collection<?>> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public final int weightOf(Collection<?> collection) {
            return collection.size();
        }
    }

    /* loaded from: classes9.dex */
    enum ListWeigher implements Weigher<List<?>> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public final int weightOf(List<?> list) {
            return list.size();
        }
    }

    /* loaded from: classes9.dex */
    enum SetWeigher implements Weigher<Set<?>> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public final int weightOf(Set<?> set) {
            return set.size();
        }
    }

    /* loaded from: classes9.dex */
    enum MapWeigher implements Weigher<Map<?, ?>> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public final int weightOf(Map<?, ?> map) {
            return map.size();
        }
    }
}

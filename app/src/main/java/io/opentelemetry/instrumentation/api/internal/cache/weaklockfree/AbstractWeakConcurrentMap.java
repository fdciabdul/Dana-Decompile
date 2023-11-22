package io.opentelemetry.instrumentation.api.internal.cache.weaklockfree;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap;
import j$.util.Iterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.Consumer;
import j$.util.function.Function;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class AbstractWeakConcurrentMap<K, V, L> extends ReferenceQueue<K> implements Runnable, Iterable<Map.Entry<K, V>> {
    final ConcurrentMap<WeakKey<K>, V> target;

    protected V defaultValue(K k) {
        return null;
    }

    protected abstract L getLookupKey(K k);

    protected abstract void resetLookupKey(L l);

    protected AbstractWeakConcurrentMap() {
        this(new ConcurrentHashMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractWeakConcurrentMap(ConcurrentMap<WeakKey<K>, V> concurrentMap) {
        this.target = concurrentMap;
    }

    public V get(K k) {
        V putIfAbsent;
        L lookupKey = getLookupKey(k);
        try {
            V v = this.target.get(lookupKey);
            if (v == null) {
                V defaultValue = defaultValue(k);
                return (defaultValue == null || (putIfAbsent = this.target.putIfAbsent(new WeakKey<>(k, this), defaultValue)) == null) ? defaultValue : putIfAbsent;
            }
            return v;
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    public V getIfPresent(K k) {
        L lookupKey = getLookupKey(k);
        try {
            return this.target.get(lookupKey);
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    public boolean containsKey(K k) {
        L lookupKey = getLookupKey(k);
        try {
            return this.target.containsKey(lookupKey);
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    public V put(K k, V v) {
        if (k == null || v == null) {
            throw null;
        }
        return this.target.put(new WeakKey<>(k, this), v);
    }

    public V putIfAbsent(K k, V v) {
        if (k == null || v == null) {
            throw null;
        }
        L lookupKey = getLookupKey(k);
        try {
            V v2 = this.target.get(lookupKey);
            return v2 == null ? this.target.putIfAbsent(new WeakKey<>(k, this), v) : v2;
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    public V computeIfAbsent(final K k, final Function<? super K, ? extends V> function) {
        if (k == null || function == null) {
            throw null;
        }
        L lookupKey = getLookupKey(k);
        try {
            V v = this.target.get(lookupKey);
            return v == null ? (V) ConcurrentMap.EL.MyBillsEntityDataFactory(this.target, new WeakKey(k, this), new Function() { // from class: io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function2) {
                    return Function.CC.getAuthRequestContext(this, function2);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    Object apply;
                    AbstractWeakConcurrentMap.WeakKey weakKey = (AbstractWeakConcurrentMap.WeakKey) obj;
                    apply = Function.this.apply(k);
                    return apply;
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function2) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function2);
                }
            }) : v;
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    public V putIfProbablyAbsent(K k, V v) {
        if (k == null || v == null) {
            throw null;
        }
        return this.target.putIfAbsent(new WeakKey<>(k, this), v);
    }

    public V remove(K k) {
        L lookupKey = getLookupKey(k);
        try {
            return this.target.remove(lookupKey);
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    public void clear() {
        this.target.clear();
    }

    public void expungeStaleEntries() {
        while (true) {
            Reference<? extends K> poll = poll();
            if (poll == null) {
                return;
            }
            this.target.remove(poll);
        }
    }

    public int approximateSize() {
        return this.target.size();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!Thread.interrupted()) {
            try {
                this.target.remove(remove());
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new EntryIterator(this.target.entrySet().iterator());
    }

    public String toString() {
        return this.target.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class WeakKey<K> extends WeakReference<K> {
        public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {Ascii.ETB, -59, 18, 83, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int PlaceComponentResult = 46;
        private final int hashCode;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0036). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r6, short r7, short r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 15
                int r6 = 18 - r6
                int r8 = r8 * 4
                int r8 = 16 - r8
                int r7 = r7 + 105
                byte[] r0 = io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap.WeakKey.KClassImpl$Data$declaredNonStaticMembers$2
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L18
                r7 = r6
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L36
            L18:
                r3 = 0
                r5 = r7
                r7 = r6
                r6 = r5
            L1c:
                byte r4 = (byte) r6
                r1[r3] = r4
                int r3 = r3 + 1
                int r7 = r7 + 1
                if (r3 != r8) goto L2d
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2d:
                r4 = r0[r7]
                r5 = r9
                r9 = r8
                r8 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L36:
                int r8 = -r8
                int r6 = r6 + r8
                int r6 = r6 + 2
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap.WeakKey.a(int, short, short, java.lang.Object[]):void");
        }

        WeakKey(K k, ReferenceQueue<? super K> referenceQueue) {
            super(k, referenceQueue);
            try {
                Object[] objArr = {k};
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr2 = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                byte b4 = (byte) (b3 - 1);
                Object[] objArr3 = new Object[1];
                a(b3, b4, b4, objArr3);
                this.hashCode = ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }

        public final int hashCode() {
            return this.hashCode;
        }

        public final boolean equals(@Nullable Object obj) {
            if (obj instanceof WeakKey) {
                return ((WeakKey) obj).get() == get();
            }
            return obj.equals(this);
        }

        public final String toString() {
            return String.valueOf(get());
        }
    }

    /* loaded from: classes6.dex */
    class EntryIterator implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
        private final Iterator<Map.Entry<WeakKey<K>, V>> iterator;
        private Map.Entry<WeakKey<K>, V> nextEntry;
        private K nextKey;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        private EntryIterator(java.util.Iterator<Map.Entry<WeakKey<K>, V>> it) {
            this.iterator = it;
            findNext();
        }

        private void findNext() {
            while (this.iterator.hasNext()) {
                Map.Entry<WeakKey<K>, V> next = this.iterator.next();
                this.nextEntry = next;
                K k = next.getKey().get();
                this.nextKey = k;
                if (k != null) {
                    return;
                }
            }
            this.nextEntry = null;
            this.nextKey = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextKey != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            K k = this.nextKey;
            if (k == null) {
                throw new NoSuchElementException();
            }
            try {
                return new SimpleEntry(k, this.nextEntry);
            } finally {
                findNext();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class SimpleEntry implements Map.Entry<K, V> {
        final Map.Entry<WeakKey<K>, V> entry;
        private final K key;

        private SimpleEntry(K k, Map.Entry<WeakKey<K>, V> entry) {
            this.key = k;
            this.entry = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.entry.getValue();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            return this.entry.setValue(v);
        }
    }
}

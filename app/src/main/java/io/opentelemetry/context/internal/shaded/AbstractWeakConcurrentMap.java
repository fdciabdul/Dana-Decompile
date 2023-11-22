package io.opentelemetry.context.internal.shaded;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import j$.util.Iterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentMap;

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

    /* loaded from: classes6.dex */
    public static final class WeakKey<K> extends WeakReference<K> {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int KClassImpl$Data$declaredNonStaticMembers$2 = TarHeader.USTAR_FILENAME_PREFIX;
        private final int hashCode;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0031). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r7, byte r8, short r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 * 4
                int r8 = 16 - r8
                int r7 = r7 + 105
                byte[] r0 = io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap.WeakKey.BuiltInFictitiousFunctionClassFactory
                int r9 = r9 * 15
                int r9 = r9 + 4
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L18
                r3 = r1
                r5 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                goto L31
            L18:
                r3 = 0
            L19:
                byte r4 = (byte) r7
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r8) goto L28
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L28:
                r3 = r0[r9]
                r6 = r9
                r9 = r8
                r8 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r6
            L31:
                int r10 = r10 + 1
                int r7 = r7 + r8
                int r7 = r7 + 2
                r8 = r9
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r5
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap.WeakKey.a(int, byte, short, java.lang.Object[]):void");
        }

        WeakKey(K k, ReferenceQueue<? super K> referenceQueue) {
            super(k, referenceQueue);
            try {
                Object[] objArr = {k};
                byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
                Object[] objArr2 = new Object[1];
                a(b, (byte) (b - 1), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                byte b3 = b2;
                Object[] objArr3 = new Object[1];
                a(b2, b3, b3, objArr3);
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

        public final boolean equals(Object obj) {
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

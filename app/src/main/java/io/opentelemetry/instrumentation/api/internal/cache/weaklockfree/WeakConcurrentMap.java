package io.opentelemetry.instrumentation.api.internal.cache.weaklockfree;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Function;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public class WeakConcurrentMap<K, V> extends AbstractWeakConcurrentMap<K, V, LookupKey<K>> {
    private final boolean reuseKeys;
    private final Thread thread;
    private static final ThreadLocal<LookupKey<?>> LOOKUP_KEY_CACHE = new ThreadLocal<LookupKey<?>>() { // from class: io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public LookupKey<?> initialValue() {
            return new LookupKey<>();
        }
    };
    private static final AtomicLong ID = new AtomicLong();

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ int approximateSize() {
        return super.approximateSize();
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return super.computeIfAbsent(obj, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ void expungeStaleEntries() {
        super.expungeStaleEntries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return super.get(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object getIfPresent(Object obj) {
        return super.getIfPresent(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    protected /* bridge */ /* synthetic */ Object getLookupKey(Object obj) {
        return getLookupKey((WeakConcurrentMap<K, V>) obj);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return super.putIfAbsent(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object putIfProbablyAbsent(Object obj, Object obj2) {
        return super.putIfProbablyAbsent(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove((WeakConcurrentMap<K, V>) obj);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    protected /* bridge */ /* synthetic */ void resetLookupKey(Object obj) {
        resetLookupKey((LookupKey) ((LookupKey) obj));
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap, java.lang.Runnable
    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public WeakConcurrentMap(boolean z) {
        this(z, isPersistentClassLoader(LookupKey.class.getClassLoader()));
    }

    private static boolean isPersistentClassLoader(ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                if (classLoader != ClassLoader.getSystemClassLoader()) {
                    if (classLoader != ClassLoader.getSystemClassLoader().getParent()) {
                        return false;
                    }
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        return true;
    }

    public WeakConcurrentMap(boolean z, boolean z2) {
        this(z, z2, new ConcurrentHashMap());
    }

    public WeakConcurrentMap(boolean z, boolean z2, ConcurrentMap<AbstractWeakConcurrentMap.WeakKey<K>, V> concurrentMap) {
        super(concurrentMap);
        this.reuseKeys = z2;
        if (z) {
            Thread thread = new Thread(this);
            this.thread = thread;
            StringBuilder sb = new StringBuilder();
            sb.append("weak-ref-cleaner-");
            sb.append(ID.getAndIncrement());
            thread.setName(sb.toString());
            thread.setPriority(1);
            thread.setDaemon(true);
            thread.start();
            return;
        }
        this.thread = null;
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    protected LookupKey<K> getLookupKey(K k) {
        LookupKey<?> lookupKey;
        if (this.reuseKeys) {
            lookupKey = LOOKUP_KEY_CACHE.get();
        } else {
            lookupKey = new LookupKey<>();
        }
        return lookupKey.withValue(k);
    }

    protected void resetLookupKey(LookupKey<K> lookupKey) {
        lookupKey.reset();
    }

    public Thread getCleanerThread() {
        return this.thread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class LookupKey<K> {
        private int hashCode;
        private K key;
        public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {113, 46, 115, -60, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int BuiltInFictitiousFunctionClassFactory = 151;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r7, int r8, short r9, java.lang.Object[] r10) {
            /*
                byte[] r0 = io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap.LookupKey.KClassImpl$Data$declaredNonStaticMembers$2
                int r7 = 106 - r7
                int r8 = r8 * 4
                int r8 = 16 - r8
                int r9 = r9 * 15
                int r9 = 18 - r9
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L18
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                goto L33
            L18:
                r3 = 0
            L19:
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                if (r4 != r8) goto L28
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L28:
                int r9 = r9 + 1
                r3 = r0[r9]
                r6 = r9
                r9 = r8
                r8 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r6
            L33:
                int r8 = -r8
                int r7 = r7 + r8
                int r7 = r7 + 2
                r8 = r9
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap.LookupKey.a(byte, int, short, java.lang.Object[]):void");
        }

        LookupKey() {
        }

        final LookupKey<K> withValue(K k) {
            this.key = k;
            try {
                Object[] objArr = {k};
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr3 = new Object[1];
                a(b3, (byte) (b3 - 1), KClassImpl$Data$declaredNonStaticMembers$2[5], objArr3);
                this.hashCode = ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
                return this;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        final void reset() {
            this.key = null;
            this.hashCode = 0;
        }

        public final boolean equals(@Nullable Object obj) {
            return obj instanceof LookupKey ? ((LookupKey) obj).key == this.key : ((AbstractWeakConcurrentMap.WeakKey) obj).get() == this.key;
        }

        public final int hashCode() {
            return this.hashCode;
        }
    }

    /* loaded from: classes6.dex */
    public static class WithInlinedExpunction<K, V> extends WeakConcurrentMap<K, V> {
        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ void expungeStaleEntries() {
            super.expungeStaleEntries();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        protected /* bridge */ /* synthetic */ Object getLookupKey(Object obj) {
            return super.getLookupKey((WithInlinedExpunction<K, V>) obj);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ Object putIfProbablyAbsent(Object obj, Object obj2) {
            return super.putIfProbablyAbsent(obj, obj2);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        protected /* bridge */ /* synthetic */ void resetLookupKey(Object obj) {
            super.resetLookupKey((LookupKey) ((LookupKey) obj));
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap, java.lang.Runnable
        public /* bridge */ /* synthetic */ void run() {
            super.run();
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        public WithInlinedExpunction() {
            super(false);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V get(K k) {
            expungeStaleEntries();
            return (V) super.get(k);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V getIfPresent(K k) {
            expungeStaleEntries();
            return (V) super.getIfPresent(k);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public boolean containsKey(K k) {
            expungeStaleEntries();
            return super.containsKey(k);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V put(K k, V v) {
            expungeStaleEntries();
            return (V) super.put(k, v);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V putIfAbsent(K k, V v) {
            expungeStaleEntries();
            return (V) super.putIfAbsent(k, v);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
            expungeStaleEntries();
            return (V) super.computeIfAbsent(k, function);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V remove(K k) {
            expungeStaleEntries();
            return (V) super.remove(k);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            expungeStaleEntries();
            return super.iterator();
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public int approximateSize() {
            expungeStaleEntries();
            return super.approximateSize();
        }
    }
}

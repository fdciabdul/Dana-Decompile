package io.opentelemetry.context.internal.shaded;

import com.google.common.base.Ascii;
import io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class WeakConcurrentMap<K, V> extends AbstractWeakConcurrentMap<K, V, LookupKey<K>> {
    private final boolean reuseKeys;
    private final Thread thread;
    private static final ThreadLocal<LookupKey<?>> LOOKUP_KEY_CACHE = new ThreadLocal<LookupKey<?>>() { // from class: io.opentelemetry.context.internal.shaded.WeakConcurrentMap.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public LookupKey<?> initialValue() {
            return new LookupKey<>();
        }
    };
    private static final AtomicLong ID = new AtomicLong();

    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ int approximateSize() {
        return super.approximateSize();
    }

    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ void expungeStaleEntries() {
        super.expungeStaleEntries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return super.get(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object getIfPresent(Object obj) {
        return super.getIfPresent(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    protected /* bridge */ /* synthetic */ Object getLookupKey(Object obj) {
        return getLookupKey((WeakConcurrentMap<K, V>) obj);
    }

    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return super.putIfAbsent(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object putIfProbablyAbsent(Object obj, Object obj2) {
        return super.putIfProbablyAbsent(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove((WeakConcurrentMap<K, V>) obj);
    }

    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    protected /* bridge */ /* synthetic */ void resetLookupKey(Object obj) {
        resetLookupKey((LookupKey) ((LookupKey) obj));
    }

    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap, java.lang.Runnable
    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
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

    @Override // io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
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
        public static final byte[] getAuthRequestContext = {39, -116, 116, Byte.MAX_VALUE, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 28;

        private static void a(byte b, short s, byte b2, Object[] objArr) {
            int i = (b * 3) + 16;
            int i2 = b2 + 105;
            byte[] bArr = getAuthRequestContext;
            int i3 = s + 4;
            byte[] bArr2 = new byte[i];
            int i4 = -1;
            int i5 = i - 1;
            if (bArr == null) {
                i2 = i5 + i3 + 2;
                i5 = i5;
                i3 = i3;
            }
            while (true) {
                i4++;
                bArr2[i4] = (byte) i2;
                if (i4 == i5) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                int i6 = i3 + 1;
                i2 = i2 + bArr[i6] + 2;
                i5 = i5;
                i3 = i6;
            }
        }

        LookupKey() {
        }

        final LookupKey<K> withValue(K k) {
            this.key = k;
            try {
                Object[] objArr = {k};
                byte b = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr2 = new Object[1];
                a(b, (byte) (b | 14), (byte) (-getAuthRequestContext[5]), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b2 = (byte) (getAuthRequestContext[5] + 1);
                byte b3 = getAuthRequestContext[5];
                Object[] objArr3 = new Object[1];
                a(b2, b3, (byte) (b3 + 1), objArr3);
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

        public final boolean equals(Object obj) {
            return obj instanceof LookupKey ? ((LookupKey) obj).key == this.key : ((AbstractWeakConcurrentMap.WeakKey) obj).get() == this.key;
        }

        public final int hashCode() {
            return this.hashCode;
        }
    }

    /* loaded from: classes9.dex */
    public static class WithInlinedExpunction<K, V> extends WeakConcurrentMap<K, V> {
        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ void expungeStaleEntries() {
            super.expungeStaleEntries();
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ Object getIfPresent(Object obj) {
            return super.getIfPresent(obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        protected /* bridge */ /* synthetic */ Object getLookupKey(Object obj) {
            return super.getLookupKey((WithInlinedExpunction<K, V>) obj);
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
            return super.putIfAbsent(obj, obj2);
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ Object putIfProbablyAbsent(Object obj, Object obj2) {
            return super.putIfProbablyAbsent(obj, obj2);
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        protected /* bridge */ /* synthetic */ void resetLookupKey(Object obj) {
            super.resetLookupKey((LookupKey) ((LookupKey) obj));
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap, java.lang.Runnable
        public /* bridge */ /* synthetic */ void run() {
            super.run();
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        public WithInlinedExpunction() {
            super(false);
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public V get(K k) {
            expungeStaleEntries();
            return (V) super.get(k);
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public boolean containsKey(K k) {
            expungeStaleEntries();
            return super.containsKey(k);
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public V put(K k, V v) {
            expungeStaleEntries();
            return (V) super.put(k, v);
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public V remove(K k) {
            expungeStaleEntries();
            return (V) super.remove(k);
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            expungeStaleEntries();
            return super.iterator();
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public int approximateSize() {
            expungeStaleEntries();
            return super.approximateSize();
        }
    }
}

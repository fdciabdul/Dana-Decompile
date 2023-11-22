package io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque;
import j$.util.Iterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Consumer$$ExternalSyntheticLambda0;
import j$.util.function.Function;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes9.dex */
public final class ConcurrentLinkedHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, j$.util.concurrent.ConcurrentMap {
    static final Queue<?> DISCARDING_QUEUE;
    static final long MAXIMUM_CAPACITY = 9223372034707292160L;
    static final int NCPU;
    static final int NUMBER_OF_READ_BUFFERS;
    static final int READ_BUFFERS_MASK;
    static final int READ_BUFFER_DRAIN_THRESHOLD = 64;
    static final int READ_BUFFER_INDEX_MASK = 127;
    static final int READ_BUFFER_SIZE = 128;
    static final int READ_BUFFER_THRESHOLD = 32;
    static final int WRITE_BUFFER_DRAIN_THRESHOLD = 16;
    static final long serialVersionUID = 1;
    final AtomicLong capacity;
    final int concurrencyLevel;
    final ConcurrentMap<K, Node<K, V>> data;
    final AtomicReference<DrainStatus> drainStatus;
    transient Set<Map.Entry<K, V>> entrySet;
    final LinkedDeque<Node<K, V>> evictionDeque;
    final Lock evictionLock;
    transient Set<K> keySet;
    final EvictionListener<K, V> listener;
    final Queue<Node<K, V>> pendingNotifications;
    final AtomicLong[] readBufferDrainAtWriteCount;
    final long[] readBufferReadCount;
    final AtomicLong[] readBufferWriteCount;
    final AtomicReference<Node<K, V>>[][] readBuffers;
    transient Collection<V> values;
    final EntryWeigher<? super K, ? super V> weigher;
    final AtomicLong weightedSize;
    final Queue<Runnable> writeBuffer;
    public static final byte[] MyBillsEntityDataFactory = {40, 6, -7, -65, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 251;

    /* loaded from: classes9.dex */
    enum DiscardingListener implements EvictionListener<Object, Object> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.EvictionListener
        public final void onEviction(Object obj, Object obj2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public enum DrainStatus {
        IDLE { // from class: io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus.1
            @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus
            final boolean shouldDrainBuffers(boolean z) {
                return !z;
            }
        },
        REQUIRED { // from class: io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus.2
            @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus
            final boolean shouldDrainBuffers(boolean z) {
                return true;
            }
        },
        PROCESSING { // from class: io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus.3
            @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus
            final boolean shouldDrainBuffers(boolean z) {
                return false;
            }
        };

        abstract boolean shouldDrainBuffers(boolean z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 12
            int r6 = 16 - r6
            int r8 = r8 * 3
            int r8 = r8 + 13
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r0 = io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.MyBillsEntityDataFactory
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r7
            r4 = 0
            r7 = r6
            goto L2e
        L19:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r7]
        L2e:
            int r6 = r6 + r3
            int r7 = r7 + 1
            int r6 = r6 + 2
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.a(short, short, short, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkNotNull(Object obj) {
    }

    @Override // j$.util.Map
    public final /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return ConcurrentMap.CC.PlaceComponentResult((java.util.concurrent.ConcurrentMap) this, obj, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return ConcurrentMap.CC.MyBillsEntityDataFactory(this, obj, function);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
    }

    @Override // j$.util.Map
    public final /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return ConcurrentMap.CC.BuiltInFictitiousFunctionClassFactory(this, obj, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final /* synthetic */ void forEach(BiConsumer biConsumer) {
        ConcurrentMap.CC.getAuthRequestContext(this, biConsumer);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.getAuthRequestContext(biConsumer));
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return ConcurrentMap.CC.PlaceComponentResult(this, obj, obj2);
    }

    @Override // j$.util.Map
    public final /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return ConcurrentMap.CC.PlaceComponentResult(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // j$.util.Map
    public final /* synthetic */ void replaceAll(BiFunction biFunction) {
        ConcurrentMap.EL.KClassImpl$Data$declaredNonStaticMembers$2(this, new Consumer$$ExternalSyntheticLambda0(1, this, biFunction));
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        NCPU = availableProcessors;
        int ceilingNextPowerOfTwo = ceilingNextPowerOfTwo(availableProcessors);
        NUMBER_OF_READ_BUFFERS = ceilingNextPowerOfTwo;
        READ_BUFFERS_MASK = ceilingNextPowerOfTwo - 1;
        DISCARDING_QUEUE = new DiscardingQueue();
    }

    static int ceilingNextPowerOfTwo(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    private ConcurrentLinkedHashMap(Builder<K, V> builder) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        int i = builder.concurrencyLevel;
        this.concurrencyLevel = i;
        this.capacity = new AtomicLong(Math.min(builder.capacity, (long) MAXIMUM_CAPACITY));
        this.data = new ConcurrentHashMap(builder.initialCapacity, 0.75f, i);
        this.weigher = builder.weigher;
        this.evictionLock = new ReentrantLock();
        this.weightedSize = new AtomicLong();
        this.evictionDeque = new LinkedDeque<>();
        this.writeBuffer = new ConcurrentLinkedQueue();
        this.drainStatus = new AtomicReference<>(DrainStatus.IDLE);
        int i2 = NUMBER_OF_READ_BUFFERS;
        this.readBufferReadCount = new long[i2];
        this.readBufferWriteCount = new AtomicLong[i2];
        this.readBufferDrainAtWriteCount = new AtomicLong[i2];
        this.readBuffers = (AtomicReference[][]) Array.newInstance(AtomicReference.class, i2, 128);
        for (int i3 = 0; i3 < NUMBER_OF_READ_BUFFERS; i3++) {
            this.readBufferWriteCount[i3] = new AtomicLong();
            this.readBufferDrainAtWriteCount[i3] = new AtomicLong();
            this.readBuffers[i3] = new AtomicReference[128];
            for (int i4 = 0; i4 < 128; i4++) {
                this.readBuffers[i3][i4] = new AtomicReference<>();
            }
        }
        EvictionListener<K, V> evictionListener = builder.listener;
        this.listener = evictionListener;
        if (evictionListener == DiscardingListener.INSTANCE) {
            concurrentLinkedQueue = (Queue<Node<K, V>>) DISCARDING_QUEUE;
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
        }
        this.pendingNotifications = concurrentLinkedQueue;
    }

    static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public final long capacity() {
        return this.capacity.get();
    }

    public final void setCapacity(long j) {
        checkArgument(j >= 0);
        this.evictionLock.lock();
        try {
            this.capacity.lazySet(Math.min(j, (long) MAXIMUM_CAPACITY));
            drainBuffers();
            evict();
            this.evictionLock.unlock();
            notifyListener();
        } catch (Throwable th) {
            this.evictionLock.unlock();
            throw th;
        }
    }

    final boolean hasOverflowed() {
        return this.weightedSize.get() > this.capacity.get();
    }

    final void evict() {
        Node<K, V> poll;
        while (hasOverflowed() && (poll = this.evictionDeque.poll()) != null) {
            if (this.data.remove(poll.key, poll)) {
                this.pendingNotifications.add(poll);
            }
            makeDead(poll);
        }
    }

    final void afterRead(Node<K, V> node) {
        int readBufferIndex = readBufferIndex();
        drainOnReadIfNeeded(readBufferIndex, recordRead(readBufferIndex, node));
        notifyListener();
    }

    static int readBufferIndex() {
        try {
            byte b = (byte) (MyBillsEntityDataFactory[15] - 1);
            byte b2 = MyBillsEntityDataFactory[15];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = MyBillsEntityDataFactory[15];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            return READ_BUFFERS_MASK & ((int) ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    final long recordRead(int i, Node<K, V> node) {
        AtomicLong atomicLong = this.readBufferWriteCount[i];
        long j = atomicLong.get();
        atomicLong.lazySet(1 + j);
        this.readBuffers[i][(int) (127 & j)].lazySet(node);
        return j;
    }

    final void drainOnReadIfNeeded(int i, long j) {
        if (this.drainStatus.get().shouldDrainBuffers(j - this.readBufferDrainAtWriteCount[i].get() < 32)) {
            tryToDrainBuffers();
        }
    }

    final void afterWrite(Runnable runnable) {
        this.writeBuffer.add(runnable);
        this.drainStatus.lazySet(DrainStatus.REQUIRED);
        tryToDrainBuffers();
        notifyListener();
    }

    final void tryToDrainBuffers() {
        if (this.evictionLock.tryLock()) {
            try {
                this.drainStatus.lazySet(DrainStatus.PROCESSING);
                drainBuffers();
            } finally {
                LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.drainStatus, DrainStatus.PROCESSING, DrainStatus.IDLE);
                this.evictionLock.unlock();
            }
        }
    }

    final void drainBuffers() {
        drainReadBuffers();
        drainWriteBuffer();
    }

    final void drainReadBuffers() {
        try {
            byte b = (byte) (MyBillsEntityDataFactory[15] - 1);
            byte b2 = MyBillsEntityDataFactory[15];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = MyBillsEntityDataFactory[15];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            int id2 = (int) ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId();
            int i = NUMBER_OF_READ_BUFFERS;
            for (int i2 = id2; i2 < i + id2; i2++) {
                drainReadBuffer(READ_BUFFERS_MASK & i2);
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    final void drainReadBuffer(int i) {
        long j = this.readBufferWriteCount[i].get();
        for (int i2 = 0; i2 < 64; i2++) {
            AtomicReference<Node<K, V>> atomicReference = this.readBuffers[i][(int) (this.readBufferReadCount[i] & 127)];
            Node<K, V> node = atomicReference.get();
            if (node == null) {
                break;
            }
            atomicReference.lazySet(null);
            applyRead(node);
            long[] jArr = this.readBufferReadCount;
            jArr[i] = jArr[i] + 1;
        }
        this.readBufferDrainAtWriteCount[i].lazySet(j);
    }

    final void applyRead(Node<K, V> node) {
        if (this.evictionDeque.contains((LinkedDeque.Linked<?>) node)) {
            this.evictionDeque.moveToBack(node);
        }
    }

    final void drainWriteBuffer() {
        Runnable poll;
        for (int i = 0; i < 16 && (poll = this.writeBuffer.poll()) != null; i++) {
            poll.run();
        }
    }

    final boolean tryToRetire(Node<K, V> node, WeightedValue<V> weightedValue) {
        if (weightedValue.isAlive()) {
            return node.compareAndSet(weightedValue, new WeightedValue(weightedValue.value, -weightedValue.weight));
        }
        return false;
    }

    final void makeRetired(Node<K, V> node) {
        WeightedValue weightedValue;
        do {
            weightedValue = (WeightedValue) node.get();
            if (!weightedValue.isAlive()) {
                return;
            }
        } while (!node.compareAndSet(weightedValue, new WeightedValue(weightedValue.value, -weightedValue.weight)));
    }

    final void makeDead(Node<K, V> node) {
        WeightedValue weightedValue;
        do {
            weightedValue = (WeightedValue) node.get();
        } while (!node.compareAndSet(weightedValue, new WeightedValue(weightedValue.value, 0)));
        AtomicLong atomicLong = this.weightedSize;
        atomicLong.lazySet(atomicLong.get() - Math.abs(weightedValue.weight));
    }

    final void notifyListener() {
        while (true) {
            Node<K, V> poll = this.pendingNotifications.poll();
            if (poll == null) {
                return;
            }
            this.listener.onEviction(poll.key, poll.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class AddTask implements Runnable {
        final Node<K, V> node;
        final int weight;

        AddTask(Node<K, V> node, int i) {
            this.weight = i;
            this.node = node;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ConcurrentLinkedHashMap.this.weightedSize.lazySet(ConcurrentLinkedHashMap.this.weightedSize.get() + this.weight);
            if (((WeightedValue) this.node.get()).isAlive()) {
                ConcurrentLinkedHashMap.this.evictionDeque.add((LinkedDeque<Node<K, V>>) this.node);
                ConcurrentLinkedHashMap.this.evict();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class RemovalTask implements Runnable {
        final Node<K, V> node;

        RemovalTask(Node<K, V> node) {
            this.node = node;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ConcurrentLinkedHashMap.this.evictionDeque.remove((LinkedDeque<Node<K, V>>) this.node);
            ConcurrentLinkedHashMap.this.makeDead(this.node);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class UpdateTask implements Runnable {
        final Node<K, V> node;
        final int weightDifference;

        public UpdateTask(Node<K, V> node, int i) {
            this.weightDifference = i;
            this.node = node;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ConcurrentLinkedHashMap.this.weightedSize.lazySet(ConcurrentLinkedHashMap.this.weightedSize.get() + this.weightDifference);
            ConcurrentLinkedHashMap.this.applyRead(this.node);
            ConcurrentLinkedHashMap.this.evict();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.data.size();
    }

    public final long weightedSize() {
        return Math.max(0L, this.weightedSize.get());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.evictionLock.lock();
        while (true) {
            try {
                Node<K, V> poll = this.evictionDeque.poll();
                if (poll == null) {
                    break;
                }
                this.data.remove(poll.key, poll);
                makeDead(poll);
            } finally {
                this.evictionLock.unlock();
            }
        }
        for (AtomicReference<Node<K, V>>[] atomicReferenceArr : this.readBuffers) {
            for (AtomicReference<Node<K, V>> atomicReference : atomicReferenceArr) {
                atomicReference.lazySet(null);
            }
        }
        while (true) {
            Runnable poll2 = this.writeBuffer.poll();
            if (poll2 == null) {
                return;
            }
            poll2.run();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.data.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        checkNotNull(obj);
        Iterator<Node<K, V>> it = this.data.values().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Node<K, V> node = this.data.get(obj);
        if (node == null) {
            return null;
        }
        afterRead(node);
        return node.getValue();
    }

    public final V getQuietly(Object obj) {
        Node<K, V> node = this.data.get(obj);
        if (node == null) {
            return null;
        }
        return node.getValue();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        return put(k, v, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final V putIfAbsent(K k, V v) {
        return put(k, v, true);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap$WeightedValue, java.lang.Object] */
    final V put(K k, V v, boolean z) {
        ?? r2;
        checkNotNull(k);
        checkNotNull(v);
        int weightOf = this.weigher.weightOf(k, v);
        WeightedValue weightedValue = new WeightedValue(v, weightOf);
        Node<K, V> node = new Node<>(k, weightedValue);
        while (true) {
            Node<K, V> putIfAbsent = this.data.putIfAbsent(node.key, node);
            if (putIfAbsent == null) {
                afterWrite(new AddTask(node, weightOf));
                return null;
            }
            if (z) {
                afterRead(putIfAbsent);
                return putIfAbsent.getValue();
            }
            do {
                r2 = (V) ((WeightedValue) putIfAbsent.get());
                if (r2.isAlive()) {
                }
            } while (!putIfAbsent.compareAndSet(r2, weightedValue));
            int i = weightOf - r2.weight;
            if (i == 0) {
                afterRead(putIfAbsent);
            } else {
                afterWrite(new UpdateTask(putIfAbsent, i));
            }
            return r2.value;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        Node<K, V> remove = this.data.remove(obj);
        if (remove == null) {
            return null;
        }
        makeRetired(remove);
        afterWrite(new RemovalTask(remove));
        return remove.getValue();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final boolean remove(Object obj, Object obj2) {
        Node<K, V> node = this.data.get(obj);
        if (node == null || obj2 == null) {
            return false;
        }
        WeightedValue<V> weightedValue = (WeightedValue) node.get();
        while (weightedValue.contains(obj2)) {
            if (tryToRetire(node, weightedValue)) {
                if (this.data.remove(obj, node)) {
                    afterWrite(new RemovalTask(node));
                    return true;
                }
                return false;
            }
            weightedValue = (WeightedValue) node.get();
            if (!weightedValue.isAlive()) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap$WeightedValue, java.lang.Object] */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final V replace(K k, V v) {
        ?? r2;
        checkNotNull(k);
        checkNotNull(v);
        int weightOf = this.weigher.weightOf(k, v);
        WeightedValue weightedValue = new WeightedValue(v, weightOf);
        Node<K, V> node = this.data.get(k);
        if (node == null) {
            return null;
        }
        do {
            r2 = (V) ((WeightedValue) node.get());
            if (!r2.isAlive()) {
                return null;
            }
        } while (!node.compareAndSet(r2, weightedValue));
        int i = weightOf - r2.weight;
        if (i == 0) {
            afterRead(node);
        } else {
            afterWrite(new UpdateTask(node, i));
        }
        return r2.value;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap$WeightedValue, java.lang.Object] */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final boolean replace(K k, V v, V v2) {
        ?? r2;
        checkNotNull(k);
        checkNotNull(v);
        checkNotNull(v2);
        int weightOf = this.weigher.weightOf(k, v2);
        WeightedValue weightedValue = new WeightedValue(v2, weightOf);
        Node<K, V> node = this.data.get(k);
        if (node == null) {
            return false;
        }
        do {
            r2 = (V) ((WeightedValue) node.get());
            if (!r2.isAlive() || !r2.contains(v)) {
                return false;
            }
        } while (!node.compareAndSet(r2, weightedValue));
        int i = weightOf - r2.weight;
        if (i == 0) {
            afterRead(node);
            return true;
        }
        afterWrite(new UpdateTask(node, i));
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set == null) {
            KeySet keySet = new KeySet();
            this.keySet = keySet;
            return keySet;
        }
        return set;
    }

    public final Set<K> ascendingKeySet() {
        return ascendingKeySetWithLimit(Integer.MAX_VALUE);
    }

    public final Set<K> ascendingKeySetWithLimit(int i) {
        return orderedKeySet(true, i);
    }

    public final Set<K> descendingKeySet() {
        return descendingKeySetWithLimit(Integer.MAX_VALUE);
    }

    public final Set<K> descendingKeySetWithLimit(int i) {
        return orderedKeySet(false, i);
    }

    final Set<K> orderedKeySet(boolean z, int i) {
        checkArgument(i >= 0);
        this.evictionLock.lock();
        try {
            drainBuffers();
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.weigher == Weighers.entrySingleton() ? Math.min(i, (int) weightedSize()) : 16);
            Iterator<Node<K, V>> it = z ? this.evictionDeque.iterator() : this.evictionDeque.descendingIterator();
            while (it.hasNext() && i > linkedHashSet.size()) {
                linkedHashSet.add(it.next().key);
            }
            return Collections.unmodifiableSet(linkedHashSet);
        } finally {
            this.evictionLock.unlock();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection == null) {
            Values values = new Values();
            this.values = values;
            return values;
        }
        return collection;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set == null) {
            EntrySet entrySet = new EntrySet();
            this.entrySet = entrySet;
            return entrySet;
        }
        return set;
    }

    public final Map<K, V> ascendingMap() {
        return ascendingMapWithLimit(Integer.MAX_VALUE);
    }

    public final Map<K, V> ascendingMapWithLimit(int i) {
        return orderedMap(true, i);
    }

    public final Map<K, V> descendingMap() {
        return descendingMapWithLimit(Integer.MAX_VALUE);
    }

    public final Map<K, V> descendingMapWithLimit(int i) {
        return orderedMap(false, i);
    }

    final Map<K, V> orderedMap(boolean z, int i) {
        checkArgument(i >= 0);
        this.evictionLock.lock();
        try {
            drainBuffers();
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.weigher == Weighers.entrySingleton() ? Math.min(i, (int) weightedSize()) : 16);
            Iterator<Node<K, V>> it = z ? this.evictionDeque.iterator() : this.evictionDeque.descendingIterator();
            while (it.hasNext() && i > linkedHashMap.size()) {
                Node<K, V> next = it.next();
                linkedHashMap.put(next.key, next.getValue());
            }
            return Collections.unmodifiableMap(linkedHashMap);
        } finally {
            this.evictionLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class WeightedValue<V> {
        final V value;
        final int weight;

        WeightedValue(V v, int i) {
            this.weight = i;
            this.value = v;
        }

        final boolean contains(Object obj) {
            V v = this.value;
            return obj == v || v.equals(obj);
        }

        final boolean isAlive() {
            return this.weight > 0;
        }

        final boolean isRetired() {
            return this.weight < 0;
        }

        final boolean isDead() {
            return this.weight == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class Node<K, V> extends AtomicReference<WeightedValue<V>> implements LinkedDeque.Linked<Node<K, V>> {
        final K key;
        Node<K, V> next;
        Node<K, V> prev;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.Linked
        public final /* bridge */ /* synthetic */ void setNext(LinkedDeque.Linked linked) {
            setNext((Node) ((Node) linked));
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.Linked
        public final /* bridge */ /* synthetic */ void setPrevious(LinkedDeque.Linked linked) {
            setPrevious((Node) ((Node) linked));
        }

        Node(K k, WeightedValue<V> weightedValue) {
            super(weightedValue);
            this.key = k;
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.Linked
        public final Node<K, V> getPrevious() {
            return this.prev;
        }

        public final void setPrevious(Node<K, V> node) {
            this.prev = node;
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.Linked
        public final Node<K, V> getNext() {
            return this.next;
        }

        public final void setNext(Node<K, V> node) {
            this.next = node;
        }

        final V getValue() {
            return ((WeightedValue) get()).value;
        }
    }

    /* loaded from: classes9.dex */
    final class KeySet extends AbstractSet<K> {
        final ConcurrentLinkedHashMap<K, V> map;

        KeySet() {
            this.map = ConcurrentLinkedHashMap.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.map.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return ConcurrentLinkedHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            return this.map.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return this.map.data.keySet().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) this.map.data.keySet().toArray(tArr);
        }
    }

    /* loaded from: classes9.dex */
    final class KeyIterator implements Iterator<K>, j$.util.Iterator {
        K current;
        final Iterator<K> iterator;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        KeyIterator() {
            this.iterator = ConcurrentLinkedHashMap.this.data.keySet().iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public final K next() {
            K next = this.iterator.next();
            this.current = next;
            return next;
        }

        @Override // java.util.Iterator
        public final void remove() {
            ConcurrentLinkedHashMap.checkState(this.current != null);
            ConcurrentLinkedHashMap.this.remove(this.current);
            this.current = null;
        }
    }

    /* loaded from: classes9.dex */
    final class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return ConcurrentLinkedHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            ConcurrentLinkedHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final java.util.Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return ConcurrentLinkedHashMap.this.containsValue(obj);
        }
    }

    /* loaded from: classes9.dex */
    final class ValueIterator implements java.util.Iterator<V>, j$.util.Iterator {
        Node<K, V> current;
        final java.util.Iterator<Node<K, V>> iterator;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        ValueIterator() {
            this.iterator = ConcurrentLinkedHashMap.this.data.values().iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public final V next() {
            Node<K, V> next = this.iterator.next();
            this.current = next;
            return next.getValue();
        }

        @Override // java.util.Iterator
        public final void remove() {
            ConcurrentLinkedHashMap.checkState(this.current != null);
            ConcurrentLinkedHashMap.this.remove(this.current.key);
            this.current = null;
        }
    }

    /* loaded from: classes9.dex */
    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final ConcurrentLinkedHashMap<K, V> map;

        EntrySet() {
            this.map = ConcurrentLinkedHashMap.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add((Map.Entry) ((Map.Entry) obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            this.map.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Node<K, V> node = this.map.data.get(entry.getKey());
                return node != null && node.getValue().equals(entry.getValue());
            }
            return false;
        }

        public final boolean add(Map.Entry<K, V> entry) {
            return this.map.putIfAbsent(entry.getKey(), entry.getValue()) == null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.map.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }
    }

    /* loaded from: classes9.dex */
    final class EntryIterator implements java.util.Iterator<Map.Entry<K, V>>, j$.util.Iterator {
        Node<K, V> current;
        final java.util.Iterator<Node<K, V>> iterator;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        EntryIterator() {
            this.iterator = ConcurrentLinkedHashMap.this.data.values().iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public final Map.Entry<K, V> next() {
            this.current = this.iterator.next();
            return new WriteThroughEntry(this.current);
        }

        @Override // java.util.Iterator
        public final void remove() {
            ConcurrentLinkedHashMap.checkState(this.current != null);
            ConcurrentLinkedHashMap.this.remove(this.current.key);
            this.current = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class WriteThroughEntry extends AbstractMap.SimpleEntry<K, V> {
        static final long serialVersionUID = 1;

        WriteThroughEntry(Node<K, V> node) {
            super(node.key, node.getValue());
        }

        @Override // java.util.AbstractMap.SimpleEntry, java.util.Map.Entry
        public final V setValue(V v) {
            ConcurrentLinkedHashMap.this.put(getKey(), v);
            return (V) super.setValue(v);
        }

        final Object writeReplace() {
            return new AbstractMap.SimpleEntry(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class BoundedEntryWeigher<K, V> implements EntryWeigher<K, V>, Serializable {
        static final long serialVersionUID = 1;
        final EntryWeigher<? super K, ? super V> weigher;

        BoundedEntryWeigher(EntryWeigher<? super K, ? super V> entryWeigher) {
            ConcurrentLinkedHashMap.checkNotNull(entryWeigher);
            this.weigher = entryWeigher;
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.EntryWeigher
        public final int weightOf(K k, V v) {
            int weightOf = this.weigher.weightOf(k, v);
            ConcurrentLinkedHashMap.checkArgument(weightOf > 0);
            return weightOf;
        }

        final Object writeReplace() {
            return this.weigher;
        }
    }

    /* loaded from: classes9.dex */
    static final class DiscardingQueue extends AbstractQueue<Object> {
        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
        public final boolean add(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public final boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public final Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public final Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return 0;
        }

        DiscardingQueue() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final java.util.Iterator<Object> iterator() {
            return Collections.emptyList().iterator();
        }
    }

    final Object writeReplace() {
        return new SerializationProxy(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }

    /* loaded from: classes9.dex */
    static final class SerializationProxy<K, V> implements Serializable {
        static final long serialVersionUID = 1;
        final long capacity;
        final int concurrencyLevel;
        final Map<K, V> data;
        final EvictionListener<K, V> listener;
        final EntryWeigher<? super K, ? super V> weigher;

        SerializationProxy(ConcurrentLinkedHashMap<K, V> concurrentLinkedHashMap) {
            this.concurrencyLevel = concurrentLinkedHashMap.concurrencyLevel;
            this.data = new HashMap(concurrentLinkedHashMap);
            this.capacity = concurrentLinkedHashMap.capacity.get();
            this.listener = concurrentLinkedHashMap.listener;
            this.weigher = concurrentLinkedHashMap.weigher;
        }

        final Object readResolve() {
            ConcurrentLinkedHashMap<K, V> build = new Builder().concurrencyLevel(this.concurrencyLevel).maximumWeightedCapacity(this.capacity).listener(this.listener).weigher(this.weigher).build();
            build.putAll((Map<K, V>) this.data);
            return build;
        }
    }

    /* loaded from: classes9.dex */
    public static final class Builder<K, V> {
        static final int DEFAULT_CONCURRENCY_LEVEL = 16;
        static final int DEFAULT_INITIAL_CAPACITY = 16;
        long capacity = -1;
        EntryWeigher<? super K, ? super V> weigher = Weighers.entrySingleton();
        int initialCapacity = 16;
        int concurrencyLevel = 16;
        EvictionListener<K, V> listener = DiscardingListener.INSTANCE;

        public final Builder<K, V> initialCapacity(int i) {
            ConcurrentLinkedHashMap.checkArgument(i >= 0);
            this.initialCapacity = i;
            return this;
        }

        public final Builder<K, V> maximumWeightedCapacity(long j) {
            ConcurrentLinkedHashMap.checkArgument(j >= 0);
            this.capacity = j;
            return this;
        }

        public final Builder<K, V> concurrencyLevel(int i) {
            ConcurrentLinkedHashMap.checkArgument(i > 0);
            this.concurrencyLevel = i;
            return this;
        }

        public final Builder<K, V> listener(EvictionListener<K, V> evictionListener) {
            ConcurrentLinkedHashMap.checkNotNull(evictionListener);
            this.listener = evictionListener;
            return this;
        }

        public final Builder<K, V> weigher(Weigher<? super V> weigher) {
            EntryWeigher<? super K, ? super V> boundedEntryWeigher;
            if (weigher == Weighers.singleton()) {
                boundedEntryWeigher = Weighers.entrySingleton();
            } else {
                boundedEntryWeigher = new BoundedEntryWeigher(Weighers.asEntryWeigher(weigher));
            }
            this.weigher = boundedEntryWeigher;
            return this;
        }

        public final Builder<K, V> weigher(EntryWeigher<? super K, ? super V> entryWeigher) {
            EntryWeigher<? super K, ? super V> boundedEntryWeigher;
            if (entryWeigher == Weighers.entrySingleton()) {
                boundedEntryWeigher = Weighers.entrySingleton();
            } else {
                boundedEntryWeigher = new BoundedEntryWeigher(entryWeigher);
            }
            this.weigher = boundedEntryWeigher;
            return this;
        }

        public final ConcurrentLinkedHashMap<K, V> build() {
            ConcurrentLinkedHashMap.checkState(this.capacity >= 0);
            return new ConcurrentLinkedHashMap<>(this);
        }
    }
}

package kotlinx.coroutines.debug.internal;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.util.concurrent.Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003'()B\u0011\u0012\b\b\u0002\u0010\"\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u001a\u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\b\u0010\u0010\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\r\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u000bR&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00170\u00168WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010 \u001a\u00020\u001d8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", DiskFormatter.KB, "V", "Lkotlin/collections/AbstractMutableMap;", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "w", "", "cleanWeakRef", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "clear", "()V", "decrementSize", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putSynchronized", "remove", "runWeakRefQueueCleaningLoopUntilInterrupted", "", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "getKeys", UserMetadata.KEYDATA_FILENAME, "", "getSize", "()I", GriverMonitorConstants.KEY_SIZE, "Ljava/lang/ref/ReferenceQueue;", "weakRefQueue", "Ljava/lang/ref/ReferenceQueue;", "", "<init>", "(Z)V", "Core", "Entry", "KeyValueSet"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {
    private volatile /* synthetic */ int _size;
    volatile /* synthetic */ Object core;
    private final ReferenceQueue<K> weakRefQueue;
    public static final byte[] PlaceComponentResult = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int MyBillsEntityDataFactory = 50;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 13
            int r8 = r8 * 12
            int r8 = 16 - r8
            int r6 = r6 * 7
            int r6 = r6 + 99
            byte[] r0 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.PlaceComponentResult
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + 2
            int r7 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a(int, short, byte, java.lang.Object[]):void");
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public ConcurrentWeakMap(boolean z) {
        this._size = 0;
        this.core = new Core(16);
        this.weakRefQueue = z ? new ReferenceQueue<>() : null;
    }

    @Override // kotlin.collections.AbstractMutableMap
    @JvmName(name = "getSize")
    /* renamed from: getSize  reason: from getter */
    public final int get_size() {
        return this._size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decrementSize() {
        _size$FU.decrementAndGet(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object key) {
        if (key == null) {
            return null;
        }
        return (V) ((Core) this.core).getImpl(key);
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public final V put(K key, V value) {
        Symbol symbol;
        V v = (V) Core.putImpl$default((Core) this.core, key, value, null, 4, null);
        symbol = ConcurrentWeakMapKt.REHASH;
        if (v == symbol) {
            v = putSynchronized(key, value);
        }
        if (v == null) {
            _size$FU.incrementAndGet(this);
        }
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object key) {
        Symbol symbol;
        if (key == 0) {
            return null;
        }
        V v = (V) Core.putImpl$default((Core) this.core, key, null, null, 4, null);
        symbol = ConcurrentWeakMapKt.REHASH;
        if (v == symbol) {
            v = putSynchronized(key, null);
        }
        if (v != null) {
            _size$FU.decrementAndGet(this);
        }
        return v;
    }

    private final V putSynchronized(K key, V value) {
        V v;
        Symbol symbol;
        synchronized (this) {
            Core core = (Core) this.core;
            while (true) {
                v = (V) Core.putImpl$default(core, key, value, null, 4, null);
                symbol = ConcurrentWeakMapKt.REHASH;
                if (v == symbol) {
                    core = core.rehash();
                    this.core = core;
                }
            }
        }
        return v;
    }

    @Override // kotlin.collections.AbstractMutableMap
    @JvmName(name = "getKeys")
    public final Set<K> getKeys() {
        return new KeyValueSet(new Function2<K, V, K>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // kotlin.jvm.functions.Function2
            public final K invoke(K k, V v) {
                return k;
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableMap
    @JvmName(name = "getEntries")
    public final Set<Map.Entry<K, V>> getEntries() {
        return new KeyValueSet(new Function2<K, V, Map.Entry<K, V>>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((ConcurrentWeakMap$entries$1<K, V>) obj, obj2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Map.Entry<K, V> invoke(K k, V v) {
                return new ConcurrentWeakMap.Entry(k, v);
            }
        });
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        if (!(this.weakRefQueue != null)) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                try {
                    Reference<? extends K> remove = this.weakRefQueue.remove();
                    if (remove == null) {
                        break;
                    }
                    cleanWeakRef((HashedWeakRef) remove);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (InterruptedException unused) {
                byte b = (byte) (-PlaceComponentResult[15]);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (PlaceComponentResult[15] + 1);
                Object[] objArr2 = new Object[1];
                a(b3, b3, (byte) (-PlaceComponentResult[15]), objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
    }

    private final void cleanWeakRef(HashedWeakRef<?> w) {
        ((Core) this.core).cleanWeakRef(w);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u0011\"\u0004\b\u0002\u0010\u000e2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001e"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "weakRef", "", "cleanWeakRef", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "key", "getImpl", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "hash", "index", "(I)I", "E", "Lkotlin/Function2;", "factory", "", "keyValueIterator", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "value", "weakKey0", "putImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "rehash", "()Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "removeCleanedAt", "(I)V", "allocated", "I", "shift", GriverMonitorConstants.KEY_THRESHOLD, "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "KeyValueIterator"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public final class Core {
        private static final /* synthetic */ AtomicIntegerFieldUpdater load$FU = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load");
        private final int allocated;
        /* synthetic */ AtomicReferenceArray keys;
        private volatile /* synthetic */ int load = 0;
        private final int shift;
        private final int threshold;
        /* synthetic */ AtomicReferenceArray values;

        public Core(int i) {
            this.allocated = i;
            this.shift = Integer.numberOfLeadingZeros(i) + 1;
            this.threshold = (i * 2) / 3;
            this.keys = new AtomicReferenceArray(i);
            this.values = new AtomicReferenceArray(i);
        }

        private final int index(int hash) {
            return (hash * (-1640531527)) >>> this.shift;
        }

        public final V getImpl(K key) {
            int index = index(key.hashCode());
            while (true) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) this.keys.get(index);
                if (hashedWeakRef == null) {
                    return null;
                }
                T t = hashedWeakRef.get();
                if (Intrinsics.areEqual(key, t)) {
                    V v = (V) this.values.get(index);
                    return v instanceof Marked ? (V) ((Marked) v).ref : v;
                }
                if (t == 0) {
                    removeCleanedAt(index);
                }
                if (index == 0) {
                    index = this.allocated;
                }
                index--;
            }
        }

        private final void removeCleanedAt(int index) {
            Object obj;
            do {
                obj = this.values.get(index);
                if (obj == null || (obj instanceof Marked)) {
                    return;
                }
            } while (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this.values, index, obj, null));
            ConcurrentWeakMap.this.decrementSize();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object putImpl$default(Core core, Object obj, Object obj2, HashedWeakRef hashedWeakRef, int i, Object obj3) {
            if ((i & 4) != 0) {
                hashedWeakRef = null;
            }
            return core.putImpl(obj, obj2, hashedWeakRef);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        
            if (r1 < r6.threshold) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        
            r7 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.REHASH;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        
            return r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            if (kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.load$FU.compareAndSet(r6, r1, r1 + 1) == false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        
            r1 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        
            if (r9 != null) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
        
            r9 = new kotlinx.coroutines.debug.internal.HashedWeakRef<>(r7, ((kotlinx.coroutines.debug.internal.ConcurrentWeakMap) r6.this$0).weakRefQueue);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        
            if (com.google.common.util.concurrent.Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(r6.keys, r0, null, r9) != false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
        
            r7 = r6.values.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
        
            if ((r7 instanceof kotlinx.coroutines.debug.internal.Marked) == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
        
            r7 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.REHASH;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
        
            return r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006c, code lost:
        
            if (com.google.common.util.concurrent.Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(r6.values, r0, r7, r8) == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006e, code lost:
        
            return r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            if (r1 == false) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        
            r1 = r6.load;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object putImpl(K r7, V r8, kotlinx.coroutines.debug.internal.HashedWeakRef<K> r9) {
            /*
                r6 = this;
                int r0 = r7.hashCode()
                int r0 = r6.index(r0)
                r1 = 0
            L9:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r6.keys
                java.lang.Object r2 = r2.get(r0)
                kotlinx.coroutines.debug.internal.HashedWeakRef r2 = (kotlinx.coroutines.debug.internal.HashedWeakRef) r2
                r3 = 1
                if (r2 != 0) goto L46
                r2 = 0
                if (r8 != 0) goto L18
                return r2
            L18:
                if (r1 != 0) goto L30
            L1a:
                int r1 = r6.load
                int r4 = r6.threshold
                if (r1 < r4) goto L25
                kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.access$getREHASH$p()
                return r7
            L25:
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.load$FU
                int r5 = r1 + 1
                boolean r1 = r4.compareAndSet(r6, r1, r5)
                if (r1 == 0) goto L1a
                r1 = 1
            L30:
                if (r9 != 0) goto L3d
                kotlinx.coroutines.debug.internal.HashedWeakRef r9 = new kotlinx.coroutines.debug.internal.HashedWeakRef
                kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V> r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this
                java.lang.ref.ReferenceQueue r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.access$getWeakRefQueue$p(r3)
                r9.<init>(r7, r3)
            L3d:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r6.keys
                boolean r2 = com.google.common.util.concurrent.Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(r3, r0, r2, r9)
                if (r2 != 0) goto L57
                goto L9
            L46:
                java.lang.Object r2 = r2.get()
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r2)
                if (r4 == 0) goto L6f
                if (r1 == 0) goto L57
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.load$FU
                r7.decrementAndGet(r6)
            L57:
                java.util.concurrent.atomic.AtomicReferenceArray r7 = r6.values
                java.lang.Object r7 = r7.get(r0)
                boolean r9 = r7 instanceof kotlinx.coroutines.debug.internal.Marked
                if (r9 == 0) goto L66
                kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.access$getREHASH$p()
                return r7
            L66:
                java.util.concurrent.atomic.AtomicReferenceArray r9 = r6.values
                boolean r9 = com.google.common.util.concurrent.Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(r9, r0, r7, r8)
                if (r9 == 0) goto L57
                return r7
            L6f:
                if (r2 != 0) goto L74
                r6.removeCleanedAt(r0)
            L74:
                if (r0 != 0) goto L78
                int r0 = r6.allocated
            L78:
                int r0 = r0 - r3
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.putImpl(java.lang.Object, java.lang.Object, kotlinx.coroutines.debug.internal.HashedWeakRef):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ConcurrentWeakMap<K, V>.Core rehash() {
            Object obj;
            Symbol symbol;
            Marked mark;
            while (true) {
                ConcurrentWeakMap<K, V>.Core core = (ConcurrentWeakMap<K, V>.Core) new Core(Integer.highestOneBit(RangesKt.coerceAtLeast(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i = this.allocated;
                for (int i2 = 0; i2 < i; i2++) {
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) this.keys.get(i2);
                    Object obj2 = hashedWeakRef != null ? hashedWeakRef.get() : null;
                    if (hashedWeakRef != null && obj2 == null) {
                        removeCleanedAt(i2);
                    }
                    while (true) {
                        obj = this.values.get(i2);
                        if (obj instanceof Marked) {
                            obj = ((Marked) obj).ref;
                            break;
                        }
                        AtomicReferenceArray atomicReferenceArray = this.values;
                        mark = ConcurrentWeakMapKt.mark(obj);
                        if (Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, i2, obj, mark)) {
                            break;
                        }
                    }
                    if (obj2 != null && obj != null) {
                        Object putImpl = core.putImpl(obj2, obj, hashedWeakRef);
                        symbol = ConcurrentWeakMapKt.REHASH;
                        if (putImpl != symbol) {
                        }
                    }
                }
                return core;
            }
        }

        public final void cleanWeakRef(HashedWeakRef<?> weakRef) {
            int index = index(weakRef.hash);
            while (true) {
                HashedWeakRef<?> hashedWeakRef = (HashedWeakRef) this.keys.get(index);
                if (hashedWeakRef == null) {
                    return;
                }
                if (hashedWeakRef == weakRef) {
                    removeCleanedAt(index);
                    return;
                }
                if (index == 0) {
                    index = this.allocated;
                }
                index--;
            }
        }

        public final <E> Iterator<E> keyValueIterator(Function2<? super K, ? super V, ? extends E> factory) {
            return new KeyValueIterator(factory);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR&\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00028\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", "E", "", "", "findNext", "()V", "", "hasNext", "()Z", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "", "remove", "()Ljava/lang/Void;", "Lkotlin/Function2;", "factory", "Lkotlin/jvm/functions/Function2;", "", "index", "I", "key", "Ljava/lang/Object;", "value", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes9.dex */
        public final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator, j$.util.Iterator {
            private final Function2<K, V, E> factory;
            private int index = -1;
            private K key;
            private V value;

            @Override // j$.util.Iterator
            public final /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.getAuthRequestContext(this, consumer);
            }

            @Override // java.util.Iterator
            public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            /* JADX WARN: Multi-variable type inference failed */
            public KeyValueIterator(Function2<? super K, ? super V, ? extends E> function2) {
                this.factory = function2;
                findNext();
            }

            private final void findNext() {
                K k;
                while (true) {
                    int i = this.index + 1;
                    this.index = i;
                    if (i >= ((Core) Core.this).allocated) {
                        return;
                    }
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) Core.this.keys.get(this.index);
                    if (hashedWeakRef != null && (k = (K) hashedWeakRef.get()) != null) {
                        this.key = k;
                        V v = (V) Core.this.values.get(this.index);
                        if (v instanceof Marked) {
                            v = (V) ((Marked) v).ref;
                        }
                        if (v != null) {
                            this.value = v;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.index < ((Core) Core.this).allocated;
            }

            @Override // java.util.Iterator
            public final E next() {
                if (this.index >= ((Core) Core.this).allocated) {
                    throw new NoSuchElementException();
                }
                Function2<K, V, E> function2 = this.factory;
                K k = this.key;
                if (k == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    k = (K) Unit.INSTANCE;
                }
                V v = this.value;
                if (v == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    v = (V) Unit.INSTANCE;
                }
                E invoke = function2.invoke(k, v);
                findNext();
                return invoke;
            }

            @Override // java.util.Iterator
            public final Void remove() {
                ConcurrentWeakMapKt.noImpl();
                throw new KotlinNothingValueException();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u0007\u001a\u00028\u0002\u0012\u0006\u0010\u000b\u001a\u00028\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00028\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00028\u00038\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", DiskFormatter.KB, "V", "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "key", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "value", "getValue", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    static final class Entry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final K key;
        private final V value;

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        @JvmName(name = "getKey")
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        @JvmName(name = "getValue")
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V newValue) {
            ConcurrentWeakMapKt.noImpl();
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", "E", "Lkotlin/collections/AbstractMutableSet;", LottieParams.KEY_ELEMENT_ID, "", ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD, "(Ljava/lang/Object;)Z", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function2;", "factory", "Lkotlin/jvm/functions/Function2;", "", "getSize", "()I", GriverMonitorConstants.KEY_SIZE, "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    final class KeyValueSet<E> extends AbstractMutableSet<E> {
        private final Function2<K, V, E> factory;

        /* JADX WARN: Multi-variable type inference failed */
        public KeyValueSet(Function2<? super K, ? super V, ? extends E> function2) {
            this.factory = function2;
        }

        @Override // kotlin.collections.AbstractMutableSet
        @JvmName(name = "getSize")
        public final int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(E element) {
            ConcurrentWeakMapKt.noImpl();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final java.util.Iterator<E> iterator() {
            return ((Core) ConcurrentWeakMap.this.core).keyValueIterator(this.factory);
        }
    }
}

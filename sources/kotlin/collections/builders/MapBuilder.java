package kotlin.collections.builders;

import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.huawei.hms.opendevice.i;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u0083\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005:\f\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001B\n\b\u0016¢\u0006\u0005\b\u0080\u0001\u0010\u0012B\u0013\b\u0016\u0012\u0007\u0010\u0081\u0001\u001a\u00020\u0007¢\u0006\u0005\b\u0080\u0001\u0010'BI\b\u0002\u0012\f\u0010n\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n\u0012\u0006\u0010u\u001a\u00020a\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010t\u001a\u00020\u0007\u0012\u0006\u0010s\u001a\u00020\u0007¢\u0006\u0006\b\u0080\u0001\u0010\u0082\u0001J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u001b\u0010\u0018\u001a\u00020\u00172\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001c\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00172\u0006\u0010 \u001a\u00028\u0001H\u0016¢\u0006\u0004\b!\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00172\u000e\u0010\"\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010'J\u001b\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*H\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010-H\u0096\u0002¢\u0006\u0004\b.\u0010\u001fJ\u0017\u0010/\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b/\u0010\tJ\u0017\u00100\u001a\u00020\u00072\u0006\u0010 \u001a\u00028\u0001H\u0002¢\u0006\u0004\b0\u0010\tJ\u001a\u00101\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b3\u0010\tJ\u000f\u00104\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0017H\u0016¢\u0006\u0004\b6\u00107J\u001b\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000108H\u0000¢\u0006\u0004\b9\u0010:J!\u0010;\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0001H\u0016¢\u0006\u0004\b;\u0010<J%\u0010>\u001a\u00020\u00102\u0014\u0010=\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b>\u0010?J)\u0010@\u001a\u00020\u00172\u0018\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a0\u0015H\u0002¢\u0006\u0004\b@\u0010\u0019J#\u0010A\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0002¢\u0006\u0004\bA\u0010\u001dJ\u0017\u0010C\u001a\u00020\u00172\u0006\u0010B\u001a\u00020\u0007H\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010F\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u0007H\u0002¢\u0006\u0004\bF\u0010'J\u0019\u0010G\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\bG\u00102J#\u0010H\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0000¢\u0006\u0004\bH\u0010\u001dJ\u0017\u0010J\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0007H\u0002¢\u0006\u0004\bJ\u0010'J\u0017\u0010K\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0000¢\u0006\u0004\bK\u0010\tJ\u0017\u0010M\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u0007H\u0002¢\u0006\u0004\bM\u0010'J\u0017\u0010O\u001a\u00020\u00172\u0006\u0010N\u001a\u00028\u0001H\u0000¢\u0006\u0004\bO\u0010\u001fJ\u000f\u0010Q\u001a\u00020PH\u0016¢\u0006\u0004\bQ\u0010RJ\u001b\u0010T\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0000¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020-H\u0002¢\u0006\u0004\bV\u0010WR\u0014\u0010%\u001a\u00020\u00078CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u00105R&\u0010]\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010Z0Y8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R$\u0010_\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010^8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010b\u001a\u00020a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010g\u001a\u00020\u00078CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u00105R$\u0010i\u001a\u00020\u00172\u0006\u0010h\u001a\u00020\u00178\u0001@BX\u0081\u000e¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u00107R\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00028\u00000Y8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\\R\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u001e\u0010q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010p8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010s\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bs\u0010eR\u0016\u0010t\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bt\u0010eR\u0016\u0010u\u001a\u00020a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bu\u0010cR$\u0010v\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u00078\u0017@RX\u0097\u000e¢\u0006\f\n\u0004\bv\u0010e\u001a\u0004\bw\u00105R\u001a\u0010{\u001a\b\u0012\u0004\u0012\u00028\u00010x8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\by\u0010zR\u001e\u0010|\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b|\u0010oR\u001e\u0010~\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010}8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007f"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", DiskFormatter.KB, "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "key", "", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "", "allocateValuesArray", "()[Ljava/lang/Object;", "", "build", "()Ljava/util/Map;", "", "checkIsMutable$kotlin_stdlib", "()V", "clear", "compact", "", "m", "", "containsAllEntries$kotlin_stdlib", "(Ljava/util/Collection;)Z", "", RVParams.LONG_URL_WITH_ENTRY_KEY, "containsEntry$kotlin_stdlib", "(Ljava/util/Map$Entry;)Z", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "other", "contentEquals", "(Ljava/util/Map;)Z", "capacity", "ensureCapacity", "(I)V", "n", "ensureExtraCapacity", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$EntriesItr;", "", "equals", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "()I", "isEmpty", "()Z", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$KeysItr;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "from", "putAll", "(Ljava/util/Map;)V", "putAllEntries", "putEntry", i.MyBillsEntityDataFactory, "putRehash", "(I)Z", "newHashSize", "rehash", "remove", "removeEntry$kotlin_stdlib", "removedHash", "removeHashAt", "removeKey$kotlin_stdlib", "index", "removeKeyAt", LottieParams.KEY_ELEMENT_ID, "removeValue$kotlin_stdlib", "", "toString", "()Ljava/lang/String;", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$ValuesItr;", "writeReplace", "()Ljava/lang/Object;", "getCapacity", "", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Lkotlin/collections/builders/MapBuilderEntries;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "", "hashArray", "[I", "hashShift", "I", "getHashSize", "hashSize", "p0", "isReadOnly", "Z", "isReadOnly$kotlin_stdlib", "getKeys", UserMetadata.KEYDATA_FILENAME, "keysArray", "[Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilderKeys;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "length", "maxProbeDistance", "presenceArray", GriverMonitorConstants.KEY_SIZE, "getSize", "", "getValues", "()Ljava/util/Collection;", "values", "valuesArray", "Lkotlin/collections/builders/MapBuilderValues;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "<init>", "initialCapacity", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final int INITIAL_CAPACITY = 8;
    @Deprecated
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    @Deprecated
    private static final int MAGIC = -1640531527;
    @Deprecated
    private static final int TOMBSTONE = -1;
    private MapBuilderEntries<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private MapBuilderKeys<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private MapBuilderValues<V> valuesView;

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i, int i2) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i;
        this.length = i2;
        this.hashShift = Companion.computeShift(getHashSize());
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return getValues();
    }

    @JvmName(name = "getSize")
    public final int getSize() {
        return this.size;
    }

    @JvmName(name = "isReadOnly$kotlin_stdlib")
    /* renamed from: isReadOnly$kotlin_stdlib  reason: from getter */
    public final boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i) {
        this(ListBuilderKt.arrayOfUninitializedElements(i), null, new int[i], new int[Companion.computeHashSize(i)], 2, 0);
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final boolean containsKey(Object key) {
        return findKey(key) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final boolean containsValue(Object value) {
        return findValue(value) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final V get(Object key) {
        int findKey = findKey(key);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return vArr[findKey];
    }

    @Override // java.util.Map
    public final V put(K key, V value) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(key);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i = (-addKey$kotlin_stdlib) - 1;
            V v = allocateValuesArray[i];
            allocateValuesArray[i] = value;
            return v;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = value;
        return null;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final V remove(Object key) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(key);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        V v = vArr[removeKey$kotlin_stdlib];
        ListBuilderKt.resetAt(vArr, removeKey$kotlin_stdlib);
        return v;
    }

    @Override // java.util.Map
    public final void clear() {
        checkIsMutable$kotlin_stdlib();
        int i = this.length - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.presenceArray;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.hashArray[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    @JvmName(name = "getKeys")
    public final Set<K> getKeys() {
        MapBuilderKeys<K> mapBuilderKeys = this.keysView;
        if (mapBuilderKeys == null) {
            mapBuilderKeys = new MapBuilderKeys<>(this);
            this.keysView = mapBuilderKeys;
        }
        return mapBuilderKeys;
    }

    @JvmName(name = "getValues")
    public final Collection<V> getValues() {
        MapBuilderValues<V> mapBuilderValues = this.valuesView;
        if (mapBuilderValues == null) {
            mapBuilderValues = new MapBuilderValues<>(this);
            this.valuesView = mapBuilderValues;
        }
        return mapBuilderValues;
    }

    @JvmName(name = "getEntries")
    public final Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.entriesView;
        if (mapBuilderEntries == null) {
            MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
            this.entriesView = mapBuilderEntries2;
            return mapBuilderEntries2;
        }
        return mapBuilderEntries;
    }

    @Override // java.util.Map
    public final boolean equals(Object other) {
        return other == this || ((other instanceof Map) && contentEquals((Map) other));
    }

    @Override // java.util.Map
    public final int hashCode() {
        EntriesItr<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i += entriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        EntriesItr<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            entriesIterator$kotlin_stdlib.nextAppendString(sb);
            i++;
        }
        sb.append("}");
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    @JvmName(name = "getCapacity")
    private final int getCapacity() {
        return this.keysArray.length;
    }

    @JvmName(name = "getHashSize")
    private final int getHashSize() {
        return this.hashArray.length;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final void ensureExtraCapacity(int n) {
        ensureCapacity(this.length + n);
    }

    private final void ensureCapacity(int capacity) {
        if (capacity < 0) {
            throw new OutOfMemoryError();
        }
        if (capacity > getCapacity()) {
            int capacity2 = (getCapacity() * 3) / 2;
            if (capacity <= capacity2) {
                capacity = capacity2;
            }
            this.keysArray = (K[]) ListBuilderKt.copyOfUninitializedElements(this.keysArray, capacity);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) ListBuilderKt.copyOfUninitializedElements(vArr, capacity) : null;
            int[] copyOf = Arrays.copyOf(this.presenceArray, capacity);
            Intrinsics.checkNotNullExpressionValue(copyOf, "");
            this.presenceArray = copyOf;
            int computeHashSize = Companion.computeHashSize(capacity);
            if (computeHashSize > getHashSize()) {
                rehash(computeHashSize);
            }
        } else if ((this.length + capacity) - size() > getCapacity()) {
            rehash(getHashSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) ListBuilderKt.arrayOfUninitializedElements(getCapacity());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final int hash(K key) {
        return ((key != null ? key.hashCode() : 0) * MAGIC) >>> this.hashShift;
    }

    private final void compact() {
        int i;
        V[] vArr = this.valuesArray;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.length;
            if (i2 >= i) {
                break;
            }
            if (this.presenceArray[i2] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i3] = kArr[i2];
                if (vArr != null) {
                    vArr[i3] = vArr[i2];
                }
                i3++;
            }
            i2++;
        }
        ListBuilderKt.resetRange(this.keysArray, i3, i);
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, i3, this.length);
        }
        this.length = i3;
    }

    private final void rehash(int newHashSize) {
        if (this.length > size()) {
            compact();
        }
        if (newHashSize != getHashSize()) {
            this.hashArray = new int[newHashSize];
            this.hashShift = Companion.computeShift(newHashSize);
        } else {
            ArraysKt.fill(this.hashArray, 0, 0, getHashSize());
        }
        for (int i = 0; i < this.length; i++) {
            if (!putRehash(i)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final boolean putRehash(int i) {
        int hash = hash(this.keysArray[i]);
        int i2 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i + 1;
                this.presenceArray[i] = hash;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final int findKey(K key) {
        int hash = hash(key);
        int i = this.maxProbeDistance;
        while (true) {
            int i2 = this.hashArray[hash];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (Intrinsics.areEqual(this.keysArray[i3], key)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final int findValue(V value) {
        int i = this.length;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.presenceArray[i] >= 0) {
                V[] vArr = this.valuesArray;
                Intrinsics.checkNotNull(vArr);
                if (Intrinsics.areEqual(vArr[i], value)) {
                    return i;
                }
            }
        }
    }

    public final int addKey$kotlin_stdlib(K key) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(key);
            int coerceAtMost = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
            int i = 0;
            while (true) {
                int i2 = this.hashArray[hash];
                if (i2 <= 0) {
                    if (this.length >= getCapacity()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i3 = this.length;
                        int i4 = i3 + 1;
                        this.length = i4;
                        this.keysArray[i3] = key;
                        this.presenceArray[i3] = hash;
                        this.hashArray[hash] = i4;
                        this.size = size() + 1;
                        if (i > this.maxProbeDistance) {
                            this.maxProbeDistance = i;
                        }
                        return i3;
                    }
                } else if (Intrinsics.areEqual(this.keysArray[i2 - 1], key)) {
                    return -i2;
                } else {
                    i++;
                    if (i > coerceAtMost) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    hash = hash == 0 ? getHashSize() - 1 : hash - 1;
                }
            }
        }
    }

    public final int removeKey$kotlin_stdlib(K key) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(key);
        if (findKey < 0) {
            return -1;
        }
        removeKeyAt(findKey);
        return findKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKeyAt(int index) {
        ListBuilderKt.resetAt(this.keysArray, index);
        removeHashAt(this.presenceArray[index]);
        this.presenceArray[index] = -1;
        this.size = size() - 1;
    }

    private final void removeHashAt(int removedHash) {
        int coerceAtMost = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int i = 0;
        int i2 = removedHash;
        do {
            removedHash = removedHash == 0 ? getHashSize() - 1 : removedHash - 1;
            i++;
            if (i > this.maxProbeDistance) {
                this.hashArray[i2] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i3 = iArr[removedHash];
            if (i3 == 0) {
                iArr[i2] = 0;
                return;
            }
            if (i3 < 0) {
                iArr[i2] = -1;
            } else {
                int i4 = i3 - 1;
                if (((hash(this.keysArray[i4]) - removedHash) & (getHashSize() - 1)) >= i) {
                    this.hashArray[i2] = i3;
                    this.presenceArray[i4] = i2;
                }
                coerceAtMost--;
            }
            i2 = removedHash;
            i = 0;
            coerceAtMost--;
        } while (coerceAtMost >= 0);
        this.hashArray[i2] = -1;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return Intrinsics.areEqual(vArr[findKey], entry.getValue());
    }

    private final boolean contentEquals(Map<?, ?> other) {
        return size() == other.size() && containsAllEntries$kotlin_stdlib(other.entrySet());
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> m) {
        Intrinsics.checkNotNullParameter(m, "");
        for (Object obj : m) {
            if (obj == null) {
                return false;
            }
            try {
                if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    return false;
                }
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return true;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i = (-addKey$kotlin_stdlib) - 1;
        if (Intrinsics.areEqual(entry.getValue(), allocateValuesArray[i])) {
            return false;
        }
        allocateValuesArray[i] = entry.getValue();
        return true;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> from) {
        boolean z = false;
        if (from.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(from.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = from.iterator();
        while (it.hasNext()) {
            if (putEntry(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "");
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        if (Intrinsics.areEqual(vArr[findKey], entry.getValue())) {
            removeKeyAt(findKey);
            return true;
        }
        return false;
    }

    public final boolean removeValue$kotlin_stdlib(V element) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(element);
        if (findValue < 0) {
            return false;
        }
        removeKeyAt(findValue);
        return true;
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr<>(this);
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr<>(this);
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr<>(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\f\u0010\t"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "", "capacity", "computeHashSize", "(I)I", "hashSize", "computeShift", "INITIAL_CAPACITY", "I", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int computeHashSize(int capacity) {
            return Integer.highestOneBit(RangesKt.coerceAtLeast(capacity, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int computeShift(int hashSize) {
            return Integer.numberOfLeadingZeros(hashSize) + 1;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tR\"\u0010\f\u001a\u00020\u000b8\u0001@\u0001X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00158\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", DiskFormatter.KB, "V", "", "", "hasNext", "()Z", "", "initNext$kotlin_stdlib", "()V", "remove", "", "index", "I", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "Lkotlin/collections/builders/MapBuilder;", "map", "Lkotlin/collections/builders/MapBuilder;", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class Itr<K, V> {
        private int index;
        private int lastIndex;
        private final MapBuilder<K, V> map;

        public Itr(MapBuilder<K, V> mapBuilder) {
            Intrinsics.checkNotNullParameter(mapBuilder, "");
            this.map = mapBuilder;
            this.lastIndex = -1;
            initNext$kotlin_stdlib();
        }

        @JvmName(name = "getMap$kotlin_stdlib")
        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        @JvmName(name = "getIndex$kotlin_stdlib")
        /* renamed from: getIndex$kotlin_stdlib  reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        @JvmName(name = "setIndex$kotlin_stdlib")
        public final void setIndex$kotlin_stdlib(int i) {
            this.index = i;
        }

        @JvmName(name = "getLastIndex$kotlin_stdlib")
        /* renamed from: getLastIndex$kotlin_stdlib  reason: from getter */
        public final int getLastIndex() {
            return this.lastIndex;
        }

        @JvmName(name = "setLastIndex$kotlin_stdlib")
        public final void setLastIndex$kotlin_stdlib(int i) {
            this.lastIndex = i;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.index < ((MapBuilder) this.map).length) {
                int[] iArr = ((MapBuilder) this.map).presenceArray;
                int i = this.index;
                if (iArr[i] >= 0) {
                    return;
                }
                this.index = i + 1;
            }
        }

        public final boolean hasNext() {
            return this.index < ((MapBuilder) this.map).length;
        }

        public final void remove() {
            if (!(this.lastIndex != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.map.checkIsMutable$kotlin_stdlib();
            this.map.removeKeyAt(this.lastIndex);
            this.lastIndex = -1;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", DiskFormatter.KB, "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator, j$.util.Iterator {
        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeysItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "");
        }

        @Override // java.util.Iterator
        public final K next() {
            if (getIndex() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            setIndex$kotlin_stdlib(index + 1);
            setLastIndex$kotlin_stdlib(index);
            K k = (K) ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex()];
            initNext$kotlin_stdlib();
            return k;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", DiskFormatter.KB, "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ValuesItr<K, V> extends Itr<K, V> implements java.util.Iterator<V>, KMutableIterator, j$.util.Iterator {
        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValuesItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "");
        }

        @Override // java.util.Iterator
        public final V next() {
            if (getIndex() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            setIndex$kotlin_stdlib(index + 1);
            setLastIndex$kotlin_stdlib(index);
            Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
            Intrinsics.checkNotNull(objArr);
            V v = (V) objArr[getLastIndex()];
            initNext$kotlin_stdlib();
            return v;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0004B\u001b\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", DiskFormatter.KB, "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "Lkotlin/collections/builders/MapBuilder$EntryRef;", HummerConstants.HUMMER_NEXT, "()Lkotlin/collections/builders/MapBuilder$EntryRef;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", RVParams.SHOW_TOOLBAR, "", "nextAppendString", "(Ljava/lang/StringBuilder;)V", "", "nextHashCode$kotlin_stdlib", "()I", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class EntriesItr<K, V> extends Itr<K, V> implements java.util.Iterator<Map.Entry<K, V>>, KMutableIterator, j$.util.Iterator {
        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntriesItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "");
        }

        @Override // java.util.Iterator
        public final EntryRef<K, V> next() {
            if (getIndex() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            setIndex$kotlin_stdlib(index + 1);
            setLastIndex$kotlin_stdlib(index);
            EntryRef<K, V> entryRef = new EntryRef<>(getMap$kotlin_stdlib(), getLastIndex());
            initNext$kotlin_stdlib();
            return entryRef;
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            setIndex$kotlin_stdlib(index + 1);
            setLastIndex$kotlin_stdlib(index);
            Object obj = ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex()];
            int hashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
            Intrinsics.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex()];
            int hashCode2 = obj2 != null ? obj2.hashCode() : 0;
            initNext$kotlin_stdlib();
            return hashCode ^ hashCode2;
        }

        public final void nextAppendString(StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "");
            if (getIndex() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            setIndex$kotlin_stdlib(index + 1);
            setLastIndex$kotlin_stdlib(index);
            Object obj = ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex()];
            if (Intrinsics.areEqual(obj, getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
            Intrinsics.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex()];
            if (Intrinsics.areEqual(obj2, getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            initNext$kotlin_stdlib();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0017\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00028\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00028\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", DiskFormatter.KB, "V", "", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "index", "I", "getKey", "()Ljava/lang/Object;", "key", "Lkotlin/collections/builders/MapBuilder;", "map", "Lkotlin/collections/builders/MapBuilder;", "getValue", "value", "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final int index;
        private final MapBuilder<K, V> map;

        public EntryRef(MapBuilder<K, V> mapBuilder, int i) {
            Intrinsics.checkNotNullParameter(mapBuilder, "");
            this.map = mapBuilder;
            this.index = i;
        }

        @Override // java.util.Map.Entry
        @JvmName(name = "getKey")
        public final K getKey() {
            return (K) ((MapBuilder) this.map).keysArray[this.index];
        }

        @Override // java.util.Map.Entry
        @JvmName(name = "getValue")
        public final V getValue() {
            Object[] objArr = ((MapBuilder) this.map).valuesArray;
            Intrinsics.checkNotNull(objArr);
            return (V) objArr[this.index];
        }

        @Override // java.util.Map.Entry
        public final V setValue(V newValue) {
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] allocateValuesArray = this.map.allocateValuesArray();
            int i = this.index;
            V v = (V) allocateValuesArray[i];
            allocateValuesArray[i] = newValue;
            return v;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object other) {
            if (other instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) other;
                if (Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K key = getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }
}

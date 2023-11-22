package kotlin;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.UShortIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0017\n\u0002\b\b\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0014\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b0\u00101B\u0014\b\u0000\u0012\u0006\u0010,\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b0\u00102J\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\u0002ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010$\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0010\u0010(\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00118WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0017R\u001a\u0010,\u001a\u00020+8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010-\u0012\u0004\b.\u0010/\u0088\u0001,\u0092\u0001\u00020+ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", LottieParams.KEY_ELEMENT_ID, "", "contains-xj2QHRw", "([SS)Z", "contains", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "containsAll", "", "other", "equals-impl", "([SLjava/lang/Object;)Z", "equals", "", "index", "get-Mh2AYeg", "([SI)S", "get", "hashCode-impl", "([S)I", "hashCode", "isEmpty-impl", "([S)Z", "isEmpty", "", "iterator-impl", "([S)Ljava/util/Iterator;", "iterator", "value", "", "set-01HTLdE", "([SIS)V", "set", "", "toString-impl", "([S)Ljava/lang/String;", "toString", "getSize-impl", GriverMonitorConstants.KEY_SIZE, "", "storage", "[S", "getStorage$annotations", "()V", "constructor-impl", "(I)[S", "([S)[S", "Iterator"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class UShortArray implements Collection<UShort>, KMappedMarker {
    public final short[] storage;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShortArray m3507boximpl(short[] sArr) {
        return new UShortArray(sArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short[] m3509constructorimpl(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "");
        return sArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3512equalsimpl(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.areEqual(sArr, ((UShortArray) obj).getStorage());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3513equalsimpl0(short[] sArr, short[] sArr2) {
        return Intrinsics.areEqual(sArr, sArr2);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3516hashCodeimpl(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3520toStringimpl(short[] sArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("UShortArray(storage=");
        sb.append(Arrays.toString(sArr));
        sb.append(')');
        return sb.toString();
    }

    @Override // java.util.Collection
    public final /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-xj2QHRw  reason: not valid java name */
    public final boolean m3521addxj2QHRw(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        return m3512equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return m3516hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public final String toString() {
        return m3520toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ short[] getStorage() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return m3522containsxj2QHRw(((UShort) obj).getData());
        }
        return false;
    }

    private /* synthetic */ UShortArray(short[] sArr) {
        this.storage = sArr;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short[] m3508constructorimpl(int i) {
        return m3509constructorimpl(new short[i]);
    }

    /* renamed from: get-Mh2AYeg  reason: not valid java name */
    public static final short m3514getMh2AYeg(short[] sArr, int i) {
        return UShort.m3457constructorimpl(sArr[i]);
    }

    /* renamed from: set-01HTLdE  reason: not valid java name */
    public static final void m3519set01HTLdE(short[] sArr, int i, short s) {
        sArr[i] = s;
    }

    @JvmName(name = "getSize-impl")
    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m3515getSizeimpl(short[] sArr) {
        return sArr.length;
    }

    @Override // java.util.Collection
    /* renamed from: getSize  reason: merged with bridge method [inline-methods] */
    public final int size() {
        return m3515getSizeimpl(this.storage);
    }

    /* renamed from: iterator-impl  reason: not valid java name */
    public static java.util.Iterator<UShort> m3518iteratorimpl(short[] sArr) {
        return new Iterator(sArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator<UShort> iterator() {
        return m3518iteratorimpl(this.storage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\b\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b!"}, d2 = {"Lkotlin/UShortArray$Iterator;", "Lkotlin/collections/UShortIterator;", "", "hasNext", "()Z", "Lkotlin/UShort;", "nextUShort-Mh2AYeg", "()S", "nextUShort", "", "array", "[S", "", "index", "I", "<init>", "([S)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Iterator extends UShortIterator {
        private final short[] array;
        private int index;

        public Iterator(short[] sArr) {
            Intrinsics.checkNotNullParameter(sArr, "");
            this.array = sArr;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // kotlin.collections.UShortIterator
        /* renamed from: nextUShort-Mh2AYeg  reason: not valid java name */
        public final short mo3524nextUShortMh2AYeg() {
            int i = this.index;
            short[] sArr = this.array;
            if (i < sArr.length) {
                this.index = i + 1;
                return UShort.m3457constructorimpl(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public final boolean m3522containsxj2QHRw(short s) {
        return m3510containsxj2QHRw(this.storage, s);
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public static boolean m3510containsxj2QHRw(short[] sArr, short s) {
        return ArraysKt.contains(sArr, s);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        return m3511containsAllimpl(this.storage, collection);
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m3511containsAllimpl(short[] sArr, Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        Collection<UShort> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!((obj instanceof UShort) && ArraysKt.contains(sArr, ((UShort) obj).getData()))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m3517isEmptyimpl(short[] sArr) {
        return sArr.length == 0;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return m3517isEmptyimpl(this.storage);
    }
}

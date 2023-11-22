package kotlin;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0014\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b0\u00101B\u0014\b\u0000\u0012\u0006\u0010,\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b0\u00102J\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\u0002ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010$\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0010\u0010(\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00118WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0017R\u001a\u0010,\u001a\u00020+8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010-\u0012\u0004\b.\u0010/\u0088\u0001,\u0092\u0001\u00020+ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", LottieParams.KEY_ELEMENT_ID, "", "contains-WZ4Q5Ns", "([II)Z", "contains", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "containsAll", "", "other", "equals-impl", "([ILjava/lang/Object;)Z", "equals", "", "index", "get-pVg5ArA", "([II)I", "get", "hashCode-impl", "([I)I", "hashCode", "isEmpty-impl", "([I)Z", "isEmpty", "", "iterator-impl", "([I)Ljava/util/Iterator;", "iterator", "value", "", "set-VXSXFK8", "([III)V", "set", "", "toString-impl", "([I)Ljava/lang/String;", "toString", "getSize-impl", GriverMonitorConstants.KEY_SIZE, "", "storage", "[I", "getStorage$annotations", "()V", "constructor-impl", "(I)[I", "([I)[I", "Iterator"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    public final int[] storage;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UIntArray m3325boximpl(int[] iArr) {
        return new UIntArray(iArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m3327constructorimpl(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "");
        return iArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3330equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual(iArr, ((UIntArray) obj).getStorage());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3331equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3334hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3338toStringimpl(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("UIntArray(storage=");
        sb.append(Arrays.toString(iArr));
        sb.append(')');
        return sb.toString();
    }

    @Override // java.util.Collection
    public final /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-WZ4Q5Ns  reason: not valid java name */
    public final boolean m3339addWZ4Q5Ns(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        return m3330equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return m3334hashCodeimpl(this.storage);
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
        return m3338toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ int[] getStorage() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return m3340containsWZ4Q5Ns(((UInt) obj).getData());
        }
        return false;
    }

    private /* synthetic */ UIntArray(int[] iArr) {
        this.storage = iArr;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m3326constructorimpl(int i) {
        return m3327constructorimpl(new int[i]);
    }

    /* renamed from: get-pVg5ArA  reason: not valid java name */
    public static final int m3332getpVg5ArA(int[] iArr, int i) {
        return UInt.m3273constructorimpl(iArr[i]);
    }

    /* renamed from: set-VXSXFK8  reason: not valid java name */
    public static final void m3337setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    @JvmName(name = "getSize-impl")
    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m3333getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    @Override // java.util.Collection
    /* renamed from: getSize  reason: merged with bridge method [inline-methods] */
    public final int size() {
        return m3333getSizeimpl(this.storage);
    }

    /* renamed from: iterator-impl  reason: not valid java name */
    public static java.util.Iterator<UInt> m3336iteratorimpl(int[] iArr) {
        return new Iterator(iArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator<UInt> iterator() {
        return m3336iteratorimpl(this.storage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\b\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b!"}, d2 = {"Lkotlin/UIntArray$Iterator;", "Lkotlin/collections/UIntIterator;", "", "hasNext", "()Z", "Lkotlin/UInt;", "nextUInt-pVg5ArA", "()I", "nextUInt", "", "array", "[I", "", "index", "I", "<init>", "([I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Iterator extends UIntIterator {
        private final int[] array;
        private int index;

        public Iterator(int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "");
            this.array = iArr;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // kotlin.collections.UIntIterator
        /* renamed from: nextUInt-pVg5ArA  reason: not valid java name */
        public final int mo3342nextUIntpVg5ArA() {
            int i = this.index;
            int[] iArr = this.array;
            if (i < iArr.length) {
                this.index = i + 1;
                return UInt.m3273constructorimpl(iArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public final boolean m3340containsWZ4Q5Ns(int i) {
        return m3328containsWZ4Q5Ns(this.storage, i);
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public static boolean m3328containsWZ4Q5Ns(int[] iArr, int i) {
        return ArraysKt.contains(iArr, i);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        return m3329containsAllimpl(this.storage, collection);
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m3329containsAllimpl(int[] iArr, Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        Collection<UInt> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!((obj instanceof UInt) && ArraysKt.contains(iArr, ((UInt) obj).getData()))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m3335isEmptyimpl(int[] iArr) {
        return iArr.length == 0;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return m3335isEmptyimpl(this.storage);
    }
}

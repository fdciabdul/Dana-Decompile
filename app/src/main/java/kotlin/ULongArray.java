package kotlin;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.ULongIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\b\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0014\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b0\u00101B\u0014\b\u0000\u0012\u0006\u0010,\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b0\u00102J\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\u0002ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010$\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0010\u0010(\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00118WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0017R\u001a\u0010,\u001a\u00020+8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010-\u0012\u0004\b.\u0010/\u0088\u0001,\u0092\u0001\u00020+ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", LottieParams.KEY_ELEMENT_ID, "", "contains-VKZWuLQ", "([JJ)Z", "contains", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "containsAll", "", "other", "equals-impl", "([JLjava/lang/Object;)Z", "equals", "", "index", "get-s-VKNKU", "([JI)J", "get", "hashCode-impl", "([J)I", "hashCode", "isEmpty-impl", "([J)Z", "isEmpty", "", "iterator-impl", "([J)Ljava/util/Iterator;", "iterator", "value", "", "set-k8EXiF4", "([JIJ)V", "set", "", "toString-impl", "([J)Ljava/lang/String;", "toString", "getSize-impl", GriverMonitorConstants.KEY_SIZE, "", "storage", "[J", "getStorage$annotations", "()V", "constructor-impl", "(I)[J", "([J)[J", "Iterator"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class ULongArray implements Collection<ULong>, KMappedMarker {
    public final long[] storage;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULongArray m3403boximpl(long[] jArr) {
        return new ULongArray(jArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long[] m3405constructorimpl(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "");
        return jArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3408equalsimpl(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.areEqual(jArr, ((ULongArray) obj).getStorage());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3409equalsimpl0(long[] jArr, long[] jArr2) {
        return Intrinsics.areEqual(jArr, jArr2);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3412hashCodeimpl(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3416toStringimpl(long[] jArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("ULongArray(storage=");
        sb.append(Arrays.toString(jArr));
        sb.append(')');
        return sb.toString();
    }

    @Override // java.util.Collection
    public final /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-VKZWuLQ  reason: not valid java name */
    public final boolean m3417addVKZWuLQ(long j) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        return m3408equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return m3412hashCodeimpl(this.storage);
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
        return m3416toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ long[] getStorage() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m3418containsVKZWuLQ(((ULong) obj).getData());
        }
        return false;
    }

    private /* synthetic */ ULongArray(long[] jArr) {
        this.storage = jArr;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long[] m3404constructorimpl(int i) {
        return m3405constructorimpl(new long[i]);
    }

    /* renamed from: get-s-VKNKU  reason: not valid java name */
    public static final long m3410getsVKNKU(long[] jArr, int i) {
        return ULong.m3351constructorimpl(jArr[i]);
    }

    /* renamed from: set-k8EXiF4  reason: not valid java name */
    public static final void m3415setk8EXiF4(long[] jArr, int i, long j) {
        jArr[i] = j;
    }

    @JvmName(name = "getSize-impl")
    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m3411getSizeimpl(long[] jArr) {
        return jArr.length;
    }

    @Override // java.util.Collection
    /* renamed from: getSize  reason: merged with bridge method [inline-methods] */
    public final int size() {
        return m3411getSizeimpl(this.storage);
    }

    /* renamed from: iterator-impl  reason: not valid java name */
    public static java.util.Iterator<ULong> m3414iteratorimpl(long[] jArr) {
        return new Iterator(jArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator<ULong> iterator() {
        return m3414iteratorimpl(this.storage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\b\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b!"}, d2 = {"Lkotlin/ULongArray$Iterator;", "Lkotlin/collections/ULongIterator;", "", "hasNext", "()Z", "Lkotlin/ULong;", "nextULong-s-VKNKU", "()J", "nextULong", "", "array", "[J", "", "index", "I", "<init>", "([J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Iterator extends ULongIterator {
        private final long[] array;
        private int index;

        public Iterator(long[] jArr) {
            Intrinsics.checkNotNullParameter(jArr, "");
            this.array = jArr;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // kotlin.collections.ULongIterator
        /* renamed from: nextULong-s-VKNKU  reason: not valid java name */
        public final long mo3420nextULongsVKNKU() {
            int i = this.index;
            long[] jArr = this.array;
            if (i < jArr.length) {
                this.index = i + 1;
                return ULong.m3351constructorimpl(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public final boolean m3418containsVKZWuLQ(long j) {
        return m3406containsVKZWuLQ(this.storage, j);
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public static boolean m3406containsVKZWuLQ(long[] jArr, long j) {
        return ArraysKt.contains(jArr, j);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        return m3407containsAllimpl(this.storage, collection);
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m3407containsAllimpl(long[] jArr, Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        Collection<ULong> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!((obj instanceof ULong) && ArraysKt.contains(jArr, ((ULong) obj).getData()))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m3413isEmptyimpl(long[] jArr) {
        return jArr.length == 0;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return m3413isEmptyimpl(this.storage);
    }
}

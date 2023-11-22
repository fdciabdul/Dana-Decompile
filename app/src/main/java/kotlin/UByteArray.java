package kotlin;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.UByteIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\b\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0014\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b0\u00101B\u0014\b\u0000\u0012\u0006\u0010,\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b0\u00102J\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\u0002ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010$\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0010\u0010(\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00118WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0017R\u001a\u0010,\u001a\u00020+8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010-\u0012\u0004\b.\u0010/\u0088\u0001,\u0092\u0001\u00020+ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", LottieParams.KEY_ELEMENT_ID, "", "contains-7apg3OU", "([BB)Z", "contains", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "containsAll", "", "other", "equals-impl", "([BLjava/lang/Object;)Z", "equals", "", "index", "get-w2LRezQ", "([BI)B", "get", "hashCode-impl", "([B)I", "hashCode", "isEmpty-impl", "([B)Z", "isEmpty", "", "iterator-impl", "([B)Ljava/util/Iterator;", "iterator", "value", "", "set-VurrAj0", "([BIB)V", "set", "", "toString-impl", "([B)Ljava/lang/String;", "toString", "getSize-impl", GriverMonitorConstants.KEY_SIZE, "", "storage", "[B", "getStorage$annotations", "()V", "constructor-impl", "(I)[B", "([B)[B", "Iterator"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class UByteArray implements Collection<UByte>, KMappedMarker {
    public final byte[] storage;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByteArray m3247boximpl(byte[] bArr) {
        return new UByteArray(bArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte[] m3249constructorimpl(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        return bArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3252equalsimpl(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.areEqual(bArr, ((UByteArray) obj).getStorage());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3253equalsimpl0(byte[] bArr, byte[] bArr2) {
        return Intrinsics.areEqual(bArr, bArr2);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3256hashCodeimpl(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3260toStringimpl(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("UByteArray(storage=");
        sb.append(Arrays.toString(bArr));
        sb.append(')');
        return sb.toString();
    }

    @Override // java.util.Collection
    public final /* synthetic */ boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-7apg3OU  reason: not valid java name */
    public final boolean m3261add7apg3OU(byte b) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        return m3252equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return m3256hashCodeimpl(this.storage);
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
        return m3260toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ byte[] getStorage() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return m3262contains7apg3OU(((UByte) obj).getData());
        }
        return false;
    }

    private /* synthetic */ UByteArray(byte[] bArr) {
        this.storage = bArr;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte[] m3248constructorimpl(int i) {
        return m3249constructorimpl(new byte[i]);
    }

    /* renamed from: get-w2LRezQ  reason: not valid java name */
    public static final byte m3254getw2LRezQ(byte[] bArr, int i) {
        return UByte.m3197constructorimpl(bArr[i]);
    }

    /* renamed from: set-VurrAj0  reason: not valid java name */
    public static final void m3259setVurrAj0(byte[] bArr, int i, byte b) {
        bArr[i] = b;
    }

    @JvmName(name = "getSize-impl")
    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m3255getSizeimpl(byte[] bArr) {
        return bArr.length;
    }

    @Override // java.util.Collection
    /* renamed from: getSize  reason: merged with bridge method [inline-methods] */
    public final int size() {
        return m3255getSizeimpl(this.storage);
    }

    /* renamed from: iterator-impl  reason: not valid java name */
    public static java.util.Iterator<UByte> m3258iteratorimpl(byte[] bArr) {
        return new Iterator(bArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator<UByte> iterator() {
        return m3258iteratorimpl(this.storage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\b\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b!"}, d2 = {"Lkotlin/UByteArray$Iterator;", "Lkotlin/collections/UByteIterator;", "", "hasNext", "()Z", "Lkotlin/UByte;", "nextUByte-w2LRezQ", "()B", "nextUByte", "", "array", "[B", "", "index", "I", "<init>", "([B)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Iterator extends UByteIterator {
        private final byte[] array;
        private int index;

        public Iterator(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "");
            this.array = bArr;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // kotlin.collections.UByteIterator
        /* renamed from: nextUByte-w2LRezQ  reason: not valid java name */
        public final byte mo3264nextUBytew2LRezQ() {
            int i = this.index;
            byte[] bArr = this.array;
            if (i < bArr.length) {
                this.index = i + 1;
                return UByte.m3197constructorimpl(bArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }
    }

    /* renamed from: contains-7apg3OU  reason: not valid java name */
    public final boolean m3262contains7apg3OU(byte b) {
        return m3250contains7apg3OU(this.storage, b);
    }

    /* renamed from: contains-7apg3OU  reason: not valid java name */
    public static boolean m3250contains7apg3OU(byte[] bArr, byte b) {
        return ArraysKt.contains(bArr, b);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        return m3251containsAllimpl(this.storage, collection);
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m3251containsAllimpl(byte[] bArr, Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        Collection<UByte> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!((obj instanceof UByte) && ArraysKt.contains(bArr, ((UByte) obj).getData()))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m3257isEmptyimpl(byte[] bArr) {
        return bArr.length == 0;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return m3257isEmptyimpl(this.storage);
    }
}

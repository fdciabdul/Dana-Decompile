package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001a\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001a\u0010\n\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\t0\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0004\u001a\u001a\u0010\r\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00010\u000bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001a\u0010\u0010\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001a\u0010\u0013\u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020\u00060\u000bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001a\u0010\u0016\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u000bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"", "Lkotlin/UByte;", "Lkotlin/UInt;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "", "Lkotlin/UByteArray;", "toUByteArray", "(Ljava/util/Collection;)[B", "Lkotlin/UIntArray;", "toUIntArray", "(Ljava/util/Collection;)[I", "Lkotlin/ULongArray;", "toULongArray", "(Ljava/util/Collection;)[J", "Lkotlin/UShortArray;", "toUShortArray", "(Ljava/util/Collection;)[S"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes9.dex */
class UCollectionsKt___UCollectionsKt {
    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        byte[] m3248constructorimpl = UByteArray.m3248constructorimpl(collection.size());
        Iterator<UByte> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UByteArray.m3259setVurrAj0(m3248constructorimpl, i, it.next().getData());
            i++;
        }
        return m3248constructorimpl;
    }

    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        int[] m3326constructorimpl = UIntArray.m3326constructorimpl(collection.size());
        Iterator<UInt> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UIntArray.m3337setVXSXFK8(m3326constructorimpl, i, it.next().getData());
            i++;
        }
        return m3326constructorimpl;
    }

    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        long[] m3404constructorimpl = ULongArray.m3404constructorimpl(collection.size());
        Iterator<ULong> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            ULongArray.m3415setk8EXiF4(m3404constructorimpl, i, it.next().getData());
            i++;
        }
        return m3404constructorimpl;
    }

    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        short[] m3508constructorimpl = UShortArray.m3508constructorimpl(collection.size());
        Iterator<UShort> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UShortArray.m3519set01HTLdE(m3508constructorimpl, i, it.next().getData());
            i++;
        }
        return m3508constructorimpl;
    }

    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Iterator<UInt> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m3273constructorimpl(i + it.next().getData());
        }
        return i;
    }

    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Iterator<ULong> it = iterable.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ULong.m3351constructorimpl(j + it.next().getData());
        }
        return j;
    }

    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Iterator<UByte> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m3273constructorimpl(i + UInt.m3273constructorimpl(it.next().getData() & 255));
        }
        return i;
    }

    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Iterator<UShort> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m3273constructorimpl(i + UInt.m3273constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return i;
    }
}

package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001a\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001a\u0010\n\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\t0\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "Lkotlin/UInt;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/sequences/USequencesKt")
/* loaded from: classes9.dex */
class USequencesKt___USequencesKt {
    public static final int sumOfUInt(Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Iterator<UInt> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m3273constructorimpl(i + it.next().getData());
        }
        return i;
    }

    public static final long sumOfULong(Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Iterator<ULong> it = sequence.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ULong.m3351constructorimpl(j + it.next().getData());
        }
        return j;
    }

    public static final int sumOfUByte(Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Iterator<UByte> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m3273constructorimpl(i + UInt.m3273constructorimpl(it.next().getData() & 255));
        }
        return i;
    }

    public static final int sumOfUShort(Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Iterator<UShort> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m3273constructorimpl(i + UInt.m3273constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return i;
    }
}

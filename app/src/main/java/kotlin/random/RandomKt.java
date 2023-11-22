package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

@Metadata(d1 = {"\u0000@\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000f\u0010\u0012\u001a\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0018\u001a\u00020\u0000*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0019\u0010\u001b\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001b\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001e\u0010\u001f"}, d2 = {"", "seed", "Lkotlin/random/Random;", "Random", "(I)Lkotlin/random/Random;", "", "(J)Lkotlin/random/Random;", "", "from", "until", "", "boundsErrorMessage", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;", "", "", "checkRangeBounds", "(DD)V", "(II)V", "(JJ)V", "value", "fastLog2", "(I)I", "Lkotlin/ranges/IntRange;", "range", "nextInt", "(Lkotlin/random/Random;Lkotlin/ranges/IntRange;)I", "Lkotlin/ranges/LongRange;", "nextLong", "(Lkotlin/random/Random;Lkotlin/ranges/LongRange;)J", "bitCount", "takeUpperBits", "(II)I"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RandomKt {
    public static final int takeUpperBits(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    public static final Random Random(int i) {
        return new XorWowRandom(i, i >> 31);
    }

    public static final Random Random(long j) {
        return new XorWowRandom((int) j, (int) (j >> 32));
    }

    public static final int nextInt(Random random, IntRange intRange) {
        Intrinsics.checkNotNullParameter(random, "");
        Intrinsics.checkNotNullParameter(intRange, "");
        if (!intRange.isEmpty()) {
            return intRange.getLast() < Integer.MAX_VALUE ? random.nextInt(intRange.getFirst(), intRange.getLast() + 1) : intRange.getFirst() > Integer.MIN_VALUE ? random.nextInt(intRange.getFirst() - 1, intRange.getLast()) + 1 : random.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot get random in empty range: ");
        sb.append(intRange);
        throw new IllegalArgumentException(sb.toString());
    }

    public static final long nextLong(Random random, LongRange longRange) {
        Intrinsics.checkNotNullParameter(random, "");
        Intrinsics.checkNotNullParameter(longRange, "");
        if (!longRange.isEmpty()) {
            return longRange.getLast() < LongCompanionObject.MAX_VALUE ? random.nextLong(longRange.getFirst(), longRange.getLast() + 1) : longRange.getFirst() > Long.MIN_VALUE ? random.nextLong(longRange.getFirst() - 1, longRange.getLast()) + 1 : random.nextLong();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot get random in empty range: ");
        sb.append(longRange);
        throw new IllegalArgumentException(sb.toString());
    }

    public static final int fastLog2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final void checkRangeBounds(int i, int i2) {
        if (!(i2 > i)) {
            throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final void checkRangeBounds(long j, long j2) {
        if (!(j2 > j)) {
            throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    public static final void checkRangeBounds(double d, double d2) {
        if (!(d2 > d)) {
            throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(d), Double.valueOf(d2)).toString());
        }
    }

    public static final String boundsErrorMessage(Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "");
        Intrinsics.checkNotNullParameter(obj2, "");
        StringBuilder sb = new StringBuilder();
        sb.append("Random range is empty: [");
        sb.append(obj);
        sb.append(", ");
        sb.append(obj2);
        sb.append(").");
        return sb.toString();
    }
}

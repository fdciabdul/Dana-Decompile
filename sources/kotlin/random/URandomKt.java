package kotlin.random;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a0\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0000*\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001c\u0010\u0018\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a$\u0010\u0018\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eø\u0001\u0000¢\u0006\u0004\b\u0018\u0010 \u001a\u0014\u0010!\u001a\u00020\u0007*\u00020\u000bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001c\u0010!\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a$\u0010!\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010!\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u001f\u001a\u00020'ø\u0001\u0000¢\u0006\u0004\b!\u0010(\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/UInt;", "from", "until", "", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkUIntRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "checkULongRangeBounds", "Lkotlin/random/Random;", "", GriverMonitorConstants.KEY_SIZE, "Lkotlin/UByteArray;", "nextUBytes", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "Lkotlin/ranges/UIntRange;", "range", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class URandomKt {
    public static final int nextUInt(Random random) {
        Intrinsics.checkNotNullParameter(random, "");
        return UInt.m3273constructorimpl(random.nextInt());
    }

    /* renamed from: nextUInt-qCasIEU */
    public static final int m4381nextUIntqCasIEU(Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "");
        return m4380nextUInta8DCA5k(random, 0, i);
    }

    /* renamed from: nextUInt-a8DCA5k */
    public static final int m4380nextUInta8DCA5k(Random random, int i, int i2) {
        Intrinsics.checkNotNullParameter(random, "");
        m4375checkUIntRangeBoundsJ1ME1BU(i, i2);
        return UInt.m3273constructorimpl(random.nextInt(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    public static final int nextUInt(Random random, UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(random, "");
        Intrinsics.checkNotNullParameter(uIntRange, "");
        if (!uIntRange.isEmpty()) {
            return UnsignedKt.uintCompare(uIntRange.getLast(), -1) < 0 ? m4380nextUInta8DCA5k(random, uIntRange.getFirst(), UInt.m3273constructorimpl(uIntRange.getLast() + 1)) : UnsignedKt.uintCompare(uIntRange.getFirst(), 0) > 0 ? UInt.m3273constructorimpl(m4380nextUInta8DCA5k(random, UInt.m3273constructorimpl(uIntRange.getFirst() - 1), uIntRange.getLast()) + 1) : nextUInt(random);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot get random in empty range: ");
        sb.append(uIntRange);
        throw new IllegalArgumentException(sb.toString());
    }

    public static final long nextULong(Random random) {
        Intrinsics.checkNotNullParameter(random, "");
        return ULong.m3351constructorimpl(random.nextLong());
    }

    /* renamed from: nextULong-V1Xi4fY */
    public static final long m4382nextULongV1Xi4fY(Random random, long j) {
        Intrinsics.checkNotNullParameter(random, "");
        return m4383nextULongjmpaWc(random, 0L, j);
    }

    /* renamed from: nextULong-jmpaW-c */
    public static final long m4383nextULongjmpaWc(Random random, long j, long j2) {
        Intrinsics.checkNotNullParameter(random, "");
        m4376checkULongRangeBoundseb3DHEI(j, j2);
        return ULong.m3351constructorimpl(random.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    public static final long nextULong(Random random, ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(random, "");
        Intrinsics.checkNotNullParameter(uLongRange, "");
        if (!uLongRange.isEmpty()) {
            return UnsignedKt.ulongCompare(uLongRange.getLast(), -1L) < 0 ? m4383nextULongjmpaWc(random, uLongRange.getFirst(), ULong.m3351constructorimpl(uLongRange.getLast() + ULong.m3351constructorimpl(1L))) : UnsignedKt.ulongCompare(uLongRange.getFirst(), 0L) > 0 ? ULong.m3351constructorimpl(m4383nextULongjmpaWc(random, ULong.m3351constructorimpl(uLongRange.getFirst() - ULong.m3351constructorimpl(1L)), uLongRange.getLast()) + ULong.m3351constructorimpl(1L)) : nextULong(random);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot get random in empty range: ");
        sb.append(uLongRange);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: nextUBytes-EVgfTAA */
    public static final byte[] m4377nextUBytesEVgfTAA(Random random, byte[] bArr) {
        Intrinsics.checkNotNullParameter(random, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        random.nextBytes(bArr);
        return bArr;
    }

    public static final byte[] nextUBytes(Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "");
        return UByteArray.m3249constructorimpl(random.nextBytes(i));
    }

    /* renamed from: nextUBytes-Wvrt4B4$default */
    public static /* synthetic */ byte[] m4379nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m3255getSizeimpl(bArr);
        }
        return m4378nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    /* renamed from: nextUBytes-Wvrt4B4 */
    public static final byte[] m4378nextUBytesWvrt4B4(Random random, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(random, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        random.nextBytes(bArr, i, i2);
        return bArr;
    }

    /* renamed from: checkUIntRangeBounds-J1ME1BU */
    public static final void m4375checkUIntRangeBoundsJ1ME1BU(int i, int i2) {
        if (!(UnsignedKt.uintCompare(i2, i) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m3267boximpl(i), UInt.m3267boximpl(i2)).toString());
        }
    }

    /* renamed from: checkULongRangeBounds-eb3DHEI */
    public static final void m4376checkULongRangeBoundseb3DHEI(long j, long j2) {
        if (!(UnsignedKt.ulongCompare(j2, j) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m3345boximpl(j), ULong.m3345boximpl(j2)).toString());
        }
    }
}

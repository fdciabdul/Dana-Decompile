package kotlin;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001a\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\f\u001a\"\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\f\u001a\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\"\u0010\u0018\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\"\u0010\u001a\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017\u001a\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH\u0000¢\u0006\u0004\b\u001e\u0010!\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"", SecurityConstants.KEY_VALUE, "Lkotlin/UInt;", "doubleToUInt", "(D)I", "Lkotlin/ULong;", "doubleToULong", "(D)J", "", "v1", "v2", "uintCompare", "(II)I", "uintDivide-J1ME1BU", "uintDivide", "uintRemainder-J1ME1BU", "uintRemainder", "uintToDouble", "(I)D", "", "ulongCompare", "(JJ)I", "ulongDivide-eb3DHEI", "(JJ)J", "ulongDivide", "ulongRemainder-eb3DHEI", "ulongRemainder", "ulongToDouble", "(J)D", "", "ulongToString", "(J)Ljava/lang/String;", "base", "(JI)Ljava/lang/String;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnsignedKt {
    public static final int uintCompare(int i, int i2) {
        return Intrinsics.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    public static final int ulongCompare(long j, long j2) {
        return Intrinsics.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    /* renamed from: uintDivide-J1ME1BU  reason: not valid java name */
    public static final int m3526uintDivideJ1ME1BU(int i, int i2) {
        return UInt.m3273constructorimpl((int) ((i & 4294967295L) / (i2 & 4294967295L)));
    }

    /* renamed from: uintRemainder-J1ME1BU  reason: not valid java name */
    public static final int m3527uintRemainderJ1ME1BU(int i, int i2) {
        return UInt.m3273constructorimpl((int) ((i & 4294967295L) % (i2 & 4294967295L)));
    }

    /* renamed from: ulongDivide-eb3DHEI  reason: not valid java name */
    public static final long m3528ulongDivideeb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ulongCompare(j, j2) < 0 ? ULong.m3351constructorimpl(0L) : ULong.m3351constructorimpl(1L);
        } else if (j >= 0) {
            return ULong.m3351constructorimpl(j / j2);
        } else {
            long j3 = ((j >>> 1) / j2) << 1;
            return ULong.m3351constructorimpl(j3 + (ulongCompare(ULong.m3351constructorimpl(j - (j3 * j2)), ULong.m3351constructorimpl(j2)) < 0 ? 0 : 1));
        }
    }

    /* renamed from: ulongRemainder-eb3DHEI  reason: not valid java name */
    public static final long m3529ulongRemaindereb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ulongCompare(j, j2) >= 0 ? ULong.m3351constructorimpl(j - j2) : j;
        } else if (j >= 0) {
            return ULong.m3351constructorimpl(j % j2);
        } else {
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            if (ulongCompare(ULong.m3351constructorimpl(j3), ULong.m3351constructorimpl(j2)) < 0) {
                j2 = 0;
            }
            return ULong.m3351constructorimpl(j3 - j2);
        }
    }

    public static final int doubleToUInt(double d) {
        if (!Double.isNaN(d) && d > uintToDouble(0)) {
            if (d < uintToDouble(-1)) {
                if (d <= 2.147483647E9d) {
                    return UInt.m3273constructorimpl((int) d);
                }
                return UInt.m3273constructorimpl(UInt.m3273constructorimpl((int) (d - 2.147483647E9d)) + UInt.m3273constructorimpl(Integer.MAX_VALUE));
            }
            return -1;
        }
        return 0;
    }

    public static final long doubleToULong(double d) {
        if (!Double.isNaN(d) && d > ulongToDouble(0L)) {
            if (d < ulongToDouble(-1L)) {
                if (d < 9.223372036854776E18d) {
                    return ULong.m3351constructorimpl((long) d);
                }
                return ULong.m3351constructorimpl(ULong.m3351constructorimpl((long) (d - 9.223372036854776E18d)) - Long.MIN_VALUE);
            }
            return -1L;
        }
        return 0L;
    }

    public static final double uintToDouble(int i) {
        double d = Integer.MAX_VALUE & i;
        double d2 = (i >>> 31) << 30;
        Double.isNaN(d2);
        Double.isNaN(d);
        return d + (d2 * 2.0d);
    }

    public static final double ulongToDouble(long j) {
        double d = j >>> 11;
        double d2 = j & 2047;
        Double.isNaN(d);
        Double.isNaN(d2);
        return (d * 2048.0d) + d2;
    }

    public static final String ulongToString(long j) {
        return ulongToString(j, 10);
    }

    public static final String ulongToString(long j, int i) {
        if (j >= 0) {
            String l = Long.toString(j, CharsKt.checkRadix(i));
            Intrinsics.checkNotNullExpressionValue(l, "");
            return l;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(j3, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l2, "");
        sb.append(l2);
        String l3 = Long.toString(j4, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l3, "");
        sb.append(l3);
        return sb.toString();
    }
}

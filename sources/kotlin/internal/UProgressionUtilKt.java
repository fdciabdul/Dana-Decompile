package kotlin.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u001a*\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\u000f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0005\u001a*\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "differenceModulo", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "start", "end", "", "step", "getProgressionLastElement-Nkh28Cs", "getProgressionLastElement", "", "getProgressionLastElement-7ftBX0g"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA  reason: not valid java name */
    private static final int m4367differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int m3527uintRemainderJ1ME1BU = UnsignedKt.m3527uintRemainderJ1ME1BU(i, i3);
        int m3527uintRemainderJ1ME1BU2 = UnsignedKt.m3527uintRemainderJ1ME1BU(i2, i3);
        int uintCompare = UnsignedKt.uintCompare(m3527uintRemainderJ1ME1BU, m3527uintRemainderJ1ME1BU2);
        int m3273constructorimpl = UInt.m3273constructorimpl(m3527uintRemainderJ1ME1BU - m3527uintRemainderJ1ME1BU2);
        return uintCompare < 0 ? UInt.m3273constructorimpl(m3273constructorimpl + i3) : m3273constructorimpl;
    }

    /* renamed from: differenceModulo-sambcqE  reason: not valid java name */
    private static final long m4368differenceModulosambcqE(long j, long j2, long j3) {
        long m3529ulongRemaindereb3DHEI = UnsignedKt.m3529ulongRemaindereb3DHEI(j, j3);
        long m3529ulongRemaindereb3DHEI2 = UnsignedKt.m3529ulongRemaindereb3DHEI(j2, j3);
        int ulongCompare = UnsignedKt.ulongCompare(m3529ulongRemaindereb3DHEI, m3529ulongRemaindereb3DHEI2);
        long m3351constructorimpl = ULong.m3351constructorimpl(m3529ulongRemaindereb3DHEI - m3529ulongRemaindereb3DHEI2);
        return ulongCompare < 0 ? ULong.m3351constructorimpl(m3351constructorimpl + j3) : m3351constructorimpl;
    }

    /* renamed from: getProgressionLastElement-Nkh28Cs  reason: not valid java name */
    public static final int m4370getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            return UnsignedKt.uintCompare(i, i2) < 0 ? UInt.m3273constructorimpl(i2 - m4367differenceModuloWZ9TVnA(i2, i, UInt.m3273constructorimpl(i3))) : i2;
        } else if (i3 < 0) {
            return UnsignedKt.uintCompare(i, i2) > 0 ? UInt.m3273constructorimpl(i2 + m4367differenceModuloWZ9TVnA(i, i2, UInt.m3273constructorimpl(-i3))) : i2;
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    /* renamed from: getProgressionLastElement-7ftBX0g  reason: not valid java name */
    public static final long m4369getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        if (j3 > 0) {
            return UnsignedKt.ulongCompare(j, j2) < 0 ? ULong.m3351constructorimpl(j2 - m4368differenceModulosambcqE(j2, j, ULong.m3351constructorimpl(j3))) : j2;
        } else if (j3 < 0) {
            return UnsignedKt.ulongCompare(j, j2) > 0 ? ULong.m3351constructorimpl(j2 + m4368differenceModulosambcqE(j, j2, ULong.m3351constructorimpl(-j3))) : j2;
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}

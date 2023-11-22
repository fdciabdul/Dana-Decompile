package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/UByteArray;", "array", "", "left", "right", "partition-4UcCI2c", "([BII)I", "partition", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "", "quickSort-4UcCI2c", "([BII)V", "quickSort", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UArraySortingKt {
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    private static final int m3627partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m3254getw2LRezQ = UByteArray.m3254getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m3254getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m3254getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m3254getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m3254getw2LRezQ2 = UByteArray.m3254getw2LRezQ(bArr, i);
                UByteArray.m3259setVurrAj0(bArr, i, UByteArray.m3254getw2LRezQ(bArr, i2));
                UByteArray.m3259setVurrAj0(bArr, i2, m3254getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    private static final void m3631quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        while (true) {
            int m3627partition4UcCI2c = m3627partition4UcCI2c(bArr, i, i2);
            int i3 = m3627partition4UcCI2c - 1;
            if (i < i3) {
                m3631quickSort4UcCI2c(bArr, i, i3);
            }
            if (m3627partition4UcCI2c >= i2) {
                return;
            }
            i = m3627partition4UcCI2c;
        }
    }

    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    private static final int m3628partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m3514getMh2AYeg = UShortArray.m3514getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                short m3514getMh2AYeg2 = UShortArray.m3514getMh2AYeg(sArr, i);
                i3 = m3514getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m3514getMh2AYeg2 & UShort.MAX_VALUE, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m3514getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m3514getMh2AYeg3 = UShortArray.m3514getMh2AYeg(sArr, i);
                UShortArray.m3519set01HTLdE(sArr, i, UShortArray.m3514getMh2AYeg(sArr, i2));
                UShortArray.m3519set01HTLdE(sArr, i2, m3514getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    private static final void m3632quickSortAa5vz7o(short[] sArr, int i, int i2) {
        while (true) {
            int m3628partitionAa5vz7o = m3628partitionAa5vz7o(sArr, i, i2);
            int i3 = m3628partitionAa5vz7o - 1;
            if (i < i3) {
                m3632quickSortAa5vz7o(sArr, i, i3);
            }
            if (m3628partitionAa5vz7o >= i2) {
                return;
            }
            i = m3628partitionAa5vz7o;
        }
    }

    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    private static final int m3629partitionoBK06Vg(int[] iArr, int i, int i2) {
        int m3332getpVg5ArA = UIntArray.m3332getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.uintCompare(UIntArray.m3332getpVg5ArA(iArr, i), m3332getpVg5ArA) < 0) {
                i++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m3332getpVg5ArA(iArr, i2), m3332getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m3332getpVg5ArA2 = UIntArray.m3332getpVg5ArA(iArr, i);
                UIntArray.m3337setVXSXFK8(iArr, i, UIntArray.m3332getpVg5ArA(iArr, i2));
                UIntArray.m3337setVXSXFK8(iArr, i2, m3332getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    private static final void m3633quickSortoBK06Vg(int[] iArr, int i, int i2) {
        while (true) {
            int m3629partitionoBK06Vg = m3629partitionoBK06Vg(iArr, i, i2);
            int i3 = m3629partitionoBK06Vg - 1;
            if (i < i3) {
                m3633quickSortoBK06Vg(iArr, i, i3);
            }
            if (m3629partitionoBK06Vg >= i2) {
                return;
            }
            i = m3629partitionoBK06Vg;
        }
    }

    /* renamed from: partition--nroSd4  reason: not valid java name */
    private static final int m3626partitionnroSd4(long[] jArr, int i, int i2) {
        long m3410getsVKNKU = ULongArray.m3410getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.ulongCompare(ULongArray.m3410getsVKNKU(jArr, i), m3410getsVKNKU) < 0) {
                i++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m3410getsVKNKU(jArr, i2), m3410getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m3410getsVKNKU2 = ULongArray.m3410getsVKNKU(jArr, i);
                ULongArray.m3415setk8EXiF4(jArr, i, ULongArray.m3410getsVKNKU(jArr, i2));
                ULongArray.m3415setk8EXiF4(jArr, i2, m3410getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    private static final void m3630quickSortnroSd4(long[] jArr, int i, int i2) {
        while (true) {
            int m3626partitionnroSd4 = m3626partitionnroSd4(jArr, i, i2);
            int i3 = m3626partitionnroSd4 - 1;
            if (i < i3) {
                m3630quickSortnroSd4(jArr, i, i3);
            }
            if (m3626partitionnroSd4 >= i2) {
                return;
            }
            i = m3626partitionnroSd4;
        }
    }

    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m3635sortArray4UcCI2c(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "");
        m3631quickSort4UcCI2c(bArr, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m3636sortArrayAa5vz7o(short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "");
        m3632quickSortAa5vz7o(sArr, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m3637sortArrayoBK06Vg(int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "");
        m3633quickSortoBK06Vg(iArr, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m3634sortArraynroSd4(long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "");
        m3630quickSortnroSd4(jArr, i, i2 - 1);
    }
}

package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a \u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a$\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\n\u001a\u00020\t\"\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a \u0010\u0005\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a$\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\n\u0010\n\u001a\u00020\u0012\"\u00020\rø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a$\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\n\u0010\n\u001a\u00020\u001a\"\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a \u0010\u0005\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u0005\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0086\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a$\u0010\u0005\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\n\u0010\n\u001a\u00020\"\"\u00020\u001dø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a \u0010&\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0004\u001a+\u0010&\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b'\u0010\b\u001a$\u0010&\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\n\u001a\u00020\t\"\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b(\u0010\f\u001a \u0010&\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b)\u0010\u000f\u001a+\u0010&\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0086\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0011\u001a$\u0010&\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\n\u0010\n\u001a\u00020\u0012\"\u00020\rø\u0001\u0000¢\u0006\u0004\b+\u0010\u0014\u001a \u0010&\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0017\u001a+\u0010&\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0086\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0019\u001a$\u0010&\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\n\u0010\n\u001a\u00020\u001a\"\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b.\u0010\u001c\u001a \u0010&\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\b/\u0010\u001f\u001a+\u0010&\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0086\bø\u0001\u0000¢\u0006\u0004\b0\u0010!\u001a$\u0010&\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\n\u0010\n\u001a\u00020\"\"\u00020\u001dø\u0001\u0000¢\u0006\u0004\b1\u0010$\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "maxOf", "c", "maxOf-b33U2AM", "(BBB)B", "Lkotlin/UByteArray;", "other", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf-Kr8caGY", "minOf", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes9.dex */
public class UComparisonsKt___UComparisonsKt {
    /* renamed from: maxOf-J1ME1BU  reason: not valid java name */
    public static final int m4343maxOfJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) < 0 ? i2 : i;
    }

    /* renamed from: maxOf-eb3DHEI  reason: not valid java name */
    public static final long m4351maxOfeb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : j;
    }

    /* renamed from: maxOf-Kr8caGY  reason: not valid java name */
    public static final byte m4344maxOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) < 0 ? b2 : b;
    }

    /* renamed from: maxOf-5PvTz6A  reason: not valid java name */
    public static final short m4342maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0 ? s2 : s;
    }

    /* renamed from: maxOf-WZ9TVnA  reason: not valid java name */
    private static final int m4348maxOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m4343maxOfJ1ME1BU(i, UComparisonsKt.m4343maxOfJ1ME1BU(i2, i3));
    }

    /* renamed from: maxOf-sambcqE  reason: not valid java name */
    private static final long m4352maxOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m4351maxOfeb3DHEI(j, UComparisonsKt.m4351maxOfeb3DHEI(j2, j3));
    }

    /* renamed from: maxOf-b33U2AM  reason: not valid java name */
    private static final byte m4350maxOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m4344maxOfKr8caGY(b, UComparisonsKt.m4344maxOfKr8caGY(b2, b3));
    }

    /* renamed from: maxOf-VKSA0NQ  reason: not valid java name */
    private static final short m4347maxOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m4342maxOf5PvTz6A(s, UComparisonsKt.m4342maxOf5PvTz6A(s2, s3));
    }

    /* renamed from: maxOf-Md2H83M  reason: not valid java name */
    public static final int m4345maxOfMd2H83M(int i, int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "");
        int m3333getSizeimpl = UIntArray.m3333getSizeimpl(iArr);
        for (int i2 = 0; i2 < m3333getSizeimpl; i2++) {
            i = UComparisonsKt.m4343maxOfJ1ME1BU(i, UIntArray.m3332getpVg5ArA(iArr, i2));
        }
        return i;
    }

    /* renamed from: maxOf-R03FKyM  reason: not valid java name */
    public static final long m4346maxOfR03FKyM(long j, long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "");
        int m3411getSizeimpl = ULongArray.m3411getSizeimpl(jArr);
        for (int i = 0; i < m3411getSizeimpl; i++) {
            j = UComparisonsKt.m4351maxOfeb3DHEI(j, ULongArray.m3410getsVKNKU(jArr, i));
        }
        return j;
    }

    /* renamed from: maxOf-Wr6uiD8  reason: not valid java name */
    public static final byte m4349maxOfWr6uiD8(byte b, byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        int m3255getSizeimpl = UByteArray.m3255getSizeimpl(bArr);
        for (int i = 0; i < m3255getSizeimpl; i++) {
            b = UComparisonsKt.m4344maxOfKr8caGY(b, UByteArray.m3254getw2LRezQ(bArr, i));
        }
        return b;
    }

    /* renamed from: maxOf-t1qELG4  reason: not valid java name */
    public static final short m4353maxOft1qELG4(short s, short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "");
        int m3515getSizeimpl = UShortArray.m3515getSizeimpl(sArr);
        for (int i = 0; i < m3515getSizeimpl; i++) {
            s = UComparisonsKt.m4342maxOf5PvTz6A(s, UShortArray.m3514getMh2AYeg(sArr, i));
        }
        return s;
    }

    /* renamed from: minOf-J1ME1BU  reason: not valid java name */
    public static final int m4355minOfJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) > 0 ? i2 : i;
    }

    /* renamed from: minOf-eb3DHEI  reason: not valid java name */
    public static final long m4363minOfeb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) > 0 ? j2 : j;
    }

    /* renamed from: minOf-Kr8caGY  reason: not valid java name */
    public static final byte m4356minOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) > 0 ? b2 : b;
    }

    /* renamed from: minOf-5PvTz6A  reason: not valid java name */
    public static final short m4354minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0 ? s2 : s;
    }

    /* renamed from: minOf-WZ9TVnA  reason: not valid java name */
    private static final int m4360minOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m4355minOfJ1ME1BU(i, UComparisonsKt.m4355minOfJ1ME1BU(i2, i3));
    }

    /* renamed from: minOf-sambcqE  reason: not valid java name */
    private static final long m4364minOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m4363minOfeb3DHEI(j, UComparisonsKt.m4363minOfeb3DHEI(j2, j3));
    }

    /* renamed from: minOf-b33U2AM  reason: not valid java name */
    private static final byte m4362minOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m4356minOfKr8caGY(b, UComparisonsKt.m4356minOfKr8caGY(b2, b3));
    }

    /* renamed from: minOf-VKSA0NQ  reason: not valid java name */
    private static final short m4359minOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m4354minOf5PvTz6A(s, UComparisonsKt.m4354minOf5PvTz6A(s2, s3));
    }

    /* renamed from: minOf-Md2H83M  reason: not valid java name */
    public static final int m4357minOfMd2H83M(int i, int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "");
        int m3333getSizeimpl = UIntArray.m3333getSizeimpl(iArr);
        for (int i2 = 0; i2 < m3333getSizeimpl; i2++) {
            i = UComparisonsKt.m4355minOfJ1ME1BU(i, UIntArray.m3332getpVg5ArA(iArr, i2));
        }
        return i;
    }

    /* renamed from: minOf-R03FKyM  reason: not valid java name */
    public static final long m4358minOfR03FKyM(long j, long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "");
        int m3411getSizeimpl = ULongArray.m3411getSizeimpl(jArr);
        for (int i = 0; i < m3411getSizeimpl; i++) {
            j = UComparisonsKt.m4363minOfeb3DHEI(j, ULongArray.m3410getsVKNKU(jArr, i));
        }
        return j;
    }

    /* renamed from: minOf-Wr6uiD8  reason: not valid java name */
    public static final byte m4361minOfWr6uiD8(byte b, byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        int m3255getSizeimpl = UByteArray.m3255getSizeimpl(bArr);
        for (int i = 0; i < m3255getSizeimpl; i++) {
            b = UComparisonsKt.m4356minOfKr8caGY(b, UByteArray.m3254getw2LRezQ(bArr, i));
        }
        return b;
    }

    /* renamed from: minOf-t1qELG4  reason: not valid java name */
    public static final short m4365minOft1qELG4(short s, short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "");
        int m3515getSizeimpl = UShortArray.m3515getSizeimpl(sArr);
        for (int i = 0; i < m3515getSizeimpl; i++) {
            s = UComparisonsKt.m4354minOf5PvTz6A(s, UShortArray.m3514getMh2AYeg(sArr, i));
        }
        return s;
    }
}

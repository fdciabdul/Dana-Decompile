package kotlin.collections.unsigned;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a0\u0010\u0018\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a0\u0010\u0018\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a0\u0010\u0018\u001a\u00020\u0013*\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a0\u0010\u0018\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\"\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0013H\u0086\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0013H\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010\"\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0013H\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010\"\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0013H\u0086\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a+\u0010,\u001a\u00020**\u00020\u00002\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0)H\u0086\bø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a+\u0010/\u001a\u00020.*\u00020\u00002\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0)H\u0086\bø\u0001\u0001¢\u0006\u0004\b/\u00100\u001a+\u0010,\u001a\u00020**\u00020\u00062\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*0)H\u0086\bø\u0001\u0001¢\u0006\u0004\b,\u00101\u001a+\u0010/\u001a\u00020.*\u00020\u00062\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.0)H\u0086\bø\u0001\u0001¢\u0006\u0004\b/\u00102\u001a+\u0010,\u001a\u00020**\u00020\n2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020*0)H\u0086\bø\u0001\u0001¢\u0006\u0004\b,\u00103\u001a+\u0010/\u001a\u00020.*\u00020\n2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020.0)H\u0086\bø\u0001\u0001¢\u0006\u0004\b/\u00104\u001a+\u0010,\u001a\u00020**\u00020\u000e2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020*0)H\u0086\bø\u0001\u0001¢\u0006\u0004\b,\u00105\u001a+\u0010/\u001a\u00020.*\u00020\u000e2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020.0)H\u0086\bø\u0001\u0001¢\u0006\u0004\b/\u00106\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001"}, d2 = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "asList-GBYM_sE", "([B)Ljava/util/List;", "asList", "Lkotlin/UIntArray;", "Lkotlin/UInt;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "asList-rL5Bavg", "([S)Ljava/util/List;", LottieParams.KEY_ELEMENT_ID, "", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "index", "elementAt-PpDY95g", "([BI)B", "elementAt", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;"}, k = 5, mv = {1, 6, 0}, pn = "", xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
/* loaded from: classes2.dex */
public class UArraysKt___UArraysJvmKt {
    /* renamed from: elementAt-qFRl0hI */
    private static final int m3656elementAtqFRl0hI(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "");
        return UIntArray.m3332getpVg5ArA(iArr, i);
    }

    /* renamed from: elementAt-r7IrZao */
    private static final long m3657elementAtr7IrZao(long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "");
        return ULongArray.m3410getsVKNKU(jArr, i);
    }

    /* renamed from: elementAt-PpDY95g */
    private static final byte m3654elementAtPpDY95g(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "");
        return UByteArray.m3254getw2LRezQ(bArr, i);
    }

    /* renamed from: elementAt-nggk6HY */
    private static final short m3655elementAtnggk6HY(short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "");
        return UShortArray.m3514getMh2AYeg(sArr, i);
    }

    /* renamed from: asList--ajY-9A */
    public static final List<UInt> m3642asListajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "");
        return new UArraysKt___UArraysJvmKt$asList$1(iArr);
    }

    /* renamed from: asList-QwZRm1k */
    public static final List<ULong> m3644asListQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "");
        return new UArraysKt___UArraysJvmKt$asList$2(jArr);
    }

    /* renamed from: asList-GBYM_sE */
    public static final List<UByte> m3643asListGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        return new UArraysKt___UArraysJvmKt$asList$3(bArr);
    }

    /* renamed from: asList-rL5Bavg */
    public static final List<UShort> m3645asListrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "");
        return new UArraysKt___UArraysJvmKt$asList$4(sArr);
    }

    /* renamed from: binarySearch-2fe2U9s$default */
    public static /* synthetic */ int m3647binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m3333getSizeimpl(iArr);
        }
        return UArraysKt.m3646binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    /* renamed from: binarySearch-2fe2U9s */
    public static final int m3646binarySearch2fe2U9s(int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i2, i3, UIntArray.m3333getSizeimpl(iArr));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(iArr[i5], i);
            if (uintCompare < 0) {
                i2 = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default */
    public static /* synthetic */ int m3651binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m3411getSizeimpl(jArr);
        }
        return UArraysKt.m3650binarySearchK6DWlUc(jArr, j, i, i2);
    }

    /* renamed from: binarySearch-K6DWlUc */
    public static final int m3650binarySearchK6DWlUc(long[] jArr, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m3411getSizeimpl(jArr));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int ulongCompare = UnsignedKt.ulongCompare(jArr[i4], j);
            if (ulongCompare < 0) {
                i = i4 + 1;
            } else if (ulongCompare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default */
    public static /* synthetic */ int m3653binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m3255getSizeimpl(bArr);
        }
        return UArraysKt.m3652binarySearchWpHrYlw(bArr, b, i, i2);
    }

    /* renamed from: binarySearch-WpHrYlw */
    public static final int m3652binarySearchWpHrYlw(byte[] bArr, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m3255getSizeimpl(bArr));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(bArr[i4], b & 255);
            if (uintCompare < 0) {
                i = i4 + 1;
            } else if (uintCompare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default */
    public static /* synthetic */ int m3649binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m3515getSizeimpl(sArr);
        }
        return UArraysKt.m3648binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    /* renamed from: binarySearch-EtDCXyQ */
    public static final int m3648binarySearchEtDCXyQ(short[] sArr, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m3515getSizeimpl(sArr));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(sArr[i4], 65535 & s);
            if (uintCompare < 0) {
                i = i4 + 1;
            } else if (uintCompare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    private static final BigDecimal sumOfBigDecimal(int[] iArr, Function1<? super UInt, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(iArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        int m3333getSizeimpl = UIntArray.m3333getSizeimpl(iArr);
        for (int i = 0; i < m3333getSizeimpl; i++) {
            valueOf = valueOf.add(function1.invoke(UInt.m3267boximpl(UIntArray.m3332getpVg5ArA(iArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(long[] jArr, Function1<? super ULong, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(jArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        int m3411getSizeimpl = ULongArray.m3411getSizeimpl(jArr);
        for (int i = 0; i < m3411getSizeimpl; i++) {
            valueOf = valueOf.add(function1.invoke(ULong.m3345boximpl(ULongArray.m3410getsVKNKU(jArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(byte[] bArr, Function1<? super UByte, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        int m3255getSizeimpl = UByteArray.m3255getSizeimpl(bArr);
        for (int i = 0; i < m3255getSizeimpl; i++) {
            valueOf = valueOf.add(function1.invoke(UByte.m3191boximpl(UByteArray.m3254getw2LRezQ(bArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(short[] sArr, Function1<? super UShort, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(sArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        int m3515getSizeimpl = UShortArray.m3515getSizeimpl(sArr);
        for (int i = 0; i < m3515getSizeimpl; i++) {
            valueOf = valueOf.add(function1.invoke(UShort.m3451boximpl(UShortArray.m3514getMh2AYeg(sArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(int[] iArr, Function1<? super UInt, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(iArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        int m3333getSizeimpl = UIntArray.m3333getSizeimpl(iArr);
        for (int i = 0; i < m3333getSizeimpl; i++) {
            valueOf = valueOf.add(function1.invoke(UInt.m3267boximpl(UIntArray.m3332getpVg5ArA(iArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(long[] jArr, Function1<? super ULong, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(jArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        int m3411getSizeimpl = ULongArray.m3411getSizeimpl(jArr);
        for (int i = 0; i < m3411getSizeimpl; i++) {
            valueOf = valueOf.add(function1.invoke(ULong.m3345boximpl(ULongArray.m3410getsVKNKU(jArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(byte[] bArr, Function1<? super UByte, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        int m3255getSizeimpl = UByteArray.m3255getSizeimpl(bArr);
        for (int i = 0; i < m3255getSizeimpl; i++) {
            valueOf = valueOf.add(function1.invoke(UByte.m3191boximpl(UByteArray.m3254getw2LRezQ(bArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(short[] sArr, Function1<? super UShort, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(sArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        int m3515getSizeimpl = UShortArray.m3515getSizeimpl(sArr);
        for (int i = 0; i < m3515getSizeimpl; i++) {
            valueOf = valueOf.add(function1.invoke(UShort.m3451boximpl(UShortArray.m3514getMh2AYeg(sArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }
}

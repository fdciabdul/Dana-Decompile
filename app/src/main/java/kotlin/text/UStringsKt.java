package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0000*\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0010\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0000*\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0007*\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001c\u0010\u0016\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0018\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u0007*\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0007*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u00020\n*\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001c\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\n*\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010\u001f\u001a\u0004\u0018\u00010\n*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010!\u001a\u0014\u0010\"\u001a\u00020\r*\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010\"\u001a\u00020\r*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010$\u001a\u0016\u0010%\u001a\u0004\u0018\u00010\r*\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001e\u0010%\u001a\u0004\u0018\u00010\r*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010'\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/UByte;", "", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "toString", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "(Ljava/lang/String;)Lkotlin/UByte;", "(Ljava/lang/String;I)Lkotlin/UByte;", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "(Ljava/lang/String;)Lkotlin/UInt;", "(Ljava/lang/String;I)Lkotlin/UInt;", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "(Ljava/lang/String;)Lkotlin/ULong;", "(Ljava/lang/String;I)Lkotlin/ULong;", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "(Ljava/lang/String;)Lkotlin/UShort;", "(Ljava/lang/String;I)Lkotlin/UShort;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class UStringsKt {
    /* renamed from: toString-LxnNnR4  reason: not valid java name */
    public static final String m4480toStringLxnNnR4(byte b, int i) {
        String num = Integer.toString(b & 255, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(num, "");
        return num;
    }

    /* renamed from: toString-olVBNx4  reason: not valid java name */
    public static final String m4482toStringolVBNx4(short s, int i) {
        String num = Integer.toString(s & UShort.MAX_VALUE, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(num, "");
        return num;
    }

    /* renamed from: toString-V7xB4Y4  reason: not valid java name */
    public static final String m4481toStringV7xB4Y4(int i, int i2) {
        String l = Long.toString(i & 4294967295L, CharsKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(l, "");
        return l;
    }

    /* renamed from: toString-JSWoG40  reason: not valid java name */
    public static final String m4479toStringJSWoG40(long j, int i) {
        return UnsignedKt.ulongToString(j, CharsKt.checkRadix(i));
    }

    public static final byte toUByte(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        UByte uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final byte toUByte(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        UByte uByteOrNull = toUByteOrNull(str, i);
        if (uByteOrNull != null) {
            return uByteOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final short toUShort(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        UShort uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final short toUShort(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        UShort uShortOrNull = toUShortOrNull(str, i);
        if (uShortOrNull != null) {
            return uShortOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final int toUInt(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final int toUInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final long toULong(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        ULong uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final long toULong(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        ULong uLongOrNull = toULongOrNull(str, i);
        if (uLongOrNull != null) {
            return uLongOrNull.getData();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final UByte toUByteOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return toUByteOrNull(str, 10);
    }

    public static final UByte toUByteOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull != null) {
            int data = uIntOrNull.getData();
            if (UnsignedKt.uintCompare(data, UInt.m3273constructorimpl(255)) > 0) {
                return null;
            }
            return UByte.m3191boximpl(UByte.m3197constructorimpl((byte) data));
        }
        return null;
    }

    public static final UShort toUShortOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return toUShortOrNull(str, 10);
    }

    public static final UShort toUShortOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull != null) {
            int data = uIntOrNull.getData();
            if (UnsignedKt.uintCompare(data, UInt.m3273constructorimpl(65535)) > 0) {
                return null;
            }
            return UShort.m3451boximpl(UShort.m3457constructorimpl((short) data));
        }
        return null;
    }

    public static final UInt toUIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return toUIntOrNull(str, 10);
    }

    public static final UInt toUIntOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        int i3 = 1;
        if (Intrinsics.compare((int) charAt, 48) >= 0) {
            i3 = 0;
        } else if (length == 1 || charAt != '+') {
            return null;
        }
        int m3273constructorimpl = UInt.m3273constructorimpl(i);
        int i4 = 119304647;
        while (i3 < length) {
            int digitOf = CharsKt.digitOf(str.charAt(i3), i);
            if (digitOf < 0) {
                return null;
            }
            if (UnsignedKt.uintCompare(i2, i4) > 0) {
                if (i4 == 119304647) {
                    i4 = UnsignedKt.m3526uintDivideJ1ME1BU(-1, m3273constructorimpl);
                    if (UnsignedKt.uintCompare(i2, i4) > 0) {
                    }
                }
                return null;
            }
            int m3273constructorimpl2 = UInt.m3273constructorimpl(i2 * m3273constructorimpl);
            int m3273constructorimpl3 = UInt.m3273constructorimpl(UInt.m3273constructorimpl(digitOf) + m3273constructorimpl2);
            if (UnsignedKt.uintCompare(m3273constructorimpl3, m3273constructorimpl2) < 0) {
                return null;
            }
            i3++;
            i2 = m3273constructorimpl3;
        }
        return UInt.m3267boximpl(i2);
    }

    public static final ULong toULongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return toULongOrNull(str, 10);
    }

    public static final ULong toULongOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i2 = 1;
        }
        long m3351constructorimpl = ULong.m3351constructorimpl(i);
        long j = 0;
        long j2 = 512409557603043100L;
        while (i2 < length) {
            if (CharsKt.digitOf(str.charAt(i2), i) < 0) {
                return null;
            }
            if (UnsignedKt.ulongCompare(j, j2) > 0) {
                if (j2 == 512409557603043100L) {
                    j2 = UnsignedKt.m3528ulongDivideeb3DHEI(-1L, m3351constructorimpl);
                    if (UnsignedKt.ulongCompare(j, j2) > 0) {
                    }
                }
                return null;
            }
            long m3351constructorimpl2 = ULong.m3351constructorimpl(j * m3351constructorimpl);
            long m3351constructorimpl3 = ULong.m3351constructorimpl(ULong.m3351constructorimpl(UInt.m3273constructorimpl(r13) & 4294967295L) + m3351constructorimpl2);
            if (UnsignedKt.ulongCompare(m3351constructorimpl3, m3351constructorimpl2) < 0) {
                return null;
            }
            i2++;
            j = m3351constructorimpl3;
        }
        return ULong.m3345boximpl(j);
    }
}

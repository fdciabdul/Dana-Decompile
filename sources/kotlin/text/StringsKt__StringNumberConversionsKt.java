package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\n\u001a\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\r\u001a\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0015"}, d2 = {"", "input", "", "numberFormatError", "(Ljava/lang/String;)Ljava/lang/Void;", "", "toByteOrNull", "(Ljava/lang/String;)Ljava/lang/Byte;", "", "radix", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "", "toLongOrNull", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "", "toShortOrNull", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static final Byte toByteOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.toByteOrNull(str, 10);
    }

    public static final Byte toByteOrNull(String str, int i) {
        int intValue;
        Intrinsics.checkNotNullParameter(str, "");
        Integer intOrNull = StringsKt.toIntOrNull(str, i);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    public static final Short toShortOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.toShortOrNull(str, 10);
    }

    public static final Short toShortOrNull(String str, int i) {
        int intValue;
        Intrinsics.checkNotNullParameter(str, "");
        Integer intOrNull = StringsKt.toIntOrNull(str, i);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }

    public static final Integer toIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.toIntOrNull(str, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Integer toIntOrNull(java.lang.String r10, int r11) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.text.CharsKt.checkRadix(r11)
            int r0 = r10.length()
            r1 = 0
            if (r0 != 0) goto L10
            return r1
        L10:
            r2 = 0
            char r3 = r10.charAt(r2)
            r4 = 48
            int r4 = kotlin.jvm.internal.Intrinsics.compare(r3, r4)
            r5 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            r6 = 1
            if (r4 >= 0) goto L33
            if (r0 != r6) goto L24
            return r1
        L24:
            r4 = 45
            if (r3 != r4) goto L2c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1
            goto L35
        L2c:
            r4 = 43
            if (r3 != r4) goto L32
            r3 = 1
            goto L34
        L32:
            return r1
        L33:
            r3 = 0
        L34:
            r6 = 0
        L35:
            r4 = -59652323(0xfffffffffc71c71d, float:-5.0215282E36)
            r7 = -59652323(0xfffffffffc71c71d, float:-5.0215282E36)
        L3b:
            if (r3 >= r0) goto L5c
            char r8 = r10.charAt(r3)
            int r8 = kotlin.text.CharsKt.digitOf(r8, r11)
            if (r8 >= 0) goto L48
            return r1
        L48:
            if (r2 >= r7) goto L51
            if (r7 != r4) goto L50
            int r7 = r5 / r11
            if (r2 >= r7) goto L51
        L50:
            return r1
        L51:
            int r2 = r2 * r11
            int r9 = r5 + r8
            if (r2 >= r9) goto L58
            return r1
        L58:
            int r2 = r2 - r8
            int r3 = r3 + 1
            goto L3b
        L5c:
            if (r6 == 0) goto L63
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
            goto L68
        L63:
            int r10 = -r2
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
        L68:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(java.lang.String, int):java.lang.Integer");
    }

    public static final Long toLongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.toLongOrNull(str, 10);
    }

    public static final Long toLongOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        boolean z = false;
        char charAt = str.charAt(0);
        long j = -9223372036854775807L;
        int i2 = 1;
        if (Intrinsics.compare((int) charAt, 48) >= 0) {
            i2 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                j = Long.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            }
        }
        long j2 = 0;
        long j3 = -256204778801521550L;
        long j4 = -256204778801521550L;
        while (i2 < length) {
            int digitOf = CharsKt.digitOf(str.charAt(i2), i);
            if (digitOf < 0) {
                return null;
            }
            if (j2 < j4) {
                if (j4 == j3) {
                    j4 = j / i;
                    if (j2 < j4) {
                    }
                }
                return null;
            }
            long j5 = j2 * i;
            long j6 = digitOf;
            if (j5 < j + j6) {
                return null;
            }
            j2 = j5 - j6;
            i2++;
            j3 = -256204778801521550L;
        }
        return z ? Long.valueOf(j2) : Long.valueOf(-j2);
    }

    public static final Void numberFormatError(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid number format: '");
        sb.append(str);
        sb.append('\'');
        throw new NumberFormatException(sb.toString());
    }
}

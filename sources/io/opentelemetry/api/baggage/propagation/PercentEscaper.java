package io.opentelemetry.api.baggage.propagation;

import io.opentelemetry.api.internal.TemporaryBuffers;
import javax.annotation.CheckForNull;

/* loaded from: classes9.dex */
final class PercentEscaper {
    private static final int DEST_PAD = 32;
    private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private static final String SAFE_CHARS = "-._~!$'()*&@:abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final boolean[] safeOctets = createSafeOctets(SAFE_CHARS);

    PercentEscaper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PercentEscaper create() {
        return new PercentEscaper();
    }

    private static boolean[] createSafeOctets(String str) {
        char[] charArray = str.toCharArray();
        int i = -1;
        for (char c : charArray) {
            i = Math.max((int) c, i);
        }
        boolean[] zArr = new boolean[i + 1];
        for (char c2 : charArray) {
            zArr[c2] = true;
        }
        return zArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String escape(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            boolean[] zArr = safeOctets;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    private static String escapeSlow(String str, int i) {
        int length = str.length();
        char[] chars = TemporaryBuffers.chars(1024);
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int codePointAt = codePointAt(str, i, length);
            if (codePointAt < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] escape = escape(codePointAt);
            int i4 = (Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1) + i;
            if (escape != null) {
                int i5 = i - i2;
                int i6 = i3 + i5;
                int length2 = escape.length + i6;
                if (chars.length < length2) {
                    chars = growBuffer(chars, i3, length2 + (length - i) + 32);
                }
                if (i5 > 0) {
                    str.getChars(i2, i, chars, i3);
                    i3 = i6;
                }
                if (escape.length > 0) {
                    System.arraycopy(escape, 0, chars, i3, escape.length);
                    i3 += escape.length;
                }
                i2 = i4;
            }
            i = nextEscapeIndex(str, i4, length);
        }
        int i7 = length - i2;
        if (i7 > 0) {
            int i8 = i7 + i3;
            if (chars.length < i8) {
                chars = growBuffer(chars, i3, i8);
            }
            str.getChars(i2, length, chars, i3);
            i3 = i8;
        }
        return new String(chars, 0, i3);
    }

    private static int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            boolean[] zArr = safeOctets;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i++;
        }
        return i;
    }

    @CheckForNull
    private static char[] escape(int i) {
        boolean[] zArr = safeOctets;
        if (i >= zArr.length || !zArr[i]) {
            if (i <= 127) {
                char[] cArr = UPPER_HEX_DIGITS;
                return new char[]{'%', cArr[i >>> 4], cArr[i & 15]};
            } else if (i <= 2047) {
                char[] cArr2 = UPPER_HEX_DIGITS;
                char[] cArr3 = {'%', cArr2[(r13 >>> 4) | 12], cArr2[r13 & 15], '%', cArr2[(r13 & 3) | 8], cArr2[i & 15]};
                int i2 = i >>> 4;
                int i3 = i2 >>> 2;
                return cArr3;
            } else if (i <= 65535) {
                char[] cArr4 = UPPER_HEX_DIGITS;
                char[] cArr5 = {'%', 'E', cArr4[r13 >>> 2], '%', cArr4[(r13 & 3) | 8], cArr4[r13 & 15], '%', cArr4[(r13 & 3) | 8], cArr4[i & 15]};
                int i4 = i >>> 4;
                int i5 = i4 >>> 2;
                int i6 = i5 >>> 4;
                return cArr5;
            } else if (i <= 1114111) {
                char[] cArr6 = UPPER_HEX_DIGITS;
                char[] cArr7 = {'%', 'F', cArr6[(r13 >>> 2) & 7], '%', cArr6[(r13 & 3) | 8], cArr6[r13 & 15], '%', cArr6[(r13 & 3) | 8], cArr6[r13 & 15], '%', cArr6[(r13 & 3) | 8], cArr6[i & 15]};
                int i7 = i >>> 4;
                int i8 = i7 >>> 2;
                int i9 = i8 >>> 4;
                int i10 = i9 >>> 2;
                int i11 = i10 >>> 4;
                return cArr7;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid unicode character value ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return null;
    }

    private static int codePointAt(CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            int i3 = i + 1;
            char charAt = charSequence.charAt(i);
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected low surrogate character '");
                sb.append(charAt);
                sb.append("' with value ");
                sb.append((int) charAt);
                sb.append(" at index ");
                sb.append(i3 - 1);
                sb.append(" in '");
                sb.append((Object) charSequence);
                sb.append("'");
                throw new IllegalArgumentException(sb.toString());
            } else if (i3 == i2) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i3);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Expected low surrogate but got char '");
                sb2.append(charAt2);
                sb2.append("' with value ");
                sb2.append((int) charAt2);
                sb2.append(" at index ");
                sb2.append(i3);
                sb2.append(" in '");
                sb2.append((Object) charSequence);
                sb2.append("'");
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static char[] growBuffer(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }
}

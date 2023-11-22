package io.opentelemetry.api.internal;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class OtelEncodingUtils {
    private static final String ALPHABET = "0123456789abcdef";
    static final int BYTE_BASE16 = 2;
    static final int LONG_BASE16 = 16;
    static final int LONG_BYTES = 8;
    private static final int NUM_ASCII_CHARACTERS = 128;
    private static final char[] ENCODING = buildEncodingArray();
    private static final byte[] DECODING = buildDecodingArray();
    private static final boolean[] VALID_HEX = buildValidHexArray();

    private static char[] buildEncodingArray() {
        char[] cArr = new char[512];
        for (int i = 0; i < 256; i++) {
            cArr[i] = ALPHABET.charAt(i >>> 4);
            cArr[i | 256] = ALPHABET.charAt(i & 15);
        }
        return cArr;
    }

    private static byte[] buildDecodingArray() {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i = 0; i < 16; i++) {
            bArr[ALPHABET.charAt(i)] = (byte) i;
        }
        return bArr;
    }

    private static boolean[] buildValidHexArray() {
        boolean[] zArr = new boolean[65535];
        int i = 0;
        while (i < 65535) {
            zArr[i] = (48 <= i && i <= 57) || (97 <= i && i <= 102);
            i++;
        }
        return zArr;
    }

    public static long longFromBase16String(CharSequence charSequence, int i) {
        return ((byteFromBase16(charSequence.charAt(i), charSequence.charAt(i + 1)) & 255) << 56) | ((byteFromBase16(charSequence.charAt(i + 2), charSequence.charAt(i + 3)) & 255) << 48) | ((byteFromBase16(charSequence.charAt(i + 4), charSequence.charAt(i + 5)) & 255) << 40) | ((byteFromBase16(charSequence.charAt(i + 6), charSequence.charAt(i + 7)) & 255) << 32) | ((byteFromBase16(charSequence.charAt(i + 8), charSequence.charAt(i + 9)) & 255) << 24) | ((byteFromBase16(charSequence.charAt(i + 10), charSequence.charAt(i + 11)) & 255) << 16) | ((byteFromBase16(charSequence.charAt(i + 12), charSequence.charAt(i + 13)) & 255) << 8) | (byteFromBase16(charSequence.charAt(i + 14), charSequence.charAt(i + 15)) & 255);
    }

    public static void longToBase16String(long j, char[] cArr, int i) {
        byteToBase16((byte) ((j >> 56) & 255), cArr, i);
        byteToBase16((byte) ((j >> 48) & 255), cArr, i + 2);
        byteToBase16((byte) ((j >> 40) & 255), cArr, i + 4);
        byteToBase16((byte) ((j >> 32) & 255), cArr, i + 6);
        byteToBase16((byte) ((j >> 24) & 255), cArr, i + 8);
        byteToBase16((byte) ((j >> 16) & 255), cArr, i + 10);
        byteToBase16((byte) ((j >> 8) & 255), cArr, i + 12);
        byteToBase16((byte) (j & 255), cArr, i + 14);
    }

    public static byte[] bytesFromBase16(CharSequence charSequence, int i) {
        byte[] bArr = new byte[i / 2];
        for (int i2 = 0; i2 < i; i2 += 2) {
            bArr[i2 / 2] = byteFromBase16(charSequence.charAt(i2), charSequence.charAt(i2 + 1));
        }
        return bArr;
    }

    public static void bytesToBase16(byte[] bArr, char[] cArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            byteToBase16(bArr[i2], cArr, i2 * 2);
        }
    }

    public static void byteToBase16(byte b, char[] cArr, int i) {
        int i2 = b & 255;
        char[] cArr2 = ENCODING;
        cArr[i] = cArr2[i2];
        cArr[i + 1] = cArr2[i2 | 256];
    }

    public static byte byteFromBase16(char c, char c2) {
        byte[] bArr;
        byte b;
        byte b2;
        if (c >= 128 || (b = (bArr = DECODING)[c]) == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("invalid character ");
            sb.append(c);
            throw new IllegalArgumentException(sb.toString());
        } else if (c2 >= 128 || (b2 = bArr[c2]) == -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("invalid character ");
            sb2.append(c2);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            return (byte) (b2 | (b << 4));
        }
    }

    public static boolean isValidBase16String(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!isValidBase16Character(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBase16Character(char c) {
        return VALID_HEX[c];
    }

    private OtelEncodingUtils() {
    }
}

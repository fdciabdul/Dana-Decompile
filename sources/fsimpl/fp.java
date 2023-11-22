package fsimpl;

import com.google.common.base.Ascii;

/* loaded from: classes.dex */
class fp {
    private static char a(int i) {
        return (char) ((i >>> 10) + 55232);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (d(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || d(b3) || d(b4)) {
            throw new IllegalArgumentException("Invalid UTF-8");
        }
        int e = ((b & 7) << 18) | (e(b2) << 12) | (e(b3) << 6) | e(b4);
        cArr[i] = a(e);
        cArr[i + 1] = b(e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (d(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || d(b3)))) {
            throw new IllegalArgumentException("Invalid UTF-8");
        }
        cArr[i] = (char) (((b & 15) << 12) | (e(b2) << 6) | e(b3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte b, byte b2, char[] cArr, int i) {
        if (b < -62) {
            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
        }
        if (d(b2)) {
            throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
        }
        cArr[i] = (char) (((b & Ascii.US) << 6) | e(b2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(byte b) {
        return b >= 0;
    }

    private static char b(int i) {
        return (char) ((i & 1023) + 56320);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(byte b) {
        return b < -32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(byte b) {
        return b < -16;
    }

    private static boolean d(byte b) {
        return b > -65;
    }

    private static int e(byte b) {
        return b & 63;
    }
}

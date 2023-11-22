package androidx.emoji2.text.flatbuffer;

import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
public abstract class Utf8 {
    private static Utf8 BuiltInFictitiousFunctionClassFactory;

    public static Utf8 getAuthRequestContext() {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new Utf8Safe();
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class DecodeUtil {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean KClassImpl$Data$declaredNonStaticMembers$2(byte b) {
            return b >= 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean MyBillsEntityDataFactory(byte b) {
            return b < -16;
        }

        private static char PlaceComponentResult(int i) {
            return (char) ((i & 1023) + 56320);
        }

        private static boolean PlaceComponentResult(byte b) {
            return b > -65;
        }

        private static char getAuthRequestContext(int i) {
            return (char) ((i >>> 10) + 55232);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean getAuthRequestContext(byte b) {
            return b < -32;
        }

        DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void PlaceComponentResult(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void BuiltInFictitiousFunctionClassFactory(byte b, byte b2, char[] cArr, int i) throws IllegalArgumentException {
            if (b < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            }
            if (PlaceComponentResult(b2)) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            cArr[i] = (char) (((b & Ascii.US) << 6) | (b2 & 63));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void getAuthRequestContext(byte b, byte b2, byte b3, char[] cArr, int i) throws IllegalArgumentException {
            if (PlaceComponentResult(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || PlaceComponentResult(b3)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void PlaceComponentResult(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws IllegalArgumentException {
            if (PlaceComponentResult(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || PlaceComponentResult(b3) || PlaceComponentResult(b4)) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            int i2 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
            cArr[i] = getAuthRequestContext(i2);
            cArr[i + 1] = PlaceComponentResult(i2);
        }
    }

    /* loaded from: classes6.dex */
    static class UnpairedSurrogateException extends IllegalArgumentException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        UnpairedSurrogateException(int r3, int r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unpaired surrogate at index "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = " of "
                r0.append(r3)
                r0.append(r4)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.flatbuffer.Utf8.UnpairedSurrogateException.<init>(int, int):void");
        }
    }
}

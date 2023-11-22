package com.xiaomi.push;

/* loaded from: classes8.dex */
public class aa {
    private static byte[] PlaceComponentResult;
    private static final String getAuthRequestContext = System.getProperty("line.separator");
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = new char[64];

    static {
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            KClassImpl$Data$declaredNonStaticMembers$2[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            KClassImpl$Data$declaredNonStaticMembers$2[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            KClassImpl$Data$declaredNonStaticMembers$2[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char[] cArr = KClassImpl$Data$declaredNonStaticMembers$2;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        PlaceComponentResult = new byte[128];
        int i2 = 0;
        while (true) {
            byte[] bArr = PlaceComponentResult;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            PlaceComponentResult[KClassImpl$Data$declaredNonStaticMembers$2[i3]] = (byte) i3;
        }
    }

    public static byte[] BuiltInFictitiousFunctionClassFactory(String str) {
        return BuiltInFictitiousFunctionClassFactory(str.toCharArray());
    }

    private static byte[] BuiltInFictitiousFunctionClassFactory(char[] cArr) {
        return MyBillsEntityDataFactory(cArr, 0, cArr.length);
    }

    private static byte[] MyBillsEntityDataFactory(char[] cArr, int i, int i2) {
        char c;
        if (i2 % 4 == 0) {
            while (i2 > 0 && cArr[(i2 + 0) - 1] == '=') {
                i2--;
            }
            int i3 = (i2 * 3) / 4;
            byte[] bArr = new byte[i3];
            int i4 = 0;
            int i5 = i2 + 0;
            while (i < i5) {
                int i6 = i + 1;
                char c2 = cArr[i];
                int i7 = i6 + 1;
                char c3 = cArr[i6];
                char c4 = 'A';
                if (i7 < i5) {
                    c = cArr[i7];
                    i7++;
                } else {
                    c = 'A';
                }
                if (i7 < i5) {
                    c4 = cArr[i7];
                    i7++;
                }
                if (c2 > 127 || c3 > 127 || c > 127 || c4 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = PlaceComponentResult;
                byte b = bArr2[c2];
                byte b2 = bArr2[c3];
                byte b3 = bArr2[c];
                byte b4 = bArr2[c4];
                if (b < 0 || b2 < 0 || b3 < 0 || b4 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i8 = i4 + 1;
                bArr[i4] = (byte) ((b << 2) | (b2 >>> 4));
                if (i8 < i3) {
                    bArr[i8] = (byte) (((b2 & 15) << 4) | (b3 >>> 2));
                    i8++;
                }
                if (i8 < i3) {
                    bArr[i8] = (byte) (((b3 & 3) << 6) | b4);
                    i8++;
                }
                i4 = i8;
                i = i7;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static char[] MyBillsEntityDataFactory(byte[] bArr) {
        return PlaceComponentResult(bArr, 0, bArr.length);
    }

    private static char[] PlaceComponentResult(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[((i2 + 2) / 3) * 4];
        int i6 = i2 + 0;
        int i7 = 0;
        while (i < i6) {
            int i8 = i + 1;
            int i9 = bArr[i] & 255;
            if (i8 < i6) {
                i3 = bArr[i8] & 255;
                i8++;
            } else {
                i3 = 0;
            }
            if (i8 < i6) {
                i4 = bArr[i8] & 255;
                i8++;
            } else {
                i4 = 0;
            }
            int i10 = i7 + 1;
            char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
            cArr[i7] = cArr2[i9 >>> 2];
            int i11 = i10 + 1;
            cArr[i10] = cArr2[((i9 & 3) << 4) | (i3 >>> 4)];
            char c = '=';
            cArr[i11] = i11 < i5 ? cArr2[((i3 & 15) << 2) | (i4 >>> 6)] : '=';
            int i12 = i11 + 1;
            if (i12 < i5) {
                c = cArr2[i4 & 63];
            }
            cArr[i12] = c;
            i7 = i12 + 1;
            i = i8;
        }
        return cArr;
    }

    public static String getAuthRequestContext(String str) {
        return new String(BuiltInFictitiousFunctionClassFactory(str));
    }
}

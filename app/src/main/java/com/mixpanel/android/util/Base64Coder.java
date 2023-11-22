package com.mixpanel.android.util;

/* loaded from: classes.dex */
public class Base64Coder {
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = new char[64];
    private static byte[] PlaceComponentResult;

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

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        return new String(KClassImpl$Data$declaredNonStaticMembers$2(str.getBytes()));
    }

    private static char[] KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        return PlaceComponentResult(bArr, bArr.length);
    }

    private static char[] PlaceComponentResult(byte[] bArr, int i) {
        int i2;
        int i3;
        int i4 = ((i * 4) + 2) / 3;
        char[] cArr = new char[((i + 2) / 3) * 4];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i) {
            int i7 = i5 + 1;
            int i8 = bArr[i5] & 255;
            if (i7 < i) {
                i2 = bArr[i7] & 255;
                i7++;
            } else {
                i2 = 0;
            }
            if (i7 < i) {
                i3 = bArr[i7] & 255;
                i7++;
            } else {
                i3 = 0;
            }
            int i9 = i6 + 1;
            char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
            cArr[i6] = cArr2[i8 >>> 2];
            int i10 = i9 + 1;
            cArr[i9] = cArr2[((i8 & 3) << 4) | (i2 >>> 4)];
            char c = '=';
            cArr[i10] = i10 < i4 ? cArr2[((i2 & 15) << 2) | (i3 >>> 6)] : '=';
            int i11 = i10 + 1;
            if (i11 < i4) {
                c = cArr2[i3 & 63];
            }
            cArr[i11] = c;
            i6 = i11 + 1;
            i5 = i7;
        }
        return cArr;
    }
}

package org.yaml.snakeyaml.external.biz.base64Coder;

/* loaded from: classes6.dex */
public class Base64Coder {
    private static final byte[] BuiltInFictitiousFunctionClassFactory;
    private static final String MyBillsEntityDataFactory = System.getProperty("line.separator");
    private static final char[] getAuthRequestContext = new char[64];

    static {
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            getAuthRequestContext[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            getAuthRequestContext[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            getAuthRequestContext[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char[] cArr = getAuthRequestContext;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        BuiltInFictitiousFunctionClassFactory = new byte[128];
        int i2 = 0;
        while (true) {
            byte[] bArr = BuiltInFictitiousFunctionClassFactory;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            BuiltInFictitiousFunctionClassFactory[getAuthRequestContext[i3]] = (byte) i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] getAuthRequestContext(char[] cArr, int i, int i2) {
        char c;
        if (i2 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
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
            byte[] bArr2 = BuiltInFictitiousFunctionClassFactory;
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

    private Base64Coder() {
    }
}

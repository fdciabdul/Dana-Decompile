package com.alibaba.griver.base.common.constants;

import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes6.dex */
public class SecurityConstants {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = null;
    public static final String DEFAULT_AUTH_CODE = "0a6a";
    public static final String DEFAULT_CHARSET;
    private static int PlaceComponentResult = 0;
    public static final String SG_CLASS = "com.alibaba.wireless.security.open.SecurityGuardManager";
    private static int getAuthRequestContext = 1;

    static {
        getAuthRequestContext();
        Object[] objArr = new Object[1];
        a(new int[]{0, 5, 0, 1}, true, new byte[]{1, 1, 1, 1, 0}, objArr);
        DEFAULT_CHARSET = ((String) objArr[0]).intern();
        int i = getAuthRequestContext + 117;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    static void getAuthRequestContext() {
        BuiltInFictitiousFunctionClassFactory = new char[]{35508, 35544, 35500, 35495, 35539};
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        try {
            char[] cArr = BuiltInFictitiousFunctionClassFactory;
            if (cArr != null) {
                int i5 = $10 + 105;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                int length = cArr.length;
                char[] cArr2 = new char[length];
                for (int i7 = 0; i7 < length; i7++) {
                    cArr2[i7] = (char) (cArr[i7] ^ 5097613533456403102L);
                }
                cArr = cArr2;
            }
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr, i, cArr3, 0, i2);
            if ((bArr != null ? (char) 31 : 'D') != 'D') {
                char[] cArr4 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                        int i8 = $10 + 79;
                        $11 = i8 % 128;
                        int i9 = i8 % 2;
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                        int i10 = $10 + 111;
                        $11 = i10 % 128;
                        int i11 = i10 % 2;
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr4;
            }
            if (!(i4 <= 0)) {
                char[] cArr5 = new char[i2];
                System.arraycopy(cArr3, 0, cArr5, 0, i2);
                int i12 = i2 - i4;
                System.arraycopy(cArr5, 0, cArr3, i12, i4);
                System.arraycopy(cArr5, i4, cArr3, 0, i12);
            }
            if ((z ? '7' : '*') != '*') {
                char[] cArr6 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    try {
                        int i13 = $10 + 125;
                        $11 = i13 % 128;
                        int i14 = i13 % 2;
                        cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                cArr3 = cArr6;
            }
            if (i3 > 0) {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            objArr[0] = new String(cArr3);
        } catch (Exception e2) {
            throw e2;
        }
    }
}

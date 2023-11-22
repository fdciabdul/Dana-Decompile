package com.alipay.mobile.security.bio.utils;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes7.dex */
public abstract class DESCoder {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String ALGORITHM = "DESede";
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    private static char[] MyBillsEntityDataFactory = {35508, 35544, 35500, 35495, 35539};

    public static byte[] decryptBASE64(String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 7;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            byte[] decode = (i % 2 != 0 ? (char) 30 : 'F') != 'F' ? Base64.decode(str, 0) : Base64.decode(str, 0);
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            return decode;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String encryptBASE64(byte[] bArr) {
        int i = BuiltInFictitiousFunctionClassFactory + 25;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        String encodeToString = Base64.encodeToString(bArr, 0);
        int i3 = BuiltInFictitiousFunctionClassFactory + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return encodeToString;
    }

    public static byte[] encryptMode(byte[] bArr, String str) {
        Object[] objArr = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(build3DesKey(str), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(1, secretKeySpec);
            byte[] doFinal = cipher.doFinal(bArr);
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 == 0) {
                int length = objArr.length;
                return doFinal;
            }
            return doFinal;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | Exception unused) {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            return null;
        }
    }

    public static byte[] decryptMode(byte[] bArr, String str) {
        Object[] objArr = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(build3DesKey(str), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(2, secretKeySpec);
            byte[] doFinal = cipher.doFinal(bArr);
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
                try {
                    BuiltInFictitiousFunctionClassFactory = i % 128;
                    if ((i % 2 == 0 ? (char) 17 : Typography.quote) != 17) {
                        return doFinal;
                    }
                    int length = objArr.length;
                    return doFinal;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | Exception unused) {
            return null;
        }
    }

    private static byte[] build3DesKey(String str) throws UnsupportedEncodingException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        byte[] bArr = new byte[24];
        Object[] objArr = new Object[1];
        a(new int[]{0, 5, 0, 1}, true, new byte[]{1, 1, 1, 1, 0}, objArr);
        byte[] bytes = str.getBytes(((String) objArr[0]).intern());
        if ((24 > bytes.length ? (char) 14 : '6') == 14) {
            int i3 = BuiltInFictitiousFunctionClassFactory + 77;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        } else {
            System.arraycopy(bytes, 0, bArr, 0, 24);
        }
        return bArr;
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        char[] cArr;
        char c;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr2 = MyBillsEntityDataFactory;
        if (cArr2 != null) {
            int i5 = $11 + 9;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i7 = 0;
            while (true) {
                if (!(i7 < length)) {
                    break;
                }
                int i8 = $10 + 87;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                cArr3[i7] = (char) (cArr2[i7] ^ 5097613533456403102L);
                i7++;
            }
            cArr2 = cArr3;
        }
        char[] cArr4 = new char[i2];
        System.arraycopy(cArr2, i, cArr4, 0, i2);
        if (bArr != null) {
            int i10 = $10 + 5;
            $11 = i10 % 128;
            if (i10 % 2 == 0) {
                cArr = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                c = 1;
            } else {
                cArr = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                c = 0;
            }
            while (true) {
                try {
                    if (!(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2)) {
                        break;
                    }
                    if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? 'K' : '#') != 'K') {
                        cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                        int i11 = $10 + 47;
                        $11 = i11 % 128;
                        int i12 = i11 % 2;
                    } else {
                        cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    }
                    c = cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr4 = cArr;
        }
        if (!(i4 <= 0)) {
            int i13 = $10 + 15;
            $11 = i13 % 128;
            int i14 = i13 % 2;
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr4, 0, cArr5, 0, i2);
            int i15 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr4, i15, i4);
            System.arraycopy(cArr5, i4, cArr4, 0, i15);
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if (!(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2)) {
                    break;
                }
                int i16 = $10 + 3;
                $11 = i16 % 128;
                int i17 = i16 % 2;
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr4[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr4 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                int i18 = $10 + 13;
                $11 = i18 % 128;
                int i19 = i18 % 2;
                cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                int i20 = $11 + 119;
                $10 = i20 % 128;
                int i21 = i20 % 2;
            }
        }
        objArr[0] = new String(cArr4);
    }
}

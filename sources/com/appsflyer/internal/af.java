package com.appsflyer.internal;

import com.alibaba.griver.base.common.utils.MD5Util;
import com.appsflyer.AFLogger;
import id.dana.data.here.HereOauthManager;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes.dex */
public final class af {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {35458, 35500, 35495, 35539, 35530};
    private static int MyBillsEntityDataFactory = 1;

    public static String AFKeystoreWrapper(String str) {
        int i = MyBillsEntityDataFactory + 77;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Object obj = null;
        try {
            if ((i % 2 != 0 ? '6' : 'V') != 'V') {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.reset();
                Object[] objArr = new Object[1];
                a(new int[]{0, 5, 0, 0}, false, new byte[]{0, 1, 1, 0, 1}, objArr);
                messageDigest.update(str.getBytes(((String) objArr[0]).intern()));
                str = AFInAppEventParameterName(messageDigest.digest());
            } else {
                MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-1");
                messageDigest2.reset();
                Object[] objArr2 = new Object[1];
                a(new int[]{0, 5, 0, 0}, true, new byte[]{0, 1, 1, 0, 1}, objArr2);
                messageDigest2.update(str.getBytes(((String) objArr2[0]).intern()));
                str = AFInAppEventParameterName(messageDigest2.digest());
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA1");
            AFLogger.AFInAppEventType(sb.toString(), e);
            str = null;
        }
        int i2 = MyBillsEntityDataFactory + 109;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (i2 % 2 != 0) {
            obj.hashCode();
            return str;
        }
        return str;
    }

    public static String AFInAppEventType(String str) {
        String str2;
        int i = MyBillsEntityDataFactory + 105;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MD5Util.ALGORIGTHM_MD5);
            messageDigest.reset();
            Object[] objArr = new Object[1];
            a(new int[]{0, 5, 0, 0}, true, new byte[]{0, 1, 1, 0, 1}, objArr);
            messageDigest.update(str.getBytes(((String) objArr[0]).intern()));
            str2 = AFInAppEventParameterName(messageDigest.digest());
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to MD5");
            AFLogger.AFInAppEventType(sb.toString(), e);
            str2 = null;
        }
        int i3 = MyBillsEntityDataFactory + 83;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return str2;
    }

    public static String values(String str) {
        int i = MyBillsEntityDataFactory + 29;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            String values = values(messageDigest.digest());
            try {
                int i3 = BuiltInFictitiousFunctionClassFactory + 81;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return values;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA-256");
            AFLogger.AFInAppEventType(sb.toString(), e2);
            return null;
        }
    }

    private static String values(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = MyBillsEntityDataFactory + 87;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            if ((i2 % 2 != 0 ? '.' : '@') != '.') {
                sb.append(Integer.toString((bArr[i] & 255) + 256, 16).substring(1));
                i++;
            } else {
                try {
                    try {
                        sb.append(Integer.toString((bArr[i] & 10110) + 8923, 10).substring(1));
                        i += 70;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        String obj = sb.toString();
        int i3 = BuiltInFictitiousFunctionClassFactory + 59;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length2 = objArr.length;
            return obj;
        }
        return obj;
    }

    private static String AFInAppEventParameterName(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if ((i < length ? 'c' : ']') != ']') {
                int i2 = BuiltInFictitiousFunctionClassFactory + 19;
                MyBillsEntityDataFactory = i2 % 128;
                int i3 = i2 % 2;
                formatter.format("%02x", Byte.valueOf(bArr[i]));
                i++;
                int i4 = MyBillsEntityDataFactory + 89;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                int i5 = i4 % 2;
            } else {
                String obj = formatter.toString();
                formatter.close();
                return obj;
            }
        }
    }

    public static String values(String str, String str2) {
        try {
            Mac mac = Mac.getInstance(HereOauthManager.HASHING_ALGORITHM);
            mac.init(new SecretKeySpec(str2.getBytes(), HereOauthManager.HASHING_ALGORITHM));
            return values(mac.doFinal(str.getBytes())).toLowerCase();
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            try {
                AFLogger.AFInAppEventParameterName(e.getMessage(), e);
                String message = e.getMessage();
                int i = MyBillsEntityDataFactory + 101;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if (!(i % 2 == 0)) {
                    Object obj = null;
                    obj.hashCode();
                    return message;
                }
                return message;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        int i;
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        char[] cArr = KClassImpl$Data$declaredNonStaticMembers$2;
        if (!(cArr == null)) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i7 = 0;
            while (true) {
                if ((i7 < length ? '\b' : 'K') != '\b') {
                    break;
                }
                cArr2[i7] = (char) (cArr[i7] ^ 5097613533456403102L);
                i7++;
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i4];
        try {
            System.arraycopy(cArr, i3, cArr3, 0, i4);
            if (!(bArr == null)) {
                char[] cArr4 = new char[i4];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4) {
                    try {
                        int i8 = $11 + 15;
                        $10 = i8 % 128;
                        int i9 = i8 % 2;
                        if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                        } else {
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                        }
                        c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        int i10 = $11 + 65;
                        $10 = i10 % 128;
                        int i11 = i10 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                cArr3 = cArr4;
            }
            if (!(i6 <= 0)) {
                int i12 = $10 + 49;
                $11 = i12 % 128;
                int i13 = i12 % 2;
                char[] cArr5 = new char[i4];
                System.arraycopy(cArr3, 0, cArr5, 0, i4);
                int i14 = i4 - i6;
                System.arraycopy(cArr5, 0, cArr3, i14, i6);
                System.arraycopy(cArr5, i6, cArr3, 0, i14);
            }
            if (z) {
                char[] cArr6 = new char[i4];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (true) {
                    if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4 ? Typography.less : (char) 31) == 31) {
                        break;
                    }
                    int i15 = $10 + 47;
                    $11 = i15 % 128;
                    if ((i15 % 2 == 0 ? '4' : '3') != '3') {
                        cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i4 >> verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) << 0];
                        i2 = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory % 0;
                    } else {
                        cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i4 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                        i2 = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory + 1;
                    }
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = i2;
                }
                cArr3 = cArr6;
            }
            if (i5 > 0) {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4) {
                    int i16 = $11 + 57;
                    $10 = i16 % 128;
                    if (i16 % 2 != 0) {
                        cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[4]);
                        i = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory << 1;
                    } else {
                        cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                        i = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory + 1;
                    }
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = i;
                }
            }
            objArr[0] = new String(cArr3);
        } catch (Exception e2) {
            throw e2;
        }
    }
}

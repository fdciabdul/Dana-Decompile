package com.alipay.androidinter.app.safepaybase.encrypt;

import android.util.Base64;
import com.alipay.androidinter.app.safepaybase.log.LogTracer;
import id.dana.data.here.HereOauthManager;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import o.whenAvailable;

/* loaded from: classes6.dex */
public class Rsa {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String ALGORITHM = "RSA";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int PlaceComponentResult = 0;
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
    private static char[] MyBillsEntityDataFactory = {62235, 4270, 13408, 22655, 32166};
    private static long getAuthRequestContext = 6217129932494213370L;

    private static PublicKey getPublicKeyFromX509(String str, String str2) throws Exception {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 2)));
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return generatePublic;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00d1: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:42:0x00d1 */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String encrypt(java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.androidinter.app.safepaybase.encrypt.Rsa.encrypt(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0084, code lost:
    
        if ((r3 != null ? ')' : '(') != ')') goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] encryptToByteArray(java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r2 = "RSA"
            java.security.PublicKey r8 = getPublicKeyFromX509(r2, r8)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.String r2 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r3 = 1
            r2.init(r3, r8)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            int r8 = android.view.ViewConfiguration.getWindowTouchSlop()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            int r8 = r8 >> 8
            int r4 = android.view.ViewConfiguration.getMaximumFlingVelocity()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            int r4 = r4 >> 16
            int r4 = 5 - r4
            int r5 = android.view.ViewConfiguration.getMinimumFlingVelocity()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            int r5 = r5 >> 16
            char r5 = (char) r5     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            a(r8, r4, r5, r3)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r8 = r3[r0]     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.String r8 = r8.intern()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            byte[] r7 = r7.getBytes(r8)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            int r8 = r2.getBlockSize()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r3.<init>()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r4 = 0
        L42:
            int r5 = r7.length     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L94
            r6 = 89
            if (r4 >= r5) goto L4a
            r5 = 89
            goto L4c
        L4a:
            r5 = 26
        L4c:
            if (r5 == r6) goto L53
            byte[] r1 = r3.toByteArray()     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L94
            goto L87
        L53:
            int r5 = r7.length     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L94
            int r5 = r5 - r4
            if (r5 >= r8) goto L64
            int r5 = com.alipay.androidinter.app.safepaybase.encrypt.Rsa.PlaceComponentResult
            int r5 = r5 + 31
            int r6 = r5 % 128
            com.alipay.androidinter.app.safepaybase.encrypt.Rsa.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r5 = r5 % 2
            int r5 = r7.length     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L94
            int r5 = r5 - r4
            goto L65
        L64:
            r5 = r8
        L65:
            byte[] r5 = r2.doFinal(r7, r4, r5)     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L94
            r3.write(r5)     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L94
            int r4 = r4 + r8
            goto L42
        L6e:
            r7 = move-exception
            goto L74
        L70:
            r7 = move-exception
            goto L96
        L72:
            r7 = move-exception
            r3 = r1
        L74:
            com.alipay.androidinter.app.safepaybase.log.LogTracer r8 = com.alipay.androidinter.app.safepaybase.log.LogTracer.getInstance()     // Catch: java.lang.Throwable -> L94
            r8.printExceptionStackTrace(r7)     // Catch: java.lang.Throwable -> L94
            r7 = 41
            if (r3 == 0) goto L82
            r8 = 41
            goto L84
        L82:
            r8 = 40
        L84:
            if (r8 == r7) goto L87
            goto L93
        L87:
            r3.close()     // Catch: java.io.IOException -> L8b
            goto L93
        L8b:
            r7 = move-exception
            com.alipay.androidinter.app.safepaybase.log.LogTracer r8 = com.alipay.androidinter.app.safepaybase.log.LogTracer.getInstance()
            r8.printExceptionStackTrace(r7)
        L93:
            return r1
        L94:
            r7 = move-exception
            r1 = r3
        L96:
            r8 = 68
            if (r1 == 0) goto L9d
            r2 = 68
            goto L9f
        L9d:
            r2 = 28
        L9f:
            if (r2 != r8) goto Lc2
            int r8 = com.alipay.androidinter.app.safepaybase.encrypt.Rsa.PlaceComponentResult
            int r8 = r8 + 87
            int r2 = r8 % 128
            com.alipay.androidinter.app.safepaybase.encrypt.Rsa.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r8 = r8 % 2
            if (r8 != 0) goto Lb6
            r1.close()     // Catch: java.io.IOException -> Lba
            r8 = 98
            int r8 = r8 / r0
            goto Lc2
        Lb4:
            r7 = move-exception
            throw r7
        Lb6:
            r1.close()     // Catch: java.io.IOException -> Lba
            goto Lc2
        Lba:
            r8 = move-exception
            com.alipay.androidinter.app.safepaybase.log.LogTracer r0 = com.alipay.androidinter.app.safepaybase.log.LogTracer.getInstance()
            r0.printExceptionStackTrace(r8)
        Lc2:
            goto Lc4
        Lc3:
            throw r7
        Lc4:
            goto Lc3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.androidinter.app.safepaybase.encrypt.Rsa.encryptToByteArray(java.lang.String, java.lang.String):byte[]");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0099: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:41:0x0099 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String decrypt(java.lang.String r9, java.lang.String r10) {
        /*
            r0 = 73
            r1 = 0
            r2 = 2
            java.security.spec.PKCS8EncodedKeySpec r3 = new java.security.spec.PKCS8EncodedKeySpec     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            byte[] r10 = android.util.Base64.decode(r10, r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r10 = "RSA"
            java.security.KeyFactory r10 = java.security.KeyFactory.getInstance(r10)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.security.PrivateKey r10 = r10.generatePrivate(r3)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r3 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r3 = javax.crypto.Cipher.getInstance(r3)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r3.init(r2, r10)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            byte[] r9 = android.util.Base64.decode(r9, r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            int r10 = r3.getBlockSize()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r4.<init>()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r5 = 0
            r6 = 0
        L2f:
            int r7 = r9.length     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L98
            if (r6 >= r7) goto L34
            r7 = 0
            goto L35
        L34:
            r7 = 1
        L35:
            if (r7 == 0) goto L4e
            java.lang.String r9 = new java.lang.String     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L98
            byte[] r10 = r4.toByteArray()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L98
            r9.<init>(r10)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L98
            r4.close()     // Catch: java.io.IOException -> L44
            goto L4c
        L44:
            r10 = move-exception
            com.alipay.androidinter.app.safepaybase.log.LogTracer r0 = com.alipay.androidinter.app.safepaybase.log.LogTracer.getInstance()
            r0.printExceptionStackTrace(r10)
        L4c:
            r1 = r9
            goto L97
        L4e:
            int r7 = r9.length     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L98
            int r7 = r7 - r6
            if (r7 >= r10) goto L60
            int r7 = com.alipay.androidinter.app.safepaybase.encrypt.Rsa.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L5e
            int r7 = r7 + r0
            int r8 = r7 % 128
            com.alipay.androidinter.app.safepaybase.encrypt.Rsa.PlaceComponentResult = r8     // Catch: java.lang.Exception -> L5e
            int r7 = r7 % 2
            int r7 = r9.length     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L98
            int r7 = r7 - r6
            goto L61
        L5e:
            r9 = move-exception
            throw r9
        L60:
            r7 = r10
        L61:
            byte[] r7 = r3.doFinal(r9, r6, r7)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L98
            r4.write(r7)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L98
            int r6 = r6 + r10
            int r7 = com.alipay.androidinter.app.safepaybase.encrypt.Rsa.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 117
            int r8 = r7 % 128
            com.alipay.androidinter.app.safepaybase.encrypt.Rsa.PlaceComponentResult = r8
            int r7 = r7 % r2
            goto L2f
        L73:
            r9 = move-exception
            goto L79
        L75:
            r9 = move-exception
            goto L9a
        L77:
            r9 = move-exception
            r4 = r1
        L79:
            com.alipay.androidinter.app.safepaybase.log.LogTracer r10 = com.alipay.androidinter.app.safepaybase.log.LogTracer.getInstance()     // Catch: java.lang.Throwable -> L98
            r10.printExceptionStackTrace(r9)     // Catch: java.lang.Throwable -> L98
            if (r4 == 0) goto L97
            r4.close()     // Catch: java.io.IOException -> L8f
            int r9 = com.alipay.androidinter.app.safepaybase.encrypt.Rsa.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9 + 7
            int r10 = r9 % 128
            com.alipay.androidinter.app.safepaybase.encrypt.Rsa.PlaceComponentResult = r10
            int r9 = r9 % r2
            goto L97
        L8f:
            r9 = move-exception
            com.alipay.androidinter.app.safepaybase.log.LogTracer r10 = com.alipay.androidinter.app.safepaybase.log.LogTracer.getInstance()
            r10.printExceptionStackTrace(r9)
        L97:
            return r1
        L98:
            r9 = move-exception
            r1 = r4
        L9a:
            r10 = 54
            if (r1 == 0) goto La0
            r0 = 54
        La0:
            if (r0 != r10) goto Lb7
            int r10 = com.alipay.androidinter.app.safepaybase.encrypt.Rsa.PlaceComponentResult
            int r10 = r10 + 89
            int r0 = r10 % 128
            com.alipay.androidinter.app.safepaybase.encrypt.Rsa.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r10 = r10 % r2
            r1.close()     // Catch: java.io.IOException -> Laf
            goto Lb7
        Laf:
            r10 = move-exception
            com.alipay.androidinter.app.safepaybase.log.LogTracer r0 = com.alipay.androidinter.app.safepaybase.log.LogTracer.getInstance()
            r0.printExceptionStackTrace(r10)
        Lb7:
            goto Lb9
        Lb8:
            throw r9
        Lb9:
            goto Lb8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.androidinter.app.safepaybase.encrypt.Rsa.decrypt(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String sign(String str, String str2) {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2, 2)));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initSign(generatePrivate);
            signature.update(str.getBytes(HereOauthManager.ENC));
            String encodeToString = Base64.encodeToString(signature.sign(), 2);
            try {
                int i = PlaceComponentResult + 3;
                try {
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    return encodeToString;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            LogTracer.getInstance().printExceptionStackTrace(e3);
            return null;
        }
    }

    public static boolean doCheck(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str3, 2)));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(generatePublic);
            signature.update(str.getBytes(HereOauthManager.ENC));
            boolean verify = signature.verify(Base64.decode(str2, 2));
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return verify;
        } catch (Exception e) {
            LogTracer.getInstance().printExceptionStackTrace(e);
            return false;
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            try {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? (char) 22 : (char) 20) != 22) {
                    break;
                }
                int i3 = $11 + 79;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (MyBillsEntityDataFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ getAuthRequestContext))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            int i5 = $10 + 15;
            $11 = i5 % 128;
            if ((i5 % 2 == 0 ? '\r' : (char) 18) != '\r') {
                try {
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e2) {
                    throw e2;
                }
            } else {
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                whenavailable.BuiltInFictitiousFunctionClassFactory += 0;
            }
        }
        objArr[0] = new String(cArr);
    }
}

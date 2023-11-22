package com.alipay.iap.android.aplog.util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes3.dex */
public class RSAUtil {
    private static final String ALGORITHM = "RSA";
    private static final int MAX_DECRYPT_BLOCK = 128;
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static final String TAG = "LogRSAUtil";
    private static final String TRANSFORM = "RSA/ECB/PKCS1Padding";
    private static Cipher decryptCipher;
    private static Cipher encryptCipher;

    private static PublicKey getPublicKeyFromX509(String str, String str2) throws Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(Base64.decode(str2)));
    }

    private static PrivateKey getPrivatekeyFromPKCS8(String str, String str2) throws Exception {
        return KeyFactory.getInstance(str).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        if (r7 == null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] encrypt(byte[] r6, java.lang.String r7) {
        /*
            java.lang.Class<com.alipay.iap.android.aplog.util.RSAUtil> r0 = com.alipay.iap.android.aplog.util.RSAUtil.class
            monitor-enter(r0)
            r1 = 0
            javax.crypto.Cipher r2 = com.alipay.iap.android.aplog.util.RSAUtil.encryptCipher     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r2 != 0) goto L1a
            java.lang.String r2 = "RSA"
            java.security.PublicKey r7 = getPublicKeyFromX509(r2, r7)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r2 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            com.alipay.iap.android.aplog.util.RSAUtil.encryptCipher = r2     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r3 = 1
            r2.init(r3, r7)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
        L1a:
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r7.<init>()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r2 = 0
        L20:
            int r3 = r6.length     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            if (r2 >= r3) goto L38
            javax.crypto.Cipher r3 = com.alipay.iap.android.aplog.util.RSAUtil.encryptCipher     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            int r4 = r6.length     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            int r4 = r4 - r2
            r5 = 117(0x75, float:1.64E-43)
            if (r4 >= r5) goto L2e
            int r4 = r6.length     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            int r5 = r4 - r2
        L2e:
            byte[] r3 = r3.doFinal(r6, r2, r5)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            r7.write(r3)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            int r2 = r2 + 117
            goto L20
        L38:
            r7.flush()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            byte[] r6 = r7.toByteArray()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            r1 = r6
            goto L50
        L41:
            r6 = move-exception
            goto L47
        L43:
            r6 = move-exception
            goto L57
        L45:
            r6 = move-exception
            r7 = r1
        L47:
            com.alipay.iap.android.aplog.util.RSAUtil.encryptCipher = r1     // Catch: java.lang.Throwable -> L55
            java.lang.String r2 = "LogRSAUtil"
            com.fullstory.instrumentation.InstrumentInjector.log_w(r2, r6)     // Catch: java.lang.Throwable -> L55
            if (r7 == 0) goto L53
        L50:
            r7.close()     // Catch: java.io.IOException -> L53 java.lang.Throwable -> L5d
        L53:
            monitor-exit(r0)
            return r1
        L55:
            r6 = move-exception
            r1 = r7
        L57:
            if (r1 == 0) goto L5c
            r1.close()     // Catch: java.io.IOException -> L5c java.lang.Throwable -> L5d
        L5c:
            throw r6     // Catch: java.lang.Throwable -> L5d
        L5d:
            r6 = move-exception
            monitor-exit(r0)
            goto L61
        L60:
            throw r6
        L61:
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.RSAUtil.encrypt(byte[], java.lang.String):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        if (r7 == null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] decrypt(byte[] r6, java.lang.String r7) {
        /*
            java.lang.Class<com.alipay.iap.android.aplog.util.RSAUtil> r0 = com.alipay.iap.android.aplog.util.RSAUtil.class
            monitor-enter(r0)
            r1 = 0
            javax.crypto.Cipher r2 = com.alipay.iap.android.aplog.util.RSAUtil.decryptCipher     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r2 != 0) goto L1a
            java.lang.String r2 = "RSA"
            java.security.PrivateKey r7 = getPrivatekeyFromPKCS8(r2, r7)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r2 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            com.alipay.iap.android.aplog.util.RSAUtil.decryptCipher = r2     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r3 = 2
            r2.init(r3, r7)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
        L1a:
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r7.<init>()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r2 = 0
        L20:
            int r3 = r6.length     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            if (r2 >= r3) goto L38
            javax.crypto.Cipher r3 = com.alipay.iap.android.aplog.util.RSAUtil.decryptCipher     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            int r4 = r6.length     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            int r4 = r4 - r2
            r5 = 128(0x80, float:1.794E-43)
            if (r4 >= r5) goto L2e
            int r4 = r6.length     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            int r5 = r4 - r2
        L2e:
            byte[] r3 = r3.doFinal(r6, r2, r5)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            r7.write(r3)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            int r2 = r2 + 128
            goto L20
        L38:
            r7.flush()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            byte[] r6 = r7.toByteArray()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L55
            r1 = r6
            goto L50
        L41:
            r6 = move-exception
            goto L47
        L43:
            r6 = move-exception
            goto L57
        L45:
            r6 = move-exception
            r7 = r1
        L47:
            com.alipay.iap.android.aplog.util.RSAUtil.decryptCipher = r1     // Catch: java.lang.Throwable -> L55
            java.lang.String r2 = "LogRSAUtil"
            com.fullstory.instrumentation.InstrumentInjector.log_w(r2, r6)     // Catch: java.lang.Throwable -> L55
            if (r7 == 0) goto L53
        L50:
            r7.close()     // Catch: java.io.IOException -> L53 java.lang.Throwable -> L5d
        L53:
            monitor-exit(r0)
            return r1
        L55:
            r6 = move-exception
            r1 = r7
        L57:
            if (r1 == 0) goto L5c
            r1.close()     // Catch: java.io.IOException -> L5c java.lang.Throwable -> L5d
        L5c:
            throw r6     // Catch: java.lang.Throwable -> L5d
        L5d:
            r6 = move-exception
            monitor-exit(r0)
            goto L61
        L60:
            throw r6
        L61:
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.RSAUtil.decrypt(byte[], java.lang.String):byte[]");
    }
}

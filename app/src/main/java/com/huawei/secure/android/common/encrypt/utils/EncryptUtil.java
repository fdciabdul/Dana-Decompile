package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* loaded from: classes8.dex */
public class EncryptUtil {
    private static boolean BuiltInFictitiousFunctionClassFactory = false;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;

    /* JADX WARN: Removed duplicated region for block: B:22:0x0019 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.SecureRandom BuiltInFictitiousFunctionClassFactory() {
        /*
            java.lang.String r0 = "EncryptUtil"
            com.huawei.secure.android.common.encrypt.utils.b.KClassImpl$Data$declaredNonStaticMembers$2()
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.security.NoSuchAlgorithmException -> L10
            r2 = 26
            if (r1 < r2) goto L15
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstanceStrong()     // Catch: java.security.NoSuchAlgorithmException -> L10
            goto L16
        L10:
            java.lang.String r1 = "getSecureRandomBytes: NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r0, r1)
        L15:
            r1 = 0
        L16:
            r2 = 0
            if (r1 != 0) goto L1f
            java.lang.String r3 = "SHA1PRNG"
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstance(r3)     // Catch: java.lang.Throwable -> L3e java.security.NoSuchAlgorithmException -> L63
        L1f:
            org.bouncycastle.crypto.engines.AESEngine r3 = new org.bouncycastle.crypto.engines.AESEngine     // Catch: java.lang.Throwable -> L3e java.security.NoSuchAlgorithmException -> L63
            r3.<init>()     // Catch: java.lang.Throwable -> L3e java.security.NoSuchAlgorithmException -> L63
            r4 = 32
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L3e java.security.NoSuchAlgorithmException -> L63
            r1.nextBytes(r4)     // Catch: java.lang.Throwable -> L3e java.security.NoSuchAlgorithmException -> L63
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r5 = new org.bouncycastle.crypto.prng.SP800SecureRandomBuilder     // Catch: java.lang.Throwable -> L3e java.security.NoSuchAlgorithmException -> L63
            r6 = 1
            r5.<init>(r1, r6)     // Catch: java.lang.Throwable -> L3e java.security.NoSuchAlgorithmException -> L63
            r6 = 384(0x180, float:5.38E-43)
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r5 = r5.setEntropyBitsRequired(r6)     // Catch: java.lang.Throwable -> L3e java.security.NoSuchAlgorithmException -> L63
            r6 = 256(0x100, float:3.59E-43)
            org.bouncycastle.crypto.prng.SP800SecureRandom r0 = r5.buildCTR(r3, r6, r4, r2)     // Catch: java.lang.Throwable -> L3e java.security.NoSuchAlgorithmException -> L63
            return r0
        L3e:
            r3 = move-exception
            boolean r4 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.KClassImpl$Data$declaredNonStaticMembers$2
            if (r4 == 0) goto L68
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "exception : "
            r4.append(r5)
            java.lang.String r3 = r3.getMessage()
            r4.append(r3)
            java.lang.String r3 = " , you should implementation bcprov-jdk15on library"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r0, r3)
            com.huawei.secure.android.common.encrypt.utils.EncryptUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            goto L68
        L63:
            java.lang.String r2 = "NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r0, r2)
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.utils.EncryptUtil.BuiltInFictitiousFunctionClassFactory():java.security.SecureRandom");
    }

    public static String MyBillsEntityDataFactory(int i) {
        return HexUtil.getAuthRequestContext(getAuthRequestContext(i));
    }

    public static byte[] getAuthRequestContext(int i) {
        if (!BuiltInFictitiousFunctionClassFactory) {
            byte[] bArr = new byte[i];
            SecureRandom secureRandom = null;
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    secureRandom = SecureRandom.getInstanceStrong();
                }
            } catch (NoSuchAlgorithmException unused) {
                b.PlaceComponentResult("EncryptUtil", "getSecureRandomBytes: NoSuchAlgorithmException");
            }
            if (secureRandom == null) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                } catch (NoSuchAlgorithmException unused2) {
                    b.PlaceComponentResult("EncryptUtil", "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                    return new byte[0];
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getSecureRandomBytes getInstance: exception : ");
                    sb.append(e.getMessage());
                    b.PlaceComponentResult("EncryptUtil", sb.toString());
                    return new byte[0];
                }
            }
            secureRandom.nextBytes(bArr);
            return bArr;
        }
        return PlaceComponentResult(i);
    }

    private static byte[] PlaceComponentResult(int i) {
        SecureRandom BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory2 == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        BuiltInFictitiousFunctionClassFactory2.nextBytes(bArr);
        return bArr;
    }
}

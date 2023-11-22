package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.b;
import id.dana.cashier.view.InputCardNumberView;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.text.Typography;
import o.whenAvailable;

/* loaded from: classes8.dex */
public class AesGcmKS {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static long KClassImpl$Data$declaredNonStaticMembers$2;
    private static int MyBillsEntityDataFactory;
    private static Map<String, SecretKey> PlaceComponentResult;
    private static char[] getAuthRequestContext;

    static {
        BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult = new HashMap();
        int i = MyBillsEntityDataFactory + 5;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? 'V' : Typography.quote) != 'V') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext = new char[]{39341, 14199, 50184, 38212, 8876};
        KClassImpl$Data$declaredNonStaticMembers$2 = -7548534320540394091L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if ((!r0 ? '!' : '^') != '^') goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (android.text.TextUtils.isEmpty(r7) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (android.text.TextUtils.isEmpty(r8) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        if (r0 == true) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r4 = new java.lang.Object[1];
        a((android.util.TypedValue.complexToFloat(0) > 0.0f ? 1 : (android.util.TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (android.view.ViewConfiguration.getKeyRepeatTimeout() >> 16) + 5, (char) (android.text.TextUtils.indexOf("", "") + 27318), r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2(r7, r8.getBytes(((java.lang.String) r4[0]).intern())));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        r8 = new java.lang.StringBuilder();
        r8.append("encrypt: UnsupportedEncodingException : ");
        r8.append(r7.getMessage());
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        return "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r7, java.lang.String r8) {
        /*
            int r0 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 101
            int r1 = r0 % 128
            com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            java.lang.String r1 = "GCMKS"
            java.lang.String r2 = ""
            if (r0 == 0) goto L24
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L22
            r3 = 94
            if (r0 != 0) goto L1d
            r0 = 33
            goto L1f
        L1d:
            r0 = 94
        L1f:
            if (r0 == r3) goto L81
            goto L2a
        L22:
            r7 = move-exception
            throw r7
        L24:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L81
        L2a:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L34
            r0 = 0
            goto L35
        L34:
            r0 = 1
        L35:
            if (r0 == r4) goto L81
            float r0 = android.util.TypedValue.complexToFloat(r3)     // Catch: java.io.UnsupportedEncodingException -> L67
            r5 = 0
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            int r5 = android.view.ViewConfiguration.getKeyRepeatTimeout()     // Catch: java.io.UnsupportedEncodingException -> L67
            int r5 = r5 >> 16
            int r5 = r5 + 5
            int r6 = android.text.TextUtils.indexOf(r2, r2)     // Catch: java.io.UnsupportedEncodingException -> L67
            int r6 = r6 + 27318
            char r6 = (char) r6     // Catch: java.io.UnsupportedEncodingException -> L67
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.io.UnsupportedEncodingException -> L67
            a(r0, r5, r6, r4)     // Catch: java.io.UnsupportedEncodingException -> L67
            r0 = r4[r3]     // Catch: java.io.UnsupportedEncodingException -> L67
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.io.UnsupportedEncodingException -> L67
            java.lang.String r0 = r0.intern()     // Catch: java.io.UnsupportedEncodingException -> L67
            byte[] r8 = r8.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L67
            byte[] r7 = KClassImpl$Data$declaredNonStaticMembers$2(r7, r8)     // Catch: java.io.UnsupportedEncodingException -> L67
            java.lang.String r7 = com.huawei.secure.android.common.encrypt.utils.HexUtil.getAuthRequestContext(r7)     // Catch: java.io.UnsupportedEncodingException -> L67
            return r7
        L67:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "encrypt: UnsupportedEncodingException : "
            r8.append(r0)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r1, r7)
            return r2
        L81:
            java.lang.String r7 = "alias or encrypt content is null"
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r1, r7)     // Catch: java.lang.Exception -> L91
            int r7 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L91
            int r7 = r7 + 73
            int r8 = r7 % 128
            com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory = r8     // Catch: java.lang.Exception -> L93
            int r7 = r7 % 2
            return r2
        L91:
            r7 = move-exception
            throw r7
        L93:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String, java.lang.String):java.lang.String");
    }

    private static SecretKey MyBillsEntityDataFactory(String str) {
        if ((TextUtils.isEmpty(str) ? Typography.dollar : (char) 11) != '$') {
            if ((PlaceComponentResult.get(str) == null ? (char) 21 : 'B') == 21) {
                int i = MyBillsEntityDataFactory + 7;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                KClassImpl$Data$declaredNonStaticMembers$2(str);
            }
            try {
                return PlaceComponentResult.get(str);
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 87;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        if (r1 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        r9 = BuiltInFictitiousFunctionClassFactory(r9, com.huawei.secure.android.common.encrypt.utils.HexUtil.getAuthRequestContext(r10));
        r7 = new java.lang.Object[1];
        a((android.telephony.cdma.CdmaCellLocation.convertQuartSecToDecDegrees(0) > com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (android.telephony.cdma.CdmaCellLocation.convertQuartSecToDecDegrees(0) == com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (android.view.ViewConfiguration.getScrollDefaultDelay() >> 16) + 5, (char) (android.text.TextUtils.indexOf("", "") + 27318), r7);
        r1 = new java.lang.String(r9, ((java.lang.String) r7[0]).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        r9 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory + 1;
        com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.MyBillsEntityDataFactory = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        r10 = new java.lang.StringBuilder();
        r10.append("decrypt: UnsupportedEncodingException : ");
        r10.append(r9.getMessage());
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", r10.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0094, code lost:
    
        return "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String BuiltInFictitiousFunctionClassFactory(java.lang.String r9, java.lang.String r10) {
        /*
            int r0 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory
            r1 = 41
            int r0 = r0 + r1
            int r2 = r0 % 128
            com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.MyBillsEntityDataFactory = r2
            int r0 = r0 % 2
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r2 = 60
            if (r0 != 0) goto L14
            goto L16
        L14:
            r1 = 60
        L16:
            java.lang.String r0 = "GCMKS"
            java.lang.String r3 = ""
            if (r1 == r2) goto L99
            int r1 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L97
            int r1 = r1 + 19
            int r2 = r1 % 128
            com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.MyBillsEntityDataFactory = r2     // Catch: java.lang.Exception -> L95
            int r1 = r1 % 2
            r2 = 1
            r4 = 0
            if (r1 == 0) goto L2c
            r1 = 1
            goto L2d
        L2c:
            r1 = 0
        L2d:
            if (r1 == 0) goto L3a
            boolean r1 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Exception -> L97
            r5 = 0
            int r5 = r5.length     // Catch: java.lang.Throwable -> L38
            if (r1 != 0) goto L99
            goto L40
        L38:
            r9 = move-exception
            throw r9
        L3a:
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L99
        L40:
            java.lang.String r1 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L7b
            byte[] r10 = com.huawei.secure.android.common.encrypt.utils.HexUtil.getAuthRequestContext(r10)     // Catch: java.io.UnsupportedEncodingException -> L7b
            byte[] r9 = BuiltInFictitiousFunctionClassFactory(r9, r10)     // Catch: java.io.UnsupportedEncodingException -> L7b
            double r5 = android.telephony.cdma.CdmaCellLocation.convertQuartSecToDecDegrees(r4)     // Catch: java.io.UnsupportedEncodingException -> L7b
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            int r5 = android.view.ViewConfiguration.getScrollDefaultDelay()     // Catch: java.io.UnsupportedEncodingException -> L7b
            int r5 = r5 >> 16
            int r5 = r5 + 5
            int r6 = android.text.TextUtils.indexOf(r3, r3)     // Catch: java.io.UnsupportedEncodingException -> L7b
            int r6 = r6 + 27318
            char r6 = (char) r6     // Catch: java.io.UnsupportedEncodingException -> L7b
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch: java.io.UnsupportedEncodingException -> L7b
            a(r10, r5, r6, r7)     // Catch: java.io.UnsupportedEncodingException -> L7b
            r10 = r7[r4]     // Catch: java.io.UnsupportedEncodingException -> L7b
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.io.UnsupportedEncodingException -> L7b
            java.lang.String r10 = r10.intern()     // Catch: java.io.UnsupportedEncodingException -> L7b
            r1.<init>(r9, r10)     // Catch: java.io.UnsupportedEncodingException -> L7b
            int r9 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L97
            int r9 = r9 + r2
            int r10 = r9 % 128
            com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.MyBillsEntityDataFactory = r10     // Catch: java.lang.Exception -> L97
            int r9 = r9 % 2
            return r1
        L7b:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "decrypt: UnsupportedEncodingException : "
            r10.append(r1)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r0, r9)
            return r3
        L95:
            r9 = move-exception
            throw r9
        L97:
            r9 = move-exception
            throw r9
        L99:
            java.lang.String r9 = "alias or encrypt content is null"
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r0, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.String):java.lang.String");
    }

    private static byte[] BuiltInFictitiousFunctionClassFactory(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.PlaceComponentResult("GCMKS", "alias or encrypt content is null");
            return bArr2;
        }
        int i = MyBillsEntityDataFactory + 43;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if ((!MyBillsEntityDataFactory() ? (char) 17 : 'B') == 17) {
            try {
                b.PlaceComponentResult("GCMKS", "sdk version is too low");
                return bArr2;
            } catch (Exception e) {
                throw e;
            }
        } else if (bArr.length <= 12) {
            try {
                int i3 = MyBillsEntityDataFactory + 7;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                char c = i3 % 2 == 0 ? Typography.greater : Typography.dollar;
                b.PlaceComponentResult("GCMKS", "Decrypt source data is invalid.");
                if (c != '$') {
                    int i4 = 72 / 0;
                }
                return bArr2;
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            return KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory(str), bArr);
        }
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str)) {
            int i = BuiltInFictitiousFunctionClassFactory + 43;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            if ((bArr != null ? '.' : 'N') != 'N') {
                try {
                    if (!(MyBillsEntityDataFactory())) {
                        int i3 = MyBillsEntityDataFactory + 47;
                        BuiltInFictitiousFunctionClassFactory = i3 % 128;
                        boolean z = i3 % 2 != 0;
                        Object[] objArr = null;
                        b.PlaceComponentResult("GCMKS", "sdk version is too low");
                        if (!z) {
                            objArr.hashCode();
                        }
                        int i4 = BuiltInFictitiousFunctionClassFactory + 37;
                        MyBillsEntityDataFactory = i4 % 128;
                        if ((i4 % 2 != 0 ? '*' : (char) 21) != 21) {
                            int length = objArr.length;
                            return bArr2;
                        }
                        return bArr2;
                    }
                    return PlaceComponentResult(MyBillsEntityDataFactory(str), bArr);
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        b.PlaceComponentResult("GCMKS", "alias or encrypt content is null");
        return bArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
    
        if ((r6 == null ? 'B' : '5') != '5') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if ((r6 == null ? 'c' : '?') != '?') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", "content is null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if (r5 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        r5 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory + 67;
        com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.MyBillsEntityDataFactory = r5 % 128;
        r5 = r5 % 2;
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", "secret key is null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        if (MyBillsEntityDataFactory() != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", "sdk version is too low");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        r3 = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
        r3.init(1, r5);
        r5 = r3.doFinal(r6);
        r6 = r3.getIV();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        if (r6 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        r3 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.MyBillsEntityDataFactory + 45;
        com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
    
        if (r6.length == 12) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0072, code lost:
    
        r0 = java.util.Arrays.copyOf(r6, r6.length + r5.length);
        java.lang.System.arraycopy(r5, 0, r0, r6.length, r5.length);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007e, code lost:
    
        r5 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory + 33;
        com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.MyBillsEntityDataFactory = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
    
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", "IV is invalid.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0090, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0091, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append("Exception: ");
        r6.append(r5.getMessage());
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", r6.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ab, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ac, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append("InvalidKeyException : ");
        r6.append(r5.getMessage());
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", r6.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c5, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c6, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append("IllegalBlockSizeException : ");
        r6.append(r5.getMessage());
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", r6.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00df, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e0, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append("BadPaddingException : ");
        r6.append(r5.getMessage());
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", r6.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f9, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00fa, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append("NoSuchPaddingException : ");
        r6.append(r5.getMessage());
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", r6.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0113, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0114, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append("NoSuchAlgorithmException : ");
        r6.append(r5.getMessage());
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("GCMKS", r6.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] PlaceComponentResult(javax.crypto.SecretKey r5, byte[] r6) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.PlaceComponentResult(javax.crypto.SecretKey, byte[]):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if ((r0 instanceof javax.crypto.SecretKey ? '^' : 5) != '^') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if ((!(r0 instanceof javax.crypto.SecretKey)) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        com.huawei.secure.android.common.encrypt.utils.b.KClassImpl$Data$declaredNonStaticMembers$2("GCMKS", "generate key");
        r0 = javax.crypto.KeyGenerator.getInstance(io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider.ALGORITHM, "AndroidKeyStore");
        r0.init(new android.security.keystore.KeyGenParameterSpec.Builder(r7, 3).setBlockModes(com.google.android.gms.stats.CodePackage.GCM).setEncryptionPaddings("NoPadding").setKeySize(256).build());
        r5 = r0.generateKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
    
        r1 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.MyBillsEntityDataFactory + 15;
        com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008f, code lost:
    
        if ((r1 % 2) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
    
        r1 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0094, code lost:
    
        r1 = 'Z';
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0096, code lost:
    
        if (r1 == 'Z') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0098, code lost:
    
        r0 = (javax.crypto.SecretKey) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009a, code lost:
    
        r3 = 0 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009e, code lost:
    
        r0 = (javax.crypto.SecretKey) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a0, code lost:
    
        r5 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static javax.crypto.SecretKey KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String):javax.crypto.SecretKey");
    }

    private static boolean MyBillsEntityDataFactory() {
        int i = BuiltInFictitiousFunctionClassFactory + 55;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            if ((Build.VERSION.SDK_INT >= 23 ? InputCardNumberView.DIVIDER : (char) 31) == ' ') {
                int i3 = BuiltInFictitiousFunctionClassFactory + 39;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return true;
            }
            try {
                int i5 = BuiltInFictitiousFunctionClassFactory + 11;
                MyBillsEntityDataFactory = i5 % 128;
                int i6 = i5 % 2;
                return false;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        Object[] objArr = null;
        if ((secretKey == null ? '9' : (char) 30) != 30) {
            int i = MyBillsEntityDataFactory + 25;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 == 0) {
                b.PlaceComponentResult("GCMKS", "Decrypt secret key is null");
                objArr.hashCode();
            } else {
                b.PlaceComponentResult("GCMKS", "Decrypt secret key is null");
            }
            int i2 = MyBillsEntityDataFactory + 43;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            return bArr2;
        }
        if ((bArr == null ? 'O' : '8') == '8') {
            if (!(!MyBillsEntityDataFactory())) {
                if ((bArr.length > 12 ? (char) 14 : (char) 25) != 14) {
                    int i4 = MyBillsEntityDataFactory + 79;
                    BuiltInFictitiousFunctionClassFactory = i4 % 128;
                    int i5 = i4 % 2;
                    try {
                        b.PlaceComponentResult("GCMKS", "Decrypt source data is invalid.");
                        return bArr2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, 12);
                try {
                    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                    cipher.init(2, secretKey, new GCMParameterSpec(128, copyOf));
                    return cipher.doFinal(bArr, 12, bArr.length - 12);
                } catch (InvalidAlgorithmParameterException e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("InvalidAlgorithmParameterException : ");
                    sb.append(e2.getMessage());
                    b.PlaceComponentResult("GCMKS", sb.toString());
                    return bArr2;
                } catch (InvalidKeyException e3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("InvalidKeyException : ");
                    sb2.append(e3.getMessage());
                    b.PlaceComponentResult("GCMKS", sb2.toString());
                    return bArr2;
                } catch (NoSuchAlgorithmException e4) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("NoSuchAlgorithmException : ");
                    sb3.append(e4.getMessage());
                    b.PlaceComponentResult("GCMKS", sb3.toString());
                    return bArr2;
                } catch (BadPaddingException e5) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("BadPaddingException : ");
                    sb4.append(e5.getMessage());
                    b.PlaceComponentResult("GCMKS", sb4.toString());
                    return bArr2;
                } catch (IllegalBlockSizeException e6) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("IllegalBlockSizeException : ");
                    sb5.append(e6.getMessage());
                    b.PlaceComponentResult("GCMKS", sb5.toString());
                    return bArr2;
                } catch (NoSuchPaddingException e7) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("NoSuchPaddingException : ");
                    sb6.append(e7.getMessage());
                    b.PlaceComponentResult("GCMKS", sb6.toString());
                    return bArr2;
                } catch (Exception e8) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Exception: ");
                    sb7.append(e8.getMessage());
                    b.PlaceComponentResult("GCMKS", sb7.toString());
                    return bArr2;
                }
            }
            int i6 = MyBillsEntityDataFactory + 21;
            BuiltInFictitiousFunctionClassFactory = i6 % 128;
            if (i6 % 2 != 0) {
                try {
                    b.PlaceComponentResult("GCMKS", "sdk version is too low");
                    return bArr2;
                } catch (Exception e9) {
                    throw e9;
                }
            }
            b.PlaceComponentResult("GCMKS", "sdk version is too low");
            int length = objArr.length;
            return bArr2;
        }
        int i7 = BuiltInFictitiousFunctionClassFactory + 15;
        MyBillsEntityDataFactory = i7 % 128;
        int i8 = i7 % 2;
        b.PlaceComponentResult("GCMKS", "content is null");
        return bArr2;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                break;
            }
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getAuthRequestContext[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ KClassImpl$Data$declaredNonStaticMembers$2))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (!(whenavailable.BuiltInFictitiousFunctionClassFactory < i2)) {
                String str = new String(cArr);
                int i3 = $11 + 67;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                objArr[0] = str;
                return;
            }
            int i5 = $10 + 75;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            try {
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            } catch (Exception e) {
                throw e;
            }
            throw e;
        }
    }
}

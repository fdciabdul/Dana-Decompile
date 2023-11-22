package com.alipay.iap.android.common.utils.security;

import android.util.Base64;
import com.fullstory.instrumentation.InstrumentInjector;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes2.dex */
public class RSAHelper {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String DEFAULT_ALGORITHM = "RSA";
    private static final String DEFAULT_TRANSFORMATION = "RSA/ECB/PKCS1Padding";
    private static int[] KClassImpl$Data$declaredNonStaticMembers$2 = {-1635065987, 1931871840, 739983388, 1924885780, 102516859, -1637265171, 2048760017, -838430217, 245853021, 1518491267, -1819626235, -1763486686, 1235189999, 1341378006, 1019658765, 1681340107, 1289226605, 1403432025};
    private static int PlaceComponentResult = 1;
    private static final String TAG = "RSAHelper";
    private static int getAuthRequestContext;

    private RSAHelper() {
    }

    public static String encrypt(String str, String str2) {
        int i = PlaceComponentResult + 15;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            try {
                byte[] encrypt = encrypt(str, getPublicKey(str2));
                if (!(encrypt != null)) {
                    int i3 = getAuthRequestContext + 121;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                    InstrumentInjector.log_e("RSAHelper", "encrypt with empty input");
                    return null;
                }
                return new String(Base64.encode(encrypt, 2));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                try {
                    InstrumentInjector.log_e("RSAHelper", "", e);
                    int i5 = PlaceComponentResult + 87;
                    getAuthRequestContext = i5 % 128;
                    int i6 = i5 % 2;
                    return null;
                } catch (Exception e2) {
                    throw e2;
                }
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        if ((!r1 ? '+' : '_') != '_') goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        if ((!r6.equals("")) != true) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
    
        r2 = new java.lang.Object[1];
        a(5 - android.graphics.Color.red(0), new int[]{2002917620, -1541761603, -1385185682, -1222966000}, r2);
        r6 = encryptBytes(r6.getBytes(java.nio.charset.Charset.forName(((java.lang.String) r2[0]).intern())), r7);
        r7 = com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext + 15;
        com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] encrypt(java.lang.String r6, java.security.PublicKey r7) {
        /*
            int r0 = com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult
            int r0 = r0 + 115
            int r1 = r0 % 128
            com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext = r1
            int r0 = r0 % 2
            r0 = 0
            if (r6 == 0) goto L77
            int r1 = com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext
            int r1 = r1 + 79
            int r2 = r1 % 128
            com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult = r2
            int r1 = r1 % 2
            r2 = 51
            if (r1 != 0) goto L1e
            r1 = 73
            goto L20
        L1e:
            r1 = 51
        L20:
            java.lang.String r3 = ""
            r4 = 1
            r5 = 0
            if (r1 == r2) goto L3b
            boolean r1 = r6.equals(r3)
            r0.hashCode()     // Catch: java.lang.Throwable -> L39
            r2 = 95
            if (r1 != 0) goto L34
            r1 = 43
            goto L36
        L34:
            r1 = 95
        L36:
            if (r1 == r2) goto L77
            goto L47
        L39:
            r6 = move-exception
            throw r6
        L3b:
            boolean r1 = r6.equals(r3)
            if (r1 != 0) goto L43
            r1 = 1
            goto L44
        L43:
            r1 = 0
        L44:
            if (r1 == r4) goto L47
            goto L77
        L47:
            int r0 = android.graphics.Color.red(r5)
            int r0 = 5 - r0
            r1 = 4
            int[] r1 = new int[r1]
            r1 = {x0078: FILL_ARRAY_DATA , data: [2002917620, -1541761603, -1385185682, -1222966000} // fill-array
            java.lang.Object[] r2 = new java.lang.Object[r4]
            a(r0, r1, r2)
            r0 = r2[r5]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)
            byte[] r6 = r6.getBytes(r0)
            byte[] r6 = encryptBytes(r6, r7)
            int r7 = com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext
            int r7 = r7 + 15
            int r0 = r7 % 128
            com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult = r0
            int r7 = r7 % 2
            return r6
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.common.utils.security.RSAHelper.encrypt(java.lang.String, java.security.PublicKey):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r4 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:
    
        if (r4 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001d, code lost:
    
        if (r5 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0022, code lost:
    
        if (r0 == true) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:
    
        r0 = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r0.init(1, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        return r0.doFinal(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0038, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003d, code lost:
    
        com.fullstory.instrumentation.InstrumentInjector.log_e("RSAHelper", "", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0042, code lost:
    
        r4 = com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult + 61;
        com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004c, code lost:
    
        if ((r4 % 2) == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004f, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0050, code lost:
    
        if (r1 != true) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0052, code lost:
    
        r4 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0053, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0056, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] encryptBytes(byte[] r4, java.security.PublicKey r5) {
        /*
            int r0 = com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext     // Catch: java.lang.Exception -> L5b
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L59
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L17
            if (r4 != 0) goto L1d
            goto L1c
        L17:
            r3.hashCode()     // Catch: java.lang.Throwable -> L57
            if (r4 != 0) goto L1d
        L1c:
            return r3
        L1d:
            if (r5 != 0) goto L21
            r0 = 1
            goto L22
        L21:
            r0 = 0
        L22:
            if (r0 == r2) goto L56
            java.lang.String r0 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r0 = javax.crypto.Cipher.getInstance(r0)     // Catch: javax.crypto.IllegalBlockSizeException -> L32 javax.crypto.BadPaddingException -> L34 java.security.InvalidKeyException -> L36 javax.crypto.NoSuchPaddingException -> L38 java.security.NoSuchAlgorithmException -> L3a
            r0.init(r2, r5)     // Catch: javax.crypto.IllegalBlockSizeException -> L32 javax.crypto.BadPaddingException -> L34 java.security.InvalidKeyException -> L36 javax.crypto.NoSuchPaddingException -> L38 java.security.NoSuchAlgorithmException -> L3a
            byte[] r4 = r0.doFinal(r4)     // Catch: javax.crypto.IllegalBlockSizeException -> L32 javax.crypto.BadPaddingException -> L34 java.security.InvalidKeyException -> L36 javax.crypto.NoSuchPaddingException -> L38 java.security.NoSuchAlgorithmException -> L3a
            return r4
        L32:
            r4 = move-exception
            goto L3b
        L34:
            r4 = move-exception
            goto L3b
        L36:
            r4 = move-exception
            goto L3b
        L38:
            r4 = move-exception
            goto L3b
        L3a:
            r4 = move-exception
        L3b:
            java.lang.String r5 = "RSAHelper"
            java.lang.String r0 = ""
            com.fullstory.instrumentation.InstrumentInjector.log_e(r5, r0, r4)     // Catch: java.lang.Exception -> L59
            int r4 = com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult
            int r4 = r4 + 61
            int r5 = r4 % 128
            com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L4f
            goto L50
        L4f:
            r1 = 1
        L50:
            if (r1 == r2) goto L56
            int r4 = r3.length     // Catch: java.lang.Throwable -> L54
            return r3
        L54:
            r4 = move-exception
            throw r4
        L56:
            return r3
        L57:
            r4 = move-exception
            throw r4
        L59:
            r4 = move-exception
            throw r4
        L5b:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.common.utils.security.RSAHelper.encryptBytes(byte[], java.security.PublicKey):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        if ((r7 == null) != true) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        if (r7.equals("") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        r4 = new java.lang.Object[1];
        a(6 - (android.os.SystemClock.currentThreadTimeMillis() > (-1) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1) ? 0 : -1)), new int[]{2002917620, -1541761603, -1385185682, -1222966000}, r4);
        r7 = decryptBytes(r7.getBytes(java.nio.charset.Charset.forName(((java.lang.String) r4[0]).intern())), r8);
        r8 = com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext + 43;
        com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        if ((r8 % 2) != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
    
        if (r8 == true) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
    
        r8 = 26 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if ((r7 != null) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] decrypt(java.lang.String r7, java.security.PrivateKey r8) {
        /*
            int r0 = com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult
            int r0 = r0 + 65
            int r1 = r0 % 128
            com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L1a
            int r0 = r1.length     // Catch: java.lang.Throwable -> L18
            if (r7 == 0) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L6a
            goto L21
        L18:
            r7 = move-exception
            throw r7
        L1a:
            if (r7 == 0) goto L1e
            r0 = 0
            goto L1f
        L1e:
            r0 = 1
        L1f:
            if (r0 == r3) goto L6a
        L21:
            java.lang.String r0 = ""
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L6a
            long r0 = android.os.SystemClock.currentThreadTimeMillis()
            r4 = -1
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            int r0 = 6 - r6
            r1 = 4
            int[] r1 = new int[r1]
            r1 = {x006c: FILL_ARRAY_DATA , data: [2002917620, -1541761603, -1385185682, -1222966000} // fill-array
            java.lang.Object[] r4 = new java.lang.Object[r3]
            a(r0, r1, r4)
            r0 = r4[r2]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)
            byte[] r7 = r7.getBytes(r0)
            byte[] r7 = decryptBytes(r7, r8)
            int r8 = com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext
            int r8 = r8 + 43
            int r0 = r8 % 128
            com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult = r0
            int r8 = r8 % 2
            if (r8 != 0) goto L60
            r8 = 1
            goto L61
        L60:
            r8 = 0
        L61:
            if (r8 == r3) goto L64
            return r7
        L64:
            r8 = 26
            int r8 = r8 / r2
            return r7
        L68:
            r7 = move-exception
            throw r7
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.common.utils.security.RSAHelper.decrypt(java.lang.String, java.security.PrivateKey):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        if ((r4 == null ? ':' : '*') != ':') goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        if (r5 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        r4 = com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext + 71;
        com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if ((r4 % 2) != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        r0 = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r0.init(2, r5);
        r4 = r0.doFinal(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        r5 = com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext + 45;
        com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        r4 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
    
        r4 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0051, code lost:
    
        r4 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
    
        r4 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0055, code lost:
    
        r4 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0058, code lost:
    
        com.fullstory.instrumentation.InstrumentInjector.log_e("RSAHelper", "", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005e, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005f, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0060, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0061, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0062, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (r4 == null) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] decryptBytes(byte[] r4, java.security.PrivateKey r5) {
        /*
            int r0 = com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext
            int r0 = r0 + 119
            int r1 = r0 % 128
            com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            if (r0 != 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            r3 = 0
            if (r0 == r2) goto L16
            if (r4 != 0) goto L22
            goto L62
        L16:
            int r0 = r3.length     // Catch: java.lang.Throwable -> L63
            r0 = 58
            if (r4 != 0) goto L1e
            r2 = 58
            goto L20
        L1e:
            r2 = 42
        L20:
            if (r2 == r0) goto L62
        L22:
            if (r5 != 0) goto L36
            int r4 = com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext
            int r4 = r4 + 71
            int r5 = r4 % 128
            com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult = r5
            int r4 = r4 % r1
            if (r4 != 0) goto L35
            r3.hashCode()     // Catch: java.lang.Throwable -> L33
            return r3
        L33:
            r4 = move-exception
            throw r4
        L35:
            return r3
        L36:
            java.lang.String r0 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r0 = javax.crypto.Cipher.getInstance(r0)     // Catch: javax.crypto.IllegalBlockSizeException -> L4d javax.crypto.BadPaddingException -> L4f java.security.InvalidKeyException -> L51 javax.crypto.NoSuchPaddingException -> L53 java.security.NoSuchAlgorithmException -> L55
            r0.init(r1, r5)     // Catch: javax.crypto.IllegalBlockSizeException -> L4d javax.crypto.BadPaddingException -> L4f java.security.InvalidKeyException -> L51 javax.crypto.NoSuchPaddingException -> L53 java.security.NoSuchAlgorithmException -> L55
            byte[] r4 = r0.doFinal(r4)     // Catch: javax.crypto.IllegalBlockSizeException -> L4d javax.crypto.BadPaddingException -> L4f java.security.InvalidKeyException -> L51 javax.crypto.NoSuchPaddingException -> L53 java.security.NoSuchAlgorithmException -> L55
            int r5 = com.alipay.iap.android.common.utils.security.RSAHelper.getAuthRequestContext     // Catch: java.lang.Exception -> L60
            int r5 = r5 + 45
            int r0 = r5 % 128
            com.alipay.iap.android.common.utils.security.RSAHelper.PlaceComponentResult = r0     // Catch: java.lang.Exception -> L60
            int r5 = r5 % r1
            return r4
        L4d:
            r4 = move-exception
            goto L56
        L4f:
            r4 = move-exception
            goto L56
        L51:
            r4 = move-exception
            goto L56
        L53:
            r4 = move-exception
            goto L56
        L55:
            r4 = move-exception
        L56:
            java.lang.String r5 = "RSAHelper"
            java.lang.String r0 = ""
            com.fullstory.instrumentation.InstrumentInjector.log_e(r5, r0, r4)     // Catch: java.lang.Exception -> L5e
            return r3
        L5e:
            r4 = move-exception
            throw r4
        L60:
            r4 = move-exception
            throw r4
        L62:
            return r3
        L63:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.common.utils.security.RSAHelper.decryptBytes(byte[], java.security.PrivateKey):byte[]");
    }

    private static PublicKey getPublicKey(String str) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        int i = getAuthRequestContext + 15;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return generatePublic;
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        int length;
        int[] iArr2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        int i4 = 2;
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (iArr3 != null) {
            try {
                int i5 = $10 + 77;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                int length2 = iArr3.length;
                int[] iArr4 = new int[length2];
                int i7 = 0;
                while (true) {
                    if ((i7 < length2 ? Typography.less : ':') != '<') {
                        break;
                    }
                    iArr4[i7] = (int) (iArr3[i7] ^ (-3152031022165484798L));
                    i7++;
                    i4 = 2;
                }
                iArr3 = iArr4;
            } catch (Exception e) {
                throw e;
            }
        }
        int length3 = iArr3.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (iArr6 != null) {
            int i8 = $11 + 77;
            $10 = i8 % 128;
            if (i8 % i4 != 0) {
                length = iArr6.length;
                iArr2 = new int[length];
            } else {
                length = iArr6.length;
                iArr2 = new int[length];
            }
            int i9 = 0;
            while (i9 < length) {
                int i10 = $11 + 69;
                $10 = i10 % 128;
                if (i10 % i4 != 0) {
                    i3 = length3;
                    iArr2[i9] = (int) (iArr6[i9] - 3152031022165484798L);
                    i9 >>= 0;
                } else {
                    i3 = length3;
                    iArr2[i9] = (int) (iArr6[i9] ^ (-3152031022165484798L));
                    i9++;
                }
                length3 = i3;
                i4 = 2;
            }
            iArr6 = iArr2;
            i2 = length3;
        } else {
            i2 = length3;
        }
        System.arraycopy(iArr6, 0, iArr5, 0, i2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            int i11 = $10 + 97;
            $11 = i11 % 128;
            int i12 = i11 % 2;
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
            for (int i13 = 0; i13 < 16; i13++) {
                int i14 = $10 + 123;
                $11 = i14 % 128;
                int i15 = i14 % 2;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[i13];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i16;
            }
            try {
                int i17 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i17;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr5[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[17];
                int i18 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i19 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}

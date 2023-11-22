package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.Typography;
import o.A;

/* loaded from: classes8.dex */
public final class AesCbc {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int MyBillsEntityDataFactory = 269894810;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;

    private AesCbc() {
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            int i = getAuthRequestContext + 89;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            b.PlaceComponentResult("CBC", "encrypt 5 content is null");
            return new byte[0];
        } else if (bArr == null) {
            b.PlaceComponentResult("CBC", "encrypt 5 key is null");
            return new byte[0];
        } else {
            if (bArr.length < 16) {
                int i3 = PlaceComponentResult + 71;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                b.PlaceComponentResult("CBC", "encrypt 5 key lengh is not right");
                return new byte[0];
            } else if (bArr2 == null) {
                b.PlaceComponentResult("CBC", "encrypt 5 iv is null");
                return new byte[0];
            } else if (bArr2.length < 16) {
                int i5 = getAuthRequestContext + 103;
                PlaceComponentResult = i5 % 128;
                boolean z = i5 % 2 == 0;
                b.PlaceComponentResult("CBC", "encrypt 5 iv lengh is not right");
                return !z ? new byte[1] : new byte[0];
            } else {
                try {
                    Object[] objArr = new Object[1];
                    a(new char[]{17, 16, 2, 65513, 65524}, KeyEvent.normalizeMetaState(0) + DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 5, false, TextUtils.getOffsetAfter("", 0) + 5, objArr);
                    return PlaceComponentResult(str.getBytes(((String) objArr[0]).intern()), bArr, bArr2);
                } catch (UnsupportedEncodingException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" cbc encrypt data error");
                    sb.append(e.getMessage());
                    b.PlaceComponentResult("CBC", sb.toString());
                    return new byte[0];
                }
            }
        }
    }

    public static String PlaceComponentResult(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if ((TextUtils.isEmpty(str2) ? '\b' : '[') != '\b') {
                    byte[] authRequestContext = HexUtil.getAuthRequestContext(str2);
                    if (authRequestContext.length < 16) {
                        b.PlaceComponentResult("CBC", "decrypt 1 key length is not right");
                        return "";
                    }
                    return PlaceComponentResult(str, authRequestContext);
                }
                int i = PlaceComponentResult + 85;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                b.PlaceComponentResult("CBC", "decrypt 1 key is null");
                return "";
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = getAuthRequestContext + 97;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        b.PlaceComponentResult("CBC", "decrypt 1 content is null");
        return "";
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        try {
            int i = PlaceComponentResult + 75;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            if (!(TextUtils.isEmpty(str))) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.substring(6, 12));
                    sb.append(str.substring(16, 26));
                    sb.append(str.substring(32, 48));
                    return sb.toString();
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getIv exception : ");
                    sb2.append(e.getMessage());
                    b.PlaceComponentResult("CBC", sb2.toString());
                    return "";
                }
            }
            int i3 = getAuthRequestContext + 89;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 27 : '2') == 27) {
                Object obj = null;
                obj.hashCode();
            }
            return "";
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if ((r0) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r6)) != true) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("CBC", "encrypt 1 content is null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        if (android.text.TextUtils.isEmpty(r7) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("CBC", "encrypt 1 key is null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        r7 = com.huawei.secure.android.common.encrypt.utils.HexUtil.getAuthRequestContext(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
    
        if (r7.length >= 16) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004f, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:
    
        if (r1 == true) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0056, code lost:
    
        return getAuthRequestContext(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0057, code lost:
    
        r6 = com.huawei.secure.android.common.encrypt.aes.AesCbc.getAuthRequestContext + 121;
        com.huawei.secure.android.common.encrypt.aes.AesCbc.PlaceComponentResult = r6 % 128;
        r6 = r6 % 2;
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("CBC", "encrypt 1 key length is not right");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0067, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0068, code lost:
    
        throw r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String BuiltInFictitiousFunctionClassFactory(java.lang.String r6, java.lang.String r7) {
        /*
            int r0 = com.huawei.secure.android.common.encrypt.aes.AesCbc.PlaceComponentResult
            int r0 = r0 + 95
            int r1 = r0 % 128
            com.huawei.secure.android.common.encrypt.aes.AesCbc.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            java.lang.String r3 = ""
            java.lang.String r4 = "CBC"
            if (r0 == 0) goto L29
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L23
            r0 = 1
            goto L24
        L23:
            r0 = 0
        L24:
            if (r0 == 0) goto L3a
            goto L34
        L27:
            r6 = move-exception
            throw r6
        L29:
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> L69
            if (r0 == 0) goto L31
            r0 = 0
            goto L32
        L31:
            r0 = 1
        L32:
            if (r0 == r2) goto L3a
        L34:
            java.lang.String r6 = "encrypt 1 content is null"
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r4, r6)
            return r3
        L3a:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L46
            java.lang.String r6 = "encrypt 1 key is null"
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r4, r6)
            return r3
        L46:
            byte[] r7 = com.huawei.secure.android.common.encrypt.utils.HexUtil.getAuthRequestContext(r7)     // Catch: java.lang.Exception -> L67
            int r0 = r7.length
            r5 = 16
            if (r0 >= r5) goto L50
            r1 = 1
        L50:
            if (r1 == r2) goto L57
            java.lang.String r6 = getAuthRequestContext(r6, r7)
            return r6
        L57:
            int r6 = com.huawei.secure.android.common.encrypt.aes.AesCbc.getAuthRequestContext
            int r6 = r6 + 121
            int r7 = r6 % 128
            com.huawei.secure.android.common.encrypt.aes.AesCbc.PlaceComponentResult = r7
            int r6 = r6 % 2
            java.lang.String r6 = "encrypt 1 key length is not right"
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r4, r6)
            return r3
        L67:
            r6 = move-exception
            throw r6
        L69:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.aes.AesCbc.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String PlaceComponentResult(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            int i = getAuthRequestContext + 17;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? 'K' : '!') != 'K') {
                b.PlaceComponentResult("CBC", "decrypt 2 content is null");
                return "";
            }
            b.PlaceComponentResult("CBC", "decrypt 2 content is null");
            Object obj = null;
            obj.hashCode();
            return "";
        }
        if (bArr == null) {
            b.PlaceComponentResult("CBC", "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            try {
                b.PlaceComponentResult("CBC", "decrypt 2 key lengh is not right");
                int i2 = getAuthRequestContext + 65;
                PlaceComponentResult = i2 % 128;
                int i3 = i2 % 2;
                return "";
            } catch (Exception e) {
                throw e;
            }
        }
        String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str);
        String PlaceComponentResult2 = PlaceComponentResult(str);
        if (TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$2)) {
            try {
                b.PlaceComponentResult("CBC", "decrypt 2 iv is null");
                return "";
            } catch (Exception e2) {
                throw e2;
            }
        } else if (TextUtils.isEmpty(PlaceComponentResult2)) {
            b.PlaceComponentResult("CBC", "decrypt 2 encrypt content is null");
            return "";
        } else {
            return getAuthRequestContext(PlaceComponentResult2, bArr, HexUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    public static String getAuthRequestContext(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            int i = getAuthRequestContext + 117;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            b.PlaceComponentResult("CBC", "encrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            b.PlaceComponentResult("CBC", "encrypt 2 key is null");
            int i3 = getAuthRequestContext + 109;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return "";
        } else {
            if (bArr.length < 16) {
                try {
                    b.PlaceComponentResult("CBC", "encrypt 2 key lengh is not right");
                    int i5 = getAuthRequestContext + 85;
                    PlaceComponentResult = i5 % 128;
                    if (i5 % 2 != 0) {
                        int i6 = 17 / 0;
                        return "";
                    }
                    return "";
                } catch (Exception e) {
                    throw e;
                }
            }
            try {
                byte[] authRequestContext = EncryptUtil.getAuthRequestContext(16);
                byte[] KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, bArr, authRequestContext);
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    int i7 = getAuthRequestContext + 125;
                    PlaceComponentResult = i7 % 128;
                    int i8 = i7 % 2;
                    if ((KClassImpl$Data$declaredNonStaticMembers$2.length != 0 ? (char) 28 : '.') != '.') {
                        int i9 = getAuthRequestContext + 29;
                        PlaceComponentResult = i9 % 128;
                        int i10 = i9 % 2;
                        return KClassImpl$Data$declaredNonStaticMembers$2(HexUtil.getAuthRequestContext(authRequestContext), HexUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2));
                    }
                }
                return "";
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((android.text.TextUtils.isEmpty(r4)) != true) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        if (r0 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r0 == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r4, java.lang.String r5) {
        /*
            int r0 = com.huawei.secure.android.common.encrypt.aes.AesCbc.PlaceComponentResult
            int r0 = r0 + 117
            int r1 = r0 % 128
            com.huawei.secure.android.common.encrypt.aes.AesCbc.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L1b
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L18
            int r3 = r1.length     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto La9
            goto L27
        L16:
            r4 = move-exception
            throw r4
        L18:
            r4 = move-exception
            goto Lb8
        L1b:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r3 = 1
            if (r0 != 0) goto L24
            r0 = 0
            goto L25
        L24:
            r0 = 1
        L25:
            if (r0 == r3) goto La9
        L27:
            int r0 = com.huawei.secure.android.common.encrypt.aes.AesCbc.getAuthRequestContext
            int r0 = r0 + 21
            int r3 = r0 % 128
            com.huawei.secure.android.common.encrypt.aes.AesCbc.PlaceComponentResult = r3
            int r0 = r0 % 2
            r3 = 80
            if (r0 == 0) goto L38
            r0 = 51
            goto L3a
        L38:
            r0 = 80
        L3a:
            if (r0 == r3) goto L48
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1.hashCode()     // Catch: java.lang.Throwable -> L46
            if (r0 != 0) goto La9
            goto L4e
        L46:
            r4 = move-exception
            throw r4
        L48:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto La9
        L4e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L8e
            r0.<init>()     // Catch: java.lang.Exception -> L8e
            r1 = 6
            java.lang.String r3 = r5.substring(r2, r1)     // Catch: java.lang.Exception -> L8e
            r0.append(r3)     // Catch: java.lang.Exception -> L8e
            java.lang.String r2 = r4.substring(r2, r1)     // Catch: java.lang.Exception -> L8e
            r0.append(r2)     // Catch: java.lang.Exception -> L8e
            r2 = 10
            java.lang.String r3 = r5.substring(r1, r2)     // Catch: java.lang.Exception -> L8e
            r0.append(r3)     // Catch: java.lang.Exception -> L8e
            r3 = 16
            java.lang.String r1 = r4.substring(r1, r3)     // Catch: java.lang.Exception -> L8e
            r0.append(r1)     // Catch: java.lang.Exception -> L8e
            java.lang.String r1 = r5.substring(r2, r3)     // Catch: java.lang.Exception -> L8e
            r0.append(r1)     // Catch: java.lang.Exception -> L8e
            java.lang.String r4 = r4.substring(r3)     // Catch: java.lang.Exception -> L8e
            r0.append(r4)     // Catch: java.lang.Exception -> L8e
            java.lang.String r4 = r5.substring(r3)     // Catch: java.lang.Exception -> L8e
            r0.append(r4)     // Catch: java.lang.Exception -> L8e
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Exception -> L8e
            return r4
        L8e:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "mix exception: "
            r5.append(r0)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "CBC"
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r5, r4)
        La9:
            int r4 = com.huawei.secure.android.common.encrypt.aes.AesCbc.PlaceComponentResult     // Catch: java.lang.Exception -> L18
            int r4 = r4 + 117
            int r5 = r4 % 128
            com.huawei.secure.android.common.encrypt.aes.AesCbc.getAuthRequestContext = r5     // Catch: java.lang.Exception -> Lb6
            int r4 = r4 % 2
            java.lang.String r4 = ""
            return r4
        Lb6:
            r4 = move-exception
            throw r4
        Lb8:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.aes.AesCbc.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String, java.lang.String):java.lang.String");
    }

    private static byte[] MyBillsEntityDataFactory(byte[] bArr, byte[] bArr2) {
        int i = PlaceComponentResult + 49;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        try {
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            int i3 = PlaceComponentResult + 119;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return bArr3;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r5)) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(r5.substring(0, 6));
        r0.append(r5.substring(12, 16));
        r0.append(r5.substring(26, 32));
        r0.append(r5.substring(48));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        return r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("get encryptword exception : ");
        r0.append(r5.getMessage());
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult("CBC", r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
    
        r5 = com.huawei.secure.android.common.encrypt.aes.AesCbc.getAuthRequestContext + 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
    
        com.huawei.secure.android.common.encrypt.aes.AesCbc.PlaceComponentResult = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
    
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0083, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0086, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if ((android.text.TextUtils.isEmpty(r5) ? ')' : 2) != 2) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String PlaceComponentResult(java.lang.String r5) {
        /*
            int r0 = com.huawei.secure.android.common.encrypt.aes.AesCbc.getAuthRequestContext
            int r0 = r0 + 53
            int r1 = r0 % 128
            com.huawei.secure.android.common.encrypt.aes.AesCbc.PlaceComponentResult = r1
            r1 = 2
            int r0 = r0 % r1
            java.lang.String r2 = ""
            r3 = 0
            if (r0 == 0) goto L21
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r4 = 96
            int r4 = r4 / r3
            if (r0 == 0) goto L1b
            r0 = 41
            goto L1c
        L1b:
            r0 = 2
        L1c:
            if (r0 == r1) goto L2c
            goto L79
        L1f:
            r5 = move-exception
            throw r5
        L21:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L29
            r0 = 0
            goto L2a
        L29:
            r0 = 1
        L2a:
            if (r0 == 0) goto L79
        L2c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5d
            r0.<init>()     // Catch: java.lang.Exception -> L5d
            r1 = 6
            java.lang.String r1 = r5.substring(r3, r1)     // Catch: java.lang.Exception -> L5d
            r0.append(r1)     // Catch: java.lang.Exception -> L5d
            r1 = 12
            r3 = 16
            java.lang.String r1 = r5.substring(r1, r3)     // Catch: java.lang.Exception -> L5d
            r0.append(r1)     // Catch: java.lang.Exception -> L5d
            r1 = 26
            r3 = 32
            java.lang.String r1 = r5.substring(r1, r3)     // Catch: java.lang.Exception -> L5d
            r0.append(r1)     // Catch: java.lang.Exception -> L5d
            r1 = 48
            java.lang.String r5 = r5.substring(r1)     // Catch: java.lang.Exception -> L5d
            r0.append(r5)     // Catch: java.lang.Exception -> L5d
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Exception -> L5d
            return r5
        L5d:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "get encryptword exception : "
            r0.append(r1)
            java.lang.String r5 = r5.getMessage()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "CBC"
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r0, r5)
            return r2
        L79:
            int r5 = com.huawei.secure.android.common.encrypt.aes.AesCbc.getAuthRequestContext     // Catch: java.lang.Exception -> L85
            int r5 = r5 + 9
            int r0 = r5 % 128
            com.huawei.secure.android.common.encrypt.aes.AesCbc.PlaceComponentResult = r0     // Catch: java.lang.Exception -> L83
            int r5 = r5 % r1
            return r2
        L83:
            r5 = move-exception
            throw r5
        L85:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.aes.AesCbc.PlaceComponentResult(java.lang.String):java.lang.String");
    }

    private static String getAuthRequestContext(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            int i = getAuthRequestContext + 83;
            PlaceComponentResult = i % 128;
            if (i % 2 != 0) {
                b.PlaceComponentResult("CBC", "decrypt 4 content is null");
                Object obj = null;
                obj.hashCode();
                return "";
            }
            b.PlaceComponentResult("CBC", "decrypt 4 content is null");
            return "";
        }
        if ((bArr == null ? '(' : Typography.greater) == '(') {
            b.PlaceComponentResult("CBC", "decrypt 4 key is null");
            int i2 = getAuthRequestContext + 105;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            return "";
        } else if (bArr.length < 16) {
            b.PlaceComponentResult("CBC", "decrypt 4 key lengh is not right");
            return "";
        } else {
            if ((bArr2 == null ? (char) 24 : '^') == 24) {
                b.PlaceComponentResult("CBC", "decrypt 4 iv is null");
                return "";
            } else if (bArr2.length < 16) {
                b.PlaceComponentResult("CBC", "decrypt 4 iv lengh is not right");
                return "";
            } else {
                try {
                    byte[] authRequestContext = getAuthRequestContext(HexUtil.getAuthRequestContext(str), bArr, bArr2);
                    Object[] objArr = new Object[1];
                    a(new char[]{17, 16, 2, 65513, 65524}, ExpandableListView.getPackedPositionChild(0L) + DeepRecoverARiverProxy.TYPE_ENTITY_TA_PAGE, 6 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), false, 4 + (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr);
                    return new String(authRequestContext, ((String) objArr[0]).intern());
                } catch (UnsupportedEncodingException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" cbc decrypt data error");
                    sb.append(e.getMessage());
                    b.PlaceComponentResult("CBC", sb.toString());
                    return "";
                }
            }
        }
    }

    private static byte[] PlaceComponentResult(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (!(bArr != null)) {
            b.PlaceComponentResult("CBC", "encrypt 6 content is null");
            byte[] bArr4 = new byte[0];
            int i = getAuthRequestContext + 93;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return bArr4;
        } else if (bArr.length == 0) {
            int i3 = getAuthRequestContext + 91;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 == 0) {
                b.PlaceComponentResult("CBC", "encrypt 6 content length is 0");
                return new byte[0];
            }
            b.PlaceComponentResult("CBC", "encrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            int i4 = getAuthRequestContext + 5;
            PlaceComponentResult = i4 % 128;
            int i5 = i4 % 2;
            b.PlaceComponentResult("CBC", "encrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            try {
                b.PlaceComponentResult("CBC", "encrypt 6 key length is error");
                return new byte[0];
            } catch (Exception e) {
                throw e;
            }
        } else {
            if ((bArr3 == null ? 'A' : 'C') != 'C') {
                b.PlaceComponentResult("CBC", "encrypt 6 iv is null");
                return new byte[0];
            } else if (bArr3.length < 16) {
                try {
                    int i6 = getAuthRequestContext + 79;
                    PlaceComponentResult = i6 % 128;
                    if (i6 % 2 != 0) {
                        b.PlaceComponentResult("CBC", "encrypt 6 iv length is error");
                        return new byte[0];
                    }
                    b.PlaceComponentResult("CBC", "encrypt 6 iv length is error");
                    return new byte[0];
                } catch (Exception e2) {
                    throw e2;
                }
            } else {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, SecureKeyStorageProvider.ALGORITHM);
                try {
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                    return cipher.doFinal(bArr);
                } catch (InvalidAlgorithmParameterException e3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("InvalidAlgorithmParameterException: ");
                    sb.append(e3.getMessage());
                    b.PlaceComponentResult("CBC", sb.toString());
                    return new byte[0];
                } catch (InvalidKeyException e4) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("InvalidKeyException: ");
                    sb2.append(e4.getMessage());
                    b.PlaceComponentResult("CBC", sb2.toString());
                    return new byte[0];
                } catch (NoSuchAlgorithmException e5) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("NoSuchAlgorithmException: ");
                    sb3.append(e5.getMessage());
                    b.PlaceComponentResult("CBC", sb3.toString());
                    return new byte[0];
                } catch (BadPaddingException e6) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("BadPaddingException: ");
                    sb4.append(e6.getMessage());
                    b.PlaceComponentResult("CBC", sb4.toString());
                    return new byte[0];
                } catch (IllegalBlockSizeException e7) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("IllegalBlockSizeException: ");
                    sb5.append(e7.getMessage());
                    b.PlaceComponentResult("CBC", sb5.toString());
                    return new byte[0];
                } catch (NoSuchPaddingException e8) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("NoSuchPaddingException: ");
                    sb6.append(e8.getMessage());
                    b.PlaceComponentResult("CBC", sb6.toString());
                    return new byte[0];
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:57:0x0140
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static byte[] getAuthRequestContext(byte[] r6, byte[] r7, byte[] r8) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.aes.AesCbc.getAuthRequestContext(byte[], byte[], byte[]):byte[]");
    }

    public static byte[] BuiltInFictitiousFunctionClassFactory(byte[] bArr, byte[] bArr2) {
        int i = PlaceComponentResult + 119;
        getAuthRequestContext = i % 128;
        try {
            if ((i % 2 == 0 ? (char) 20 : '.') != 20) {
                byte[] authRequestContext = EncryptUtil.getAuthRequestContext(16);
                return MyBillsEntityDataFactory(authRequestContext, PlaceComponentResult(bArr, bArr2, authRequestContext));
            }
            try {
                byte[] authRequestContext2 = EncryptUtil.getAuthRequestContext(11);
                return MyBillsEntityDataFactory(authRequestContext2, PlaceComponentResult(bArr, bArr2, authRequestContext2));
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if (a2.MyBillsEntityDataFactory >= i2) {
                break;
            }
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (!(i3 <= 0)) {
            int i5 = $11 + 65;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            int i7 = $11 + 87;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i2) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
                try {
                    int i9 = $10 + 63;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}

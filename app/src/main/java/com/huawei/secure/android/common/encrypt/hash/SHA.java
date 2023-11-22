package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes8.dex */
public final class SHA {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String[] BuiltInFictitiousFunctionClassFactory;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static char[] PlaceComponentResult = null;
    private static final String getAuthRequestContext = "SHA";

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        BuiltInFictitiousFunctionClassFactory = new String[]{"SHA-256", "SHA-384", "SHA-512"};
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 39;
            try {
                MyBillsEntityDataFactory = i % 128;
                if (!(i % 2 == 0)) {
                    return;
                }
                int i2 = 16 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private SHA() {
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult = new char[]{35458, 35500, 35495, 35539, 35530};
    }

    private static boolean MyBillsEntityDataFactory(String str) {
        String[] strArr;
        int length;
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
            try {
                MyBillsEntityDataFactory = i % 128;
                if (i % 2 == 0) {
                    strArr = BuiltInFictitiousFunctionClassFactory;
                    length = strArr.length;
                } else {
                    strArr = BuiltInFictitiousFunctionClassFactory;
                    length = strArr.length;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        return false;
                    }
                    int i3 = MyBillsEntityDataFactory + 53;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    if ((strArr[i2].equals(str) ? '8' : '\n') == '8') {
                        int i5 = MyBillsEntityDataFactory + 81;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                        int i6 = i5 % 2;
                        return true;
                    }
                    i2++;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static String PlaceComponentResult(String str) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            String authRequestContext = getAuthRequestContext(str, "SHA-256");
            try {
                int i3 = MyBillsEntityDataFactory + 33;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? 'G' : ';') != ';') {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return authRequestContext;
                }
                return authRequestContext;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String getAuthRequestContext(String str, String str2) {
        byte[] bArr;
        if (!TextUtils.isEmpty(str)) {
            int i = MyBillsEntityDataFactory + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            if (!TextUtils.isEmpty(str2)) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                if (!MyBillsEntityDataFactory(str2)) {
                    b.PlaceComponentResult(getAuthRequestContext, "algorithm is not safe or legal");
                    return "";
                }
                try {
                    Object[] objArr = new Object[1];
                    a(new int[]{0, 5, 0, 0}, true, new byte[]{0, 1, 1, 0, 1}, objArr);
                    bArr = str.getBytes(((String) objArr[0]).intern());
                } catch (UnsupportedEncodingException unused) {
                    bArr = new byte[0];
                    b.PlaceComponentResult(getAuthRequestContext, "Error in generate SHA UnsupportedEncodingException");
                }
                return HexUtil.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(bArr, str2));
            }
        }
        b.PlaceComponentResult(getAuthRequestContext, "content or algorithm is null.");
        int i5 = MyBillsEntityDataFactory + 107;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        if (i5 % 2 != 0) {
            Object[] objArr2 = null;
            int length = objArr2.length;
            return "";
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r4 == null) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        if (r4 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        r0 = com.huawei.secure.android.common.encrypt.hash.SHA.MyBillsEntityDataFactory + 99;
        com.huawei.secure.android.common.encrypt.hash.SHA.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        if ((r0 % 2) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        r0 = 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        r0 = 'R';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        if (r0 == 29) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        if (MyBillsEntityDataFactory(r5) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        r0 = MyBillsEntityDataFactory(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        if (r0 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(com.huawei.secure.android.common.encrypt.hash.SHA.getAuthRequestContext, "algorithm is not safe or legal");
        r4 = new byte[0];
        r5 = com.huawei.secure.android.common.encrypt.hash.SHA.KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        com.huawei.secure.android.common.encrypt.hash.SHA.MyBillsEntityDataFactory = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
    
        r5 = java.security.MessageDigest.getInstance(r5);
        r5.update(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        return r5.digest();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
    
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(com.huawei.secure.android.common.encrypt.hash.SHA.getAuthRequestContext, "Error in generate SHA NoSuchAlgorithmException");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        return new byte[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0079, code lost:
    
        com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(com.huawei.secure.android.common.encrypt.hash.SHA.getAuthRequestContext, "content or algorithm is null.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0082, code lost:
    
        return new byte[0];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] BuiltInFictitiousFunctionClassFactory(byte[] r4, java.lang.String r5) {
        /*
            int r0 = com.huawei.secure.android.common.encrypt.hash.SHA.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L85
            int r0 = r0 + 19
            int r1 = r0 % 128
            com.huawei.secure.android.common.encrypt.hash.SHA.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L85
            int r0 = r0 % 2
            r1 = 94
            if (r0 == 0) goto L11
            r0 = 94
            goto L13
        L11:
            r0 = 12
        L13:
            r2 = 0
            r3 = 0
            if (r0 == r1) goto L1f
            if (r4 == 0) goto L1b
            r0 = 0
            goto L1c
        L1b:
            r0 = 1
        L1c:
            if (r0 == 0) goto L22
            goto L79
        L1f:
            int r0 = r2.length     // Catch: java.lang.Throwable -> L83
            if (r4 == 0) goto L79
        L22:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L79
            int r0 = com.huawei.secure.android.common.encrypt.hash.SHA.MyBillsEntityDataFactory
            int r0 = r0 + 99
            int r1 = r0 % 128
            com.huawei.secure.android.common.encrypt.hash.SHA.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 29
            if (r0 == 0) goto L39
            r0 = 29
            goto L3b
        L39:
            r0 = 82
        L3b:
            if (r0 == r1) goto L44
            boolean r0 = MyBillsEntityDataFactory(r5)
            if (r0 != 0) goto L61
            goto L4d
        L44:
            boolean r0 = MyBillsEntityDataFactory(r5)
            r2.hashCode()     // Catch: java.lang.Throwable -> L77
            if (r0 != 0) goto L61
        L4d:
            java.lang.String r4 = com.huawei.secure.android.common.encrypt.hash.SHA.getAuthRequestContext
            java.lang.String r5 = "algorithm is not safe or legal"
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r4, r5)
            byte[] r4 = new byte[r3]
            int r5 = com.huawei.secure.android.common.encrypt.hash.SHA.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 33
            int r0 = r5 % 128
            com.huawei.secure.android.common.encrypt.hash.SHA.MyBillsEntityDataFactory = r0
            int r5 = r5 % 2
            return r4
        L61:
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch: java.security.NoSuchAlgorithmException -> L6d
            r5.update(r4)     // Catch: java.security.NoSuchAlgorithmException -> L6d
            byte[] r4 = r5.digest()     // Catch: java.security.NoSuchAlgorithmException -> L6d
            return r4
        L6d:
            java.lang.String r4 = com.huawei.secure.android.common.encrypt.hash.SHA.getAuthRequestContext
            java.lang.String r5 = "Error in generate SHA NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r4, r5)
            byte[] r4 = new byte[r3]
            return r4
        L77:
            r4 = move-exception
            throw r4
        L79:
            java.lang.String r4 = com.huawei.secure.android.common.encrypt.hash.SHA.getAuthRequestContext
            java.lang.String r5 = "content or algorithm is null."
            com.huawei.secure.android.common.encrypt.utils.b.PlaceComponentResult(r4, r5)
            byte[] r4 = new byte[r3]
            return r4
        L83:
            r4 = move-exception
            throw r4
        L85:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.hash.SHA.BuiltInFictitiousFunctionClassFactory(byte[], java.lang.String):byte[]");
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        int length;
        char[] cArr;
        int i;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        try {
            char[] cArr2 = PlaceComponentResult;
            if (cArr2 != null) {
                int i6 = $10 + 79;
                $11 = i6 % 128;
                if (i6 % 2 == 0) {
                    length = cArr2.length;
                    cArr = new char[length];
                    i = 1;
                } else {
                    length = cArr2.length;
                    cArr = new char[length];
                    i = 0;
                }
                while (i < length) {
                    cArr[i] = (char) (cArr2[i] ^ 5097613533456403102L);
                    i++;
                }
                cArr2 = cArr;
            }
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, i2, cArr3, 0, i3);
            if ((bArr != null ? (char) 19 : 'I') == 19) {
                char[] cArr4 = new char[i3];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (true) {
                    if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3 ? '%' : (char) 25) != '%') {
                        break;
                    }
                    try {
                        if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                        } else {
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                        }
                        c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                cArr3 = cArr4;
            }
            if (i5 > 0) {
                char[] cArr5 = new char[i3];
                System.arraycopy(cArr3, 0, cArr5, 0, i3);
                int i7 = i3 - i5;
                System.arraycopy(cArr5, 0, cArr3, i7, i5);
                System.arraycopy(cArr5, i5, cArr3, 0, i7);
            }
            if ((z ? 'D' : 'J') != 'J') {
                char[] cArr6 = new char[i3];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3) {
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i3 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            }
            if ((i4 > 0 ? (char) 29 : '/') == 29) {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (true) {
                    if (!(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3)) {
                        break;
                    }
                    int i8 = $10 + 73;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
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

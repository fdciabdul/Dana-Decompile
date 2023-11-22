package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes7.dex */
class j implements d {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    private static int[] getAuthRequestContext = {114054605, -187422591, -1224283426, 1733326641, -1594035162, -516117251, -1598568840, -618031596, -155617669, 2056602195, 1312782550, 2018379823, -107560164, -1367993400, -1628678688, -265042111, -2097121379, 593463862};
    private final Context MyBillsEntityDataFactory;
    private final String PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, String str) {
        this.MyBillsEntityDataFactory = context;
        this.PlaceComponentResult = str;
    }

    private static byte[] BuiltInFictitiousFunctionClassFactory(byte[] bArr) throws NoSuchAlgorithmException {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(bArr);
            int i3 = BuiltInFictitiousFunctionClassFactory + 35;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return digest;
        } catch (Exception e) {
            throw e;
        }
    }

    private static String getAuthRequestContext(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("agc_");
            Object[] objArr = new Object[1];
            a(5 - TextUtils.indexOf("", "", 0, 0), new int[]{-1601424567, 1632473306, 801279190, -2078640096}, objArr);
            sb.append(Hex.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(str.getBytes(((String) objArr[0]).intern()))));
            String obj = sb.toString();
            int i = BuiltInFictitiousFunctionClassFactory + 11;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 != 0) {
                Object[] objArr2 = null;
                int length = objArr2.length;
                return obj;
            }
            return obj;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if ((android.text.TextUtils.isEmpty(r6) ? 25 : 'I') != 'I') goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r6 = com.huawei.agconnect.config.impl.j.BuiltInFictitiousFunctionClassFactory + 83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        com.huawei.agconnect.config.impl.j.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        r6 = r5.MyBillsEntityDataFactory.getResources().getIdentifier(r6, "string", r5.PlaceComponentResult);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        if (r6 != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:
    
        if (r0 == true) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
    
        r6 = com.huawei.agconnect.config.impl.j.BuiltInFictitiousFunctionClassFactory + 69;
        com.huawei.agconnect.config.impl.j.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
        r6 = r6 % 2;
        r6 = com.huawei.agconnect.config.impl.j.KClassImpl$Data$declaredNonStaticMembers$2 + 29;
        com.huawei.agconnect.config.impl.j.BuiltInFictitiousFunctionClassFactory = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
    
        if ((r6 % 2) != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
    
        if (r2 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0073, code lost:
    
        r6 = 63 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0081, code lost:
    
        return r5.MyBillsEntityDataFactory.getResources().getString(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0082, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        if ((!r0) != false) goto L26;
     */
    @Override // com.huawei.agconnect.config.impl.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String BuiltInFictitiousFunctionClassFactory(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            int r0 = com.huawei.agconnect.config.impl.j.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 111
            int r1 = r0 % 128
            com.huawei.agconnect.config.impl.j.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            java.lang.String r6 = getAuthRequestContext(r6)
            if (r0 != 0) goto L24
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L22
            if (r0 == 0) goto L1e
            r0 = 0
            goto L1f
        L1e:
            r0 = 1
        L1f:
            if (r0 == 0) goto L33
            goto L42
        L22:
            r6 = move-exception
            throw r6
        L24:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r3 = 73
            if (r0 == 0) goto L2f
            r0 = 25
            goto L31
        L2f:
            r0 = 73
        L31:
            if (r0 == r3) goto L42
        L33:
            int r6 = com.huawei.agconnect.config.impl.j.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L40
            int r6 = r6 + 83
            int r0 = r6 % 128
            com.huawei.agconnect.config.impl.j.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L3e
            int r6 = r6 % 2
            return r7
        L3e:
            r6 = move-exception
            throw r6
        L40:
            r6 = move-exception
            throw r6
        L42:
            android.content.Context r0 = r5.MyBillsEntityDataFactory
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r3 = r5.PlaceComponentResult
            java.lang.String r4 = "string"
            int r6 = r0.getIdentifier(r6, r4, r3)
            if (r6 != 0) goto L54
            r0 = 0
            goto L55
        L54:
            r0 = 1
        L55:
            if (r0 == r2) goto L77
            int r6 = com.huawei.agconnect.config.impl.j.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 69
            int r0 = r6 % 128
            com.huawei.agconnect.config.impl.j.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r6 = r6 % 2
            int r6 = com.huawei.agconnect.config.impl.j.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 29
            int r0 = r6 % 128
            com.huawei.agconnect.config.impl.j.BuiltInFictitiousFunctionClassFactory = r0
            int r6 = r6 % 2
            if (r6 != 0) goto L6e
            r2 = 0
        L6e:
            if (r2 == 0) goto L71
            return r7
        L71:
            r6 = 63
            int r6 = r6 / r1
            return r7
        L75:
            r6 = move-exception
            throw r6
        L77:
            android.content.Context r0 = r5.MyBillsEntityDataFactory     // Catch: android.content.res.Resources.NotFoundException -> L82
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L82
            java.lang.String r6 = r0.getString(r6)     // Catch: android.content.res.Resources.NotFoundException -> L82
            return r6
        L82:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.config.impl.j.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.String):java.lang.String");
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int length;
        int[] iArr2;
        int length2;
        int[] iArr3;
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        int i3 = 2;
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr4 = getAuthRequestContext;
        int i4 = 0;
        int i5 = 1;
        if (iArr4 != null) {
            int i6 = $10 + 13;
            $11 = i6 % 128;
            if (i6 % 2 != 0) {
                length2 = iArr4.length;
                iArr3 = new int[length2];
                i2 = 0;
            } else {
                length2 = iArr4.length;
                iArr3 = new int[length2];
                i2 = 1;
            }
            while (i2 < length2) {
                iArr3[i2] = (int) (iArr4[i2] ^ (-3152031022165484798L));
                i2++;
            }
            iArr4 = iArr3;
        }
        int length3 = iArr4.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = getAuthRequestContext;
        if ((iArr6 != null ? '6' : '8') == '6') {
            int i7 = $10 + 43;
            $11 = i7 % 128;
            if (i7 % 2 == 0) {
                length = iArr6.length;
                iArr2 = new int[length];
            } else {
                length = iArr6.length;
                iArr2 = new int[length];
            }
            int i8 = 0;
            while (true) {
                if ((i8 < length ? 1 : 0) != i5) {
                    break;
                }
                iArr2[i8] = (int) (iArr6[i8] ^ (-3152031022165484798L));
                i8++;
                i3 = 2;
                i4 = 0;
                i5 = 1;
            }
            iArr6 = iArr2;
        }
        try {
            System.arraycopy(iArr6, i4, iArr5, i4, length3);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = i4;
            while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                int i9 = $10 + 85;
                $11 = i9 % 128;
                int i10 = i9 % i3;
                cArr[i4] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[i5] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[i3] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + i5] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + i5];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[i4] << 16) + cArr[i5];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[i3] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
                for (int i11 = 0; i11 < 16; i11++) {
                    int i12 = $10 + 69;
                    $11 = i12 % 128;
                    int i13 = i12 % i3;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[i11];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i14;
                }
                int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i15;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr5[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[17];
                int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i17 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[i4] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[i5] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[i3] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[i4];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + i5] = cArr[i5];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + i3] = cArr[i3];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += i3;
            }
            objArr[i4] = new String(cArr2, i4, i);
        } catch (Exception e) {
            throw e;
        }
    }
}

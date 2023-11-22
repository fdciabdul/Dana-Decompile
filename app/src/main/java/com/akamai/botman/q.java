package com.akamai.botman;

import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes3.dex */
public final class q {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int PlaceComponentResult;
    private static int[] getAuthRequestContext = {-988883875, 754916253, 177374195, -2123321856, 2064503245, 1068039242, -1931330654, 692532001, 1967093904, 149601219, -183264281, -1894315570, -2116274421, 118214803, 723033084, -1238297174, 1501162542, 848786722};

    public static int BuiltInFictitiousFunctionClassFactory(String str) {
        if ((str == null) || str.trim().equalsIgnoreCase("")) {
            return -1;
        }
        try {
            int i = PlaceComponentResult + 115;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                try {
                    if (i3 >= str.length()) {
                        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                        PlaceComponentResult = i5 % 128;
                        int i6 = i5 % 2;
                        return i4;
                    }
                    char charAt = str.charAt(i3);
                    if (charAt < 128) {
                        i4 += charAt;
                    }
                    i3++;
                } catch (Exception unused) {
                    return -2;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static long PlaceComponentResult(String str) {
        long j;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        PlaceComponentResult = i % 128;
        try {
            if (i % 2 != 0) {
                j = Long.parseLong(str);
                int i2 = 17 / 0;
            } else {
                j = Long.parseLong(str);
            }
        } catch (NumberFormatException unused) {
            j = 0;
        }
        int i3 = PlaceComponentResult + 113;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        if ((r2 <= 86 ? '.' : 23) != '.') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
    
        if (r2 <= 126) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006b, code lost:
    
        if (r2 == 34) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (r2 == 37) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        r8 = '9';
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
    
        r8 = 25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        if (r8 == 25) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        if (r2 == 39) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        r6 = com.akamai.botman.q.KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        com.akamai.botman.q.PlaceComponentResult = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0087, code lost:
    
        if (r2 == 44) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008b, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008c, code lost:
    
        if (r6 == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
    
        if (r2 == 92) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
    
        r0.append((char) r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getAuthRequestContext(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.q.getAuthRequestContext(java.lang.String):java.lang.String");
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        int i3 = 2;
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = getAuthRequestContext;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i4 = 0;
            while (true) {
                if ((i4 < length ? 'W' : '*') == '*') {
                    break;
                }
                try {
                    int i5 = $10 + 99;
                    $11 = i5 % 128;
                    if (i5 % 2 == 0) {
                        iArr3[i4] = (int) (iArr2[i4] * (-3152031022165484798L));
                        i4 /= 1;
                    } else {
                        iArr3[i4] = (int) (iArr2[i4] ^ (-3152031022165484798L));
                        i4++;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = getAuthRequestContext;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i6 = 0;
            while (true) {
                if ((i6 < length3 ? 'I' : (char) 16) != 'I') {
                    break;
                }
                int i7 = $11 + 27;
                $10 = i7 % 128;
                int i8 = i7 % i3;
                iArr6[i6] = (int) (iArr5[i6] ^ (-3152031022165484798L));
                i6++;
                length2 = length2;
                i3 = 2;
            }
            i2 = length2;
            iArr5 = iArr6;
        } else {
            i2 = length2;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, i2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length ? (char) 30 : '`') == '`') {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
            int i9 = $11 + 109;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            int i11 = 16;
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            int i12 = 0;
            while (true) {
                if (!(i12 >= i11)) {
                    int i13 = $10 + 49;
                    $11 = i13 % 128;
                    int i14 = i13 % 2;
                    try {
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i12];
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i15;
                        i12++;
                        i11 = 16;
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
            }
            int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i16;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i17 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i18 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
    }
}

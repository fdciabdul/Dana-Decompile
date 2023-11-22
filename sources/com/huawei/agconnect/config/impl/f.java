package com.huawei.agconnect.config.impl;

import android.view.Gravity;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;
import o.D;

/* loaded from: classes7.dex */
class f implements g {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int MyBillsEntityDataFactory = 1;
    private static int PlaceComponentResult = 0;
    private static long getAuthRequestContext = -8462349444895393634L;
    private SecretKey BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r6 == null) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002e, code lost:
    
        if ((r6 != null) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:
    
        if (r7 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0032, code lost:
    
        r0 = com.huawei.agconnect.config.impl.f.MyBillsEntityDataFactory + 51;
        com.huawei.agconnect.config.impl.f.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
        r3.BuiltInFictitiousFunctionClassFactory = com.huawei.agconnect.config.impl.i.BuiltInFictitiousFunctionClassFactory(com.huawei.agconnect.config.impl.Hex.BuiltInFictitiousFunctionClassFactory(r4), com.huawei.agconnect.config.impl.Hex.BuiltInFictitiousFunctionClassFactory(r5), com.huawei.agconnect.config.impl.Hex.BuiltInFictitiousFunctionClassFactory(r6), com.huawei.agconnect.config.impl.Hex.BuiltInFictitiousFunctionClassFactory(r7), 5000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public f(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) throws java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.IllegalArgumentException {
        /*
            r3 = this;
            r3.<init>()
            if (r4 == 0) goto L54
            r0 = 82
            if (r5 == 0) goto Lc
            r1 = 82
            goto Le
        Lc:
            r1 = 39
        Le:
            if (r1 == r0) goto L11
            goto L54
        L11:
            int r0 = com.huawei.agconnect.config.impl.f.PlaceComponentResult
            int r0 = r0 + 113
            int r1 = r0 % 128
            com.huawei.agconnect.config.impl.f.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L2a
            r0 = 71
            int r0 = r0 / r2
            if (r6 == 0) goto L25
            r1 = 0
        L25:
            if (r1 == 0) goto L30
            goto L54
        L28:
            r4 = move-exception
            throw r4
        L2a:
            if (r6 == 0) goto L2d
            goto L2e
        L2d:
            r1 = 0
        L2e:
            if (r1 == 0) goto L54
        L30:
            if (r7 == 0) goto L54
            int r0 = com.huawei.agconnect.config.impl.f.MyBillsEntityDataFactory
            int r0 = r0 + 51
            int r1 = r0 % 128
            com.huawei.agconnect.config.impl.f.PlaceComponentResult = r1
            int r0 = r0 % 2
            byte[] r4 = com.huawei.agconnect.config.impl.Hex.BuiltInFictitiousFunctionClassFactory(r4)
            byte[] r5 = com.huawei.agconnect.config.impl.Hex.BuiltInFictitiousFunctionClassFactory(r5)
            byte[] r6 = com.huawei.agconnect.config.impl.Hex.BuiltInFictitiousFunctionClassFactory(r6)
            byte[] r7 = com.huawei.agconnect.config.impl.Hex.BuiltInFictitiousFunctionClassFactory(r7)
            r0 = 5000(0x1388, float:7.006E-42)
            javax.crypto.SecretKey r4 = com.huawei.agconnect.config.impl.i.BuiltInFictitiousFunctionClassFactory(r4, r5, r6, r7, r0)
            r3.BuiltInFictitiousFunctionClassFactory = r4
        L54:
            int r4 = com.huawei.agconnect.config.impl.f.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L5f
            int r4 = r4 + 85
            int r5 = r4 % 128
            com.huawei.agconnect.config.impl.f.PlaceComponentResult = r5     // Catch: java.lang.Exception -> L5f
            int r4 = r4 % 2
            return
        L5f:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.config.impl.f.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // com.huawei.agconnect.config.impl.g
    public final String PlaceComponentResult(String str, String str2) {
        int i = PlaceComponentResult + 73;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        SecretKey secretKey = this.BuiltInFictitiousFunctionClassFactory;
        if (secretKey == null) {
            int i3 = PlaceComponentResult + 3;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return str;
        }
        try {
            byte[] MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory(secretKey, Hex.BuiltInFictitiousFunctionClassFactory(str));
            Object[] objArr = new Object[1];
            a(Gravity.getAbsoluteGravity(0, 0), new char[]{27432, 27517, 21244, 10206, 7654, 64721, 48840, 63308, 40094}, objArr);
            return new String(MyBillsEntityDataFactory2, ((String) objArr[0]).intern());
        } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
            return str2;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        try {
            char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext ^ 3919452569568103912L, cArr, i);
            d.MyBillsEntityDataFactory = 4;
            while (true) {
                if (!(d.MyBillsEntityDataFactory >= KClassImpl$Data$declaredNonStaticMembers$2.length)) {
                    int i2 = $10 + 57;
                    $11 = i2 % 128;
                    int i3 = i2 % 2;
                    d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                    KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (getAuthRequestContext ^ 3919452569568103912L)));
                    d.MyBillsEntityDataFactory++;
                    int i4 = $10 + 5;
                    $11 = i4 % 128;
                    int i5 = i4 % 2;
                } else {
                    objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                    return;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}

package com.huawei.agconnect.config.impl;

import android.view.View;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;
import o.D;

/* loaded from: classes7.dex */
public class e implements g {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static long MyBillsEntityDataFactory = -2288271017970476438L;
    private static int getAuthRequestContext = 1;
    private final d KClassImpl$Data$declaredNonStaticMembers$2;
    private SecretKey PlaceComponentResult;

    public e(d dVar) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dVar;
        PlaceComponentResult();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0014, code lost:
    
        if (r0 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x001f, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0027, code lost:
    
        if (java.util.regex.Pattern.matches("^\\[!([A-Fa-f0-9]*)]", r4) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0029, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x002b, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x002c, code lost:
    
        if (r4 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x002e, code lost:
    
        r4 = com.huawei.agconnect.config.impl.e.BuiltInFictitiousFunctionClassFactory + 79;
        com.huawei.agconnect.config.impl.e.getAuthRequestContext = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x003a, code lost:
    
        if ((r4 % 2) != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x003c, code lost:
    
        r4 = '[';
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x003f, code lost:
    
        r4 = kotlin.text.Typography.dollar;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0041, code lost:
    
        if (r4 == '$') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0043, code lost:
    
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r4) {
        /*
            int r0 = com.huawei.agconnect.config.impl.e.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 15
            int r1 = r0 % 128
            com.huawei.agconnect.config.impl.e.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L1b
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L19
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L43
            goto L21
        L17:
            r4 = move-exception
            throw r4
        L19:
            r4 = move-exception
            throw r4
        L1b:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L43
        L21:
            java.lang.String r0 = "^\\[!([A-Fa-f0-9]*)]"
            boolean r4 = java.util.regex.Pattern.matches(r0, r4)
            if (r4 == 0) goto L2b
            r4 = 1
            goto L2c
        L2b:
            r4 = 0
        L2c:
            if (r4 == 0) goto L43
            int r4 = com.huawei.agconnect.config.impl.e.BuiltInFictitiousFunctionClassFactory
            int r4 = r4 + 79
            int r0 = r4 % 128
            com.huawei.agconnect.config.impl.e.getAuthRequestContext = r0
            int r4 = r4 % 2
            r0 = 36
            if (r4 != 0) goto L3f
            r4 = 91
            goto L41
        L3f:
            r4 = 36
        L41:
            if (r4 == r0) goto L44
        L43:
            r1 = 0
        L44:
            int r4 = com.huawei.agconnect.config.impl.e.BuiltInFictitiousFunctionClassFactory
            int r4 = r4 + 119
            int r0 = r4 % 128
            com.huawei.agconnect.config.impl.e.getAuthRequestContext = r0
            int r4 = r4 % 2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.config.impl.e.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String):boolean");
    }

    private static String PlaceComponentResult(String str) {
        int i = getAuthRequestContext + 67;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            if ((matcher.find() ? '\f' : '5') != '\f') {
                try {
                    int i3 = getAuthRequestContext + 43;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    int i4 = i3 % 2;
                    return "";
                } catch (Exception e) {
                    throw e;
                }
            }
            return matcher.group(1);
        } catch (IllegalStateException | IndexOutOfBoundsException unused) {
            InstrumentInjector.log_e("ExclamationMark", "getRawString exception");
            return "";
        }
    }

    private SecretKey PlaceComponentResult() {
        try {
            String BuiltInFictitiousFunctionClassFactory2 = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory("/code/code1", null);
            String BuiltInFictitiousFunctionClassFactory3 = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory("/code/code2", null);
            String BuiltInFictitiousFunctionClassFactory4 = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory("/code/code3", null);
            String BuiltInFictitiousFunctionClassFactory5 = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory("/code/code4", null);
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                int i = getAuthRequestContext + 3;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                    int i3 = getAuthRequestContext + 31;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    int i4 = i3 % 2;
                    if ((BuiltInFictitiousFunctionClassFactory4 != null ? 'B' : '\r') != '\r') {
                        if (!(BuiltInFictitiousFunctionClassFactory5 == null)) {
                            int i5 = BuiltInFictitiousFunctionClassFactory + 95;
                            getAuthRequestContext = i5 % 128;
                            this.PlaceComponentResult = !(i5 % 2 == 0) ? i.BuiltInFictitiousFunctionClassFactory(Hex.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2), Hex.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3), Hex.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory4), Hex.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory5), 10000) : i.BuiltInFictitiousFunctionClassFactory(Hex.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2), Hex.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3), Hex.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory4), Hex.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory5), 14227);
                            try {
                                int i6 = getAuthRequestContext + 17;
                                BuiltInFictitiousFunctionClassFactory = i6 % 128;
                                int i7 = i6 % 2;
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            InstrumentInjector.log_e("ExclamationMark", "Exception when reading the 'K&I' for 'Config'.");
            this.PlaceComponentResult = null;
        }
        try {
            return this.PlaceComponentResult;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.huawei.agconnect.config.impl.g
    public final String PlaceComponentResult(String str, String str2) {
        String str3;
        int i = getAuthRequestContext + 75;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if ((this.PlaceComponentResult == null ? 'K' : (char) 23) == 'K') {
            int i3 = getAuthRequestContext + 63;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 41 / 0;
            }
            str3 = "mKey is null, return default value";
        } else if (!KClassImpl$Data$declaredNonStaticMembers$2(str)) {
            return str2;
        } else {
            try {
                byte[] MyBillsEntityDataFactory2 = i.MyBillsEntityDataFactory(this.PlaceComponentResult, Hex.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult(str)));
                Object[] objArr = new Object[1];
                a(View.combineMeasuredStates(0, 0), new char[]{40557, 40504, 24185, 31611, 30869, 18863, 21561, 15934, 49245}, objArr);
                return new String(MyBillsEntityDataFactory2, ((String) objArr[0]).intern());
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
                str3 = "UnsupportedEncodingException||GeneralSecurityException||IllegalArgumentException";
            }
        }
        InstrumentInjector.log_e("ExclamationMark", str3);
        return str2;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            if (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
                int i2 = $11 + 67;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (MyBillsEntityDataFactory ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
                int i4 = $11 + 123;
                $10 = i4 % 128;
                int i5 = i4 % 2;
            } else {
                objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                return;
            }
        }
    }
}

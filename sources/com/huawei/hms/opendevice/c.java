package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;
import com.huawei.secure.android.common.util.IOUtil;
import id.dana.data.constant.BranchLinkConstant;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import o.D;

/* loaded from: classes8.dex */
public abstract class c {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final Object BuiltInFictitiousFunctionClassFactory;
    public static final String KClassImpl$Data$declaredNonStaticMembers$2 = "c";
    private static long MyBillsEntityDataFactory = 0;
    public static Map<String, String> PlaceComponentResult = null;
    private static int getAuthRequestContext = 0;
    private static int lookAheadTest = 1;

    static {
        try {
            MyBillsEntityDataFactory();
            PlaceComponentResult = new HashMap();
            BuiltInFictitiousFunctionClassFactory = new Object();
            int i = lookAheadTest + 45;
            getAuthRequestContext = i % 128;
            if (!(i % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            int i = lookAheadTest + 41;
            getAuthRequestContext = i % 128;
            if (!(i % 2 != 0)) {
                return getAuthRequestContext(PlaceComponentResult(), BuiltInFictitiousFunctionClassFactory(), getAuthRequestContext(), scheduleImpl());
            }
            int i2 = 30 / 0;
            return getAuthRequestContext(PlaceComponentResult(), BuiltInFictitiousFunctionClassFactory(), getAuthRequestContext(), scheduleImpl());
        } catch (Exception e) {
            throw e;
        }
    }

    private static String MyBillsEntityDataFactory(Context context) {
        synchronized (c.class) {
            String PlaceComponentResult2 = WorkKeyCryptUtil.PlaceComponentResult(lookAheadTest(), KClassImpl$Data$declaredNonStaticMembers$2());
            if (t.getAuthRequestContext(PlaceComponentResult2)) {
                HMSLog.i(KClassImpl$Data$declaredNonStaticMembers$2, "keyS has been upgraded, no require operate again.");
                return PlaceComponentResult2;
            }
            String PlaceComponentResult3 = WorkKeyCryptUtil.PlaceComponentResult(lookAheadTest(), NetworkUserEntityData$$ExternalSyntheticLambda0());
            if (t.getAuthRequestContext(PlaceComponentResult3)) {
                HMSLog.i(KClassImpl$Data$declaredNonStaticMembers$2, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                BuiltInFictitiousFunctionClassFactory(WorkKeyCryptUtil.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult3, KClassImpl$Data$declaredNonStaticMembers$2()), context);
                return PlaceComponentResult3;
            }
            String PlaceComponentResult4 = WorkKeyCryptUtil.PlaceComponentResult(lookAheadTest(), BaseKeyUtil.getAuthRequestContext(PlaceComponentResult(), BuiltInFictitiousFunctionClassFactory(), getAuthRequestContext(), scheduleImpl(), false));
            if (t.getAuthRequestContext(PlaceComponentResult4)) {
                HMSLog.i(KClassImpl$Data$declaredNonStaticMembers$2, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
                BuiltInFictitiousFunctionClassFactory(WorkKeyCryptUtil.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult4, KClassImpl$Data$declaredNonStaticMembers$2()), context);
                return PlaceComponentResult4;
            }
            HMSLog.e(KClassImpl$Data$declaredNonStaticMembers$2, "all mode unable to decrypt root key.");
            return "";
        }
    }

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = -6760127316387215778L;
    }

    private static RootKeyUtil NetworkUserEntityData$$ExternalSyntheticLambda0() {
        RootKeyUtil BuiltInFictitiousFunctionClassFactory2;
        int i = getAuthRequestContext + 41;
        lookAheadTest = i % 128;
        Object obj = null;
        if (i % 2 != 0) {
            try {
                BuiltInFictitiousFunctionClassFactory2 = RootKeyUtil.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult(), BuiltInFictitiousFunctionClassFactory(), getAuthRequestContext(), scheduleImpl());
            } catch (Exception e) {
                throw e;
            }
        } else {
            BuiltInFictitiousFunctionClassFactory2 = RootKeyUtil.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult(), BuiltInFictitiousFunctionClassFactory(), getAuthRequestContext(), scheduleImpl());
            obj.hashCode();
        }
        int i2 = getAuthRequestContext + 117;
        lookAheadTest = i2 % 128;
        if ((i2 % 2 == 0 ? ']' : '8') != '8') {
            obj.hashCode();
            return BuiltInFictitiousFunctionClassFactory2;
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }

    public static void PlaceComponentResult(Context context) {
        String authRequestContext;
        String authRequestContext2;
        String authRequestContext3;
        String authRequestContext4;
        String authRequestContext5;
        synchronized (BuiltInFictitiousFunctionClassFactory) {
            BuiltInFictitiousFunctionClassFactory(context.getApplicationContext());
            if (getErrorConfigVersion()) {
                HMSLog.i(KClassImpl$Data$declaredNonStaticMembers$2, "The local secret is already in separate file mode.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(p.PlaceComponentResult(context.getApplicationContext()));
            sb.append("/shared_prefs/LocalAvengers.xml");
            File file = new File(sb.toString());
            if (file.exists()) {
                IOUtil.BuiltInFictitiousFunctionClassFactory(file);
                HMSLog.i(KClassImpl$Data$declaredNonStaticMembers$2, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] authRequestContext6 = EncryptUtil.getAuthRequestContext(32);
            byte[] authRequestContext7 = EncryptUtil.getAuthRequestContext(32);
            byte[] authRequestContext8 = EncryptUtil.getAuthRequestContext(32);
            byte[] authRequestContext9 = EncryptUtil.getAuthRequestContext(32);
            authRequestContext = HexUtil.getAuthRequestContext(authRequestContext6);
            authRequestContext2 = HexUtil.getAuthRequestContext(authRequestContext7);
            authRequestContext3 = HexUtil.getAuthRequestContext(authRequestContext8);
            authRequestContext4 = HexUtil.getAuthRequestContext(authRequestContext9);
            authRequestContext5 = HexUtil.getAuthRequestContext(EncryptUtil.getAuthRequestContext(32));
            KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, authRequestContext2, authRequestContext3, authRequestContext4, WorkKeyCryptUtil.BuiltInFictitiousFunctionClassFactory(authRequestContext5, getAuthRequestContext(authRequestContext, authRequestContext2, authRequestContext3, authRequestContext4)), context);
            HMSLog.i(KClassImpl$Data$declaredNonStaticMembers$2, "generate D.");
        }
    }

    private static byte[] getAuthRequestContext(String str, String str2, String str3, String str4) {
        if ((Build.VERSION.SDK_INT >= 26 ? 'A' : 'H') == 'A') {
            int i = lookAheadTest + 91;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return BaseKeyUtil.getAuthRequestContext(str, str2, str3, str4, true);
        }
        byte[] authRequestContext = BaseKeyUtil.getAuthRequestContext(str, str2, str3, str4, false);
        int i3 = getAuthRequestContext + 75;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return authRequestContext;
    }

    private static boolean getErrorConfigVersion() {
        boolean z;
        int i = lookAheadTest + 25;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? 'L' : 'c') != 'L') {
            try {
                z = !TextUtils.isEmpty(lookAheadTest());
            } catch (Exception e) {
                throw e;
            }
        } else {
            z = TextUtils.isEmpty(lookAheadTest()) | false;
        }
        int i2 = lookAheadTest + 3;
        getAuthRequestContext = i2 % 128;
        if ((i2 % 2 != 0 ? '\'' : JSONLexer.EOI) != 26) {
            Object obj = null;
            obj.hashCode();
            return z;
        }
        return z;
    }

    private static String lookAheadTest() {
        try {
            int i = lookAheadTest + 57;
            try {
                getAuthRequestContext = i % 128;
                if (!(i % 2 != 0)) {
                    return MyBillsEntityDataFactory("s");
                }
                String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory("s");
                Object[] objArr = null;
                int length = objArr.length;
                return MyBillsEntityDataFactory2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String scheduleImpl() {
        String MyBillsEntityDataFactory2;
        int i = getAuthRequestContext + 25;
        lookAheadTest = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? (char) 6 : (char) 25) != 25) {
            MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(SecurityConstants.KEY_TEXT);
            obj.hashCode();
        } else {
            MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(SecurityConstants.KEY_TEXT);
        }
        int i2 = lookAheadTest + 107;
        getAuthRequestContext = i2 % 128;
        if ((i2 % 2 != 0 ? JSONLexer.EOI : 'P') != 26) {
            return MyBillsEntityDataFactory2;
        }
        obj.hashCode();
        return MyBillsEntityDataFactory2;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        try {
            int i = getAuthRequestContext + 47;
            try {
                lookAheadTest = i % 128;
                int i2 = i % 2;
                if ((!getErrorConfigVersion() ? 'E' : (char) 23) == 'E') {
                    int i3 = lookAheadTest + 85;
                    getAuthRequestContext = i3 % 128;
                    if ((i3 % 2 != 0 ? (char) 20 : (char) 22) != 20) {
                        HMSLog.i(KClassImpl$Data$declaredNonStaticMembers$2, "work key is empty, execute init.");
                        PlaceComponentResult(context);
                    } else {
                        HMSLog.i(KClassImpl$Data$declaredNonStaticMembers$2, "work key is empty, execute init.");
                        PlaceComponentResult(context);
                        Object obj = null;
                        obj.hashCode();
                    }
                }
                String PlaceComponentResult2 = WorkKeyCryptUtil.PlaceComponentResult(lookAheadTest(), KClassImpl$Data$declaredNonStaticMembers$2());
                return (t.getAuthRequestContext(PlaceComponentResult2) ? '-' : '1') != '-' ? MyBillsEntityDataFactory(context) : PlaceComponentResult2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        if ((getErrorConfigVersion() ? 30 : 21) != 30) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
    
        if (getErrorConfigVersion() != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        r9 = com.huawei.hms.opendevice.c.getAuthRequestContext + 103;
        com.huawei.hms.opendevice.c.lookAheadTest = r9 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        if ((r9 % 2) != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        if (r4 == true) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.opendevice.c.KClassImpl$Data$declaredNonStaticMembers$2, "secretKeyCache not empty.");
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        r9.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
    
        com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.opendevice.c.KClassImpl$Data$declaredNonStaticMembers$2, "secretKeyCache not empty.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0052, code lost:
    
        com.huawei.hms.opendevice.c.PlaceComponentResult.clear();
        r9 = com.huawei.hms.opendevice.p.PlaceComponentResult(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
    
        if (android.text.TextUtils.isEmpty(r9) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
    
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
    
        r0.append(r9);
        r0.append("/files/math/m");
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
    
        r0 = com.huawei.hms.opendevice.s.getAuthRequestContext(r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
    
        r5 = new java.lang.StringBuilder();
        r5.append(r9);
        r5.append("/files/panda/p");
        r5 = com.huawei.hms.opendevice.s.getAuthRequestContext(r5.toString());
        r6 = new java.lang.StringBuilder();
        r6.append(r9);
        r6.append("/files/panda/d");
        r6 = com.huawei.hms.opendevice.s.getAuthRequestContext(r6.toString());
        r7 = new java.lang.StringBuilder();
        r7.append(r9);
        r7.append("/files/math/t");
        r7 = com.huawei.hms.opendevice.s.getAuthRequestContext(r7.toString());
        r8 = new java.lang.StringBuilder();
        r8.append(r9);
        r8.append("/files/s");
        r9 = com.huawei.hms.opendevice.s.getAuthRequestContext(r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dc, code lost:
    
        if (com.huawei.hms.opendevice.t.getAuthRequestContext(r0, r5, r6, r7, r9) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00de, code lost:
    
        com.huawei.hms.opendevice.c.PlaceComponentResult.put("m", r0);
        com.huawei.hms.opendevice.c.PlaceComponentResult.put(id.dana.data.constant.BranchLinkConstant.PayloadKey.PROMO_CODE, r5);
        com.huawei.hms.opendevice.c.PlaceComponentResult.put(com.alipay.mobile.rome.syncsdk.transport.connection.d.f7256a, r6);
        com.huawei.hms.opendevice.c.PlaceComponentResult.put(com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants.KEY_TEXT, r7);
        com.huawei.hms.opendevice.c.PlaceComponentResult.put("s", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0102, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0103, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0104, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0105, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0106, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void BuiltInFictitiousFunctionClassFactory(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.c.BuiltInFictitiousFunctionClassFactory(android.content.Context):void");
    }

    private static String BuiltInFictitiousFunctionClassFactory() {
        try {
            int i = getAuthRequestContext + 105;
            lookAheadTest = i % 128;
            if (i % 2 != 0) {
                try {
                    return MyBillsEntityDataFactory(BranchLinkConstant.PayloadKey.PROMO_CODE);
                } catch (Exception e) {
                    throw e;
                }
            }
            String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(BranchLinkConstant.PayloadKey.PROMO_CODE);
            Object obj = null;
            obj.hashCode();
            return MyBillsEntityDataFactory2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String PlaceComponentResult() {
        int i = lookAheadTest + 35;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory("m");
        try {
            int i3 = lookAheadTest + 43;
            try {
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                return MyBillsEntityDataFactory2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        if (r0 == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, android.content.Context r10) {
        /*
            int r0 = com.huawei.hms.opendevice.c.getAuthRequestContext
            int r0 = r0 + 77
            int r1 = r0 % 128
            com.huawei.hms.opendevice.c.lookAheadTest = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            if (r0 == r2) goto L26
            android.content.Context r10 = r10.getApplicationContext()     // Catch: java.lang.Exception -> L23
            java.lang.String r10 = com.huawei.hms.opendevice.p.PlaceComponentResult(r10)     // Catch: java.lang.Exception -> L23
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Exception -> L23
            if (r0 != 0) goto Lab
            goto L35
        L23:
            r5 = move-exception
            goto Lc3
        L26:
            android.content.Context r10 = r10.getApplicationContext()
            java.lang.String r10 = com.huawei.hms.opendevice.p.PlaceComponentResult(r10)
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            int r4 = r3.length     // Catch: java.lang.Throwable -> Lc4
            if (r0 != 0) goto Lab
        L35:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.IOException -> La4
            r0.<init>()     // Catch: java.io.IOException -> La4
            r0.append(r10)     // Catch: java.io.IOException -> La4
            java.lang.String r4 = "/files/math/m"
            r0.append(r4)     // Catch: java.io.IOException -> La4
            java.lang.String r4 = "m"
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> La4
            MyBillsEntityDataFactory(r4, r5, r0)     // Catch: java.io.IOException -> La4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.io.IOException -> La4
            r5.<init>()     // Catch: java.io.IOException -> La4
            r5.append(r10)     // Catch: java.io.IOException -> La4
            java.lang.String r0 = "/files/panda/p"
            r5.append(r0)     // Catch: java.io.IOException -> La4
            java.lang.String r0 = "p"
            java.lang.String r5 = r5.toString()     // Catch: java.io.IOException -> La4
            MyBillsEntityDataFactory(r0, r6, r5)     // Catch: java.io.IOException -> La4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.io.IOException -> La4
            r5.<init>()     // Catch: java.io.IOException -> La4
            r5.append(r10)     // Catch: java.io.IOException -> La4
            java.lang.String r6 = "/files/panda/d"
            r5.append(r6)     // Catch: java.io.IOException -> La4
            java.lang.String r6 = "d"
            java.lang.String r5 = r5.toString()     // Catch: java.io.IOException -> La4
            MyBillsEntityDataFactory(r6, r7, r5)     // Catch: java.io.IOException -> La4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.io.IOException -> La4
            r5.<init>()     // Catch: java.io.IOException -> La4
            r5.append(r10)     // Catch: java.io.IOException -> La4
            java.lang.String r6 = "/files/math/t"
            r5.append(r6)     // Catch: java.io.IOException -> La4
            java.lang.String r6 = "t"
            java.lang.String r5 = r5.toString()     // Catch: java.io.IOException -> La4
            MyBillsEntityDataFactory(r6, r8, r5)     // Catch: java.io.IOException -> La4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.io.IOException -> La4
            r5.<init>()     // Catch: java.io.IOException -> La4
            r5.append(r10)     // Catch: java.io.IOException -> La4
            java.lang.String r6 = "/files/s"
            r5.append(r6)     // Catch: java.io.IOException -> La4
            java.lang.String r6 = "s"
            java.lang.String r5 = r5.toString()     // Catch: java.io.IOException -> La4
            MyBillsEntityDataFactory(r6, r9, r5)     // Catch: java.io.IOException -> La4
            return
        La4:
            java.lang.String r5 = com.huawei.hms.opendevice.c.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r6 = "save key IOException."
            com.huawei.hms.support.log.HMSLog.e(r5, r6)
        Lab:
            int r5 = com.huawei.hms.opendevice.c.lookAheadTest     // Catch: java.lang.Exception -> L23
            int r5 = r5 + 105
            int r6 = r5 % 128
            com.huawei.hms.opendevice.c.getAuthRequestContext = r6     // Catch: java.lang.Exception -> Lc1
            int r5 = r5 % 2
            if (r5 == 0) goto Lb8
            r1 = 1
        Lb8:
            if (r1 == r2) goto Lbb
            return
        Lbb:
            r3.hashCode()     // Catch: java.lang.Throwable -> Lbf
            return
        Lbf:
            r5 = move-exception
            throw r5
        Lc1:
            r5 = move-exception
            throw r5
        Lc3:
            throw r5
        Lc4:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.c.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.content.Context):void");
    }

    private static String getAuthRequestContext() {
        String MyBillsEntityDataFactory2;
        int i = lookAheadTest + 63;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            try {
                MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(com.alipay.mobile.rome.syncsdk.transport.connection.d.f7256a);
            } catch (Exception e) {
                throw e;
            }
        } else {
            MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(com.alipay.mobile.rome.syncsdk.transport.connection.d.f7256a);
            int i2 = 54 / 0;
        }
        int i3 = getAuthRequestContext + 107;
        lookAheadTest = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return MyBillsEntityDataFactory2;
        }
        return MyBillsEntityDataFactory2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if (r0 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void BuiltInFictitiousFunctionClassFactory(java.lang.String r4, android.content.Context r5) {
        /*
            int r0 = com.huawei.hms.opendevice.c.getAuthRequestContext     // Catch: java.lang.Exception -> L73
            int r0 = r0 + 29
            int r1 = r0 % 128
            com.huawei.hms.opendevice.c.lookAheadTest = r1     // Catch: java.lang.Exception -> L73
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
            if (r0 == r2) goto L28
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r5 = com.huawei.hms.opendevice.p.PlaceComponentResult(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r3.hashCode()     // Catch: java.lang.Throwable -> L26
            if (r0 != 0) goto L68
            goto L36
        L26:
            r4 = move-exception
            throw r4
        L28:
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r5 = com.huawei.hms.opendevice.p.PlaceComponentResult(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L68
        L36:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L61
            r0.<init>()     // Catch: java.io.IOException -> L61
            r0.append(r5)     // Catch: java.io.IOException -> L61
            java.lang.String r5 = "/files/s"
            r0.append(r5)     // Catch: java.io.IOException -> L61
            java.lang.String r5 = "s"
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L61
            MyBillsEntityDataFactory(r5, r4, r0)     // Catch: java.io.IOException -> L61
            int r4 = com.huawei.hms.opendevice.c.getAuthRequestContext     // Catch: java.lang.Exception -> L73
            int r4 = r4 + 21
            int r5 = r4 % 128
            com.huawei.hms.opendevice.c.lookAheadTest = r5     // Catch: java.lang.Exception -> L73
            int r4 = r4 % 2
            if (r4 != 0) goto L59
            goto L5a
        L59:
            r1 = 1
        L5a:
            if (r1 == r2) goto L60
            int r4 = r3.length     // Catch: java.lang.Throwable -> L5e
            return
        L5e:
            r4 = move-exception
            throw r4
        L60:
            return
        L61:
            java.lang.String r4 = com.huawei.hms.opendevice.c.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r5 = "save keyS IOException."
            com.huawei.hms.support.log.HMSLog.e(r4, r5)
        L68:
            int r4 = com.huawei.hms.opendevice.c.getAuthRequestContext
            int r4 = r4 + 25
            int r5 = r4 % 128
            com.huawei.hms.opendevice.c.lookAheadTest = r5
            int r4 = r4 % 2
            return
        L73:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.c.BuiltInFictitiousFunctionClassFactory(java.lang.String, android.content.Context):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Writer] */
    /* JADX WARN: Type inference failed for: r0v3 */
    private static void MyBillsEntityDataFactory(String str, String str2, String str3) throws IOException {
        BufferedWriter bufferedWriter;
        HMSLog.i(KClassImpl$Data$declaredNonStaticMembers$2, "save local secret key.");
        ?? r0 = 0;
        try {
            File file = new File(str3);
            s.BuiltInFictitiousFunctionClassFactory(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Object[] objArr = new Object[1];
            a(ViewConfiguration.getFadingEdgeLength() >> 16, new char[]{45020, 44937, 11910, 9572, 51344, 12367, 57274, 33084, 4928}, objArr);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, ((String) objArr[0]).intern());
            try {
                bufferedWriter = new BufferedWriter(outputStreamWriter);
                try {
                    bufferedWriter.write(str2);
                    bufferedWriter.flush();
                    PlaceComponentResult.put(str, str2);
                    IOUtils.closeQuietly((Writer) outputStreamWriter);
                    IOUtils.closeQuietly((Writer) bufferedWriter);
                    int i = getAuthRequestContext + 99;
                    lookAheadTest = i % 128;
                    if (!(i % 2 != 0)) {
                        int length = r0.length;
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = outputStreamWriter;
                    IOUtils.closeQuietly((Writer) r0);
                    IOUtils.closeQuietly((Writer) bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:26:0x0059
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static java.lang.String MyBillsEntityDataFactory(java.lang.String r4) {
        /*
            int r0 = com.huawei.hms.opendevice.c.getAuthRequestContext
            int r0 = r0 + 117
            int r1 = r0 % 128
            com.huawei.hms.opendevice.c.lookAheadTest = r1
            int r0 = r0 % 2
            r1 = 32
            if (r0 != 0) goto L11
            r0 = 10
            goto L13
        L11:
            r0 = 32
        L13:
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L30
            java.util.Map<java.lang.String, java.lang.String> r0 = com.huawei.hms.opendevice.c.PlaceComponentResult
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L2a
            goto L2b
        L2a:
            r2 = 1
        L2b:
            if (r2 == r3) goto L4e
            goto L42
        L2e:
            r4 = move-exception
            throw r4
        L30:
            java.util.Map<java.lang.String, java.lang.String> r0 = com.huawei.hms.opendevice.c.PlaceComponentResult
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L3f
            r2 = 1
        L3f:
            if (r2 == r3) goto L42
            goto L4e
        L42:
            int r4 = com.huawei.hms.opendevice.c.lookAheadTest
            int r4 = r4 + 109
            int r0 = r4 % 128
            com.huawei.hms.opendevice.c.getAuthRequestContext = r0
            int r4 = r4 % 2
            java.lang.String r4 = ""
        L4e:
            int r0 = com.huawei.hms.opendevice.c.lookAheadTest
            int r0 = r0 + 11
            int r1 = r0 % 128
            com.huawei.hms.opendevice.c.getAuthRequestContext = r1
            int r0 = r0 % 2
            return r4
        L59:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.c.MyBillsEntityDataFactory(java.lang.String):java.lang.String");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        int i2 = $11 + 117;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            try {
                if (d.MyBillsEntityDataFactory >= KClassImpl$Data$declaredNonStaticMembers$22.length) {
                    objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                    return;
                }
                int i4 = $10 + 77;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (MyBillsEntityDataFactory ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
    }
}

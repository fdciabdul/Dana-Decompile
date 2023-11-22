package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class d0 {
    public static d0 KClassImpl$Data$declaredNonStaticMembers$2;
    public String BuiltInFictitiousFunctionClassFactory;
    public String MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean MyBillsEntityDataFactory(String str) {
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        g0.getAuthRequestContext(b.lookAheadTest(), "Privacy_MY", "PrivacyData", str);
        g0.MyBillsEntityDataFactory(b.lookAheadTest(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    public static d0 PlaceComponentResult() {
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            synchronized (d0.class) {
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2 = new d0();
                }
            }
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
    
        if (KClassImpl$Data$declaredNonStaticMembers$2() != false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String MyBillsEntityDataFactory() {
        /*
            r5 = this;
            java.lang.String r0 = r5.BuiltInFictitiousFunctionClassFactory
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Le9
            android.content.Context r0 = com.huawei.hms.hatool.b.lookAheadTest()
            java.lang.String r1 = ""
            java.lang.String r2 = "Privacy_MY"
            java.lang.String r3 = "PrivacyData"
            java.lang.String r0 = com.huawei.hms.hatool.g0.MyBillsEntityDataFactory(r0, r2, r3, r1)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            r3 = 16
            java.lang.String r4 = "analytics_keystore"
            if (r2 == 0) goto L4d
            java.lang.String r0 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.MyBillsEntityDataFactory(r3)
            boolean r1 = KClassImpl$Data$declaredNonStaticMembers$2()
            if (r1 == 0) goto L2f
            java.lang.String r1 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.KClassImpl$Data$declaredNonStaticMembers$2(r4, r0)
            goto L48
        L2f:
            java.lang.String r1 = r5.MyBillsEntityDataFactory
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L42
            com.huawei.hms.hatool.c0 r1 = new com.huawei.hms.hatool.c0
            r1.<init>()
            java.lang.String r1 = r1.getAuthRequestContext()
            r5.MyBillsEntityDataFactory = r1
        L42:
            java.lang.String r1 = r5.MyBillsEntityDataFactory
            java.lang.String r1 = com.huawei.hms.hatool.d.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1)
        L48:
            MyBillsEntityDataFactory(r1)
            goto Le7
        L4d:
            boolean r2 = KClassImpl$Data$declaredNonStaticMembers$2()
            if (r2 == 0) goto L57
            java.lang.String r1 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.BuiltInFictitiousFunctionClassFactory(r4, r0)
        L57:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto Le6
            java.lang.String r1 = "hmsSdk"
            java.lang.String r2 = "deCrypt work key first"
            com.huawei.hms.hatool.y.BuiltInFictitiousFunctionClassFactory(r1, r2)
            java.lang.String r1 = r5.MyBillsEntityDataFactory
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L77
            com.huawei.hms.hatool.c0 r1 = new com.huawei.hms.hatool.c0
            r1.<init>()
            java.lang.String r1 = r1.getAuthRequestContext()
            r5.MyBillsEntityDataFactory = r1
        L77:
            java.lang.String r1 = r5.MyBillsEntityDataFactory
            java.lang.String r0 = com.huawei.hms.hatool.d.PlaceComponentResult(r0, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto Lb5
            java.lang.String r0 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.MyBillsEntityDataFactory(r3)
            boolean r1 = KClassImpl$Data$declaredNonStaticMembers$2()
            if (r1 == 0) goto L92
            java.lang.String r1 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.KClassImpl$Data$declaredNonStaticMembers$2(r4, r0)
            goto Lab
        L92:
            java.lang.String r1 = r5.MyBillsEntityDataFactory
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto La5
            com.huawei.hms.hatool.c0 r1 = new com.huawei.hms.hatool.c0
            r1.<init>()
            java.lang.String r1 = r1.getAuthRequestContext()
            r5.MyBillsEntityDataFactory = r1
        La5:
            java.lang.String r1 = r5.MyBillsEntityDataFactory
            java.lang.String r1 = com.huawei.hms.hatool.d.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1)
        Lab:
            MyBillsEntityDataFactory(r1)
            boolean r1 = KClassImpl$Data$declaredNonStaticMembers$2()
            if (r1 == 0) goto Le7
            goto Le2
        Lb5:
            boolean r1 = KClassImpl$Data$declaredNonStaticMembers$2()
            if (r1 == 0) goto Le7
            boolean r1 = KClassImpl$Data$declaredNonStaticMembers$2()
            if (r1 == 0) goto Lc6
            java.lang.String r1 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.KClassImpl$Data$declaredNonStaticMembers$2(r4, r0)
            goto Ldf
        Lc6:
            java.lang.String r1 = r5.MyBillsEntityDataFactory
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto Ld9
            com.huawei.hms.hatool.c0 r1 = new com.huawei.hms.hatool.c0
            r1.<init>()
            java.lang.String r1 = r1.getAuthRequestContext()
            r5.MyBillsEntityDataFactory = r1
        Ld9:
            java.lang.String r1 = r5.MyBillsEntityDataFactory
            java.lang.String r1 = com.huawei.hms.hatool.d.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1)
        Ldf:
            MyBillsEntityDataFactory(r1)
        Le2:
            com.huawei.hms.hatool.c0.MyBillsEntityDataFactory()
            goto Le7
        Le6:
            r0 = r1
        Le7:
            r5.BuiltInFictitiousFunctionClassFactory = r0
        Le9:
            java.lang.String r0 = r5.BuiltInFictitiousFunctionClassFactory
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.d0.MyBillsEntityDataFactory():java.lang.String");
    }
}

package com.alibaba.griver.biz;

import o.getOnBoardingScenario;

/* loaded from: classes2.dex */
public class WalletAPIUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static long MyBillsEntityDataFactory = 978006434099274329L;
    public static final String TAG = "WalletAPIUtils";
    private static int getAuthRequestContext;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if ((!r5 ? 'V' : 'Y') != 'Y') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        if ((!"B15".equals(r4.getString("channel"))) != true) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
    
        if (r4.containsKey("authClientId") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        r2 = com.alibaba.griver.biz.WalletAPIUtils.BuiltInFictitiousFunctionClassFactory + 93;
        com.alibaba.griver.biz.WalletAPIUtils.getAuthRequestContext = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        if ((r2 % 2) == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
    
        r2 = android.text.TextUtils.isEmpty(r4.getString("authClientId"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
    
        r1 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
    
        if (r2 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
    
        if (android.text.TextUtils.isEmpty(r4.getString("authClientId")) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        r1 = 'B';
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
    
        r1 = 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0087, code lost:
    
        if (r1 == 'B') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008a, code lost:
    
        r5 = r4.getString("authClientId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008f, code lost:
    
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0096, code lost:
    
        if (r4.containsKey("merchantId") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0098, code lost:
    
        r2 = com.alibaba.griver.biz.WalletAPIUtils.getAuthRequestContext + 75;
        com.alibaba.griver.biz.WalletAPIUtils.BuiltInFictitiousFunctionClassFactory = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00aa, code lost:
    
        if (android.text.TextUtils.isEmpty(r4.getString("merchantId")) != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ac, code lost:
    
        r0 = r4.getString("merchantId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b1, code lost:
    
        r4 = new java.lang.StringBuilder();
        r4.append("authClientId:");
        r4.append(r5);
        r4.append("tempMerchantId: ");
        r4.append(r0);
        com.alibaba.griver.base.common.logger.GriverLogger.d(com.alibaba.griver.biz.WalletAPIUtils.TAG, r4.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.String, java.lang.String> getMerchantIdAndAuthClientId(com.alibaba.ariver.app.api.Page r4, java.lang.String r5) {
        /*
            com.alibaba.ariver.app.api.App r4 = r4.getApp()     // Catch: java.lang.Exception -> Ld7
            java.lang.Class<com.alibaba.ariver.resource.api.models.AppModel> r0 = com.alibaba.ariver.resource.api.models.AppModel.class
            java.lang.Object r4 = r4.getData(r0)     // Catch: java.lang.Exception -> Ld7
            com.alibaba.ariver.resource.api.models.AppModel r4 = (com.alibaba.ariver.resource.api.models.AppModel) r4     // Catch: java.lang.Exception -> Ld7
            java.lang.String r0 = ""
            if (r4 == 0) goto Ld0
            com.alibaba.fastjson.JSONObject r1 = r4.getExtendInfos()
            com.alibaba.fastjson.JSONObject r4 = com.alibaba.griver.base.utils.MiniProgramExtendUtils.getJsApiExecuteConfig(r4, r1, r5)
            if (r4 == 0) goto Ld0
            int r5 = com.alibaba.griver.biz.WalletAPIUtils.getAuthRequestContext
            int r5 = r5 + 17
            int r1 = r5 % 128
            com.alibaba.griver.biz.WalletAPIUtils.BuiltInFictitiousFunctionClassFactory = r1
            int r5 = r5 % 2
            r1 = 0
            java.lang.String r2 = "channel"
            java.lang.String r3 = "B15"
            if (r5 != 0) goto L42
            java.lang.String r5 = r4.getString(r2)
            boolean r5 = r3.equals(r5)
            int r2 = r1.length     // Catch: java.lang.Throwable -> L40
            r2 = 89
            if (r5 != 0) goto L3b
            r5 = 86
            goto L3d
        L3b:
            r5 = 89
        L3d:
            if (r5 == r2) goto Ld0
            goto L54
        L40:
            r4 = move-exception
            throw r4
        L42:
            java.lang.String r5 = r4.getString(r2)
            boolean r5 = r3.equals(r5)
            r2 = 1
            if (r5 != 0) goto L4f
            r5 = 1
            goto L50
        L4f:
            r5 = 0
        L50:
            if (r5 == r2) goto L54
            goto Ld0
        L54:
            java.lang.String r5 = "authClientId"
            boolean r2 = r4.containsKey(r5)
            if (r2 == 0) goto L8f
            int r2 = com.alibaba.griver.biz.WalletAPIUtils.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 93
            int r3 = r2 % 128
            com.alibaba.griver.biz.WalletAPIUtils.getAuthRequestContext = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L76
            java.lang.String r2 = r4.getString(r5)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            int r1 = r1.length     // Catch: java.lang.Throwable -> L74
            if (r2 != 0) goto L8f
            goto L8a
        L74:
            r4 = move-exception
            throw r4
        L76:
            java.lang.String r1 = r4.getString(r5)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 66
            if (r1 != 0) goto L85
            r1 = 66
            goto L87
        L85:
            r1 = 29
        L87:
            if (r1 == r2) goto L8a
            goto L8f
        L8a:
            java.lang.String r5 = r4.getString(r5)
            goto L90
        L8f:
            r5 = r0
        L90:
            java.lang.String r1 = "merchantId"
            boolean r2 = r4.containsKey(r1)
            if (r2 == 0) goto Lb1
            int r2 = com.alibaba.griver.biz.WalletAPIUtils.getAuthRequestContext
            int r2 = r2 + 75
            int r3 = r2 % 128
            com.alibaba.griver.biz.WalletAPIUtils.BuiltInFictitiousFunctionClassFactory = r3
            int r2 = r2 % 2
            java.lang.String r2 = r4.getString(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto Lb1
            java.lang.String r4 = r4.getString(r1)
            r0 = r4
        Lb1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "authClientId:"
            r4.append(r1)
            r4.append(r5)
            java.lang.String r1 = "tempMerchantId: "
            r4.append(r1)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.String r1 = "WalletAPIUtils"
            com.alibaba.griver.base.common.logger.GriverLogger.d(r1, r4)
            goto Ld1
        Ld0:
            r5 = r0
        Ld1:
            android.util.Pair r4 = new android.util.Pair
            r4.<init>(r0, r5)
            return r4
        Ld7:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.biz.WalletAPIUtils.getMerchantIdAndAuthClientId(com.alibaba.ariver.app.api.Page, java.lang.String):android.util.Pair");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        if ((r3 != null) != true) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if ((r3 != null ? '\r' : 21) != 21) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        r3 = r3.getString("merchantId");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alipay.iap.android.wallet.acl.base.APIContext createApiContext(com.alibaba.ariver.app.api.Page r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.biz.WalletAPIUtils.createApiContext(com.alibaba.ariver.app.api.Page, java.lang.String):com.alipay.iap.android.wallet.acl.base.APIContext");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            int i2 = $10 + 67;
            $11 = i2 % 128;
            if (!(i2 % 2 == 0)) {
                jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ MyBillsEntityDataFactory) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                getonboardingscenario.getAuthRequestContext++;
            } else {
                try {
                    try {
                        jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] % (getonboardingscenario.getAuthRequestContext / getonboardingscenario.MyBillsEntityDataFactory)) | (MyBillsEntityDataFactory * 4796183387843776835L);
                        getonboardingscenario.getAuthRequestContext >>= 0;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        int i3 = $10 + 71;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (true) {
            if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                String str = new String(cArr2);
                int i5 = $11 + 81;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                objArr[0] = str;
                return;
            }
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
    }
}

package com.alibaba.ariver.permission.extension.auth;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.PermissionKeyPoint;
import com.alibaba.ariver.permission.model.AuthScope;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.getOnBoardingScenario;

/* loaded from: classes6.dex */
public class TRVOpenAuthHelper {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String ERROR_CODE_CANCEL_TRIVER = "PC_USER_CANCEL";
    public static final String ERROR_CODE_PARAMS_TRIVER = "PC_PARAMS_ERROR";
    public static final String ERROR_MESSAGE_PARAMS_TRIVER = "scopes至少传入1个，且最大支持5个";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public static final String KEY_ALL_PERMISSION = "allRemoteScope";
    private static int MyBillsEntityDataFactory = 1;
    public static final String TAG = "AriverTriver";
    private static long getAuthRequestContext = -7140122795175922292L;

    /* JADX WARN: Code restructure failed: missing block: B:346:0x01c2, code lost:
    
        if (r7 > java.lang.System.currentTimeMillis()) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x01cf, code lost:
    
        if (r7 > java.lang.System.currentTimeMillis()) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x01d1, code lost:
    
        r5 = r11.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x01d9, code lost:
    
        if (r5.hasNext() == false) goto L579;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x01db, code lost:
    
        r7 = (java.lang.String) r5.next();
        r8 = (com.alibaba.ariver.kernel.common.storage.KVStorageProxy) com.alibaba.ariver.kernel.common.RVProxy.get(com.alibaba.ariver.kernel.common.storage.KVStorageProxy.class);
        r10 = getAuthAppkey(r3);
        r11 = new java.lang.StringBuilder();
        r11.append(r7);
        r11.append(com.alibaba.exthub.config.ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME);
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x020f, code lost:
    
        if (android.text.TextUtils.equals(id.dana.sendmoney.summary.SummaryActivity.CHECKED, r8.getString(r10, buildPermissionKey(r21, r11.toString()))) == false) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x0211, code lost:
    
        r8 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x0214, code lost:
    
        r8 = '[';
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0216, code lost:
    
        if (r8 == 16) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x021a, code lost:
    
        r8 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory + 9;
        com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0224, code lost:
    
        if ((r8 % 2) == 0) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0226, code lost:
    
        r12.remove(r7);
        r13.add(r7);
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x022d, code lost:
    
        r8 = r7.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0232, code lost:
    
        r12.remove(r7);
        r13.add(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x0331, code lost:
    
        if (r21.getStartParams() != null) goto L417;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x033b, code lost:
    
        if (r21.getStartParams() != null) goto L417;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x033d, code lost:
    
        r7 = a(r21.getStartParams(), "sellerId");
        r11 = a(r21.getStartParams(), "sceneId");
        r15 = new com.alibaba.fastjson.JSONObject();
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x035a, code lost:
    
        if (android.text.TextUtils.isEmpty(r7) != false) goto L420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x035c, code lost:
    
        r15.put("sellerId", (java.lang.Object) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x0363, code lost:
    
        if (android.text.TextUtils.isEmpty(r11) != false) goto L423;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x0365, code lost:
    
        r15.put("sceneId", (java.lang.Object) r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x0368, code lost:
    
        r6.addData("bizContext", r15.toJSONString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x0375, code lost:
    
        if (android.text.TextUtils.isEmpty(r11) != false) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x0377, code lost:
    
        r7 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x0381, code lost:
    
        if ((r7 % 2) != 0) goto L434;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x0383, code lost:
    
        r7 = r3.getExtendInfos();
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x0388, code lost:
    
        r10.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x038b, code lost:
    
        if (r7 == null) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x0395, code lost:
    
        if (r3.getExtendInfos() == null) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x0397, code lost:
    
        r7 = r3.getExtendInfos().getJSONObject("authInfo");
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x03a1, code lost:
    
        if (r7 == null) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x03a3, code lost:
    
        r7 = r7.getString("authAppId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x03ad, code lost:
    
        if (android.text.TextUtils.isEmpty(r7) != false) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x03af, code lost:
    
        r10 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory + 117;
        com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r10 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x03b9, code lost:
    
        if ((r10 % 2) == 0) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x03bb, code lost:
    
        r6.addData("mainAppId", r7);
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x03bf, code lost:
    
        r8 = r7.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x03c4, code lost:
    
        r6.addData("mainAppId", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x0439, code lost:
    
        if (r6 > 0) goto L476;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x0440, code lost:
    
        if (r5.length > 0) goto L476;
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x0442, code lost:
    
        r14 = new java.lang.Object[1];
        b(android.text.TextUtils.lastIndexOf("", '0', 0, 0) + 54504, new char[]{25754, 45180, 52551, 6743, 14187}, r14);
        r6 = new java.lang.String(r5, java.nio.charset.Charset.forName(((java.lang.String) r14[0]).intern()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x0470, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) != false) goto L479;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x0472, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:0x0474, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x0475, code lost:
    
        if (r5 == false) goto L482;
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x0479, code lost:
    
        r5 = com.alibaba.fastjson.JSON.parseObject(r6).getJSONObject("data");
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x0483, code lost:
    
        if (r5 == null) goto L485;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x0485, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0487, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:487:0x0489, code lost:
    
        if (r6 == true) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:489:0x048f, code lost:
    
        if (r5.isEmpty() != false) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:490:0x0491, code lost:
    
        r1.setSuccess(java.lang.Boolean.TRUE);
        r1.setAuthContentResult(new com.alibaba.ariver.permission.openauth.model.result.AuthContentResultModel());
        r1.getAuthContentResult().setAppName(r5.getString("appName"));
        r1.getAuthContentResult().setAppLogoLink(r5.getString("appLogoLink"));
        r1.getAuthContentResult().setAgreements(new java.util.ArrayList());
        r1.getAuthContentResult().setIsvAgent(r4);
        r4 = r5.getString("appAlias");
     */
    /* JADX WARN: Code restructure failed: missing block: B:491:0x04d5, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) != false) goto L496;
     */
    /* JADX WARN: Code restructure failed: missing block: B:492:0x04d7, code lost:
    
        r6 = r1.getAuthContentResult().getExtInfo();
     */
    /* JADX WARN: Code restructure failed: missing block: B:493:0x04df, code lost:
    
        if (r6 != null) goto L495;
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:0x04e1, code lost:
    
        r6 = new java.util.HashMap<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:495:0x04e6, code lost:
    
        r6.put("appAlias", r4);
        r1.getAuthContentResult().setExtInfo(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x04f0, code lost:
    
        r2 = com.alibaba.ariver.kernel.common.utils.JSONUtils.toStringArray(r5.getJSONArray("authTextList"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x04fe, code lost:
    
        if (com.alibaba.ariver.permission.util.TRVAuthUtils.isPlatformTB(r21) != false) goto L499;
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x0500, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:0x0502, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:501:0x0504, code lost:
    
        if (r4 == true) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x0506, code lost:
    
        if (r2 == null) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:0x0508, code lost:
    
        r3 = ((com.alibaba.ariver.kernel.common.storage.KVStorageProxy) com.alibaba.ariver.kernel.common.RVProxy.get(com.alibaba.ariver.kernel.common.storage.KVStorageProxy.class)).getString(getAuthAppkey(r3), buildPermissionKey(r3, com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KEY_ALL_PERMISSION));
        r4 = new java.util.ArrayList();
        r3 = com.alibaba.fastjson.JSONArray.parseArray(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:504:0x0527, code lost:
    
        if (r3 == null) goto L509;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x0529, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:0x052e, code lost:
    
        if (r8 >= r3.size()) goto L564;
     */
    /* JADX WARN: Code restructure failed: missing block: B:508:0x0530, code lost:
    
        r6 = (com.alibaba.fastjson.JSONObject) r3.get(r8);
        r4.add(new com.alibaba.ariver.permission.model.AuthScope(r6.getString("scopeName"), r6.getString("scopeContent")));
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:509:0x054b, code lost:
    
        r3 = a(r2, "authText");
        r6 = r12.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:0x0559, code lost:
    
        if (r6.hasNext() == false) goto L566;
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x055b, code lost:
    
        r8 = r6.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x0565, code lost:
    
        if (r4.size() != 0) goto L565;
     */
    /* JADX WARN: Code restructure failed: missing block: B:514:0x0567, code lost:
    
        r4.add(new com.alibaba.ariver.permission.model.AuthScope(r8, r3.get(r8)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x0576, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:517:0x057b, code lost:
    
        if (r9 >= r4.size()) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:519:0x0581, code lost:
    
        if (a(r8, r4) != false) goto L572;
     */
    /* JADX WARN: Code restructure failed: missing block: B:520:0x0583, code lost:
    
        if (r3 == null) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:521:0x0585, code lost:
    
        r4.add(new com.alibaba.ariver.permission.model.AuthScope(r8, r3.get(r8)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:522:0x0593, code lost:
    
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:523:0x0596, code lost:
    
        ((com.alibaba.ariver.kernel.common.storage.KVStorageProxy) com.alibaba.ariver.kernel.common.RVProxy.get(com.alibaba.ariver.kernel.common.storage.KVStorageProxy.class)).putString(getAuthAppkey(r21), buildPermissionKey(r21, com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KEY_ALL_PERMISSION), com.alibaba.fastjson.JSON.toJSONString(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:524:0x05ad, code lost:
    
        r1.getAuthContentResult().setAuthText(r2);
        r1.getAuthContentResult().setSuccess(java.lang.Boolean.TRUE);
        r0 = r5.getJSONArray("agreements");
     */
    /* JADX WARN: Code restructure failed: missing block: B:525:0x05c3, code lost:
    
        if (r0 == null) goto L529;
     */
    /* JADX WARN: Code restructure failed: missing block: B:526:0x05c5, code lost:
    
        r2 = r0.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:527:0x05ca, code lost:
    
        if (r5 >= r2) goto L574;
     */
    /* JADX WARN: Code restructure failed: missing block: B:528:0x05cc, code lost:
    
        r3 = new com.alibaba.ariver.permission.openauth.model.result.AuthAgreementModel();
        r3.setLink(r0.getJSONObject(r5).getString("link"));
        r3.setName(r0.getJSONObject(r5).getString("name"));
        r1.getAuthContentResult().getAgreements().add(r3);
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x05f9, code lost:
    
        r1.setSuccess(java.lang.Boolean.TRUE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:530:0x05fe, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.ariver.permission.openauth.model.result.AuthSkipResultModel getAuthSkipResultPB(java.lang.String r20, com.alibaba.ariver.app.api.App r21, com.alibaba.ariver.permission.openauth.model.request.AuthSkipRequestModel r22) {
        /*
            Method dump skipped, instructions count: 1677
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.getAuthSkipResultPB(java.lang.String, com.alibaba.ariver.app.api.App, com.alibaba.ariver.permission.openauth.model.request.AuthSkipRequestModel):com.alibaba.ariver.permission.openauth.model.result.AuthSkipResultModel");
    }

    private static boolean a(String str, List<AuthScope> list) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
            MyBillsEntityDataFactory = i % 128;
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            for (int i4 = i % 2 == 0 ? 1 : 0; i4 < list.size(); i4++) {
                if (str.equals(list.get(i4).getScopeName())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0023, code lost:
    
        if ((r0 == null) != true) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0034, code lost:
    
        if (r0 != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0036, code lost:
    
        r0 = r0.getNativeApiScopeConfig();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x003a, code lost:
    
        if (r0 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x003c, code lost:
    
        r1 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory + 83;
        com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
        r0 = r0.keySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0052, code lost:
    
        if (r0.hasNext() == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0054, code lost:
    
        r1 = r0.next();
        r2 = (com.alibaba.ariver.kernel.common.storage.KVStorageProxy) com.alibaba.ariver.kernel.common.RVProxy.get(com.alibaba.ariver.kernel.common.storage.KVStorageProxy.class);
        r3 = getAuthAppkey(r6);
        r4 = new java.lang.StringBuilder();
        r4.append(r1);
        r4.append(com.alibaba.exthub.config.ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0086, code lost:
    
        if (id.dana.sendmoney.summary.SummaryActivity.CHECKED.equals(r2.getString(r3, buildPermissionKey(r6, r4.toString()))) == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0088, code lost:
    
        r2 = (com.alibaba.ariver.kernel.common.storage.KVStorageProxy) com.alibaba.ariver.kernel.common.RVProxy.get(com.alibaba.ariver.kernel.common.storage.KVStorageProxy.class);
        r3 = getAuthAppkey(r6);
        r4 = new java.lang.StringBuilder();
        r4.append(r1);
        r4.append(com.alibaba.exthub.config.ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME);
        r2.remove(r3, buildPermissionKey(r6, r4.toString()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.alibaba.ariver.app.api.App r6) {
        /*
            int r0 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> Lba
            int r0 = r0 + 53
            int r1 = r0 % 128
            com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> Lb8
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L26
            java.lang.Class<com.alibaba.ariver.resource.api.models.AppModel> r0 = com.alibaba.ariver.resource.api.models.AppModel.class
            java.lang.Object r0 = r6.getData(r0)
            com.alibaba.ariver.resource.api.models.AppModel r0 = (com.alibaba.ariver.resource.api.models.AppModel) r0
            com.alibaba.ariver.resource.api.models.PermissionModel r0 = r0.getPermissionModel()
            if (r0 == 0) goto L22
            goto L23
        L22:
            r1 = 1
        L23:
            if (r1 == r2) goto Lab
            goto L36
        L26:
            java.lang.Class<com.alibaba.ariver.resource.api.models.AppModel> r0 = com.alibaba.ariver.resource.api.models.AppModel.class
            java.lang.Object r0 = r6.getData(r0)
            com.alibaba.ariver.resource.api.models.AppModel r0 = (com.alibaba.ariver.resource.api.models.AppModel) r0
            com.alibaba.ariver.resource.api.models.PermissionModel r0 = r0.getPermissionModel()
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> Lb6
            if (r0 == 0) goto Lab
        L36:
            com.alibaba.fastjson.JSONObject r0 = r0.getNativeApiScopeConfig()
            if (r0 == 0) goto Lab
            int r1 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory
            int r1 = r1 + 83
            int r2 = r1 % 128
            com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L4e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lab
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Class<com.alibaba.ariver.kernel.common.storage.KVStorageProxy> r2 = com.alibaba.ariver.kernel.common.storage.KVStorageProxy.class
            java.lang.Object r2 = com.alibaba.ariver.kernel.common.RVProxy.get(r2)
            com.alibaba.ariver.kernel.common.storage.KVStorageProxy r2 = (com.alibaba.ariver.kernel.common.storage.KVStorageProxy) r2
            java.lang.String r3 = getAuthAppkey(r6)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r5 = "scope"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = buildPermissionKey(r6, r4)
            java.lang.String r2 = r2.getString(r3, r4)
            java.lang.String r3 = "true"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L4e
            java.lang.Class<com.alibaba.ariver.kernel.common.storage.KVStorageProxy> r2 = com.alibaba.ariver.kernel.common.storage.KVStorageProxy.class
            java.lang.Object r2 = com.alibaba.ariver.kernel.common.RVProxy.get(r2)
            com.alibaba.ariver.kernel.common.storage.KVStorageProxy r2 = (com.alibaba.ariver.kernel.common.storage.KVStorageProxy) r2
            java.lang.String r3 = getAuthAppkey(r6)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r5)
            java.lang.String r1 = r4.toString()
            java.lang.String r1 = buildPermissionKey(r6, r1)
            r2.remove(r3, r1)
            goto L4e
        Lab:
            int r6 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory
            int r6 = r6 + 23
            int r0 = r6 % 128
            com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r6 = r6 % 2
            return
        Lb6:
            r6 = move-exception
            throw r6
        Lb8:
            r6 = move-exception
            throw r6
        Lba:
            r6 = move-exception
            goto Lbd
        Lbc:
            throw r6
        Lbd:
            goto Lbc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.a(com.alibaba.ariver.app.api.App):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:514:0x01ab, code lost:
    
        if (r7.getAppInfoModel().getTemplateConfig().getTemplateId() != null) goto L521;
     */
    /* JADX WARN: Code restructure failed: missing block: B:520:0x01bd, code lost:
    
        if (r7.getAppInfoModel().getTemplateConfig().getTemplateId() != null) goto L521;
     */
    /* JADX WARN: Code restructure failed: missing block: B:521:0x01bf, code lost:
    
        r15 = r7.getAppInfoModel().getTemplateConfig().getTemplateId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x026d, code lost:
    
        if (r3 != null) goto L554;
     */
    /* JADX WARN: Code restructure failed: missing block: B:553:0x027b, code lost:
    
        if (r3 != null) goto L554;
     */
    /* JADX WARN: Code restructure failed: missing block: B:554:0x027d, code lost:
    
        r3 = r3.getString("authAppId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:555:0x0287, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L557;
     */
    /* JADX WARN: Code restructure failed: missing block: B:556:0x0289, code lost:
    
        r13.addData("mainAppId", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:714:0x0681, code lost:
    
        if ((r3 ? false : true) != true) goto L782;
     */
    /* JADX WARN: Code restructure failed: missing block: B:720:0x068c, code lost:
    
        if (r2.isEmpty() == false) goto L721;
     */
    /* JADX WARN: Removed duplicated region for block: B:633:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:634:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:637:0x0470  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.ariver.permission.openauth.model.result.AuthExecuteResultModel getAuthResult(com.alibaba.ariver.app.api.App r24, com.alibaba.ariver.permission.openauth.model.request.AuthExecuteRequestModel r25, com.alibaba.ariver.permission.openauth.model.result.AuthSkipResultModel r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 2206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.getAuthResult(com.alibaba.ariver.app.api.App, com.alibaba.ariver.permission.openauth.model.request.AuthExecuteRequestModel, com.alibaba.ariver.permission.openauth.model.result.AuthSkipResultModel, java.lang.String):com.alibaba.ariver.permission.openauth.model.result.AuthExecuteResultModel");
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x008e, code lost:
    
        if (r4 != null) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x009b, code lost:
    
        if (r4 != null) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x009d, code lost:
    
        r0 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory + 123;
        com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x00b1, code lost:
    
        if (android.text.TextUtils.equals(r4.getAppId(), r5) == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x00b3, code lost:
    
        r5 = 'a';
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x00b6, code lost:
    
        r5 = 28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00b8, code lost:
    
        if (r5 == 28) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x00be, code lost:
    
        if (r4.getPermission() == null) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x00c0, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x00c2, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00c3, code lost:
    
        if (r4 == false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x00c6, code lost:
    
        r4 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 + 89;
        com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x00d0, code lost:
    
        if ((r4 % 2) != 0) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x00d4, code lost:
    
        r4 = 27 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x00d5, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x00d8, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x00d9, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x00da, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.alibaba.ariver.resource.api.models.AppModel r4, java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.a(com.alibaba.ariver.resource.api.models.AppModel, java.lang.String, java.lang.String):boolean");
    }

    public static String buildPermissionKey(String str, String str2) {
        String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId();
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.append("_appid_");
        sb.append(str);
        sb.append("_key_");
        sb.append(str2);
        String obj = sb.toString();
        try {
            int i = MyBillsEntityDataFactory + 51;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? (char) 31 : 'K') != 31) {
                return obj;
            }
            int i2 = 43 / 0;
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String buildPermissionKey(App app, String str) {
        String authAppkey;
        String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId();
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.append("_appid_");
        if (!(app != null)) {
            authAppkey = "";
        } else {
            try {
                int i = MyBillsEntityDataFactory + 53;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                authAppkey = getAuthAppkey(app);
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            sb.append(authAppkey);
            sb.append("_key_");
            sb.append(str);
            return sb.toString();
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:35:0x002e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.lang.String buildPermissionKey(com.alibaba.ariver.resource.api.models.AppModel r4, java.lang.String r5) {
        /*
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVAccountService> r0 = com.alibaba.ariver.kernel.common.service.RVAccountService.class
            java.lang.Object r0 = com.alibaba.ariver.kernel.common.RVProxy.get(r0)
            com.alibaba.ariver.kernel.common.service.RVAccountService r0 = (com.alibaba.ariver.kernel.common.service.RVAccountService) r0
            java.lang.String r0 = r0.getUserId()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "_appid_"
            r1.append(r0)
            r0 = 0
            if (r4 == 0) goto L1e
            r2 = 0
            goto L1f
        L1e:
            r2 = 1
        L1f:
            if (r2 == 0) goto L30
            java.lang.String r4 = ""
            int r0 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 25
            int r2 = r0 % 128
            com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory = r2
            int r0 = r0 % 2
            goto L53
        L2e:
            r4 = move-exception
            throw r4
        L30:
            int r2 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory
            int r2 = r2 + 3
            int r3 = r2 % 128
            com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % 2
            r3 = 67
            if (r2 == 0) goto L41
            r2 = 56
            goto L43
        L41:
            r2 = 67
        L43:
            if (r2 == r3) goto L4f
            java.lang.String r4 = getAuthAppkey(r4)
            r2 = 38
            int r2 = r2 / r0
            goto L53
        L4d:
            r4 = move-exception
            throw r4
        L4f:
            java.lang.String r4 = getAuthAppkey(r4)
        L53:
            r1.append(r4)
            java.lang.String r4 = "_key_"
            r1.append(r4)
            r1.append(r5)
            java.lang.String r4 = r1.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.buildPermissionKey(com.alibaba.ariver.resource.api.models.AppModel, java.lang.String):java.lang.String");
    }

    public static String buildPermissionKey(App app, String str, String str2) {
        String appId;
        if ((str2 == null ? '1' : '\n') == '1') {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            str2 = "";
        }
        String buildLocalPermissionKey = ((PermissionKeyPoint) ExtensionPoint.as(PermissionKeyPoint.class).node(app).create()).buildLocalPermissionKey(app, str, str2);
        if (TextUtils.isEmpty(buildLocalPermissionKey)) {
            String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId();
            StringBuilder sb = new StringBuilder();
            sb.append(userId);
            sb.append("_");
            if (!(!TextUtils.isEmpty(getAuthAppkey(app)))) {
                try {
                    appId = app.getAppId();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                appId = getAuthAppkey(app);
            }
            sb.append(appId);
            sb.append("_");
            sb.append(str2.substring(str2.indexOf(".") + 1, str2.length()));
            return sb.toString();
        }
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return buildLocalPermissionKey;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x0086, code lost:
    
        if (r11 != false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0093, code lost:
    
        if (android.text.TextUtils.equals(r6.getAppId(), r11) != false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0099, code lost:
    
        if (r6.getPermission() == null) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x009b, code lost:
    
        r11 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory + 87;
        com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r11 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x00a5, code lost:
    
        if ((r11 % 2) == 0) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x00a7, code lost:
    
        r1 = com.alibaba.ariver.resource.api.models.PermissionModel.generateFromJSON(r6.getPermission());
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x00af, code lost:
    
        r11 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x00b3, code lost:
    
        r1 = com.alibaba.ariver.resource.api.models.PermissionModel.generateFromJSON(r6.getPermission());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.String, java.lang.String> a(com.alibaba.ariver.resource.api.models.AppModel r9, java.util.List<java.lang.String> r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.a(com.alibaba.ariver.resource.api.models.AppModel, java.util.List, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0031, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0043, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r4) ? 28 : '_') != '_') goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.os.Bundle r3, java.lang.String r4) {
        /*
            int r0 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 35
            int r1 = r0 % 128
            com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            java.lang.String r0 = "widgetSceneParams"
            java.lang.String r3 = r3.getString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L67
            int r0 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L65
            int r0 = r0 + 79
            int r1 = r0 % 128
            com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L63
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L27
            r0 = 0
            goto L28
        L27:
            r0 = 1
        L28:
            if (r0 == r2) goto L36
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r2 = 55
            int r2 = r2 / r1
            if (r0 != 0) goto L67
            goto L45
        L34:
            r3 = move-exception
            throw r3
        L36:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 95
            if (r0 != 0) goto L41
            r0 = 28
            goto L43
        L41:
            r0 = 95
        L43:
            if (r0 == r1) goto L67
        L45:
            com.alibaba.fastjson.JSONObject r3 = com.alibaba.fastjson.JSON.parseObject(r3)     // Catch: java.lang.Exception -> L67
            r0 = 52
            if (r3 == 0) goto L50
            r1 = 52
            goto L51
        L50:
            r1 = 6
        L51:
            if (r1 == r0) goto L54
            goto L67
        L54:
            int r0 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 51
            int r1 = r0 % 128
            com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            java.lang.String r3 = r3.getString(r4)     // Catch: java.lang.Exception -> L67
            goto L69
        L63:
            r3 = move-exception
            throw r3
        L65:
            r3 = move-exception
            throw r3
        L67:
            java.lang.String r3 = ""
        L69:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.a(android.os.Bundle, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0019, code lost:
    
        if ((r3 != null ? 'H' : ']') != 'H') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x001e, code lost:
    
        if (r3 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0024, code lost:
    
        if (r3.getExtendInfos() == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0026, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0027, code lost:
    
        if (r1 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0029, code lost:
    
        r3 = r3.getExtendInfos().getString("engineType");
        r0 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory + 87;
        com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x003e, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x003f, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0040, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0048, code lost:
    
        return android.text.TextUtils.equals(id.dana.danah5.share.ShareToFeedBridge.WIDGET, r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.alibaba.ariver.resource.api.models.AppModel r3) {
        /*
            int r0 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory
            int r0 = r0 + 69
            int r1 = r0 % 128
            com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1e
            r0 = 21
            int r0 = r0 / r1
            r0 = 72
            if (r3 == 0) goto L17
            r2 = 72
            goto L19
        L17:
            r2 = 93
        L19:
            if (r2 == r0) goto L20
            goto L40
        L1c:
            r3 = move-exception
            throw r3
        L1e:
            if (r3 == 0) goto L40
        L20:
            com.alibaba.fastjson.JSONObject r0 = r3.getExtendInfos()     // Catch: java.lang.Exception -> L3e
            if (r0 == 0) goto L27
            r1 = 1
        L27:
            if (r1 == 0) goto L40
            com.alibaba.fastjson.JSONObject r3 = r3.getExtendInfos()
            java.lang.String r0 = "engineType"
            java.lang.String r3 = r3.getString(r0)
            int r0 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory
            int r0 = r0 + 87
            int r1 = r0 % 128
            com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            goto L41
        L3e:
            r3 = move-exception
            throw r3
        L40:
            r3 = 0
        L41:
            java.lang.String r0 = "widget"
            boolean r3 = android.text.TextUtils.equals(r0, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.a(com.alibaba.ariver.resource.api.models.AppModel):boolean");
    }

    public static String getAuthAppkey(App app) {
        String authAppkey;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? (char) 28 : '?') != '?') {
            authAppkey = getAuthAppkey((AppModel) app.getData(AppModel.class));
            int i2 = 27 / 0;
        } else {
            authAppkey = getAuthAppkey((AppModel) app.getData(AppModel.class));
        }
        int i3 = MyBillsEntityDataFactory + 31;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 16 : 'R') != 16) {
            return authAppkey;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return authAppkey;
    }

    public static String getAuthAppkey(AppModel appModel) {
        Object[] objArr = null;
        if (appModel != null) {
            if ((!a(appModel) ? 'R' : '@') != '@') {
                AppInfoModel appInfoModel = appModel.getAppInfoModel();
                if (appInfoModel != null) {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
                    MyBillsEntityDataFactory = i % 128;
                    if (i % 2 == 0) {
                        String appKey = appInfoModel.getAppKey();
                        int length = objArr.length;
                        return appKey;
                    }
                    return appInfoModel.getAppKey();
                }
                return "";
            }
        }
        if ((appModel != null ? (char) 11 : 'X') != 11) {
            return "";
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        try {
            if (appModel.getExtendInfos() != null) {
                JSONObject jSONObject = appModel.getExtendInfos().getJSONObject("authInfo");
                if (jSONObject != null) {
                    int i4 = MyBillsEntityDataFactory + 123;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                    if (i4 % 2 == 0) {
                        try {
                            return jSONObject.getString("authAppkey");
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    String string = jSONObject.getString("authAppkey");
                    objArr.hashCode();
                    return string;
                }
                AppInfoModel appInfoModel2 = appModel.getAppInfoModel();
                if ((appInfoModel2 != null ? (char) 25 : '3') != '3') {
                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
                    MyBillsEntityDataFactory = i5 % 128;
                    int i6 = i5 % 2;
                    String appKey2 = appInfoModel2.getAppKey();
                    int i7 = MyBillsEntityDataFactory + 69;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                    int i8 = i7 % 2;
                    return appKey2;
                }
                return "";
            }
            return "";
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0058, code lost:
    
        if ((r0 != null) != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0064, code lost:
    
        if (r0 != null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x006d, code lost:
    
        if (r6.getBooleanValue("widgetHasBeenTouched") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x006f, code lost:
    
        r6 = java.lang.Boolean.TRUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0071, code lost:
    
        if (r0 == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0073, code lost:
    
        r1 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory + 21;
        com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x007d, code lost:
    
        if ((r1 % 2) == 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x007f, code lost:
    
        r1 = r0.getExtendInfos();
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0083, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0086, code lost:
    
        if (r1 == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0091, code lost:
    
        if (r0.getExtendInfos() == null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0093, code lost:
    
        r1 = 'N';
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0096, code lost:
    
        r1 = 'F';
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0098, code lost:
    
        if (r1 == 'F') goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x009a, code lost:
    
        r0 = r0.getExtendInfos().getJSONObject("authInfo");
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00a4, code lost:
    
        if (r0 == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x00a6, code lost:
    
        r6 = java.lang.Boolean.valueOf(r0.getBooleanValue("canUseAuth"));
        r0 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory + 39;
        com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00bb, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x00bc, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00bd, code lost:
    
        r6 = r6.booleanValue();
        r0 = com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.MyBillsEntityDataFactory + 43;
        com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x00cb, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x001a, code lost:
    
        if (r6 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0020, code lost:
    
        if (r6 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0022, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0024, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean canAuth(com.alibaba.ariver.app.api.App r6) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.TRVOpenAuthHelper.canAuth(com.alibaba.ariver.app.api.App):boolean");
    }

    private static Map<String, String> a(List<String> list, String str) {
        Object[] objArr = null;
        try {
            HashMap hashMap = new HashMap();
            Iterator<String> it = list.iterator();
            while (true) {
                if ((it.hasNext() ? (char) 16 : '7') == '7') {
                    try {
                        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
                        MyBillsEntityDataFactory = i % 128;
                        int i2 = i % 2;
                        return hashMap;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                int i3 = MyBillsEntityDataFactory + 11;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    JSONObject parseObject = JSONObject.parseObject(it.next());
                    hashMap.put(parseObject.getString("scopeName"), parseObject.getString(str));
                } else {
                    JSONObject parseObject2 = JSONObject.parseObject(it.next());
                    hashMap.put(parseObject2.getString("scopeName"), parseObject2.getString(str));
                    int length = objArr.length;
                }
            }
        } catch (Exception e2) {
            RVLogger.e(TAG, "getAuthTexts error", e2);
            return null;
        }
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        int i2;
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        try {
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (true) {
                try {
                    if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                        break;
                    }
                    int i3 = $11 + 49;
                    $10 = i3 % 128;
                    if (i3 % 2 == 0) {
                        jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ getAuthRequestContext) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                        i2 = getonboardingscenario.getAuthRequestContext + 1;
                    } else {
                        jArr[getonboardingscenario.getAuthRequestContext] = cArr[getonboardingscenario.getAuthRequestContext] & (getonboardingscenario.getAuthRequestContext / getonboardingscenario.MyBillsEntityDataFactory) & (getAuthRequestContext * 4796183387843776835L);
                        i2 = getonboardingscenario.getAuthRequestContext % 1;
                    }
                    getonboardingscenario.getAuthRequestContext = i2;
                } catch (Exception e) {
                    throw e;
                }
            }
            char[] cArr2 = new char[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (getonboardingscenario.getAuthRequestContext < cArr.length) {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            }
            String str = new String(cArr2);
            int i4 = $10 + 57;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            objArr[0] = str;
        } catch (Exception e2) {
            throw e2;
        }
    }
}

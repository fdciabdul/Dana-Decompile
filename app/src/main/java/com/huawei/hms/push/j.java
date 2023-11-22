package com.huawei.hms.push;

import android.content.Context;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;

/* loaded from: classes8.dex */
public class j {
    public static final String[] MyBillsEntityDataFactory = {"url", GriverOnPreloadExtension.PARAMS_APP, "cosa", "rp"};
    public Context PlaceComponentResult;
    public k getAuthRequestContext;

    public j(Context context, k kVar) {
        this.PlaceComponentResult = context;
        this.getAuthRequestContext = kVar;
    }

    public static boolean getAuthRequestContext(String str) {
        for (String str2 : MyBillsEntityDataFactory) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a8, code lost:
    
        if (com.huawei.hms.push.q.MyBillsEntityDataFactory(r6.PlaceComponentResult, r6.getAuthRequestContext.newProxyInstance, r2).booleanValue() != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x006e, code lost:
    
        if (r3 != false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ad A[Catch: Exception -> 0x00cd, TryCatch #0 {Exception -> 0x00cd, blocks: (B:3:0x0007, B:17:0x00ad, B:19:0x00b3, B:21:0x00bc, B:23:0x00c7, B:22:0x00c2, B:11:0x008b, B:13:0x0091, B:10:0x0072, B:6:0x003c), top: B:28:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b3 A[Catch: Exception -> 0x00cd, TryCatch #0 {Exception -> 0x00cd, blocks: (B:3:0x0007, B:17:0x00ad, B:19:0x00b3, B:21:0x00bc, B:23:0x00c7, B:22:0x00c2, B:11:0x008b, B:13:0x0091, B:10:0x0072, B:6:0x003c), top: B:28:0x0007, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult() {
        /*
            r6 = this;
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r1 = "run into launchCosaApp"
            com.huawei.hms.support.log.HMSLog.i(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcd
            r1.<init>()     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = "enter launchExistApp cosa, appPackageName ="
            r1.append(r2)     // Catch: java.lang.Exception -> Lcd
            com.huawei.hms.push.k r2 = r6.getAuthRequestContext     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = r2.newProxyInstance     // Catch: java.lang.Exception -> Lcd
            r1.append(r2)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = ",and msg.intentUri is "
            r1.append(r2)     // Catch: java.lang.Exception -> Lcd
            com.huawei.hms.push.k r2 = r6.getAuthRequestContext     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = r2.lookAheadTest     // Catch: java.lang.Exception -> Lcd
            r1.append(r2)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Lcd
            com.huawei.hms.support.log.HMSLog.i(r0, r1)     // Catch: java.lang.Exception -> Lcd
            android.content.Context r1 = r6.PlaceComponentResult     // Catch: java.lang.Exception -> Lcd
            com.huawei.hms.push.k r2 = r6.getAuthRequestContext     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = r2.newProxyInstance     // Catch: java.lang.Exception -> Lcd
            android.content.Intent r1 = com.huawei.hms.push.q.MyBillsEntityDataFactory(r1, r2)     // Catch: java.lang.Exception -> Lcd
            com.huawei.hms.push.k r2 = r6.getAuthRequestContext     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = r2.lookAheadTest     // Catch: java.lang.Exception -> Lcd
            r3 = 0
            if (r2 == 0) goto L8b
            com.huawei.hms.push.k r2 = r6.getAuthRequestContext     // Catch: java.lang.Exception -> L71
            java.lang.String r2 = r2.lookAheadTest     // Catch: java.lang.Exception -> L71
            android.content.Intent r2 = android.content.Intent.parseUri(r2, r3)     // Catch: java.lang.Exception -> L71
            r4 = 0
            r2.setSelector(r4)     // Catch: java.lang.Exception -> L71
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L71
            r4.<init>()     // Catch: java.lang.Exception -> L71
            java.lang.String r5 = "Intent.parseUri(msg.intentUri, 0), action:"
            r4.append(r5)     // Catch: java.lang.Exception -> L71
            java.lang.String r5 = r2.getAction()     // Catch: java.lang.Exception -> L71
            r4.append(r5)     // Catch: java.lang.Exception -> L71
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L71
            com.huawei.hms.support.log.HMSLog.i(r0, r4)     // Catch: java.lang.Exception -> L71
            android.content.Context r4 = r6.PlaceComponentResult     // Catch: java.lang.Exception -> L71
            com.huawei.hms.push.k r5 = r6.getAuthRequestContext     // Catch: java.lang.Exception -> L71
            java.lang.String r5 = r5.newProxyInstance     // Catch: java.lang.Exception -> L71
            java.lang.Boolean r4 = com.huawei.hms.push.q.MyBillsEntityDataFactory(r4, r5, r2)     // Catch: java.lang.Exception -> L71
            boolean r3 = r4.booleanValue()     // Catch: java.lang.Exception -> L71
            if (r3 == 0) goto Lab
            goto Laa
        L71:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcd
            r4.<init>()     // Catch: java.lang.Exception -> Lcd
            java.lang.String r5 = "intentUri error."
            r4.append(r5)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Lcd
            r4.append(r2)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Exception -> Lcd
            com.huawei.hms.support.log.HMSLog.w(r0, r2)     // Catch: java.lang.Exception -> Lcd
            goto Lab
        L8b:
            com.huawei.hms.push.k r2 = r6.getAuthRequestContext     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = r2.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> Lcd
            if (r2 == 0) goto Lab
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Exception -> Lcd
            com.huawei.hms.push.k r4 = r6.getAuthRequestContext     // Catch: java.lang.Exception -> Lcd
            java.lang.String r4 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> Lcd
            r2.<init>(r4)     // Catch: java.lang.Exception -> Lcd
            android.content.Context r4 = r6.PlaceComponentResult     // Catch: java.lang.Exception -> Lcd
            com.huawei.hms.push.k r5 = r6.getAuthRequestContext     // Catch: java.lang.Exception -> Lcd
            java.lang.String r5 = r5.newProxyInstance     // Catch: java.lang.Exception -> Lcd
            java.lang.Boolean r4 = com.huawei.hms.push.q.MyBillsEntityDataFactory(r4, r5, r2)     // Catch: java.lang.Exception -> Lcd
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Exception -> Lcd
            if (r4 == 0) goto Lab
        Laa:
            r1 = r2
        Lab:
            if (r1 != 0) goto Lb3
            java.lang.String r1 = "launchCosaApp,intent == null"
            com.huawei.hms.support.log.HMSLog.i(r0, r1)     // Catch: java.lang.Exception -> Lcd
            return
        Lb3:
            com.huawei.hms.push.k r2 = r6.getAuthRequestContext     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = r2.newProxyInstance     // Catch: java.lang.Exception -> Lcd
            r1.setPackage(r2)     // Catch: java.lang.Exception -> Lcd
            if (r3 == 0) goto Lc2
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r2)     // Catch: java.lang.Exception -> Lcd
            goto Lc7
        Lc2:
            r2 = 805437440(0x30020000, float:4.7293724E-10)
            r1.setFlags(r2)     // Catch: java.lang.Exception -> Lcd
        Lc7:
            android.content.Context r2 = r6.PlaceComponentResult     // Catch: java.lang.Exception -> Lcd
            r2.startActivity(r1)     // Catch: java.lang.Exception -> Lcd
            return
        Lcd:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "launch Cosa App exception."
            r2.append(r3)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.huawei.hms.support.log.HMSLog.e(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.j.PlaceComponentResult():void");
    }
}

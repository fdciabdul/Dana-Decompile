package com.huawei.hms.opendevice;

import android.content.Context;

/* loaded from: classes8.dex */
public class f implements Runnable {
    public Context PlaceComponentResult;

    public f(Context context) {
        this.PlaceComponentResult = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x00a4 A[Catch: NameNotFoundException -> 0x00ea, Exception -> 0x00ee, TryCatch #0 {NameNotFoundException -> 0x00ea, blocks: (B:78:0x008e, B:80:0x00a4, B:82:0x00ce, B:83:0x00d3, B:85:0x00e0, B:87:0x00e6), top: B:94:0x008e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e6 A[Catch: NameNotFoundException -> 0x00ea, Exception -> 0x00ee, TRY_LEAVE, TryCatch #0 {NameNotFoundException -> 0x00ea, blocks: (B:78:0x008e, B:80:0x00a4, B:82:0x00ce, B:83:0x00d3, B:85:0x00e0, B:87:0x00e6), top: B:94:0x008e, outer: #2 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r9 = this;
            java.lang.String r0 = "push kit sdk not exists"
            java.lang.String r1 = "AutoInit"
            com.huawei.hms.aaid.constant.ErrorEnum r2 = com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS     // Catch: java.lang.Exception -> Lee
            int r2 = r2.getInternalCode()     // Catch: java.lang.Exception -> Lee
            r3 = 0
            android.content.Context r4 = r9.PlaceComponentResult     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            com.huawei.hms.aaid.HmsInstanceId r4 = com.huawei.hms.aaid.HmsInstanceId.getAuthRequestContext(r4)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            android.content.Context r5 = r9.PlaceComponentResult     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            com.huawei.hms.utils.Util.getAppId(r5)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            android.os.Looper r5 = android.os.Looper.getMainLooper()     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            android.os.Looper r6 = android.os.Looper.myLooper()     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            if (r5 == r6) goto L7b
            android.content.Context r5 = r4.PlaceComponentResult     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            boolean r5 = com.huawei.hms.aaid.utils.BaseUtils.KClassImpl$Data$declaredNonStaticMembers$2(r5)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            if (r5 == 0) goto L45
            com.huawei.hms.aaid.plugin.PushProxy r5 = com.huawei.hms.aaid.plugin.ProxyCenter.KClassImpl$Data$declaredNonStaticMembers$2()     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            if (r5 != 0) goto L45
            android.content.Context r5 = r4.PlaceComponentResult     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            boolean r5 = com.huawei.hms.aaid.utils.BaseUtils.getAuthRequestContext(r5)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            if (r5 == 0) goto L37
            goto L45
        L37:
            java.lang.String r2 = com.huawei.hms.aaid.HmsInstanceId.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            java.lang.String r4 = "Operations in child processes are not supported."
            com.huawei.hms.support.log.HMSLog.e(r2, r4)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            com.huawei.hms.aaid.constant.ErrorEnum r2 = com.huawei.hms.aaid.constant.ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            com.huawei.hms.common.ApiException r2 = r2.toApiException()     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            throw r2     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
        L45:
            android.content.Context r5 = r4.PlaceComponentResult     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            com.huawei.hms.aaid.entity.TokenReq r5 = com.huawei.hms.opendevice.o.BuiltInFictitiousFunctionClassFactory(r5)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            android.content.Context r6 = r4.PlaceComponentResult     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            java.lang.String r6 = com.huawei.hms.opendevice.o.MyBillsEntityDataFactory(r6)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            r5.setAaid(r6)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            r6 = 0
            r5.setMultiSender(r6)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            android.content.Context r6 = r4.PlaceComponentResult     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            com.huawei.hms.opendevice.i r6 = com.huawei.hms.opendevice.i.BuiltInFictitiousFunctionClassFactory(r6)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            android.content.Context r7 = r4.PlaceComponentResult     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            java.lang.String r7 = r7.getPackageName()     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            java.lang.String r8 = "1"
            r6.MyBillsEntityDataFactory(r7, r8)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            java.lang.String r4 = r4.MyBillsEntityDataFactory(r5)     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            java.lang.String r5 = "Push init succeed"
            com.huawei.hms.support.log.HMSLog.i(r1, r5)     // Catch: com.huawei.hms.common.ApiException -> L79 java.lang.Exception -> Lee
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: com.huawei.hms.common.ApiException -> L79 java.lang.Exception -> Lee
            if (r5 == 0) goto L8e
            return
        L79:
            r2 = move-exception
            goto L84
        L7b:
            com.huawei.hms.aaid.constant.ErrorEnum r2 = com.huawei.hms.aaid.constant.ErrorEnum.ERROR_MAIN_THREAD     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            com.huawei.hms.common.ApiException r2 = r2.toApiException()     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
            throw r2     // Catch: com.huawei.hms.common.ApiException -> L82 java.lang.Exception -> Lee
        L82:
            r2 = move-exception
            r4 = r3
        L84:
            r3 = r2
            int r2 = r3.getStatusCode()     // Catch: java.lang.Exception -> Lee
            java.lang.String r5 = "new Push init failed"
            com.huawei.hms.support.log.HMSLog.e(r1, r5)     // Catch: java.lang.Exception -> Lee
        L8e:
            android.content.Context r5 = r9.PlaceComponentResult     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            android.content.Context r6 = r9.PlaceComponentResult     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            java.lang.String r6 = r6.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            r7 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r6, r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            android.os.Bundle r6 = r5.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            if (r6 == 0) goto Le6
            android.os.Bundle r5 = r5.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            android.content.Intent r5 = new android.content.Intent     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            java.lang.String r6 = "com.huawei.push.action.MESSAGING_EVENT"
            r5.<init>(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            android.content.Context r6 = r9.PlaceComponentResult     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            java.lang.String r6 = r6.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            r5.setPackage(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            android.os.Bundle r6 = new android.os.Bundle     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            r6.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            java.lang.String r7 = "message_type"
            java.lang.String r8 = "new_token"
            r6.putString(r7, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            java.lang.String r7 = "device_token"
            r6.putString(r7, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            java.lang.String r4 = "error"
            r6.putInt(r4, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            if (r3 == 0) goto Ld3
            java.lang.String r2 = "exception_key"
            r6.putSerializable(r2, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
        Ld3:
            com.huawei.hms.opendevice.h r2 = new com.huawei.hms.opendevice.h     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            r2.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            android.content.Context r3 = r9.PlaceComponentResult     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            boolean r2 = r2.BuiltInFictitiousFunctionClassFactory(r3, r6, r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            if (r2 != 0) goto Lf4
            java.lang.String r2 = "start service failed"
            com.huawei.hms.support.log.HMSLog.e(r1, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            return
        Le6:
            com.huawei.hms.support.log.HMSLog.i(r1, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lea java.lang.Exception -> Lee
            return
        Lea:
            com.huawei.hms.support.log.HMSLog.i(r1, r0)     // Catch: java.lang.Exception -> Lee
            return
        Lee:
            r0 = move-exception
            java.lang.String r2 = "Push init failed"
            com.huawei.hms.support.log.HMSLog.e(r1, r2, r0)
        Lf4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.f.run():void");
    }
}

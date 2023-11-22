package com.iap.ac.android.mpm.oauth.agreement;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.callback.NetworkCallback;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.mpm.base.model.oauth.result.ApplyAgreementAuthResult;
import com.iap.ac.android.mpm.base.model.oauth.result.PrepareAgreementAuthResult;
import com.iap.ac.android.mpm.oauth.agreement.source.AgreementAuthEntityData;

/* loaded from: classes8.dex */
public class AgreementAuthRepository {
    private static final String TAG = "AgreementAuthRepository";
    private AgreementAuthEntityData entityData = new AgreementAuthEntityData();

    public void paySignCenter(final String str, final String str2, final NetworkCallback networkCallback) {
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.mpm.oauth.agreement.AgreementAuthRepository.1
            @Override // java.lang.Runnable
            public void run() {
                AgreementAuthRepository.this.paySignCenterInner(str, str2, networkCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void paySignCenterInner(String str, String str2, final NetworkCallback networkCallback) {
        PrepareAgreementAuthResult prepareAgreementAuthResult;
        try {
            prepareAgreementAuthResult = prepare(str, str2);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("prepare error:");
            sb.append(e);
            ACLog.e(TAG, sb.toString());
            prepareAgreementAuthResult = null;
        }
        if (prepareAgreementAuthResult != null && prepareAgreementAuthResult.success) {
            ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_GET_AUTHCODE_ENTER).addParams("mode", (Object) 1).addParams(LogConstants.Oauth.AUTHURL, prepareAgreementAuthResult.authUrl).event();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            SPIManager.getInstance().getAuthCode(prepareAgreementAuthResult.authUrl, new IAuthCallback() { // from class: com.iap.ac.android.mpm.oauth.agreement.AgreementAuthRepository.2
                /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
                /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
                @Override // com.iap.ac.android.biz.common.callback.IAuthCallback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onResult(com.iap.ac.android.biz.common.model.AuthResult r8) {
                    /*
                        r7 = this;
                        r0 = 0
                        if (r8 == 0) goto Ld
                        java.lang.String r1 = r8.authCode     // Catch: java.lang.Exception -> L42
                        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L42
                        if (r1 != 0) goto Ld
                        r1 = 1
                        goto Le
                    Ld:
                        r1 = 0
                    Le:
                        java.lang.String r2 = "iapconnect_center"
                        java.lang.String r3 = "ac_common_get_authcode"
                        com.iap.ac.android.biz.common.utils.log.ACLogEvent r2 = com.iap.ac.android.biz.common.utils.log.ACLogEvent.newLogger(r2, r3)     // Catch: java.lang.Exception -> L42
                        if (r1 == 0) goto L1b
                        java.lang.String r1 = "T"
                        goto L1d
                    L1b:
                        java.lang.String r1 = "F"
                    L1d:
                        java.lang.String r3 = "result"
                        com.iap.ac.android.biz.common.utils.log.ACLogEvent r1 = r2.addParams(r3, r1)     // Catch: java.lang.Exception -> L42
                        long r2 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L42
                        long r4 = r2     // Catch: java.lang.Exception -> L42
                        java.lang.String r6 = "timeCost"
                        long r2 = r2 - r4
                        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L42
                        com.iap.ac.android.biz.common.utils.log.ACLogEvent r1 = r1.addParams(r6, r2)     // Catch: java.lang.Exception -> L42
                        r1.event()     // Catch: java.lang.Exception -> L42
                        com.iap.ac.android.mpm.oauth.agreement.AgreementAuthRepository r1 = com.iap.ac.android.mpm.oauth.agreement.AgreementAuthRepository.this     // Catch: java.lang.Exception -> L42
                        java.lang.String r2 = r8.authCode     // Catch: java.lang.Exception -> L42
                        java.lang.String r8 = r8.authState     // Catch: java.lang.Exception -> L42
                        com.iap.ac.android.mpm.base.model.oauth.result.ApplyAgreementAuthResult r8 = r1.apply(r2, r8)     // Catch: java.lang.Exception -> L42
                        goto L5a
                    L42:
                        r8 = move-exception
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "apply error:"
                        r1.append(r2)
                        r1.append(r8)
                        java.lang.String r8 = r1.toString()
                        java.lang.String r1 = "AgreementAuthRepository"
                        com.iap.ac.android.common.log.ACLog.e(r1, r8)
                        r8 = r0
                    L5a:
                        if (r8 == 0) goto L68
                        boolean r1 = r8.success
                        if (r1 == 0) goto L68
                        com.iap.ac.android.biz.common.callback.NetworkCallback r0 = r4
                        java.lang.String r8 = r8.extInfo
                        r0.onResult(r8)
                        return
                    L68:
                        com.iap.ac.android.biz.common.callback.NetworkCallback r8 = r4
                        r8.onResult(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.mpm.oauth.agreement.AgreementAuthRepository.AnonymousClass2.onResult(com.iap.ac.android.biz.common.model.AuthResult):void");
                }
            });
            return;
        }
        networkCallback.onResult(null);
    }

    public PrepareAgreementAuthResult prepare(String str, String str2) throws Exception {
        return this.entityData.prepare(str, str2);
    }

    public ApplyAgreementAuthResult apply(String str, String str2) throws Exception {
        return this.entityData.Apply(str, str2);
    }
}

package com.iap.ac.android.biz.common.internal.oauth.holdlogin;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.oauth.OAuthUtil;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.rpc.facade.MobilePaymentHoldLoginRpcFacade;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentHoldLoginRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentHoldLoginResult;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class HoldLoginProcessor extends BaseNetwork<MobilePaymentHoldLoginRpcFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<MobilePaymentHoldLoginRpcFacade> getFacadeClass() {
        return MobilePaymentHoldLoginRpcFacade.class;
    }

    public boolean holdLoginInWorker(String str, String str2, String str3) {
        MobilePaymentHoldLoginResult holdLogin;
        synchronized (this) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                MobilePaymentHoldLoginRequest mobilePaymentHoldLoginRequest = new MobilePaymentHoldLoginRequest();
                mobilePaymentHoldLoginRequest.instanceId = str;
                mobilePaymentHoldLoginRequest.openId = str3;
                mobilePaymentHoldLoginRequest.nonce = Utils.getNonce();
                mobilePaymentHoldLoginRequest.timestamp = System.currentTimeMillis();
                mobilePaymentHoldLoginRequest.clientKeyDigest = Utils.SHA256(String.format("%s||%s||%s", str2, mobilePaymentHoldLoginRequest.nonce, String.valueOf(mobilePaymentHoldLoginRequest.timestamp)));
                holdLogin = getFacade().holdLogin(mobilePaymentHoldLoginRequest);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("holdLoginInWorker exception: ");
                sb.append(th);
                ACLog.e(Constants.TAG, sb.toString());
                reportRpcResult(LogConstants.EVENT_ID_HOLD_LOGIN, false, ResultCode.INVALID_NETWORK, Utils.e(th), SystemClock.elapsedRealtime() - elapsedRealtime, "");
            }
            if (holdLogin != null && holdLogin.success) {
                ACLog.i(Constants.TAG, "holdLoginInWorker success");
                if (ACManager.getInstance().useV2Encrypt()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(LogConstants.KEY_USE_V2_ENCRYPT, SummaryActivity.CHECKED);
                    reportRpcResult(LogConstants.EVENT_ID_HOLD_LOGIN, true, null, null, SystemClock.elapsedRealtime() - elapsedRealtime, holdLogin.traceId, hashMap);
                } else {
                    reportRpcResult(LogConstants.EVENT_ID_HOLD_LOGIN, true, null, null, SystemClock.elapsedRealtime() - elapsedRealtime, holdLogin.traceId);
                }
                OAuthUtil.getInstance().updateSessionTime();
                return true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("holdLoginInWorker error: ");
            sb2.append(holdLogin);
            ACLog.e(Constants.TAG, sb2.toString());
            if (holdLogin != null) {
                if (ACManager.getInstance().useV2Encrypt()) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(LogConstants.KEY_USE_V2_ENCRYPT, SummaryActivity.CHECKED);
                    reportRpcResult(LogConstants.EVENT_ID_HOLD_LOGIN, false, holdLogin.errorCode, holdLogin.errorMessage, SystemClock.elapsedRealtime() - elapsedRealtime, holdLogin.traceId, hashMap2);
                } else {
                    reportRpcResult(LogConstants.EVENT_ID_HOLD_LOGIN, false, holdLogin.errorCode, holdLogin.errorMessage, SystemClock.elapsedRealtime() - elapsedRealtime, holdLogin.traceId);
                }
            } else if (ACManager.getInstance().useV2Encrypt()) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put(LogConstants.KEY_USE_V2_ENCRYPT, SummaryActivity.CHECKED);
                reportRpcResult(LogConstants.EVENT_ID_HOLD_LOGIN, false, ResultCode.INVALID_NETWORK, "Oops! System busy. Try again later!", SystemClock.elapsedRealtime() - elapsedRealtime, "", hashMap3);
            } else {
                reportRpcResult(LogConstants.EVENT_ID_HOLD_LOGIN, false, ResultCode.INVALID_NETWORK, "Oops! System busy. Try again later!", SystemClock.elapsedRealtime() - elapsedRealtime, "");
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d6 A[Catch: all -> 0x015a, TryCatch #1 {all -> 0x015a, blocks: (B:5:0x0006, B:7:0x0023, B:10:0x002a, B:12:0x006b, B:14:0x0077, B:16:0x007b, B:18:0x008d, B:19:0x00ac, B:22:0x00be, B:24:0x00d6, B:26:0x00e0, B:27:0x0104, B:28:0x011a, B:30:0x0124, B:31:0x0146, B:11:0x004b), top: B:44:0x0006, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011a A[Catch: all -> 0x015a, TryCatch #1 {all -> 0x015a, blocks: (B:5:0x0006, B:7:0x0023, B:10:0x002a, B:12:0x006b, B:14:0x0077, B:16:0x007b, B:18:0x008d, B:19:0x00ac, B:22:0x00be, B:24:0x00d6, B:26:0x00e0, B:27:0x0104, B:28:0x011a, B:30:0x0124, B:31:0x0146, B:11:0x004b), top: B:44:0x0006, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean rewardsHoldLoginInWorker(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.biz.common.internal.oauth.holdlogin.HoldLoginProcessor.rewardsHoldLoginInWorker(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}

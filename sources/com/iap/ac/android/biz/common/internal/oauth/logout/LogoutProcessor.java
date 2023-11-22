package com.iap.ac.android.biz.common.internal.oauth.logout;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.LogResult;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.rpc.facade.MobilePaymentLogoutRpcFacade;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentLogoutRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentLogoutResult;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class LogoutProcessor extends BaseNetwork<MobilePaymentLogoutRpcFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<MobilePaymentLogoutRpcFacade> getFacadeClass() {
        return MobilePaymentLogoutRpcFacade.class;
    }

    public boolean logout() {
        MobilePaymentLogoutResult logout;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        LogResult logResult = new LogResult();
        try {
            try {
                logout = getFacade().logout(new MobilePaymentLogoutRequest());
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("LogoutProcessor exception: ");
                sb.append(e);
                String obj = sb.toString();
                ACLog.e(Constants.TAG, obj);
                logResult.resultCode = ResultCode.INVALID_NETWORK;
                logResult.resultMessage = obj;
            }
            if (logout != null && logout.success) {
                logResult.resultCode = "SUCCESS";
                logResult.traceId = logout.traceId;
                ACLogEvent.commonEvent(LogConstants.EVENT_ID_AUTH_LOGOUT, elapsedRealtime, logResult);
                return true;
            }
            if (logout != null) {
                logResult.resultCode = logout.errorCode;
                logResult.resultMessage = logout.errorMessage;
                logResult.traceId = logout.traceId;
            } else {
                logResult.resultCode = ResultCode.INVALID_NETWORK;
                logResult.resultMessage = "empty RPC result from server";
            }
            ACLogEvent.commonEvent(LogConstants.EVENT_ID_AUTH_LOGOUT, elapsedRealtime, logResult);
            return false;
        } catch (Throwable th) {
            ACLogEvent.commonEvent(LogConstants.EVENT_ID_AUTH_LOGOUT, elapsedRealtime, logResult);
            throw th;
        }
    }
}

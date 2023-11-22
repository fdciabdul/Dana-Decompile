package com.iap.ac.android.biz.common.risk;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.facade.MobilePaymentTokenIdPostFacade;
import com.iap.ac.android.biz.common.rpc.request.MobilePaymentTokenIdPostRequest;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentTokenIdPostResult;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class ApdidTokenReportProcessor extends BaseNetwork<MobilePaymentTokenIdPostFacade> {
    public static final int MAX_RETRY_TIMES = 3;
    public static final long RETRY_TIME_INTERVAL = 500;

    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<MobilePaymentTokenIdPostFacade> getFacadeClass() {
        return MobilePaymentTokenIdPostFacade.class;
    }

    public boolean reportTokenId(String str) {
        MobilePaymentTokenIdPostResult reportTokenId;
        MobilePaymentTokenIdPostRequest mobilePaymentTokenIdPostRequest = new MobilePaymentTokenIdPostRequest();
        mobilePaymentTokenIdPostRequest.apdidToken = str;
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                reportTokenId = getFacade().reportTokenId(mobilePaymentTokenIdPostRequest);
            } catch (Throwable unused) {
                reportUploadTokenIdResult(false, null, null, SystemClock.elapsedRealtime() - elapsedRealtime, null);
            }
            if (reportTokenId != null && reportTokenId.success) {
                reportUploadTokenIdResult(true, null, null, SystemClock.elapsedRealtime() - elapsedRealtime, reportTokenId.traceId);
                z = true;
                return true;
            }
            if (reportTokenId != null) {
                reportUploadTokenIdResult(false, reportTokenId.errorCode, reportTokenId.errorMessage, SystemClock.elapsedRealtime() - elapsedRealtime, reportTokenId.traceId);
            } else {
                reportUploadTokenIdResult(false, null, null, SystemClock.elapsedRealtime() - elapsedRealtime, null);
            }
            Thread.sleep(500L);
        }
        return z;
    }

    private void reportUploadTokenIdResult(boolean z, String str, String str2, long j, String str3) {
        ACLog.d(Constants.TAG, String.format("reportUploadTokenIdResult: %s, errorCode: %s, errorMessage: %s", Boolean.valueOf(z), str, str2));
        if (z) {
            ACLogEvent.commonRpcSuccessEvent("iapconnect_center", LogConstants.EVENT_ID_APDID_UPLOAD, j, str3);
        } else {
            ACLogEvent.commonRpcFailEvent("iapconnect_center", LogConstants.EVENT_ID_APDID_UPLOAD, str, str2, j, str3);
        }
    }
}

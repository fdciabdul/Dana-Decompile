package com.iap.ac.android.gol.utils;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.gol.model.SignContractBizContent;

/* loaded from: classes3.dex */
public class GolMonitorUtils {
    public static void signContractBegin(SignContractBizContent signContractBizContent) {
        if (signContractBizContent == null) {
            ACLogEvent.newLogger("iapconnect_center", LogConstants.Gol.EVENT_ID_SIGN_CONTRACT_ENTER).event();
        } else {
            ACLogEvent.newLogger("iapconnect_center", LogConstants.Gol.EVENT_ID_SIGN_CONTRACT_ENTER).addParams("referenceAgreementId", signContractBizContent.referenceAgreementId).addParams(LogConstants.Gol.KEY_AUTH_CLIENT_NAME, signContractBizContent.authClientName).event();
        }
    }

    public static void googleSignContractBegin() {
        ACLogEvent.newLogger("iapconnect_center", LogConstants.Gol.EVENT_ID_GOOGLE_SIGN_CONTRACT_ENTER).event();
    }

    public static void signContractFinish(boolean z, String str, long j, boolean z2) {
        if (z2) {
            return;
        }
        ACLogEvent.newLogger("iapconnect_center", LogConstants.Gol.EVENT_ID_SIGN_CONTRACT_FINISH).addParams("result", z ? "T" : LogConstants.RESULT_FALSE).addParams("redirectUrl", str).addParams("timeCost", Long.valueOf(SystemClock.elapsedRealtime() - j)).event();
    }

    public static void googleSignContractFinish(boolean z, long j) {
        ACLogEvent.newLogger("iapconnect_center", LogConstants.Gol.EVENT_ID_GOOGLE_SIGN_CONTRACT_FINISH).addParams("result", z ? "T" : LogConstants.RESULT_FALSE).addParams("timeCost", Long.valueOf(SystemClock.elapsedRealtime() - j)).event();
    }

    public static void signContractFail(String str, String str2, long j, boolean z) {
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Gol.EVENT_ID_SIGN_CONTRACT_FAIL, str);
        if (z) {
            return;
        }
        signContractFinish(false, str2, j, false);
    }

    public static void googleSignContractFail(String str, long j) {
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Gol.EVENT_ID_SIGN_CONTRACT_FAIL, str);
        googleSignContractFinish(false, j);
    }
}

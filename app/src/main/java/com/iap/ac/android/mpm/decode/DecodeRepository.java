package com.iap.ac.android.mpm.decode;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.internal.oauth.OAuthUtil;
import com.iap.ac.android.biz.common.model.LogResult;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.mpm.base.model.decode.result.DecodeResult;
import com.iap.ac.android.mpm.decode.source.DecodeEntityData;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class DecodeRepository {
    private static final String TAG = "DecodeRepository";
    private DecodeEntityData entityData = new DecodeEntityData();

    public DecodeResult decode(String str, boolean z) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int oAuthChainType = OAuthUtil.getInstance().getOAuthChainType();
        LogResult logResult = new LogResult();
        try {
            try {
                DecodeResult decode = this.entityData.decode(str, z);
                if (decode != null) {
                    logResult.resultCode = decode.success ? "SUCCESS" : decode.errorCode;
                    logResult.resultMessage = decode.errorMessage;
                    logResult.traceId = decode.traceId;
                } else {
                    logResult.resultMessage = "decode result is null";
                    logResult.resultCode = ResultCode.UNKNOWN_EXCEPTION;
                    logResult.traceId = "";
                }
                if (decode == null || !decode.success) {
                    ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_MPM_CODE_SCAN_ERROR).addParams("resultMessage", logResult.resultMessage).addParams("resultCode", logResult.resultCode).addParams("traceId", logResult.traceId).setEventType(LogEventType.CRUCIAL_LOG).event();
                }
                return decode;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("decode error:");
                sb.append(e);
                ACLog.e(TAG, sb.toString());
                ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Mpm.AC_MPM_CODE_SCAN_ERROR, Utils.e(e));
                throw e;
            }
        } finally {
            HashMap hashMap = new HashMap();
            hashMap.put(LogConstants.KEY_OAUTH_TYPE, String.valueOf(oAuthChainType));
            ACLogEvent.commonEvent(LogConstants.Mpm.AC_MPM_CODE_SCAN, elapsedRealtime, hashMap, logResult);
        }
    }
}

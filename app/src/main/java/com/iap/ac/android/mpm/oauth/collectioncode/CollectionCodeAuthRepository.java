package com.iap.ac.android.mpm.oauth.collectioncode;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.model.LogResult;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.mpm.base.model.oauth.result.PrepareCollectionCodeAuthResult;
import com.iap.ac.android.mpm.oauth.collectioncode.source.CollectionCodeAuthEntityData;

/* loaded from: classes3.dex */
public class CollectionCodeAuthRepository {
    private static final String TAG = "CollectionCodeAuthRepository";
    private CollectionCodeAuthEntityData entityData = new CollectionCodeAuthEntityData();

    public PrepareCollectionCodeAuthResult prepare(String str, String str2) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        LogResult logResult = new LogResult();
        try {
            try {
                PrepareCollectionCodeAuthResult prepare = this.entityData.prepare(str, str2);
                if (prepare != null) {
                    logResult.resultCode = prepare.success ? "SUCCESS" : prepare.errorCode;
                    logResult.resultMessage = prepare.errorMessage;
                    logResult.traceId = prepare.traceId;
                } else {
                    logResult.resultMessage = "prepare result is null";
                    logResult.resultCode = ResultCode.UNKNOWN_EXCEPTION;
                    logResult.traceId = "";
                }
                if (prepare == null || !prepare.success) {
                    ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_MPM_COLLECTIONCODE_AUTH_PREPARE_ERROR).addParams("resultMessage", logResult.resultMessage).addParams("resultCode", logResult.resultCode).addParams("traceId", logResult.traceId).setEventType(LogEventType.CRUCIAL_LOG).event();
                }
                return prepare;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("prepareCollectionCodeAuth error:");
                sb.append(Utils.e(e));
                ACLog.e(TAG, sb.toString());
                ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Mpm.AC_MPM_COLLECTIONCODE_AUTH_PREPARE_ERROR, Utils.e(e));
                throw e;
            }
        } finally {
            ACLogEvent.commonEvent(LogConstants.Mpm.AC_MPM_COLLECTIONCODE_AUTH_PREPARE, elapsedRealtime, logResult);
        }
    }
}

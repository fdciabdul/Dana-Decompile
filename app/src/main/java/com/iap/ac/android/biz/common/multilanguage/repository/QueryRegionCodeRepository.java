package com.iap.ac.android.biz.common.multilanguage.repository;

import com.iap.ac.android.biz.common.model.LogResult;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.model.multilanguage.queryregioncode.RegionCodeQueryRpcResult;
import com.iap.ac.android.biz.common.multilanguage.repository.source.QueryRegionCodeEntityData;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.event.LogEventType;

/* loaded from: classes8.dex */
public class QueryRegionCodeRepository {
    public static final String TAG = "QueryRegionCodeRepository";
    public QueryRegionCodeEntityData entityData = new QueryRegionCodeEntityData();

    public RegionCodeQueryRpcResult queryRegionCode(String str) throws Exception {
        LogResult logResult = new LogResult();
        try {
            RegionCodeQueryRpcResult queryRegionCode = this.entityData.queryRegionCode(str);
            if (queryRegionCode != null) {
                logResult.resultCode = queryRegionCode.success ? "SUCCESS" : queryRegionCode.errorCode;
                logResult.resultMessage = queryRegionCode.errorMessage;
                logResult.traceId = queryRegionCode.traceId;
            } else {
                logResult.resultMessage = "queryRegionCode result is null";
                logResult.resultCode = ResultCode.UNKNOWN_EXCEPTION;
                logResult.traceId = "";
            }
            if (queryRegionCode == null || !queryRegionCode.success) {
                ACLogEvent.newLogger("iapconnect_center", LogConstants.MultiLanguage.EVENT_ID_AC_QUERY_REGION_CODE_FAIL).addParams("resultMessage", logResult.resultMessage).addParams("resultCode", logResult.resultCode).addParams("traceId", logResult.traceId).setEventType(LogEventType.CRUCIAL_LOG).event();
            }
            return queryRegionCode;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("queryRegionCode error:");
            sb.append(th);
            ACLog.e(TAG, sb.toString());
            ACLogEvent.crucialEvent("iapconnect_center", LogConstants.MultiLanguage.EVENT_ID_AC_QUERY_REGION_CODE_FAIL, Utils.e(th));
            throw th;
        }
    }
}

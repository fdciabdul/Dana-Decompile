package com.iap.ac.android.biz.common.multilanguage.repository;

import com.iap.ac.android.biz.common.model.LogResult;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.model.multilanguage.querycity.CityQueryRpcResult;
import com.iap.ac.android.biz.common.multilanguage.repository.source.QueryCityEntityData;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.event.LogEventType;
import java.util.List;

/* loaded from: classes8.dex */
public class QueryCityRepository {
    public static final String TAG = "QueryCityRepository";
    public QueryCityEntityData entityData = new QueryCityEntityData();

    public CityQueryRpcResult queryCity(String str, List<String> list) throws Exception {
        LogResult logResult = new LogResult();
        try {
            CityQueryRpcResult queryCity = this.entityData.queryCity(str, list);
            if (queryCity != null) {
                logResult.resultCode = queryCity.success ? "SUCCESS" : queryCity.errorCode;
                logResult.resultMessage = queryCity.errorMessage;
                logResult.traceId = queryCity.traceId;
            } else {
                logResult.resultMessage = "queryCity result is null";
                logResult.resultCode = ResultCode.UNKNOWN_EXCEPTION;
                logResult.traceId = "";
            }
            if (queryCity == null || !queryCity.success) {
                ACLogEvent.newLogger("iapconnect_center", LogConstants.MultiLanguage.EVENT_ID_AC_QUERY_CITY_FAIL).addParams("resultMessage", logResult.resultMessage).addParams("resultCode", logResult.resultCode).addParams("traceId", logResult.traceId).setEventType(LogEventType.CRUCIAL_LOG).event();
            }
            return queryCity;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("queryCity error:");
            sb.append(th);
            ACLog.e(TAG, sb.toString());
            ACLogEvent.crucialEvent("iapconnect_center", LogConstants.MultiLanguage.EVENT_ID_AC_QUERY_CITY_FAIL, Utils.e(th));
            throw th;
        }
    }
}

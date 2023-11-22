package com.iap.ac.android.mpm.hook.source;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.biz.common.constants.ACConstants;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.LogResult;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.mpm.base.model.hook.HookConstants;
import com.iap.ac.android.mpm.base.model.hook.PreCreateOrderConfig;
import com.iap.ac.android.mpm.base.model.hook.request.CommonHookRequest;
import com.iap.ac.android.mpm.base.model.hook.request.TradePayParams;
import com.iap.ac.android.mpm.base.model.hook.result.CommonHookResult;
import com.iap.ac.android.rpccommon.model.facade.MobileEnvInfo;

/* loaded from: classes3.dex */
public class CommonHookEntityData extends BaseNetwork<CommonHookFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<CommonHookFacade> getFacadeClass() {
        return CommonHookFacade.class;
    }

    private CommonHookResult commonHook(CommonHookRequest commonHookRequest) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        LogResult logResult = new LogResult();
        CommonHookResult commonHookResult = null;
        try {
            try {
                commonHookResult = getFacade().commonHook(commonHookRequest);
                if (commonHookResult != null) {
                    logResult.resultCode = commonHookResult.success ? "SUCCESS" : commonHookResult.errorCode;
                    logResult.resultMessage = commonHookResult.errorMessage;
                    logResult.traceId = commonHookResult.traceId;
                } else {
                    logResult.resultMessage = "hook result is null";
                    logResult.resultCode = ResultCode.UNKNOWN_EXCEPTION;
                    logResult.traceId = "";
                }
                if (commonHookResult == null || !commonHookResult.success) {
                    ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_MPM_PAYMENT_HOOK_ERROR).addParams("resultMessage", logResult.resultMessage).addParams("resultCode", logResult.resultCode).addParams("traceId", logResult.traceId).setEventType(LogEventType.CRUCIAL_LOG).event();
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("commonHook error:");
                sb.append(e);
                ACLog.e(Constants.TAG, sb.toString());
                ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Mpm.AC_MPM_PAYMENT_HOOK_ERROR, Utils.e(e));
            }
            return commonHookResult;
        } finally {
            ACLogEvent.commonEvent(LogConstants.Mpm.AC_MPM_PAYMENT_HOOK, elapsedRealtime, logResult);
        }
    }

    public CommonHookResult hookUrl(String str) {
        CommonHookRequest commonHookRequest = new CommonHookRequest();
        commonHookRequest.hookCategory = "URL";
        commonHookRequest.hookUrl = str;
        return commonHook(commonHookRequest);
    }

    public CommonHookResult hookJsAPI(PreCreateOrderConfig preCreateOrderConfig) {
        CommonHookRequest commonHookRequest = new CommonHookRequest();
        if (preCreateOrderConfig.isOrderStrFromMiniProgram) {
            commonHookRequest.envInfo = new MobileEnvInfo();
            commonHookRequest.envInfo.orderTerminalType = ACConstants.OrderTerminalType.MINI_APP;
        }
        commonHookRequest.hookCategory = HookConstants.HookCategory.HOOK_CATEGORY_TRADEPAY;
        commonHookRequest.acquirerId = preCreateOrderConfig.acquirerId;
        commonHookRequest.tradePayParams = new TradePayParams();
        commonHookRequest.tradePayParams.orderStr = preCreateOrderConfig.orderStr;
        commonHookRequest.tradePayParams.tradeNo = preCreateOrderConfig.tradeNo;
        return commonHook(commonHookRequest);
    }
}

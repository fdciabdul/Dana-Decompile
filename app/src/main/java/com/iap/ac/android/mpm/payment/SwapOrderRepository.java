package com.iap.ac.android.mpm.payment;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.model.LogResult;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.mpm.base.model.payment.result.SwapOrderResult;
import com.iap.ac.android.mpm.payment.source.SwapOrderEntityData;
import java.util.Map;

/* loaded from: classes3.dex */
public class SwapOrderRepository {
    private static final String TAG = "SwapOrderRepository";
    private SwapOrderEntityData entityData = new SwapOrderEntityData();

    public SwapOrderResult swapOrder(Map<String, String> map, String str, String str2, boolean z) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        LogResult logResult = new LogResult();
        try {
            try {
                SwapOrderResult swapOrder = this.entityData.swapOrder(map, str, str2, z);
                if (swapOrder != null) {
                    logResult.resultCode = swapOrder.success ? "SUCCESS" : swapOrder.errorCode;
                    logResult.resultMessage = swapOrder.errorMessage;
                    logResult.traceId = swapOrder.traceId;
                } else {
                    logResult.resultMessage = "swap order result is null";
                    logResult.resultCode = ResultCode.UNKNOWN_EXCEPTION;
                    logResult.traceId = "";
                }
                if (swapOrder == null || !swapOrder.success) {
                    ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_MPM_SWAP_ORDER_ERROR).addParams("resultMessage", logResult.resultMessage).addParams("resultCode", logResult.resultCode).addParams("traceId", logResult.traceId).setEventType(LogEventType.CRUCIAL_LOG).event();
                }
                return swapOrder;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("SwapOrderRepository error:");
                sb.append(Utils.e(e));
                ACLog.e(TAG, sb.toString());
                ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Mpm.AC_MPM_SWAP_ORDER_ERROR, Utils.e(e));
                throw e;
            }
        } finally {
            ACLogEvent.commonEvent(LogConstants.Mpm.AC_MPM_SWAP_ORDER, elapsedRealtime, logResult);
        }
    }
}

package com.iap.ac.android.mpm.node.pay;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.callback.IPayCallback;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.PayResult;
import com.iap.ac.android.biz.common.model.PayResultCode;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.base.interfaces.INodeCallback;
import com.iap.ac.android.mpm.node.base.BaseNode;

/* loaded from: classes3.dex */
public class PayNode extends BaseNode<PayNodeRequest, PayNodeResponse> {
    @Override // com.iap.ac.android.mpm.node.base.BaseNode
    public void handleNode(PayNodeRequest payNodeRequest, final INodeCallback<PayNodeResponse> iNodeCallback) {
        String str = payNodeRequest.paymentId;
        String str2 = payNodeRequest.paymentUrl;
        String str3 = payNodeRequest.paymentRedirectUrl;
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_PAY_START).addParams("paymentId", str).addParams("url", str2).addParams("redirectUrl", str3).event();
        ACLog.i(Constants.TAG, String.format("decode.uri = %s, paymentId = %s, redirectUrl = %s", str2, str, str3));
        SPIManager.getInstance().pay(str2, str, payNodeRequest.aclAPIContext, new IPayCallback() { // from class: com.iap.ac.android.mpm.node.pay.PayNode.1
            {
                PayNode.this = this;
            }

            @Override // com.iap.ac.android.biz.common.callback.IPayCallback
            public void onResult(PayResult payResult) {
                ACLog.i(Constants.TAG, "pay finished");
                if (payResult == null) {
                    payResult = new PayResult();
                    payResult.setResultCode(PayResultCode.PAY_FAILURE);
                    payResult.setResultMessage("PARAM_ILLEGAL");
                }
                Result result = new Result(payResult, false);
                ACLogEvent.commonEvent(LogConstants.Mpm.AC_PAY_END, elapsedRealtime, result);
                Result result2 = new Result(payResult, true);
                PayNodeResponse payNodeResponse = new PayNodeResponse();
                payNodeResponse.payResult = payResult;
                payNodeResponse.result = result2;
                payNodeResponse.logResultCode = result.resultCode;
                payNodeResponse.logResultMsg = result.resultMessage;
                payNodeResponse.endNode = "pay";
                iNodeCallback.onResult(payNodeResponse);
            }
        });
    }
}

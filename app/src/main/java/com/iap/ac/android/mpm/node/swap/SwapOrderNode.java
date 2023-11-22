package com.iap.ac.android.mpm.node.swap;

import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.base.interfaces.INodeCallback;
import com.iap.ac.android.mpm.base.model.payment.result.SwapOrderResult;
import com.iap.ac.android.mpm.node.base.BaseNode;
import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.payment.SwapOrderRepository;

/* loaded from: classes3.dex */
public class SwapOrderNode extends BaseNode<SwapOrderNodeRequest, SwapOrderNodeResponse> {
    public SwapOrderRepository getSwapOrderRepository() {
        return new SwapOrderRepository();
    }

    @Override // com.iap.ac.android.mpm.node.base.BaseNode
    public void handleNode(SwapOrderNodeRequest swapOrderNodeRequest, INodeCallback<SwapOrderNodeResponse> iNodeCallback) {
        SwapOrderNodeResponse swapOrderNodeResponse = new SwapOrderNodeResponse();
        Result result = new Result();
        try {
            SwapOrderResult swapOrder = getSwapOrderRepository().swapOrder(swapOrderNodeRequest.params, swapOrderNodeRequest.tradeNO, swapOrderNodeRequest.acquireId, swapOrderNodeRequest.isAcMiniProgram);
            if (swapOrder == null) {
                ACLog.w(Constants.TAG, "swapOrder result is null");
                result.resultCode = ResultCode.INVALID_NETWORK;
                result.resultMessage = "Oops! System busy. Try again later!";
                appendErrorInfo(swapOrderNodeResponse, result, ResultCode.INVALID_NETWORK, "swapOrder result is null");
            } else if (!swapOrder.success) {
                ACLog.w(Constants.TAG, "swapOrder result.success is false");
                result.resultCode = swapOrder.errorCode;
                result.resultMessage = swapOrder.errorMessage;
                appendErrorInfo(swapOrderNodeResponse, result, swapOrder.errorCode, swapOrder.errorMessage);
            } else {
                swapOrderNodeResponse.result = result;
                swapOrderNodeResponse.cashierUrl = swapOrder.cashierUrl;
                swapOrderNodeResponse.pspPaymentId = swapOrder.pspPaymentId;
                swapOrderNodeResponse.isSuccess = true;
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("swap order error:");
            sb.append(e);
            String obj = sb.toString();
            result.resultCode = ResultCode.INVALID_NETWORK;
            result.resultMessage = "Oops! System busy. Try again later!";
            appendErrorInfo(swapOrderNodeResponse, result, ResultCode.INVALID_NETWORK, obj);
        }
        iNodeCallback.onResult(swapOrderNodeResponse);
    }

    private void appendErrorInfo(NodeResponse nodeResponse, Result result, String str, String str2) {
        nodeResponse.result = result;
        if (str == null) {
            str = ResultCode.INVALID_NETWORK;
        }
        nodeResponse.logResultCode = str;
        if (str2 == null) {
            str2 = "Oops! System busy. Try again later!";
        }
        nodeResponse.logResultMsg = str2;
        nodeResponse.endNode = LogConstants.Mpm.EndNodeType.SWAPORDER;
    }
}

package com.iap.ac.android.mpm.biz.base;

import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.base.interfaces.INodeCallback;
import com.iap.ac.android.mpm.base.model.route.DecodeActionType;
import com.iap.ac.android.mpm.biz.base.BaseBizProcessor;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNode;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeRequest;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeResponse;
import com.iap.ac.android.mpm.node.hook.CommonHookNode;
import com.iap.ac.android.mpm.node.hook.CommonHookNodeRequest;
import com.iap.ac.android.mpm.node.hook.CommonHookNodeResponse;
import com.iap.ac.android.mpm.node.pay.PayNode;
import com.iap.ac.android.mpm.node.pay.PayNodeRequest;
import com.iap.ac.android.mpm.node.pay.PayNodeResponse;
import com.iap.ac.android.mpm.node.swap.SwapOrderNode;
import com.iap.ac.android.mpm.node.swap.SwapOrderNodeRequest;
import com.iap.ac.android.mpm.node.swap.SwapOrderNodeResponse;
import com.iap.ac.android.mpm.node.url.OpenUrlNode;
import com.iap.ac.android.mpm.node.url.OpenUrlNodeRequest;
import com.iap.ac.android.mpm.node.url.OpenUrlNodeResponse;

/* loaded from: classes3.dex */
public abstract class BaseRoute<T extends BaseBizProcessor> {
    private EntranceType entranceType = EntranceType.Decode;

    public abstract void navigate(T t, NodeRequest nodeRequest);

    public void changeEntranceType(EntranceType entranceType) {
        this.entranceType = entranceType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleSwapOrderNodeRequest(final BaseBizProcessor baseBizProcessor, final SwapOrderNodeRequest swapOrderNodeRequest) {
        baseBizProcessor.onNodeBegin(swapOrderNodeRequest);
        new SwapOrderNode().handleNode(swapOrderNodeRequest, new INodeCallback<SwapOrderNodeResponse>() { // from class: com.iap.ac.android.mpm.biz.base.BaseRoute.1
            @Override // com.iap.ac.android.mpm.base.interfaces.INodeCallback
            public void onResult(SwapOrderNodeResponse swapOrderNodeResponse) {
                baseBizProcessor.onNodeEnd(swapOrderNodeRequest, swapOrderNodeResponse);
                if (swapOrderNodeResponse.isSuccess()) {
                    PayNodeRequest payNodeRequest = new PayNodeRequest();
                    payNodeRequest.paymentId = swapOrderNodeResponse.pspPaymentId;
                    payNodeRequest.paymentUrl = swapOrderNodeResponse.cashierUrl;
                    BaseRoute.this.handlePayNodeRequest(baseBizProcessor, payNodeRequest);
                    return;
                }
                baseBizProcessor.onProcessFinish(swapOrderNodeResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleCommonHookNodeRequest(final BaseBizProcessor baseBizProcessor, final CommonHookNodeRequest commonHookNodeRequest) {
        baseBizProcessor.onNodeBegin(commonHookNodeRequest);
        new CommonHookNode().handleNode(commonHookNodeRequest, new INodeCallback<CommonHookNodeResponse>() { // from class: com.iap.ac.android.mpm.biz.base.BaseRoute.2
            @Override // com.iap.ac.android.mpm.base.interfaces.INodeCallback
            public void onResult(CommonHookNodeResponse commonHookNodeResponse) {
                baseBizProcessor.onNodeEnd(commonHookNodeRequest, commonHookNodeResponse);
                if (commonHookNodeResponse.isSuccess()) {
                    BaseRoute.this.handleDecodeOrderNodeRequest(baseBizProcessor, new DecodeOrderNodeRequest(commonHookNodeResponse.codeValue, commonHookNodeResponse.isAcMiniProgram));
                    return;
                }
                baseBizProcessor.onProcessFinish(commonHookNodeResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleDecodeOrderNodeRequest(final BaseBizProcessor baseBizProcessor, final DecodeOrderNodeRequest decodeOrderNodeRequest) {
        baseBizProcessor.onNodeBegin(decodeOrderNodeRequest);
        new DecodeOrderNode().handleNode(decodeOrderNodeRequest, new INodeCallback<DecodeOrderNodeResponse>() { // from class: com.iap.ac.android.mpm.biz.base.BaseRoute.3
            @Override // com.iap.ac.android.mpm.base.interfaces.INodeCallback
            public void onResult(DecodeOrderNodeResponse decodeOrderNodeResponse) {
                baseBizProcessor.onNodeEnd(decodeOrderNodeRequest, decodeOrderNodeResponse);
                if (decodeOrderNodeResponse.isSuccess()) {
                    ACLog.i(Constants.TAG, String.format("DecodeOrderNodeResponse success, decodeAction = %s, entranceType = %s", decodeOrderNodeResponse.decodeAction, BaseRoute.this.entranceType));
                    if ("pay".equalsIgnoreCase(decodeOrderNodeResponse.decodeAction)) {
                        PayNodeRequest payNodeRequest = new PayNodeRequest();
                        payNodeRequest.paymentId = decodeOrderNodeResponse.paymentId;
                        payNodeRequest.paymentUrl = decodeOrderNodeResponse.paymentUrl;
                        payNodeRequest.paymentRedirectUrl = decodeOrderNodeResponse.paymentRedirectUrl;
                        BaseRoute.this.handlePayNodeRequest(baseBizProcessor, payNodeRequest);
                        return;
                    } else if (DecodeActionType.OPEN_URL.equalsIgnoreCase(decodeOrderNodeResponse.decodeAction)) {
                        if (EntranceType.Decode.equals(BaseRoute.this.entranceType)) {
                            OpenUrlNodeRequest openUrlNodeRequest = new OpenUrlNodeRequest();
                            openUrlNodeRequest.openUrl = decodeOrderNodeResponse.openUrl;
                            BaseRoute.this.handleOpenUrlNodeRequest(baseBizProcessor, openUrlNodeRequest);
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(BaseRoute.this.entranceType);
                        sb.append(" open url is not support");
                        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.Mpm.AC_MPM_DECODE_PARAMS_ERROR, sb.toString());
                        return;
                    } else {
                        return;
                    }
                }
                baseBizProcessor.onProcessFinish(decodeOrderNodeResponse);
            }
        });
    }

    protected void handlePayNodeRequest(final BaseBizProcessor baseBizProcessor, final PayNodeRequest payNodeRequest) {
        baseBizProcessor.onNodeBegin(payNodeRequest);
        new PayNode().handleNode(payNodeRequest, new INodeCallback<PayNodeResponse>() { // from class: com.iap.ac.android.mpm.biz.base.BaseRoute.4
            @Override // com.iap.ac.android.mpm.base.interfaces.INodeCallback
            public void onResult(PayNodeResponse payNodeResponse) {
                baseBizProcessor.onNodeEnd(payNodeRequest, payNodeResponse);
                baseBizProcessor.onProcessFinish(payNodeResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleOpenUrlNodeRequest(final BaseBizProcessor baseBizProcessor, final OpenUrlNodeRequest openUrlNodeRequest) {
        baseBizProcessor.onNodeBegin(openUrlNodeRequest);
        new OpenUrlNode().handleNode(openUrlNodeRequest, new INodeCallback<OpenUrlNodeResponse>() { // from class: com.iap.ac.android.mpm.biz.base.BaseRoute.5
            @Override // com.iap.ac.android.mpm.base.interfaces.INodeCallback
            public void onResult(OpenUrlNodeResponse openUrlNodeResponse) {
                baseBizProcessor.onNodeEnd(openUrlNodeRequest, openUrlNodeResponse);
                if (openUrlNodeResponse.isSuccess()) {
                    baseBizProcessor.onProcessPause(openUrlNodeResponse);
                } else {
                    baseBizProcessor.onProcessFinish(openUrlNodeResponse);
                }
            }
        });
    }
}

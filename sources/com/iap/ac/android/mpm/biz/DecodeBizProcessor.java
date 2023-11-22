package com.iap.ac.android.mpm.biz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.container.IContainerPresenter;
import com.iap.ac.android.common.container.event.IContainerListener;
import com.iap.ac.android.common.container.utils.ContainerUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import com.iap.ac.android.mpm.biz.base.BaseBizProcessor;
import com.iap.ac.android.mpm.biz.base.EntranceType;
import com.iap.ac.android.mpm.interceptor.provider.UAProvider;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;
import com.iap.ac.android.mpm.node.url.OpenUrlNodeRequest;
import com.iap.ac.android.mpm.node.url.OpenUrlNodeResponse;

/* loaded from: classes3.dex */
public abstract class DecodeBizProcessor extends BaseBizProcessor {
    protected String bizKey;
    protected String bizName;
    protected String codeValue;
    public IContainerPresenter containerPresenter;
    protected Context context;
    protected String paymentCancelUrl;
    protected String paymentRedirectUrl;
    protected String thirdPartyError;
    protected boolean hasProcessFinished = false;
    protected EntranceType entranceType = EntranceType.Decode;

    protected void handlePaymentRedirectUrl(Result result) {
    }

    public DecodeBizProcessor(String str, Context context, String str2, String str3, IDecodeCallback iDecodeCallback) {
        this.bizName = str;
        this.context = context.getApplicationContext();
        this.codeValue = str2;
        this.scene = str3;
        this.decodeCallback = iDecodeCallback;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(SystemClock.elapsedRealtime());
        this.bizKey = sb.toString();
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessBegin() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.bizName);
        sb.append(" onProcessBegin");
        ACLog.i(Constants.TAG, sb.toString());
        this.startTime = SystemClock.elapsedRealtime();
        sendBeginLog(this.codeValue, this.bizName);
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessPause(NodeResponse nodeResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.bizName);
        sb.append(" onProcessPause ");
        sb.append(nodeResponse.nodeType());
        sb.append(" is ");
        sb.append(nodeResponse.isSuccess());
        ACLog.i(Constants.TAG, sb.toString());
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessResume(NodeRequest nodeRequest, BizProcessResumeParams bizProcessResumeParams) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.bizName);
        sb.append(" onProcessResume");
        sb.append(nodeRequest.getNodeType());
        ACLog.i(Constants.TAG, sb.toString());
        this.entranceType = bizProcessResumeParams.entranceType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleOnResumeError(final NodeType nodeType) {
        ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_MPM_NODE_TYPE_ERROR).addParams(LogConstants.BIZ_NAME, this.bizName).addParams(LogConstants.NODE_TYPE, nodeType).setEventType(LogEventType.CRUCIAL_LOG).event();
        Result result = new Result();
        result.resultCode = "PARAM_ILLEGAL";
        result.resultMessage = "Oops! System busy. Try again later!";
        NodeResponse nodeResponse = new NodeResponse() { // from class: com.iap.ac.android.mpm.biz.DecodeBizProcessor.1
            @Override // com.iap.ac.android.mpm.node.base.NodeResponse
            public boolean isSuccess() {
                return false;
            }

            @Override // com.iap.ac.android.mpm.node.base.NodeResponse
            public NodeType nodeType() {
                return nodeType;
            }
        };
        nodeResponse.result = result;
        nodeResponse.logResultCode = "PARAM_ILLEGAL";
        StringBuilder sb = new StringBuilder();
        sb.append(this.bizName);
        sb.append("onProcessResume can't recognize ");
        sb.append(nodeType);
        nodeResponse.logResultMsg = sb.toString();
        nodeResponse.endNode = "resume";
        onProcessFinish(nodeResponse);
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessFinish(NodeResponse nodeResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.bizName);
        sb.append(" onProcessFinish ");
        sb.append(nodeResponse.nodeType());
        sb.append(" is ");
        sb.append(nodeResponse.isSuccess());
        ACLog.i(Constants.TAG, sb.toString());
        this.hasProcessFinished = true;
        sendFinishLog(nodeResponse, this.bizName, this.paymentRedirectUrl);
        handleProcessFinish(nodeResponse);
        nodeResponse.result.thirdPartyError = this.thirdPartyError;
        sendResult(nodeResponse.result);
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onNodeBegin(NodeRequest nodeRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.bizName);
        sb.append(" onNodeBegin ");
        sb.append(nodeRequest.getNodeType());
        ACLog.i(Constants.TAG, sb.toString());
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onNodeEnd(NodeRequest nodeRequest, NodeResponse nodeResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.bizName);
        sb.append(" onNodeEnd ");
        sb.append(nodeResponse.nodeType());
        sb.append(" is ");
        sb.append(nodeResponse.isSuccess());
        ACLog.i(Constants.TAG, sb.toString());
    }

    protected void handleProcessFinish(NodeResponse nodeResponse) {
        if (nodeResponse.isSuccess() && NodeType.Pay.equals(nodeResponse.nodeType())) {
            handlePaymentRedirectUrl(nodeResponse.result);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateOpenUrlRequestParams(OpenUrlNodeRequest openUrlNodeRequest) {
        BizProcessorManager.addProcessor(this.bizKey, this);
        openUrlNodeRequest.bizKey = this.bizKey;
        openUrlNodeRequest.context = this.context;
        openUrlNodeRequest.acDecodeConfig = this.acDecodeConfig;
        openUrlNodeRequest.listener = new IContainerListener() { // from class: com.iap.ac.android.mpm.biz.DecodeBizProcessor.2
            @Override // com.iap.ac.android.common.container.event.IContainerListener
            public void onContainerCreated(Bundle bundle) {
                StringBuilder sb = new StringBuilder();
                sb.append(DecodeBizProcessor.this.bizName);
                sb.append(" onContainerCreated");
                ACLog.d(Constants.TAG, sb.toString());
            }

            @Override // com.iap.ac.android.common.container.event.IContainerListener
            public void onContainerDestroyed(Bundle bundle) {
                StringBuilder sb = new StringBuilder();
                sb.append(DecodeBizProcessor.this.bizName);
                sb.append(" onContainerDestroyed");
                ACLog.d(Constants.TAG, sb.toString());
                BizProcessorManager.removeProcessor(DecodeBizProcessor.this.bizKey);
                if (DecodeBizProcessor.this.hasProcessFinished) {
                    return;
                }
                UAProvider.enableUserAgent(false);
                Result result = new Result();
                result.resultCode = "USER_CANCEL";
                result.resultMessage = ResultCode.USER_CANCEL_MESSAGE;
                DecodeBizProcessor.this.onProcessFinish(OpenUrlNodeResponse.buildContainerDestroyedResp(result));
            }
        };
    }

    public void closeWebView() {
        IContainerPresenter iContainerPresenter = this.containerPresenter;
        if (iContainerPresenter == null) {
            return;
        }
        try {
            iContainerPresenter.closeWebview();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.bizName);
            sb.append("close webview error:");
            sb.append(e);
            String obj = sb.toString();
            ACLog.e(Constants.TAG, obj);
            ACLogEvent.exceptionLog(obj);
        }
    }

    public void bringWebContainerForeground(IContainerPresenter iContainerPresenter) {
        if (iContainerPresenter == null || iContainerPresenter.getActivity() == null) {
            return;
        }
        Class<?> cls = iContainerPresenter.getActivity().getClass();
        if (ContainerUtils.isActivityRunning(iContainerPresenter.getActivity())) {
            Intent intent = new Intent(iContainerPresenter.getActivity().getApplicationContext(), cls);
            intent.setFlags(805306368);
            iContainerPresenter.getActivity().getApplicationContext().startActivity(intent);
        }
    }
}

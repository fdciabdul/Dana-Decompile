package com.iap.ac.android.mpm.biz.gof;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.container.js.ContainerBridgeContext;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import com.iap.ac.android.mpm.base.model.route.ACDecodeConfig;
import com.iap.ac.android.mpm.base.model.tradepay.TradePayResultUtils;
import com.iap.ac.android.mpm.biz.BizProcessResumeParams;
import com.iap.ac.android.mpm.biz.DecodeBizProcessor;
import com.iap.ac.android.mpm.biz.base.EntranceType;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeResponse;
import com.iap.ac.android.mpm.node.oauth.GetAuthCodeNodeResponse;
import com.iap.ac.android.mpm.node.oauth.PrepareAuthNodeRequest;
import com.iap.ac.android.mpm.node.oauth.PrepareAuthNodeResponse;
import com.iap.ac.android.mpm.node.swap.SwapOrderNodeRequest;
import com.iap.ac.android.mpm.node.url.OpenUrlNodeRequest;
import com.iap.ac.android.mpm.utils.EntryCodeData;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GofCollectionCodeBiz extends DecodeBizProcessor {
    private static final String AUTH_CODE = "${AC_AUTHCODE}";
    private String authRedirectUrl;
    private ContainerBridgeContext bridgeContext;
    private GofCollectionCodeRoute route;

    public GofCollectionCodeBiz(Context context, String str, String str2, ACDecodeConfig aCDecodeConfig, IDecodeCallback iDecodeCallback) {
        super(LogConstants.Mpm.BizScenarioType.GOF_COLLECTION_CODE, context, str, str2, iDecodeCallback);
        this.acDecodeConfig = aCDecodeConfig;
        this.route = new GofCollectionCodeRoute();
        EntryCodeData.getInstance().codeValue = str;
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessBegin() {
        if (!isToggleBiz()) {
            sendToggleOffResult();
            return;
        }
        super.onProcessBegin();
        OpenUrlNodeRequest openUrlNodeRequest = new OpenUrlNodeRequest();
        openUrlNodeRequest.openUrl = this.codeValue;
        updateOpenUrlRequestParams(openUrlNodeRequest);
        this.route.navigate(this, (NodeRequest) openUrlNodeRequest);
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessPause(NodeResponse nodeResponse) {
        super.onProcessPause(nodeResponse);
        if (NodeType.GetAuthCode.equals(nodeResponse.nodeType())) {
            redirectUrl((GetAuthCodeNodeResponse) nodeResponse);
        }
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessResume(NodeRequest nodeRequest, BizProcessResumeParams bizProcessResumeParams) {
        super.onProcessResume(nodeRequest, bizProcessResumeParams);
        NodeType nodeType = nodeRequest.getNodeType();
        String str = TextUtils.isEmpty(this.acDecodeConfig.acquireId) ? "1022088000000000001" : this.acDecodeConfig.acquireId;
        if (NodeType.PrepareAuth.equals(nodeType)) {
            this.containerPresenter = bizProcessResumeParams.containerPresenter;
            ((PrepareAuthNodeRequest) nodeRequest).acquireId = str;
            this.route.changeEntranceType(bizProcessResumeParams.entranceType);
            this.route.navigate(this, nodeRequest);
        } else if (NodeType.SwapOrder.equals(nodeType)) {
            this.containerPresenter = bizProcessResumeParams.containerPresenter;
            this.bridgeContext = bizProcessResumeParams.bridgeContext;
            ((SwapOrderNodeRequest) nodeRequest).acquireId = str;
            this.route.changeEntranceType(bizProcessResumeParams.entranceType);
            this.route.navigate(this, nodeRequest);
        } else if (NodeType.DecodeOrder.equals(nodeType)) {
            this.containerPresenter = bizProcessResumeParams.containerPresenter;
            this.route.changeEntranceType(bizProcessResumeParams.entranceType);
            this.route.navigate(this, nodeRequest);
        } else if (NodeType.CommonHook.equals(nodeType)) {
            this.containerPresenter = bizProcessResumeParams.containerPresenter;
            this.route.changeEntranceType(bizProcessResumeParams.entranceType);
            this.route.navigate(this, nodeRequest);
        } else {
            handleOnResumeError(nodeType);
        }
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor
    public void handleProcessFinish(NodeResponse nodeResponse) {
        if (EntranceType.TradePayPlugin.equals(this.entranceType)) {
            handleTradePayFinished(nodeResponse);
        } else if (nodeResponse.isSuccess() && NodeType.Pay.equals(nodeResponse.nodeType())) {
            handlePayFinished();
        }
    }

    private void handleTradePayFinished(final NodeResponse nodeResponse) {
        Result result = nodeResponse.result;
        if (this.bridgeContext != null) {
            final JSONObject tradePayResultJsonObject = TradePayResultUtils.getTradePayResultJsonObject(result.resultCode);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.iap.ac.android.mpm.biz.gof.GofCollectionCodeBiz.1
                @Override // java.lang.Runnable
                public void run() {
                    GofCollectionCodeBiz.this.bridgeContext.sendBridgeResult(tradePayResultJsonObject);
                    if (!NodeType.Pay.equals(nodeResponse.nodeType()) || !nodeResponse.isSuccess() || ConfigCenter.INSTANCE.getIsvToggle() || GofCollectionCodeBiz.this.containerPresenter == null) {
                        return;
                    }
                    GofCollectionCodeBiz.this.closeWebView();
                }
            });
        }
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onNodeBegin(NodeRequest nodeRequest) {
        super.onNodeBegin(nodeRequest);
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onNodeEnd(NodeRequest nodeRequest, NodeResponse nodeResponse) {
        super.onNodeEnd(nodeRequest, nodeResponse);
        NodeType nodeType = nodeRequest.getNodeType();
        if (nodeResponse.isSuccess() && NodeType.PrepareAuth.equals(nodeType)) {
            this.authRedirectUrl = ((PrepareAuthNodeResponse) nodeResponse).authResult.authRedirectUrl;
        } else if (NodeType.DecodeOrder.equals(nodeRequest.getNodeType())) {
            DecodeOrderNodeResponse decodeOrderNodeResponse = (DecodeOrderNodeResponse) nodeResponse;
            if ("pay".equalsIgnoreCase(decodeOrderNodeResponse.decodeAction)) {
                this.paymentRedirectUrl = decodeOrderNodeResponse.paymentRedirectUrl;
            }
            this.thirdPartyError = decodeOrderNodeResponse.thirdPartyError;
        }
    }

    private void redirectUrl(GetAuthCodeNodeResponse getAuthCodeNodeResponse) {
        if (getAuthCodeNodeResponse.isSuccess()) {
            try {
                this.containerPresenter.loadUrl(this.authRedirectUrl.replace(AUTH_CODE, getAuthCodeNodeResponse.authCode));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("GofCollectionCode redirectUrl error:");
                sb.append(e);
                String obj = sb.toString();
                ACLog.e(Constants.TAG, obj);
                GetAuthCodeNodeResponse getAuthCodeNodeResponse2 = new GetAuthCodeNodeResponse();
                Result result = new Result();
                result.resultCode = ResultCode.INVALID_NETWORK;
                result.resultMessage = "Oops! System busy. Try again later!";
                getAuthCodeNodeResponse2.logResultCode = ResultCode.INVALID_NETWORK;
                getAuthCodeNodeResponse2.logResultMsg = obj;
                getAuthCodeNodeResponse2.endNode = "redirectUrl";
                getAuthCodeNodeResponse2.isSuccess = false;
                onProcessFinish(getAuthCodeNodeResponse2);
            }
        }
    }

    private void handlePayFinished() {
        try {
            if (!ConfigCenter.INSTANCE.getIsvToggle()) {
                this.containerPresenter.closeWebview();
            } else if (TextUtils.isEmpty(this.paymentRedirectUrl)) {
            } else {
                this.containerPresenter.loadUrl(this.paymentRedirectUrl);
                bringWebContainerForeground(this.containerPresenter);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("GofCollectionCode redirectUrl error:");
            sb.append(e);
            String obj = sb.toString();
            ACLog.e(Constants.TAG, obj);
            ACLogEvent.exceptionLog(obj);
        }
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public boolean isToggleBiz() {
        ConfigCenter.INSTANCE.refreshConfigs();
        boolean mpmGofCollectionOrderToggle = ConfigCenter.INSTANCE.getMpmGofCollectionOrderToggle();
        StringBuilder sb = new StringBuilder();
        sb.append("GofCollectionCodeCodeBiz toggle is ");
        sb.append(mpmGofCollectionOrderToggle);
        ACLog.i(Constants.TAG, sb.toString());
        return mpmGofCollectionOrderToggle;
    }
}

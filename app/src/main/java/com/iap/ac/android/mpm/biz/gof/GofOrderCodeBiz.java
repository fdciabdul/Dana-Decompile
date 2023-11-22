package com.iap.ac.android.mpm.biz.gof;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.ACConstants;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import com.iap.ac.android.mpm.base.model.route.ACDecodeConfig;
import com.iap.ac.android.mpm.biz.BizProcessResumeParams;
import com.iap.ac.android.mpm.biz.DecodeBizProcessor;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeRequest;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeResponse;
import com.iap.ac.android.mpm.node.url.OpenUrlNodeRequest;

/* loaded from: classes3.dex */
public class GofOrderCodeBiz extends DecodeBizProcessor {
    private boolean isAcMiniProgram;
    private GofOrderCodeRoute route;

    public GofOrderCodeBiz(Context context, String str, boolean z, ACDecodeConfig aCDecodeConfig, String str2, IDecodeCallback iDecodeCallback) {
        super(LogConstants.Mpm.BizScenarioType.GOF_ORDER_CODE, context, str, str2, iDecodeCallback);
        this.acDecodeConfig = aCDecodeConfig;
        this.isAcMiniProgram = z;
        this.route = new GofOrderCodeRoute();
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessBegin() {
        if (!isToggleBiz()) {
            sendToggleOffResult();
            return;
        }
        super.onProcessBegin();
        this.route.navigate(this, (NodeRequest) new DecodeOrderNodeRequest(this.codeValue, this.isAcMiniProgram));
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessResume(NodeRequest nodeRequest, BizProcessResumeParams bizProcessResumeParams) {
        super.onProcessResume(nodeRequest, bizProcessResumeParams);
        NodeType nodeType = nodeRequest.getNodeType();
        if (NodeType.DecodeOrder.equals(nodeType)) {
            this.containerPresenter = bizProcessResumeParams.containerPresenter;
            this.route.changeEntranceType(bizProcessResumeParams.entranceType);
            this.route.navigate(this, (NodeRequest) ((DecodeOrderNodeRequest) nodeRequest));
            return;
        }
        handleOnResumeError(nodeType);
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onNodeBegin(NodeRequest nodeRequest) {
        super.onNodeBegin(nodeRequest);
        NodeType nodeType = nodeRequest.getNodeType();
        if (NodeType.DecodeOrder.equals(nodeRequest.getNodeType())) {
            showLoading();
        } else if (NodeType.OpenUrl.equals(nodeType)) {
            updateOpenUrlRequestParams((OpenUrlNodeRequest) nodeRequest);
        }
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor, com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onNodeEnd(NodeRequest nodeRequest, NodeResponse nodeResponse) {
        super.onNodeEnd(nodeRequest, nodeResponse);
        if (NodeType.DecodeOrder.equals(nodeResponse.nodeType())) {
            DecodeOrderNodeResponse decodeOrderNodeResponse = (DecodeOrderNodeResponse) nodeResponse;
            if ("pay".equalsIgnoreCase(decodeOrderNodeResponse.decodeAction)) {
                this.paymentRedirectUrl = decodeOrderNodeResponse.paymentRedirectUrl;
            }
            this.thirdPartyError = decodeOrderNodeResponse.thirdPartyError;
            dismissLoading();
        }
    }

    @Override // com.iap.ac.android.mpm.biz.DecodeBizProcessor
    public void handlePaymentRedirectUrl(Result result) {
        boolean equalsIgnoreCase = ACConstants.Scene.SOURCE_FROM_WEBVIEW.equalsIgnoreCase(this.scene);
        boolean z = !TextUtils.isEmpty(this.paymentRedirectUrl);
        redirectUrl(z, equalsIgnoreCase);
        if (!z || !equalsIgnoreCase) {
            ACLog.i(Constants.TAG, String.format("payment redirect url  is %s, scene is %s", this.paymentRedirectUrl, this.scene));
            return;
        }
        ACLog.i(Constants.TAG, "return to web page and reload paymentRedirectUrl");
        result.closeWebpage = false;
        result.merchantResultPageUrl = this.paymentRedirectUrl;
    }

    private void redirectUrl(boolean z, boolean z2) {
        if (this.containerPresenter == null) {
            return;
        }
        try {
            if (!ConfigCenter.INSTANCE.getIsvToggle()) {
                this.containerPresenter.closeWebview();
            } else if (!z || z2) {
            } else {
                this.containerPresenter.loadUrl(this.paymentRedirectUrl);
                bringWebContainerForeground(this.containerPresenter);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("GofOrderCodeBiz redirectUrl error:");
            sb.append(e);
            String obj = sb.toString();
            ACLog.e(Constants.TAG, obj);
            ACLogEvent.exceptionLog(obj);
        }
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public boolean isToggleBiz() {
        ConfigCenter.INSTANCE.refreshConfigs();
        boolean mpmGofOrderToggle = ConfigCenter.INSTANCE.getMpmGofOrderToggle();
        StringBuilder sb = new StringBuilder();
        sb.append("GofOrderCodeBiz toggle is ");
        sb.append(mpmGofOrderToggle);
        ACLog.i(Constants.TAG, sb.toString());
        return mpmGofOrderToggle;
    }
}

package com.iap.ac.android.mpm.biz.miniprogram;

import android.os.SystemClock;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.base.interfaces.IDecodeCallback;
import com.iap.ac.android.mpm.base.model.hook.PreCreateOrderConfig;
import com.iap.ac.android.mpm.base.model.hook.request.TradePayParams;
import com.iap.ac.android.mpm.biz.BizProcessResumeParams;
import com.iap.ac.android.mpm.biz.base.BaseBizProcessor;
import com.iap.ac.android.mpm.biz.base.EntranceType;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeRequest;
import com.iap.ac.android.mpm.node.hook.CommonHookNodeRequest;
import com.iap.ac.android.mpm.node.pay.PayNodeRequest;
import com.iap.ac.android.mpm.node.pay.PayNodeResponse;
import com.iap.ac.android.mpm.node.swap.SwapOrderNodeRequest;
import java.util.Map;

/* loaded from: classes8.dex */
public class MiniProgramTradePayBiz extends BaseBizProcessor {
    private static final String ACQUIRE_ID = "acquireId";
    private final AclAPIContext aclAPIContext;
    private final Map<String, String> params;
    private final TradePayParams tradePayParams;

    public MiniProgramTradePayBiz(Map<String, String> map, TradePayParams tradePayParams, AclAPIContext aclAPIContext, IDecodeCallback iDecodeCallback) {
        this.params = map;
        this.tradePayParams = tradePayParams;
        this.aclAPIContext = aclAPIContext;
        this.decodeCallback = iDecodeCallback;
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessBegin() {
        NodeRequest nodeRequest;
        String str = null;
        ACManager.getInstance().fetchConfigAsync(null);
        if (!isToggleBiz()) {
            sendToggleOffResult();
            return;
        }
        MiniProgramTradePayRoute miniProgramTradePayRoute = new MiniProgramTradePayRoute();
        miniProgramTradePayRoute.changeEntranceType(EntranceType.TradePayPlugin);
        String str2 = this.params.get(ACQUIRE_ID);
        if (TextUtils.isEmpty(str2)) {
            str2 = "1022088000000000001";
        }
        if (!TextUtils.isEmpty(this.tradePayParams.tradeNo)) {
            str = this.tradePayParams.tradeNo;
            nodeRequest = new SwapOrderNodeRequest(this.params, str, str2, true);
        } else if (!TextUtils.isEmpty(this.tradePayParams.orderStr)) {
            str = this.tradePayParams.orderStr;
            PreCreateOrderConfig preCreateOrderConfig = new PreCreateOrderConfig();
            preCreateOrderConfig.orderStr = str;
            preCreateOrderConfig.isOrderStrFromMiniProgram = true;
            preCreateOrderConfig.acquirerId = str2;
            nodeRequest = new CommonHookNodeRequest(preCreateOrderConfig);
        } else if (TextUtils.isEmpty(this.tradePayParams.paymentUrl)) {
            nodeRequest = null;
        } else {
            str = this.tradePayParams.paymentUrl;
            nodeRequest = new DecodeOrderNodeRequest(this.tradePayParams.paymentUrl, true);
        }
        this.startTime = SystemClock.elapsedRealtime();
        sendBeginLog(str, LogConstants.Mpm.BizScenarioType.MINI_PROGRAM_TRADE_PAY);
        if (nodeRequest == null) {
            PayNodeResponse payNodeResponse = new PayNodeResponse();
            Result result = new Result();
            payNodeResponse.logResultCode = "PARAM_ILLEGAL";
            result.resultCode = "PARAM_ILLEGAL";
            result.resultMessage = "Oops! System busy. Try again later!";
            payNodeResponse.logResultMsg = "all parameters are empty";
            payNodeResponse.result = result;
            payNodeResponse.endNode = "pay";
            onProcessFinish(payNodeResponse);
            return;
        }
        miniProgramTradePayRoute.navigate(this, nodeRequest);
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessPause(NodeResponse nodeResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append("MiniProgramTradePayBiz onProcessPause ");
        sb.append(nodeResponse.nodeType());
        ACLog.i(Constants.TAG, sb.toString());
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessResume(NodeRequest nodeRequest, BizProcessResumeParams bizProcessResumeParams) {
        StringBuilder sb = new StringBuilder();
        sb.append("MiniProgramTradePayBiz onProcessResume ");
        sb.append(nodeRequest.getNodeType());
        ACLog.i(Constants.TAG, sb.toString());
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onProcessFinish(NodeResponse nodeResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append("MiniProgramTradePayBiz onProcessFinish ");
        sb.append(nodeResponse.nodeType());
        ACLog.i(Constants.TAG, sb.toString());
        sendFinishLog(nodeResponse, LogConstants.Mpm.BizScenarioType.MINI_PROGRAM_TRADE_PAY, null);
        sendResult(nodeResponse.result);
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onNodeBegin(NodeRequest nodeRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append("MiniProgramTradePayBiz onNodeBegin ");
        sb.append(nodeRequest.getNodeType());
        ACLog.i(Constants.TAG, sb.toString());
        if (NodeType.Pay.equals(nodeRequest.getNodeType())) {
            ((PayNodeRequest) nodeRequest).aclAPIContext = this.aclAPIContext;
        }
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public void onNodeEnd(NodeRequest nodeRequest, NodeResponse nodeResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append("MiniProgramTradePayBiz onNodeEnd ");
        sb.append(nodeResponse.nodeType());
        ACLog.i(Constants.TAG, sb.toString());
    }

    @Override // com.iap.ac.android.mpm.biz.base.BaseBizProcessor
    public boolean isToggleBiz() {
        ConfigCenter.INSTANCE.refreshConfigs();
        boolean mpmMiniAppToggle = ConfigCenter.INSTANCE.getMpmMiniAppToggle();
        StringBuilder sb = new StringBuilder();
        sb.append("MiniProgramTradePayBiz toggle is ");
        sb.append(mpmMiniAppToggle);
        ACLog.i(Constants.TAG, sb.toString());
        return mpmMiniAppToggle;
    }
}

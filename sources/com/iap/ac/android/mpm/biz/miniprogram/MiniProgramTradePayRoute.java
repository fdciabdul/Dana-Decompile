package com.iap.ac.android.mpm.biz.miniprogram;

import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.biz.base.BaseRoute;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeType;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeRequest;
import com.iap.ac.android.mpm.node.hook.CommonHookNodeRequest;
import com.iap.ac.android.mpm.node.swap.SwapOrderNodeRequest;

/* loaded from: classes8.dex */
public class MiniProgramTradePayRoute extends BaseRoute<MiniProgramTradePayBiz> {
    @Override // com.iap.ac.android.mpm.biz.base.BaseRoute
    public void navigate(MiniProgramTradePayBiz miniProgramTradePayBiz, NodeRequest nodeRequest) {
        NodeType nodeType = nodeRequest.getNodeType();
        if (NodeType.SwapOrder.equals(nodeType)) {
            handleSwapOrderNodeRequest(miniProgramTradePayBiz, (SwapOrderNodeRequest) nodeRequest);
        } else if (NodeType.CommonHook.equals(nodeType)) {
            handleCommonHookNodeRequest(miniProgramTradePayBiz, (CommonHookNodeRequest) nodeRequest);
        } else if (NodeType.DecodeOrder.equals(nodeType)) {
            handleDecodeOrderNodeRequest(miniProgramTradePayBiz, (DecodeOrderNodeRequest) nodeRequest);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("MiniProgramTradePayRoute node type is illegal");
            sb.append(nodeType);
            ACLog.w(Constants.TAG, sb.toString());
        }
    }
}

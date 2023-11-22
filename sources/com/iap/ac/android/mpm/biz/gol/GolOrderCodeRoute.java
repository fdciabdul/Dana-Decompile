package com.iap.ac.android.mpm.biz.gol;

import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.biz.base.BaseRoute;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeType;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeRequest;

/* loaded from: classes3.dex */
public class GolOrderCodeRoute extends BaseRoute<GolOrderCodeBiz> {
    @Override // com.iap.ac.android.mpm.biz.base.BaseRoute
    public void navigate(GolOrderCodeBiz golOrderCodeBiz, NodeRequest nodeRequest) {
        NodeType nodeType = nodeRequest.getNodeType();
        if (NodeType.DecodeOrder.equals(nodeType)) {
            handleDecodeOrderNodeRequest(golOrderCodeBiz, (DecodeOrderNodeRequest) nodeRequest);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("GolOrderCodeRoute node type is illegal");
        sb.append(nodeType);
        ACLog.w(Constants.TAG, sb.toString());
    }
}

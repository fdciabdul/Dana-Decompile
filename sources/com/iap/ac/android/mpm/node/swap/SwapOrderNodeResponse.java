package com.iap.ac.android.mpm.node.swap;

import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class SwapOrderNodeResponse extends NodeResponse {
    public String cashierUrl;
    public boolean isSuccess;
    public String pspPaymentId;

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public NodeType nodeType() {
        return NodeType.SwapOrder;
    }

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public boolean isSuccess() {
        return this.isSuccess;
    }
}

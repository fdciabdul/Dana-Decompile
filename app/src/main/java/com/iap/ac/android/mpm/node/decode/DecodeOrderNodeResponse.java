package com.iap.ac.android.mpm.node.decode;

import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class DecodeOrderNodeResponse extends NodeResponse {
    public String decodeAction;
    public boolean isSuccess;
    public String openUrl;
    public String paymentCancelUrl;
    public String paymentId;
    public String paymentRedirectUrl;
    public String paymentUrl;
    public String terminalType;
    public String thirdPartyError;

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public NodeType nodeType() {
        return NodeType.DecodeOrder;
    }

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public boolean isSuccess() {
        return this.isSuccess;
    }
}

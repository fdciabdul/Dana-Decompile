package com.iap.ac.android.mpm.node.oauth;

import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class GetAuthCodeNodeResponse extends NodeResponse {
    public String authCode;
    public boolean isSuccess;

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public NodeType nodeType() {
        return NodeType.GetAuthCode;
    }

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public boolean isSuccess() {
        return this.isSuccess;
    }
}

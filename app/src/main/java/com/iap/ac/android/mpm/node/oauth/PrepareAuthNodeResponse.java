package com.iap.ac.android.mpm.node.oauth;

import com.iap.ac.android.mpm.base.model.oauth.result.PrepareCollectionCodeAuthResult;
import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class PrepareAuthNodeResponse extends NodeResponse {
    public PrepareCollectionCodeAuthResult authResult;
    public boolean isSuccess;

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public NodeType nodeType() {
        return NodeType.PrepareAuth;
    }

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public boolean isSuccess() {
        return this.isSuccess;
    }
}

package com.iap.ac.android.mpm.node.hook;

import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class CommonHookNodeResponse extends NodeResponse {
    public String codeValue;
    public boolean isAcMiniProgram;
    public boolean isSuccess;

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public NodeType nodeType() {
        return NodeType.CommonHook;
    }

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public boolean isSuccess() {
        return this.isSuccess;
    }
}

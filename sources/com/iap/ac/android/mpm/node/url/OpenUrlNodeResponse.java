package com.iap.ac.android.mpm.node.url;

import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class OpenUrlNodeResponse extends NodeResponse {
    public boolean isSuccess = true;

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public NodeType nodeType() {
        return NodeType.OpenUrl;
    }

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public boolean isSuccess() {
        return this.isSuccess;
    }

    public static OpenUrlNodeResponse buildContainerDestroyedResp(Result result) {
        OpenUrlNodeResponse openUrlNodeResponse = new OpenUrlNodeResponse();
        openUrlNodeResponse.isSuccess = false;
        openUrlNodeResponse.result = result;
        openUrlNodeResponse.logResultCode = result.resultCode;
        openUrlNodeResponse.logResultMsg = result.resultMessage;
        openUrlNodeResponse.endNode = "userCancel";
        return openUrlNodeResponse;
    }
}

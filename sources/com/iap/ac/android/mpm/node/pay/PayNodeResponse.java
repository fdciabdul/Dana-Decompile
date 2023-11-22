package com.iap.ac.android.mpm.node.pay;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.model.PayResult;
import com.iap.ac.android.biz.common.model.PayResultCode;
import com.iap.ac.android.mpm.node.base.NodeResponse;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class PayNodeResponse extends NodeResponse {
    public PayResult payResult;

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public NodeType nodeType() {
        return NodeType.Pay;
    }

    @Override // com.iap.ac.android.mpm.node.base.NodeResponse
    public boolean isSuccess() {
        PayResult payResult = this.payResult;
        if (payResult == null) {
            return false;
        }
        String resultCode = payResult.getResultCode();
        return TextUtils.equals(resultCode, PayResultCode.PAY_SUCCESS) || TextUtils.equals(resultCode, PayResultCode.PAY_PENDING);
    }
}

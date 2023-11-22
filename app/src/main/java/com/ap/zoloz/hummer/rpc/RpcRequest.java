package com.ap.zoloz.hummer.rpc;

import com.zoloz.zhub.common.factor.model.FactorNextRequest;

/* loaded from: classes7.dex */
public class RpcRequest {
    public FactorNextRequest factorNextRequest = new FactorNextRequest();
    public String currentTaskName = "";
    public boolean showLoading = false;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RpcRequest{factorNextRequest = ");
        sb.append(this.factorNextRequest.toString());
        sb.append(", currentTaskName = ");
        sb.append(this.currentTaskName);
        sb.append(", showLoading = ");
        sb.append(this.showLoading);
        sb.append('}');
        return sb.toString();
    }
}

package com.ap.zoloz.hummer.rpc;

import com.zoloz.zhub.common.factor.model.FactorNextResponse;

/* loaded from: classes7.dex */
public class RpcResponse {
    public FactorNextResponse factorNextResponse = new FactorNextResponse();
    public String exception = "";

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RpcResponse{factorNextResponse = ");
        sb.append(this.factorNextResponse.toString());
        sb.append(", exception = ");
        sb.append(this.exception);
        sb.append('}');
        return sb.toString();
    }
}

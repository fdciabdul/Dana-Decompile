package com.alipay.multigateway.sdk.adapter.network.mpaas;

import com.alipay.mobile.common.rpc.RpcInvokeContext;
import com.alipay.multigateway.sdk.GatewayCallback;
import com.alipay.multigateway.sdk.GatewayInfo;

/* loaded from: classes7.dex */
public abstract class MpaasRpcCallback implements GatewayCallback<RpcInvokeContext> {
    @Override // com.alipay.multigateway.sdk.GatewayCallback
    public abstract String getPlaintextForSign(GatewayInfo gatewayInfo, RpcInvokeContext rpcInvokeContext);

    @Override // com.alipay.multigateway.sdk.GatewayCallback
    public void onAfterGatewayApply(GatewayInfo gatewayInfo, RpcInvokeContext rpcInvokeContext) {
    }

    @Override // com.alipay.multigateway.sdk.GatewayCallback
    public void onNoRuleMatch(RpcInvokeContext rpcInvokeContext) {
    }

    @Override // com.alipay.multigateway.sdk.GatewayCallback
    public boolean shouldApplyGateway(GatewayInfo gatewayInfo, RpcInvokeContext rpcInvokeContext) {
        return true;
    }
}

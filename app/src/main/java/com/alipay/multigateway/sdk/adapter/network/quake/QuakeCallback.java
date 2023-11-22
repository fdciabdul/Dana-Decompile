package com.alipay.multigateway.sdk.adapter.network.quake;

import com.alipay.imobile.network.quake.Request;
import com.alipay.multigateway.sdk.GatewayCallback;
import com.alipay.multigateway.sdk.GatewayInfo;

/* loaded from: classes7.dex */
public abstract class QuakeCallback implements GatewayCallback<Request> {
    @Override // com.alipay.multigateway.sdk.GatewayCallback
    public String getPlaintextForSign(GatewayInfo gatewayInfo, Request request) {
        return "";
    }

    @Override // com.alipay.multigateway.sdk.GatewayCallback
    public void onAfterGatewayApply(GatewayInfo gatewayInfo, Request request) {
    }

    @Override // com.alipay.multigateway.sdk.GatewayCallback
    public void onNoRuleMatch(Request request) {
    }

    @Override // com.alipay.multigateway.sdk.GatewayCallback
    public boolean shouldApplyGateway(GatewayInfo gatewayInfo, Request request) {
        return true;
    }
}

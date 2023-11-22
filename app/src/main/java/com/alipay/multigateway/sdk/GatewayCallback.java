package com.alipay.multigateway.sdk;

/* loaded from: classes3.dex */
public interface GatewayCallback<Req> {
    String getPlaintextForSign(GatewayInfo gatewayInfo, Req req);

    void onAfterGatewayApply(GatewayInfo gatewayInfo, Req req);

    void onNoRuleMatch(Req req);

    boolean shouldApplyGateway(GatewayInfo gatewayInfo, Req req);
}

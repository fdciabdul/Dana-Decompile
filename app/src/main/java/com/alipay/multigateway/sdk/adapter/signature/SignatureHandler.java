package com.alipay.multigateway.sdk.adapter.signature;

import com.alipay.multigateway.sdk.GatewayInfo;

/* loaded from: classes3.dex */
public interface SignatureHandler {
    String signRequest(String str, GatewayInfo.SignInfo signInfo) throws Exception;
}

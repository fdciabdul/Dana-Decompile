package com.iap.ac.android.rpc.multigateway;

import com.alipay.multigateway.sdk.GatewayInfo;
import com.alipay.multigateway.sdk.NetworkDelegate;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.rpc.utils.RpcUtils;
import java.util.Map;

/* loaded from: classes3.dex */
public class RpcGatewayDelegate implements NetworkDelegate {
    public static final String TAG = RpcUtils.logTag("RpcGatewayDelegate");

    @Override // com.alipay.multigateway.sdk.NetworkDelegate
    public void setGatewayInfo(GatewayInfo gatewayInfo, Object obj) {
        Map<String, String> map;
        if (obj instanceof RpcRequest) {
            RpcAppInfo rpcAppInfo = new RpcAppInfo();
            rpcAppInfo.rpcGateWayUrl = gatewayInfo.targetUrl;
            rpcAppInfo.addHeaders(gatewayInfo.headers);
            GatewayInfo.SignInfo signInfo = gatewayInfo.signInfo;
            if (signInfo != null && (map = signInfo.extra) != null) {
                rpcAppInfo.appId = map.get("appId");
                rpcAppInfo.appKey = signInfo.extra.get("appKey");
                rpcAppInfo.authCode = signInfo.extra.get("authCode");
            }
            ((RpcRequest) obj).setRpcAppInfo(rpcAppInfo);
        }
    }
}

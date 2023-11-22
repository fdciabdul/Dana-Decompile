package com.iap.ac.config.lite.rpc;

import com.alipay.multigateway.sdk.GatewayController;
import com.alipay.multigateway.sdk.GatewayInfo;
import com.alipay.multigateway.sdk.Rule;
import com.alipay.multigateway.sdk.decision.condition.Condition;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.config.lite.ConfigCenterContext;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes8.dex */
public class AmcsRpcUtils {
    public static void initializeRpcGateway(GatewayController gatewayController, RpcAppInfo rpcAppInfo, String str) {
        initializeRpcGateway(gatewayController, rpcAppInfo, str, ConfigCenterContext.SchemeVersion.V1);
        initializeRpcGateway(gatewayController, rpcAppInfo, str, ConfigCenterContext.SchemeVersion.V2);
    }

    public static void initializeRpcGateway(GatewayController gatewayController, RpcAppInfo rpcAppInfo, String str, ConfigCenterContext.SchemeVersion schemeVersion) {
        ArrayList arrayList = new ArrayList();
        if (schemeVersion == ConfigCenterContext.SchemeVersion.V1) {
            arrayList.add("ap.mobileprod.amcs.config.local.fetch");
            arrayList.add("ap.mobileprod.amcs.config.fetch.by.keys");
        } else {
            arrayList.add("ap.mobileamcs.cloud.fetch.config");
            arrayList.add("ap.mobileamcs.cloud.fetch.config.by.keys");
        }
        Rule rule = new Rule(String.format("AMCS-lite-Rpc-Gateway-%s-%s", str, schemeVersion.name()), 100);
        rule.addCondition(Condition.operationTypeIn(arrayList));
        GatewayInfo.SignInfo signInfo = new GatewayInfo.SignInfo();
        signInfo.extra.put("appId", rpcAppInfo.appId);
        signInfo.extra.put("appKey", rpcAppInfo.appKey);
        signInfo.extra.put("authCode", rpcAppInfo.authCode);
        GatewayInfo gatewayInfo = new GatewayInfo();
        gatewayInfo.signInfo = signInfo;
        gatewayInfo.targetUrl = rpcAppInfo.rpcGateWayUrl;
        Map<String, String> map = rpcAppInfo.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                gatewayInfo.addHeader(entry.getKey(), entry.getValue());
            }
        }
        rule.setGatewayInfo(gatewayInfo);
        gatewayController.addRule(rule);
    }
}

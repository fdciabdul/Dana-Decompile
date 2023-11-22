package com.alipay.plus.android.config.sdk.rpc;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.securityprofiles.profile.RpcProfile;
import com.alipay.multigateway.sdk.GatewayController;
import com.alipay.multigateway.sdk.adapter.network.quake.QuakeGatewayControllerFactory;
import com.alipay.plus.android.config.sdk.a.e;

/* loaded from: classes7.dex */
public class AmcsRpcUtils {
    public static final String DEFAULT_NODE_AMCS_LITE_SERVICE = "amcsLiteService";
    public static final String DEFAULT_NODE_GRAYSCALE_SERVICE = "grayScaleService";
    public static final String DEFAULT_NODE_MDS_SERVICE = "mdsService";

    /* renamed from: a  reason: collision with root package name */
    private static final String f7384a = e.a("AmcsRpcUtils");
    private static GatewayController b;

    public static void initializeQuakeRpcGateway(Context context, RpcProfile rpcProfile) {
        initializeRpcGateway(QuakeGatewayControllerFactory.createController(context), rpcProfile);
    }

    public static void initializeRpcGateway(GatewayController gatewayController, RpcProfile rpcProfile) {
        initializeRpcGateway(gatewayController, rpcProfile, DEFAULT_NODE_MDS_SERVICE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void initializeRpcGateway(com.alipay.multigateway.sdk.GatewayController r4, com.alipay.iap.android.common.securityprofiles.profile.RpcProfile r5, java.lang.String r6) {
        /*
            com.alipay.plus.android.config.sdk.rpc.AmcsRpcUtils.b = r4
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = isMdsService(r6)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L17
            java.lang.String r1 = "com.alipayintl.imobileprod.imcs.config.fetch"
            r0.add(r1)
            java.lang.String r1 = "ap.mobileprod.amcs.config.fetch"
            goto L24
        L17:
            boolean r1 = isGrayscaleService(r6)
            if (r1 == 0) goto L28
            java.lang.String r1 = "ap.mobileprod.amcs.config.local.fetch"
            r0.add(r1)
            java.lang.String r1 = "ap.mobileprod.amcs.config.fetch.by.keys"
        L24:
            r0.add(r1)
            goto L2e
        L28:
            boolean r1 = isAmcsLiteService(r6)
            if (r1 == 0) goto Lbb
        L2e:
            java.lang.String r1 = "ap.mobileamcs.cloud.fetch.config"
            r0.add(r1)
            java.lang.String r1 = "ap.mobileamcs.cloud.fetch.config.by.keys"
            r0.add(r1)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r1[r2] = r6
            com.alipay.multigateway.sdk.Rule r6 = new com.alipay.multigateway.sdk.Rule
            java.lang.String r2 = "AMCS-Rpc-Gateway-%s"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r2 = 100
            r6.<init>(r1, r2)
            com.alipay.multigateway.sdk.decision.condition.Condition r0 = com.alipay.multigateway.sdk.decision.condition.Condition.operationTypeIn(r0)
            r6.addCondition(r0)
            com.alipay.multigateway.sdk.GatewayInfo$SignInfo r0 = new com.alipay.multigateway.sdk.GatewayInfo$SignInfo
            r0.<init>()
            java.lang.String r1 = ""
            r0.headerName = r1
            java.lang.String r1 = "wireless_sg"
            r0.type = r1
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.extra
            java.lang.String r2 = r5.appKey
            java.lang.String r3 = "appKey"
            r1.put(r3, r2)
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.extra
            java.lang.String r2 = r5.authCode
            java.lang.String r3 = "authCode"
            r1.put(r3, r2)
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.extra
            java.lang.String r2 = "requestType"
            java.lang.String r3 = "4"
            r1.put(r2, r3)
            com.alipay.multigateway.sdk.GatewayInfo r1 = new com.alipay.multigateway.sdk.GatewayInfo
            r1.<init>()
            r1.signInfo = r0
            java.lang.String r0 = r5.gatewayUrl
            r1.targetUrl = r0
            java.lang.String r0 = r5.appId
            java.lang.String r2 = "AppId"
            r1.addHeader(r2, r0)
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.headers
            if (r0 == 0) goto Lb4
            java.util.Map<java.lang.String, java.lang.String> r5 = r5.headers
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L98:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto Lb4
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r2 = r0.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r1.addHeader(r2, r0)
            goto L98
        Lb4:
            r6.setGatewayInfo(r1)
            r4.addRule(r6)
            return
        Lbb:
            java.lang.String r4 = com.alipay.plus.android.config.sdk.rpc.AmcsRpcUtils.f7384a
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r5[r2] = r6
            java.lang.String r6 = "Can not parse rpc type [%s]"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            com.alipay.iap.android.common.log.LoggerWrapper.d(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.plus.android.config.sdk.rpc.AmcsRpcUtils.initializeRpcGateway(com.alipay.multigateway.sdk.GatewayController, com.alipay.iap.android.common.securityprofiles.profile.RpcProfile, java.lang.String):void");
    }

    public static boolean isAmcsLiteService(String str) {
        return DEFAULT_NODE_AMCS_LITE_SERVICE.equals(str);
    }

    public static boolean isGrayscaleService(String str) {
        return DEFAULT_NODE_GRAYSCALE_SERVICE.equals(str);
    }

    public static boolean isMdsService(String str) {
        return DEFAULT_NODE_MDS_SERVICE.equals(str);
    }

    public static void updateRpcGateway(RpcProfile rpcProfile, String str) {
        GatewayController gatewayController = b;
        if (gatewayController == null) {
            LoggerWrapper.e(f7384a, "** Cannot initializeRpcGateway. mGatewayController is null!");
        } else {
            initializeRpcGateway(gatewayController, rpcProfile, str);
        }
    }
}

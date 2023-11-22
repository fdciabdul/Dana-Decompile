package com.alipay.multigateway.sdk.adapter.network.quake;

import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Request;
import com.alipay.imobile.network.quake.request.RequestInterceptor;
import com.alipay.imobile.network.quake.util.SignUtil;
import com.alipay.multigateway.sdk.GatewayController;
import com.alipay.multigateway.sdk.GatewayInfo;
import com.alipay.multigateway.sdk.NetworkDelegate;
import java.util.Map;

/* loaded from: classes7.dex */
public class QuakeNetworkDelegate implements NetworkDelegate, RequestInterceptor {
    private static final String TAG = "QuakeNetworkDelegate";

    @Override // com.alipay.imobile.network.quake.request.RequestInterceptor
    public void afterReceiveResponse(Request request, NetworkResponse networkResponse) {
    }

    @Override // com.alipay.imobile.network.quake.request.RequestInterceptor
    public void beforeSendRequest(Request request) {
        GatewayController controller = QuakeGatewayControllerFactory.getController();
        if (controller == null) {
            return;
        }
        controller.processRequest(request);
    }

    @Override // com.alipay.multigateway.sdk.NetworkDelegate
    public void setGatewayInfo(GatewayInfo gatewayInfo, Object obj) {
        if (Request.class.isInstance(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("setGatewayInfo be invoked.GatewayInfo:");
            sb.append(gatewayInfo);
            LoggerWrapper.i(TAG, sb.toString());
            Request request = (Request) obj;
            String targetUrl = gatewayInfo.getTargetUrl();
            if (!TextUtils.isEmpty(targetUrl)) {
                request.setOriginUrl(targetUrl);
            }
            Map<String, String> map = gatewayInfo.headers;
            if (map != null) {
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        request.addExternalInfo(str, str2);
                    }
                }
            }
            if (gatewayInfo.signInfo == null || gatewayInfo.signInfo.extra == null) {
                return;
            }
            Map<String, String> map2 = gatewayInfo.signInfo.extra;
            String str3 = map2.get("appKey");
            String str4 = map2.get("authCode");
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return;
            }
            SignUtil.SignInfo signInfo = new SignUtil.SignInfo();
            signInfo.appKey = str3;
            signInfo.authCode = str4;
            request.setSignInfo(signInfo);
            LoggerWrapper.i(TAG, String.format("set sign info success. appKey = %s, authCode = %s.", str3, str4));
        }
    }
}

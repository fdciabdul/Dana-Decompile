package com.alibaba.griver.init.config;

import android.content.Context;
import com.alibaba.griver.init.IAPConfig;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.utils.ConfigUtils;

/* loaded from: classes3.dex */
public class AmcsLiteManager {
    public static void initAmcs(Context context, IAPConfig iAPConfig) {
        ConfigCenter configCenter = ConfigCenter.getInstance("GriverAppContainer");
        RpcAppInfo rpcAppInfo = new RpcAppInfo();
        rpcAppInfo.rpcGateWayUrl = iAPConfig.getExtra().getGatewayUrl();
        rpcAppInfo.appId = iAPConfig.getAppId();
        rpcAppInfo.addHeader("workspaceId", iAPConfig.getWorkSpaceId());
        rpcAppInfo.authCode = iAPConfig.getAuthCode();
        ConfigCenterContext configCenterContext = new ConfigCenterContext(context, rpcAppInfo, iAPConfig.getExtra().getEnv(), "", iAPConfig.getWorkSpaceId(), iAPConfig.getAppId(), "GriverAppContainer");
        configCenterContext.setBizCode("GriverAppContainer");
        configCenter.initialize(configCenterContext);
        ConfigUtils.setConfigProxy("GriverAppContainer");
        configCenter.refreshConfigWithFrequenceLimit(null);
    }
}

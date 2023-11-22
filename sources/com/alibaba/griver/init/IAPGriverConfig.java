package com.alibaba.griver.init;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class IAPGriverConfig extends IAPConfig {
    private static IAPGriverConfig instance;

    private IAPGriverConfig() {
    }

    public static IAPGriverConfig getInstance() {
        IAPGriverConfig iAPGriverConfig;
        synchronized (IAPGriverConfig.class) {
            if (instance == null) {
                instance = new IAPGriverConfig();
            }
            iAPGriverConfig = instance;
        }
        return iAPGriverConfig;
    }

    public void refreshConfig(IAPConfig iAPConfig) {
        if (iAPConfig == null || TextUtils.isEmpty(iAPConfig.getAppId())) {
            return;
        }
        instance.setAppId(iAPConfig.getAppId());
        instance.setWorkSpaceId(iAPConfig.getWorkSpaceId());
        instance.setVerifyPackagePublicKey(iAPConfig.getVerifyPackagePublicKey());
        instance.setAppendUserAgent(iAPConfig.getAppendUserAgent());
        instance.setGatewayUrl(iAPConfig.getGatewayUrl());
        instance.setEnvironment(iAPConfig.getEnvironment());
        instance.setWebSocketURLPrefixForDebug(iAPConfig.getWebSocketURLPrefixForDebug());
        instance.setAlwaysShowDiagnosticTool(iAPConfig.getAlwaysShowDiagnosticTool());
        instance.setPageConfiguration(iAPConfig.getPageConfiguration());
        instance.setAuthCode(iAPConfig.getAuthCode());
        instance.setEnv(iAPConfig.getEnv());
        instance.setExtra(iAPConfig.getExtra());
        instance.setGpSignature(iAPConfig.getGpSignature());
        instance.setUseAmcsLite(iAPConfig.getUseAmcsLite());
        instance.setUseSecurityGuard(iAPConfig.getUseSecurityGuard());
        instance.setGatewaySignKey(iAPConfig.getGatewaySignKey());
        instance.setPresetPackagePath(iAPConfig.getPresetPackagePath());
    }
}

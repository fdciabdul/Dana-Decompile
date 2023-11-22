package com.alipay.plus.android.config.sdk;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.securityprofiles.extractor.ProfileExtractor;
import com.alipay.iap.android.common.securityprofiles.extractor.SecurityProfileExtractor;
import com.alipay.iap.android.common.securityprofiles.profile.RpcProfile;
import com.alipay.iap.android.common.syncintegration.impl.SyncProvider;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.a.g;
import com.alipay.plus.android.config.sdk.delegate.ConfigIdentifierProvider;
import com.alipay.plus.android.config.sdk.delegate.ConfigMonitor;
import com.alipay.plus.android.config.sdk.delegate.ConfigRpcProvider;
import com.alipay.plus.android.config.sdk.rpc.DefaultConfigRpcProvider;
import com.alipay.plus.android.config.sdk.trigger.ConfigUpdateSyncTrigger;
import com.alipay.plus.android.config.sdk.trigger.ConfigUpdateTrigger;
import com.alipay.plus.android.config.sdk.utils.ConfigProfileUtils;
import com.alipay.plus.android.config.sdk.utils.ConfigUtils;

/* loaded from: classes7.dex */
public class ConfigCenterContext {
    public static final String PROD_ENVIRONMENT = "prod";

    /* renamed from: a */
    private static final String f7352a = e.a("ConfigCenterContext");
    private boolean b;
    protected ConfigRpcProvider mConfigRpcProvider;
    protected ConfigUpdateTrigger mConfigUpdateTrigger;
    protected Context mContext;
    protected ConfigIdentifierProvider mIdentifierProvider;
    protected ConfigMonitor mMonitor;
    protected RpcProfile mRpcProfile;
    protected boolean mUseExternalOperationType;

    public ConfigCenterContext(Context context, RpcProfile rpcProfile) {
        this.mConfigRpcProvider = new DefaultConfigRpcProvider();
        this.mMonitor = new ConfigMonitor.IAPLogMonitor();
        this.mIdentifierProvider = new g();
        this.mConfigUpdateTrigger = new ConfigUpdateSyncTrigger(new SyncProvider());
        this.mUseExternalOperationType = false;
        this.b = false;
        this.mContext = context;
        a(rpcProfile);
    }

    public ConfigCenterContext(Context context, String str, String str2) {
        this(context, str, str2, new SecurityProfileExtractor(context, str2));
    }

    public ConfigCenterContext(Context context, String str, String str2, ProfileExtractor profileExtractor) {
        this.mConfigRpcProvider = new DefaultConfigRpcProvider();
        this.mMonitor = new ConfigMonitor.IAPLogMonitor();
        this.mIdentifierProvider = new g();
        this.mConfigUpdateTrigger = new ConfigUpdateSyncTrigger(new SyncProvider());
        this.mUseExternalOperationType = false;
        this.b = false;
        RpcProfile createRpcProfile = ConfigProfileUtils.createRpcProfile(profileExtractor, str, str2);
        if (createRpcProfile == null) {
            createRpcProfile = new RpcProfile();
            createRpcProfile.authCode = str2;
            createRpcProfile.environment = str;
            LoggerWrapper.e(f7352a, "Cannot get prod RpcProfile!!");
        }
        this.mContext = context;
        a(createRpcProfile);
    }

    private void a(RpcProfile rpcProfile) {
        this.mRpcProfile = rpcProfile;
        String str = f7352a;
        StringBuilder sb = new StringBuilder();
        sb.append("rpcProfile: ");
        sb.append(ConfigUtils.toJSONString(this.mRpcProfile));
        LoggerWrapper.d(str, sb.toString());
    }

    public ConfigMonitor getConfigMonitor() {
        return this.mMonitor;
    }

    public ConfigRpcProvider getConfigRpcProvider() {
        return this.mConfigRpcProvider;
    }

    public ConfigUpdateTrigger getConfigUpdateTrigger() {
        return this.mConfigUpdateTrigger;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public String getEnvironment() {
        return this.mRpcProfile.environment;
    }

    public ConfigIdentifierProvider getIdentifierProvider() {
        return this.mIdentifierProvider;
    }

    public RpcProfile getRpcProfile() {
        return this.mRpcProfile;
    }

    public boolean isUseExternalOperationType() {
        return this.mUseExternalOperationType;
    }

    public boolean isUseGraySscaleAsDefault() {
        return this.b;
    }

    public void setConfigMonitor(ConfigMonitor configMonitor) {
        this.mMonitor = configMonitor;
    }

    public void setConfigRpcProvider(ConfigRpcProvider configRpcProvider) {
        this.mConfigRpcProvider = configRpcProvider;
    }

    public void setConfigUpdateTrigger(ConfigUpdateTrigger configUpdateTrigger) {
        this.mConfigUpdateTrigger = configUpdateTrigger;
    }

    public void setEnvironment(String str) {
        this.mRpcProfile.environment = str;
    }

    public void setIdentifierProvider(ConfigIdentifierProvider configIdentifierProvider) {
        this.mIdentifierProvider = configIdentifierProvider;
    }

    public void setUseExternalOperationType(boolean z) {
        this.mUseExternalOperationType = z;
    }

    public void setUseGrayScaleAsDefault(boolean z) {
        this.b = z;
    }
}

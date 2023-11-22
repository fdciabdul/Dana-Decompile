package com.alipay.iap.android.common.config;

import com.alipay.iap.android.common.config.IConfigProvider;

/* loaded from: classes3.dex */
public class ConfigProxy implements IConfigProvider {
    private static final ConfigProxy INSTANCE = new ConfigProxy();
    private static final String TAG = "ConfigProxy";
    private IConfigProvider configProvider = new IConfigProvider.MockProvider();

    public static ConfigProxy getInstance() {
        return INSTANCE;
    }

    private ConfigProxy() {
    }

    public void setConfigProvider(IConfigProvider iConfigProvider) {
        this.configProvider = iConfigProvider;
    }

    public IConfigProvider getConfigProvider() {
        return this.configProvider;
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public String getConfig(String str) {
        return this.configProvider.getConfig(str);
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public String getSectionConfig(String str) {
        return this.configProvider.getSectionConfig(str);
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void addCommonConfigChangeListener(String str, ICommonConfigChangeListener iCommonConfigChangeListener) {
        this.configProvider.addCommonConfigChangeListener(str, iCommonConfigChangeListener);
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void removeCommonConfigChangeListener(ICommonConfigChangeListener iCommonConfigChangeListener) {
        this.configProvider.removeCommonConfigChangeListener(iCommonConfigChangeListener);
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void addSectionConfigChangeListener(String str, ISectionConfigChangeListener iSectionConfigChangeListener) {
        this.configProvider.addSectionConfigChangeListener(str, iSectionConfigChangeListener);
    }

    @Override // com.alipay.iap.android.common.config.IConfigProvider
    public void removeSectionConfigChangeListener(ISectionConfigChangeListener iSectionConfigChangeListener) {
        this.configProvider.removeSectionConfigChangeListener(iSectionConfigChangeListener);
    }
}

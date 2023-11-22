package com.alipay.iap.android.common.config;

import com.alipay.iap.android.common.log.LoggerWrapper;

/* loaded from: classes3.dex */
public interface IConfigProvider {
    void addCommonConfigChangeListener(String str, ICommonConfigChangeListener iCommonConfigChangeListener);

    void addSectionConfigChangeListener(String str, ISectionConfigChangeListener iSectionConfigChangeListener);

    String getConfig(String str);

    String getSectionConfig(String str);

    void removeCommonConfigChangeListener(ICommonConfigChangeListener iCommonConfigChangeListener);

    void removeSectionConfigChangeListener(ISectionConfigChangeListener iSectionConfigChangeListener);

    /* loaded from: classes3.dex */
    public static class MockProvider implements IConfigProvider {
        private static final String TAG = "MockProvider";

        @Override // com.alipay.iap.android.common.config.IConfigProvider
        public String getConfig(String str) {
            logMockProviderWarning();
            return null;
        }

        @Override // com.alipay.iap.android.common.config.IConfigProvider
        public String getSectionConfig(String str) {
            logMockProviderWarning();
            return null;
        }

        @Override // com.alipay.iap.android.common.config.IConfigProvider
        public void addCommonConfigChangeListener(String str, ICommonConfigChangeListener iCommonConfigChangeListener) {
            logMockProviderWarning();
        }

        @Override // com.alipay.iap.android.common.config.IConfigProvider
        public void removeCommonConfigChangeListener(ICommonConfigChangeListener iCommonConfigChangeListener) {
            logMockProviderWarning();
        }

        @Override // com.alipay.iap.android.common.config.IConfigProvider
        public void addSectionConfigChangeListener(String str, ISectionConfigChangeListener iSectionConfigChangeListener) {
            logMockProviderWarning();
        }

        @Override // com.alipay.iap.android.common.config.IConfigProvider
        public void removeSectionConfigChangeListener(ISectionConfigChangeListener iSectionConfigChangeListener) {
            logMockProviderWarning();
        }

        private static void logMockProviderWarning() {
            LoggerWrapper.w(TAG, "**WARNING** ConfigProxy configProvider is mocked! you need invoke ConfigProxy.getInstance().setConfigProvider(...) before use it!");
        }
    }
}

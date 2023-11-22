package com.iap.ac.android.acs.multilanguage.core.config;

import android.text.TextUtils;
import com.iap.ac.android.acs.multilanguage.core.storage.ILangPkgStorage;
import com.iap.ac.android.acs.multilanguage.core.storage.a;
import com.iap.ac.android.acs.multilanguage.utils.LanguagePackageUtil;

/* loaded from: classes3.dex */
public class LanguagePackageConfig {
    private static final int DEF_MAX_MEMORY_CACHE_COUNT = 3;
    private static final int DEF_UPDATE_INTERVAL_IN_HOUR = 2;
    private String language;
    private int maxMemoryCacheSize;
    private ILangPkgStorage storageImpl;
    private int updateIntervalInHour;

    /* loaded from: classes3.dex */
    public static class Builder {
        private String language;
        private int maxMemoryCacheSize;
        protected ILangPkgStorage storageImpl;
        protected int updateIntervalInHour;

        public LanguagePackageConfig build() {
            return new LanguagePackageConfig(this.language, this.updateIntervalInHour, this.maxMemoryCacheSize, this.storageImpl);
        }

        public Builder language(String str) {
            this.language = str;
            return this;
        }

        public Builder maxMemoryCacheSize(int i) {
            this.maxMemoryCacheSize = i;
            return this;
        }

        public Builder storageImpl(ILangPkgStorage iLangPkgStorage) {
            this.storageImpl = iLangPkgStorage;
            return this;
        }

        public Builder updateIntervalInHour(int i) {
            this.updateIntervalInHour = i;
            return this;
        }
    }

    public static LanguagePackageConfig adapter(LanguagePackageConfig languagePackageConfig) {
        LanguagePackageConfig buildDefaultConfig = buildDefaultConfig();
        if (languagePackageConfig == null) {
            return buildDefaultConfig;
        }
        if (TextUtils.isEmpty(languagePackageConfig.language)) {
            languagePackageConfig.language = buildDefaultConfig.language;
        }
        if (languagePackageConfig.updateIntervalInHour <= 0) {
            languagePackageConfig.updateIntervalInHour = buildDefaultConfig.updateIntervalInHour;
        }
        if (languagePackageConfig.maxMemoryCacheSize <= 0) {
            languagePackageConfig.maxMemoryCacheSize = buildDefaultConfig.maxMemoryCacheSize;
        }
        if (languagePackageConfig.storageImpl == null) {
            languagePackageConfig.storageImpl = buildDefaultConfig.storageImpl;
        }
        return languagePackageConfig;
    }

    public static LanguagePackageConfig buildDefaultConfig() {
        return new Builder().language(LanguagePackageUtil.getCurrentLanguage()).updateIntervalInHour(2).maxMemoryCacheSize(3).storageImpl(new a()).build();
    }

    public String getLanguage() {
        return this.language;
    }

    public int getMaxMemoryCacheSize() {
        return this.maxMemoryCacheSize;
    }

    public ILangPkgStorage getStorageImpl() {
        return this.storageImpl;
    }

    public int getUpdateIntervalInHour() {
        return this.updateIntervalInHour;
    }

    private LanguagePackageConfig(String str, int i, int i2, ILangPkgStorage iLangPkgStorage) {
        this.language = str;
        this.updateIntervalInHour = i;
        this.maxMemoryCacheSize = i2;
        this.storageImpl = iLangPkgStorage;
    }
}

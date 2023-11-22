package com.iap.ac.android.biz.common;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.iap.ac.android.biz.common.callback.IConfigCallback;
import com.iap.ac.android.biz.common.callback.InquireQuoteCallback;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.config.ConfigManager;
import com.iap.ac.android.biz.common.internal.consts.InnerConstants;
import com.iap.ac.android.biz.common.internal.quote.QuoteManager;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.model.InitConfig;
import com.iap.ac.android.biz.common.model.QuoteCurrency;
import com.iap.ac.android.biz.common.model.VersionConfig;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.biz.common.model.remoteconfig.cpm.CPMConfig;
import com.iap.ac.android.biz.common.model.remoteconfig.mpm.HookUrlConfig;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.biz.common.storage.ACEncryptStorageProvider;
import com.iap.ac.android.biz.common.storage.lite.ACEncryptStorageLiteProvider;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.data.ACSecurityData;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.log.ACLog;
import java.util.List;

/* loaded from: classes3.dex */
public class ACManager {
    public static volatile ACManager mInstance;
    public ConfigManager mConfigManager;
    public Context mContext;
    public InitConfig mInitConfig;
    public ACSecurityData mSecurityStorageProvider;
    public ACSecurityData mSecurityStorageProviderLite;
    public String mTid;
    public boolean mInitialized = false;
    public boolean mOldSecurityGuardExist = false;
    public CommonConfig mCommonConfig = new CommonConfig();

    public static ACManager getInstance() {
        if (mInstance == null) {
            synchronized (ACManager.class) {
                if (mInstance == null) {
                    mInstance = new ACManager();
                }
            }
        }
        return mInstance;
    }

    public void clear() {
        if (this.mInitialized) {
            if (this.mSecurityStorageProviderLite != null && (!this.mOldSecurityGuardExist || ((Boolean) ConfigCenter.INSTANCE.getKeyOrDefault("security_lite_encrypt_enabled", Boolean.FALSE)).booleanValue())) {
                this.mSecurityStorageProviderLite.clear();
                ACLog.d(Constants.TAG, "SecurityStorage clear key by v2");
            }
            ACLog.d(Constants.TAG, "SecurityStorage clear key by v1");
            this.mSecurityStorageProvider.clear();
        }
    }

    public boolean delete(String str) {
        if (this.mInitialized) {
            if (this.mSecurityStorageProviderLite != null && (!this.mOldSecurityGuardExist || ((Boolean) ConfigCenter.INSTANCE.getKeyOrDefault("security_lite_encrypt_enabled", Boolean.FALSE)).booleanValue())) {
                this.mSecurityStorageProviderLite.delete(str);
                StringBuilder sb = new StringBuilder();
                sb.append("SecurityStorage delete key by v2");
                sb.append(str);
                ACLog.d(Constants.TAG, sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SecurityStorage delete key by v1");
            sb2.append(str);
            ACLog.d(Constants.TAG, sb2.toString());
            return this.mSecurityStorageProvider.delete(str);
        }
        return false;
    }

    public String fetch(String str) {
        ACSecurityData aCSecurityData;
        if (this.mSecurityStorageProviderLite != null && (!this.mOldSecurityGuardExist || ((Boolean) ConfigCenter.INSTANCE.getKeyOrDefault("security_lite_encrypt_enabled", Boolean.FALSE)).booleanValue())) {
            String str2 = this.mSecurityStorageProviderLite.get(str);
            if (TextUtils.isEmpty(str2) && (aCSecurityData = this.mSecurityStorageProvider) != null) {
                String str3 = aCSecurityData.get(str);
                if (!TextUtils.isEmpty(str3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SecurityStorage fetch key by v2 is null, use v1 key, key=");
                    sb.append(str);
                    ACLog.d(Constants.TAG, sb.toString());
                    this.mSecurityStorageProviderLite.save(str, str3);
                    this.mSecurityStorageProvider.delete(str);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SecurityStorage fetch key by v2 is null, use v1 key is null, return null, key=");
                    sb2.append(str);
                    ACLog.d(Constants.TAG, sb2.toString());
                }
                return str3;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("SecurityStorage fetch key by v2, key=");
            sb3.append(str);
            ACLog.d(Constants.TAG, sb3.toString());
            return str2;
        }
        ACSecurityData aCSecurityData2 = this.mSecurityStorageProvider;
        if (aCSecurityData2 == null) {
            return null;
        }
        String str4 = aCSecurityData2.get(str);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("SecurityStorage fetch key by v1, key=");
        sb4.append(str);
        ACLog.d(Constants.TAG, sb4.toString());
        return str4;
    }

    public void fetchConfigAsync(IConfigCallback iConfigCallback) {
        if (this.mInitialized) {
            this.mConfigManager.fetchConfigAsync(iConfigCallback);
        } else if (iConfigCallback != null) {
            iConfigCallback.onConfigFailed();
        }
    }

    public void fetchConfigInWorker() {
        if (this.mInitialized) {
            this.mConfigManager.fetchConfigInWorker(null);
        }
    }

    public boolean getAMCSToggle() {
        if (this.mInitialized) {
            return this.mConfigManager.getAMCSToggle();
        }
        return true;
    }

    public String getAppId() {
        if (this.mInitialized) {
            return this.mInitConfig.appId;
        }
        return null;
    }

    public String getClientKeyStorageKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return "clientKey";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append("clientKey");
        return sb.toString();
    }

    public String getCodeType(String str) {
        if (this.mInitialized) {
            return this.mConfigManager.getCodeType(str);
        }
        return null;
    }

    public CommonConfig getCommonConfig() {
        return this.mCommonConfig;
    }

    public Context getContext() {
        return this.mContext;
    }

    public CPMConfig getCpmConfig(String str) {
        if (this.mInitialized) {
            return this.mConfigManager.getCpmConfig(str);
        }
        return null;
    }

    public List<HookUrlConfig> getHookUrlConfig() {
        if (this.mInitialized) {
            return this.mConfigManager.getHookUrlConfig();
        }
        return null;
    }

    public String getIapConnectVersion() {
        ConfigManager configManager;
        if (!this.mInitialized || (configManager = this.mConfigManager) == null || configManager.getVersionConfig() == null) {
            return null;
        }
        return this.mConfigManager.getVersionConfig().iapconnectVersion;
    }

    public OAuthConfig getOAuthConfig() {
        if (this.mInitialized) {
            return this.mConfigManager.getOAuthConfig();
        }
        return null;
    }

    public String getOpenIdStorageKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return InnerConstants.STORAGE_KEY_OPENID;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(InnerConstants.STORAGE_KEY_OPENID);
        return sb.toString();
    }

    public String getPspId() {
        CommonConfig commonConfig;
        if (this.mInitialized && (commonConfig = this.mCommonConfig) != null) {
            return commonConfig.pspId;
        }
        return null;
    }

    public String getRewardsClientKeyStorageKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return InnerConstants.STORAGE_KEY_REWARDS_CLIENTKEY;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(InnerConstants.STORAGE_KEY_REWARDS_CLIENTKEY);
        return sb.toString();
    }

    public String getRewardsOpenIdStorageKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return InnerConstants.STORAGE_KEY_REWARDS_OPENID;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(InnerConstants.STORAGE_KEY_REWARDS_OPENID);
        return sb.toString();
    }

    public List<String> getSslCertList() {
        ConfigManager configManager;
        if (!this.mInitialized || (configManager = this.mConfigManager) == null) {
            return null;
        }
        return configManager.getSslCertList();
    }

    public String getTid() {
        if (TextUtils.isEmpty(this.mTid)) {
            String tid = InstanceInfo.getTid(this.mContext);
            this.mTid = tid;
            if (TextUtils.isEmpty(tid)) {
                this.mTid = InstanceInfo.getInstanceId(this.mContext);
            }
        }
        return this.mTid;
    }

    public VersionConfig getVersionConfig() {
        ConfigManager configManager;
        if (!this.mInitialized || (configManager = this.mConfigManager) == null) {
            return null;
        }
        return configManager.getVersionConfig();
    }

    public void init(Context context, InitConfig initConfig) {
        synchronized (this) {
            this.mInitialized = false;
            this.mInitConfig = initConfig;
            ACLog.setDebuggableByContext(context);
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            SPIManager.getInstance().init(initConfig);
            this.mSecurityStorageProvider = ACEncryptStorageProvider.getInstance(context).getAcSecurityDataInstance();
            if (Utils.checkClassExist("com.alipay.plus.security.lite.SecurityGuardLiteManager")) {
                this.mSecurityStorageProviderLite = ACEncryptStorageLiteProvider.getInstance(context).getAcSecurityDataInstance();
            }
            if (Utils.checkClassExist(SecurityConstants.SG_CLASS)) {
                this.mOldSecurityGuardExist = true;
            }
            ConfigManager configManager = new ConfigManager(context, initConfig.appId);
            this.mConfigManager = configManager;
            CommonConfig commonConfig = configManager.getCommonConfig();
            this.mCommonConfig = commonConfig;
            if (commonConfig != null && commonConfig.isValid()) {
                this.mCommonConfig.setEnvType(initConfig.envType);
                this.mTid = initConfig.tid;
                this.mInitialized = true;
                return;
            }
            ACLog.e(Constants.TAG, "read preset config error");
        }
    }

    public void inquireQuote(QuoteCurrency quoteCurrency, InquireQuoteCallback inquireQuoteCallback) {
        QuoteManager.inquireQuote(quoteCurrency, inquireQuoteCallback);
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public boolean save(String str, String str2) {
        if (this.mSecurityStorageProviderLite != null && (!this.mOldSecurityGuardExist || ((Boolean) ConfigCenter.INSTANCE.getKeyOrDefault("security_lite_encrypt_enabled", Boolean.FALSE)).booleanValue())) {
            this.mSecurityStorageProviderLite.save(str, str2);
            StringBuilder sb = new StringBuilder();
            sb.append("SecurityStorage save key by v2, key=");
            sb.append(str);
            ACLog.d(Constants.TAG, sb.toString());
            return true;
        } else if (this.mSecurityStorageProvider == null) {
            return false;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SecurityStorage save key by v1, key=");
            sb2.append(str);
            ACLog.d(Constants.TAG, sb2.toString());
            return this.mSecurityStorageProvider.save(str, str2);
        }
    }

    public boolean useV2Encrypt() {
        return !this.mOldSecurityGuardExist || ((Boolean) ConfigCenter.INSTANCE.getKeyOrDefault("security_lite_encrypt_enabled", Boolean.FALSE)).booleanValue();
    }
}

package com.iap.ac.android.biz.common.internal.config;

import android.content.Context;
import android.os.SystemClock;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.callback.IConfigCallback;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.config.common.AMCSConfigModel;
import com.iap.ac.android.biz.common.internal.config.common.OAuthConfigModel;
import com.iap.ac.android.biz.common.internal.config.cpm.CPMConfigModel;
import com.iap.ac.android.biz.common.internal.config.cpm.RegionCodeTypeMapConfigModel;
import com.iap.ac.android.biz.common.internal.config.mpm.HookUrlConfigModel;
import com.iap.ac.android.biz.common.internal.config.preset.PresetConfigModel;
import com.iap.ac.android.biz.common.internal.config.preset.VersionConfigModel;
import com.iap.ac.android.biz.common.internal.config.processor.RemoteConfigProcessor;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.model.VersionConfig;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.biz.common.model.remoteconfig.cpm.CPMConfig;
import com.iap.ac.android.biz.common.model.remoteconfig.mpm.HookUrlConfig;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentFetchConfigsResult;
import com.iap.ac.android.biz.common.storage.ACStorageProvider;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ConfigManager {
    public static final String BIZ_TYPE_FOR_STORAGE = "ConfigManager";
    public static final String ERROR_CODE_CONFIG_PARSE = "CONFIG_PARSE_ERROR";
    public static final String ERROR_MESSAGE_CONFIG_PARSE = "parse remote config error";
    public static final String KEY_AC_CONFIG = "key_ac_config";
    public ACStorageProvider mStorageProvider;
    public long mLastFetchTime = 0;
    public RemoteConfigProcessor mRemoteConfigProcessor = new RemoteConfigProcessor();
    public OAuthConfigModel mOAuthConfigModel = new OAuthConfigModel();
    public CPMConfigModel mCPMConfigModel = new CPMConfigModel();
    public RegionCodeTypeMapConfigModel mRegionMapConfigModel = new RegionCodeTypeMapConfigModel();
    public HookUrlConfigModel mHookUrlConfigModel = new HookUrlConfigModel();
    public AMCSConfigModel mAmcsConfigModel = new AMCSConfigModel();
    public PresetConfigModel mPresetConfig = new PresetConfigModel();
    public VersionConfigModel mVersionConfig = new VersionConfigModel();

    /* loaded from: classes8.dex */
    public static class StorageKey {
        public static final String KEY_AMCS_CONFIG = "AMCS_CONFIG";
        public static final String KEY_CODETYPE_CONFIG = "CODETYPE_CONFIG";
        public static final String KEY_HOOK_URL_CONFIG = "HOOK_URL_CONFIG";
        public static final String KEY_OAUTH_CONFIG = "OAUTH_CONFIG";
        public static final String KEY_PSP_SCHEME_PREFIX_LIST = "PSP_SCHEME_PREFIX_LIST";
        public static final String KEY_REGION_CODETYPE_MAPPING = "REGION_CODETYPE_MAPPING";
    }

    public ConfigManager(Context context, String str) {
        this.mStorageProvider = new ACStorageProvider(context, BIZ_TYPE_FOR_STORAGE);
        boolean loadLocalConfig = loadLocalConfig(context, str);
        if (!loadLocalConfig) {
            ACLog.e(Constants.TAG, "load local config failed. Not not worry,will try to fetch from remote when needed.");
        }
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_AC_CONFIG).addParams("result", loadLocalConfig ? "T" : LogConstants.RESULT_FALSE).event();
    }

    private boolean loadLocalConfig(Context context, String str) {
        ACLog.i(Constants.TAG, "loadLocalConfig begin");
        if (!this.mVersionConfig.parsePresetConfig(context, str)) {
            ACLog.e(Constants.TAG, "ConfigManager, loadLocalConfig error, parse version fails.");
        }
        if (!this.mPresetConfig.parsePresetConfig(context, str)) {
            ACLog.e(Constants.TAG, "ConfigManager, loadLocalConfig error, parsePresetConfig fails.");
            return false;
        }
        MobilePaymentFetchConfigsResult mobilePaymentFetchConfigsResult = (MobilePaymentFetchConfigsResult) JsonUtils.fromJson(this.mStorageProvider.fetch(KEY_AC_CONFIG), MobilePaymentFetchConfigsResult.class);
        if (mobilePaymentFetchConfigsResult == null) {
            ACLog.e(Constants.TAG, "ACConfig parse failed");
        } else {
            Map<String, String> map = mobilePaymentFetchConfigsResult.basicConfigs;
            if (map == null) {
                ACLog.e(Constants.TAG, "ACConfig basicConfig is null");
            } else {
                if (!this.mOAuthConfigModel.parseFromJson(map.get(StorageKey.KEY_OAUTH_CONFIG))) {
                    ACLog.e(Constants.TAG, "ConfigManager, loadLocalConfig, parse OAuth config fails");
                }
                if (!this.mAmcsConfigModel.parseFromJson(map.get(StorageKey.KEY_AMCS_CONFIG))) {
                    ACLog.w(Constants.TAG, "ConfigManager, loadLocalConfig parse amcs config fails.");
                }
            }
            Map<String, String> map2 = mobilePaymentFetchConfigsResult.cpmConfigs;
            if (map2 == null) {
                ACLog.e(Constants.TAG, "ACConfig cpmConfigs is null");
            } else {
                if (!this.mRegionMapConfigModel.parseFromJson(map2.get(StorageKey.KEY_REGION_CODETYPE_MAPPING))) {
                    ACLog.w(Constants.TAG, "ConfigManager, loadLocalConfig parse region code type map fails.");
                }
                if (!this.mCPMConfigModel.parseFromJson(map2.get(StorageKey.KEY_CODETYPE_CONFIG))) {
                    ACLog.w(Constants.TAG, "ConfigManager, loadLocalConfig parse cpm config fails.");
                }
            }
            Map<String, String> map3 = mobilePaymentFetchConfigsResult.mpmConfigs;
            if (map3 == null) {
                ACLog.e(Constants.TAG, "ACConfig mpmConfigs is null");
            } else if (!this.mHookUrlConfigModel.parseFromJson(map3.get(StorageKey.KEY_HOOK_URL_CONFIG))) {
                ACLog.w(Constants.TAG, "ConfigManager, loadLocalConfig parse hook auth url fails.");
            }
        }
        if (this.mOAuthConfigModel.isValid() && this.mRegionMapConfigModel.isValid() && this.mCPMConfigModel.isValid() && this.mHookUrlConfigModel.isValid()) {
            return true;
        }
        ACLog.i(Constants.TAG, "loadLocalConfig fail, parse preset config begin");
        parseConfigResult(this.mPresetConfig.getPresetConfigResult(), null, 0L, false);
        return true;
    }

    private void parseConfigResult(MobilePaymentFetchConfigsResult mobilePaymentFetchConfigsResult, IConfigCallback iConfigCallback, long j, boolean z) {
        String str = mobilePaymentFetchConfigsResult.traceId;
        HashMap hashMap = new HashMap();
        Map<String, String> map = mobilePaymentFetchConfigsResult.cpmConfigs;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = mobilePaymentFetchConfigsResult.mpmConfigs;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        Map<String, String> map3 = mobilePaymentFetchConfigsResult.basicConfigs;
        if (map3 != null) {
            hashMap.putAll(map3);
        }
        if (hashMap.size() <= 0) {
            reportFetchRemoteConfigFail(iConfigCallback, "PARAM_ILLEGAL", "Oops! System busy. Try again later!", SystemClock.elapsedRealtime() - j, str);
            return;
        }
        if (!this.mStorageProvider.save(KEY_AC_CONFIG, JsonUtils.toJson(mobilePaymentFetchConfigsResult))) {
            StringBuilder a2 = a.a("parseConfigResult, storage error, key:key_ac_config,value: ");
            a2.append(JsonUtils.toJson(mobilePaymentFetchConfigsResult));
            ACLog.e(Constants.TAG, a2.toString());
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1628845874:
                    if (str2.equals(StorageKey.KEY_HOOK_URL_CONFIG)) {
                        c = 0;
                        break;
                    }
                    break;
                case -612987942:
                    if (str2.equals(StorageKey.KEY_CODETYPE_CONFIG)) {
                        c = 1;
                        break;
                    }
                    break;
                case -598378683:
                    if (str2.equals(StorageKey.KEY_AMCS_CONFIG)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1079081482:
                    if (str2.equals(StorageKey.KEY_OAUTH_CONFIG)) {
                        c = 3;
                        break;
                    }
                    break;
                case 1764176129:
                    if (str2.equals(StorageKey.KEY_REGION_CODETYPE_MAPPING)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                this.mHookUrlConfigModel.parseFromJson((String) entry.getValue());
            } else if (c == 1) {
                this.mCPMConfigModel.parseFromJson((String) entry.getValue());
            } else if (c == 2) {
                this.mAmcsConfigModel.parseFromJson((String) entry.getValue());
            } else if (c == 3) {
                this.mOAuthConfigModel.parseFromJson((String) entry.getValue());
            } else if (c != 4) {
                StringBuilder a3 = a.a("Unknown key: ");
                a3.append((String) entry.getKey());
                ACLog.w(Constants.TAG, a3.toString());
            } else {
                this.mRegionMapConfigModel.parseFromJson((String) entry.getValue());
            }
        }
        if (this.mOAuthConfigModel.isValid() && this.mCPMConfigModel.isValid() && this.mRegionMapConfigModel.isValid() && this.mHookUrlConfigModel.isValid()) {
            if (iConfigCallback != null) {
                iConfigCallback.onConfigSuccess();
            }
            if (z) {
                this.mLastFetchTime = System.currentTimeMillis();
            }
            ACLogEvent.commonRpcSuccessEvent("iapconnect_center", LogConstants.EVENT_ID_REMOTE_CONFIG, SystemClock.elapsedRealtime() - j, str);
            return;
        }
        reportFetchRemoteConfigFail(iConfigCallback, ERROR_CODE_CONFIG_PARSE, ERROR_MESSAGE_CONFIG_PARSE, SystemClock.elapsedRealtime() - j, str);
    }

    private void reportFetchRemoteConfigFail(IConfigCallback iConfigCallback, String str, String str2, long j, String str3) {
        ACLogEvent.commonRpcFailEvent("iapconnect_center", LogConstants.EVENT_ID_REMOTE_CONFIG, str, str2, j, str3);
        if (iConfigCallback == null) {
            return;
        }
        iConfigCallback.onConfigFailed();
    }

    public void fetchConfigAsync(final IConfigCallback iConfigCallback) {
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.biz.common.internal.config.ConfigManager.1
            {
                ConfigManager.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConfigManager.this.fetchConfigInWorker(iConfigCallback);
            }
        });
    }

    public void fetchConfigInWorker(IConfigCallback iConfigCallback) {
        synchronized (this) {
            if (System.currentTimeMillis() - this.mLastFetchTime <= ConfigCenter.INSTANCE.getRemoteConfigRefreshInterval()) {
                ACLog.i(Constants.TAG, "loadRemoteConfigInWorker skip, local cache valid");
                if (iConfigCallback != null) {
                    iConfigCallback.onConfigSuccess();
                }
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            MobilePaymentFetchConfigsResult fetchRemoteConfigsInWorker = this.mRemoteConfigProcessor.fetchRemoteConfigsInWorker();
            if (fetchRemoteConfigsInWorker != null) {
                if (fetchRemoteConfigsInWorker.success) {
                    parseConfigResult(fetchRemoteConfigsInWorker, iConfigCallback, elapsedRealtime, true);
                } else {
                    reportFetchRemoteConfigFail(iConfigCallback, fetchRemoteConfigsInWorker.errorCode, fetchRemoteConfigsInWorker.errorMessage, SystemClock.elapsedRealtime() - elapsedRealtime, fetchRemoteConfigsInWorker.traceId);
                    ACLog.e(Constants.TAG, "acCommon fetchConfig failed result config is null");
                }
            } else {
                reportFetchRemoteConfigFail(iConfigCallback, ResultCode.INVALID_NETWORK, "Oops! System busy. Try again later!", SystemClock.elapsedRealtime() - elapsedRealtime, "");
                ACLog.e(Constants.TAG, "acCommon fetchConfig failed rpc failed");
            }
        }
    }

    public boolean getAMCSToggle() {
        return this.mAmcsConfigModel.getAMCSToggle();
    }

    public String getCodeType(String str) {
        return this.mRegionMapConfigModel.getFirstCodeType(str);
    }

    public CommonConfig getCommonConfig() {
        return this.mPresetConfig.getCommonConfig();
    }

    public CPMConfig getCpmConfig(String str) {
        return this.mCPMConfigModel.getCPMConfig(str);
    }

    public List<HookUrlConfig> getHookUrlConfig() {
        return this.mHookUrlConfigModel.getHookUrlConfigList();
    }

    public OAuthConfig getOAuthConfig() {
        return this.mOAuthConfigModel.getAuthConfig();
    }

    public List<String> getSslCertList() {
        PresetConfigModel presetConfigModel = this.mPresetConfig;
        if (presetConfigModel == null || presetConfigModel.getCommonConfig() == null) {
            return null;
        }
        return this.mPresetConfig.getCommonConfig().certList;
    }

    public VersionConfig getVersionConfig() {
        VersionConfigModel versionConfigModel = this.mVersionConfig;
        if (versionConfigModel == null) {
            return null;
        }
        return versionConfigModel.getVersionConfig();
    }
}

package com.iap.ac.android.biz.common.internal.config.preset;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.config.utils.ConfigUtils;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.model.PresetConfig;
import com.iap.ac.android.biz.common.rpc.result.MobilePaymentFetchConfigsResult;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.utils.resource.ConfigResourceUtils;

/* loaded from: classes3.dex */
public class PresetConfigModel {
    public static final String KEY_PAY_CONFIG = "pay_config";
    public static final String PRESET_CONFIG_FILE_EXTENSION = ".json";
    public static final String PRESET_CONFIG_FILE_NAME = "iapconnect_config";
    public CommonConfig mCommonConfig = new CommonConfig();
    public PresetConfig mPresetConfig;

    private void extractCommonConfig() {
        PresetConfig presetConfig = this.mPresetConfig;
        if (presetConfig != null) {
            CommonConfig commonConfig = this.mCommonConfig;
            commonConfig.appId = presetConfig.appId;
            commonConfig.gpSignature = presetConfig.gpSignature;
            if (!TextUtils.isEmpty(presetConfig.acsAppId)) {
                this.mCommonConfig.acsAppId = this.mPresetConfig.acsAppId;
            }
            String str = this.mPresetConfig.authCode;
            if (str != null) {
                this.mCommonConfig.authCode = str;
            }
            if (!TextUtils.isEmpty(this.mPresetConfig.cdnUrl)) {
                this.mCommonConfig.cdnUrl = this.mPresetConfig.cdnUrl;
            }
            CommonConfig commonConfig2 = this.mCommonConfig;
            PresetConfig presetConfig2 = this.mPresetConfig;
            commonConfig2.siteName = presetConfig2.siteName;
            commonConfig2.certList = presetConfig2.certList;
            commonConfig2.defaultRegion = presetConfig2.defaultRegion;
            commonConfig2.defaultMobilePhoneRegionCode = presetConfig2.defaultMobilePhoneRegionCode;
            commonConfig2.pspId = presetConfig2.pspId;
            commonConfig2.clientId = presetConfig2.clientId;
        }
    }

    private String getPresetConfigFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "iapconnect_config.json";
        }
        StringBuilder a2 = a.a("iapconnect_config_");
        a2.append(str.toLowerCase());
        a2.append(".json");
        return a2.toString();
    }

    public CommonConfig getCommonConfig() {
        if (isValid()) {
            return this.mCommonConfig;
        }
        return null;
    }

    public MobilePaymentFetchConfigsResult getPresetConfigResult() {
        if (isValid()) {
            return this.mPresetConfig.acconfig;
        }
        return null;
    }

    public boolean isValid() {
        PresetConfig presetConfig = this.mPresetConfig;
        return (presetConfig == null || presetConfig.acconfig == null || !this.mCommonConfig.isValid()) ? false : true;
    }

    public boolean parsePresetConfig(Context context, String str) {
        boolean isValid;
        synchronized (this) {
            String readFullConfig = ConfigResourceUtils.readFullConfig(context, str, KEY_PAY_CONFIG);
            if (TextUtils.isEmpty(readFullConfig)) {
                readFullConfig = Utils.readConfigFromAsset(context, getPresetConfigFileName(str));
            }
            if (!TextUtils.isEmpty(readFullConfig)) {
                PresetConfig presetConfig = (PresetConfig) ConfigUtils.fromJson(readFullConfig, PresetConfig.class);
                if (presetConfig != null) {
                    this.mPresetConfig = presetConfig;
                    extractCommonConfig();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("PresetConfigModel, parsePresetConfig error, parse PresetConfig null with json: ");
                    sb.append(readFullConfig);
                    ACLog.e(Constants.TAG, sb.toString());
                }
            } else {
                ACLog.e(Constants.TAG, "PresetConfigModel, parsePresetConfig error, empty preset file content");
            }
            isValid = isValid();
        }
        return isValid;
    }
}

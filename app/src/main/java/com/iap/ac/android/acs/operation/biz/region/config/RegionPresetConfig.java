package com.iap.ac.android.acs.operation.biz.region.config;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.utils.resource.ConfigResourceUtils;

/* loaded from: classes3.dex */
public class RegionPresetConfig {
    public static final String KEY_REGION_CONFIG = "region_config";
    public static final String PRESET_CONFIG_FILE_EXTENSION = ".json";
    public static final String PRESET_CONFIG_FILE_NAME = "region/region_config";
    public RegionPresetBean mPresetConfig;

    private String getPresetConfigFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "region/region_config.json";
        }
        StringBuilder a2 = a.a("region/region_config_");
        a2.append(str.toLowerCase());
        a2.append(".json");
        return a2.toString();
    }

    public boolean isValid() {
        RegionPresetBean regionPresetBean = this.mPresetConfig;
        return (regionPresetBean == null || TextUtils.isEmpty(regionPresetBean.appId) || TextUtils.isEmpty(this.mPresetConfig.workerSpaceId)) ? false : true;
    }

    public boolean parsePresetConfig(Context context, String str) {
        RegionPresetFullConfig regionPresetFullConfig;
        synchronized (this) {
            String readFullConfig = ConfigResourceUtils.readFullConfig(context, str, "region_config");
            if (!TextUtils.isEmpty(readFullConfig) && (regionPresetFullConfig = (RegionPresetFullConfig) JsonUtils.fromJson(readFullConfig, RegionPresetFullConfig.class)) != null) {
                RegionPresetBean regionPresetBean = new RegionPresetBean();
                this.mPresetConfig = regionPresetBean;
                regionPresetBean.appId = regionPresetFullConfig.appId;
                regionPresetBean.workerSpaceId = regionPresetFullConfig.workspaceId;
                regionPresetBean.gatewayUrl = regionPresetFullConfig.gatewayUrl;
                regionPresetBean.gpSignature = regionPresetFullConfig.gpSignature;
                return isValid();
            }
            String readConfigFromAsset = Utils.readConfigFromAsset(context, getPresetConfigFileName(str));
            if (!TextUtils.isEmpty(readConfigFromAsset)) {
                RegionPresetBean regionPresetBean2 = (RegionPresetBean) JsonUtils.fromJson(readConfigFromAsset, RegionPresetBean.class);
                this.mPresetConfig = regionPresetBean2;
                if (regionPresetBean2 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("PresetConfigModel, parsePresetConfig error, parse PresetConfig null with json: ");
                    sb.append(readConfigFromAsset);
                    ACLog.e("IAPConnectPlugin", sb.toString());
                }
            } else {
                ACLog.e("IAPConnectPlugin", "PresetConfigModel, parsePresetConfig error, empty preset file content");
            }
            return isValid();
        }
    }
}

package com.iap.ac.android.acs.operation.biz.region.config;

import android.content.Context;
import com.iap.ac.android.biz.common.model.InitConfig;

/* loaded from: classes3.dex */
public class RegionConfigManager {
    public static final String TAG = "RegionConfigManager";
    public Context mContext;
    public RegionPresetConfig mRegionPresetConfig = new RegionPresetConfig();

    public RegionConfigManager(Context context) {
        this.mContext = context;
    }

    public RegionCommonConfig loadLocalConfig(InitConfig initConfig) {
        RegionCommonConfig regionCommonConfig;
        synchronized (this) {
            regionCommonConfig = new RegionCommonConfig();
            if (this.mRegionPresetConfig.parsePresetConfig(this.mContext, initConfig.appId)) {
                RegionPresetBean regionPresetBean = this.mRegionPresetConfig.mPresetConfig;
                regionCommonConfig.appId = regionPresetBean.appId;
                regionCommonConfig.workerSpaceId = regionPresetBean.workerSpaceId;
                regionCommonConfig.regionGatewayUrl = regionPresetBean.gatewayUrl;
                regionCommonConfig.setEnvType(initConfig.envType);
                regionCommonConfig.gpSignature = this.mRegionPresetConfig.mPresetConfig.gpSignature;
            }
        }
        return regionCommonConfig;
    }
}

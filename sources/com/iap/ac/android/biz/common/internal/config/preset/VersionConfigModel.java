package com.iap.ac.android.biz.common.internal.config.preset;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.config.utils.ConfigUtils;
import com.iap.ac.android.biz.common.model.VersionConfig;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class VersionConfigModel {
    public static final String PRESET_CONFIG_FILE_EXTENSION = ".json";
    public static final String PRESET_CONFIG_FILE_NAME = "version";
    public VersionConfig mVersionConfig;

    private String getPresetConfigFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "version.json";
        }
        StringBuilder a2 = a.a("version_");
        a2.append(str.toLowerCase());
        a2.append(".json");
        return a2.toString();
    }

    public VersionConfig getVersionConfig() {
        if (isValid()) {
            return this.mVersionConfig;
        }
        return null;
    }

    public boolean isValid() {
        VersionConfig versionConfig = this.mVersionConfig;
        return (versionConfig == null || TextUtils.isEmpty(versionConfig.iapconnectVersion)) ? false : true;
    }

    public boolean parsePresetConfig(Context context, String str) {
        boolean isValid;
        synchronized (this) {
            String readConfigFromAsset = Utils.readConfigFromAsset(context, getPresetConfigFileName(str));
            if (!TextUtils.isEmpty(readConfigFromAsset)) {
                VersionConfig versionConfig = (VersionConfig) ConfigUtils.fromJson(readConfigFromAsset, VersionConfig.class);
                if (versionConfig != null) {
                    this.mVersionConfig = versionConfig;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("VersionConfigModel, parsePresetConfig error, parse PresetConfig null with json: ");
                    sb.append(readConfigFromAsset);
                    ACLog.e(Constants.TAG, sb.toString());
                }
            } else {
                ACLog.e(Constants.TAG, "VersionConfigModel, parsePresetConfig error, empty preset file content");
            }
            isValid = isValid();
        }
        return isValid;
    }
}

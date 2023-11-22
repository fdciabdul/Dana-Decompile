package com.alipay.griver.ccdn;

import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import id.dana.domain.featureconfig.model.UgcConfig;

/* loaded from: classes6.dex */
public class CCDNH5Config {
    private static final String TAG = "CCDNH5Config";
    private JSONArray appsWhitelist;
    private int cleanupInterval;
    private boolean disableWhitelist;
    private boolean enable;
    private int maxEntries;
    private int maxMemEntries;
    private int maxMemSize;
    private JSONArray urls;
    private int volume;

    private int valueCheck(int i, int i2) {
        return i <= 0 ? i2 : i;
    }

    public CCDNH5Config(String str) {
        try {
            JSONObject parseObject = JSON.parseObject(str);
            this.enable = JSONUtils.getBoolean(parseObject, "enable", false);
            int i = JSONUtils.getInt(parseObject, GriverConfigConstants.KEY_CCDN_H5_CONFIG_VOLUME, 134217728);
            this.volume = i;
            this.volume = valueCheck(i, 134217728);
            int i2 = JSONUtils.getInt(parseObject, GriverConfigConstants.KEY_CCDN_H5_CONFIG_MAX_ENTRIES, 128);
            this.maxEntries = i2;
            this.maxEntries = valueCheck(i2, 128);
            int i3 = JSONUtils.getInt(parseObject, GriverConfigConstants.KEY_CCDN_H5_CONFIG_MAX_MEM_ENTRIES, 32);
            this.maxMemEntries = i3;
            this.maxMemEntries = valueCheck(i3, 32);
            int i4 = JSONUtils.getInt(parseObject, GriverConfigConstants.KEY_CCDN_H5_CONFIG_MAX_MEM_SIZE, 33554432);
            this.maxMemSize = i4;
            this.maxMemSize = valueCheck(i4, 33554432);
            int i5 = JSONUtils.getInt(parseObject, GriverConfigConstants.KEY_CCDN_H5_CONFIG_CLEANUP_INTERVAL, UgcConfig.DEFAULT_UGC_INTERVAL);
            this.cleanupInterval = i5;
            this.cleanupInterval = valueCheck(i5, UgcConfig.DEFAULT_UGC_INTERVAL);
            this.urls = JSONUtils.getJSONArray(parseObject, GriverConfigConstants.KEY_CCDN_H5_CONFIG_URLS, new JSONArray());
            this.appsWhitelist = JSONUtils.getJSONArray(parseObject, GriverConfigConstants.KEY_CCDN_H5_CONFIG_APPS_WHITE_LIST, new JSONArray());
            this.disableWhitelist = JSONUtils.getBoolean(parseObject, GriverConfigConstants.KEY_CCDN_H5_CONFIG_DISABEL_WHITE_LIST, false);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("CCDNH5Config error");
            sb.append(th);
            GriverLogger.e(TAG, sb.toString());
        }
    }

    public boolean isEnable() {
        return this.enable;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getMaxEntries() {
        return this.maxEntries;
    }

    public int getMaxMemEntries() {
        return this.maxMemEntries;
    }

    public int getMaxMemSize() {
        return this.maxMemSize;
    }

    public int getCleanupInterval() {
        return this.cleanupInterval;
    }

    public JSONArray getUrls() {
        return this.urls;
    }

    public JSONArray getAppsWhitelist() {
        return this.appsWhitelist;
    }

    public boolean isDisableWhitelist() {
        return this.disableWhitelist;
    }
}

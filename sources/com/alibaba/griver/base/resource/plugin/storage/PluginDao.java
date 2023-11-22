package com.alibaba.griver.base.resource.plugin.storage;

import com.alibaba.ariver.resource.api.models.PluginModel;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class PluginDao implements Serializable {
    public static final String COLUMN_LAST_REFRESH_TIMESTAMP = "lastRefreshTimestamp";
    public static final String COLUMN_PLUGIN_ID = "pluginId";
    public static final String COLUMN_PLUG_INFO = "plugInfo";
    public static final String COLUMN_VERSION = "version";
    private long lastRefreshTimestamp;
    private String pluginId;
    private PluginModel pluginInfo;
    private String version;

    public String getPluginId() {
        return this.pluginId;
    }

    public void setPluginId(String str) {
        this.pluginId = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public PluginModel getPluginInfo() {
        return this.pluginInfo;
    }

    public void setPluginInfo(PluginModel pluginModel) {
        this.pluginInfo = pluginModel;
    }

    public long getLastRefreshTimestamp() {
        return this.lastRefreshTimestamp;
    }

    public void setLastRefreshTimestamp(long j) {
        this.lastRefreshTimestamp = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlugInfoDao{pluginId='");
        sb.append(this.pluginId);
        sb.append('\'');
        sb.append(", version='");
        sb.append(this.version);
        sb.append('\'');
        sb.append(", pluginInfo=");
        sb.append(this.pluginInfo);
        sb.append(", lastRefreshTimestamp=");
        sb.append(this.lastRefreshTimestamp);
        sb.append('}');
        return sb.toString();
    }
}

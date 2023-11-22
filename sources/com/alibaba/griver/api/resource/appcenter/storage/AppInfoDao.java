package com.alibaba.griver.api.resource.appcenter.storage;

import com.alibaba.ariver.resource.api.models.AppModel;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class AppInfoDao implements Serializable {
    public static final String COLUMN_APP_ID = "appId";
    public static final String COLUMN_APP_INFO = "appInfo";
    public static final String COLUMN_LAST_OPEN_TIMESTAMP = "lastOpenTimestamp";
    public static final String COLUMN_LAST_REFRESH_TIMESTAMP = "lastRefreshTimestamp";
    public static final String COLUMN_VERSION = "version";
    private String appId;
    private AppModel appInfo;
    private long lastOpenTimestamp;
    private long lastRefreshTimestamp;
    private String version;

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public AppModel getAppInfo() {
        return this.appInfo;
    }

    public void setAppInfo(AppModel appModel) {
        this.appInfo = appModel;
    }

    public long getLastRefreshTimestamp() {
        return this.lastRefreshTimestamp;
    }

    public void setLastRefreshTimestamp(long j) {
        this.lastRefreshTimestamp = j;
    }

    public long getLastOpenTimestamp() {
        return this.lastOpenTimestamp;
    }

    public void setLastOpenTimestamp(long j) {
        this.lastOpenTimestamp = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppInfoDao{appId='");
        sb.append(this.appId);
        sb.append('\'');
        sb.append(", version='");
        sb.append(this.version);
        sb.append('\'');
        sb.append(", appInfo=");
        sb.append(this.appInfo);
        sb.append(", lastRefreshTimestamp=");
        sb.append(this.lastRefreshTimestamp);
        sb.append(", lastOpenTimestamp=");
        sb.append(this.lastOpenTimestamp);
        sb.append('}');
        return sb.toString();
    }
}

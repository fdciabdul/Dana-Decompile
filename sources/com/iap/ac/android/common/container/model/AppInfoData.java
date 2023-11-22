package com.iap.ac.android.common.container.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class AppInfoData implements Serializable {
    public String appDesc;
    public String appId;
    public String appName;
    public String appSlogan;
    public List<CategoryInfoData> categoryInfos = new ArrayList();
    public String deployVersion;
    public String iconUrl;
    public String status;

    public String getAppDesc() {
        return this.appDesc;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppSlogan() {
        return this.appSlogan;
    }

    public List<CategoryInfoData> getCategoryInfos() {
        return this.categoryInfos;
    }

    public String getDeployVersion() {
        return this.deployVersion;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getStatus() {
        return this.status;
    }

    public void setAppDesc(String str) {
        this.appDesc = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppSlogan(String str) {
        this.appSlogan = str;
    }

    public void setCategoryInfos(List<CategoryInfoData> list) {
        this.categoryInfos = list;
    }

    public void setDeployVersion(String str) {
        this.deployVersion = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}

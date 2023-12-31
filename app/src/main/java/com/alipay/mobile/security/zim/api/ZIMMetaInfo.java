package com.alipay.mobile.security.zim.api;

/* loaded from: classes3.dex */
public class ZIMMetaInfo {
    private String apdidToken;
    private String appName;
    private String appVersion;
    private String bioMetaInfo;
    private String buildVersion;
    private String deviceModel;
    private String deviceType;
    private String osVersion;

    public String getBuildVersion() {
        return this.buildVersion;
    }

    public void setBuildVersion(String str) {
        this.buildVersion = str;
    }

    public String getApdidToken() {
        return this.apdidToken;
    }

    public void setApdidToken(String str) {
        this.apdidToken = str;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public String getBioMetaInfo() {
        return this.bioMetaInfo;
    }

    public void setBioMetaInfo(String str) {
        this.bioMetaInfo = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ZIMMetaInfo{apdidToken='");
        sb.append(this.apdidToken);
        sb.append('\'');
        sb.append(", deviceType='");
        sb.append(this.deviceType);
        sb.append('\'');
        sb.append(", deviceModel='");
        sb.append(this.deviceModel);
        sb.append('\'');
        sb.append(", appName='");
        sb.append(this.appName);
        sb.append('\'');
        sb.append(", appVersion='");
        sb.append(this.appVersion);
        sb.append('\'');
        sb.append(", osVersion='");
        sb.append(this.osVersion);
        sb.append('\'');
        sb.append(", bioMetaInfo='");
        sb.append(this.bioMetaInfo);
        sb.append('\'');
        sb.append(", buildVersion='");
        sb.append(this.buildVersion);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AppInfoModel implements Parcelable, Serializable {
    public static final Parcelable.Creator<AppInfoModel> CREATOR = new Parcelable.Creator<AppInfoModel>() { // from class: com.alibaba.ariver.resource.api.models.AppInfoModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppInfoModel createFromParcel(Parcel parcel) {
            return new AppInfoModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppInfoModel[] newArray(int i) {
            return new AppInfoModel[i];
        }
    };
    private static final long serialVersionUID = -5050984571826320290L;
    @JSONField
    private String alias;
    @JSONField
    private String appId;
    @JSONField
    private String appKey;
    @JSONField
    private JSONArray appStartTags;
    @JSONField
    private String desc;
    @JSONField
    private String developerVersion;
    @JSONField
    private String fallbackBaseUrl;
    @JSONField
    private String logo;
    @JSONField
    private String mainUrl;
    @JSONField
    private String name;
    @JSONField
    private String newFallbackBaseUrl;
    @JSONField
    private String newPackageSize;
    @JSONField
    private String newPackageUrl;
    @JSONField(name = "newSubPackageUrls")
    private JSONObject newSubPackages;
    @JSONField
    private String origin;
    @JSONField
    private String packageSize;
    @JSONField
    private String packageUrl;
    @JSONField
    private String patchInfo;
    @JSONField
    private List<SpecificPluginInfo> pluginVersionInfo;
    private List<PluginModel> plugins;
    @JSONField
    private String reqmode;
    @JSONField
    private String slogan;
    @JSONField
    private String status;
    @JSONField(name = "subPackageUrls")
    private JSONObject subPackages;
    @JSONField
    private int subType;
    @JSONField
    private TemplateConfigModel templateConfig;
    @JSONField(name = "deployVersion")
    private String version;
    @JSONField
    private String vhost;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AppInfoModel() {
    }

    protected AppInfoModel(Parcel parcel) {
        this.appId = parcel.readString();
        this.name = parcel.readString();
        this.alias = parcel.readString();
        this.logo = parcel.readString();
        this.desc = parcel.readString();
        this.origin = parcel.readString();
        this.version = parcel.readString();
        this.developerVersion = parcel.readString();
        this.fallbackBaseUrl = parcel.readString();
        this.newFallbackBaseUrl = parcel.readString();
        this.packageUrl = parcel.readString();
        this.newPackageUrl = parcel.readString();
        this.packageSize = parcel.readString();
        this.newPackageSize = parcel.readString();
        this.vhost = parcel.readString();
        this.mainUrl = parcel.readString();
        this.appKey = parcel.readString();
        this.patchInfo = parcel.readString();
        this.subPackages = (JSONObject) parcel.readSerializable();
        this.newSubPackages = (JSONObject) parcel.readSerializable();
        this.templateConfig = (TemplateConfigModel) parcel.readParcelable(AppInfoModel.class.getClassLoader());
        int readInt = parcel.readInt();
        if (readInt > 0) {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(PluginModel.class.getClassLoader());
            this.plugins = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                Parcelable parcelable = readParcelableArray[i];
                if (parcelable instanceof PluginModel) {
                    this.plugins.add((PluginModel) parcelable);
                }
            }
        }
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            Parcelable[] readParcelableArray2 = parcel.readParcelableArray(SpecificPluginInfo.class.getClassLoader());
            this.pluginVersionInfo = new ArrayList();
            for (int i2 = 0; i2 < readInt2; i2++) {
                Parcelable parcelable2 = readParcelableArray2[i2];
                if (parcelable2 instanceof SpecificPluginInfo) {
                    this.pluginVersionInfo.add((SpecificPluginInfo) parcelable2);
                }
            }
        }
        this.status = parcel.readString();
        this.slogan = parcel.readString();
        this.subType = parcel.readInt();
        this.reqmode = parcel.readString();
        this.appStartTags = (JSONArray) parcel.readSerializable();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.name);
        parcel.writeString(this.alias);
        parcel.writeString(this.logo);
        parcel.writeString(this.desc);
        parcel.writeString(this.origin);
        parcel.writeString(this.version);
        parcel.writeString(this.developerVersion);
        parcel.writeString(this.fallbackBaseUrl);
        parcel.writeString(this.newFallbackBaseUrl);
        parcel.writeString(this.packageUrl);
        parcel.writeString(this.newPackageUrl);
        parcel.writeString(this.packageSize);
        parcel.writeString(this.newPackageSize);
        parcel.writeString(this.vhost);
        parcel.writeString(this.mainUrl);
        parcel.writeString(this.appKey);
        parcel.writeString(this.patchInfo);
        parcel.writeSerializable(this.subPackages);
        parcel.writeSerializable(this.newSubPackages);
        parcel.writeParcelable(this.templateConfig, 0);
        List<PluginModel> list = this.plugins;
        int size = list == null ? 0 : list.size();
        parcel.writeInt(size);
        if (size > 0) {
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                parcelableArr[i2] = this.plugins.get(i2);
            }
            parcel.writeParcelableArray(parcelableArr, 0);
        }
        List<SpecificPluginInfo> list2 = this.pluginVersionInfo;
        int size2 = list2 == null ? 0 : list2.size();
        parcel.writeInt(size2);
        if (size2 > 0) {
            Parcelable[] parcelableArr2 = new Parcelable[size2];
            for (int i3 = 0; i3 < size2; i3++) {
                parcelableArr2[i3] = this.pluginVersionInfo.get(i3);
            }
            parcel.writeParcelableArray(parcelableArr2, 0);
        }
        parcel.writeString(this.status);
        parcel.writeString(this.slogan);
        parcel.writeInt(this.subType);
        parcel.writeString(this.reqmode);
        parcel.writeSerializable(this.appStartTags);
    }

    public String getWholePackageUrl() {
        String string = getSubPackages() != null ? JSONUtils.getString(getSubPackages(), "whole") : null;
        return TextUtils.isEmpty(string) ? getPackageUrl() : string;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getPatchInfo() {
        return this.patchInfo;
    }

    public void setPatchInfo(String str) {
        this.patchInfo = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getDeveloperVersion() {
        return this.developerVersion;
    }

    public void setDeveloperVersion(String str) {
        this.developerVersion = str;
    }

    public String getFallbackBaseUrl() {
        return this.fallbackBaseUrl;
    }

    public void setFallbackBaseUrl(String str) {
        this.fallbackBaseUrl = str;
    }

    public String getPackageUrl() {
        return this.packageUrl;
    }

    public void setPackageUrl(String str) {
        this.packageUrl = str;
    }

    public String getPackageSize() {
        return this.packageSize;
    }

    public void setPackageSize(String str) {
        this.packageSize = str;
    }

    public String getVhost() {
        return this.vhost;
    }

    public void setVhost(String str) {
        this.vhost = str;
    }

    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(String str) {
        this.mainUrl = str;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public JSONObject getSubPackages() {
        return this.subPackages;
    }

    public void setSubPackages(JSONObject jSONObject) {
        this.subPackages = jSONObject;
    }

    public TemplateConfigModel getTemplateConfig() {
        return this.templateConfig;
    }

    public void setTemplateConfig(TemplateConfigModel templateConfigModel) {
        this.templateConfig = templateConfigModel;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public int getSubType() {
        return this.subType;
    }

    public void setSubType(int i) {
        this.subType = i;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public List<PluginModel> getPlugins() {
        return this.plugins;
    }

    public void setPlugins(List<PluginModel> list) {
        this.plugins = list;
    }

    public String getSlogan() {
        return this.slogan;
    }

    public void setSlogan(String str) {
        this.slogan = str;
    }

    public String getNewFallbackBaseUrl() {
        return this.newFallbackBaseUrl;
    }

    public void setNewFallbackBaseUrl(String str) {
        this.newFallbackBaseUrl = str;
    }

    public String getNewPackageUrl() {
        return this.newPackageUrl;
    }

    public void setNewPackageUrl(String str) {
        this.newPackageUrl = str;
    }

    public String getNewPackageSize() {
        return this.newPackageSize;
    }

    public void setNewPackageSize(String str) {
        this.newPackageSize = str;
    }

    public JSONObject getNewSubPackages() {
        return this.newSubPackages;
    }

    public void setNewSubPackages(JSONObject jSONObject) {
        this.newSubPackages = jSONObject;
    }

    public JSONArray getAppStartTags() {
        return this.appStartTags;
    }

    public void setAppStartTags(JSONArray jSONArray) {
        this.appStartTags = jSONArray;
    }

    public String getReqmode() {
        return this.reqmode;
    }

    public void setReqmode(String str) {
        this.reqmode = str;
    }

    public List<SpecificPluginInfo> getPluginVersionInfo() {
        return this.pluginVersionInfo;
    }

    public void setPluginVersionInfo(List<SpecificPluginInfo> list) {
        this.pluginVersionInfo = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppInfoModel{appId='");
        sb.append(this.appId);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", alias='");
        sb.append(this.alias);
        sb.append('\'');
        sb.append(", logo='");
        sb.append(this.logo);
        sb.append('\'');
        sb.append(", desc='");
        sb.append(this.desc);
        sb.append('\'');
        sb.append(", origin='");
        sb.append(this.origin);
        sb.append('\'');
        sb.append(", version='");
        sb.append(this.version);
        sb.append('\'');
        sb.append(", developerVersion='");
        sb.append(this.developerVersion);
        sb.append('\'');
        sb.append(", fallbackBaseUrl='");
        sb.append(this.fallbackBaseUrl);
        sb.append('\'');
        sb.append(", newFallbackBaseUrl='");
        sb.append(this.newFallbackBaseUrl);
        sb.append('\'');
        sb.append(", packageUrl='");
        sb.append(this.packageUrl);
        sb.append('\'');
        sb.append(", newPackageUrl='");
        sb.append(this.newPackageUrl);
        sb.append('\'');
        sb.append(", packageSize='");
        sb.append(this.packageSize);
        sb.append('\'');
        sb.append(", newPackageSize='");
        sb.append(this.newPackageSize);
        sb.append('\'');
        sb.append(", vhost='");
        sb.append(this.vhost);
        sb.append('\'');
        sb.append(", mainUrl='");
        sb.append(this.mainUrl);
        sb.append('\'');
        sb.append(", appKey='");
        sb.append(this.appKey);
        sb.append('\'');
        sb.append(", subPackages=");
        sb.append(this.subPackages);
        sb.append(", newSubPackages=");
        sb.append(this.newSubPackages);
        sb.append(", patchInfo=");
        sb.append(this.patchInfo);
        sb.append(", templateConfig=");
        sb.append(this.templateConfig);
        sb.append(", plugins=");
        sb.append(this.plugins);
        sb.append(", pluginVersionInfo=");
        sb.append(this.pluginVersionInfo);
        sb.append(", status='");
        sb.append(this.status);
        sb.append('\'');
        sb.append(", slogan=");
        sb.append(this.slogan);
        sb.append(", reqmode=");
        sb.append(this.reqmode);
        sb.append(", appStartTags=");
        sb.append(this.appStartTags);
        sb.append('}');
        return sb.toString();
    }
}

package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class PluginModel implements Parcelable, Serializable {
    public static final Parcelable.Creator<PluginModel> CREATOR = new Parcelable.Creator<PluginModel>() { // from class: com.alibaba.ariver.resource.api.models.PluginModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PluginModel createFromParcel(Parcel parcel) {
            return new PluginModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PluginModel[] newArray(int i) {
            return new PluginModel[i];
        }
    };
    private static final long serialVersionUID = 5268600696037076004L;
    @JSONField
    private String appId;
    @JSONField
    private String appKey;
    @JSONField
    private String developerVersion;
    @JSONField
    private JSONObject extendInfo;
    @JSONField
    private String fallbackBaseUrl;
    @JSONField
    private String newFallbackBaseUrl;
    @JSONField
    private String newPackageSize;
    @JSONField
    private String newPackageUrl;
    @JSONField
    private String packageSize;
    @JSONField
    private String packageUrl;
    @JSONField
    private JSONObject permission;
    @JSONField
    private String pluginScene;
    @JSONField
    private String requireVersion;
    @JSONField(name = "deployVersion")
    private String version;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PluginModel() {
    }

    protected PluginModel(Parcel parcel) {
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.packageUrl = parcel.readString();
        this.newPackageUrl = parcel.readString();
        this.packageSize = parcel.readString();
        this.newPackageSize = parcel.readString();
        this.fallbackBaseUrl = parcel.readString();
        this.newFallbackBaseUrl = parcel.readString();
        this.developerVersion = parcel.readString();
        this.requireVersion = parcel.readString();
        this.pluginScene = parcel.readString();
        this.version = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            byte[] buf = IOUtils.getBuf(readInt);
            parcel.readByteArray(buf);
            this.permission = JSONUtils.unmarshallJSONObject(buf);
        }
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            byte[] buf2 = IOUtils.getBuf(readInt2);
            parcel.readByteArray(buf2);
            this.extendInfo = JSONUtils.unmarshallJSONObject(buf2);
        }
    }

    public String getPluginScene() {
        return this.pluginScene;
    }

    public void setPluginScene(String str) {
        this.pluginScene = str;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void setAppKey(String str) {
        this.appKey = str;
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

    public String getNewFallbackBaseUrl() {
        return this.newFallbackBaseUrl;
    }

    public void setNewFallbackBaseUrl(String str) {
        this.newFallbackBaseUrl = str;
    }

    public String getRequireVersion() {
        return this.requireVersion;
    }

    public void setRequireVersion(String str) {
        this.requireVersion = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public JSONObject getPermission() {
        return this.permission;
    }

    public void setPermission(JSONObject jSONObject) {
        this.permission = jSONObject;
    }

    public JSONObject getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(JSONObject jSONObject) {
        this.extendInfo = jSONObject;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PluginModel{appId='");
        sb.append(this.appId);
        sb.append('\'');
        sb.append(", appKey='");
        sb.append(this.appKey);
        sb.append('\'');
        sb.append(", packageUrl='");
        sb.append(this.packageUrl);
        sb.append('\'');
        sb.append(", packageSize='");
        sb.append(this.packageSize);
        sb.append('\'');
        sb.append(", newPackageUrl='");
        sb.append(this.newPackageUrl);
        sb.append('\'');
        sb.append(", newPackageSize='");
        sb.append(this.newPackageSize);
        sb.append('\'');
        sb.append(", fallbackBaseUrl='");
        sb.append(this.fallbackBaseUrl);
        sb.append('\'');
        sb.append(", newFallbackBaseUrl='");
        sb.append(this.newFallbackBaseUrl);
        sb.append('\'');
        sb.append(", developerVersion='");
        sb.append(this.developerVersion);
        sb.append('\'');
        sb.append(", requireVersion='");
        sb.append(this.requireVersion);
        sb.append('\'');
        sb.append(", pluginScene='");
        sb.append(this.pluginScene);
        sb.append('\'');
        sb.append(", version='");
        sb.append(this.version);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appKey);
        parcel.writeString(this.packageUrl);
        parcel.writeString(this.newPackageUrl);
        parcel.writeString(this.packageSize);
        parcel.writeString(this.newPackageSize);
        parcel.writeString(this.fallbackBaseUrl);
        parcel.writeString(this.newFallbackBaseUrl);
        parcel.writeString(this.developerVersion);
        parcel.writeString(this.requireVersion);
        parcel.writeString(this.pluginScene);
        parcel.writeString(this.version);
        byte[] marshallJSONObject = JSONUtils.marshallJSONObject(this.permission);
        int length = marshallJSONObject == null ? 0 : marshallJSONObject.length;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(marshallJSONObject);
        }
        byte[] marshallJSONObject2 = JSONUtils.marshallJSONObject(this.extendInfo);
        int length2 = marshallJSONObject2 != null ? marshallJSONObject2.length : 0;
        parcel.writeInt(length2);
        if (length2 > 0) {
            parcel.writeByteArray(marshallJSONObject2);
        }
    }
}

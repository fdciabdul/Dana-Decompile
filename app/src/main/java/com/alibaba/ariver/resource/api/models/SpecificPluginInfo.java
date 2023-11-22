package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class SpecificPluginInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<SpecificPluginInfo> CREATOR = new Parcelable.Creator<SpecificPluginInfo>() { // from class: com.alibaba.ariver.resource.api.models.SpecificPluginInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SpecificPluginInfo createFromParcel(Parcel parcel) {
            return new SpecificPluginInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SpecificPluginInfo[] newArray(int i) {
            return new SpecificPluginInfo[i];
        }
    };
    private static final long serialVersionUID = -5153414854273050635L;
    @JSONField
    private String appId;
    @JSONField
    private String requireVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SpecificPluginInfo() {
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getRequireVersion() {
        return this.requireVersion;
    }

    public void setRequireVersion(String str) {
        this.requireVersion = str;
    }

    protected SpecificPluginInfo(Parcel parcel) {
        this.appId = parcel.readString();
        this.requireVersion = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.requireVersion);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpecificPluginInfo{appId='");
        sb.append(this.appId);
        sb.append('\'');
        sb.append(", requireVersion='");
        sb.append(this.requireVersion);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}

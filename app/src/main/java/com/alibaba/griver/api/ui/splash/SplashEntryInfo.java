package com.alibaba.griver.api.ui.splash;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class SplashEntryInfo implements Parcelable {
    public static final Parcelable.Creator<SplashEntryInfo> CREATOR = new Parcelable.Creator<SplashEntryInfo>() { // from class: com.alibaba.griver.api.ui.splash.SplashEntryInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SplashEntryInfo createFromParcel(Parcel parcel) {
            return new SplashEntryInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SplashEntryInfo[] newArray(int i) {
            return new SplashEntryInfo[i];
        }
    };
    public static final String NEED_REFRESH = "needRefresh";
    public static final String PROGRESS = "progress";
    public String appId;
    public String appName;
    public String desc;
    public String iconUrl;
    public boolean needRefresh;
    public int progress;
    public String slogan;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SplashEntryInfo() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appName);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.desc);
        parcel.writeString(this.slogan);
        parcel.writeInt(this.progress);
        parcel.writeByte(this.needRefresh ? (byte) 1 : (byte) 0);
    }

    protected SplashEntryInfo(Parcel parcel) {
        this.appId = parcel.readString();
        this.appName = parcel.readString();
        this.iconUrl = parcel.readString();
        this.desc = parcel.readString();
        this.slogan = parcel.readString();
        this.progress = parcel.readInt();
        this.needRefresh = parcel.readByte() != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplashEntryInfo{appId='");
        sb.append(this.appId);
        sb.append('\'');
        sb.append(", appName='");
        sb.append(this.appName);
        sb.append('\'');
        sb.append(", iconUrl='");
        sb.append(this.iconUrl);
        sb.append('\'');
        sb.append(", desc='");
        sb.append(this.desc);
        sb.append('\'');
        sb.append(", slogan='");
        sb.append(this.slogan);
        sb.append('\'');
        sb.append(", progress=");
        sb.append(this.progress);
        sb.append(", needRefresh=");
        sb.append(this.needRefresh);
        sb.append('}');
        return sb.toString();
    }
}

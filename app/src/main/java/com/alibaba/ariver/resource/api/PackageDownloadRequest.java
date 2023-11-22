package com.alibaba.ariver.resource.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class PackageDownloadRequest implements Parcelable {
    public static final Parcelable.Creator<PackageDownloadRequest> CREATOR = new Parcelable.Creator<PackageDownloadRequest>() { // from class: com.alibaba.ariver.resource.api.PackageDownloadRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PackageDownloadRequest createFromParcel(Parcel parcel) {
            return new PackageDownloadRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PackageDownloadRequest[] newArray(int i) {
            return new PackageDownloadRequest[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f6198a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private Bundle h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PackageDownloadRequest() {
        this.h = new Bundle();
    }

    protected PackageDownloadRequest(Parcel parcel) {
        this.h = new Bundle();
        this.f6198a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readByte() != 0;
        this.g = parcel.readByte() != 0;
        this.h = parcel.readBundle();
    }

    public String getFileName() {
        return this.b;
    }

    public void setFileName(String str) {
        this.b = str;
    }

    public String getFilePath() {
        return this.c;
    }

    public void setFilePath(String str) {
        this.c = str;
    }

    public String getDownloadUrl() {
        return this.f6198a;
    }

    public void setDownloadUrl(String str) {
        this.f6198a = str;
    }

    public String getAppId() {
        return this.d;
    }

    public void setAppId(String str) {
        this.d = str;
    }

    public String getVersion() {
        return this.e;
    }

    public void setVersion(String str) {
        this.e = str;
    }

    public boolean isAutoInstall() {
        return this.f;
    }

    public void setAutoInstall(boolean z) {
        this.f = z;
    }

    public boolean isUrgentResource() {
        return this.g;
    }

    public void setIsUrgentResource(boolean z) {
        this.g = z;
    }

    public Bundle getRequestParam() {
        return this.h;
    }

    public static boolean isInDownloadPath(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("nebulaDownload");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6198a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeBundle(this.h);
    }
}

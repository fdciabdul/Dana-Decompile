package com.alibaba.ariver.resource.api.prepare;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class PrepareData implements Parcelable {
    public static final Parcelable.Creator<PrepareData> CREATOR = new Parcelable.Creator<PrepareData>() { // from class: com.alibaba.ariver.resource.api.prepare.PrepareData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PrepareData createFromParcel(Parcel parcel) {
            return new PrepareData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PrepareData[] newArray(int i) {
            return new PrepareData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private long f6216a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;

    /* renamed from: o  reason: collision with root package name */
    private String f6217o;
    private String p;
    private Bundle q;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getData() {
        return this.q;
    }

    public PrepareData() {
        this.q = new Bundle();
        clear();
    }

    protected PrepareData(Parcel parcel) {
        this.q = new Bundle();
        this.j = parcel.readString();
        this.f6216a = parcel.readLong();
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        this.h = parcel.readLong();
        this.i = parcel.readByte() != 0;
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.f6217o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readBundle();
    }

    public void clear() {
        this.d = 0L;
        this.c = 0L;
        this.b = 0L;
        this.f6216a = 0L;
        this.h = 0L;
        this.f = 0L;
        this.i = false;
        this.n = "";
        this.m = "";
        this.p = "";
        this.f6217o = "";
        this.l = "";
        this.k = "";
    }

    public long getBeginTime() {
        return this.f6216a;
    }

    public void setBeginTime(long j) {
        this.f6216a = j;
    }

    public long getRequestBeginTime() {
        return this.b;
    }

    public void setRequestBeginTime(long j) {
        this.b = j;
    }

    public long getRequestEndTime() {
        return this.c;
    }

    public void setRequestEndTime(long j) {
        this.c = j;
    }

    public long getDownloadTime() {
        return this.d;
    }

    public void setDownloadTime(long j) {
        long j2 = this.d;
        if (j2 == 0 || j2 > j) {
            this.d = j;
        }
    }

    public long getInstallTime() {
        return this.f;
    }

    public void setInstallTime(long j) {
        this.f = j;
    }

    public long getDownloadEndTime() {
        return this.e;
    }

    public void setDownloadEndTime(long j) {
        this.e = j;
    }

    public long getInstallEndTime() {
        return this.g;
    }

    public void setInstallEndTime(long j) {
        this.g = j;
    }

    public String getAppType() {
        return this.j;
    }

    public void setAppType(String str) {
        this.j = str;
    }

    public long getEndTime() {
        return this.h;
    }

    public void setEndTime(long j) {
        this.h = j;
    }

    public boolean getOriginHasAppInfo() {
        return this.i;
    }

    public void setOriginHasAppInfo(boolean z) {
        this.i = z;
    }

    public String getRequestMode() {
        return this.k;
    }

    public void setRequestMode(UpdateMode updateMode) {
        this.k = String.valueOf(updateMode.value);
    }

    public String getOfflineMode() {
        return this.l;
    }

    public void setOfflineMode(OfflineMode offlineMode) {
        this.l = String.valueOf(offlineMode.value);
    }

    public String getNbUrl() {
        return this.n;
    }

    public void setNbUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            this.n = "";
        } else {
            this.n = str;
        }
    }

    public String getAppId() {
        return this.f6217o;
    }

    public void setAppId(String str) {
        this.f6217o = str;
    }

    public String getVersion() {
        return this.p;
    }

    public void setVersion(String str) {
        this.p = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrepareData{beginTime=");
        sb.append(this.f6216a);
        sb.append(", requestBeginTime=");
        sb.append(this.b);
        sb.append(", requestEndTime=");
        sb.append(this.c);
        sb.append(", downloadTime=");
        sb.append(this.d);
        sb.append(", installTime=");
        sb.append(this.f);
        sb.append(", endTime=");
        sb.append(this.h);
        sb.append(", originHasAppInfo=");
        sb.append(this.i);
        sb.append(", offlineMode=");
        sb.append(this.l);
        sb.append(", errorDetail=");
        sb.append(this.m);
        sb.append(", bundleData=");
        sb.append(this.q);
        sb.append(", nbUrl='");
        sb.append(this.n);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeLong(this.f6216a);
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        parcel.writeLong(this.h);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.f6217o);
        parcel.writeString(this.p);
        parcel.writeBundle(this.q);
    }
}

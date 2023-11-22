package com.alibaba.griver.base.resource.cache;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class GriverCacheDao implements Parcelable {
    public static final String COLUMN_CACHE_CREATE_TIMESTAMP = "createTimeStamp";
    public static final String COLUMN_CACHE_EXPIRED_TIMESTAMP = "expiredTimeStamp";
    public static final String COLUMN_CACHE_EXTRA = "extra";
    public static final String COLUMN_CACHE_ID = "id";
    public static final String COLUMN_CACHE_KEY = "cacheKey";
    public static final String COLUMN_CACHE_NAME = "cacheName";
    public static final String COLUMN_CACHE_SIZE = "cacheSize";
    public static final String COLUMN_CACHE_TYPE = "cacheType";
    public static final String COLUMN_CACHE_VALUE = "cacheValue";
    public static final Parcelable.Creator<GriverCacheDao> CREATOR = new Parcelable.Creator<GriverCacheDao>() { // from class: com.alibaba.griver.base.resource.cache.GriverCacheDao.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GriverCacheDao createFromParcel(Parcel parcel) {
            return new GriverCacheDao(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GriverCacheDao[] newArray(int i) {
            return new GriverCacheDao[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private Integer f6356a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Long f;
    private Long g;
    private Long h;
    private String i;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Integer getId() {
        return this.f6356a;
    }

    public void setId(Integer num) {
        this.f6356a = num;
    }

    public String getCacheName() {
        return this.b;
    }

    public void setCacheName(String str) {
        this.b = str;
    }

    public String getCacheKey() {
        return this.c;
    }

    public void setCacheKey(String str) {
        this.c = str;
    }

    public String getCacheValue() {
        return this.d;
    }

    public void setCacheValue(String str) {
        this.d = str;
    }

    public String getCacheType() {
        return this.e;
    }

    public void setCacheType(String str) {
        this.e = str;
    }

    public Long getCacheSize() {
        return this.f;
    }

    public void setCacheSize(Long l) {
        this.f = l;
    }

    public Long getExpiredTimeStamp() {
        return this.g;
    }

    public void setExpiredTimeStamp(Long l) {
        this.g = l;
    }

    public Long getCreateTimeStamp() {
        return this.h;
    }

    public void setCreateTimeStamp(Long l) {
        this.h = l;
    }

    public String getExtra() {
        return this.i;
    }

    public void setExtra(String str) {
        this.i = str;
    }

    public GriverCacheDao() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f6356a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeValue(this.f);
        parcel.writeValue(this.g);
        parcel.writeValue(this.h);
        parcel.writeString(this.i);
    }

    protected GriverCacheDao(Parcel parcel) {
        this.f6356a = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = (Long) parcel.readValue(Long.class.getClassLoader());
        this.g = (Long) parcel.readValue(Long.class.getClassLoader());
        this.h = (Long) parcel.readValue(Long.class.getClassLoader());
        this.i = parcel.readString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GriverCacheDao{id=");
        sb.append(this.f6356a);
        sb.append(", cacheName='");
        sb.append(this.b);
        sb.append('\'');
        sb.append(", cacheKey='");
        sb.append(this.c);
        sb.append('\'');
        sb.append(", cacheValue='");
        sb.append(this.d);
        sb.append('\'');
        sb.append(", cacheType='");
        sb.append(this.e);
        sb.append('\'');
        sb.append(", cacheSize=");
        sb.append(this.f);
        sb.append(", expiredTimeStamp=");
        sb.append(this.g);
        sb.append(", createTimeStamp=");
        sb.append(this.h);
        sb.append(", extra='");
        sb.append(this.i);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new a();
    public Bundle KClassImpl$Data$declaredNonStaticMembers$2;
    public Bundle MyBillsEntityDataFactory;
    public int PlaceComponentResult;
    public String getAuthRequestContext;

    /* synthetic */ DataBuffer(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.PlaceComponentResult);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeBundle(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeBundle(this.MyBillsEntityDataFactory);
    }

    private DataBuffer(Parcel parcel) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.PlaceComponentResult = 1;
        this.MyBillsEntityDataFactory = null;
        this.PlaceComponentResult = parcel.readInt();
        this.getAuthRequestContext = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readBundle(Bundle.class.getClassLoader());
        this.MyBillsEntityDataFactory = parcel.readBundle(Bundle.class.getClassLoader());
    }

    public DataBuffer() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.PlaceComponentResult = 1;
        this.MyBillsEntityDataFactory = null;
    }

    public DataBuffer(String str, int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.MyBillsEntityDataFactory = null;
        this.getAuthRequestContext = str;
        this.PlaceComponentResult = i;
    }

    /* loaded from: classes7.dex */
    static final class a implements Parcelable.Creator<DataBuffer> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DataBuffer[] newArray(int i) {
            return new DataBuffer[i];
        }
    }
}

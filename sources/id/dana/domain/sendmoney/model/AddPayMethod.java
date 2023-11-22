package id.dana.domain.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class AddPayMethod implements Parcelable {
    public static final Parcelable.Creator<AddPayMethod> CREATOR = new Parcelable.Creator<AddPayMethod>() { // from class: id.dana.domain.sendmoney.model.AddPayMethod.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AddPayMethod createFromParcel(Parcel parcel) {
            return new AddPayMethod(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AddPayMethod[] newArray(int i) {
            return new AddPayMethod[i];
        }
    };
    public boolean enable;
    public String instId;
    public String instLocalName;
    public String key;
    public String payMethod;
    public String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AddPayMethod() {
    }

    public AddPayMethod(String str, String str2, String str3, String str4, String str5, boolean z) {
        this.key = str;
        this.instId = str2;
        this.instLocalName = str3;
        this.payMethod = str4;
        this.url = str5;
        this.enable = z;
    }

    protected AddPayMethod(Parcel parcel) {
        this.key = parcel.readString();
        this.instId = parcel.readString();
        this.instLocalName = parcel.readString();
        this.payMethod = parcel.readString();
        this.url = parcel.readString();
        this.enable = parcel.readByte() != 0;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getInstId() {
        return this.instId;
    }

    public void setInstId(String str) {
        this.instId = str;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public String getInstLocalName() {
        return this.instLocalName;
    }

    public void setInstLocalName(String str) {
        this.instLocalName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.instId);
        parcel.writeString(this.instLocalName);
        parcel.writeString(this.payMethod);
        parcel.writeString(this.url);
        parcel.writeByte(this.enable ? (byte) 1 : (byte) 0);
    }
}

package com.iap.ac.android.acs.plugin.rpc.getphonenumber.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;

/* loaded from: classes8.dex */
public class MobilePhoneInfo implements Parcelable {
    public static final Parcelable.Creator<MobilePhoneInfo> CREATOR = new Parcelable.Creator<MobilePhoneInfo>() { // from class: com.iap.ac.android.acs.plugin.rpc.getphonenumber.model.MobilePhoneInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MobilePhoneInfo createFromParcel(Parcel parcel) {
            MobilePhoneInfo mobilePhoneInfo = new MobilePhoneInfo();
            mobilePhoneInfo.region = parcel.readString();
            mobilePhoneInfo.formattedMobilePhoneNumber = parcel.readString();
            mobilePhoneInfo.mobilePhoneNumber = parcel.readString();
            mobilePhoneInfo.mobilePhoneRegionCode = parcel.readString();
            return mobilePhoneInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MobilePhoneInfo[] newArray(int i) {
            return new MobilePhoneInfo[i];
        }
    };
    public String formattedMobilePhoneNumber;
    public String mobilePhoneNumber;
    public String mobilePhoneRegionCode;
    public String region;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder a2 = a.a("MobilePhoneInfo{region='");
        a2.append(this.region);
        a2.append('\'');
        a2.append(", formattedMobilePhoneNumber='");
        a2.append(UIUtils.encryptPhoneNumber(this.formattedMobilePhoneNumber));
        a2.append('\'');
        a2.append(", mobilePhoneNumber='");
        a2.append(UIUtils.encryptPhoneNumber(this.mobilePhoneNumber));
        a2.append('\'');
        a2.append(", mobilePhoneRegionCode='");
        a2.append(this.mobilePhoneRegionCode);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.region);
        parcel.writeString(this.formattedMobilePhoneNumber);
        parcel.writeString(this.mobilePhoneNumber);
        parcel.writeString(this.mobilePhoneRegionCode);
    }
}

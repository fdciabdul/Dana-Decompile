package com.iap.ac.android.acs.plugin.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.iap.ac.android.acs.plugin.a.a;

/* loaded from: classes8.dex */
public class CityModel implements Parcelable {
    public static final Parcelable.Creator<CityModel> CREATOR = new Parcelable.Creator<CityModel>() { // from class: com.iap.ac.android.acs.plugin.ui.model.CityModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CityModel createFromParcel(Parcel parcel) {
            CityModel cityModel = new CityModel();
            cityModel.code = parcel.readString();
            cityModel.name = parcel.readString();
            return cityModel;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CityModel[] newArray(int i) {
            return new CityModel[i];
        }
    };
    public String code;
    public String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder a2 = a.a("CityModel{code='");
        a2.append(this.code);
        a2.append('\'');
        a2.append(", name='");
        a2.append(this.name);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.code);
        parcel.writeString(this.name);
    }
}

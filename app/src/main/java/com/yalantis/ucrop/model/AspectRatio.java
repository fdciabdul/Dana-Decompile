package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new Parcelable.Creator<AspectRatio>() { // from class: com.yalantis.ucrop.model.AspectRatio.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AspectRatio[] newArray(int i) {
            return new AspectRatio[i];
        }
    };
    public final float BuiltInFictitiousFunctionClassFactory;
    public final float KClassImpl$Data$declaredNonStaticMembers$2;
    public final String getAuthRequestContext;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AspectRatio(String str, float f, float f2) {
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f2;
    }

    protected AspectRatio(Parcel parcel) {
        this.getAuthRequestContext = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readFloat();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeFloat(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeFloat(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}

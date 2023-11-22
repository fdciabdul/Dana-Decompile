package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class CardHolderModel implements Parcelable {
    public static final Parcelable.Creator<CardHolderModel> CREATOR = new Parcelable.Creator<CardHolderModel>() { // from class: id.dana.sendmoney.model.CardHolderModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CardHolderModel createFromParcel(Parcel parcel) {
            return new CardHolderModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CardHolderModel[] newArray(int i) {
            return new CardHolderModel[i];
        }
    };
    String KClassImpl$Data$declaredNonStaticMembers$2;
    String getAuthRequestContext;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CardHolderModel(String str, String str2) {
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
    }

    protected CardHolderModel(Parcel parcel) {
        this.getAuthRequestContext = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}

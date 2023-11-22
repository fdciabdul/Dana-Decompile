package id.dana.nearbyme.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class PromoLimitInfoModel implements Parcelable {
    public static final Parcelable.Creator<PromoLimitInfoModel> CREATOR = new Parcelable.Creator<PromoLimitInfoModel>() { // from class: id.dana.nearbyme.model.PromoLimitInfoModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PromoLimitInfoModel createFromParcel(Parcel parcel) {
            return new PromoLimitInfoModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PromoLimitInfoModel[] newArray(int i) {
            return new PromoLimitInfoModel[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected PromoLimitInfoModel(Parcel parcel) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
    }

    public PromoLimitInfoModel() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.MyBillsEntityDataFactory);
    }
}

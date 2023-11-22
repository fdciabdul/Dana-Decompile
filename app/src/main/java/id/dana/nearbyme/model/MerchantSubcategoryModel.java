package id.dana.nearbyme.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class MerchantSubcategoryModel implements Parcelable {
    public static final Parcelable.Creator<MerchantSubcategoryModel> CREATOR = new Parcelable.Creator<MerchantSubcategoryModel>() { // from class: id.dana.nearbyme.model.MerchantSubcategoryModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ MerchantSubcategoryModel createFromParcel(Parcel parcel) {
            return new MerchantSubcategoryModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MerchantSubcategoryModel[] newArray(int i) {
            return new MerchantSubcategoryModel[i];
        }
    };
    public List<String> BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String getAuthRequestContext;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MerchantSubcategoryModel() {
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
    }

    public MerchantSubcategoryModel(Parcel parcel) {
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        this.getAuthRequestContext = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeStringList(this.BuiltInFictitiousFunctionClassFactory);
    }
}

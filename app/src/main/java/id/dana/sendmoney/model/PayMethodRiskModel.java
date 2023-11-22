package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class PayMethodRiskModel implements Parcelable {
    public static final Parcelable.Creator<PayMethodRiskModel> CREATOR = new Parcelable.Creator<PayMethodRiskModel>() { // from class: id.dana.sendmoney.model.PayMethodRiskModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PayMethodRiskModel createFromParcel(Parcel parcel) {
            return new PayMethodRiskModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PayMethodRiskModel[] newArray(int i) {
            return new PayMethodRiskModel[i];
        }
    };
    String BuiltInFictitiousFunctionClassFactory;
    String KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    String PlaceComponentResult;
    private String getAuthRequestContext;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PayMethodRiskModel(String str, String str2, String str3, String str4, int i) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.getAuthRequestContext = str3;
        this.PlaceComponentResult = str4;
        this.MyBillsEntityDataFactory = i;
    }

    protected PayMethodRiskModel(Parcel parcel) {
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.PlaceComponentResult = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeInt(this.MyBillsEntityDataFactory);
    }
}

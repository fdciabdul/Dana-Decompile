package id.dana.splitbill.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.model.CurrencyAmountModel;

/* loaded from: classes5.dex */
public class PayerModel implements Parcelable {
    public static final Parcelable.Creator<PayerModel> CREATOR = new Parcelable.Creator<PayerModel>() { // from class: id.dana.splitbill.model.PayerModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PayerModel createFromParcel(Parcel parcel) {
            return new PayerModel(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PayerModel[] newArray(int i) {
            return new PayerModel[i];
        }
    };
    public CurrencyAmountModel BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String PlaceComponentResult;
    public boolean getAuthRequestContext;
    public boolean getErrorConfigVersion;
    public String lookAheadTest;
    public boolean scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ PayerModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public PayerModel(String str, CurrencyAmountModel currencyAmountModel, String str2, String str3, String str4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.BuiltInFictitiousFunctionClassFactory = currencyAmountModel;
        this.PlaceComponentResult = str2;
        this.MyBillsEntityDataFactory = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
    }

    public PayerModel(String str, CurrencyAmountModel currencyAmountModel, String str2, String str3, String str4, String str5) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.BuiltInFictitiousFunctionClassFactory = currencyAmountModel;
        this.PlaceComponentResult = str2;
        this.MyBillsEntityDataFactory = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        this.lookAheadTest = str5;
    }

    private PayerModel(Parcel parcel) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.PlaceComponentResult = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readString();
        this.getErrorConfigVersion = parcel.readInt() == 1;
        this.getAuthRequestContext = parcel.readInt() == 1;
        this.lookAheadTest = parcel.readString();
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.scheduleImpl;
    }

    public final boolean getAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeParcelable(this.BuiltInFictitiousFunctionClassFactory, i);
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeInt(this.getErrorConfigVersion ? 1 : 0);
        parcel.writeInt(this.getAuthRequestContext ? 1 : 0);
        parcel.writeString(this.lookAheadTest);
    }
}

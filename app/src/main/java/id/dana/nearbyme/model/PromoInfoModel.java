package id.dana.nearbyme.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import id.dana.model.CurrencyAmountModel;
import java.util.List;

/* loaded from: classes2.dex */
public class PromoInfoModel implements Parcelable {
    public static final Parcelable.Creator<PromoInfoModel> CREATOR = new Parcelable.Creator<PromoInfoModel>() { // from class: id.dana.nearbyme.model.PromoInfoModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PromoInfoModel createFromParcel(Parcel parcel) {
            return new PromoInfoModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PromoInfoModel[] newArray(int i) {
            return new PromoInfoModel[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public CurrencyAmountModel KClassImpl$Data$declaredNonStaticMembers$2;
    public long MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public List<PromoLimitInfoModel> PlaceComponentResult;
    public long getAuthRequestContext;
    public String getErrorConfigVersion;
    public String initRecordTimeStamp;
    public List<String> lookAheadTest;
    public String moveToNextValue;
    public CurrencyAmountModel scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PromoInfoModel() {
    }

    protected PromoInfoModel(Parcel parcel) {
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readString();
        this.initRecordTimeStamp = parcel.readString();
        this.moveToNextValue = parcel.readString();
        this.lookAheadTest = parcel.createStringArrayList();
        this.scheduleImpl = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.getAuthRequestContext = parcel.readLong();
        this.MyBillsEntityDataFactory = parcel.readLong();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.PlaceComponentResult = parcel.createTypedArrayList(PromoLimitInfoModel.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeString(this.initRecordTimeStamp);
        parcel.writeString(this.moveToNextValue);
        parcel.writeStringList(this.lookAheadTest);
        parcel.writeParcelable(this.scheduleImpl, i);
        parcel.writeLong(this.getAuthRequestContext);
        parcel.writeLong(this.MyBillsEntityDataFactory);
        parcel.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, i);
        parcel.writeTypedList(this.PlaceComponentResult);
    }

    public final String BuiltInFictitiousFunctionClassFactory() {
        return (this.KClassImpl$Data$declaredNonStaticMembers$2 == null || PlaceComponentResult()) ? "" : this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
    }

    public final String MyBillsEntityDataFactory() {
        return (this.scheduleImpl == null || getAuthRequestContext()) ? "" : this.scheduleImpl.getAuthRequestContext();
    }

    private boolean PlaceComponentResult() {
        return TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory) && TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
    }

    private boolean getAuthRequestContext() {
        return TextUtils.isEmpty(this.scheduleImpl.MyBillsEntityDataFactory) && TextUtils.isEmpty(this.scheduleImpl.BuiltInFictitiousFunctionClassFactory);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return (TextUtils.isEmpty(this.moveToNextValue) || TextUtils.isEmpty(this.getErrorConfigVersion) || !this.moveToNextValue.equalsIgnoreCase("AMOUNT_MAX")) ? false : true;
    }
}

package id.dana.splitbill.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import id.dana.data.util.NumberUtils;
import id.dana.model.CurrencyAmountModel;

/* loaded from: classes5.dex */
public class SplitBillPayerModel implements Parcelable {
    public static final Parcelable.Creator<SplitBillPayerModel> CREATOR = new Parcelable.Creator<SplitBillPayerModel>() { // from class: id.dana.splitbill.model.SplitBillPayerModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ SplitBillPayerModel createFromParcel(Parcel parcel) {
            return new SplitBillPayerModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SplitBillPayerModel[] newArray(int i) {
            return new SplitBillPayerModel[i];
        }
    };
    public boolean BuiltInFictitiousFunctionClassFactory;
    public int GetContactSyncConfig;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public boolean PlaceComponentResult;
    public CurrencyAmountModel getAuthRequestContext;
    public String getErrorConfigVersion;
    public String lookAheadTest;
    public String moveToNextValue;
    public String scheduleImpl;

    /* loaded from: classes5.dex */
    public static class Builder {
        public String BuiltInFictitiousFunctionClassFactory;
        public int GetContactSyncConfig;
        public CurrencyAmountModel KClassImpl$Data$declaredNonStaticMembers$2;
        public boolean MyBillsEntityDataFactory;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        public boolean PlaceComponentResult;
        public String getAuthRequestContext;
        public String getErrorConfigVersion;
        public String lookAheadTest;
        public String moveToNextValue;
        public String scheduleImpl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SplitBillPayerModel() {
    }

    protected SplitBillPayerModel(Parcel parcel) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readString();
        this.moveToNextValue = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.lookAheadTest = parcel.readString();
        this.scheduleImpl = parcel.readString();
        this.getAuthRequestContext = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.GetContactSyncConfig = parcel.readInt();
        this.PlaceComponentResult = parcel.readByte() != 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readByte() != 0;
        this.BuiltInFictitiousFunctionClassFactory = parcel.readByte() != 0;
        this.getErrorConfigVersion = parcel.readString();
    }

    public final boolean PlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SplitBillPayerModel) || (str = ((SplitBillPayerModel) obj).scheduleImpl) == null || this.scheduleImpl == null) {
            return false;
        }
        return NumberUtils.getClearPhoneNumber(str).equals(NumberUtils.getClearPhoneNumber(this.scheduleImpl));
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeString(this.moveToNextValue);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.lookAheadTest);
        parcel.writeString(this.scheduleImpl);
        parcel.writeParcelable(this.getAuthRequestContext, i);
        parcel.writeInt(this.GetContactSyncConfig);
        parcel.writeByte(this.PlaceComponentResult ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.KClassImpl$Data$declaredNonStaticMembers$2 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.BuiltInFictitiousFunctionClassFactory ? (byte) 1 : (byte) 0);
        parcel.writeString(this.getErrorConfigVersion);
    }

    public static boolean getAuthRequestContext(CurrencyAmountModel currencyAmountModel) {
        return (currencyAmountModel == null || TextUtils.isEmpty(currencyAmountModel.MyBillsEntityDataFactory)) ? false : true;
    }
}

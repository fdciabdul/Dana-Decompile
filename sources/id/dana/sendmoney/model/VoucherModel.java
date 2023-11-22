package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.model.CurrencyAmountModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class VoucherModel implements Parcelable {
    public static final Parcelable.Creator<VoucherModel> CREATOR = new Parcelable.Creator<VoucherModel>() { // from class: id.dana.sendmoney.model.VoucherModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ VoucherModel createFromParcel(Parcel parcel) {
            return new VoucherModel(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ VoucherModel[] newArray(int i) {
            return new VoucherModel[i];
        }
    };
    public boolean BuiltInFictitiousFunctionClassFactory;
    public CurrencyAmountModel DatabaseTableConfigUtil;
    public long GetContactSyncConfig;
    public CurrencyAmountModel KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public List<CouponPayMethodInfoModel> NetworkUserEntityData$$ExternalSyntheticLambda0;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    public long NetworkUserEntityData$$ExternalSyntheticLambda2;
    public int PlaceComponentResult;
    public long getAuthRequestContext;
    public long getErrorConfigVersion;
    public String lookAheadTest;
    public String moveToNextValue;
    public long scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ VoucherModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public VoucherModel() {
    }

    private VoucherModel(Parcel parcel) {
        this.MyBillsEntityDataFactory = parcel.readString();
        this.lookAheadTest = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.DatabaseTableConfigUtil = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.moveToNextValue = parcel.readString();
        this.getAuthRequestContext = parcel.readLong();
        this.getErrorConfigVersion = parcel.readLong();
        this.GetContactSyncConfig = parcel.readLong();
        this.scheduleImpl = parcel.readLong();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = parcel.readLong();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.BuiltInFictitiousFunctionClassFactory = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.PlaceComponentResult = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = arrayList;
        parcel.readList(arrayList, CouponPayMethodInfoModel.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.lookAheadTest);
        parcel.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, i);
        parcel.writeParcelable(this.DatabaseTableConfigUtil, i);
        parcel.writeString(this.moveToNextValue);
        parcel.writeLong(this.getAuthRequestContext);
        parcel.writeLong(this.getErrorConfigVersion);
        parcel.writeLong(this.GetContactSyncConfig);
        parcel.writeLong(this.scheduleImpl);
        parcel.writeLong(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        parcel.writeValue(Boolean.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
        parcel.writeValue(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory));
        parcel.writeInt(this.PlaceComponentResult);
        parcel.writeList(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public final boolean PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean MyBillsEntityDataFactory(String str) {
        for (CouponPayMethodInfoModel couponPayMethodInfoModel : this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            if (couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory() && couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}

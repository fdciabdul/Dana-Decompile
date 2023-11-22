package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.model.CurrencyAmountModel;

/* loaded from: classes5.dex */
public class CouponPayMethodInfoModel implements Parcelable {
    public static final Parcelable.Creator<CouponPayMethodInfoModel> CREATOR = new Parcelable.Creator<CouponPayMethodInfoModel>() { // from class: id.dana.sendmoney.model.CouponPayMethodInfoModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CouponPayMethodInfoModel createFromParcel(Parcel parcel) {
            return new CouponPayMethodInfoModel(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CouponPayMethodInfoModel[] newArray(int i) {
            return new CouponPayMethodInfoModel[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public boolean PlaceComponentResult;
    public int getAuthRequestContext;
    public boolean getErrorConfigVersion;
    public CurrencyAmountModel lookAheadTest;
    private String scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ CouponPayMethodInfoModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public CouponPayMethodInfoModel() {
    }

    private CouponPayMethodInfoModel(Parcel parcel) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.scheduleImpl = parcel.readString();
        this.getErrorConfigVersion = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.PlaceComponentResult = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.lookAheadTest = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.getAuthRequestContext = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.scheduleImpl);
        parcel.writeValue(Boolean.valueOf(this.getErrorConfigVersion));
        parcel.writeValue(Boolean.valueOf(this.PlaceComponentResult));
        parcel.writeParcelable(this.lookAheadTest, i);
        parcel.writeInt(this.getAuthRequestContext);
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.getErrorConfigVersion;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }
}

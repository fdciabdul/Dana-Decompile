package id.dana.splitbill.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.model.CurrencyAmountModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class SplitBillModel implements Parcelable {
    public static final Parcelable.Creator<SplitBillModel> CREATOR = new Parcelable.Creator<SplitBillModel>() { // from class: id.dana.splitbill.model.SplitBillModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ SplitBillModel createFromParcel(Parcel parcel) {
            return new SplitBillModel(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SplitBillModel[] newArray(int i) {
            return new SplitBillModel[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public PayerModel KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public List<PayerModel> PlaceComponentResult;
    public int getAuthRequestContext;
    public PayerModel getErrorConfigVersion;
    public CurrencyAmountModel lookAheadTest;
    public String moveToNextValue;
    public String scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ SplitBillModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public SplitBillModel() {
    }

    private SplitBillModel(Parcel parcel) {
        this.PlaceComponentResult = new ArrayList();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.lookAheadTest = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.getAuthRequestContext = parcel.readInt();
        this.MyBillsEntityDataFactory = parcel.readInt();
        parcel.readTypedList(this.PlaceComponentResult, PayerModel.CREATOR);
        this.getErrorConfigVersion = (PayerModel) parcel.readParcelable(PayerModel.class.getClassLoader());
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (PayerModel) parcel.readParcelable(PayerModel.class.getClassLoader());
        this.scheduleImpl = parcel.readString();
        this.moveToNextValue = parcel.readString();
    }

    public final boolean PlaceComponentResult() {
        return this.getAuthRequestContext == this.MyBillsEntityDataFactory;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeParcelable(this.lookAheadTest, i);
        parcel.writeInt(this.getAuthRequestContext);
        parcel.writeInt(this.MyBillsEntityDataFactory);
        parcel.writeTypedList(this.PlaceComponentResult);
        parcel.writeParcelable(this.getErrorConfigVersion, i);
        parcel.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, i);
        parcel.writeString(this.scheduleImpl);
        parcel.writeString(this.moveToNextValue);
    }
}

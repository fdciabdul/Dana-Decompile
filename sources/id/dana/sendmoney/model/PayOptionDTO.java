package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.model.CurrencyAmountModel;

/* loaded from: classes5.dex */
public class PayOptionDTO implements Parcelable {
    public static final Parcelable.Creator<PayOptionDTO> CREATOR = new Parcelable.Creator<PayOptionDTO>() { // from class: id.dana.sendmoney.model.PayOptionDTO.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PayOptionDTO createFromParcel(Parcel parcel) {
            return new PayOptionDTO(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PayOptionDTO[] newArray(int i) {
            return new PayOptionDTO[i];
        }
    };
    public CurrencyAmountModel BuiltInFictitiousFunctionClassFactory;
    public String MyBillsEntityDataFactory;
    public String PlaceComponentResult;
    public CurrencyAmountModel getAuthRequestContext;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected PayOptionDTO(Parcel parcel) {
        this.MyBillsEntityDataFactory = parcel.readString();
        this.getAuthRequestContext = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.BuiltInFictitiousFunctionClassFactory = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.PlaceComponentResult = parcel.readString();
    }

    public PayOptionDTO() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeParcelable(this.getAuthRequestContext, i);
        parcel.writeParcelable(this.BuiltInFictitiousFunctionClassFactory, i);
        parcel.writeString(this.PlaceComponentResult);
    }
}

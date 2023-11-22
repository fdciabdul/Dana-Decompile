package id.dana.domain.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.payasset.model.PayMethodView;
import id.dana.domain.user.CurrencyAmount;

/* loaded from: classes4.dex */
public class PayOptionDTOResponse implements Parcelable {
    public static final Parcelable.Creator<PayOptionDTOResponse> CREATOR = new Parcelable.Creator<PayOptionDTOResponse>() { // from class: id.dana.domain.sendmoney.model.PayOptionDTOResponse.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PayOptionDTOResponse createFromParcel(Parcel parcel) {
            return new PayOptionDTOResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PayOptionDTOResponse[] newArray(int i) {
            return new PayOptionDTOResponse[i];
        }
    };
    private String fundType;
    private String payMethod;
    private boolean payMethodFlag;
    private PayMethodView payMethodView;
    private CurrencyAmount payeeMaxBalanceAmount;
    private CurrencyAmount payeeMaxMonthFundInAmount;
    private CurrencyAmount payeeMonthConsumedAmount;
    private CurrencyAmount payerMaxAmount;
    private CurrencyAmount payerMinAmount;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PayOptionDTOResponse() {
    }

    protected PayOptionDTOResponse(Parcel parcel) {
        this.fundType = parcel.readString();
        this.payMethod = parcel.readString();
        this.payMethodFlag = parcel.readByte() != 0;
        this.payMethodView = (PayMethodView) parcel.readParcelable(PayMethodView.class.getClassLoader());
        this.payerMaxAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.payerMinAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.payeeMaxBalanceAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.payeeMaxMonthFundInAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.payeeMonthConsumedAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
    }

    public boolean isPayMethodFlag() {
        return this.payMethodFlag;
    }

    public void setPayMethodFlag(boolean z) {
        this.payMethodFlag = z;
    }

    public String getFundType() {
        return this.fundType;
    }

    public void setFundType(String str) {
        this.fundType = str;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public CurrencyAmount getPayerMinAmount() {
        return this.payerMinAmount;
    }

    public void setPayerMinAmount(CurrencyAmount currencyAmount) {
        this.payerMinAmount = currencyAmount;
    }

    public CurrencyAmount getPayerMaxAmount() {
        return this.payerMaxAmount;
    }

    public void setPayerMaxAmount(CurrencyAmount currencyAmount) {
        this.payerMaxAmount = currencyAmount;
    }

    public PayMethodView getPayMethodView() {
        return this.payMethodView;
    }

    public void setPayMethodView(PayMethodView payMethodView) {
        this.payMethodView = payMethodView;
    }

    public CurrencyAmount getPayeeMaxBalanceAmount() {
        return this.payeeMaxBalanceAmount;
    }

    public void setPayeeMaxBalanceAmount(CurrencyAmount currencyAmount) {
        this.payeeMaxBalanceAmount = currencyAmount;
    }

    public CurrencyAmount getPayeeMaxMonthFundInAmount() {
        return this.payeeMaxMonthFundInAmount;
    }

    public void setPayeeMaxMonthFundInAmount(CurrencyAmount currencyAmount) {
        this.payeeMaxMonthFundInAmount = currencyAmount;
    }

    public CurrencyAmount getPayeeMonthConsumedAmount() {
        return this.payeeMonthConsumedAmount;
    }

    public void setPayeeMonthConsumedAmount(CurrencyAmount currencyAmount) {
        this.payeeMonthConsumedAmount = currencyAmount;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fundType);
        parcel.writeString(this.payMethod);
        parcel.writeByte(this.payMethodFlag ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.payMethodView, i);
        parcel.writeParcelable(this.payerMaxAmount, i);
        parcel.writeParcelable(this.payerMinAmount, i);
        parcel.writeParcelable(this.payeeMaxBalanceAmount, i);
        parcel.writeParcelable(this.payeeMaxMonthFundInAmount, i);
        parcel.writeParcelable(this.payeeMonthConsumedAmount, i);
    }
}

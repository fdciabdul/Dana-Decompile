package id.dana.domain.withdraw.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import id.dana.domain.user.CurrencyAmount;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class TransferMethodView implements Parcelable {
    public static final Parcelable.Creator<TransferMethodView> CREATOR = new Parcelable.Creator<TransferMethodView>() { // from class: id.dana.domain.withdraw.model.TransferMethodView.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TransferMethodView createFromParcel(Parcel parcel) {
            return new TransferMethodView(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TransferMethodView[] newArray(int i) {
            return new TransferMethodView[i];
        }
    };
    private CurrencyAmount chargeAmount;
    private CurrencyAmount freeFeeMinAmount;
    private long freeRemainedTimes;
    private long freeTimes;
    private List<PayOptionDTOResponse> payOptionDTOResponses;
    private CurrencyAmount payeeMaxBalanceAmount;
    private CurrencyAmount payeeMaxMonthFundInAmount;
    private CurrencyAmount payeeMonthConsumedAmount;
    private CurrencyAmount transferMaxAmount;
    private String transferMethod;
    private CurrencyAmount transferMinAmount;
    private List<WithdrawMethodOption> withdrawMethodOptions;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private TransferMethodView() {
    }

    protected TransferMethodView(Parcel parcel) {
        this.withdrawMethodOptions = new ArrayList();
        this.payOptionDTOResponses = new ArrayList();
        this.chargeAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.freeFeeMinAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.freeRemainedTimes = parcel.readLong();
        this.freeTimes = parcel.readLong();
        this.transferMethod = parcel.readString();
        this.transferMaxAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.transferMinAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.payeeMaxBalanceAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.payeeMaxMonthFundInAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.payeeMonthConsumedAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        parcel.readList(this.withdrawMethodOptions, WithdrawMethodOption.class.getClassLoader());
        parcel.readList(this.payOptionDTOResponses, PayOptionDTOResponse.class.getClassLoader());
    }

    public List<PayOptionDTOResponse> getPayOptionDTOResponses() {
        return this.payOptionDTOResponses;
    }

    public String getTransferMethod() {
        return this.transferMethod;
    }

    public CurrencyAmount getChargeAmount() {
        return this.chargeAmount;
    }

    public CurrencyAmount getFreeFeeMinAmount() {
        return this.freeFeeMinAmount;
    }

    public long getFreeRemainedTimes() {
        return this.freeRemainedTimes;
    }

    public long getFreeTimes() {
        return this.freeTimes;
    }

    public boolean isFreeTransferAvailable() {
        return this.freeRemainedTimes != 0;
    }

    public CurrencyAmount getTransferMaxAmount() {
        return this.transferMaxAmount;
    }

    public CurrencyAmount getTransferMinAmount() {
        return this.transferMinAmount;
    }

    public List<WithdrawMethodOption> getWithdrawMethodOptions() {
        return this.withdrawMethodOptions;
    }

    public CurrencyAmount getPayeeMaxBalanceAmount() {
        return this.payeeMaxBalanceAmount;
    }

    public CurrencyAmount getPayeeMaxMonthFundInAmount() {
        return this.payeeMaxMonthFundInAmount;
    }

    public CurrencyAmount getPayeeMonthConsumedAmount() {
        return this.payeeMonthConsumedAmount;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.chargeAmount, i);
        parcel.writeParcelable(this.freeFeeMinAmount, i);
        parcel.writeLong(this.freeRemainedTimes);
        parcel.writeLong(this.freeTimes);
        parcel.writeString(this.transferMethod);
        parcel.writeParcelable(this.transferMaxAmount, i);
        parcel.writeParcelable(this.transferMinAmount, i);
        parcel.writeParcelable(this.payeeMaxBalanceAmount, i);
        parcel.writeParcelable(this.payeeMaxMonthFundInAmount, i);
        parcel.writeParcelable(this.payeeMonthConsumedAmount, i);
        parcel.writeList(this.withdrawMethodOptions);
        parcel.writeList(this.payOptionDTOResponses);
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private CurrencyAmount chargeAmount;
        private CurrencyAmount freeMinAmount;
        private long freeRemainedTimes;
        private long freeTimes;
        private List<PayOptionDTOResponse> payOptionDTOResponses;
        private CurrencyAmount payeeMaxBalanceAmount;
        private CurrencyAmount payeeMaxMonthFundInAmount;
        private CurrencyAmount payeeMonthConsumedAmount;
        private CurrencyAmount transferMaxAmount;
        private String transferMethod;
        private CurrencyAmount transferMinAmount;
        private List<WithdrawMethodOption> withdrawMethodOptions;

        public Builder chargeAmount(CurrencyAmount currencyAmount) {
            this.chargeAmount = currencyAmount;
            return this;
        }

        public Builder freeMinAmount(CurrencyAmount currencyAmount) {
            this.freeMinAmount = currencyAmount;
            return this;
        }

        public Builder transferMethod(String str) {
            this.transferMethod = str;
            return this;
        }

        public Builder freeRemainedTimes(long j) {
            this.freeRemainedTimes = j;
            return this;
        }

        public Builder freeTimes(long j) {
            this.freeTimes = j;
            return this;
        }

        public Builder setPayOptionDTOResponses(List<PayOptionDTOResponse> list) {
            this.payOptionDTOResponses = list;
            return this;
        }

        public Builder withdrawMethodOptions(List<WithdrawMethodOption> list) {
            this.withdrawMethodOptions = list;
            return this;
        }

        public Builder setTransferMaxAmount(CurrencyAmount currencyAmount) {
            this.transferMaxAmount = currencyAmount;
            return this;
        }

        public Builder setTransferMinAmount(CurrencyAmount currencyAmount) {
            this.transferMinAmount = currencyAmount;
            return this;
        }

        public Builder setPayeeMaxBalanceAmount(CurrencyAmount currencyAmount) {
            this.payeeMaxBalanceAmount = currencyAmount;
            return this;
        }

        public Builder setPayeeMaxMonthFundInAmount(CurrencyAmount currencyAmount) {
            this.payeeMaxMonthFundInAmount = currencyAmount;
            return this;
        }

        public Builder setPayeeMonthConsumedAmount(CurrencyAmount currencyAmount) {
            this.payeeMonthConsumedAmount = currencyAmount;
            return this;
        }

        public TransferMethodView build() {
            TransferMethodView transferMethodView = new TransferMethodView();
            transferMethodView.chargeAmount = this.chargeAmount;
            transferMethodView.freeFeeMinAmount = this.freeMinAmount;
            transferMethodView.transferMethod = this.transferMethod;
            transferMethodView.freeRemainedTimes = this.freeRemainedTimes;
            transferMethodView.freeTimes = this.freeTimes;
            transferMethodView.withdrawMethodOptions = this.withdrawMethodOptions;
            transferMethodView.payOptionDTOResponses = this.payOptionDTOResponses;
            transferMethodView.transferMinAmount = this.transferMinAmount;
            transferMethodView.transferMaxAmount = this.transferMaxAmount;
            transferMethodView.payeeMaxBalanceAmount = this.payeeMaxBalanceAmount;
            transferMethodView.payeeMaxMonthFundInAmount = this.payeeMaxMonthFundInAmount;
            transferMethodView.payeeMonthConsumedAmount = this.payeeMonthConsumedAmount;
            return transferMethodView;
        }
    }
}

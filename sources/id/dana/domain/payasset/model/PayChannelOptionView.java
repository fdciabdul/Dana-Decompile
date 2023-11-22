package id.dana.domain.payasset.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.user.CurrencyAmount;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class PayChannelOptionView implements Parcelable {
    public static final Parcelable.Creator<PayChannelOptionView> CREATOR = new Parcelable.Creator<PayChannelOptionView>() { // from class: id.dana.domain.payasset.model.PayChannelOptionView.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PayChannelOptionView createFromParcel(Parcel parcel) {
            return new PayChannelOptionView(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PayChannelOptionView[] newArray(int i) {
            return new PayChannelOptionView[i];
        }
    };
    private AmountRange amountRange;
    private String bankCode;
    private String disableReason;
    private boolean enableStatus;
    private Map<String, String> extendInfo;
    private String instId;
    private String instLocalName;
    private String instName;
    private boolean interBank;
    private CurrencyAmount maxAmount;
    private CurrencyAmount minAmount;
    private String offlinePayIndex;
    private String payAccountNo;
    private String payMethod;
    private String payOption;
    private List<String> supportCountries;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PayChannelOptionView() {
    }

    protected PayChannelOptionView(Parcel parcel) {
        this.bankCode = parcel.readString();
        this.disableReason = parcel.readString();
        this.enableStatus = parcel.readByte() != 0;
        this.instId = parcel.readString();
        this.instName = parcel.readString();
        this.instLocalName = parcel.readString();
        this.interBank = parcel.readByte() != 0;
        this.offlinePayIndex = parcel.readString();
        this.payAccountNo = parcel.readString();
        this.payMethod = parcel.readString();
        this.payOption = parcel.readString();
        this.supportCountries = parcel.createStringArrayList();
    }

    public int hashCode() {
        int hashCode = getAmountRange() != null ? getAmountRange().hashCode() : 0;
        int hashCode2 = getBankCode() != null ? getBankCode().hashCode() : 0;
        int hashCode3 = getDisableReason() != null ? getDisableReason().hashCode() : 0;
        boolean isEnableStatus = isEnableStatus();
        int hashCode4 = getExtendInfo() != null ? getExtendInfo().hashCode() : 0;
        int hashCode5 = getInstId() != null ? getInstId().hashCode() : 0;
        int hashCode6 = getInstName() != null ? getInstName().hashCode() : 0;
        boolean isInterBank = isInterBank();
        int hashCode7 = getOfflinePayIndex() != null ? getOfflinePayIndex().hashCode() : 0;
        int hashCode8 = getPayAccountNo() != null ? getPayAccountNo().hashCode() : 0;
        int hashCode9 = getPayMethod() != null ? getPayMethod().hashCode() : 0;
        int hashCode10 = getPayOption() != null ? getPayOption().hashCode() : 0;
        int hashCode11 = getMinAmount() != null ? getMinAmount().hashCode() : 0;
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (isEnableStatus ? 1 : 0)) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (isInterBank ? 1 : 0)) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + (getMaxAmount() != null ? getMaxAmount().hashCode() : 0)) * 31) + (getSupportCountries() != null ? getSupportCountries().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayChannelOptionView) {
            PayChannelOptionView payChannelOptionView = (PayChannelOptionView) obj;
            if (isEnableStatus() == payChannelOptionView.isEnableStatus() && isInterBank() == payChannelOptionView.isInterBank()) {
                if (getAmountRange() == null ? payChannelOptionView.getAmountRange() == null : getAmountRange().equals(payChannelOptionView.getAmountRange())) {
                    if (getBankCode() == null ? payChannelOptionView.getBankCode() == null : getBankCode().equals(payChannelOptionView.getBankCode())) {
                        if (getDisableReason() == null ? payChannelOptionView.getDisableReason() == null : getDisableReason().equals(payChannelOptionView.getDisableReason())) {
                            if (getExtendInfo() == null ? payChannelOptionView.getExtendInfo() == null : getExtendInfo().equals(payChannelOptionView.getExtendInfo())) {
                                if (getInstId() == null ? payChannelOptionView.getInstId() == null : getInstId().equals(payChannelOptionView.getInstId())) {
                                    if (getInstName() == null ? payChannelOptionView.getInstName() == null : getInstName().equals(payChannelOptionView.getInstName())) {
                                        if (getOfflinePayIndex() == null ? payChannelOptionView.getOfflinePayIndex() == null : getOfflinePayIndex().equals(payChannelOptionView.getOfflinePayIndex())) {
                                            if (getPayAccountNo() == null ? payChannelOptionView.getPayAccountNo() == null : getPayAccountNo().equals(payChannelOptionView.getPayAccountNo())) {
                                                if (getPayMethod() == null ? payChannelOptionView.getPayMethod() == null : getPayMethod().equals(payChannelOptionView.getPayMethod())) {
                                                    if (getPayOption() == null ? payChannelOptionView.getPayOption() == null : getPayOption().equals(payChannelOptionView.getPayOption())) {
                                                        if (getMinAmount() == null ? payChannelOptionView.getMinAmount() == null : getMinAmount().equals(payChannelOptionView.getMinAmount())) {
                                                            if (getMaxAmount() == null ? payChannelOptionView.getMaxAmount() == null : getMaxAmount().equals(payChannelOptionView.getMaxAmount())) {
                                                                if (getSupportCountries() != null) {
                                                                    return getSupportCountries().equals(payChannelOptionView.getSupportCountries());
                                                                }
                                                                return payChannelOptionView.getSupportCountries() == null;
                                                            }
                                                            return false;
                                                        }
                                                        return false;
                                                    }
                                                    return false;
                                                }
                                                return false;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public AmountRange getAmountRange() {
        return this.amountRange;
    }

    public void setAmountRange(AmountRange amountRange) {
        this.amountRange = amountRange;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public String getDisableReason() {
        return this.disableReason;
    }

    public void setDisableReason(String str) {
        this.disableReason = str;
    }

    public boolean isEnableStatus() {
        return this.enableStatus;
    }

    public void setEnableStatus(boolean z) {
        this.enableStatus = z;
    }

    public Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(Map<String, String> map) {
        this.extendInfo = map;
    }

    public String getInstId() {
        return this.instId;
    }

    public void setInstId(String str) {
        this.instId = str;
    }

    public String getInstName() {
        return this.instName;
    }

    public void setInstName(String str) {
        this.instName = str;
    }

    public String getInstLocalName() {
        return this.instLocalName;
    }

    public void setInstLocalName(String str) {
        this.instLocalName = str;
    }

    public boolean isInterBank() {
        return this.interBank;
    }

    public void setInterBank(boolean z) {
        this.interBank = z;
    }

    public String getOfflinePayIndex() {
        return this.offlinePayIndex;
    }

    public void setOfflinePayIndex(String str) {
        this.offlinePayIndex = str;
    }

    public String getPayAccountNo() {
        return this.payAccountNo;
    }

    public void setPayAccountNo(String str) {
        this.payAccountNo = str;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getPayOption() {
        return this.payOption;
    }

    public void setPayOption(String str) {
        this.payOption = str;
    }

    public CurrencyAmount getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(CurrencyAmount currencyAmount) {
        this.minAmount = currencyAmount;
    }

    public CurrencyAmount getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(CurrencyAmount currencyAmount) {
        this.maxAmount = currencyAmount;
    }

    public List<String> getSupportCountries() {
        return this.supportCountries;
    }

    public void setSupportCountries(List<String> list) {
        this.supportCountries = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bankCode);
        parcel.writeString(this.disableReason);
        parcel.writeByte(this.enableStatus ? (byte) 1 : (byte) 0);
        parcel.writeString(this.instId);
        parcel.writeString(this.instName);
        parcel.writeString(this.instLocalName);
        parcel.writeByte(this.interBank ? (byte) 1 : (byte) 0);
        parcel.writeString(this.offlinePayIndex);
        parcel.writeString(this.payAccountNo);
        parcel.writeString(this.payMethod);
        parcel.writeString(this.payOption);
        parcel.writeStringList(this.supportCountries);
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private AmountRange amountRange;
        private String bankCode;
        private String disableReason;
        private boolean enableStatus;
        private Map<String, String> extendInfo;
        private String instId;
        private String instName;
        private boolean interBank;
        private CurrencyAmount maxAmount;
        private CurrencyAmount minAmount;
        private String offlinePayIndex;
        private String payAccountNo;
        private String payMethod;
        private String payOption;
        private List<String> supportCountries;

        public PayChannelOptionView build() {
            PayChannelOptionView payChannelOptionView = new PayChannelOptionView();
            payChannelOptionView.setAmountRange(getAmountRange());
            payChannelOptionView.setBankCode(getBankCode());
            payChannelOptionView.setDisableReason(getDisableReason());
            payChannelOptionView.setEnableStatus(isEnableStatus());
            payChannelOptionView.setExtendInfo(getExtendInfo());
            payChannelOptionView.setInstId(getInstId());
            payChannelOptionView.setInstName(getInstName());
            payChannelOptionView.setInterBank(isInterBank());
            payChannelOptionView.setOfflinePayIndex(getOfflinePayIndex());
            payChannelOptionView.setPayAccountNo(getPayAccountNo());
            payChannelOptionView.setPayMethod(getPayMethod());
            payChannelOptionView.setPayOption(getPayOption());
            payChannelOptionView.setMinAmount(getMinAmount());
            payChannelOptionView.setMaxAmount(getMaxAmount());
            payChannelOptionView.setSupportCountries(getSupportCountries());
            return payChannelOptionView;
        }

        public AmountRange getAmountRange() {
            return this.amountRange;
        }

        public Builder setAmountRange(AmountRange amountRange) {
            this.amountRange = amountRange;
            return this;
        }

        public String getBankCode() {
            return this.bankCode;
        }

        public Builder setBankCode(String str) {
            this.bankCode = str;
            return this;
        }

        public String getDisableReason() {
            return this.disableReason;
        }

        public Builder setDisableReason(String str) {
            this.disableReason = str;
            return this;
        }

        public boolean isEnableStatus() {
            return this.enableStatus;
        }

        public Builder setEnableStatus(boolean z) {
            this.enableStatus = z;
            return this;
        }

        public Map<String, String> getExtendInfo() {
            return this.extendInfo;
        }

        public Builder setExtendInfo(Map<String, String> map) {
            this.extendInfo = map;
            return this;
        }

        public String getInstId() {
            return this.instId;
        }

        public Builder setInstId(String str) {
            this.instId = str;
            return this;
        }

        public String getInstName() {
            return this.instName;
        }

        public Builder setInstName(String str) {
            this.instName = str;
            return this;
        }

        public boolean isInterBank() {
            return this.interBank;
        }

        public Builder setInterBank(boolean z) {
            this.interBank = z;
            return this;
        }

        public String getOfflinePayIndex() {
            return this.offlinePayIndex;
        }

        public Builder setOfflinePayIndex(String str) {
            this.offlinePayIndex = str;
            return this;
        }

        public String getPayAccountNo() {
            return this.payAccountNo;
        }

        public Builder setPayAccountNo(String str) {
            this.payAccountNo = str;
            return this;
        }

        public String getPayMethod() {
            return this.payMethod;
        }

        public Builder setPayMethod(String str) {
            this.payMethod = str;
            return this;
        }

        public String getPayOption() {
            return this.payOption;
        }

        public Builder setPayOption(String str) {
            this.payOption = str;
            return this;
        }

        public CurrencyAmount getMinAmount() {
            return this.minAmount;
        }

        public Builder setMinAmount(CurrencyAmount currencyAmount) {
            this.minAmount = currencyAmount;
            return this;
        }

        public CurrencyAmount getMaxAmount() {
            return this.maxAmount;
        }

        public Builder setMaxAmount(CurrencyAmount currencyAmount) {
            this.maxAmount = currencyAmount;
            return this;
        }

        public List<String> getSupportCountries() {
            return this.supportCountries;
        }

        public Builder setSupportCountries(List<String> list) {
            this.supportCountries = list;
            return this;
        }
    }
}

package id.dana.domain.payasset.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class PayCardOptionView implements Parcelable {
    public static final Parcelable.Creator<PayCardOptionView> CREATOR = new Parcelable.Creator<PayCardOptionView>() { // from class: id.dana.domain.payasset.model.PayCardOptionView.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PayCardOptionView createFromParcel(Parcel parcel) {
            return new PayCardOptionView(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PayCardOptionView[] newArray(int i) {
            return new PayCardOptionView[i];
        }
    };
    private String assetType;
    private String bindingId;
    private String cardBin;
    private String cardIndexNo;
    private int cardNoLength;
    private String cardScheme;
    private boolean defaultCard;
    private boolean enableStatus;
    private String expiryMonth;
    private String expiryYear;
    private Map<String, String> extendInfo;
    private Map<String, String> holderName;
    private String instId;
    private String instLocalName;
    private String instName;
    private String maskedCardNo;
    private String offlinePayIndex;
    private String payMethod;
    private String payOption;
    private List<String> payVerifyElements;
    private boolean payWithoutCVV;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PayCardOptionView() {
    }

    protected PayCardOptionView(Parcel parcel) {
        this.assetType = parcel.readString();
        this.bindingId = parcel.readString();
        this.cardBin = parcel.readString();
        this.cardIndexNo = parcel.readString();
        this.cardNoLength = parcel.readInt();
        this.cardScheme = parcel.readString();
        this.defaultCard = parcel.readByte() != 0;
        this.enableStatus = parcel.readByte() != 0;
        this.expiryMonth = parcel.readString();
        this.expiryYear = parcel.readString();
        this.instId = parcel.readString();
        this.instLocalName = parcel.readString();
        this.instName = parcel.readString();
        this.maskedCardNo = parcel.readString();
        this.offlinePayIndex = parcel.readString();
        this.payMethod = parcel.readString();
        this.payOption = parcel.readString();
        this.payVerifyElements = parcel.createStringArrayList();
        this.payWithoutCVV = parcel.readByte() != 0;
    }

    public int hashCode() {
        int hashCode = getAssetType() != null ? getAssetType().hashCode() : 0;
        int hashCode2 = getBindingId() != null ? getBindingId().hashCode() : 0;
        int hashCode3 = getCardBin() != null ? getCardBin().hashCode() : 0;
        int hashCode4 = getCardIndexNo() != null ? getCardIndexNo().hashCode() : 0;
        int cardNoLength = getCardNoLength();
        int hashCode5 = getCardScheme() != null ? getCardScheme().hashCode() : 0;
        boolean isDefaultCard = isDefaultCard();
        boolean isEnableStatus = isEnableStatus();
        int hashCode6 = getExpiryMonth() != null ? getExpiryMonth().hashCode() : 0;
        int hashCode7 = getExpiryYear() != null ? getExpiryYear().hashCode() : 0;
        int hashCode8 = getExtendInfo() != null ? getExtendInfo().hashCode() : 0;
        int hashCode9 = getHolderName() != null ? getHolderName().hashCode() : 0;
        int hashCode10 = getInstId() != null ? getInstId().hashCode() : 0;
        int hashCode11 = getInstName() != null ? getInstName().hashCode() : 0;
        int hashCode12 = getMaskedCardNo() != null ? getMaskedCardNo().hashCode() : 0;
        int hashCode13 = getOfflinePayIndex() != null ? getOfflinePayIndex().hashCode() : 0;
        int hashCode14 = getPayMethod() != null ? getPayMethod().hashCode() : 0;
        return (((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + cardNoLength) * 31) + hashCode5) * 31) + (isDefaultCard ? 1 : 0)) * 31) + (isEnableStatus ? 1 : 0)) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (getPayOption() != null ? getPayOption().hashCode() : 0)) * 31) + (getPayVerifyElements() != null ? getPayVerifyElements().hashCode() : 0)) * 31) + (isPayWithoutCVV() ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PayCardOptionView payCardOptionView = (PayCardOptionView) obj;
        if (getCardNoLength() == payCardOptionView.getCardNoLength() && isDefaultCard() == payCardOptionView.isDefaultCard() && isEnableStatus() == payCardOptionView.isEnableStatus() && isPayWithoutCVV() == payCardOptionView.isPayWithoutCVV()) {
            if (getAssetType() == null ? payCardOptionView.getAssetType() == null : getAssetType().equals(payCardOptionView.getAssetType())) {
                if (getBindingId() == null ? payCardOptionView.getBindingId() == null : getBindingId().equals(payCardOptionView.getBindingId())) {
                    if (getCardBin() == null ? payCardOptionView.getCardBin() == null : getCardBin().equals(payCardOptionView.getCardBin())) {
                        if (getCardIndexNo() == null ? payCardOptionView.getCardIndexNo() == null : getCardIndexNo().equals(payCardOptionView.getCardIndexNo())) {
                            if (getCardScheme() == null ? payCardOptionView.getCardScheme() == null : getCardScheme().equals(payCardOptionView.getCardScheme())) {
                                if (getExpiryMonth() == null ? payCardOptionView.getExpiryMonth() == null : getExpiryMonth().equals(payCardOptionView.getExpiryMonth())) {
                                    if (getExpiryYear() == null ? payCardOptionView.getExpiryYear() == null : getExpiryYear().equals(payCardOptionView.getExpiryYear())) {
                                        if (getExtendInfo() == null ? payCardOptionView.getExtendInfo() == null : getExtendInfo().equals(payCardOptionView.getExtendInfo())) {
                                            if (getHolderName() == null ? payCardOptionView.getHolderName() == null : getHolderName().equals(payCardOptionView.getHolderName())) {
                                                if (getInstId() == null ? payCardOptionView.getInstId() == null : getInstId().equals(payCardOptionView.getInstId())) {
                                                    if (getInstName() == null ? payCardOptionView.getInstName() == null : getInstName().equals(payCardOptionView.getInstName())) {
                                                        if (getMaskedCardNo() == null ? payCardOptionView.getMaskedCardNo() == null : getMaskedCardNo().equals(payCardOptionView.getMaskedCardNo())) {
                                                            if (getOfflinePayIndex() == null ? payCardOptionView.getOfflinePayIndex() == null : getOfflinePayIndex().equals(payCardOptionView.getOfflinePayIndex())) {
                                                                if (getPayMethod() == null ? payCardOptionView.getPayMethod() == null : getPayMethod().equals(payCardOptionView.getPayMethod())) {
                                                                    if (getPayOption() == null ? payCardOptionView.getPayOption() == null : getPayOption().equals(payCardOptionView.getPayOption())) {
                                                                        if (getPayVerifyElements() != null) {
                                                                            return getPayVerifyElements().equals(payCardOptionView.getPayVerifyElements());
                                                                        }
                                                                        return payCardOptionView.getPayVerifyElements() == null;
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
            return false;
        }
        return false;
    }

    public String getAssetType() {
        return this.assetType;
    }

    public void setAssetType(String str) {
        this.assetType = str;
    }

    public String getBindingId() {
        return this.bindingId;
    }

    public void setBindingId(String str) {
        this.bindingId = str;
    }

    public String getCardBin() {
        return this.cardBin;
    }

    public void setCardBin(String str) {
        this.cardBin = str;
    }

    public String getCardIndexNo() {
        return this.cardIndexNo;
    }

    public void setCardIndexNo(String str) {
        this.cardIndexNo = str;
    }

    public int getCardNoLength() {
        return this.cardNoLength;
    }

    public void setCardNoLength(int i) {
        this.cardNoLength = i;
    }

    public String getCardScheme() {
        return this.cardScheme;
    }

    public void setCardScheme(String str) {
        this.cardScheme = str;
    }

    public boolean isDefaultCard() {
        return this.defaultCard;
    }

    public void setDefaultCard(boolean z) {
        this.defaultCard = z;
    }

    public boolean isEnableStatus() {
        return this.enableStatus;
    }

    public void setEnableStatus(boolean z) {
        this.enableStatus = z;
    }

    public String getExpiryMonth() {
        return this.expiryMonth;
    }

    public void setExpiryMonth(String str) {
        this.expiryMonth = str;
    }

    public String getExpiryYear() {
        return this.expiryYear;
    }

    public void setExpiryYear(String str) {
        this.expiryYear = str;
    }

    public Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(Map<String, String> map) {
        this.extendInfo = map;
    }

    public Map<String, String> getHolderName() {
        return this.holderName;
    }

    public void setHolderName(Map<String, String> map) {
        this.holderName = map;
    }

    public String getInstId() {
        return this.instId;
    }

    public void setInstId(String str) {
        this.instId = str;
    }

    public String getInstLocalName() {
        return this.instLocalName;
    }

    public void setInstLocalName(String str) {
        this.instLocalName = str;
    }

    public String getInstName() {
        return this.instName;
    }

    public void setInstName(String str) {
        this.instName = str;
    }

    public String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    public void setMaskedCardNo(String str) {
        this.maskedCardNo = str;
    }

    public String getOfflinePayIndex() {
        return this.offlinePayIndex;
    }

    public void setOfflinePayIndex(String str) {
        this.offlinePayIndex = str;
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

    public List<String> getPayVerifyElements() {
        return this.payVerifyElements;
    }

    public void setPayVerifyElements(List<String> list) {
        this.payVerifyElements = list;
    }

    public boolean isPayWithoutCVV() {
        return this.payWithoutCVV;
    }

    public void setPayWithoutCVV(boolean z) {
        this.payWithoutCVV = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.assetType);
        parcel.writeString(this.bindingId);
        parcel.writeString(this.cardBin);
        parcel.writeString(this.cardIndexNo);
        parcel.writeInt(this.cardNoLength);
        parcel.writeString(this.cardScheme);
        parcel.writeByte(this.defaultCard ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enableStatus ? (byte) 1 : (byte) 0);
        parcel.writeString(this.expiryMonth);
        parcel.writeString(this.expiryYear);
        parcel.writeString(this.instId);
        parcel.writeString(this.instLocalName);
        parcel.writeString(this.instName);
        parcel.writeString(this.maskedCardNo);
        parcel.writeString(this.offlinePayIndex);
        parcel.writeString(this.payMethod);
        parcel.writeString(this.payOption);
        parcel.writeStringList(this.payVerifyElements);
        parcel.writeByte(this.payWithoutCVV ? (byte) 1 : (byte) 0);
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private String assetType;
        private String bindingId;
        private String cardBin;
        private String cardIndexNo;
        private int cardNoLength;
        private String cardScheme;
        private boolean defaultCard;
        private boolean enableStatus;
        private String expiryMonth;
        private String expiryYear;
        private Map<String, String> extendInfo;
        private Map<String, String> holderName;
        private String instId;
        private String instLocalName;
        private String instName;
        private String maskedCardNo;
        private String offlinePayIndex;
        private String payMethod;
        private String payOption;
        private List<String> payVerifyElements;
        private boolean payWithoutCVV;

        public Builder setInsLocalName(String str) {
            setInstLocalName(str);
            return this;
        }

        public PayCardOptionView build() {
            PayCardOptionView payCardOptionView = new PayCardOptionView();
            payCardOptionView.setAssetType(getAssetType());
            payCardOptionView.setBindingId(getBindingId());
            payCardOptionView.setCardBin(getCardBin());
            payCardOptionView.setCardIndexNo(getCardIndexNo());
            payCardOptionView.setCardNoLength(getCardNoLength());
            payCardOptionView.setCardScheme(getCardScheme());
            payCardOptionView.setDefaultCard(isDefaultCard());
            payCardOptionView.setEnableStatus(isEnableStatus());
            payCardOptionView.setExpiryMonth(getExpiryMonth());
            payCardOptionView.setExpiryYear(getExpiryYear());
            payCardOptionView.setExtendInfo(getExtendInfo());
            payCardOptionView.setHolderName(getHolderName());
            payCardOptionView.setInstId(getInstId());
            payCardOptionView.setInstName(getInstName());
            payCardOptionView.setMaskedCardNo(getMaskedCardNo());
            payCardOptionView.setOfflinePayIndex(getOfflinePayIndex());
            payCardOptionView.setPayMethod(getPayMethod());
            payCardOptionView.setPayOption(getPayOption());
            payCardOptionView.setPayVerifyElements(getPayVerifyElements());
            payCardOptionView.setPayWithoutCVV(isPayWithoutCVV());
            payCardOptionView.setInstLocalName(getInstLocalName());
            return payCardOptionView;
        }

        public String getAssetType() {
            return this.assetType;
        }

        public Builder setAssetType(String str) {
            this.assetType = str;
            return this;
        }

        public String getBindingId() {
            return this.bindingId;
        }

        public Builder setBindingId(String str) {
            this.bindingId = str;
            return this;
        }

        public String getCardBin() {
            return this.cardBin;
        }

        public Builder setCardBin(String str) {
            this.cardBin = str;
            return this;
        }

        public String getCardIndexNo() {
            return this.cardIndexNo;
        }

        public Builder setCardIndexNo(String str) {
            this.cardIndexNo = str;
            return this;
        }

        public int getCardNoLength() {
            return this.cardNoLength;
        }

        public Builder setCardNoLength(int i) {
            this.cardNoLength = i;
            return this;
        }

        public String getCardScheme() {
            return this.cardScheme;
        }

        public Builder setCardScheme(String str) {
            this.cardScheme = str;
            return this;
        }

        public boolean isDefaultCard() {
            return this.defaultCard;
        }

        public Builder setDefaultCard(boolean z) {
            this.defaultCard = z;
            return this;
        }

        public boolean isEnableStatus() {
            return this.enableStatus;
        }

        public Builder setEnableStatus(boolean z) {
            this.enableStatus = z;
            return this;
        }

        public String getExpiryMonth() {
            return this.expiryMonth;
        }

        public Builder setExpiryMonth(String str) {
            this.expiryMonth = str;
            return this;
        }

        public String getExpiryYear() {
            return this.expiryYear;
        }

        public Builder setExpiryYear(String str) {
            this.expiryYear = str;
            return this;
        }

        public Map<String, String> getExtendInfo() {
            return this.extendInfo;
        }

        public Builder setExtendInfo(Map<String, String> map) {
            this.extendInfo = map;
            return this;
        }

        public Map<String, String> getHolderName() {
            return this.holderName;
        }

        public Builder setHolderName(Map<String, String> map) {
            this.holderName = map;
            return this;
        }

        public String getInstId() {
            return this.instId;
        }

        public Builder setInstId(String str) {
            this.instId = str;
            return this;
        }

        public String getInstLocalName() {
            return this.instLocalName;
        }

        public void setInstLocalName(String str) {
            this.instLocalName = str;
        }

        public String getInstName() {
            return this.instName;
        }

        public Builder setInstName(String str) {
            this.instName = str;
            return this;
        }

        public String getMaskedCardNo() {
            return this.maskedCardNo;
        }

        public Builder setMaskedCardNo(String str) {
            this.maskedCardNo = str;
            return this;
        }

        public String getOfflinePayIndex() {
            return this.offlinePayIndex;
        }

        public Builder setOfflinePayIndex(String str) {
            this.offlinePayIndex = str;
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

        public List<String> getPayVerifyElements() {
            return this.payVerifyElements;
        }

        public Builder setPayVerifyElements(List<String> list) {
            this.payVerifyElements = list;
            return this;
        }

        public boolean isPayWithoutCVV() {
            return this.payWithoutCVV;
        }

        public Builder setPayWithoutCVV(boolean z) {
            this.payWithoutCVV = z;
            return this;
        }
    }
}

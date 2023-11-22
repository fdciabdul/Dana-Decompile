package id.dana.domain.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.withdraw.model.TransferMethodView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class TransferInit implements Parcelable {
    public static final Parcelable.Creator<TransferInit> CREATOR = new Parcelable.Creator<TransferInit>() { // from class: id.dana.domain.sendmoney.model.TransferInit.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TransferInit createFromParcel(Parcel parcel) {
            return new TransferInit(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TransferInit[] newArray(int i) {
            return new TransferInit[i];
        }
    };
    private boolean accountFrozen;
    private String kyc;
    private boolean needSenderName;
    private CurrencyAmount payeeAccountBalance;
    private String payeeAvatar;
    private String payeeMaskedNickname;
    private String payeeMaskedPhoneNumber;
    private CurrencyAmount payeeMaxTransferAmount;
    private String payeeUserId;
    private CurrencyAmount payerAccountBalance;
    private String payerMaskedNickname;
    private String payerMaskedPhoneNumber;
    private CurrencyAmount payerMaxAmount;
    private CurrencyAmount payerMinAmount;
    private String payerUserId;
    private QrisTcicoEntryPointInfo qrisTcicoEntryPointInfo;
    private List<TransferMethodView> transferMethod;
    private boolean userFrozen;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TransferInit() {
    }

    protected TransferInit(Parcel parcel) {
        this.transferMethod = new ArrayList();
        this.kyc = parcel.readString();
        this.needSenderName = parcel.readByte() != 0;
        this.payerAccountBalance = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.payeeAccountBalance = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.payerMaskedNickname = parcel.readString();
        this.payerMaskedPhoneNumber = parcel.readString();
        this.payerMaxAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.payerMinAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
        this.payerUserId = parcel.readString();
        this.payeeMaskedNickname = parcel.readString();
        this.payeeMaskedPhoneNumber = parcel.readString();
        this.payeeUserId = parcel.readString();
        this.payeeAvatar = parcel.readString();
        this.userFrozen = parcel.readByte() != 0;
        this.accountFrozen = parcel.readByte() != 0;
        parcel.readList(this.transferMethod, TransferMethodView.class.getClassLoader());
        this.qrisTcicoEntryPointInfo = (QrisTcicoEntryPointInfo) parcel.readParcelable(QrisTcicoEntryPointInfo.class.getClassLoader());
        this.payeeMaxTransferAmount = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
    }

    public List<TransferMethodView> getTransferMethod() {
        return this.transferMethod;
    }

    public void setTransferMethod(List<TransferMethodView> list) {
        this.transferMethod = list;
    }

    public boolean isNeedSenderName() {
        return this.needSenderName;
    }

    public void setNeedSenderName(boolean z) {
        this.needSenderName = z;
    }

    public String getKyc() {
        return this.kyc;
    }

    public void setKyc(String str) {
        this.kyc = str;
    }

    public CurrencyAmount getPayerAccountBalance() {
        return this.payerAccountBalance;
    }

    public void setPayerAccountBalance(CurrencyAmount currencyAmount) {
        this.payerAccountBalance = currencyAmount;
    }

    public CurrencyAmount getPayeeAccountBalance() {
        return this.payeeAccountBalance;
    }

    public String getPayerMaskedNickname() {
        return this.payerMaskedNickname;
    }

    public void setPayerMaskedNickname(String str) {
        this.payerMaskedNickname = str;
    }

    public String getPayerMaskedPhoneNumber() {
        return this.payerMaskedPhoneNumber;
    }

    public void setPayerMaskedPhoneNumber(String str) {
        this.payerMaskedPhoneNumber = str;
    }

    public CurrencyAmount getPayerMaxAmount() {
        return this.payerMaxAmount;
    }

    public void setPayerMaxAmount(CurrencyAmount currencyAmount) {
        this.payerMaxAmount = currencyAmount;
    }

    public CurrencyAmount getPayerMinAmount() {
        return this.payerMinAmount;
    }

    public void setPayerMinAmount(CurrencyAmount currencyAmount) {
        this.payerMinAmount = currencyAmount;
    }

    public String getPayerUserId() {
        return this.payerUserId;
    }

    public void setPayerUserId(String str) {
        this.payerUserId = str;
    }

    public String getPayeeMaskedNickname() {
        return this.payeeMaskedNickname;
    }

    public void setPayeeMaskedNickname(String str) {
        this.payeeMaskedNickname = str;
    }

    public String getPayeeMaskedPhoneNumber() {
        return this.payeeMaskedPhoneNumber;
    }

    public void setPayeeMaskedPhoneNumber(String str) {
        this.payeeMaskedPhoneNumber = str;
    }

    public String getPayeeUserId() {
        return this.payeeUserId;
    }

    public void setPayeeUserId(String str) {
        this.payeeUserId = str;
    }

    public String getPayeeAvatar() {
        return this.payeeAvatar;
    }

    public void setPayeeAvatar(String str) {
        this.payeeAvatar = str;
    }

    public boolean isDanaUser() {
        return !TextUtils.isEmpty(getPayeeUserId());
    }

    public QrisTcicoEntryPointInfo getQrisTcicoEntryPointInfo() {
        return this.qrisTcicoEntryPointInfo;
    }

    public void setQrisTcicoEntryPointInfo(QrisTcicoEntryPointInfo qrisTcicoEntryPointInfo) {
        this.qrisTcicoEntryPointInfo = qrisTcicoEntryPointInfo;
    }

    public boolean isUserFrozen() {
        return this.userFrozen;
    }

    public boolean isAccountFrozen() {
        return this.accountFrozen;
    }

    public CurrencyAmount getPayeeMaxTransferAmount() {
        return this.payeeMaxTransferAmount;
    }

    public void setPayeeMaxTransferAmount(CurrencyAmount currencyAmount) {
        this.payeeMaxTransferAmount = currencyAmount;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.kyc);
        parcel.writeByte(this.needSenderName ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.payerAccountBalance, i);
        parcel.writeParcelable(this.payeeAccountBalance, i);
        parcel.writeString(this.payerMaskedNickname);
        parcel.writeString(this.payerMaskedPhoneNumber);
        parcel.writeParcelable(this.payerMaxAmount, i);
        parcel.writeParcelable(this.payerMinAmount, i);
        parcel.writeString(this.payerUserId);
        parcel.writeString(this.payeeMaskedNickname);
        parcel.writeString(this.payeeMaskedPhoneNumber);
        parcel.writeString(this.payeeUserId);
        parcel.writeString(this.payeeAvatar);
        parcel.writeByte(this.userFrozen ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.accountFrozen ? (byte) 1 : (byte) 0);
        parcel.writeList(this.transferMethod);
        parcel.writeParcelable(this.qrisTcicoEntryPointInfo, i);
        parcel.writeParcelable(this.payeeMaxTransferAmount, i);
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private boolean accountFrozen;
        private String kyc;
        private boolean needSenderName;
        private CurrencyAmount payeeAccountBalance;
        private String payeeAvatar;
        private String payeeMaskedNickname;
        private String payeeMaskedPhoneNumber;
        private CurrencyAmount payeeMaxTransferAmount;
        private String payeeUserId;
        private CurrencyAmount payerAccountBalance;
        private String payerMaskedNickname;
        private String payerMaskedPhoneNumber;
        private CurrencyAmount payerMaxAmount;
        private CurrencyAmount payerMinAmount;
        private String payerUserId;
        private QrisTcicoEntryPointInfo qrisTcicoEntryPointInfo;
        private List<TransferMethodView> transferMethod;
        private boolean userFrozen;

        public Builder setKyc(String str) {
            this.kyc = str;
            return this;
        }

        public Builder setPayerMaskedNickname(String str) {
            this.payerMaskedNickname = str;
            return this;
        }

        public Builder setPayerMaskedPhoneNumber(String str) {
            this.payerMaskedPhoneNumber = str;
            return this;
        }

        public Builder setPayerUserId(String str) {
            this.payerUserId = str;
            return this;
        }

        public Builder setPayerAccountBalance(CurrencyAmount currencyAmount) {
            this.payerAccountBalance = currencyAmount;
            return this;
        }

        public Builder setPayerMaxAmount(CurrencyAmount currencyAmount) {
            this.payerMaxAmount = currencyAmount;
            return this;
        }

        public Builder setPayerMinAmount(CurrencyAmount currencyAmount) {
            this.payerMinAmount = currencyAmount;
            return this;
        }

        public Builder setNeedSenderName(boolean z) {
            this.needSenderName = z;
            return this;
        }

        public Builder setTransferMethod(List<TransferMethodView> list) {
            this.transferMethod = list;
            return this;
        }

        public Builder setPayeeMaskedNickname(String str) {
            this.payeeMaskedNickname = str;
            return this;
        }

        public Builder setPayeeMaskedPhoneNumber(String str) {
            this.payeeMaskedPhoneNumber = str;
            return this;
        }

        public Builder setPayeeUserId(String str) {
            this.payeeUserId = str;
            return this;
        }

        public Builder setPayeeAvatar(String str) {
            this.payeeAvatar = str;
            return this;
        }

        public Builder setqrisTcicoEntryPoint(QrisTcicoEntryPointInfo qrisTcicoEntryPointInfo) {
            this.qrisTcicoEntryPointInfo = qrisTcicoEntryPointInfo;
            return this;
        }

        public Builder setAccountFrozen(boolean z) {
            this.accountFrozen = z;
            return this;
        }

        public Builder setUserFrozen(boolean z) {
            this.userFrozen = z;
            return this;
        }

        public Builder setPayeeAccountBalance(CurrencyAmount currencyAmount) {
            this.payeeAccountBalance = currencyAmount;
            return this;
        }

        public Builder setPayeeMaxTransferAmount(CurrencyAmount currencyAmount) {
            this.payeeMaxTransferAmount = currencyAmount;
            return this;
        }

        public TransferInit build() {
            TransferInit transferInit = new TransferInit();
            transferInit.needSenderName = this.needSenderName;
            transferInit.transferMethod = this.transferMethod;
            transferInit.kyc = this.kyc;
            transferInit.payerMaskedNickname = this.payerMaskedNickname;
            transferInit.payerMaskedPhoneNumber = this.payerMaskedPhoneNumber;
            transferInit.payerUserId = this.payerUserId;
            transferInit.payerAccountBalance = this.payerAccountBalance;
            transferInit.payerMaxAmount = this.payerMaxAmount;
            transferInit.payerMinAmount = this.payerMinAmount;
            transferInit.payeeMaskedNickname = this.payeeMaskedNickname;
            transferInit.payeeMaskedPhoneNumber = this.payeeMaskedPhoneNumber;
            transferInit.payeeUserId = this.payeeUserId;
            transferInit.payeeAvatar = this.payeeAvatar;
            transferInit.qrisTcicoEntryPointInfo = this.qrisTcicoEntryPointInfo;
            transferInit.accountFrozen = this.accountFrozen;
            transferInit.userFrozen = this.userFrozen;
            transferInit.payeeAccountBalance = this.payeeAccountBalance;
            transferInit.payeeMaxTransferAmount = this.payeeMaxTransferAmount;
            return transferInit;
        }
    }
}

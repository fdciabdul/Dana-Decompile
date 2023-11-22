package id.dana.domain.sendmoney.model;

import id.dana.domain.homeinfo.KycResponse;
import id.dana.domain.user.CurrencyAmount;
import java.util.List;

/* loaded from: classes4.dex */
public class SendMoneyInit {
    private String avatarUrl;
    private KycResponse kyc;
    private List<PayOptionDTOResponse> payOptions;
    private String payeeMaskedNickname;
    private String payeeMaskedPhoneNumber;
    private String payeeUserId;
    private CurrencyAmount payerAccountBalance;
    private CurrencyAmount payerMaxAmount;
    private CurrencyAmount payerMinAmount;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public KycResponse getKyc() {
        return this.kyc;
    }

    public void setKyc(KycResponse kycResponse) {
        this.kyc = kycResponse;
    }

    public List<PayOptionDTOResponse> getPayOptions() {
        return this.payOptions;
    }

    public void setPayOptions(List<PayOptionDTOResponse> list) {
        this.payOptions = list;
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

    public CurrencyAmount getPayerAccountBalance() {
        return this.payerAccountBalance;
    }

    public String getCurrency() {
        CurrencyAmount currencyAmount = this.payerAccountBalance;
        return currencyAmount == null ? "" : currencyAmount.getCurrency();
    }

    public String getAmount() {
        CurrencyAmount currencyAmount = this.payerAccountBalance;
        return currencyAmount == null ? "" : currencyAmount.getAmount();
    }

    public void setPayerAccountBalance(CurrencyAmount currencyAmount) {
        this.payerAccountBalance = currencyAmount;
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

    /* loaded from: classes4.dex */
    public static class Builder {
        private String avatarUrl;
        private KycResponse kyc;
        private List<PayOptionDTOResponse> payOptions;
        private String payeeMaskedNickname;
        private String payeeMaskedPhoneNumber;
        private String payeeUserId;
        private CurrencyAmount payerAccountBalance;
        private CurrencyAmount payerMaxAmount;
        private CurrencyAmount payerMinAmount;

        public Builder setAvatarUrl(String str) {
            this.avatarUrl = str;
            return this;
        }

        public Builder setKyc(KycResponse kycResponse) {
            this.kyc = kycResponse;
            return this;
        }

        public Builder setPayOptions(List<PayOptionDTOResponse> list) {
            this.payOptions = list;
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

        public SendMoneyInit build() {
            SendMoneyInit sendMoneyInit = new SendMoneyInit();
            sendMoneyInit.avatarUrl = this.avatarUrl;
            sendMoneyInit.kyc = this.kyc;
            sendMoneyInit.payOptions = this.payOptions;
            sendMoneyInit.payeeMaskedNickname = this.payeeMaskedNickname;
            sendMoneyInit.payeeMaskedPhoneNumber = this.payeeMaskedPhoneNumber;
            sendMoneyInit.payeeUserId = this.payeeUserId;
            sendMoneyInit.payerAccountBalance = this.payerAccountBalance;
            sendMoneyInit.payerMaxAmount = this.payerMaxAmount;
            sendMoneyInit.payerMinAmount = this.payerMinAmount;
            return sendMoneyInit;
        }
    }
}

package id.dana.domain.sendmoney.model;

import id.dana.domain.model.cashier.PayMethodRisk;
import id.dana.domain.user.CurrencyAmount;

/* loaded from: classes8.dex */
public class WithdrawSubmit {
    private String cardCacheToken;
    private String formattedHolderName;
    private String formattedMaskedCardNo;
    private String fundOrderId;
    private String maskedPhoneNumber;
    private PayMethodRisk payMethodRiskResult;
    private String publicKey;
    private CurrencyAmount totalAmount;

    public String getCardCacheToken() {
        return this.cardCacheToken;
    }

    public void setCardCacheToken(String str) {
        this.cardCacheToken = str;
    }

    public String getFormattedHolderName() {
        return this.formattedHolderName;
    }

    public void setFormattedHolderName(String str) {
        this.formattedHolderName = str;
    }

    public String getFormattedMaskedCardNo() {
        return this.formattedMaskedCardNo;
    }

    public void setFormattedMaskedCardNo(String str) {
        this.formattedMaskedCardNo = str;
    }

    public String getFundOrderId() {
        return this.fundOrderId;
    }

    public void setFundOrderId(String str) {
        this.fundOrderId = str;
    }

    public String getMaskedPhoneNumber() {
        return this.maskedPhoneNumber;
    }

    public void setMaskedPhoneNumber(String str) {
        this.maskedPhoneNumber = str;
    }

    public PayMethodRisk getPayMethodRiskResult() {
        return this.payMethodRiskResult;
    }

    public void setPayMethodRiskResult(PayMethodRisk payMethodRisk) {
        this.payMethodRiskResult = payMethodRisk;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }

    public CurrencyAmount getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(CurrencyAmount currencyAmount) {
        this.totalAmount = currencyAmount;
    }
}

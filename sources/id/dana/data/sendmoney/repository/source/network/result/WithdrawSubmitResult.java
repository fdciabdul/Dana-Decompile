package id.dana.data.sendmoney.repository.source.network.result;

import id.dana.data.model.CurrencyAmountResult;
import id.dana.data.model.cashier.PayMethodRiskResult;
import id.dana.network.base.BaseRpcResultAphome;

/* loaded from: classes8.dex */
public class WithdrawSubmitResult extends BaseRpcResultAphome {
    private String cardCacheToken;
    private String formattedHolderName;
    private String formattedMaskedCardNo;
    private String fundOrderId;
    private String maskedPhoneNumber;
    private PayMethodRiskResult payMethodRiskResult;
    private SecurityContextResult securityContext;
    private CurrencyAmountResult totalAmount;

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

    public PayMethodRiskResult getPayMethodRiskResult() {
        return this.payMethodRiskResult;
    }

    public void setPayMethodRiskResult(PayMethodRiskResult payMethodRiskResult) {
        this.payMethodRiskResult = payMethodRiskResult;
    }

    public SecurityContextResult getSecurityContext() {
        return this.securityContext;
    }

    public void setSecurityContext(SecurityContextResult securityContextResult) {
        this.securityContext = securityContextResult;
    }

    public String getPublicKey() {
        SecurityContextResult securityContextResult = this.securityContext;
        return securityContextResult == null ? "" : securityContextResult.getPublicKey();
    }

    public CurrencyAmountResult getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(CurrencyAmountResult currencyAmountResult) {
        this.totalAmount = currencyAmountResult;
    }
}

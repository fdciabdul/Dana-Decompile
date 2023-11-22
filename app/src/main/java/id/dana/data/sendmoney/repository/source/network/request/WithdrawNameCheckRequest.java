package id.dana.data.sendmoney.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.domain.user.CurrencyAmount;

/* loaded from: classes4.dex */
public class WithdrawNameCheckRequest extends BaseRpcRequest {
    private String cardCredential;
    private String cardIndexNo;
    private String cardNo;
    private CurrencyAmount fundAmount;
    private String instId;
    @SerializedName("isSavedAccount")
    private boolean isSavedAccount;
    private boolean saveCard;
    private String savedAccountHolderName;
    private String senderName;
    private String withdrawInstLocalName;
    private String withdrawPayMethod;
    private String withdrawPayOption;

    public boolean isSavedAccount() {
        return this.isSavedAccount;
    }

    public void setSavedAccount(boolean z) {
        this.isSavedAccount = z;
    }

    public String getSavedAccountHolderName() {
        return this.savedAccountHolderName;
    }

    public void setSavedAccountHolderName(String str) {
        this.savedAccountHolderName = str;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public String getInstId() {
        return this.instId;
    }

    public void setInstId(String str) {
        this.instId = str;
    }

    public String getCardIndexNo() {
        return this.cardIndexNo;
    }

    public void setCardIndexNo(String str) {
        this.cardIndexNo = str;
    }

    public CurrencyAmount getFundAmount() {
        return this.fundAmount;
    }

    public void setFundAmount(CurrencyAmount currencyAmount) {
        this.fundAmount = currencyAmount;
    }

    public boolean isSaveCard() {
        return this.saveCard;
    }

    public void setSaveCard(boolean z) {
        this.saveCard = z;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public void setSenderName(String str) {
        this.senderName = str;
    }

    public String getWithdrawPayMethod() {
        return this.withdrawPayMethod;
    }

    public void setWithdrawPayMethod(String str) {
        this.withdrawPayMethod = str;
    }

    public String getWithdrawPayOption() {
        return this.withdrawPayOption;
    }

    public void setWithdrawPayOption(String str) {
        this.withdrawPayOption = str;
    }

    public String getWithdrawInstLocalName() {
        return this.withdrawInstLocalName;
    }

    public void setWithdrawInstLocalName(String str) {
        this.withdrawInstLocalName = str;
    }

    public String getCardCredential() {
        return this.cardCredential;
    }

    public void setCardCredential(String str) {
        this.cardCredential = str;
    }
}

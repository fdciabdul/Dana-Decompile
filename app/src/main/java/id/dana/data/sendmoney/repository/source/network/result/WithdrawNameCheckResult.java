package id.dana.data.sendmoney.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import id.dana.wallet_v3.constant.WalletConstant;

/* loaded from: classes4.dex */
public class WithdrawNameCheckResult extends BaseRpcResultAphome {
    @SerializedName(WalletConstant.CARD_INDEX_NO)
    private String cardIndexNo;
    @SerializedName("formattedHolderName")
    private String formattedHolderName;
    @SerializedName("formattedMaskedCardNo")
    private String formattedMaskedCardNo;
    @SerializedName("holderName")
    private CardHolderResult holderName;

    public String getCardIndexNo() {
        return this.cardIndexNo;
    }

    public void setCardIndexNo(String str) {
        this.cardIndexNo = str;
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

    public CardHolderResult getHolderName() {
        return this.holderName;
    }

    public void setHolderName(CardHolderResult cardHolderResult) {
        this.holderName = cardHolderResult;
    }
}

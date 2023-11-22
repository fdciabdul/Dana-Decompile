package id.dana.domain.sendmoney.model;

/* loaded from: classes4.dex */
public class WithdrawNameCheck {
    private String cardIndexNo;
    private String formattedHolderName;
    private String formattedMaskedCardNo;
    private CardHolder holderName;

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

    public CardHolder getHolderName() {
        return this.holderName;
    }

    public void setHolderName(CardHolder cardHolder) {
        this.holderName = cardHolder;
    }
}

package id.dana.domain.sendmoney.model;

import id.dana.domain.user.CurrencyAmount;

/* loaded from: classes4.dex */
public class CouponPayMethodInfo {
    private String bindingId;
    private String cardBin;
    private boolean eligible;
    private String payMethod;
    private String payOption;
    private int priority;
    private boolean recommended;
    private CurrencyAmount recommendedAmount;

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

    public String getCardBin() {
        return this.cardBin;
    }

    public void setCardBin(String str) {
        this.cardBin = str;
    }

    public String getBindingId() {
        return this.bindingId;
    }

    public void setBindingId(String str) {
        this.bindingId = str;
    }

    public boolean isRecommended() {
        return this.recommended;
    }

    public void setRecommended(boolean z) {
        this.recommended = z;
    }

    public boolean isEligible() {
        return this.eligible;
    }

    public void setEligible(boolean z) {
        this.eligible = z;
    }

    public CurrencyAmount getRecommendedAmount() {
        return this.recommendedAmount;
    }

    public void setRecommendedAmount(CurrencyAmount currencyAmount) {
        this.recommendedAmount = currencyAmount;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }
}

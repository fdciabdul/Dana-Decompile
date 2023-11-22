package id.dana.domain.sendmoney.model;

import id.dana.domain.user.CurrencyAmount;

/* loaded from: classes4.dex */
public class CouponDiscountInfo {
    private String content;
    private String discountOffRate;
    private String discountType;
    private CurrencyAmount maxDiscountAmount;

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getDiscountOffRate() {
        return this.discountOffRate;
    }

    public void setDiscountOffRate(String str) {
        this.discountOffRate = str;
    }

    public String getDiscountType() {
        return this.discountType;
    }

    public void setDiscountType(String str) {
        this.discountType = str;
    }

    public CurrencyAmount getMaxDiscountAmount() {
        return this.maxDiscountAmount;
    }

    public void setMaxDiscountAmount(CurrencyAmount currencyAmount) {
        this.maxDiscountAmount = currencyAmount;
    }
}

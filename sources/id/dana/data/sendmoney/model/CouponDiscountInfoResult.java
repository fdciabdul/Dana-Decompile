package id.dana.data.sendmoney.model;

import id.dana.data.model.CurrencyAmountResult;

/* loaded from: classes4.dex */
public class CouponDiscountInfoResult {
    private String content;
    private String discountOffRate;
    private String discountType;
    private CurrencyAmountResult maxDiscountAmount;

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

    public CurrencyAmountResult getMaxDiscountAmount() {
        return this.maxDiscountAmount;
    }

    public void setMaxDiscountAmount(CurrencyAmountResult currencyAmountResult) {
        this.maxDiscountAmount = currencyAmountResult;
    }
}

package id.dana.data.promoquest.repository.source.result;

import id.dana.data.model.CurrencyAmountResult;

/* loaded from: classes4.dex */
public class PrizeInfoEntityResult {
    private String prizeId;
    private CurrencyAmountResult prizeMoneyAmount;
    private String prizeType;
    private String voucherId;
    private String voucherName;

    public String getPrizeId() {
        return this.prizeId;
    }

    public void setPrizeId(String str) {
        this.prizeId = str;
    }

    public CurrencyAmountResult getPrizeMoneyAmount() {
        return this.prizeMoneyAmount;
    }

    public void setPrizeMoneyAmount(CurrencyAmountResult currencyAmountResult) {
        this.prizeMoneyAmount = currencyAmountResult;
    }

    public String getPrizeType() {
        return this.prizeType;
    }

    public void setPrizeType(String str) {
        this.prizeType = str;
    }

    public String getVoucherId() {
        return this.voucherId;
    }

    public void setVoucherId(String str) {
        this.voucherId = str;
    }

    public String getVoucherName() {
        return this.voucherName;
    }

    public void setVoucherName(String str) {
        this.voucherName = str;
    }
}

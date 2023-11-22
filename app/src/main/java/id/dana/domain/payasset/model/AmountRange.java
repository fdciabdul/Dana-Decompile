package id.dana.domain.payasset.model;

import id.dana.domain.user.CurrencyAmount;
import java.util.Objects;

/* loaded from: classes4.dex */
public class AmountRange {
    private CurrencyAmount maxAmount;
    private CurrencyAmount minAmount;

    public int hashCode() {
        CurrencyAmount currencyAmount = this.maxAmount;
        int hashCode = currencyAmount != null ? currencyAmount.hashCode() : 0;
        CurrencyAmount currencyAmount2 = this.minAmount;
        return (hashCode * 31) + (currencyAmount2 != null ? currencyAmount2.hashCode() : 0);
    }

    public CurrencyAmount getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(CurrencyAmount currencyAmount) {
        this.maxAmount = currencyAmount;
    }

    public CurrencyAmount getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(CurrencyAmount currencyAmount) {
        this.minAmount = currencyAmount;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AmountRange amountRange = (AmountRange) obj;
        if (Objects.equals(this.maxAmount, amountRange.maxAmount)) {
            return Objects.equals(this.minAmount, amountRange.minAmount);
        }
        return false;
    }
}

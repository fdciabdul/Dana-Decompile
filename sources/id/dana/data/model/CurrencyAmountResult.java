package id.dana.data.model;

import com.google.gson.annotations.SerializedName;
import id.dana.domain.user.CurrencyAmount;
import java.util.Objects;

/* loaded from: classes4.dex */
public class CurrencyAmountResult {
    @SerializedName("amount")
    private String amount;
    private String currency;
    private boolean placeholder = false;

    public static CurrencyAmountResult getDefault() {
        CurrencyAmountResult currencyAmountResult = new CurrencyAmountResult();
        currencyAmountResult.setAmount("0");
        currencyAmountResult.setCurrency("Rp.");
        currencyAmountResult.setPlaceholder(true);
        return currencyAmountResult;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public boolean isPlaceholder() {
        return this.placeholder;
    }

    public void setPlaceholder(boolean z) {
        this.placeholder = z;
    }

    public CurrencyAmount toCurrencyAmount() {
        CurrencyAmount currencyAmount = new CurrencyAmount();
        currencyAmount.setAmount(this.amount);
        currencyAmount.setCurrency(this.currency);
        currencyAmount.setPlaceholder(this.placeholder);
        return currencyAmount;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CurrencyAmountResult currencyAmountResult = (CurrencyAmountResult) obj;
        return this.placeholder == currencyAmountResult.placeholder && Objects.equals(this.amount, currencyAmountResult.amount) && Objects.equals(this.currency, currencyAmountResult.currency);
    }

    public int hashCode() {
        return Objects.hash(this.amount, this.currency, Boolean.valueOf(this.placeholder));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CurrencyAmountResult{amount='");
        sb.append(this.amount);
        sb.append('\'');
        sb.append(", currency='");
        sb.append(this.currency);
        sb.append('\'');
        sb.append(", placeholder=");
        sb.append(this.placeholder);
        sb.append('}');
        return sb.toString();
    }
}

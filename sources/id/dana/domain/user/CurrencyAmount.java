package id.dana.domain.user;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class CurrencyAmount implements Parcelable {
    public static final Parcelable.Creator<CurrencyAmount> CREATOR = new Parcelable.Creator<CurrencyAmount>() { // from class: id.dana.domain.user.CurrencyAmount.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CurrencyAmount createFromParcel(Parcel parcel) {
            return new CurrencyAmount(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CurrencyAmount[] newArray(int i) {
            return new CurrencyAmount[i];
        }
    };
    private String amount;
    private String currency;
    private boolean placeholder;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CurrencyAmount() {
    }

    public CurrencyAmount(String str, String str2) {
        this.amount = str;
        this.currency = str2;
        this.placeholder = false;
    }

    public CurrencyAmount(String str, String str2, boolean z) {
        this.amount = str;
        this.currency = str2;
        this.placeholder = z;
    }

    protected CurrencyAmount(Parcel parcel) {
        this.amount = parcel.readString();
        this.currency = parcel.readString();
        this.placeholder = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.amount);
        parcel.writeString(this.currency);
        parcel.writeByte(this.placeholder ? (byte) 1 : (byte) 0);
    }

    public int hashCode() {
        String str = this.amount;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.currency;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CurrencyAmount currencyAmount = (CurrencyAmount) obj;
        String str = this.amount;
        if (str == null ? currencyAmount.amount == null : str.equals(currencyAmount.amount)) {
            String str2 = this.currency;
            String str3 = currencyAmount.currency;
            return str2 != null ? str2.equals(str3) : str3 == null;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CurrencyAmount{amount='");
        sb.append(this.amount);
        sb.append('\'');
        sb.append(", currency='");
        sb.append(this.currency);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public boolean isLessThan(CurrencyAmount currencyAmount) {
        return this.currency.equals(currencyAmount.getCurrency()) && Long.parseLong(currencyAmount.getAmount()) < Long.parseLong(this.currency);
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public boolean isMoreThan(CurrencyAmount currencyAmount) {
        return this.currency.equals(currencyAmount.getCurrency()) && Long.parseLong(currencyAmount.getAmount()) > Long.parseLong(this.currency);
    }

    public boolean isPlaceholder() {
        return this.placeholder;
    }

    public void setPlaceholder(boolean z) {
        this.placeholder = z;
    }
}

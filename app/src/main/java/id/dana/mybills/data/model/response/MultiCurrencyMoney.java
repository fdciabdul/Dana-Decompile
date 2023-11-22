package id.dana.mybills.data.model.response;

import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b0\u00101J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004Jp\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\nR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b-\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b/\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/response/MultiCurrencyMoney;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "Ljava/util/Currency;", "component7", "()Ljava/util/Currency;", "component8", "amount", "cent", "centFactor", FirebaseAnalytics.Param.CURRENCY, AppsFlyerProperties.CURRENCY_CODE, "currencyValue", "currencyMoney", "value", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Currency;Ljava/lang/String;)Lid/dana/mybills/data/model/response/MultiCurrencyMoney;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "Ljava/lang/Long;", "getCent", "Ljava/lang/Integer;", "getCentFactor", "getCurrency", "getCurrencyCode", "Ljava/util/Currency;", "getCurrencyMoney", "getCurrencyValue", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Currency;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MultiCurrencyMoney implements Serializable {
    @SerializedName("amount")
    private final String amount;
    @SerializedName("cent")
    private final Long cent;
    @SerializedName("centFactor")
    private final Integer centFactor;
    @SerializedName(FirebaseAnalytics.Param.CURRENCY)
    private final String currency;
    @SerializedName(AppsFlyerProperties.CURRENCY_CODE)
    private final String currencyCode;
    @SerializedName("currencyMoney")
    private final Currency currencyMoney;
    @SerializedName("currencyValue")
    private final String currencyValue;
    @SerializedName("value")
    private final String value;

    public MultiCurrencyMoney() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component2  reason: from getter */
    public final Long getCent() {
        return this.cent;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getCentFactor() {
        return this.centFactor;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    /* renamed from: component6  reason: from getter */
    public final String getCurrencyValue() {
        return this.currencyValue;
    }

    /* renamed from: component7  reason: from getter */
    public final Currency getCurrencyMoney() {
        return this.currencyMoney;
    }

    /* renamed from: component8  reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final MultiCurrencyMoney copy(String amount, Long cent, Integer centFactor, String currency, String currencyCode, String currencyValue, Currency currencyMoney, String value) {
        return new MultiCurrencyMoney(amount, cent, centFactor, currency, currencyCode, currencyValue, currencyMoney, value);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MultiCurrencyMoney) {
            MultiCurrencyMoney multiCurrencyMoney = (MultiCurrencyMoney) other;
            return Intrinsics.areEqual(this.amount, multiCurrencyMoney.amount) && Intrinsics.areEqual(this.cent, multiCurrencyMoney.cent) && Intrinsics.areEqual(this.centFactor, multiCurrencyMoney.centFactor) && Intrinsics.areEqual(this.currency, multiCurrencyMoney.currency) && Intrinsics.areEqual(this.currencyCode, multiCurrencyMoney.currencyCode) && Intrinsics.areEqual(this.currencyValue, multiCurrencyMoney.currencyValue) && Intrinsics.areEqual(this.currencyMoney, multiCurrencyMoney.currencyMoney) && Intrinsics.areEqual(this.value, multiCurrencyMoney.value);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.amount;
        int hashCode = str == null ? 0 : str.hashCode();
        Long l = this.cent;
        int hashCode2 = l == null ? 0 : l.hashCode();
        Integer num = this.centFactor;
        int hashCode3 = num == null ? 0 : num.hashCode();
        String str2 = this.currency;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.currencyCode;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.currencyValue;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        Currency currency = this.currencyMoney;
        int hashCode7 = currency == null ? 0 : currency.hashCode();
        String str5 = this.value;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiCurrencyMoney(amount=");
        sb.append(this.amount);
        sb.append(", cent=");
        sb.append(this.cent);
        sb.append(", centFactor=");
        sb.append(this.centFactor);
        sb.append(", currency=");
        sb.append(this.currency);
        sb.append(", currencyCode=");
        sb.append(this.currencyCode);
        sb.append(", currencyValue=");
        sb.append(this.currencyValue);
        sb.append(", currencyMoney=");
        sb.append(this.currencyMoney);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(')');
        return sb.toString();
    }

    public MultiCurrencyMoney(String str, Long l, Integer num, String str2, String str3, String str4, Currency currency, String str5) {
        this.amount = str;
        this.cent = l;
        this.centFactor = num;
        this.currency = str2;
        this.currencyCode = str3;
        this.currencyValue = str4;
        this.currencyMoney = currency;
        this.value = str5;
    }

    public /* synthetic */ MultiCurrencyMoney(String str, Long l, Integer num, String str2, String str3, String str4, Currency currency, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : num, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : currency, (i & 128) == 0 ? str5 : null);
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getCent")
    public final Long getCent() {
        return this.cent;
    }

    @JvmName(name = "getCentFactor")
    public final Integer getCentFactor() {
        return this.centFactor;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }

    @JvmName(name = "getCurrencyCode")
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    @JvmName(name = "getCurrencyValue")
    public final String getCurrencyValue() {
        return this.currencyValue;
    }

    @JvmName(name = "getCurrencyMoney")
    public final Currency getCurrencyMoney() {
        return this.currencyMoney;
    }

    @JvmName(name = "getValue")
    public final String getValue() {
        return this.value;
    }
}

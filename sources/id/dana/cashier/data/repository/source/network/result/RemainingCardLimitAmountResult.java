package id.dana.cashier.data.repository.source.network.result;

import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJX\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\tR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b\"\u0010\tR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b#\u0010\t"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/RemainingCardLimitAmountResult;", "", "", "component1", "()Ljava/lang/Long;", "component2", "component3", "", "component4", "()Ljava/lang/String;", "component5", "component6", "amount", "cent", "centFactor", FirebaseAnalytics.Param.CURRENCY, AppsFlyerProperties.CURRENCY_CODE, "currencyValue", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/result/RemainingCardLimitAmountResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Long;", "getAmount", "getCent", "getCentFactor", "Ljava/lang/String;", "getCurrency", "getCurrencyCode", "getCurrencyValue", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RemainingCardLimitAmountResult {
    @SerializedName("amount")
    private final Long amount;
    private final Long cent;
    private final Long centFactor;
    private final String currency;
    private final String currencyCode;
    private final String currencyValue;

    public RemainingCardLimitAmountResult() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ RemainingCardLimitAmountResult copy$default(RemainingCardLimitAmountResult remainingCardLimitAmountResult, Long l, Long l2, Long l3, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            l = remainingCardLimitAmountResult.amount;
        }
        if ((i & 2) != 0) {
            l2 = remainingCardLimitAmountResult.cent;
        }
        Long l4 = l2;
        if ((i & 4) != 0) {
            l3 = remainingCardLimitAmountResult.centFactor;
        }
        Long l5 = l3;
        if ((i & 8) != 0) {
            str = remainingCardLimitAmountResult.currency;
        }
        String str4 = str;
        if ((i & 16) != 0) {
            str2 = remainingCardLimitAmountResult.currencyCode;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = remainingCardLimitAmountResult.currencyValue;
        }
        return remainingCardLimitAmountResult.copy(l, l4, l5, str4, str5, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final Long getAmount() {
        return this.amount;
    }

    /* renamed from: component2  reason: from getter */
    public final Long getCent() {
        return this.cent;
    }

    /* renamed from: component3  reason: from getter */
    public final Long getCentFactor() {
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

    public final RemainingCardLimitAmountResult copy(Long amount, Long cent, Long centFactor, String currency, String currencyCode, String currencyValue) {
        return new RemainingCardLimitAmountResult(amount, cent, centFactor, currency, currencyCode, currencyValue);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RemainingCardLimitAmountResult) {
            RemainingCardLimitAmountResult remainingCardLimitAmountResult = (RemainingCardLimitAmountResult) other;
            return Intrinsics.areEqual(this.amount, remainingCardLimitAmountResult.amount) && Intrinsics.areEqual(this.cent, remainingCardLimitAmountResult.cent) && Intrinsics.areEqual(this.centFactor, remainingCardLimitAmountResult.centFactor) && Intrinsics.areEqual(this.currency, remainingCardLimitAmountResult.currency) && Intrinsics.areEqual(this.currencyCode, remainingCardLimitAmountResult.currencyCode) && Intrinsics.areEqual(this.currencyValue, remainingCardLimitAmountResult.currencyValue);
        }
        return false;
    }

    public final int hashCode() {
        Long l = this.amount;
        int hashCode = l == null ? 0 : l.hashCode();
        Long l2 = this.cent;
        int hashCode2 = l2 == null ? 0 : l2.hashCode();
        Long l3 = this.centFactor;
        int hashCode3 = l3 == null ? 0 : l3.hashCode();
        String str = this.currency;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.currencyCode;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.currencyValue;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RemainingCardLimitAmountResult(amount=");
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
        sb.append(')');
        return sb.toString();
    }

    public RemainingCardLimitAmountResult(Long l, Long l2, Long l3, String str, String str2, String str3) {
        this.amount = l;
        this.cent = l2;
        this.centFactor = l3;
        this.currency = str;
        this.currencyCode = str2;
        this.currencyValue = str3;
    }

    public /* synthetic */ RemainingCardLimitAmountResult(Long l, Long l2, Long l3, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3);
    }

    @JvmName(name = "getAmount")
    public final Long getAmount() {
        return this.amount;
    }

    @JvmName(name = "getCent")
    public final Long getCent() {
        return this.cent;
    }

    @JvmName(name = "getCentFactor")
    public final Long getCentFactor() {
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
}

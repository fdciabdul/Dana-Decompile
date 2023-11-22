package id.dana.cashier.data.repository.source.network.result;

import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/OriginAmountResult;", "", "", "amount", "Ljava/lang/Double;", "getAmount", "()Ljava/lang/Double;", "", "cent", "Ljava/lang/Long;", "getCent", "()Ljava/lang/Long;", "centFactor", "getCentFactor", "", FirebaseAnalytics.Param.CURRENCY, "Ljava/lang/String;", "getCurrency", "()Ljava/lang/String;", AppsFlyerProperties.CURRENCY_CODE, "getCurrencyCode", "currencyValue", "getCurrencyValue", "<init>", "(Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OriginAmountResult {
    private final Double amount;
    private final Long cent;
    private final Long centFactor;
    private final String currency;
    private final String currencyCode;
    private final String currencyValue;

    public OriginAmountResult(Double d, Long l, Long l2, String str, String str2, String str3) {
        this.amount = d;
        this.cent = l;
        this.centFactor = l2;
        this.currency = str;
        this.currencyCode = str2;
        this.currencyValue = str3;
    }

    @JvmName(name = "getAmount")
    public final Double getAmount() {
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

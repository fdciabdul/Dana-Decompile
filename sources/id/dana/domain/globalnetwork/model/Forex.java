package id.dana.domain.globalnetwork.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00010B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010#R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010 \u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010#R\"\u0010\u000e\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010&\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010)R\"\u0010\u000f\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010*\u001a\u0004\b+\u0010\u000b\"\u0004\b,\u0010-"}, d2 = {"Lid/dana/domain/globalnetwork/model/Forex;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()D", "", "component4", "()J", "amount", FirebaseAnalytics.Param.CURRENCY, "rate", "time", "copy", "(Ljava/lang/String;Ljava/lang/String;DJ)Lid/dana/domain/globalnetwork/model/Forex;", "other", "", "equals", "(Ljava/lang/Object;)Z", "getCurrencySymbol", "getForexAmount", "getRoundedRate", "", "hashCode", "()I", "isAmountLessThanOne", "()Z", "shouldRefreshForex", "toString", "Ljava/lang/String;", "getAmount", "setAmount", "(Ljava/lang/String;)V", "getCurrency", "setCurrency", SummaryActivity.DAYS, "getRate", "setRate", "(D)V", "J", "getTime", "setTime", "(J)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;DJ)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Forex {
    public static final String CURRENCY_PATTERN = "###,###,###";
    public static final String DEFAULT_AMOUNT = "0";
    public static final String DEFAULT_CURRENCY = "Rp";
    public static final double DEFAULT_RATE = 1.0d;
    public static final long HOURS_TO_REFRESH = 24;
    private String amount;
    private String currency;
    private double rate;
    private long time;

    public Forex() {
        this(null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0L, 15, null);
    }

    public static /* synthetic */ Forex copy$default(Forex forex, String str, String str2, double d, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = forex.amount;
        }
        if ((i & 2) != 0) {
            str2 = forex.currency;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            d = forex.rate;
        }
        double d2 = d;
        if ((i & 8) != 0) {
            j = forex.time;
        }
        return forex.copy(str, str3, d2, j);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: component3  reason: from getter */
    public final double getRate() {
        return this.rate;
    }

    /* renamed from: component4  reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public final Forex copy(String amount, String currency, double rate, long time) {
        Intrinsics.checkNotNullParameter(amount, "");
        Intrinsics.checkNotNullParameter(currency, "");
        return new Forex(amount, currency, rate, time);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Forex) {
            Forex forex = (Forex) other;
            return Intrinsics.areEqual(this.amount, forex.amount) && Intrinsics.areEqual(this.currency, forex.currency) && Intrinsics.areEqual((Object) Double.valueOf(this.rate), (Object) Double.valueOf(forex.rate)) && this.time == forex.time;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.amount.hashCode() * 31) + this.currency.hashCode()) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.rate)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.time);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Forex(amount=");
        sb.append(this.amount);
        sb.append(", currency=");
        sb.append(this.currency);
        sb.append(", rate=");
        sb.append(this.rate);
        sb.append(", time=");
        sb.append(this.time);
        sb.append(')');
        return sb.toString();
    }

    public Forex(String str, String str2, double d, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.amount = str;
        this.currency = str2;
        this.rate = d;
        this.time = j;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "setAmount")
    public final void setAmount(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.amount = str;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }

    @JvmName(name = "setCurrency")
    public final void setCurrency(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.currency = str;
    }

    @JvmName(name = "getRate")
    public final double getRate() {
        return this.rate;
    }

    @JvmName(name = "setRate")
    public final void setRate(double d) {
        this.rate = d;
    }

    public /* synthetic */ Forex(String str, String str2, double d, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "0" : str, (i & 2) != 0 ? "Rp" : str2, (i & 4) != 0 ? 1.0d : d, (i & 8) != 0 ? Calendar.getInstance().getTimeInMillis() : j);
    }

    @JvmName(name = "getTime")
    public final long getTime() {
        return this.time;
    }

    @JvmName(name = "setTime")
    public final void setTime(long j) {
        this.time = j;
    }

    public final boolean isAmountLessThanOne() {
        return !(this.amount.length() > 0) || Long.parseLong(this.amount) < 1;
    }

    public final boolean shouldRefreshForex() {
        return TimeUnit.MILLISECONDS.toHours(Calendar.getInstance().getTimeInMillis() - this.time) >= 24;
    }

    public final String getRoundedRate() {
        String plainString = new BigDecimal(this.rate).setScale(0, RoundingMode.HALF_EVEN).toPlainString();
        Intrinsics.checkNotNullExpressionValue(plainString, "");
        return plainString;
    }

    public final String getForexAmount() {
        if (!(this.amount.length() == 0)) {
            if (!(this.rate == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                String format = new DecimalFormat(CURRENCY_PATTERN).format(Double.parseDouble(this.amount) / this.rate);
                Intrinsics.checkNotNullExpressionValue(format, "");
                return StringsKt.replace$default(format, ',', '.', false, 4, (Object) null);
            }
        }
        return "0";
    }

    public final String getCurrencySymbol() {
        String symbol = Currency.getInstance(this.currency).getSymbol(Locale.ENGLISH);
        Intrinsics.checkNotNullExpressionValue(symbol, "");
        return symbol;
    }
}

package id.dana.explore.data.sku.repository.source.network.request;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/request/Denom;", "", "", "component1", "()D", "", "component2", "()Ljava/lang/String;", "amount", FirebaseAnalytics.Param.CURRENCY, "copy", "(DLjava/lang/String;)Lid/dana/explore/data/sku/repository/source/network/request/Denom;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", SummaryActivity.DAYS, "getAmount", "Ljava/lang/String;", "getCurrency", "<init>", "(DLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Denom {
    @SerializedName("amount")
    private final double amount;
    @SerializedName(FirebaseAnalytics.Param.CURRENCY)
    private final String currency;

    public static /* synthetic */ Denom copy$default(Denom denom, double d, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            d = denom.amount;
        }
        if ((i & 2) != 0) {
            str = denom.currency;
        }
        return denom.copy(d, str);
    }

    /* renamed from: component1  reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public final Denom copy(double amount, String currency) {
        Intrinsics.checkNotNullParameter(currency, "");
        return new Denom(amount, currency);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Denom) {
            Denom denom = (Denom) other;
            return Intrinsics.areEqual((Object) Double.valueOf(this.amount), (Object) Double.valueOf(denom.amount)) && Intrinsics.areEqual(this.currency, denom.currency);
        }
        return false;
    }

    public final int hashCode() {
        return (BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.amount) * 31) + this.currency.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Denom(amount=");
        sb.append(this.amount);
        sb.append(", currency=");
        sb.append(this.currency);
        sb.append(')');
        return sb.toString();
    }

    public Denom(double d, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.amount = d;
        this.currency = str;
    }

    @JvmName(name = "getAmount")
    public final double getAmount() {
        return this.amount;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }
}

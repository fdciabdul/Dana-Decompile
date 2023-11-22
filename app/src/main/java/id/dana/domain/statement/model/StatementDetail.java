package id.dana.domain.statement.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.domain.user.CurrencyAmount;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/domain/statement/model/StatementDetail;", "", "", "component1", "()J", "Lid/dana/domain/user/CurrencyAmount;", "component2", "()Lid/dana/domain/user/CurrencyAmount;", MaintenanceBroadcastResult.KEY_DATE, "amount", "copy", "(JLid/dana/domain/user/CurrencyAmount;)Lid/dana/domain/statement/model/StatementDetail;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/user/CurrencyAmount;", "getAmount", "J", "getDate", "<init>", "(JLid/dana/domain/user/CurrencyAmount;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class StatementDetail {
    private final CurrencyAmount amount;
    private final long date;

    public static /* synthetic */ StatementDetail copy$default(StatementDetail statementDetail, long j, CurrencyAmount currencyAmount, int i, Object obj) {
        if ((i & 1) != 0) {
            j = statementDetail.date;
        }
        if ((i & 2) != 0) {
            currencyAmount = statementDetail.amount;
        }
        return statementDetail.copy(j, currencyAmount);
    }

    /* renamed from: component1  reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: component2  reason: from getter */
    public final CurrencyAmount getAmount() {
        return this.amount;
    }

    public final StatementDetail copy(long date, CurrencyAmount amount) {
        Intrinsics.checkNotNullParameter(amount, "");
        return new StatementDetail(date, amount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof StatementDetail) {
            StatementDetail statementDetail = (StatementDetail) other;
            return this.date == statementDetail.date && Intrinsics.areEqual(this.amount, statementDetail.amount);
        }
        return false;
    }

    public final int hashCode() {
        return (Cbor$Arg$$ExternalSyntheticBackport0.m(this.date) * 31) + this.amount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatementDetail(date=");
        sb.append(this.date);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(')');
        return sb.toString();
    }

    public StatementDetail(long j, CurrencyAmount currencyAmount) {
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        this.date = j;
        this.amount = currencyAmount;
    }

    @JvmName(name = "getDate")
    public final long getDate() {
        return this.date;
    }

    @JvmName(name = "getAmount")
    public final CurrencyAmount getAmount() {
        return this.amount;
    }
}

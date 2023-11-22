package id.dana.domain.statement.model;

import id.dana.domain.user.CurrencyAmount;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0007"}, d2 = {"Lid/dana/domain/statement/model/StatementSummary;", "", "Lid/dana/domain/user/CurrencyAmount;", "component1", "()Lid/dana/domain/user/CurrencyAmount;", "", "component2", "()Ljava/lang/String;", "component3", "amount", "bizType", "description", "copy", "(Lid/dana/domain/user/CurrencyAmount;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/statement/model/StatementSummary;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/user/CurrencyAmount;", "getAmount", "Ljava/lang/String;", "getBizType", "getDescription", "<init>", "(Lid/dana/domain/user/CurrencyAmount;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class StatementSummary {
    private final CurrencyAmount amount;
    private final String bizType;
    private final String description;

    public static /* synthetic */ StatementSummary copy$default(StatementSummary statementSummary, CurrencyAmount currencyAmount, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            currencyAmount = statementSummary.amount;
        }
        if ((i & 2) != 0) {
            str = statementSummary.bizType;
        }
        if ((i & 4) != 0) {
            str2 = statementSummary.description;
        }
        return statementSummary.copy(currencyAmount, str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final CurrencyAmount getAmount() {
        return this.amount;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final StatementSummary copy(CurrencyAmount amount, String bizType, String description) {
        Intrinsics.checkNotNullParameter(amount, "");
        Intrinsics.checkNotNullParameter(bizType, "");
        Intrinsics.checkNotNullParameter(description, "");
        return new StatementSummary(amount, bizType, description);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof StatementSummary) {
            StatementSummary statementSummary = (StatementSummary) other;
            return Intrinsics.areEqual(this.amount, statementSummary.amount) && Intrinsics.areEqual(this.bizType, statementSummary.bizType) && Intrinsics.areEqual(this.description, statementSummary.description);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.amount.hashCode() * 31) + this.bizType.hashCode()) * 31) + this.description.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatementSummary(amount=");
        sb.append(this.amount);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(')');
        return sb.toString();
    }

    public StatementSummary(CurrencyAmount currencyAmount, String str, String str2) {
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.amount = currencyAmount;
        this.bizType = str;
        this.description = str2;
    }

    @JvmName(name = "getAmount")
    public final CurrencyAmount getAmount() {
        return this.amount;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }
}

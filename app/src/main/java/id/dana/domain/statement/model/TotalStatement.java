package id.dana.domain.statement.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.domain.statement.StatementType;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007R\u0017\u0010\n\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/statement/model/TotalStatement;", "", "Lid/dana/domain/statement/StatementType;", "component1", "()Lid/dana/domain/statement/StatementType;", "", "component2", "()Ljava/lang/String;", "component3", "type", "amount", FirebaseAnalytics.Param.CURRENCY, "copy", "(Lid/dana/domain/statement/StatementType;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/statement/model/TotalStatement;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "getCurrency", "Lid/dana/domain/statement/StatementType;", "getType", "<init>", "(Lid/dana/domain/statement/StatementType;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TotalStatement {
    private final String amount;
    private final String currency;
    private final StatementType type;

    public static /* synthetic */ TotalStatement copy$default(TotalStatement totalStatement, StatementType statementType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            statementType = totalStatement.type;
        }
        if ((i & 2) != 0) {
            str = totalStatement.amount;
        }
        if ((i & 4) != 0) {
            str2 = totalStatement.currency;
        }
        return totalStatement.copy(statementType, str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final StatementType getType() {
        return this.type;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public final TotalStatement copy(StatementType type, String amount, String currency) {
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(amount, "");
        Intrinsics.checkNotNullParameter(currency, "");
        return new TotalStatement(type, amount, currency);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TotalStatement) {
            TotalStatement totalStatement = (TotalStatement) other;
            return this.type == totalStatement.type && Intrinsics.areEqual(this.amount, totalStatement.amount) && Intrinsics.areEqual(this.currency, totalStatement.currency);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.type.hashCode() * 31) + this.amount.hashCode()) * 31) + this.currency.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TotalStatement(type=");
        sb.append(this.type);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", currency=");
        sb.append(this.currency);
        sb.append(')');
        return sb.toString();
    }

    public TotalStatement(StatementType statementType, String str, String str2) {
        Intrinsics.checkNotNullParameter(statementType, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.type = statementType;
        this.amount = str;
        this.currency = str2;
    }

    @JvmName(name = "getType")
    public final StatementType getType() {
        return this.type;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }
}

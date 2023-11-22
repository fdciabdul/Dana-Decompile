package id.dana.domain.statement.model;

import id.dana.domain.user.CurrencyAmount;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u000eJ\u0010\u0010\u001a\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\bR\"\u0010\u0012\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010$"}, d2 = {"Lid/dana/domain/statement/model/UserStatement;", "", "Lid/dana/domain/user/CurrencyAmount;", "component1", "()Lid/dana/domain/user/CurrencyAmount;", "", "Lid/dana/domain/statement/model/StatementSummary;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/String;", "", "component4", "()I", "accumulateAmount", "userStatement", "statementType", "viewType", "copy", "(Lid/dana/domain/user/CurrencyAmount;Ljava/util/List;Ljava/lang/String;I)Lid/dana/domain/statement/model/UserStatement;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Lid/dana/domain/user/CurrencyAmount;", "getAccumulateAmount", "Ljava/lang/String;", "getStatementType", "Ljava/util/List;", "getUserStatement", "I", "getViewType", "setViewType", "(I)V", "<init>", "(Lid/dana/domain/user/CurrencyAmount;Ljava/util/List;Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserStatement {
    private final CurrencyAmount accumulateAmount;
    private final String statementType;
    private final List<StatementSummary> userStatement;
    private int viewType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserStatement copy$default(UserStatement userStatement, CurrencyAmount currencyAmount, List list, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            currencyAmount = userStatement.accumulateAmount;
        }
        if ((i2 & 2) != 0) {
            list = userStatement.userStatement;
        }
        if ((i2 & 4) != 0) {
            str = userStatement.statementType;
        }
        if ((i2 & 8) != 0) {
            i = userStatement.viewType;
        }
        return userStatement.copy(currencyAmount, list, str, i);
    }

    /* renamed from: component1  reason: from getter */
    public final CurrencyAmount getAccumulateAmount() {
        return this.accumulateAmount;
    }

    public final List<StatementSummary> component2() {
        return this.userStatement;
    }

    /* renamed from: component3  reason: from getter */
    public final String getStatementType() {
        return this.statementType;
    }

    /* renamed from: component4  reason: from getter */
    public final int getViewType() {
        return this.viewType;
    }

    public final UserStatement copy(CurrencyAmount accumulateAmount, List<StatementSummary> userStatement, String statementType, int viewType) {
        Intrinsics.checkNotNullParameter(accumulateAmount, "");
        Intrinsics.checkNotNullParameter(userStatement, "");
        Intrinsics.checkNotNullParameter(statementType, "");
        return new UserStatement(accumulateAmount, userStatement, statementType, viewType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserStatement) {
            UserStatement userStatement = (UserStatement) other;
            return Intrinsics.areEqual(this.accumulateAmount, userStatement.accumulateAmount) && Intrinsics.areEqual(this.userStatement, userStatement.userStatement) && Intrinsics.areEqual(this.statementType, userStatement.statementType) && this.viewType == userStatement.viewType;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.accumulateAmount.hashCode() * 31) + this.userStatement.hashCode()) * 31) + this.statementType.hashCode()) * 31) + this.viewType;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserStatement(accumulateAmount=");
        sb.append(this.accumulateAmount);
        sb.append(", userStatement=");
        sb.append(this.userStatement);
        sb.append(", statementType=");
        sb.append(this.statementType);
        sb.append(", viewType=");
        sb.append(this.viewType);
        sb.append(')');
        return sb.toString();
    }

    public UserStatement(CurrencyAmount currencyAmount, List<StatementSummary> list, String str, int i) {
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.accumulateAmount = currencyAmount;
        this.userStatement = list;
        this.statementType = str;
        this.viewType = i;
    }

    public /* synthetic */ UserStatement(CurrencyAmount currencyAmount, List list, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(currencyAmount, list, str, (i2 & 8) != 0 ? 1 : i);
    }

    @JvmName(name = "getAccumulateAmount")
    public final CurrencyAmount getAccumulateAmount() {
        return this.accumulateAmount;
    }

    @JvmName(name = "getUserStatement")
    public final List<StatementSummary> getUserStatement() {
        return this.userStatement;
    }

    @JvmName(name = "getStatementType")
    public final String getStatementType() {
        return this.statementType;
    }

    @JvmName(name = "getViewType")
    public final int getViewType() {
        return this.viewType;
    }

    @JvmName(name = "setViewType")
    public final void setViewType(int i) {
        this.viewType = i;
    }
}

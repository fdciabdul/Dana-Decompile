package id.dana.domain.statement.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J0\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0018R(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u0018"}, d2 = {"Lid/dana/domain/statement/model/IncomeAndExpenseStatementSummary;", "", "", "Lid/dana/domain/statement/model/UserStatement;", "component1", "()Ljava/util/List;", "component2", "incomes", "expenses", "copy", "(Ljava/util/List;Ljava/util/List;)Lid/dana/domain/statement/model/IncomeAndExpenseStatementSummary;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getExpenses", "setExpenses", "(Ljava/util/List;)V", "getIncomes", "setIncomes", "<init>", "(Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class IncomeAndExpenseStatementSummary {
    private List<UserStatement> expenses;
    private List<UserStatement> incomes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IncomeAndExpenseStatementSummary copy$default(IncomeAndExpenseStatementSummary incomeAndExpenseStatementSummary, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = incomeAndExpenseStatementSummary.incomes;
        }
        if ((i & 2) != 0) {
            list2 = incomeAndExpenseStatementSummary.expenses;
        }
        return incomeAndExpenseStatementSummary.copy(list, list2);
    }

    public final List<UserStatement> component1() {
        return this.incomes;
    }

    public final List<UserStatement> component2() {
        return this.expenses;
    }

    public final IncomeAndExpenseStatementSummary copy(List<UserStatement> incomes, List<UserStatement> expenses) {
        Intrinsics.checkNotNullParameter(incomes, "");
        Intrinsics.checkNotNullParameter(expenses, "");
        return new IncomeAndExpenseStatementSummary(incomes, expenses);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof IncomeAndExpenseStatementSummary) {
            IncomeAndExpenseStatementSummary incomeAndExpenseStatementSummary = (IncomeAndExpenseStatementSummary) other;
            return Intrinsics.areEqual(this.incomes, incomeAndExpenseStatementSummary.incomes) && Intrinsics.areEqual(this.expenses, incomeAndExpenseStatementSummary.expenses);
        }
        return false;
    }

    public final int hashCode() {
        return (this.incomes.hashCode() * 31) + this.expenses.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IncomeAndExpenseStatementSummary(incomes=");
        sb.append(this.incomes);
        sb.append(", expenses=");
        sb.append(this.expenses);
        sb.append(')');
        return sb.toString();
    }

    public IncomeAndExpenseStatementSummary(List<UserStatement> list, List<UserStatement> list2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        this.incomes = list;
        this.expenses = list2;
    }

    @JvmName(name = "getIncomes")
    public final List<UserStatement> getIncomes() {
        return this.incomes;
    }

    @JvmName(name = "setIncomes")
    public final void setIncomes(List<UserStatement> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.incomes = list;
    }

    @JvmName(name = "getExpenses")
    public final List<UserStatement> getExpenses() {
        return this.expenses;
    }

    @JvmName(name = "setExpenses")
    public final void setExpenses(List<UserStatement> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.expenses = list;
    }
}

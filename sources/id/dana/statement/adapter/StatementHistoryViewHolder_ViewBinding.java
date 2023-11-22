package id.dana.statement.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.statement.view.TransactionStatementView;

/* loaded from: classes9.dex */
public final class StatementHistoryViewHolder_ViewBinding implements Unbinder {
    private StatementHistoryViewHolder MyBillsEntityDataFactory;

    public StatementHistoryViewHolder_ViewBinding(StatementHistoryViewHolder statementHistoryViewHolder, View view) {
        this.MyBillsEntityDataFactory = statementHistoryViewHolder;
        statementHistoryViewHolder.transactionStatementView = (TransactionStatementView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_statement_summary, "field 'transactionStatementView'", TransactionStatementView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        StatementHistoryViewHolder statementHistoryViewHolder = this.MyBillsEntityDataFactory;
        if (statementHistoryViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        statementHistoryViewHolder.transactionStatementView = null;
    }
}

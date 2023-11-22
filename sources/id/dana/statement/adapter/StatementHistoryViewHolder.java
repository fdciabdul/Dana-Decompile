package id.dana.statement.adapter;

import android.view.ViewGroup;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.statement.model.StatementViewModel;
import id.dana.statement.model.UserStatementModel;
import id.dana.statement.view.TransactionStatementView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0012\u0010\u0004\u001a\u00020\u0003X\u0087\"¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/statement/adapter/StatementHistoryViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/statement/model/StatementViewModel;", "Lid/dana/statement/view/TransactionStatementView;", "transactionStatementView", "Lid/dana/statement/view/TransactionStatementView;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatementHistoryViewHolder extends BaseRecyclerViewHolder<StatementViewModel> {
    @BindView(R.id.view_statement_summary)
    public TransactionStatementView transactionStatementView;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(StatementViewModel statementViewModel) {
        StatementViewModel statementViewModel2 = statementViewModel;
        if (statementViewModel2 != null) {
            UserStatementModel userStatementModel = statementViewModel2.PlaceComponentResult;
        }
        TransactionStatementView transactionStatementView = this.transactionStatementView;
        if (transactionStatementView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            transactionStatementView = null;
        }
        transactionStatementView.setStatementTransaction(statementViewModel2 != null ? statementViewModel2.PlaceComponentResult : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatementHistoryViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.viewholder_statement_summary, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

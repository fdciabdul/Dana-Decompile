package id.dana.statement.adapter;

import android.view.ViewGroup;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.statement.model.StatementViewModel;
import id.dana.statement.model.UserStatementModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/statement/adapter/StatementSectionTitleViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/statement/model/StatementViewModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatementSectionTitleViewHolder extends BaseRecyclerViewHolder<StatementViewModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(StatementViewModel statementViewModel) {
        UserStatementModel userStatementModel;
        StatementViewModel statementViewModel2 = statementViewModel;
        ((TextView) this.itemView.findViewById(R.id.res_0x7f0a18ec_daggercancelsurveycomponent_cancelsurveycomponentimpl_sslpinningrepositoryprovider)).setText((statementViewModel2 == null || (userStatementModel = statementViewModel2.PlaceComponentResult) == null) ? null : userStatementModel.PlaceComponentResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatementSectionTitleViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.viewholder_statement_type, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

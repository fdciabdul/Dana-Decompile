package id.dana.statement.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.statement.model.StatementSummaryModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/statement/adapter/TransactionStatementAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/statement/model/StatementSummaryModel;", "Lkotlin/Function1;", "", "", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransactionStatementAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<StatementSummaryModel>, StatementSummaryModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Function1<? super String, Unit> getAuthRequestContext = new Function1<String, Unit>() { // from class: id.dana.statement.adapter.TransactionStatementAdapter$onItemClickListener$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics.checkNotNullParameter(str, "");
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }
    };

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new TransactionStatementViewHolder(viewGroup, this.getAuthRequestContext);
    }
}

package id.dana.cashier.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.topupandpay.viewholder.TopUpAndPayAgentViewHolder;
import id.dana.cashier.topupandpay.viewholder.TopUpAndPayBankCardViewHolder;
import id.dana.cashier.topupandpay.viewholder.TopUpAndPayBankTransferViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/adapter/TopUpAndPayMethodAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "", "p0", "getItemViewType", "(I)I", "Lkotlin/Function1;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpAndPayMethodAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<CashierPayMethodModel>, CashierPayMethodModel> {
    private final Function1<CashierPayMethodModel, Unit> PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TopUpAndPayBankCardViewHolder topUpAndPayBankCardViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            topUpAndPayBankCardViewHolder = new TopUpAndPayBankCardViewHolder(this.PlaceComponentResult, viewGroup);
        } else if (i == 3) {
            topUpAndPayBankCardViewHolder = new TopUpAndPayBankTransferViewHolder(this.PlaceComponentResult, viewGroup);
        } else if (i == 4) {
            topUpAndPayBankCardViewHolder = new TopUpAndPayAgentViewHolder(this.PlaceComponentResult, viewGroup);
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
        return topUpAndPayBankCardViewHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TopUpAndPayMethodAdapter(Function1<? super CashierPayMethodModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.PlaceComponentResult = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).getScheduleImpl();
    }
}

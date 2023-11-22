package id.dana.mybills.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.mybills.model.BizProductModel;
import id.dana.mybills.viewholder.QuickBuyBillsViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/mybills/adapter/QuickBuyBillsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/mybills/viewholder/QuickBuyBillsViewHolder;", "Lid/dana/mybills/model/BizProductModel;", "Lkotlin/Function1;", "", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuickBuyBillsAdapter extends BaseRecyclerViewAdapter<QuickBuyBillsViewHolder, BizProductModel> {
    public Function1<? super BizProductModel, Unit> getAuthRequestContext = new Function1<BizProductModel, Unit>() { // from class: id.dana.mybills.adapter.QuickBuyBillsAdapter$onQuickBuyItemClickListener$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(BizProductModel bizProductModel) {
            Intrinsics.checkNotNullParameter(bizProductModel, "");
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(BizProductModel bizProductModel) {
            invoke2(bizProductModel);
            return Unit.INSTANCE;
        }
    };

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new QuickBuyBillsViewHolder(viewGroup, this.getAuthRequestContext);
    }
}

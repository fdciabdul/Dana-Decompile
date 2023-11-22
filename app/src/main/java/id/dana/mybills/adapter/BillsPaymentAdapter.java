package id.dana.mybills.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.mybills.listener.GroupedBillPaymentsListener;
import id.dana.mybills.model.BillPaymentAdapterModel;
import id.dana.mybills.viewholder.BillPaymentHeaderViewHolder;
import id.dana.mybills.viewholder.BillPaymentStatusGroupViewHolder;
import id.dana.mybills.viewholder.BillPaymentStatusViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/mybills/adapter/BillsPaymentAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/mybills/model/BillPaymentAdapterModel;", "", "p0", "getItemViewType", "(I)I", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Lid/dana/mybills/listener/GroupedBillPaymentsListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/listener/GroupedBillPaymentsListener;", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillsPaymentAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<BillPaymentAdapterModel>, BillPaymentAdapterModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private GroupedBillPaymentsListener MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((BillsPaymentAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        BillPaymentStatusGroupViewHolder billPaymentStatusGroupViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == BillPaymentAdapterModel.ViewTypeEnum.HEADER.ordinal()) {
            billPaymentStatusGroupViewHolder = new BillPaymentHeaderViewHolder(viewGroup);
        } else if (i == BillPaymentAdapterModel.ViewTypeEnum.ITEMS.ordinal()) {
            billPaymentStatusGroupViewHolder = new BillPaymentStatusViewHolder(viewGroup);
        } else {
            billPaymentStatusGroupViewHolder = new BillPaymentStatusGroupViewHolder(viewGroup);
        }
        return billPaymentStatusGroupViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItem(p0).PlaceComponentResult;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<BillPaymentAdapterModel> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.setOnItemClickListener(this.MyBillsEntityDataFactory);
        super.onBindViewHolder((BillsPaymentAdapter) p0, p1);
    }
}

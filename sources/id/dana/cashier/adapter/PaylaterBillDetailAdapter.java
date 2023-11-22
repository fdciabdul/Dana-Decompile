package id.dana.cashier.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.cashier.model.PaylaterBillDetailModel;
import id.dana.cashier.viewholder.PaylaterBillDetailViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/adapter/PaylaterBillDetailAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/cashier/viewholder/PaylaterBillDetailViewHolder;", "Lid/dana/cashier/model/PaylaterBillDetailModel;", "", "p0", "getItemViewType", "(I)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterBillDetailAdapter extends BaseRecyclerViewAdapter<PaylaterBillDetailViewHolder, PaylaterBillDetailModel> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        return new PaylaterBillDetailViewHolder(context, viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        if (getItems().size() == 1) {
            getItems().get(p0).KClassImpl$Data$declaredNonStaticMembers$2 = 3;
            return 3;
        } else if (p0 != 0) {
            if (p0 == getItems().size() - 1) {
                getItems().get(p0).KClassImpl$Data$declaredNonStaticMembers$2 = 2;
                return 2;
            }
            getItems().get(p0).KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            return 0;
        } else {
            getItems().get(p0).KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            return 1;
        }
    }
}

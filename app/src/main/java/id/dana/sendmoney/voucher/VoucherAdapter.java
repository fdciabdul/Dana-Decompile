package id.dana.sendmoney.voucher;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.sendmoney.model.VoucherModel;
import id.dana.sendmoney.voucher.viewholder.VoucherViewHolder;

/* loaded from: classes5.dex */
public class VoucherAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<VoucherModel>, VoucherModel> {
    private final DynamicUrlWrapper KClassImpl$Data$declaredNonStaticMembers$2;

    public VoucherAdapter(DynamicUrlWrapper dynamicUrlWrapper) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dynamicUrlWrapper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new VoucherViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}

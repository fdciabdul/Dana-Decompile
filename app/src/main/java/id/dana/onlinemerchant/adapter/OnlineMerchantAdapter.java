package id.dana.onlinemerchant.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.onlinemerchant.adapter.viewholder.OnlineMerchantLoadingViewHolder;
import id.dana.onlinemerchant.adapter.viewholder.OnlineMerchantViewHolder;
import id.dana.onlinemerchant.adapter.viewholder.TrendingMerchantLoadingViewHolder;
import id.dana.onlinemerchant.model.OnlineMerchantWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/onlinemerchant/adapter/OnlineMerchantAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/onlinemerchant/model/OnlineMerchantWrapper;", "", "p0", "getItemViewType", "(I)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnlineMerchantAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<OnlineMerchantWrapper>, OnlineMerchantWrapper> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TrendingMerchantLoadingViewHolder trendingMerchantLoadingViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            trendingMerchantLoadingViewHolder = new TrendingMerchantLoadingViewHolder(viewGroup);
        } else if (i == 2) {
            trendingMerchantLoadingViewHolder = new OnlineMerchantLoadingViewHolder(viewGroup);
        } else {
            trendingMerchantLoadingViewHolder = new OnlineMerchantViewHolder(viewGroup);
        }
        return trendingMerchantLoadingViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).getAuthRequestContext;
    }
}

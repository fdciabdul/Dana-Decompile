package id.dana.explore.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.explore.adapter.viewholder.ExplorePromoLoadingViewHolder;
import id.dana.explore.adapter.viewholder.ExplorePromoViewHolder;
import id.dana.explore.model.ExplorePromoWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/explore/adapter/ExplorePromoAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/explore/model/ExplorePromoWrapper;", "", "p0", "getItemViewType", "(I)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExplorePromoAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ExplorePromoWrapper>, ExplorePromoWrapper> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ExplorePromoViewHolder explorePromoViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            explorePromoViewHolder = new ExplorePromoLoadingViewHolder(viewGroup);
        } else {
            explorePromoViewHolder = new ExplorePromoViewHolder(viewGroup);
        }
        return explorePromoViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).getAuthRequestContext;
    }
}

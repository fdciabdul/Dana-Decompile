package id.dana.explore.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.explore.adapter.viewholder.ExploreServiceLoadingViewholder;
import id.dana.explore.domain.sku.model.ExploreServiceModel;
import id.dana.explore.model.ExploreServiceWrapper;
import id.dana.explore.view.ExploreServiceViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/explore/adapter/ExploreServiceAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/explore/model/ExploreServiceWrapper;", "", "p0", "getItemViewType", "(I)I", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "getAuthRequestContext", "()V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreServiceAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ExploreServiceWrapper>, ExploreServiceWrapper> {
    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ExploreServiceAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ExploreServiceViewHolder exploreServiceViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            exploreServiceViewHolder = new ExploreServiceLoadingViewholder(viewGroup);
        } else {
            exploreServiceViewHolder = new ExploreServiceViewHolder(viewGroup);
        }
        return exploreServiceViewHolder;
    }

    public final void getAuthRequestContext() {
        getItems().add(new ExploreServiceWrapper(1, new ExploreServiceModel(null, null, null, null, false, 31, null), false));
        notifyDataSetChanged();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<ExploreServiceWrapper> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.explore.adapter.ExploreServiceAdapter$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ExploreServiceAdapter.PlaceComponentResult(ExploreServiceAdapter.this, i);
            }
        });
        super.onBindViewHolder((ExploreServiceAdapter) p0, p1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).PlaceComponentResult;
    }

    public static /* synthetic */ void PlaceComponentResult(ExploreServiceAdapter exploreServiceAdapter, int i) {
        Intrinsics.checkNotNullParameter(exploreServiceAdapter, "");
        exploreServiceAdapter.getItem(i);
    }
}

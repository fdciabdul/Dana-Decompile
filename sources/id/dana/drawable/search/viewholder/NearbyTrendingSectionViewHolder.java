package id.dana.drawable.search.viewholder;

import android.view.ViewGroup;
import com.google.android.flexbox.FlexboxLayoutManager;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.search.adapter.NearbySearchSectionAdapter;
import id.dana.drawable.search.adapter.NearbyTrendingItemAdapter;
import id.dana.drawable.search.model.NearbySearchSectionModel;
import id.dana.drawable.view.MaxHeightRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyrevamp/search/viewholder/NearbyTrendingSectionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/search/model/NearbySearchSectionModel;", "Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter$NearbySectionListener;", "MyBillsEntityDataFactory", "Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter$NearbySectionListener;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter$NearbySectionListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbyTrendingSectionViewHolder extends BaseRecyclerViewHolder<NearbySearchSectionModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final NearbySearchSectionAdapter.NearbySectionListener BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(NearbySearchSectionModel nearbySearchSectionModel) {
        NearbySearchSectionModel nearbySearchSectionModel2 = nearbySearchSectionModel;
        if (nearbySearchSectionModel2 != null) {
            NearbyTrendingItemAdapter nearbyTrendingItemAdapter = new NearbyTrendingItemAdapter();
            nearbyTrendingItemAdapter.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory;
            MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) this.itemView.findViewById(R.id.rvTrendingKeyword);
            if (maxHeightRecyclerView != null) {
                maxHeightRecyclerView.setMaxHeight((getContext().getResources().getDimensionPixelSize(R.dimen.f30542131165656) + getContext().getResources().getDimensionPixelSize(R.dimen.f30552131165657)) * 3);
                maxHeightRecyclerView.setLayoutManager(new FlexboxLayoutManager(maxHeightRecyclerView.getContext()));
                maxHeightRecyclerView.setAdapter(nearbyTrendingItemAdapter);
            }
            nearbyTrendingItemAdapter.setItems(nearbySearchSectionModel2.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyTrendingSectionViewHolder(ViewGroup viewGroup, NearbySearchSectionAdapter.NearbySectionListener nearbySectionListener) {
        super(viewGroup.getContext(), R.layout.item_nearby_trending_section, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.BuiltInFictitiousFunctionClassFactory = nearbySectionListener;
    }
}

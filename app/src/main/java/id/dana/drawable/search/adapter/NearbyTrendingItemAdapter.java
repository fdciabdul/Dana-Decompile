package id.dana.drawable.search.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.search.adapter.NearbySearchSectionAdapter;
import id.dana.drawable.search.adapter.NearbyTrendingItemAdapter;
import id.dana.drawable.search.model.NearbySearchItemModel;
import id.dana.richview.EllipseTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/search/adapter/NearbyTrendingItemAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/search/model/NearbySearchItemModel;", "Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter$NearbySectionListener;", "MyBillsEntityDataFactory", "Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter$NearbySectionListener;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V", "NearbyTrendingViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbyTrendingItemAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<NearbySearchItemModel>, NearbySearchItemModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public NearbySearchSectionAdapter.NearbySectionListener BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new NearbyTrendingViewHolder(viewGroup, this.BuiltInFictitiousFunctionClassFactory);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/nearbyrevamp/search/adapter/NearbyTrendingItemAdapter$NearbyTrendingViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/search/model/NearbySearchItemModel;", "Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter$NearbySectionListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter$NearbySectionListener;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/nearbyrevamp/search/adapter/NearbySearchSectionAdapter$NearbySectionListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class NearbyTrendingViewHolder extends BaseRecyclerViewHolder<NearbySearchItemModel> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final NearbySearchSectionAdapter.NearbySectionListener PlaceComponentResult;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(NearbySearchItemModel nearbySearchItemModel) {
            EllipseTextView ellipseTextView;
            final NearbySearchItemModel nearbySearchItemModel2 = nearbySearchItemModel;
            if (nearbySearchItemModel2 == null || (ellipseTextView = (EllipseTextView) this.itemView.findViewById(R.id.CreateFamilyAccountEntity)) == null) {
                return;
            }
            ellipseTextView.setText(nearbySearchItemModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            ellipseTextView.setStrokeColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView.getContext(), R.color.f27032131100473));
            ellipseTextView.setCornerRadius(ellipseTextView.getContext().getResources().getDimension(R.dimen.MyBillsEntityDataFactory_res_0x7f07005f));
            ellipseTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.search.adapter.NearbyTrendingItemAdapter$NearbyTrendingViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NearbyTrendingItemAdapter.NearbyTrendingViewHolder.PlaceComponentResult(NearbyTrendingItemAdapter.NearbyTrendingViewHolder.this, nearbySearchItemModel2);
                }
            });
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NearbyTrendingViewHolder(ViewGroup viewGroup, NearbySearchSectionAdapter.NearbySectionListener nearbySectionListener) {
            super(viewGroup.getContext(), R.layout.item_nearby_trending_keyword, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup;
            this.PlaceComponentResult = nearbySectionListener;
        }

        public static /* synthetic */ void PlaceComponentResult(NearbyTrendingViewHolder nearbyTrendingViewHolder, NearbySearchItemModel nearbySearchItemModel) {
            Intrinsics.checkNotNullParameter(nearbyTrendingViewHolder, "");
            NearbySearchSectionAdapter.NearbySectionListener nearbySectionListener = nearbyTrendingViewHolder.PlaceComponentResult;
            if (nearbySectionListener != null) {
                nearbySectionListener.getAuthRequestContext(nearbySearchItemModel.KClassImpl$Data$declaredNonStaticMembers$2, nearbySearchItemModel.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }
}

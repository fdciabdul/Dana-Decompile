package id.dana.explore.popularplaces.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.explore.popularplaces.model.ExplorePopularPlacesConfigModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/explore/popularplaces/adapter/PopularPlacesAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/explore/popularplaces/adapter/PopularPlacesAdapter$PopularPlacesViewHolder;", "Lid/dana/explore/popularplaces/model/ExplorePopularPlacesConfigModel;", "<init>", "()V", "PopularPlacesViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PopularPlacesAdapter extends BaseRecyclerViewAdapter<PopularPlacesViewHolder, ExplorePopularPlacesConfigModel> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new PopularPlacesViewHolder(viewGroup);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/popularplaces/adapter/PopularPlacesAdapter$PopularPlacesViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/explore/popularplaces/model/ExplorePopularPlacesConfigModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PopularPlacesViewHolder extends BaseRecyclerViewHolder<ExplorePopularPlacesConfigModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(ExplorePopularPlacesConfigModel explorePopularPlacesConfigModel) {
            ExplorePopularPlacesConfigModel explorePopularPlacesConfigModel2 = explorePopularPlacesConfigModel;
            Intrinsics.checkNotNullParameter(explorePopularPlacesConfigModel2, "");
            CircleImageView circleImageView = (CircleImageView) this.itemView.findViewById(R.id.iv_merchant_logo);
            if (circleImageView != null) {
                Intrinsics.checkNotNullExpressionValue(circleImageView, "");
                String str = explorePopularPlacesConfigModel2.PlaceComponentResult;
                if (str != null) {
                    GlideApp.getAuthRequestContext(circleImageView.getContext()).PlaceComponentResult(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.skeleton_popular_places).PlaceComponentResult((int) R.drawable.ic_merchant_logo_null).MyBillsEntityDataFactory((ImageView) circleImageView);
                } else if (circleImageView instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(circleImageView, R.drawable.ic_merchant_logo_null);
                } else {
                    circleImageView.setImageResource(R.drawable.ic_merchant_logo_null);
                }
                circleImageView.setContentDescription(circleImageView.getContext().getString(R.string.btn_popular_places));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PopularPlacesViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_popular_places, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}

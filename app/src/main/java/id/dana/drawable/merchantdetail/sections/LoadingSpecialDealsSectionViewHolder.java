package id.dana.drawable.merchantdetail.sections;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.model.NearbyDealsSectionModel;
import id.dana.utils.ShimmeringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/sections/LoadingSpecialDealsSectionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/NearbyDealsSectionModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoadingSpecialDealsSectionViewHolder extends BaseRecyclerViewHolder<NearbyDealsSectionModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(NearbyDealsSectionModel nearbyDealsSectionModel) {
        super.bindData(nearbyDealsSectionModel);
        ShimmeringUtil.PlaceComponentResult(this.itemView, R.layout.special_deals_loading_section_layout).MyBillsEntityDataFactory();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingSpecialDealsSectionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.special_deals_loading_section_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

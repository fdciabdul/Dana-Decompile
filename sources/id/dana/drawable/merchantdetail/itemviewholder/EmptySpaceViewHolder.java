package id.dana.drawable.merchantdetail.itemviewholder;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.model.NearbySpecialDealsItemWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/itemviewholder/EmptySpaceViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmptySpaceViewHolder extends BaseRecyclerViewHolder<NearbySpecialDealsItemWrapper> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptySpaceViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.special_deals_empty_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

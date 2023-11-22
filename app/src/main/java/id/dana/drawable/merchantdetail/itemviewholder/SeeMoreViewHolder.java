package id.dana.drawable.merchantdetail.itemviewholder;

import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.model.NearbySpecialDealsItemWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/itemviewholder/SeeMoreViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper;", "Lkotlin/Function0;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function0;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SeeMoreViewHolder extends BaseRecyclerViewHolder<NearbySpecialDealsItemWrapper> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Function0<Unit> PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(NearbySpecialDealsItemWrapper nearbySpecialDealsItemWrapper) {
        super.bindData(nearbySpecialDealsItemWrapper);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantdetail.itemviewholder.SeeMoreViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SeeMoreViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(SeeMoreViewHolder.this);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeeMoreViewHolder(ViewGroup viewGroup, Function0<Unit> function0) {
        super(viewGroup.getContext(), R.layout.deals_see_more_item_view_holder_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.PlaceComponentResult = function0;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SeeMoreViewHolder seeMoreViewHolder) {
        Intrinsics.checkNotNullParameter(seeMoreViewHolder, "");
        seeMoreViewHolder.PlaceComponentResult.invoke();
    }
}

package id.dana.drawable.search.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.model.ShopModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/search/viewholder/NearbyMerchantLoadMoreViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/ShopModel;", "Lkotlin/Function0;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbyMerchantLoadMoreViewHolder extends BaseRecyclerViewHolder<ShopModel> {
    private final Function0<Unit> PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ShopModel shopModel) {
        Button button = (Button) this.itemView.findViewById(R.id.AppCompatEmojiTextHelper_res_0x7f0a015d);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.search.viewholder.NearbyMerchantLoadMoreViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NearbyMerchantLoadMoreViewHolder.MyBillsEntityDataFactory(NearbyMerchantLoadMoreViewHolder.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyMerchantLoadMoreViewHolder(ViewGroup viewGroup, Function0<Unit> function0) {
        super(viewGroup.getContext(), R.layout.item_nearby_search_load_more, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.PlaceComponentResult = function0;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(NearbyMerchantLoadMoreViewHolder nearbyMerchantLoadMoreViewHolder) {
        Intrinsics.checkNotNullParameter(nearbyMerchantLoadMoreViewHolder, "");
        nearbyMerchantLoadMoreViewHolder.PlaceComponentResult.invoke();
    }
}

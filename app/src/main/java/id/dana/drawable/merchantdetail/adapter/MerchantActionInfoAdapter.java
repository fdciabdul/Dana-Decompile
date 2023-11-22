package id.dana.drawable.merchantdetail.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.nearbyme.model.MerchantDetailConfig;
import id.dana.drawable.model.MerchantDetailInfoModel;
import id.dana.drawable.view.MerchantActionListView;
import id.dana.nearbyme.model.ShopModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantActionInfoAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantActionInfoAdapter$MerchantActionInfoViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "", "getItemCount", "()I", "<init>", "()V", "MerchantActionInfoViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantActionInfoAdapter extends BaseRecyclerViewAdapter<MerchantActionInfoViewHolder, MerchantDetailInfoModel> {
    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new MerchantActionInfoViewHolder(viewGroup);
    }

    public MerchantActionInfoAdapter() {
        MerchantDetailInfoModel.Companion companion = MerchantDetailInfoModel.INSTANCE;
        setItems(CollectionsKt.mutableListOf(MerchantDetailInfoModel.Companion.getAuthRequestContext(new ShopModel(), new MerchantDetailConfig(false, false, false, false, false, false, false, 127, null))));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantActionInfoAdapter$MerchantActionInfoViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantActionInfoViewHolder extends BaseRecyclerViewHolder<MerchantDetailInfoModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantDetailInfoModel merchantDetailInfoModel) {
            ShopModel shopModel;
            MerchantActionListView merchantActionListView;
            MerchantDetailInfoModel merchantDetailInfoModel2 = merchantDetailInfoModel;
            if (merchantDetailInfoModel2 == null || (shopModel = merchantDetailInfoModel2.BuiltInFictitiousFunctionClassFactory) == null || (merchantActionListView = (MerchantActionListView) this.itemView.findViewById(R.id.clMerchantActionInfo)) == null) {
                return;
            }
            merchantActionListView.showActionMenu(shopModel, merchantDetailInfoModel2.PlaceComponentResult);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantActionInfoViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_merchant_actions, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}

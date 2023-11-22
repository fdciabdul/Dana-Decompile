package id.dana.drawable.merchantdetail.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.model.MerchantPromoDealsViewHolderModel;
import id.dana.drawable.view.MerchantPromoDealsView;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ShimmeringUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0011\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantPromoDealsInfoAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantPromoDealsViewHolderModel;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "", "Lid/dana/nearbyme/model/PromoInfoModel;", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "p1", "Lid/dana/nearbyme/model/ShopModel;", "p2", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Ljava/util/List;Lid/dana/nearbyme/model/ShopModel;)V", "<init>", "()V", "MerchantPromoDealsInfoViewHolder", "MerchantPromoDealsShimmerViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantPromoDealsInfoAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<MerchantPromoDealsViewHolderModel>, MerchantPromoDealsViewHolderModel> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MerchantPromoDealsInfoViewHolder merchantPromoDealsInfoViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            merchantPromoDealsInfoViewHolder = new MerchantPromoDealsShimmerViewHolder(viewGroup);
        } else {
            merchantPromoDealsInfoViewHolder = new MerchantPromoDealsInfoViewHolder(viewGroup);
        }
        return merchantPromoDealsInfoViewHolder;
    }

    public MerchantPromoDealsInfoAdapter() {
        MerchantPromoDealsViewHolderModel.Companion companion = MerchantPromoDealsViewHolderModel.INSTANCE;
        setItems(CollectionsKt.mutableListOf(MerchantPromoDealsViewHolderModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2()));
    }

    public final void MyBillsEntityDataFactory(List<? extends PromoInfoModel> p0, List<MerchantProductInfoModel> p1, ShopModel p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        ArrayList arrayList = new ArrayList();
        MerchantPromoDealsViewHolderModel.Companion companion = MerchantPromoDealsViewHolderModel.INSTANCE;
        arrayList.add(MerchantPromoDealsViewHolderModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, p1, p2));
        setItems(arrayList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).getAuthRequestContext;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        List<MerchantPromoDealsViewHolderModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        if (CollectionsKt.firstOrNull((List) items) != null) {
            List<MerchantPromoDealsViewHolderModel> items2 = getItems();
            Intrinsics.checkNotNullExpressionValue(items2, "");
            if (((MerchantPromoDealsViewHolderModel) CollectionsKt.first((List) items2)).getAuthRequestContext == 1) {
                return 1;
            }
            List<MerchantPromoDealsViewHolderModel> items3 = getItems();
            Intrinsics.checkNotNullExpressionValue(items3, "");
            if (((MerchantPromoDealsViewHolderModel) CollectionsKt.first((List) items3)).getAuthRequestContext == 0) {
                List<MerchantPromoDealsViewHolderModel> items4 = getItems();
                Intrinsics.checkNotNullExpressionValue(items4, "");
                if (((MerchantPromoDealsViewHolderModel) CollectionsKt.first((List) items4)).BuiltInFictitiousFunctionClassFactory()) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantPromoDealsInfoAdapter$MerchantPromoDealsInfoViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantPromoDealsViewHolderModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantPromoDealsInfoViewHolder extends BaseRecyclerViewHolder<MerchantPromoDealsViewHolderModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantPromoDealsViewHolderModel merchantPromoDealsViewHolderModel) {
            MerchantPromoDealsView merchantPromoDealsView;
            MerchantPromoDealsViewHolderModel merchantPromoDealsViewHolderModel2 = merchantPromoDealsViewHolderModel;
            if (merchantPromoDealsViewHolderModel2 != null) {
                ShopModel shopModel = merchantPromoDealsViewHolderModel2.PlaceComponentResult;
                if (shopModel != null && (merchantPromoDealsView = (MerchantPromoDealsView) this.itemView.findViewById(R.id.vMerchantPromoDeals)) != null) {
                    merchantPromoDealsView.setShopModel(shopModel);
                }
                MerchantPromoDealsView merchantPromoDealsView2 = (MerchantPromoDealsView) this.itemView.findViewById(R.id.vMerchantPromoDeals);
                if (merchantPromoDealsView2 != null) {
                    merchantPromoDealsView2.populatePromoAndDeals(merchantPromoDealsViewHolderModel2.KClassImpl$Data$declaredNonStaticMembers$2, merchantPromoDealsViewHolderModel2.BuiltInFictitiousFunctionClassFactory);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantPromoDealsInfoViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_merchant_promo_deals_viewholder, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantPromoDealsInfoAdapter$MerchantPromoDealsShimmerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantPromoDealsViewHolderModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantPromoDealsShimmerViewHolder extends BaseRecyclerViewHolder<MerchantPromoDealsViewHolderModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantPromoDealsViewHolderModel merchantPromoDealsViewHolderModel) {
            ShimmeringUtil.PlaceComponentResult(this.itemView.findViewById(R.id.view_shimmer), R.layout.view_merchant_promo_deals_skeleton);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantPromoDealsShimmerViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_merchant_promodeals_shimmer, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}

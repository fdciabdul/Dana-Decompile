package id.dana.drawable.search.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.search.adapter.MerchantSearchResultAdapter;
import id.dana.drawable.search.viewholder.NearbyMerchantLoadMoreViewHolder;
import id.dana.drawable.search.viewholder.NearbyMerchantLoadingViewHolder;
import id.dana.drawable.view.MerchantBasicInfoView;
import id.dana.nearbyme.model.ShopModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B0\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u0012\u0019\u0010\u0014\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u0012\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010R'\u0010\f\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u0012\u0012\u0004\u0012\u00020\u000b0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013"}, d2 = {"Lid/dana/nearbyrevamp/search/adapter/MerchantSearchResultAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/ShopModel;", "", "p0", "getItemViewType", "(I)I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "", "MyBillsEntityDataFactory", "()V", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function1;", "p1", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "MerchantSearchResultViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantSearchResultAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ShopModel>, ShopModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function1<ShopModel, Unit> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        NearbyMerchantLoadingViewHolder nearbyMerchantLoadingViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 2) {
            nearbyMerchantLoadingViewHolder = new NearbyMerchantLoadingViewHolder(viewGroup);
        } else if (i == 3) {
            nearbyMerchantLoadingViewHolder = new NearbyMerchantLoadMoreViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            nearbyMerchantLoadingViewHolder = new MerchantSearchResultViewHolder(viewGroup, this.MyBillsEntityDataFactory);
        }
        return nearbyMerchantLoadingViewHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MerchantSearchResultAdapter(Function0<Unit> function0, Function1<? super ShopModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
        this.MyBillsEntityDataFactory = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).E;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        List<ShopModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        ShopModel shopModel = (ShopModel) CollectionsKt.lastOrNull((List) items);
        return shopModel != null && shopModel.E == 0;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        List<ShopModel> items = getItems();
        if (items == null || items.isEmpty()) {
            return;
        }
        List<ShopModel> items2 = getItems();
        Intrinsics.checkNotNullExpressionValue(items2, "");
        if (((ShopModel) CollectionsKt.last((List) items2)).E == 2) {
            removeItem(getItemCount() - 1);
        }
    }

    public final void MyBillsEntityDataFactory() {
        List<ShopModel> items = getItems();
        if (items == null || items.isEmpty()) {
            return;
        }
        List<ShopModel> items2 = getItems();
        Intrinsics.checkNotNullExpressionValue(items2, "");
        if (((ShopModel) CollectionsKt.last((List) items2)).E == 3) {
            removeItem(getItemCount() - 1);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B*\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0019\u0010\u000b\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\f\u0010\rR'\u0010\b\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/nearbyrevamp/search/adapter/MerchantSearchResultAdapter$MerchantSearchResultViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/ShopModel;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantSearchResultViewHolder extends BaseRecyclerViewHolder<ShopModel> {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final Function1<ShopModel, Unit> PlaceComponentResult;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(ShopModel shopModel) {
            final ShopModel shopModel2 = shopModel;
            if (shopModel2 != null) {
                MerchantBasicInfoView merchantBasicInfoView = (MerchantBasicInfoView) this.itemView.findViewById(R.id.AutoValue_ImmutableLongExemplarData);
                if (merchantBasicInfoView != null) {
                    MerchantBasicInfoView.showMerchantInfo$default(merchantBasicInfoView, shopModel2, true, null, 4, null);
                }
                MerchantBasicInfoView merchantBasicInfoView2 = (MerchantBasicInfoView) this.itemView.findViewById(R.id.AutoValue_ImmutableLongExemplarData);
                if (merchantBasicInfoView2 != null) {
                    merchantBasicInfoView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.search.adapter.MerchantSearchResultAdapter$MerchantSearchResultViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MerchantSearchResultAdapter.MerchantSearchResultViewHolder.PlaceComponentResult(MerchantSearchResultAdapter.MerchantSearchResultViewHolder.this, shopModel2);
                        }
                    });
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MerchantSearchResultViewHolder(ViewGroup viewGroup, Function1<? super ShopModel, Unit> function1) {
            super(viewGroup.getContext(), R.layout.view_new_merchant_list_item, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            Intrinsics.checkNotNullParameter(function1, "");
            this.PlaceComponentResult = function1;
        }

        public static /* synthetic */ void PlaceComponentResult(MerchantSearchResultViewHolder merchantSearchResultViewHolder, ShopModel shopModel) {
            Intrinsics.checkNotNullParameter(merchantSearchResultViewHolder, "");
            merchantSearchResultViewHolder.PlaceComponentResult.invoke(shopModel);
        }
    }
}

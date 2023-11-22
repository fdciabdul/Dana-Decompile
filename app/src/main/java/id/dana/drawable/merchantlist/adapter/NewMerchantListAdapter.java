package id.dana.drawable.merchantlist.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.merchantlist.adapter.NewMerchantListAdapter;
import id.dana.drawable.search.viewholder.NearbyMerchantLoadMoreViewHolder;
import id.dana.drawable.search.viewholder.NearbyMerchantLoadingViewHolder;
import id.dana.drawable.view.MerchantBasicInfoView;
import id.dana.nearbyme.model.ShopModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\rJ\r\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u000b\u001a\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0004\b\u000b\u0010\u0011R'\u0010\t\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0015X\u0086\"¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016"}, d2 = {"Lid/dana/nearbyrevamp/merchantlist/adapter/NewMerchantListAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/ShopModel;", "", "p0", "getItemViewType", "(I)I", "", "PlaceComponentResult", "()Z", "getAuthRequestContext", "", "(I)V", "MyBillsEntityDataFactory", "()V", "", "(Ljava/util/List;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "BuiltInFictitiousFunctionClassFactory", "<init>", "MerchantEmptyViewHolder", "MerchantListViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewMerchantListAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ShopModel>, ShopModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Function1<? super ShopModel, Unit> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MerchantEmptyViewHolder merchantEmptyViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            merchantEmptyViewHolder = new MerchantEmptyViewHolder(viewGroup);
        } else if (i == 2) {
            merchantEmptyViewHolder = new NearbyMerchantLoadingViewHolder(viewGroup);
        } else if (i != 3) {
            merchantEmptyViewHolder = new MerchantListViewHolder(viewGroup, this.PlaceComponentResult);
        } else {
            Function0<Unit> function0 = this.BuiltInFictitiousFunctionClassFactory;
            if (function0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                function0 = null;
            }
            merchantEmptyViewHolder = new NearbyMerchantLoadMoreViewHolder(viewGroup, function0);
        }
        return merchantEmptyViewHolder;
    }

    public NewMerchantListAdapter() {
        super.setItems(CollectionsKt.emptyList());
    }

    public final boolean getAuthRequestContext() {
        List<ShopModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        ShopModel shopModel = (ShopModel) CollectionsKt.lastOrNull((List) items);
        return shopModel != null && shopModel.E == 0;
    }

    public final boolean PlaceComponentResult() {
        Intrinsics.checkNotNullExpressionValue(getItems(), "");
        if ((!r0.isEmpty()) != false) {
            List<ShopModel> items = getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            if (((ShopModel) CollectionsKt.first((List) items)).E == 1) {
                return true;
            }
        }
        return false;
    }

    public final void MyBillsEntityDataFactory() {
        ArrayList arrayList = new ArrayList();
        ShopModel shopModel = new ShopModel();
        shopModel.E = 1;
        arrayList.add(shopModel);
        setItems(arrayList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).E;
    }

    public final void getAuthRequestContext(List<? extends ShopModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0.isEmpty()) {
            return;
        }
        List<ShopModel> items = getItems();
        if (items == null || items.isEmpty()) {
            return;
        }
        for (ShopModel shopModel : p0) {
            int indexOf = getItems().indexOf(shopModel);
            if (indexOf != -1) {
                getItems().get(indexOf).MyBillsEntityDataFactory(shopModel.getCallingPid);
                notifyItemChanged(indexOf);
            }
        }
    }

    public final void getAuthRequestContext(int p0) {
        if (getPlaceComponentResult() <= 0 || getItemViewType(getPlaceComponentResult() - 1) != p0) {
            return;
        }
        removeItem(getPlaceComponentResult() - 1);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B.\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u001d\b\u0002\u0010\u000b\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rR)\u0010\b\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/nearbyrevamp/merchantlist/adapter/NewMerchantListAdapter$MerchantListViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/ShopModel;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantListViewHolder extends BaseRecyclerViewHolder<ShopModel> {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final Function1<ShopModel, Unit> getAuthRequestContext;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(ShopModel shopModel) {
            MerchantBasicInfoView merchantBasicInfoView;
            final ShopModel shopModel2 = shopModel;
            if (shopModel2 == null || (merchantBasicInfoView = (MerchantBasicInfoView) this.itemView.findViewById(R.id.AutoValue_ImmutableLongExemplarData)) == null) {
                return;
            }
            MerchantBasicInfoView.showMerchantInfo$default(merchantBasicInfoView, shopModel2, false, null, 6, null);
            View _$_findCachedViewById = merchantBasicInfoView._$_findCachedViewById(R.id.HoldLogin_Factory);
            if (_$_findCachedViewById != null) {
                Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "");
                _$_findCachedViewById.setVisibility(0);
            }
            merchantBasicInfoView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantlist.adapter.NewMerchantListAdapter$MerchantListViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewMerchantListAdapter.MerchantListViewHolder.MyBillsEntityDataFactory(NewMerchantListAdapter.MerchantListViewHolder.this, shopModel2);
                }
            });
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MerchantListViewHolder(ViewGroup viewGroup, Function1<? super ShopModel, Unit> function1) {
            super(viewGroup.getContext(), R.layout.view_new_merchant_list_item, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.getAuthRequestContext = function1;
        }

        public static /* synthetic */ void MyBillsEntityDataFactory(MerchantListViewHolder merchantListViewHolder, ShopModel shopModel) {
            Intrinsics.checkNotNullParameter(merchantListViewHolder, "");
            Function1<ShopModel, Unit> function1 = merchantListViewHolder.getAuthRequestContext;
            if (function1 != null) {
                function1.invoke(shopModel);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantlist/adapter/NewMerchantListAdapter$MerchantEmptyViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/ShopModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantEmptyViewHolder extends BaseRecyclerViewHolder<ShopModel> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantEmptyViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.view_nearby_merchants_empty, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}

package id.dana.drawable.merchantdetail.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.merchantdetail.adapter.MerchantContactInfoAdapter;
import id.dana.drawable.model.MerchantDetailInfoModel;
import id.dana.drawable.view.NewMerchantAddressInfoView;
import id.dana.nearbyme.model.ContactAddressModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ShimmeringUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0006J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R+\u0010\u000f\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0012\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantContactInfoAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "", "MyBillsEntityDataFactory", "()V", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "Lid/dana/nearbyme/model/ShopModel;", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/model/ShopModel;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function1;", "<init>", "MerchantDetailContactInfoShimmerViewHolder", "MerchantDetailContactInfoViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantContactInfoAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<MerchantDetailInfoModel>, MerchantDetailInfoModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Function1<? super ShopModel, Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MerchantDetailContactInfoViewHolder merchantDetailContactInfoViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            merchantDetailContactInfoViewHolder = new MerchantDetailContactInfoShimmerViewHolder(viewGroup);
        } else {
            merchantDetailContactInfoViewHolder = new MerchantDetailContactInfoViewHolder(viewGroup, this.BuiltInFictitiousFunctionClassFactory);
        }
        return merchantDetailContactInfoViewHolder;
    }

    public MerchantContactInfoAdapter() {
        MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        if (getItems().isEmpty()) {
            return 0;
        }
        List<MerchantDetailInfoModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        if (((MerchantDetailInfoModel) CollectionsKt.first((List) items)).KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
            return 1;
        }
        ShopModel shopModel = getItem(0).BuiltInFictitiousFunctionClassFactory;
        return shopModel != null && BuiltInFictitiousFunctionClassFactory(shopModel) ? 1 : 0;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(ShopModel shopModel) {
        ContactAddressModel BuiltInFictitiousFunctionClassFactory = shopModel.BuiltInFictitiousFunctionClassFactory();
        String str = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.PlaceComponentResult : null;
        return !(str == null || str.length() == 0) || shopModel.PlaceComponentResult();
    }

    public final void MyBillsEntityDataFactory() {
        setItems(CollectionsKt.mutableListOf(new MerchantDetailInfoModel(1, new ShopModel(), null, 4, null)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B.\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u001d\b\u0002\u0010\u000b\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rR)\u0010\u0007\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantContactInfoAdapter$MerchantDetailContactInfoViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "Lkotlin/Function1;", "Lid/dana/nearbyme/model/ShopModel;", "Lkotlin/ParameterName;", "", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantDetailContactInfoViewHolder extends BaseRecyclerViewHolder<MerchantDetailInfoModel> {
        private final Function1<ShopModel, Unit> MyBillsEntityDataFactory;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantDetailInfoModel merchantDetailInfoModel) {
            NewMerchantAddressInfoView newMerchantAddressInfoView;
            MerchantDetailInfoModel merchantDetailInfoModel2 = merchantDetailInfoModel;
            if (merchantDetailInfoModel2 != null) {
                ShopModel shopModel = merchantDetailInfoModel2.BuiltInFictitiousFunctionClassFactory;
                if (shopModel != null && (newMerchantAddressInfoView = (NewMerchantAddressInfoView) this.itemView.findViewById(R.id.clMerchantAddressInfo)) != null) {
                    newMerchantAddressInfoView.showAddress(shopModel);
                }
                NewMerchantAddressInfoView newMerchantAddressInfoView2 = (NewMerchantAddressInfoView) this.itemView.findViewById(R.id.clMerchantAddressInfo);
                if (newMerchantAddressInfoView2 != null) {
                    newMerchantAddressInfoView2.setOtherLocationsListener(new Function1<ShopModel, Unit>() { // from class: id.dana.nearbyrevamp.merchantdetail.adapter.MerchantContactInfoAdapter$MerchantDetailContactInfoViewHolder$bindData$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ShopModel shopModel2) {
                            invoke2(shopModel2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(ShopModel shopModel2) {
                            Function1 function1;
                            Intrinsics.checkNotNullParameter(shopModel2, "");
                            function1 = MerchantContactInfoAdapter.MerchantDetailContactInfoViewHolder.this.MyBillsEntityDataFactory;
                            if (function1 != null) {
                                function1.invoke(shopModel2);
                            }
                        }
                    });
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MerchantDetailContactInfoViewHolder(ViewGroup viewGroup, Function1<? super ShopModel, Unit> function1) {
            super(viewGroup.getContext(), R.layout.item_merchant_contact_info, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.MyBillsEntityDataFactory = function1;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantContactInfoAdapter$MerchantDetailContactInfoShimmerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantDetailContactInfoShimmerViewHolder extends BaseRecyclerViewHolder<MerchantDetailInfoModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantDetailInfoModel merchantDetailInfoModel) {
            ShimmeringUtil.PlaceComponentResult(this.itemView.findViewById(R.id.view_shimmer), R.layout.view_merchant_address_info_skeleton);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantDetailContactInfoShimmerViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_merchant_contact_shimmer, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}

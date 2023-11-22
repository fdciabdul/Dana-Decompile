package id.dana.drawable.merchantdetail.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.merchantdetail.adapter.MerchantReviewsInfoAdapter;
import id.dana.drawable.view.UserReviewView;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ShimmeringUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0017\u0018\u0019\u001aB\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0006R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantReviewsInfoAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "", "MyBillsEntityDataFactory", "()V", "BuiltInFictitiousFunctionClassFactory", "", "p0", "getItemViewType", "(I)I", "p1", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function0;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/nearbyme/model/ShopModel;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "MerchantReviewItemViewHolder", "MerchantReviewLoadMoreViewHolder", "MerchantReviewLoadingViewHolder", "MerchantReviewShimmerViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewsInfoAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<MerchantReviewViewModel>, MerchantReviewViewModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public ShopModel PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((MerchantReviewsInfoAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MerchantReviewItemViewHolder merchantReviewItemViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            merchantReviewItemViewHolder = new MerchantReviewItemViewHolder(viewGroup);
        } else if (i == 2) {
            merchantReviewItemViewHolder = new MerchantReviewShimmerViewHolder(viewGroup);
        } else if (i == 3) {
            merchantReviewItemViewHolder = new MerchantReviewLoadMoreViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else if (i == 4) {
            merchantReviewItemViewHolder = new MerchantReviewLoadingViewHolder(viewGroup);
        } else {
            merchantReviewItemViewHolder = new MerchantReviewItemViewHolder(viewGroup);
        }
        return merchantReviewItemViewHolder;
    }

    public MerchantReviewsInfoAdapter(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
        BuiltInFictitiousFunctionClassFactory();
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            MerchantReviewModel.Companion companion = MerchantReviewModel.INSTANCE;
            arrayList.add(MerchantReviewModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
        }
        setItems(arrayList);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        List<MerchantReviewViewModel> items = getItems();
        if (items == null || items.isEmpty()) {
            return;
        }
        List<MerchantReviewViewModel> items2 = getItems();
        Intrinsics.checkNotNullExpressionValue(items2, "");
        if (((MerchantReviewViewModel) CollectionsKt.last((List) items2)).MyBillsEntityDataFactory == 4) {
            List<MerchantReviewViewModel> items3 = getItems();
            Intrinsics.checkNotNullExpressionValue(items3, "");
            removeItem(CollectionsKt.getLastIndex(items3));
        }
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<MerchantReviewViewModel> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0 instanceof MerchantReviewItemViewHolder) {
            ((MerchantReviewItemViewHolder) p0).PlaceComponentResult = this.PlaceComponentResult;
        }
        super.onBindViewHolder((MerchantReviewsInfoAdapter) p0, p1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).MyBillsEntityDataFactory;
    }

    public final void MyBillsEntityDataFactory() {
        List<MerchantReviewViewModel> items = getItems();
        MerchantReviewModel.Companion companion = MerchantReviewModel.INSTANCE;
        items.add(MerchantReviewModel.Companion.MyBillsEntityDataFactory());
        notifyItemInserted(getItems().size() - 1);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantReviewsInfoAdapter$MerchantReviewShimmerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantReviewShimmerViewHolder extends BaseRecyclerViewHolder<MerchantReviewViewModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantReviewViewModel merchantReviewViewModel) {
            ShimmeringUtil.PlaceComponentResult(this.itemView.findViewById(R.id.view_shimmer), R.layout.view_user_review_skeleton);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantReviewShimmerViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_user_review_skeleton, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantReviewsInfoAdapter$MerchantReviewItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "Lid/dana/nearbyme/model/ShopModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/model/ShopModel;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantReviewItemViewHolder extends BaseRecyclerViewHolder<MerchantReviewViewModel> {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        ShopModel PlaceComponentResult;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantReviewViewModel merchantReviewViewModel) {
            MerchantReviewViewModel merchantReviewViewModel2 = merchantReviewViewModel;
            if (merchantReviewViewModel2 == null || merchantReviewViewModel2.BuiltInFictitiousFunctionClassFactory == null) {
                return;
            }
            UserReviewView userReviewView = (UserReviewView) this.itemView.findViewById(R.id.res_0x7f0a03ee_daggerdanaprotectionwidgetcomponent_danaprotectionwidgetcomponentimpl_provideeventtrackerqueueprovider);
            if (userReviewView != null) {
                userReviewView.setShopModel(this.PlaceComponentResult);
            }
            UserReviewView userReviewView2 = (UserReviewView) this.itemView.findViewById(R.id.res_0x7f0a03ee_daggerdanaprotectionwidgetcomponent_danaprotectionwidgetcomponentimpl_provideeventtrackerqueueprovider);
            if (userReviewView2 != null) {
                userReviewView2.setData(merchantReviewViewModel2.BuiltInFictitiousFunctionClassFactory);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantReviewItemViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_user_review, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantReviewsInfoAdapter$MerchantReviewLoadMoreViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "Lkotlin/Function0;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantReviewLoadMoreViewHolder extends BaseRecyclerViewHolder<MerchantReviewViewModel> {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final Function0<Unit> MyBillsEntityDataFactory;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantReviewViewModel merchantReviewViewModel) {
            Button button = (Button) this.itemView.findViewById(R.id.AppCompatEmojiTextHelper_res_0x7f0a015d);
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantdetail.adapter.MerchantReviewsInfoAdapter$MerchantReviewLoadMoreViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MerchantReviewsInfoAdapter.MerchantReviewLoadMoreViewHolder.PlaceComponentResult(MerchantReviewsInfoAdapter.MerchantReviewLoadMoreViewHolder.this);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantReviewLoadMoreViewHolder(ViewGroup viewGroup, Function0<Unit> function0) {
            super(viewGroup.getContext(), R.layout.item_nearby_search_load_more, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            Intrinsics.checkNotNullParameter(function0, "");
            this.MyBillsEntityDataFactory = function0;
        }

        public static /* synthetic */ void PlaceComponentResult(MerchantReviewLoadMoreViewHolder merchantReviewLoadMoreViewHolder) {
            Intrinsics.checkNotNullParameter(merchantReviewLoadMoreViewHolder, "");
            merchantReviewLoadMoreViewHolder.MyBillsEntityDataFactory.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantReviewsInfoAdapter$MerchantReviewLoadingViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantReviewLoadingViewHolder extends BaseRecyclerViewHolder<MerchantReviewViewModel> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantReviewLoadingViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_nearby_search_result_loading, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}

package id.dana.drawable.merchantdetail.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.drawable.merchantdetail.MerchantDetailView;
import id.dana.drawable.merchantdetail.adapter.MerchantHeaderInfoAdapter;
import id.dana.drawable.model.MerchantDetailInfoModel;
import id.dana.drawable.view.MerchantBasicInfoView;
import id.dana.extension.view.ViewExtKt;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ShimmeringUtil;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001b\u001c\u001dB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000e\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0013\u001a\u00020\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantHeaderInfoAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "p1", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailViewListener;", "getAuthRequestContext", "Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailViewListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "PlaceComponentResult", "", "Z", "MyBillsEntityDataFactory", "<init>", "(I)V", "MerchantDetailBasicInfoShimmer", "MerchantDetailBasicInfoViewHolder", "MerchantDetailSeeMoreViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantHeaderInfoAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<MerchantDetailInfoModel>, MerchantDetailInfoModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final int PlaceComponentResult;
    public MerchantDetailView.MerchantDetailViewListener getAuthRequestContext;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory = true;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return 2;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((MerchantHeaderInfoAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MerchantDetailBasicInfoShimmer merchantDetailBasicInfoShimmer;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            merchantDetailBasicInfoShimmer = new MerchantDetailBasicInfoShimmer(viewGroup);
        } else if (i == 3) {
            merchantDetailBasicInfoShimmer = new MerchantDetailSeeMoreViewHolder(viewGroup, this.PlaceComponentResult);
        } else {
            merchantDetailBasicInfoShimmer = new MerchantDetailBasicInfoViewHolder(viewGroup);
        }
        return merchantDetailBasicInfoShimmer;
    }

    public MerchantHeaderInfoAdapter(int i) {
        this.PlaceComponentResult = i;
        BuiltInFictitiousFunctionClassFactory();
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        MerchantDetailInfoModel.Companion companion = MerchantDetailInfoModel.INSTANCE;
        MerchantDetailInfoModel.Companion companion2 = MerchantDetailInfoModel.INSTANCE;
        setItems(CollectionsKt.mutableListOf(MerchantDetailInfoModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(), MerchantDetailInfoModel.Companion.MyBillsEntityDataFactory()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<MerchantDetailInfoModel> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0 instanceof MerchantDetailSeeMoreViewHolder) {
            MerchantDetailSeeMoreViewHolder merchantDetailSeeMoreViewHolder = (MerchantDetailSeeMoreViewHolder) p0;
            merchantDetailSeeMoreViewHolder.PlaceComponentResult = this.MyBillsEntityDataFactory;
            merchantDetailSeeMoreViewHolder.MyBillsEntityDataFactory = this.getAuthRequestContext;
        } else if (p0 instanceof MerchantDetailBasicInfoViewHolder) {
            ((MerchantDetailBasicInfoViewHolder) p0).BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        super.onBindViewHolder((MerchantHeaderInfoAdapter) p0, p1);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0012\u0010\u0006\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantHeaderInfoAdapter$MerchantDetailBasicInfoViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "", "PlaceComponentResult", "Z", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantDetailBasicInfoViewHolder extends BaseRecyclerViewHolder<MerchantDetailInfoModel> {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        boolean BuiltInFictitiousFunctionClassFactory;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantDetailInfoModel merchantDetailInfoModel) {
            ShopModel shopModel;
            MerchantDetailInfoModel merchantDetailInfoModel2 = merchantDetailInfoModel;
            if (merchantDetailInfoModel2 == null || (shopModel = merchantDetailInfoModel2.BuiltInFictitiousFunctionClassFactory) == null) {
                return;
            }
            MerchantBasicInfoView merchantBasicInfoView = (MerchantBasicInfoView) this.itemView.findViewById(R.id.AutoValue_ImmutableLongExemplarData);
            if (merchantBasicInfoView != null) {
                merchantBasicInfoView.showMerchantInfo(shopModel, true, MerchantBasicInfoView.InfoType.DETAIL);
            }
            MerchantBasicInfoView merchantBasicInfoView2 = (MerchantBasicInfoView) this.itemView.findViewById(R.id.AutoValue_ImmutableLongExemplarData);
            if (merchantBasicInfoView2 != null) {
                merchantBasicInfoView2.showAdditionalInfo(this.BuiltInFictitiousFunctionClassFactory ? MerchantBasicInfoView.InfoType.DETAIL_WITH_OPENHOUR_REDIRECTION : MerchantBasicInfoView.InfoType.DETAIL);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantDetailBasicInfoViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_merchant_detail_header, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantHeaderInfoAdapter$MerchantDetailBasicInfoShimmer;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantDetailBasicInfoShimmer extends BaseRecyclerViewHolder<MerchantDetailInfoModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantDetailInfoModel merchantDetailInfoModel) {
            ShimmeringUtil.PlaceComponentResult(this.itemView.findViewById(R.id.view_shimmer), R.layout.view_merchant_header_info_skeleton);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantDetailBasicInfoShimmer(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_merchant_detail_header_shimmer, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0012\u0010\u0004\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantHeaderInfoAdapter$MerchantDetailSeeMoreViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailViewListener;", "PlaceComponentResult", "Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailViewListener;", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getAuthRequestContext", "", "BuiltInFictitiousFunctionClassFactory", "Z", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantDetailSeeMoreViewHolder extends BaseRecyclerViewHolder<MerchantDetailInfoModel> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        boolean PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final int getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        MerchantDetailView.MerchantDetailViewListener MyBillsEntityDataFactory;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MerchantDetailInfoModel merchantDetailInfoModel) {
            if (merchantDetailInfoModel != null) {
                DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) this.itemView.findViewById(R.id.shouldRecycleViewType_res_0x7f0a018f);
                if (danaButtonSecondaryView != null) {
                    danaButtonSecondaryView.setVisibility(this.PlaceComponentResult ? 0 : 8);
                }
                DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) this.itemView.findViewById(R.id.shouldRecycleViewType_res_0x7f0a018f);
                if (danaButtonSecondaryView2 != null) {
                    danaButtonSecondaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantdetail.adapter.MerchantHeaderInfoAdapter$MerchantDetailSeeMoreViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MerchantHeaderInfoAdapter.MerchantDetailSeeMoreViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(MerchantHeaderInfoAdapter.MerchantDetailSeeMoreViewHolder.this);
                        }
                    });
                }
                ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(R.id.roundToPowerOfTwo);
                if (constraintLayout != null) {
                    ViewExtKt.BuiltInFictitiousFunctionClassFactory(constraintLayout, null, null, null, Integer.valueOf(this.PlaceComponentResult ? this.getAuthRequestContext : 0), 7);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantDetailSeeMoreViewHolder(ViewGroup viewGroup, int i) {
            super(viewGroup.getContext(), R.layout.item_merchant_detail_see_more, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.getAuthRequestContext = i;
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MerchantDetailSeeMoreViewHolder merchantDetailSeeMoreViewHolder) {
            Intrinsics.checkNotNullParameter(merchantDetailSeeMoreViewHolder, "");
            MerchantDetailView.MerchantDetailViewListener merchantDetailViewListener = merchantDetailSeeMoreViewHolder.MyBillsEntityDataFactory;
            if (merchantDetailViewListener != null) {
                merchantDetailViewListener.getAuthRequestContext();
            }
        }
    }
}

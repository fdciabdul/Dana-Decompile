package id.dana.promocenter.viewholders;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.github.mikephil.charting.utils.Utils;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.common.DividerItemDecoration;
import id.dana.promocenter.adapter.PromoSpecialAdsAdapter;
import id.dana.promocenter.model.PromoModel;
import id.dana.promocenter.model.PromoSectionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\u000e"}, d2 = {"Lid/dana/promocenter/viewholders/PromoSpecialAdsSectionViewHolder;", "Lid/dana/promocenter/viewholders/BasePromoCenterSectionViewHolder;", "Lid/dana/promocenter/model/PromoSectionModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/promocenter/model/PromoSectionModel;)V", "Lid/dana/promocenter/model/PromoSectionModel$State;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/promocenter/model/PromoSectionModel$State;)V", "Lid/dana/promocenter/adapter/PromoSpecialAdsAdapter;", "Lid/dana/promocenter/adapter/PromoSpecialAdsAdapter;", "PlaceComponentResult", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoSpecialAdsSectionViewHolder extends BasePromoCenterSectionViewHolder {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private PromoSpecialAdsAdapter PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private SkeletonScreen getAuthRequestContext;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[PromoSectionModel.State.values().length];
            iArr[PromoSectionModel.State.STATE_SHOW_LOADING.ordinal()] = 1;
            iArr[PromoSectionModel.State.STATE_HIDE_LOADING.ordinal()] = 2;
            iArr[PromoSectionModel.State.STATE_SHOW.ordinal()] = 3;
            iArr[PromoSectionModel.State.STATE_HIDDEN.ordinal()] = 4;
            getAuthRequestContext = iArr;
        }
    }

    @Override // id.dana.promocenter.viewholders.BasePromoCenterSectionViewHolder, id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PromoSectionModel promoSectionModel) {
        bindData(promoSectionModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromoSpecialAdsSectionViewHolder(ViewGroup viewGroup) {
        super(viewGroup, R.layout.view_promo_special_ads_section_viewholder);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.promocenter.viewholders.BasePromoCenterSectionViewHolder
    /* renamed from: getAuthRequestContext */
    public final void bindData(PromoSectionModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.bindData(p0);
        BaseRecyclerViewAdapter<BaseRecyclerViewHolder<PromoModel>, PromoModel> baseRecyclerViewAdapter = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        RecyclerView.LayoutManager layoutManager = p0.PlaceComponentResult;
        this.PlaceComponentResult = (PromoSpecialAdsAdapter) baseRecyclerViewAdapter;
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.rv_promo_merchant_special);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(layoutManager);
            PromoSpecialAdsAdapter promoSpecialAdsAdapter = this.PlaceComponentResult;
            if (promoSpecialAdsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                promoSpecialAdsAdapter = null;
            }
            recyclerView.setAdapter(promoSpecialAdsAdapter);
            if (recyclerView.getItemDecorationCount() <= 0) {
                recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), (int) R.dimen.BuiltInFictitiousFunctionClassFactory_res_0x7f070055, 8388613));
            }
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.promocenter.viewholders.PromoSpecialAdsSectionViewHolder$getPromoMerchantSpecialOnScrollListener$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView p02, int p1, int p2) {
                    Intrinsics.checkNotNullParameter(p02, "");
                    super.onScrolled(p02, p1, p2);
                    ConstraintLayout constraintLayout = (ConstraintLayout) PromoSpecialAdsSectionViewHolder.this.itemView.findViewById(R.id.cl_merchant_special_placeholder);
                    if (constraintLayout != null) {
                        PromoSpecialAdsSectionViewHolder promoSpecialAdsSectionViewHolder = PromoSpecialAdsSectionViewHolder.this;
                        float x = constraintLayout.getX();
                        float x2 = constraintLayout.getX();
                        float width = constraintLayout.getWidth();
                        if (((RecyclerView) promoSpecialAdsSectionViewHolder.itemView.findViewById(R.id.rv_promo_merchant_special)).getChildAt(0).getX() <= x || ((RecyclerView) promoSpecialAdsSectionViewHolder.itemView.findViewById(R.id.rv_promo_merchant_special)).getChildAt(0).getX() >= x2 + width) {
                            return;
                        }
                        PromoSpecialAdsSectionViewHolder.BuiltInFictitiousFunctionClassFactory(promoSpecialAdsSectionViewHolder, p1);
                    }
                }
            });
        }
        int dimension = (int) (getContext().getResources().getDimension(R.dimen.f33572131166011) + Utils.PlaceComponentResult(16.0f));
        RecyclerView recyclerView2 = (RecyclerView) this.itemView.findViewById(R.id.rv_promo_merchant_special);
        if (recyclerView2 != null) {
            recyclerView2.setPadding(dimension, 0, 0, 0);
        }
    }

    @Override // id.dana.promocenter.viewholders.BasePromoCenterSectionViewHolder
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(PromoSectionModel.State p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = WhenMappings.getAuthRequestContext[p0.ordinal()];
        byte b = 0;
        SkeletonScreen skeletonScreen = null;
        if (i == 1) {
            SkeletonScreen skeletonScreen2 = this.getAuthRequestContext;
            if (skeletonScreen2 != null) {
                if (skeletonScreen2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    skeletonScreen = skeletonScreen2;
                }
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((ConstraintLayout) this.itemView.findViewById(R.id.cl_promo_special_ads));
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_promo_special_ads_section_viewholder_skeleton;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
            ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, b);
            viewSkeletonScreen.MyBillsEntityDataFactory();
            Intrinsics.checkNotNullExpressionValue(viewSkeletonScreen, "");
            this.getAuthRequestContext = viewSkeletonScreen;
        } else if (i == 2) {
            SkeletonScreen skeletonScreen3 = this.getAuthRequestContext;
            if (skeletonScreen3 != null) {
                if (skeletonScreen3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    skeletonScreen = skeletonScreen3;
                }
                skeletonScreen.PlaceComponentResult();
            }
        } else if (i == 3) {
            SkeletonScreen skeletonScreen4 = this.getAuthRequestContext;
            if (skeletonScreen4 != null) {
                if (skeletonScreen4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    skeletonScreen = skeletonScreen4;
                }
                skeletonScreen.PlaceComponentResult();
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(R.id.cl_promo_special_ads);
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setVisibility(0);
        } else if (i == 4) {
            SkeletonScreen skeletonScreen5 = this.getAuthRequestContext;
            if (skeletonScreen5 != null) {
                if (skeletonScreen5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    skeletonScreen = skeletonScreen5;
                }
                skeletonScreen.PlaceComponentResult();
            }
            ConstraintLayout constraintLayout2 = (ConstraintLayout) this.itemView.findViewById(R.id.cl_promo_special_ads);
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
            constraintLayout2.setVisibility(8);
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PromoSpecialAdsSectionViewHolder promoSpecialAdsSectionViewHolder, int i) {
        PromoSpecialAdsAdapter promoSpecialAdsAdapter = promoSpecialAdsSectionViewHolder.PlaceComponentResult;
        if (promoSpecialAdsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSpecialAdsAdapter = null;
        }
        if (promoSpecialAdsAdapter.getPlaceComponentResult() > 0) {
            float width = i * (1.0f / ((RecyclerView) promoSpecialAdsSectionViewHolder.itemView.findViewById(R.id.rv_promo_merchant_special)).getChildAt(0).getWidth());
            ConstraintLayout constraintLayout = (ConstraintLayout) promoSpecialAdsSectionViewHolder.itemView.findViewById(R.id.cl_merchant_special_placeholder);
            float alpha = constraintLayout.getAlpha();
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            ConstraintLayout constraintLayout2 = constraintLayout;
            float f = alpha - width;
            if (f <= 0.2f) {
                constraintLayout2.setAlpha(0.2f);
            } else if (f > 1.0f) {
                constraintLayout2.setAlpha(1.0f);
            } else {
                constraintLayout2.setAlpha(f);
            }
        }
    }
}

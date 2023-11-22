package id.dana.promocenter.viewholders;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.promocenter.model.PromoSectionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/promocenter/viewholders/RegularPromoSectionViewHolder;", "Lid/dana/promocenter/viewholders/BasePromoCenterSectionViewHolder;", "Lid/dana/promocenter/model/PromoSectionModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/promocenter/model/PromoSectionModel;)V", "Lid/dana/promocenter/model/PromoSectionModel$State;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/promocenter/model/PromoSectionModel$State;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "BuiltInFictitiousFunctionClassFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegularPromoSectionViewHolder extends BasePromoCenterSectionViewHolder {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private SkeletonScreen PlaceComponentResult;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[PromoSectionModel.State.values().length];
            iArr[PromoSectionModel.State.STATE_SHOW_LOADING.ordinal()] = 1;
            iArr[PromoSectionModel.State.STATE_HIDE_LOADING.ordinal()] = 2;
            iArr[PromoSectionModel.State.STATE_SHOW.ordinal()] = 3;
            iArr[PromoSectionModel.State.STATE_HIDDEN.ordinal()] = 4;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    @Override // id.dana.promocenter.viewholders.BasePromoCenterSectionViewHolder, id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PromoSectionModel promoSectionModel) {
        bindData(promoSectionModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegularPromoSectionViewHolder(ViewGroup viewGroup) {
        super(viewGroup, R.layout.view_regular_promo_section_viewholder);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.promocenter.viewholders.BasePromoCenterSectionViewHolder
    /* renamed from: getAuthRequestContext */
    public final void bindData(PromoSectionModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.bindData(p0);
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.rv_regular_promo);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(p0.PlaceComponentResult);
            recyclerView.setAdapter(p0.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @Override // id.dana.promocenter.viewholders.BasePromoCenterSectionViewHolder
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(PromoSectionModel.State p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()];
        byte b = 0;
        SkeletonScreen skeletonScreen = null;
        if (i == 1) {
            SkeletonScreen skeletonScreen2 = this.PlaceComponentResult;
            if (skeletonScreen2 != null) {
                if (skeletonScreen2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    skeletonScreen = skeletonScreen2;
                }
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((RecyclerView) this.itemView.findViewById(R.id.rv_regular_promo));
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_regular_promo_skeleton;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = ((RecyclerView) this.itemView.findViewById(R.id.rv_regular_promo)).getAdapter();
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 4;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
            BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.lookAheadTest = 0;
            RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, b);
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
            Intrinsics.checkNotNullExpressionValue(recyclerViewSkeletonScreen, "");
            this.PlaceComponentResult = recyclerViewSkeletonScreen;
        } else if (i == 2) {
            SkeletonScreen skeletonScreen3 = this.PlaceComponentResult;
            if (skeletonScreen3 != null) {
                if (skeletonScreen3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    skeletonScreen = skeletonScreen3;
                }
                skeletonScreen.PlaceComponentResult();
            }
        } else if (i == 3) {
            SkeletonScreen skeletonScreen4 = this.PlaceComponentResult;
            if (skeletonScreen4 != null) {
                if (skeletonScreen4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    skeletonScreen = skeletonScreen4;
                }
                skeletonScreen.PlaceComponentResult();
            }
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(0);
        } else if (i == 4) {
            SkeletonScreen skeletonScreen5 = this.PlaceComponentResult;
            if (skeletonScreen5 != null) {
                if (skeletonScreen5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    skeletonScreen = skeletonScreen5;
                }
                skeletonScreen.PlaceComponentResult();
            }
            View view2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "");
            view2.setVisibility(8);
        }
    }
}

package id.dana.explore.adapter.viewholder;

import android.view.ViewGroup;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.explore.model.ExploreProductWrapper;
import id.dana.utils.ShimmeringUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/explore/adapter/viewholder/ExploreProductLoadingViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/explore/model/ExploreProductWrapper;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreProductLoadingViewHolder extends BaseRecyclerViewHolder<ExploreProductWrapper> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ExploreProductWrapper exploreProductWrapper) {
        super.bindData(exploreProductWrapper);
        Object value = this.PlaceComponentResult.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        ((SkeletonScreen) value).MyBillsEntityDataFactory();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExploreProductLoadingViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_default_loading_container, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.PlaceComponentResult = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.explore.adapter.viewholder.ExploreProductLoadingViewHolder$productSkeletonScreen$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                return ShimmeringUtil.PlaceComponentResult(ExploreProductLoadingViewHolder.this.itemView.findViewById(R.id.view_shimmer), R.layout.view_explore_product_skeleton);
            }
        });
    }
}

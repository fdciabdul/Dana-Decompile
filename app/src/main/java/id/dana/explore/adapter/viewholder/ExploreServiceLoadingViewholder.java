package id.dana.explore.adapter.viewholder;

import android.view.ViewGroup;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.explore.model.ExploreServiceWrapper;
import id.dana.utils.ShimmeringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/explore/adapter/viewholder/ExploreServiceLoadingViewholder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/explore/model/ExploreServiceWrapper;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getAuthRequestContext", "Lcom/ethanhua/skeleton/SkeletonScreen;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreServiceLoadingViewholder extends BaseRecyclerViewHolder<ExploreServiceWrapper> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private SkeletonScreen BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ExploreServiceWrapper exploreServiceWrapper) {
        super.bindData(exploreServiceWrapper);
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = ShimmeringUtil.PlaceComponentResult(this.itemView.findViewById(R.id.view_shimmer), R.layout.view_explore_service_skeleton);
        }
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExploreServiceLoadingViewholder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_default_loading_container, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

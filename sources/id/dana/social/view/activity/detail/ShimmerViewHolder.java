package id.dana.social.view.activity.detail;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.state.ViewHolderState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0012\u0010\n\u001a\u00020\tX\u0087\"¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/view/activity/detail/ShimmerViewHolder;", "", "T", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/state/ViewHolderState;", "Landroid/view/ViewGroup;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/View;", "viewShimmer", "Landroid/view/View;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShimmerViewHolder<T> extends BaseRecyclerViewHolder<ViewHolderState<? extends T>> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final ViewGroup BuiltInFictitiousFunctionClassFactory;
    @BindView(R.id.f4599view_shimmer)
    public View viewShimmer;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        ViewHolderState viewHolderState = (ViewHolderState) obj;
        View view = this.viewShimmer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view = null;
        }
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(view);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_feed_skeleton;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0).MyBillsEntityDataFactory();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShimmerViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.viewholder_feed_shimmer, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
    }
}

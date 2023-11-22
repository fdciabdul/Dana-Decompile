package id.dana.social.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.model.FeedViewHolderModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0007X\u0087\"¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/social/adapter/SocialFeedShimmerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Landroid/view/ViewGroup;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "PlaceComponentResult", "Landroid/view/View;", "viewShimmer", "Landroid/view/View;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialFeedShimmerViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final ViewGroup PlaceComponentResult;
    @BindView(R.id.f4599view_shimmer)
    public View viewShimmer;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
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
    public SocialFeedShimmerViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.viewholder_feed_shimmer, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.PlaceComponentResult = viewGroup;
    }
}

package id.dana.social.v2.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.model.FeedViewHolderModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/v2/viewholder/FeedsShimmerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsShimmerViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        super.bindData(feedViewHolderModel);
        View findViewById = this.itemView.findViewById(R.id.fromReader);
        if (findViewById != null) {
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(findViewById);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.viewholder_feeds_skeleton;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0).MyBillsEntityDataFactory();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsShimmerViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.viewholder_feed_shimmer_v2, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

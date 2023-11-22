package id.dana.social.adapter;

import android.view.ViewGroup;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.view.FeedsSectionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0012\u0010\u0004\u001a\u00020\u0003X\u0087\"¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/adapter/FeedsSectionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Lid/dana/social/view/FeedsSectionView;", "viewFeedsSection", "Lid/dana/social/view/FeedsSectionView;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsSectionViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {
    @BindView(R.id.view_feeds_section)
    public FeedsSectionView viewFeedsSection;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        FeedModel feedModel;
        FeedViewHolderModel feedViewHolderModel2 = feedViewHolderModel;
        if (feedViewHolderModel2 == null || (feedModel = feedViewHolderModel2.MyBillsEntityDataFactory) == null) {
            return;
        }
        FeedsSectionView feedsSectionView = this.viewFeedsSection;
        if (feedsSectionView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedsSectionView = null;
        }
        feedsSectionView.setSection(feedModel.NetworkUserEntityData$$ExternalSyntheticLambda4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsSectionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.viewholder_feeds_section, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

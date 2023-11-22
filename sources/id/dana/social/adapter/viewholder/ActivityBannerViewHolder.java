package id.dana.social.adapter.viewholder;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.social.adapter.FeedViewHolder;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.view.BubbleFeedView;
import id.dana.social.view.FeedsView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/social/adapter/viewholder/ActivityBannerViewHolder;", "Lid/dana/social/adapter/FeedViewHolder;", "Landroid/view/ViewGroup;", "p0", "Lid/dana/social/adapter/SocialFeedClickListener;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityBannerViewHolder extends FeedViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityBannerViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener) {
        super(viewGroup, socialFeedClickListener, false, false, false, R.layout.item_activity_banner);
        BubbleFeedView bubbleFeedView;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        FeedsView feedsView = (FeedsView) this.itemView.findViewById(R.id.PaymentResultFragment);
        if (feedsView == null || (bubbleFeedView = (BubbleFeedView) feedsView._$_findCachedViewById(R.id.view_bubble_feed)) == null) {
            return;
        }
        bubbleFeedView.setDescriptionMinLines();
    }
}

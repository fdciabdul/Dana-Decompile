package id.dana.social.v2.viewholder;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.social.adapter.SocialFeedClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/social/v2/viewholder/FeedActivityViewHolder;", "Lid/dana/social/v2/viewholder/FeedViewHolder;", "Landroid/view/ViewGroup;", "p0", "Lid/dana/social/adapter/SocialFeedClickListener;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedActivityViewHolder extends FeedViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedActivityViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener) {
        super(viewGroup, socialFeedClickListener, false, false, false, false, false, false, null, R.layout.item_share_activity, 256, null);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
    }
}

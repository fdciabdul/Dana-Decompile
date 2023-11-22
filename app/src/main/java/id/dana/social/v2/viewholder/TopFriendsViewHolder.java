package id.dana.social.v2.viewholder;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.v2.view.FeedsTopFriendsView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/v2/viewholder/TopFriendsViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Lid/dana/social/adapter/SocialFeedClickListener;", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/SocialFeedClickListener;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TopFriendsViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SocialFeedClickListener getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        FeedViewHolderModel feedViewHolderModel2 = feedViewHolderModel;
        if (feedViewHolderModel2 != null) {
            FeedsTopFriendsView feedsTopFriendsView = (FeedsTopFriendsView) this.itemView.findViewById(R.id.getSubStringLengthPer9Digit);
            if (feedsTopFriendsView != null) {
                feedsTopFriendsView.setData(feedViewHolderModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            FeedsTopFriendsView feedsTopFriendsView2 = (FeedsTopFriendsView) this.itemView.findViewById(R.id.getSubStringLengthPer9Digit);
            if (feedsTopFriendsView2 != null) {
                feedsTopFriendsView2.setOnTopFriendClick(new Function1<FriendModel, Unit>() { // from class: id.dana.social.v2.viewholder.TopFriendsViewHolder$bindData$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(FriendModel friendModel) {
                        invoke2(friendModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(FriendModel friendModel) {
                        SocialFeedClickListener socialFeedClickListener;
                        Intrinsics.checkNotNullParameter(friendModel, "");
                        socialFeedClickListener = TopFriendsViewHolder.this.getAuthRequestContext;
                        if (socialFeedClickListener != null) {
                            socialFeedClickListener.BuiltInFictitiousFunctionClassFactory(friendModel);
                        }
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopFriendsViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener) {
        super(viewGroup.getContext(), R.layout.viewholder_top_friends_v2, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.getAuthRequestContext = socialFeedClickListener;
    }
}

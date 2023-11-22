package id.dana.social.view.activity.detail;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.FeedCommentContract;
import id.dana.social.utils.FeedsContentAction;

/* loaded from: classes5.dex */
public final class SocialActivityDetail_MembersInjector implements MembersInjector<SocialActivityDetail> {
    public static void PlaceComponentResult(SocialActivityDetail socialActivityDetail, FeedCommentContract.Presenter presenter) {
        socialActivityDetail.feedCommentPresenter = presenter;
    }

    public static void PlaceComponentResult(SocialActivityDetail socialActivityDetail, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        socialActivityDetail.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }

    public static void MyBillsEntityDataFactory(SocialActivityDetail socialActivityDetail, FeedsContentAction feedsContentAction) {
        socialActivityDetail.feedsContentAction = feedsContentAction;
    }
}

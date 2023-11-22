package id.dana.social.view.activity.notification;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.FriendRequestContract;
import id.dana.social.contract.notification.FeedNotificationContract;

/* loaded from: classes5.dex */
public final class FeedNotificationActivity_MembersInjector implements MembersInjector<FeedNotificationActivity> {
    public static void getAuthRequestContext(FeedNotificationActivity feedNotificationActivity, FeedNotificationContract.Presenter presenter) {
        feedNotificationActivity.feedNotificationPresenter = presenter;
    }

    public static void getAuthRequestContext(FeedNotificationActivity feedNotificationActivity, FriendRequestContract.Presenter presenter) {
        feedNotificationActivity.friendRequestPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(FeedNotificationActivity feedNotificationActivity, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        feedNotificationActivity.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

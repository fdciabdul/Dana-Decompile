package id.dana.social.adapter;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.FriendRequestContract;

/* loaded from: classes5.dex */
public final class FriendRequestListActivity_MembersInjector implements MembersInjector<FriendRequestListActivity> {
    public static void getAuthRequestContext(FriendRequestListActivity friendRequestListActivity, FriendRequestContract.Presenter presenter) {
        friendRequestListActivity.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(FriendRequestListActivity friendRequestListActivity, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        friendRequestListActivity.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

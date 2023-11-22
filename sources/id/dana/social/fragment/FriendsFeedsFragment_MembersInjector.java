package id.dana.social.fragment;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.friendsfeeds.FriendFeedsContract;

/* loaded from: classes5.dex */
public final class FriendsFeedsFragment_MembersInjector implements MembersInjector<FriendsFeedsFragment> {
    public static void MyBillsEntityDataFactory(FriendsFeedsFragment friendsFeedsFragment, FriendFeedsContract.Presenter presenter) {
        friendsFeedsFragment.presenter = presenter;
    }

    public static void getAuthRequestContext(FriendsFeedsFragment friendsFeedsFragment, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        friendsFeedsFragment.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

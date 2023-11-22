package id.dana.social;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.FriendListContract;
import id.dana.social.contract.FriendRequestContract;

/* loaded from: classes5.dex */
public final class AddFriendListFragment_MembersInjector implements MembersInjector<AddFriendListFragment> {
    public static void getAuthRequestContext(AddFriendListFragment addFriendListFragment, FriendListContract.Presenter presenter) {
        addFriendListFragment.presenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(AddFriendListFragment addFriendListFragment, FriendRequestContract.Presenter presenter) {
        addFriendListFragment.friendRequestPresenter = presenter;
    }

    public static void getAuthRequestContext(AddFriendListFragment addFriendListFragment, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        addFriendListFragment.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

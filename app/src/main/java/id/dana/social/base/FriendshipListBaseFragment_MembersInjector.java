package id.dana.social.base;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.FriendshipContract;

/* loaded from: classes5.dex */
public final class FriendshipListBaseFragment_MembersInjector implements MembersInjector<FriendshipListBaseFragment> {
    public static void MyBillsEntityDataFactory(FriendshipListBaseFragment friendshipListBaseFragment, FriendshipContract.Presenter presenter) {
        friendshipListBaseFragment.friendshipPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(FriendshipListBaseFragment friendshipListBaseFragment, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        friendshipListBaseFragment.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

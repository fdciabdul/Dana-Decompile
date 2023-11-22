package id.dana.social;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.FriendRequestContract;
import id.dana.social.contract.RelationshipBottomSheetContract;

/* loaded from: classes5.dex */
public final class ReciprocalFriendListFragment_MembersInjector implements MembersInjector<ReciprocalFriendListFragment> {
    public static void MyBillsEntityDataFactory(ReciprocalFriendListFragment reciprocalFriendListFragment, RelationshipBottomSheetContract.Presenter presenter) {
        reciprocalFriendListFragment.presenter = presenter;
    }

    public static void PlaceComponentResult(ReciprocalFriendListFragment reciprocalFriendListFragment, FriendRequestContract.Presenter presenter) {
        reciprocalFriendListFragment.friendRequestPresenter = presenter;
    }

    public static void getAuthRequestContext(ReciprocalFriendListFragment reciprocalFriendListFragment, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        reciprocalFriendListFragment.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

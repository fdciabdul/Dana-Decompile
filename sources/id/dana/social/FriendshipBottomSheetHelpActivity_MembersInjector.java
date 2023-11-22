package id.dana.social;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;

/* loaded from: classes5.dex */
public final class FriendshipBottomSheetHelpActivity_MembersInjector implements MembersInjector<FriendshipBottomSheetHelpActivity> {
    public static void MyBillsEntityDataFactory(FriendshipBottomSheetHelpActivity friendshipBottomSheetHelpActivity, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        friendshipBottomSheetHelpActivity.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

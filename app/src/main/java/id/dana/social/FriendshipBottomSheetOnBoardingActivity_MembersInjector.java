package id.dana.social;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;

/* loaded from: classes9.dex */
public final class FriendshipBottomSheetOnBoardingActivity_MembersInjector implements MembersInjector<FriendshipBottomSheetOnBoardingActivity> {
    public static void PlaceComponentResult(FriendshipBottomSheetOnBoardingActivity friendshipBottomSheetOnBoardingActivity, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        friendshipBottomSheetOnBoardingActivity.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

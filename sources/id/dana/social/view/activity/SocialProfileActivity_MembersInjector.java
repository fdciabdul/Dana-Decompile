package id.dana.social.view.activity;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;

/* loaded from: classes5.dex */
public final class SocialProfileActivity_MembersInjector implements MembersInjector<SocialProfileActivity> {
    public static void PlaceComponentResult(SocialProfileActivity socialProfileActivity, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        socialProfileActivity.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

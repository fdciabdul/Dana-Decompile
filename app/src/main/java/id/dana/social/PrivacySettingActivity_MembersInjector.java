package id.dana.social;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.PrivacySettingContract;

/* loaded from: classes5.dex */
public final class PrivacySettingActivity_MembersInjector implements MembersInjector<PrivacySettingActivity> {
    public static void PlaceComponentResult(PrivacySettingActivity privacySettingActivity, PrivacySettingContract.Presenter presenter) {
        privacySettingActivity.presenter = presenter;
    }

    public static void PlaceComponentResult(PrivacySettingActivity privacySettingActivity, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        privacySettingActivity.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

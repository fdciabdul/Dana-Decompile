package id.dana.myprofile.mepagerevamp.profilesettings;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract;

/* loaded from: classes5.dex */
public final class ProfileSettingsActivity_MembersInjector implements MembersInjector<ProfileSettingsActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(ProfileSettingsActivity profileSettingsActivity, MePageRevampContract.Presenter presenter) {
        profileSettingsActivity.mePageRevampPresenter = presenter;
    }

    public static void PlaceComponentResult(ProfileSettingsActivity profileSettingsActivity, ProfileSettingsContract.Presenter presenter) {
        profileSettingsActivity.profileSettingsPresenter = presenter;
    }

    public static void getAuthRequestContext(ProfileSettingsActivity profileSettingsActivity, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        profileSettingsActivity.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

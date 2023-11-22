package id.dana.myprofile.mepagerevamp.profilesettings.view;

import dagger.MembersInjector;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.contract.PrivacySettingContract;

/* loaded from: classes5.dex */
public final class NewFeedSharingView_MembersInjector implements MembersInjector<NewFeedSharingView> {
    public static void BuiltInFictitiousFunctionClassFactory(NewFeedSharingView newFeedSharingView, PrivacySettingContract.Presenter presenter) {
        newFeedSharingView.privacySettingPresenter = presenter;
    }

    public static void getAuthRequestContext(NewFeedSharingView newFeedSharingView, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        newFeedSharingView.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

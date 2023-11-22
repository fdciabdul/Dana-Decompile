package id.dana.danah5.bottomsheet;

import dagger.MembersInjector;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.feeds.domain.share.interactor.CreateFeedActivity;
import id.dana.feeds.domain.share.interactor.GetPreviewActivity;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ShareFeedBottomSheetManager_MembersInjector implements MembersInjector<ShareFeedBottomSheetManager> {
    private final Provider<CreateFeedActivity> createFeedActivityProvider;
    private final Provider<FriendshipAnalyticTracker> friendshipAnalyticTrackerProvider;
    private final Provider<GetPreviewActivity> getFeedPreviewActivityProvider;
    private final Provider<GetShareFeedConsent> getShareFeedConsentProvider;
    private final Provider<GetUserInfo> getUserInfoProvider;
    private final Provider<SaveShareFeedConsent> saveShareFeedConsentProvider;

    public ShareFeedBottomSheetManager_MembersInjector(Provider<GetShareFeedConsent> provider, Provider<SaveShareFeedConsent> provider2, Provider<GetPreviewActivity> provider3, Provider<CreateFeedActivity> provider4, Provider<GetUserInfo> provider5, Provider<FriendshipAnalyticTracker> provider6) {
        this.getShareFeedConsentProvider = provider;
        this.saveShareFeedConsentProvider = provider2;
        this.getFeedPreviewActivityProvider = provider3;
        this.createFeedActivityProvider = provider4;
        this.getUserInfoProvider = provider5;
        this.friendshipAnalyticTrackerProvider = provider6;
    }

    public static MembersInjector<ShareFeedBottomSheetManager> create(Provider<GetShareFeedConsent> provider, Provider<SaveShareFeedConsent> provider2, Provider<GetPreviewActivity> provider3, Provider<CreateFeedActivity> provider4, Provider<GetUserInfo> provider5, Provider<FriendshipAnalyticTracker> provider6) {
        return new ShareFeedBottomSheetManager_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public final void injectMembers(ShareFeedBottomSheetManager shareFeedBottomSheetManager) {
        injectGetShareFeedConsent(shareFeedBottomSheetManager, this.getShareFeedConsentProvider.get());
        injectSaveShareFeedConsent(shareFeedBottomSheetManager, this.saveShareFeedConsentProvider.get());
        injectGetFeedPreviewActivity(shareFeedBottomSheetManager, this.getFeedPreviewActivityProvider.get());
        injectCreateFeedActivity(shareFeedBottomSheetManager, this.createFeedActivityProvider.get());
        injectGetUserInfo(shareFeedBottomSheetManager, this.getUserInfoProvider.get());
        injectFriendshipAnalyticTracker(shareFeedBottomSheetManager, this.friendshipAnalyticTrackerProvider.get());
    }

    public static void injectGetShareFeedConsent(ShareFeedBottomSheetManager shareFeedBottomSheetManager, GetShareFeedConsent getShareFeedConsent) {
        shareFeedBottomSheetManager.getShareFeedConsent = getShareFeedConsent;
    }

    public static void injectSaveShareFeedConsent(ShareFeedBottomSheetManager shareFeedBottomSheetManager, SaveShareFeedConsent saveShareFeedConsent) {
        shareFeedBottomSheetManager.saveShareFeedConsent = saveShareFeedConsent;
    }

    public static void injectGetFeedPreviewActivity(ShareFeedBottomSheetManager shareFeedBottomSheetManager, GetPreviewActivity getPreviewActivity) {
        shareFeedBottomSheetManager.getFeedPreviewActivity = getPreviewActivity;
    }

    public static void injectCreateFeedActivity(ShareFeedBottomSheetManager shareFeedBottomSheetManager, CreateFeedActivity createFeedActivity) {
        shareFeedBottomSheetManager.createFeedActivity = createFeedActivity;
    }

    public static void injectGetUserInfo(ShareFeedBottomSheetManager shareFeedBottomSheetManager, GetUserInfo getUserInfo) {
        shareFeedBottomSheetManager.getUserInfo = getUserInfo;
    }

    public static void injectFriendshipAnalyticTracker(ShareFeedBottomSheetManager shareFeedBottomSheetManager, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        shareFeedBottomSheetManager.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }
}

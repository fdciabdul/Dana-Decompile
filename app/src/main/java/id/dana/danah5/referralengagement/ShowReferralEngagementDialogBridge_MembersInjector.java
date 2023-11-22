package id.dana.danah5.referralengagement;

import dagger.MembersInjector;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ShowReferralEngagementDialogBridge_MembersInjector implements MembersInjector<ShowReferralEngagementDialogBridge> {
    private final Provider<SaveReferralEngagementDialogCache> saveReferralEngagementDialogCacheProvider;

    public ShowReferralEngagementDialogBridge_MembersInjector(Provider<SaveReferralEngagementDialogCache> provider) {
        this.saveReferralEngagementDialogCacheProvider = provider;
    }

    public static MembersInjector<ShowReferralEngagementDialogBridge> create(Provider<SaveReferralEngagementDialogCache> provider) {
        return new ShowReferralEngagementDialogBridge_MembersInjector(provider);
    }

    public final void injectMembers(ShowReferralEngagementDialogBridge showReferralEngagementDialogBridge) {
        injectSaveReferralEngagementDialogCache(showReferralEngagementDialogBridge, this.saveReferralEngagementDialogCacheProvider.get());
    }

    public static void injectSaveReferralEngagementDialogCache(ShowReferralEngagementDialogBridge showReferralEngagementDialogBridge, SaveReferralEngagementDialogCache saveReferralEngagementDialogCache) {
        showReferralEngagementDialogBridge.saveReferralEngagementDialogCache = saveReferralEngagementDialogCache;
    }
}

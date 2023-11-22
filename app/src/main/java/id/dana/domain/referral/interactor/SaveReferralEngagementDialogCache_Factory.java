package id.dana.domain.referral.interactor;

import dagger.internal.Factory;
import id.dana.domain.referral.ReferralRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveReferralEngagementDialogCache_Factory implements Factory<SaveReferralEngagementDialogCache> {
    private final Provider<ReferralRepository> referralRepositoryProvider;

    public SaveReferralEngagementDialogCache_Factory(Provider<ReferralRepository> provider) {
        this.referralRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveReferralEngagementDialogCache get() {
        return newInstance(this.referralRepositoryProvider.get());
    }

    public static SaveReferralEngagementDialogCache_Factory create(Provider<ReferralRepository> provider) {
        return new SaveReferralEngagementDialogCache_Factory(provider);
    }

    public static SaveReferralEngagementDialogCache newInstance(ReferralRepository referralRepository) {
        return new SaveReferralEngagementDialogCache(referralRepository);
    }
}

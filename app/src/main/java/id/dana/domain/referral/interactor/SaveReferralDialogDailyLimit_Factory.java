package id.dana.domain.referral.interactor;

import dagger.internal.Factory;
import id.dana.domain.referral.ReferralEngagementDialogRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveReferralDialogDailyLimit_Factory implements Factory<SaveReferralDialogDailyLimit> {
    private final Provider<ReferralEngagementDialogRepository> referralEngagementDialogRepositoryProvider;

    public SaveReferralDialogDailyLimit_Factory(Provider<ReferralEngagementDialogRepository> provider) {
        this.referralEngagementDialogRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveReferralDialogDailyLimit get() {
        return newInstance(this.referralEngagementDialogRepositoryProvider.get());
    }

    public static SaveReferralDialogDailyLimit_Factory create(Provider<ReferralEngagementDialogRepository> provider) {
        return new SaveReferralDialogDailyLimit_Factory(provider);
    }

    public static SaveReferralDialogDailyLimit newInstance(ReferralEngagementDialogRepository referralEngagementDialogRepository) {
        return new SaveReferralDialogDailyLimit(referralEngagementDialogRepository);
    }
}

package id.dana.domain.referral.interactor;

import dagger.internal.Factory;
import id.dana.domain.referral.ReferralEngagementDialogRepository;
import id.dana.domain.referral.ReferralRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckDialogDailyLimit_Factory implements Factory<CheckDialogDailyLimit> {
    private final Provider<ReferralEngagementDialogRepository> referralEngagementDialogRepositoryProvider;
    private final Provider<ReferralRepository> referralRepositoryProvider;

    public CheckDialogDailyLimit_Factory(Provider<ReferralEngagementDialogRepository> provider, Provider<ReferralRepository> provider2) {
        this.referralEngagementDialogRepositoryProvider = provider;
        this.referralRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final CheckDialogDailyLimit get() {
        return newInstance(this.referralEngagementDialogRepositoryProvider.get(), this.referralRepositoryProvider.get());
    }

    public static CheckDialogDailyLimit_Factory create(Provider<ReferralEngagementDialogRepository> provider, Provider<ReferralRepository> provider2) {
        return new CheckDialogDailyLimit_Factory(provider, provider2);
    }

    public static CheckDialogDailyLimit newInstance(ReferralEngagementDialogRepository referralEngagementDialogRepository, ReferralRepository referralRepository) {
        return new CheckDialogDailyLimit(referralEngagementDialogRepository, referralRepository);
    }
}

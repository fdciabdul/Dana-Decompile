package id.dana.domain.referral.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.ReferralRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetReferralEngagementDialog_Factory implements Factory<GetReferralEngagementDialog> {
    private final Provider<FeatureConfigRepository> configRepositoryProvider;
    private final Provider<MyReferralConsultRepository> myReferralConsultRepositoryProvider;
    private final Provider<ReferralRepository> referralRepositoryProvider;

    public GetReferralEngagementDialog_Factory(Provider<ReferralRepository> provider, Provider<FeatureConfigRepository> provider2, Provider<MyReferralConsultRepository> provider3) {
        this.referralRepositoryProvider = provider;
        this.configRepositoryProvider = provider2;
        this.myReferralConsultRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetReferralEngagementDialog get() {
        return newInstance(this.referralRepositoryProvider.get(), this.configRepositoryProvider.get(), this.myReferralConsultRepositoryProvider.get());
    }

    public static GetReferralEngagementDialog_Factory create(Provider<ReferralRepository> provider, Provider<FeatureConfigRepository> provider2, Provider<MyReferralConsultRepository> provider3) {
        return new GetReferralEngagementDialog_Factory(provider, provider2, provider3);
    }

    public static GetReferralEngagementDialog newInstance(ReferralRepository referralRepository, FeatureConfigRepository featureConfigRepository, MyReferralConsultRepository myReferralConsultRepository) {
        return new GetReferralEngagementDialog(referralRepository, featureConfigRepository, myReferralConsultRepository);
    }
}

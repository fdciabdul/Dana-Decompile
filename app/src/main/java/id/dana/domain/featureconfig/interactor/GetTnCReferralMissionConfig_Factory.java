package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTnCReferralMissionConfig_Factory implements Factory<GetTnCReferralMissionConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetTnCReferralMissionConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTnCReferralMissionConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetTnCReferralMissionConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetTnCReferralMissionConfig_Factory(provider);
    }

    public static GetTnCReferralMissionConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetTnCReferralMissionConfig(featureConfigRepository);
    }
}

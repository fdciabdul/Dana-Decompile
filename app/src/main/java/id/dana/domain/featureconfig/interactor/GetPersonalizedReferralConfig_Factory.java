package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPersonalizedReferralConfig_Factory implements Factory<GetPersonalizedReferralConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetPersonalizedReferralConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPersonalizedReferralConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetPersonalizedReferralConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetPersonalizedReferralConfig_Factory(provider);
    }

    public static GetPersonalizedReferralConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetPersonalizedReferralConfig(featureConfigRepository);
    }
}

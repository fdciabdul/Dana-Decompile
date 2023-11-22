package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetOnboardingWarningTextConfig_Factory implements Factory<GetOnboardingWarningTextConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetOnboardingWarningTextConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetOnboardingWarningTextConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetOnboardingWarningTextConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetOnboardingWarningTextConfig_Factory(provider);
    }

    public static GetOnboardingWarningTextConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetOnboardingWarningTextConfig(featureConfigRepository);
    }
}

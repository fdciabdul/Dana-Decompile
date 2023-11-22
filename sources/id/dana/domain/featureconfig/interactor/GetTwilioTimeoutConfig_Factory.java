package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTwilioTimeoutConfig_Factory implements Factory<GetTwilioTimeoutConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetTwilioTimeoutConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTwilioTimeoutConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetTwilioTimeoutConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetTwilioTimeoutConfig_Factory(provider);
    }

    public static GetTwilioTimeoutConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetTwilioTimeoutConfig(featureConfigRepository);
    }
}

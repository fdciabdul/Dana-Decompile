package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTwilioManualCheckConfig_Factory implements Factory<GetTwilioManualCheckConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetTwilioManualCheckConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTwilioManualCheckConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetTwilioManualCheckConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetTwilioManualCheckConfig_Factory(provider);
    }

    public static GetTwilioManualCheckConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetTwilioManualCheckConfig(featureConfigRepository);
    }
}

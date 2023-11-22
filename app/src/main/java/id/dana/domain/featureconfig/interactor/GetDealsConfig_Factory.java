package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDealsConfig_Factory implements Factory<GetDealsConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetDealsConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetDealsConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetDealsConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetDealsConfig_Factory(provider);
    }

    public static GetDealsConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetDealsConfig(featureConfigRepository);
    }
}

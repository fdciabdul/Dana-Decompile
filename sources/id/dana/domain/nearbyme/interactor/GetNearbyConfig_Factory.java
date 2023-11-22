package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetNearbyConfig_Factory implements Factory<GetNearbyConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetNearbyConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetNearbyConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetNearbyConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetNearbyConfig_Factory(provider);
    }

    public static GetNearbyConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetNearbyConfig(featureConfigRepository);
    }
}

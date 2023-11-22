package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetExpiryTimeConfig_Factory implements Factory<GetExpiryTimeConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetExpiryTimeConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetExpiryTimeConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetExpiryTimeConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetExpiryTimeConfig_Factory(provider);
    }

    public static GetExpiryTimeConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetExpiryTimeConfig(featureConfigRepository);
    }
}

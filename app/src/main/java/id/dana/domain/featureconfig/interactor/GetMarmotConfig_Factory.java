package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetMarmotConfig_Factory implements Factory<GetMarmotConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetMarmotConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMarmotConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetMarmotConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetMarmotConfig_Factory(provider);
    }

    public static GetMarmotConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetMarmotConfig(featureConfigRepository);
    }
}

package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQueryUserDataConfig_Factory implements Factory<GetQueryUserDataConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetQueryUserDataConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQueryUserDataConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetQueryUserDataConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetQueryUserDataConfig_Factory(provider);
    }

    public static GetQueryUserDataConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetQueryUserDataConfig(featureConfigRepository);
    }
}

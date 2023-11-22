package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQrisTcicoConfig_Factory implements Factory<GetQrisTcicoConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetQrisTcicoConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQrisTcicoConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetQrisTcicoConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetQrisTcicoConfig_Factory(provider);
    }

    public static GetQrisTcicoConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetQrisTcicoConfig(featureConfigRepository);
    }
}

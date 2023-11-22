package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSmartFrictionConfig_Factory implements Factory<GetSmartFrictionConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetSmartFrictionConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetSmartFrictionConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetSmartFrictionConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetSmartFrictionConfig_Factory(provider);
    }

    public static GetSmartFrictionConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetSmartFrictionConfig(featureConfigRepository);
    }
}

package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCashierNativeConfig_Factory implements Factory<GetCashierNativeConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetCashierNativeConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCashierNativeConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetCashierNativeConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetCashierNativeConfig_Factory(provider);
    }

    public static GetCashierNativeConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetCashierNativeConfig(featureConfigRepository);
    }
}

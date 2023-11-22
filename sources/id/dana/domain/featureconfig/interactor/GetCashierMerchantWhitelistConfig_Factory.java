package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetCashierMerchantWhitelistConfig_Factory implements Factory<GetCashierMerchantWhitelistConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetCashierMerchantWhitelistConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCashierMerchantWhitelistConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetCashierMerchantWhitelistConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetCashierMerchantWhitelistConfig_Factory(provider);
    }

    public static GetCashierMerchantWhitelistConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetCashierMerchantWhitelistConfig(featureConfigRepository);
    }
}

package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCustomLoading3dsUrls_Factory implements Factory<GetCustomLoading3dsUrls> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<SharedPrefCashierConfig> sharedPrefCashierConfigProvider;

    public GetCustomLoading3dsUrls_Factory(Provider<FeatureConfigRepository> provider, Provider<SharedPrefCashierConfig> provider2) {
        this.featureConfigRepositoryProvider = provider;
        this.sharedPrefCashierConfigProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetCustomLoading3dsUrls get() {
        return newInstance(this.featureConfigRepositoryProvider.get(), this.sharedPrefCashierConfigProvider.get());
    }

    public static GetCustomLoading3dsUrls_Factory create(Provider<FeatureConfigRepository> provider, Provider<SharedPrefCashierConfig> provider2) {
        return new GetCustomLoading3dsUrls_Factory(provider, provider2);
    }

    public static GetCustomLoading3dsUrls newInstance(FeatureConfigRepository featureConfigRepository, SharedPrefCashierConfig sharedPrefCashierConfig) {
        return new GetCustomLoading3dsUrls(featureConfigRepository, sharedPrefCashierConfig);
    }
}

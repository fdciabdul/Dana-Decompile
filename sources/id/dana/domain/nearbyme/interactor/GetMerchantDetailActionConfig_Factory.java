package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMerchantDetailActionConfig_Factory implements Factory<GetMerchantDetailActionConfig> {
    private final Provider<MerchantConfigRepository> merchantConfigRepositoryProvider;

    public GetMerchantDetailActionConfig_Factory(Provider<MerchantConfigRepository> provider) {
        this.merchantConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMerchantDetailActionConfig get() {
        return newInstance(this.merchantConfigRepositoryProvider.get());
    }

    public static GetMerchantDetailActionConfig_Factory create(Provider<MerchantConfigRepository> provider) {
        return new GetMerchantDetailActionConfig_Factory(provider);
    }

    public static GetMerchantDetailActionConfig newInstance(MerchantConfigRepository merchantConfigRepository) {
        return new GetMerchantDetailActionConfig(merchantConfigRepository);
    }
}

package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMerchantDetailPromoConfig_Factory implements Factory<GetMerchantDetailPromoConfig> {
    private final Provider<MerchantConfigRepository> merchantConfigRepositoryProvider;

    public GetMerchantDetailPromoConfig_Factory(Provider<MerchantConfigRepository> provider) {
        this.merchantConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMerchantDetailPromoConfig get() {
        return newInstance(this.merchantConfigRepositoryProvider.get());
    }

    public static GetMerchantDetailPromoConfig_Factory create(Provider<MerchantConfigRepository> provider) {
        return new GetMerchantDetailPromoConfig_Factory(provider);
    }

    public static GetMerchantDetailPromoConfig newInstance(MerchantConfigRepository merchantConfigRepository) {
        return new GetMerchantDetailPromoConfig(merchantConfigRepository);
    }
}

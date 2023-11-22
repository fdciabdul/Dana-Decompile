package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetMerchantDanaDeals_Factory implements Factory<GetMerchantDanaDeals> {
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public GetMerchantDanaDeals_Factory(Provider<MerchantInfoRepository> provider) {
        this.merchantInfoRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMerchantDanaDeals get() {
        return newInstance(this.merchantInfoRepositoryProvider.get());
    }

    public static GetMerchantDanaDeals_Factory create(Provider<MerchantInfoRepository> provider) {
        return new GetMerchantDanaDeals_Factory(provider);
    }

    public static GetMerchantDanaDeals newInstance(MerchantInfoRepository merchantInfoRepository) {
        return new GetMerchantDanaDeals(merchantInfoRepository);
    }
}

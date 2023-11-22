package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes8.dex */
public final class GetShopPromoAndDeals_Factory implements Factory<GetShopPromoAndDeals> {
    private final Provider<CoroutineDispatcher> defaultDispatcherProvider;
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public GetShopPromoAndDeals_Factory(Provider<MerchantInfoRepository> provider, Provider<CoroutineDispatcher> provider2) {
        this.merchantInfoRepositoryProvider = provider;
        this.defaultDispatcherProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetShopPromoAndDeals get() {
        return newInstance(this.merchantInfoRepositoryProvider.get(), this.defaultDispatcherProvider.get());
    }

    public static GetShopPromoAndDeals_Factory create(Provider<MerchantInfoRepository> provider, Provider<CoroutineDispatcher> provider2) {
        return new GetShopPromoAndDeals_Factory(provider, provider2);
    }

    public static GetShopPromoAndDeals newInstance(MerchantInfoRepository merchantInfoRepository, CoroutineDispatcher coroutineDispatcher) {
        return new GetShopPromoAndDeals(merchantInfoRepository, coroutineDispatcher);
    }
}

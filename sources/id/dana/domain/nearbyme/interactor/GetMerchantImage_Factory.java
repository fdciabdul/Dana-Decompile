package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes4.dex */
public final class GetMerchantImage_Factory implements Factory<GetMerchantImage> {
    private final Provider<CoroutineDispatcher> defaultDispatcherProvider;
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public GetMerchantImage_Factory(Provider<MerchantInfoRepository> provider, Provider<CoroutineDispatcher> provider2) {
        this.merchantInfoRepositoryProvider = provider;
        this.defaultDispatcherProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetMerchantImage get() {
        return newInstance(this.merchantInfoRepositoryProvider.get(), this.defaultDispatcherProvider.get());
    }

    public static GetMerchantImage_Factory create(Provider<MerchantInfoRepository> provider, Provider<CoroutineDispatcher> provider2) {
        return new GetMerchantImage_Factory(provider, provider2);
    }

    public static GetMerchantImage newInstance(MerchantInfoRepository merchantInfoRepository, CoroutineDispatcher coroutineDispatcher) {
        return new GetMerchantImage(merchantInfoRepository, coroutineDispatcher);
    }
}

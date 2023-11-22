package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMerchantInfo_Factory implements Factory<GetMerchantInfo> {
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public GetMerchantInfo_Factory(Provider<MerchantInfoRepository> provider) {
        this.merchantInfoRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMerchantInfo get() {
        return newInstance(this.merchantInfoRepositoryProvider.get());
    }

    public static GetMerchantInfo_Factory create(Provider<MerchantInfoRepository> provider) {
        return new GetMerchantInfo_Factory(provider);
    }

    public static GetMerchantInfo newInstance(MerchantInfoRepository merchantInfoRepository) {
        return new GetMerchantInfo(merchantInfoRepository);
    }
}

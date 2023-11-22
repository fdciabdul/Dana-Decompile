package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetHomeShoppingTnc_Factory implements Factory<GetHomeShoppingTnc> {
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public GetHomeShoppingTnc_Factory(Provider<MerchantInfoRepository> provider) {
        this.merchantInfoRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetHomeShoppingTnc get() {
        return newInstance(this.merchantInfoRepositoryProvider.get());
    }

    public static GetHomeShoppingTnc_Factory create(Provider<MerchantInfoRepository> provider) {
        return new GetHomeShoppingTnc_Factory(provider);
    }

    public static GetHomeShoppingTnc newInstance(MerchantInfoRepository merchantInfoRepository) {
        return new GetHomeShoppingTnc(merchantInfoRepository);
    }
}

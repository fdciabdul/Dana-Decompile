package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CreateDanaDealsVoucherOrder_Factory implements Factory<CreateDanaDealsVoucherOrder> {
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public CreateDanaDealsVoucherOrder_Factory(Provider<MerchantInfoRepository> provider) {
        this.merchantInfoRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CreateDanaDealsVoucherOrder get() {
        return newInstance(this.merchantInfoRepositoryProvider.get());
    }

    public static CreateDanaDealsVoucherOrder_Factory create(Provider<MerchantInfoRepository> provider) {
        return new CreateDanaDealsVoucherOrder_Factory(provider);
    }

    public static CreateDanaDealsVoucherOrder newInstance(MerchantInfoRepository merchantInfoRepository) {
        return new CreateDanaDealsVoucherOrder(merchantInfoRepository);
    }
}

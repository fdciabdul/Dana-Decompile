package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMerchantReviews_Factory implements Factory<GetMerchantReviews> {
    private final Provider<AccountRepository> accountRepositoryProvider;
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public GetMerchantReviews_Factory(Provider<MerchantInfoRepository> provider, Provider<AccountRepository> provider2) {
        this.merchantInfoRepositoryProvider = provider;
        this.accountRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetMerchantReviews get() {
        return newInstance(this.merchantInfoRepositoryProvider.get(), this.accountRepositoryProvider.get());
    }

    public static GetMerchantReviews_Factory create(Provider<MerchantInfoRepository> provider, Provider<AccountRepository> provider2) {
        return new GetMerchantReviews_Factory(provider, provider2);
    }

    public static GetMerchantReviews newInstance(MerchantInfoRepository merchantInfoRepository, AccountRepository accountRepository) {
        return new GetMerchantReviews(merchantInfoRepository, accountRepository);
    }
}

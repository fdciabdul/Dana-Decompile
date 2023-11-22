package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserPaymentWalletAsset_Factory implements Factory<GetUserPaymentWalletAsset> {
    private final Provider<AccountRepository> accountRepositoryProvider;
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetUserPaymentWalletAsset_Factory(Provider<WalletV3Repository> provider, Provider<AccountRepository> provider2) {
        this.walletV3RepositoryProvider = provider;
        this.accountRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetUserPaymentWalletAsset get() {
        return newInstance(this.walletV3RepositoryProvider.get(), this.accountRepositoryProvider.get());
    }

    public static GetUserPaymentWalletAsset_Factory create(Provider<WalletV3Repository> provider, Provider<AccountRepository> provider2) {
        return new GetUserPaymentWalletAsset_Factory(provider, provider2);
    }

    public static GetUserPaymentWalletAsset newInstance(WalletV3Repository walletV3Repository, AccountRepository accountRepository) {
        return new GetUserPaymentWalletAsset(walletV3Repository, accountRepository);
    }
}

package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserPaymentWalletAssetLocal_Factory implements Factory<GetUserPaymentWalletAssetLocal> {
    private final Provider<AccountRepository> accountRepositoryProvider;
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetUserPaymentWalletAssetLocal_Factory(Provider<WalletV3Repository> provider, Provider<AccountRepository> provider2) {
        this.walletV3RepositoryProvider = provider;
        this.accountRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetUserPaymentWalletAssetLocal get() {
        return newInstance(this.walletV3RepositoryProvider.get(), this.accountRepositoryProvider.get());
    }

    public static GetUserPaymentWalletAssetLocal_Factory create(Provider<WalletV3Repository> provider, Provider<AccountRepository> provider2) {
        return new GetUserPaymentWalletAssetLocal_Factory(provider, provider2);
    }

    public static GetUserPaymentWalletAssetLocal newInstance(WalletV3Repository walletV3Repository, AccountRepository accountRepository) {
        return new GetUserPaymentWalletAssetLocal(walletV3Repository, accountRepository);
    }
}

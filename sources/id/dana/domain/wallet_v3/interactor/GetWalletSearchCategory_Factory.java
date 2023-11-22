package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetWalletSearchCategory_Factory implements Factory<GetWalletSearchCategory> {
    private final Provider<WalletConfigRepository> walletConfigRepositoryProvider;
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetWalletSearchCategory_Factory(Provider<WalletConfigRepository> provider, Provider<WalletV3Repository> provider2) {
        this.walletConfigRepositoryProvider = provider;
        this.walletV3RepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetWalletSearchCategory get() {
        return newInstance(this.walletConfigRepositoryProvider.get(), this.walletV3RepositoryProvider.get());
    }

    public static GetWalletSearchCategory_Factory create(Provider<WalletConfigRepository> provider, Provider<WalletV3Repository> provider2) {
        return new GetWalletSearchCategory_Factory(provider, provider2);
    }

    public static GetWalletSearchCategory newInstance(WalletConfigRepository walletConfigRepository, WalletV3Repository walletV3Repository) {
        return new GetWalletSearchCategory(walletConfigRepository, walletV3Repository);
    }
}

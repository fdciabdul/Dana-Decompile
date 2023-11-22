package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetWalletSortCategory_Factory implements Factory<GetWalletSortCategory> {
    private final Provider<WalletConfigRepository> walletConfigRepositoryProvider;

    public GetWalletSortCategory_Factory(Provider<WalletConfigRepository> provider) {
        this.walletConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetWalletSortCategory get() {
        return newInstance(this.walletConfigRepositoryProvider.get());
    }

    public static GetWalletSortCategory_Factory create(Provider<WalletConfigRepository> provider) {
        return new GetWalletSortCategory_Factory(provider);
    }

    public static GetWalletSortCategory newInstance(WalletConfigRepository walletConfigRepository) {
        return new GetWalletSortCategory(walletConfigRepository);
    }
}

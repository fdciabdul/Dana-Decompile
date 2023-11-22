package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserPocketWalletAssetLocal_Factory implements Factory<GetUserPocketWalletAssetLocal> {
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetUserPocketWalletAssetLocal_Factory(Provider<WalletV3Repository> provider) {
        this.walletV3RepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserPocketWalletAssetLocal get() {
        return newInstance(this.walletV3RepositoryProvider.get());
    }

    public static GetUserPocketWalletAssetLocal_Factory create(Provider<WalletV3Repository> provider) {
        return new GetUserPocketWalletAssetLocal_Factory(provider);
    }

    public static GetUserPocketWalletAssetLocal newInstance(WalletV3Repository walletV3Repository) {
        return new GetUserPocketWalletAssetLocal(walletV3Repository);
    }
}

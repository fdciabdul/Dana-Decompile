package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserPocketWalletAsset_Factory implements Factory<GetUserPocketWalletAsset> {
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetUserPocketWalletAsset_Factory(Provider<WalletV3Repository> provider) {
        this.walletV3RepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserPocketWalletAsset get() {
        return newInstance(this.walletV3RepositoryProvider.get());
    }

    public static GetUserPocketWalletAsset_Factory create(Provider<WalletV3Repository> provider) {
        return new GetUserPocketWalletAsset_Factory(provider);
    }

    public static GetUserPocketWalletAsset newInstance(WalletV3Repository walletV3Repository) {
        return new GetUserPocketWalletAsset(walletV3Repository);
    }
}

package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserAllAssetLocal_Factory implements Factory<GetUserAllAssetLocal> {
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetUserAllAssetLocal_Factory(Provider<WalletV3Repository> provider) {
        this.walletV3RepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserAllAssetLocal get() {
        return newInstance(this.walletV3RepositoryProvider.get());
    }

    public static GetUserAllAssetLocal_Factory create(Provider<WalletV3Repository> provider) {
        return new GetUserAllAssetLocal_Factory(provider);
    }

    public static GetUserAllAssetLocal newInstance(WalletV3Repository walletV3Repository) {
        return new GetUserAllAssetLocal(walletV3Repository);
    }
}

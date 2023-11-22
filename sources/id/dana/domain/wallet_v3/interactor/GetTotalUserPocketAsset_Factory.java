package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTotalUserPocketAsset_Factory implements Factory<GetTotalUserPocketAsset> {
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetTotalUserPocketAsset_Factory(Provider<WalletV3Repository> provider) {
        this.walletV3RepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTotalUserPocketAsset get() {
        return newInstance(this.walletV3RepositoryProvider.get());
    }

    public static GetTotalUserPocketAsset_Factory create(Provider<WalletV3Repository> provider) {
        return new GetTotalUserPocketAsset_Factory(provider);
    }

    public static GetTotalUserPocketAsset newInstance(WalletV3Repository walletV3Repository) {
        return new GetTotalUserPocketAsset(walletV3Repository);
    }
}

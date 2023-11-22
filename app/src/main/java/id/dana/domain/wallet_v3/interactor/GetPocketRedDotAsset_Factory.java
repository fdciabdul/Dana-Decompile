package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPocketRedDotAsset_Factory implements Factory<GetPocketRedDotAsset> {
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetPocketRedDotAsset_Factory(Provider<WalletV3Repository> provider) {
        this.walletV3RepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPocketRedDotAsset get() {
        return newInstance(this.walletV3RepositoryProvider.get());
    }

    public static GetPocketRedDotAsset_Factory create(Provider<WalletV3Repository> provider) {
        return new GetPocketRedDotAsset_Factory(provider);
    }

    public static GetPocketRedDotAsset newInstance(WalletV3Repository walletV3Repository) {
        return new GetPocketRedDotAsset(walletV3Repository);
    }
}

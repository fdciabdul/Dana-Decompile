package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTotalUserPaymentAsset_Factory implements Factory<GetTotalUserPaymentAsset> {
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetTotalUserPaymentAsset_Factory(Provider<WalletV3Repository> provider) {
        this.walletV3RepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTotalUserPaymentAsset get() {
        return newInstance(this.walletV3RepositoryProvider.get());
    }

    public static GetTotalUserPaymentAsset_Factory create(Provider<WalletV3Repository> provider) {
        return new GetTotalUserPaymentAsset_Factory(provider);
    }

    public static GetTotalUserPaymentAsset newInstance(WalletV3Repository walletV3Repository) {
        return new GetTotalUserPaymentAsset(walletV3Repository);
    }
}

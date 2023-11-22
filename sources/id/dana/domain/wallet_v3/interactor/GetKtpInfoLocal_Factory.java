package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetKtpInfoLocal_Factory implements Factory<GetKtpInfoLocal> {
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetKtpInfoLocal_Factory(Provider<WalletV3Repository> provider) {
        this.walletV3RepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetKtpInfoLocal get() {
        return newInstance(this.walletV3RepositoryProvider.get());
    }

    public static GetKtpInfoLocal_Factory create(Provider<WalletV3Repository> provider) {
        return new GetKtpInfoLocal_Factory(provider);
    }

    public static GetKtpInfoLocal newInstance(WalletV3Repository walletV3Repository) {
        return new GetKtpInfoLocal(walletV3Repository);
    }
}

package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetWalletConfigFromLocal_Factory implements Factory<GetWalletConfigFromLocal> {
    private final Provider<WalletConfigRepository> walletConfigRepositoryProvider;

    public GetWalletConfigFromLocal_Factory(Provider<WalletConfigRepository> provider) {
        this.walletConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetWalletConfigFromLocal get() {
        return newInstance(this.walletConfigRepositoryProvider.get());
    }

    public static GetWalletConfigFromLocal_Factory create(Provider<WalletConfigRepository> provider) {
        return new GetWalletConfigFromLocal_Factory(provider);
    }

    public static GetWalletConfigFromLocal newInstance(WalletConfigRepository walletConfigRepository) {
        return new GetWalletConfigFromLocal(walletConfigRepository);
    }
}

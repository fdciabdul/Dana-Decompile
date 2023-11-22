package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetWalletConfig_Factory implements Factory<GetWalletConfig> {
    private final Provider<WalletConfigRepository> walletConfigRepositoryProvider;

    public GetWalletConfig_Factory(Provider<WalletConfigRepository> provider) {
        this.walletConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetWalletConfig get() {
        return newInstance(this.walletConfigRepositoryProvider.get());
    }

    public static GetWalletConfig_Factory create(Provider<WalletConfigRepository> provider) {
        return new GetWalletConfig_Factory(provider);
    }

    public static GetWalletConfig newInstance(WalletConfigRepository walletConfigRepository) {
        return new GetWalletConfig(walletConfigRepository);
    }
}

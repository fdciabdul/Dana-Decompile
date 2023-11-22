package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetIntervalTimeHitWalletApi_Factory implements Factory<GetIntervalTimeHitWalletApi> {
    private final Provider<WalletConfigRepository> walletConfigRepositoryProvider;

    public GetIntervalTimeHitWalletApi_Factory(Provider<WalletConfigRepository> provider) {
        this.walletConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetIntervalTimeHitWalletApi get() {
        return newInstance(this.walletConfigRepositoryProvider.get());
    }

    public static GetIntervalTimeHitWalletApi_Factory create(Provider<WalletConfigRepository> provider) {
        return new GetIntervalTimeHitWalletApi_Factory(provider);
    }

    public static GetIntervalTimeHitWalletApi newInstance(WalletConfigRepository walletConfigRepository) {
        return new GetIntervalTimeHitWalletApi(walletConfigRepository);
    }
}

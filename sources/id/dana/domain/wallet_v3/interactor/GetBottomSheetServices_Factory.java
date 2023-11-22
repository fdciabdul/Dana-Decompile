package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetBottomSheetServices_Factory implements Factory<GetBottomSheetServices> {
    private final Provider<WalletConfigRepository> repositoryProvider;

    public GetBottomSheetServices_Factory(Provider<WalletConfigRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetBottomSheetServices get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetBottomSheetServices_Factory create(Provider<WalletConfigRepository> provider) {
        return new GetBottomSheetServices_Factory(provider);
    }

    public static GetBottomSheetServices newInstance(WalletConfigRepository walletConfigRepository) {
        return new GetBottomSheetServices(walletConfigRepository);
    }
}

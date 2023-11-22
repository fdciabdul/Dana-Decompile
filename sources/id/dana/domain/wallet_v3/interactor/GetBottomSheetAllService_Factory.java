package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetBottomSheetAllService_Factory implements Factory<GetBottomSheetAllService> {
    private final Provider<WalletConfigRepository> repositoryProvider;

    public GetBottomSheetAllService_Factory(Provider<WalletConfigRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetBottomSheetAllService get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetBottomSheetAllService_Factory create(Provider<WalletConfigRepository> provider) {
        return new GetBottomSheetAllService_Factory(provider);
    }

    public static GetBottomSheetAllService newInstance(WalletConfigRepository walletConfigRepository) {
        return new GetBottomSheetAllService(walletConfigRepository);
    }
}

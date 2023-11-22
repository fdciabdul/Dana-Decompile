package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDynamicRecommendation_Factory implements Factory<GetDynamicRecommendation> {
    private final Provider<ServicesRepository> servicesRepositoryProvider;
    private final Provider<WalletConfigRepository> walletConfigRepositoryProvider;
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetDynamicRecommendation_Factory(Provider<WalletV3Repository> provider, Provider<ServicesRepository> provider2, Provider<WalletConfigRepository> provider3) {
        this.walletV3RepositoryProvider = provider;
        this.servicesRepositoryProvider = provider2;
        this.walletConfigRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetDynamicRecommendation get() {
        return newInstance(this.walletV3RepositoryProvider.get(), this.servicesRepositoryProvider.get(), this.walletConfigRepositoryProvider.get());
    }

    public static GetDynamicRecommendation_Factory create(Provider<WalletV3Repository> provider, Provider<ServicesRepository> provider2, Provider<WalletConfigRepository> provider3) {
        return new GetDynamicRecommendation_Factory(provider, provider2, provider3);
    }

    public static GetDynamicRecommendation newInstance(WalletV3Repository walletV3Repository, ServicesRepository servicesRepository, WalletConfigRepository walletConfigRepository) {
        return new GetDynamicRecommendation(walletV3Repository, servicesRepository, walletConfigRepository);
    }
}

package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import id.dana.data.config.repository.FeatureConfigEntityRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FetchCashierBanner_Factory implements Factory<FetchCashierBanner> {
    private final Provider<CashierRepository> cashierRepositoryProvider;
    private final Provider<FeatureConfigEntityRepository> featureConfigEntityRepositoryProvider;

    public FetchCashierBanner_Factory(Provider<CashierRepository> provider, Provider<FeatureConfigEntityRepository> provider2) {
        this.cashierRepositoryProvider = provider;
        this.featureConfigEntityRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final FetchCashierBanner get() {
        return newInstance(this.cashierRepositoryProvider.get(), this.featureConfigEntityRepositoryProvider.get());
    }

    public static FetchCashierBanner_Factory create(Provider<CashierRepository> provider, Provider<FeatureConfigEntityRepository> provider2) {
        return new FetchCashierBanner_Factory(provider, provider2);
    }

    public static FetchCashierBanner newInstance(CashierRepository cashierRepository, FeatureConfigEntityRepository featureConfigEntityRepository) {
        return new FetchCashierBanner(cashierRepository, featureConfigEntityRepository);
    }
}

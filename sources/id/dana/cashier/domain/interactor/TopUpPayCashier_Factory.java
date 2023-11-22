package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TopUpPayCashier_Factory implements Factory<TopUpPayCashier> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public TopUpPayCashier_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final TopUpPayCashier get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static TopUpPayCashier_Factory create(Provider<CashierRepository> provider) {
        return new TopUpPayCashier_Factory(provider);
    }

    public static TopUpPayCashier newInstance(CashierRepository cashierRepository) {
        return new TopUpPayCashier(cashierRepository);
    }
}

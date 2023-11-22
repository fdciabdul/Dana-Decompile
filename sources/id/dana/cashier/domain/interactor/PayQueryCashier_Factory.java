package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayQueryCashier_Factory implements Factory<PayQueryCashier> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public PayQueryCashier_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PayQueryCashier get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static PayQueryCashier_Factory create(Provider<CashierRepository> provider) {
        return new PayQueryCashier_Factory(provider);
    }

    public static PayQueryCashier newInstance(CashierRepository cashierRepository) {
        return new PayQueryCashier(cashierRepository);
    }
}

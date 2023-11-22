package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayCashier_Factory implements Factory<PayCashier> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public PayCashier_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PayCashier get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static PayCashier_Factory create(Provider<CashierRepository> provider) {
        return new PayCashier_Factory(provider);
    }

    public static PayCashier newInstance(CashierRepository cashierRepository) {
        return new PayCashier(cashierRepository);
    }
}

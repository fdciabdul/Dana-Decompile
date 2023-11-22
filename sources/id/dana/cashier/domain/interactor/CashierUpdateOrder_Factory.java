package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierUpdateOrder_Factory implements Factory<CashierUpdateOrder> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public CashierUpdateOrder_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CashierUpdateOrder get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static CashierUpdateOrder_Factory create(Provider<CashierRepository> provider) {
        return new CashierUpdateOrder_Factory(provider);
    }

    public static CashierUpdateOrder newInstance(CashierRepository cashierRepository) {
        return new CashierUpdateOrder(cashierRepository);
    }
}

package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CreateCashierOrder_Factory implements Factory<CreateCashierOrder> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public CreateCashierOrder_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CreateCashierOrder get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static CreateCashierOrder_Factory create(Provider<CashierRepository> provider) {
        return new CreateCashierOrder_Factory(provider);
    }

    public static CreateCashierOrder newInstance(CashierRepository cashierRepository) {
        return new CreateCashierOrder(cashierRepository);
    }
}

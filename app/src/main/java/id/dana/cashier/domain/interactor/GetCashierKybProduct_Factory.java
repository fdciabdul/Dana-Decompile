package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCashierKybProduct_Factory implements Factory<GetCashierKybProduct> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetCashierKybProduct_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCashierKybProduct get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetCashierKybProduct_Factory create(Provider<CashierRepository> provider) {
        return new GetCashierKybProduct_Factory(provider);
    }

    public static GetCashierKybProduct newInstance(CashierRepository cashierRepository) {
        return new GetCashierKybProduct(cashierRepository);
    }
}

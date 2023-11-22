package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCurrencyFromCdn_Factory implements Factory<GetCurrencyFromCdn> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetCurrencyFromCdn_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCurrencyFromCdn get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetCurrencyFromCdn_Factory create(Provider<CashierRepository> provider) {
        return new GetCurrencyFromCdn_Factory(provider);
    }

    public static GetCurrencyFromCdn newInstance(CashierRepository cashierRepository) {
        return new GetCurrencyFromCdn(cashierRepository);
    }
}

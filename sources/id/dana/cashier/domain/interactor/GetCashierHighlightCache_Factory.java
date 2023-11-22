package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCashierHighlightCache_Factory implements Factory<GetCashierHighlightCache> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetCashierHighlightCache_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCashierHighlightCache get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetCashierHighlightCache_Factory create(Provider<CashierRepository> provider) {
        return new GetCashierHighlightCache_Factory(provider);
    }

    public static GetCashierHighlightCache newInstance(CashierRepository cashierRepository) {
        return new GetCashierHighlightCache(cashierRepository);
    }
}

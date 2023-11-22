package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCashierHighlightConfig_Factory implements Factory<GetCashierHighlightConfig> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetCashierHighlightConfig_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCashierHighlightConfig get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetCashierHighlightConfig_Factory create(Provider<CashierRepository> provider) {
        return new GetCashierHighlightConfig_Factory(provider);
    }

    public static GetCashierHighlightConfig newInstance(CashierRepository cashierRepository) {
        return new GetCashierHighlightConfig(cashierRepository);
    }
}

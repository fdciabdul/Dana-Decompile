package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQueryPayOption_Factory implements Factory<GetQueryPayOption> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetQueryPayOption_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQueryPayOption get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetQueryPayOption_Factory create(Provider<CashierRepository> provider) {
        return new GetQueryPayOption_Factory(provider);
    }

    public static GetQueryPayOption newInstance(CashierRepository cashierRepository) {
        return new GetQueryPayOption(cashierRepository);
    }
}

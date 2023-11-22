package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTopUpConsult_Factory implements Factory<GetTopUpConsult> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetTopUpConsult_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTopUpConsult get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetTopUpConsult_Factory create(Provider<CashierRepository> provider) {
        return new GetTopUpConsult_Factory(provider);
    }

    public static GetTopUpConsult newInstance(CashierRepository cashierRepository) {
        return new GetTopUpConsult(cashierRepository);
    }
}

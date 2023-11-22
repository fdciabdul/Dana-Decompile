package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTopUpAgent_Factory implements Factory<GetTopUpAgent> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetTopUpAgent_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTopUpAgent get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetTopUpAgent_Factory create(Provider<CashierRepository> provider) {
        return new GetTopUpAgent_Factory(provider);
    }

    public static GetTopUpAgent newInstance(CashierRepository cashierRepository) {
        return new GetTopUpAgent(cashierRepository);
    }
}

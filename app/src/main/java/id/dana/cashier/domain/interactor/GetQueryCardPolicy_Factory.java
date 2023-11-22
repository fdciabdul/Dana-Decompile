package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQueryCardPolicy_Factory implements Factory<GetQueryCardPolicy> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetQueryCardPolicy_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQueryCardPolicy get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetQueryCardPolicy_Factory create(Provider<CashierRepository> provider) {
        return new GetQueryCardPolicy_Factory(provider);
    }

    public static GetQueryCardPolicy newInstance(CashierRepository cashierRepository) {
        return new GetQueryCardPolicy(cashierRepository);
    }
}

package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetOneklikRedirectUrl_Factory implements Factory<GetOneklikRedirectUrl> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetOneklikRedirectUrl_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetOneklikRedirectUrl get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetOneklikRedirectUrl_Factory create(Provider<CashierRepository> provider) {
        return new GetOneklikRedirectUrl_Factory(provider);
    }

    public static GetOneklikRedirectUrl newInstance(CashierRepository cashierRepository) {
        return new GetOneklikRedirectUrl(cashierRepository);
    }
}

package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCashierAddOnInfo_Factory implements Factory<GetCashierAddOnInfo> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetCashierAddOnInfo_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCashierAddOnInfo get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetCashierAddOnInfo_Factory create(Provider<CashierRepository> provider) {
        return new GetCashierAddOnInfo_Factory(provider);
    }

    public static GetCashierAddOnInfo newInstance(CashierRepository cashierRepository) {
        return new GetCashierAddOnInfo(cashierRepository);
    }
}

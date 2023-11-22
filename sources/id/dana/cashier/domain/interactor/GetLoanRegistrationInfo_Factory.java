package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetLoanRegistrationInfo_Factory implements Factory<GetLoanRegistrationInfo> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public GetLoanRegistrationInfo_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetLoanRegistrationInfo get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static GetLoanRegistrationInfo_Factory create(Provider<CashierRepository> provider) {
        return new GetLoanRegistrationInfo_Factory(provider);
    }

    public static GetLoanRegistrationInfo newInstance(CashierRepository cashierRepository) {
        return new GetLoanRegistrationInfo(cashierRepository);
    }
}

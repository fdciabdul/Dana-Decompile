package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import id.dana.domain.investment.InvestmentRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCashierCheckoutInfo_Factory implements Factory<GetCashierCheckoutInfo> {
    private final Provider<CashierRepository> cashierRepositoryProvider;
    private final Provider<InvestmentRepository> investmentRepositoryProvider;

    public GetCashierCheckoutInfo_Factory(Provider<CashierRepository> provider, Provider<InvestmentRepository> provider2) {
        this.cashierRepositoryProvider = provider;
        this.investmentRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetCashierCheckoutInfo get() {
        return newInstance(this.cashierRepositoryProvider.get(), this.investmentRepositoryProvider.get());
    }

    public static GetCashierCheckoutInfo_Factory create(Provider<CashierRepository> provider, Provider<InvestmentRepository> provider2) {
        return new GetCashierCheckoutInfo_Factory(provider, provider2);
    }

    public static GetCashierCheckoutInfo newInstance(CashierRepository cashierRepository, InvestmentRepository investmentRepository) {
        return new GetCashierCheckoutInfo(cashierRepository, investmentRepository);
    }
}

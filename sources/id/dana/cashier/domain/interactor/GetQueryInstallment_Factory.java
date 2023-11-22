package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQueryInstallment_Factory implements Factory<GetQueryInstallment> {
    private final Provider<CashierRepository> cashierRepositoryProvider;
    private final Provider<PaylaterRepository> paylaterRepositoryProvider;
    private final Provider<UserConsentRepository> userConsentRepositoryProvider;

    public GetQueryInstallment_Factory(Provider<CashierRepository> provider, Provider<UserConsentRepository> provider2, Provider<PaylaterRepository> provider3) {
        this.cashierRepositoryProvider = provider;
        this.userConsentRepositoryProvider = provider2;
        this.paylaterRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetQueryInstallment get() {
        return newInstance(this.cashierRepositoryProvider.get(), this.userConsentRepositoryProvider.get(), this.paylaterRepositoryProvider.get());
    }

    public static GetQueryInstallment_Factory create(Provider<CashierRepository> provider, Provider<UserConsentRepository> provider2, Provider<PaylaterRepository> provider3) {
        return new GetQueryInstallment_Factory(provider, provider2, provider3);
    }

    public static GetQueryInstallment newInstance(CashierRepository cashierRepository, UserConsentRepository userConsentRepository, PaylaterRepository paylaterRepository) {
        return new GetQueryInstallment(cashierRepository, userConsentRepository, paylaterRepository);
    }
}

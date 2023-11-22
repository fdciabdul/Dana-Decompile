package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CreateCashierAgreement_Factory implements Factory<CreateCashierAgreement> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public CreateCashierAgreement_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CreateCashierAgreement get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static CreateCashierAgreement_Factory create(Provider<CashierRepository> provider) {
        return new CreateCashierAgreement_Factory(provider);
    }

    public static CreateCashierAgreement newInstance(CashierRepository cashierRepository) {
        return new CreateCashierAgreement(cashierRepository);
    }
}

package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CreateCashierAgreementFlow_Factory implements Factory<CreateCashierAgreementFlow> {
    private final Provider<CreateCashierAgreement> createCashierAgreementProvider;

    public CreateCashierAgreementFlow_Factory(Provider<CreateCashierAgreement> provider) {
        this.createCashierAgreementProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CreateCashierAgreementFlow get() {
        return newInstance(this.createCashierAgreementProvider.get());
    }

    public static CreateCashierAgreementFlow_Factory create(Provider<CreateCashierAgreement> provider) {
        return new CreateCashierAgreementFlow_Factory(provider);
    }

    public static CreateCashierAgreementFlow newInstance(CreateCashierAgreement createCashierAgreement) {
        return new CreateCashierAgreementFlow(createCashierAgreement);
    }
}

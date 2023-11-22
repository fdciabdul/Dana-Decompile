package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveLastSmartpayActivationShow_Factory implements Factory<SaveLastSmartpayActivationShow> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public SaveLastSmartpayActivationShow_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveLastSmartpayActivationShow get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static SaveLastSmartpayActivationShow_Factory create(Provider<CashierRepository> provider) {
        return new SaveLastSmartpayActivationShow_Factory(provider);
    }

    public static SaveLastSmartpayActivationShow newInstance(CashierRepository cashierRepository) {
        return new SaveLastSmartpayActivationShow(cashierRepository);
    }
}

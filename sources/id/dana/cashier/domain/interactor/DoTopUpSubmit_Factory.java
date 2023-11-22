package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DoTopUpSubmit_Factory implements Factory<DoTopUpSubmit> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public DoTopUpSubmit_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DoTopUpSubmit get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static DoTopUpSubmit_Factory create(Provider<CashierRepository> provider) {
        return new DoTopUpSubmit_Factory(provider);
    }

    public static DoTopUpSubmit newInstance(CashierRepository cashierRepository) {
        return new DoTopUpSubmit(cashierRepository);
    }
}

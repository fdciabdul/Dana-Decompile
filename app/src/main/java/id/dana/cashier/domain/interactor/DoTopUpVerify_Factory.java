package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DoTopUpVerify_Factory implements Factory<DoTopUpVerify> {
    private final Provider<CashierRepository> cashierRepositoryProvider;

    public DoTopUpVerify_Factory(Provider<CashierRepository> provider) {
        this.cashierRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DoTopUpVerify get() {
        return newInstance(this.cashierRepositoryProvider.get());
    }

    public static DoTopUpVerify_Factory create(Provider<CashierRepository> provider) {
        return new DoTopUpVerify_Factory(provider);
    }

    public static DoTopUpVerify newInstance(CashierRepository cashierRepository) {
        return new DoTopUpVerify(cashierRepository);
    }
}

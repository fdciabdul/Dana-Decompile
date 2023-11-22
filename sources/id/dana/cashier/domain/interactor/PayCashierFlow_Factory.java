package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayCashierFlow_Factory implements Factory<PayCashierFlow> {
    private final Provider<PayCashier> payCashierProvider;

    public PayCashierFlow_Factory(Provider<PayCashier> provider) {
        this.payCashierProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PayCashierFlow get() {
        return newInstance(this.payCashierProvider.get());
    }

    public static PayCashierFlow_Factory create(Provider<PayCashier> provider) {
        return new PayCashierFlow_Factory(provider);
    }

    public static PayCashierFlow newInstance(PayCashier payCashier) {
        return new PayCashierFlow(payCashier);
    }
}

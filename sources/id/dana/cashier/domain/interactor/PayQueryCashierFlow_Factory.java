package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayQueryCashierFlow_Factory implements Factory<PayQueryCashierFlow> {
    private final Provider<PayQueryCashier> payQueryCashierProvider;

    public PayQueryCashierFlow_Factory(Provider<PayQueryCashier> provider) {
        this.payQueryCashierProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PayQueryCashierFlow get() {
        return newInstance(this.payQueryCashierProvider.get());
    }

    public static PayQueryCashierFlow_Factory create(Provider<PayQueryCashier> provider) {
        return new PayQueryCashierFlow_Factory(provider);
    }

    public static PayQueryCashierFlow newInstance(PayQueryCashier payQueryCashier) {
        return new PayQueryCashierFlow(payQueryCashier);
    }
}

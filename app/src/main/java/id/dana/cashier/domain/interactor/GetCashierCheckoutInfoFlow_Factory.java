package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCashierCheckoutInfoFlow_Factory implements Factory<GetCashierCheckoutInfoFlow> {
    private final Provider<GetCashierCheckoutInfo> getCashierCheckoutInfoProvider;

    public GetCashierCheckoutInfoFlow_Factory(Provider<GetCashierCheckoutInfo> provider) {
        this.getCashierCheckoutInfoProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCashierCheckoutInfoFlow get() {
        return newInstance(this.getCashierCheckoutInfoProvider.get());
    }

    public static GetCashierCheckoutInfoFlow_Factory create(Provider<GetCashierCheckoutInfo> provider) {
        return new GetCashierCheckoutInfoFlow_Factory(provider);
    }

    public static GetCashierCheckoutInfoFlow newInstance(GetCashierCheckoutInfo getCashierCheckoutInfo) {
        return new GetCashierCheckoutInfoFlow(getCashierCheckoutInfo);
    }
}

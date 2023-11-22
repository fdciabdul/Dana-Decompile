package id.dana.cashier.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierPayMethodModelMapper_Factory implements Factory<CashierPayMethodModelMapper> {
    private final Provider<CashierCheckoutModelMapper> getAuthRequestContext;

    private CashierPayMethodModelMapper_Factory(Provider<CashierCheckoutModelMapper> provider) {
        this.getAuthRequestContext = provider;
    }

    public static CashierPayMethodModelMapper_Factory getAuthRequestContext(Provider<CashierCheckoutModelMapper> provider) {
        return new CashierPayMethodModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierPayMethodModelMapper(this.getAuthRequestContext.get());
    }
}

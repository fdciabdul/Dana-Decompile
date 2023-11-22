package id.dana.cashier.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierCheckoutModelMapper_Factory implements Factory<CashierCheckoutModelMapper> {
    private final Provider<AttributeModelMapper> PlaceComponentResult;

    private CashierCheckoutModelMapper_Factory(Provider<AttributeModelMapper> provider) {
        this.PlaceComponentResult = provider;
    }

    public static CashierCheckoutModelMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<AttributeModelMapper> provider) {
        return new CashierCheckoutModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierCheckoutModelMapper(this.PlaceComponentResult.get());
    }
}

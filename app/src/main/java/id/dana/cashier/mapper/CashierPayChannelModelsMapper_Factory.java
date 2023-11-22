package id.dana.cashier.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierPayChannelModelsMapper_Factory implements Factory<CashierPayChannelModelsMapper> {
    private final Provider<VoucherCashierModelsMapper> BuiltInFictitiousFunctionClassFactory;

    private CashierPayChannelModelsMapper_Factory(Provider<VoucherCashierModelsMapper> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static CashierPayChannelModelsMapper_Factory PlaceComponentResult(Provider<VoucherCashierModelsMapper> provider) {
        return new CashierPayChannelModelsMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierPayChannelModelsMapper(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierContract;

/* loaded from: classes4.dex */
public final class CashierModule_ProvideCashierViewFactory implements Factory<CashierContract.View> {
    private final CashierModule KClassImpl$Data$declaredNonStaticMembers$2;

    private CashierModule_ProvideCashierViewFactory(CashierModule cashierModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cashierModule;
    }

    public static CashierModule_ProvideCashierViewFactory PlaceComponentResult(CashierModule cashierModule) {
        return new CashierModule_ProvideCashierViewFactory(cashierModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}

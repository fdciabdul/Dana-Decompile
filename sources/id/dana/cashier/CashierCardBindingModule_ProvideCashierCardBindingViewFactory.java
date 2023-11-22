package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierCardBindingContract;

/* loaded from: classes4.dex */
public final class CashierCardBindingModule_ProvideCashierCardBindingViewFactory implements Factory<CashierCardBindingContract.View> {
    private final CashierCardBindingModule KClassImpl$Data$declaredNonStaticMembers$2;

    private CashierCardBindingModule_ProvideCashierCardBindingViewFactory(CashierCardBindingModule cashierCardBindingModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cashierCardBindingModule;
    }

    public static CashierCardBindingModule_ProvideCashierCardBindingViewFactory BuiltInFictitiousFunctionClassFactory(CashierCardBindingModule cashierCardBindingModule) {
        return new CashierCardBindingModule_ProvideCashierCardBindingViewFactory(cashierCardBindingModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierCardBindingContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getMyBillsEntityDataFactory());
    }
}

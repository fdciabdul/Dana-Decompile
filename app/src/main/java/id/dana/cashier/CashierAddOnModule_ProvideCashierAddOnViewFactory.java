package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierAddOnContract;

/* loaded from: classes4.dex */
public final class CashierAddOnModule_ProvideCashierAddOnViewFactory implements Factory<CashierAddOnContract.View> {
    private final CashierAddOnModule KClassImpl$Data$declaredNonStaticMembers$2;

    private CashierAddOnModule_ProvideCashierAddOnViewFactory(CashierAddOnModule cashierAddOnModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cashierAddOnModule;
    }

    public static CashierAddOnModule_ProvideCashierAddOnViewFactory BuiltInFictitiousFunctionClassFactory(CashierAddOnModule cashierAddOnModule) {
        return new CashierAddOnModule_ProvideCashierAddOnViewFactory(cashierAddOnModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierAddOnContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getGetAuthRequestContext());
    }
}

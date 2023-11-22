package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierUserRelatedContract;

/* loaded from: classes4.dex */
public final class CashierUserRelatedModule_ProvideCashierUserRelatedViewFactory implements Factory<CashierUserRelatedContract.View> {
    private final CashierUserRelatedModule getAuthRequestContext;

    private CashierUserRelatedModule_ProvideCashierUserRelatedViewFactory(CashierUserRelatedModule cashierUserRelatedModule) {
        this.getAuthRequestContext = cashierUserRelatedModule;
    }

    public static CashierUserRelatedModule_ProvideCashierUserRelatedViewFactory BuiltInFictitiousFunctionClassFactory(CashierUserRelatedModule cashierUserRelatedModule) {
        return new CashierUserRelatedModule_ProvideCashierUserRelatedViewFactory(cashierUserRelatedModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierUserRelatedContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}

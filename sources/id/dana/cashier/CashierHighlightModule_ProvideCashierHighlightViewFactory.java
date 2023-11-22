package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierHighlightContract;

/* loaded from: classes4.dex */
public final class CashierHighlightModule_ProvideCashierHighlightViewFactory implements Factory<CashierHighlightContract.View> {
    private final CashierHighlightModule getAuthRequestContext;

    private CashierHighlightModule_ProvideCashierHighlightViewFactory(CashierHighlightModule cashierHighlightModule) {
        this.getAuthRequestContext = cashierHighlightModule;
    }

    public static CashierHighlightModule_ProvideCashierHighlightViewFactory MyBillsEntityDataFactory(CashierHighlightModule cashierHighlightModule) {
        return new CashierHighlightModule_ProvideCashierHighlightViewFactory(cashierHighlightModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierHighlightContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getBuiltInFictitiousFunctionClassFactory());
    }
}

package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierPayLaterContract;

/* loaded from: classes4.dex */
public final class CashierPayLaterModule_ProvideCashierPayLaterViewFactory implements Factory<CashierPayLaterContract.View> {
    private final CashierPayLaterModule MyBillsEntityDataFactory;

    private CashierPayLaterModule_ProvideCashierPayLaterViewFactory(CashierPayLaterModule cashierPayLaterModule) {
        this.MyBillsEntityDataFactory = cashierPayLaterModule;
    }

    public static CashierPayLaterModule_ProvideCashierPayLaterViewFactory getAuthRequestContext(CashierPayLaterModule cashierPayLaterModule) {
        return new CashierPayLaterModule_ProvideCashierPayLaterViewFactory(cashierPayLaterModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierPayLaterContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getGetAuthRequestContext());
    }
}

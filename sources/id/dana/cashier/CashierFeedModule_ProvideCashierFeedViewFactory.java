package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierFeedContract;

/* loaded from: classes4.dex */
public final class CashierFeedModule_ProvideCashierFeedViewFactory implements Factory<CashierFeedContract.View> {
    private final CashierFeedModule BuiltInFictitiousFunctionClassFactory;

    private CashierFeedModule_ProvideCashierFeedViewFactory(CashierFeedModule cashierFeedModule) {
        this.BuiltInFictitiousFunctionClassFactory = cashierFeedModule;
    }

    public static CashierFeedModule_ProvideCashierFeedViewFactory getAuthRequestContext(CashierFeedModule cashierFeedModule) {
        return new CashierFeedModule_ProvideCashierFeedViewFactory(cashierFeedModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierFeedContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}

package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierAnalyticModule_ProvideCashierAnalyticTrackerFactory implements Factory<CashierAnalyticTracker> {
    private final CashierAnalyticModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> getAuthRequestContext;

    public static CashierAnalyticTracker KClassImpl$Data$declaredNonStaticMembers$2(CashierAnalyticModule cashierAnalyticModule, Context context) {
        return (CashierAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(cashierAnalyticModule.MyBillsEntityDataFactory(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}

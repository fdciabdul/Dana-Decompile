package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayResultModule_ProvideCashierAnalyticTrackerFactory implements Factory<CashierAnalyticTracker> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final PayResultModule PlaceComponentResult;

    public static CashierAnalyticTracker BuiltInFictitiousFunctionClassFactory(PayResultModule payResultModule, Context context) {
        return (CashierAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(payResultModule.BuiltInFictitiousFunctionClassFactory(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

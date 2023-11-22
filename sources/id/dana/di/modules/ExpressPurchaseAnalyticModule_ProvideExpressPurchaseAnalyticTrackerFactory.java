package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.expresspurchase.tracker.ExpressPurchaseAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ExpressPurchaseAnalyticModule_ProvideExpressPurchaseAnalyticTrackerFactory implements Factory<ExpressPurchaseAnalyticTracker> {
    private final ExpressPurchaseAnalyticModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    public static ExpressPurchaseAnalyticTracker MyBillsEntityDataFactory(ExpressPurchaseAnalyticModule expressPurchaseAnalyticModule, Context context) {
        return (ExpressPurchaseAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(expressPurchaseAnalyticModule.MyBillsEntityDataFactory(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ExpressPurchaseAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

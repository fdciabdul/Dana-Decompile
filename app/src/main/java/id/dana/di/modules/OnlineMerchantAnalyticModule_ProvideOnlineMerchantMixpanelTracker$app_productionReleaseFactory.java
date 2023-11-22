package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OnlineMerchantAnalyticModule_ProvideOnlineMerchantMixpanelTracker$app_productionReleaseFactory implements Factory<OnlineMerchantAnalyticTracker> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final OnlineMerchantAnalyticModule PlaceComponentResult;

    public static OnlineMerchantAnalyticTracker PlaceComponentResult(OnlineMerchantAnalyticModule onlineMerchantAnalyticModule, Context context) {
        return (OnlineMerchantAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(onlineMerchantAnalyticModule.MyBillsEntityDataFactory(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OnlineMerchantAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

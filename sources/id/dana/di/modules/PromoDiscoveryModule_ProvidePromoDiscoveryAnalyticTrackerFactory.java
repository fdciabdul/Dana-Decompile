package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.promodiscovery.tracker.PromoDiscoveryAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PromoDiscoveryModule_ProvidePromoDiscoveryAnalyticTrackerFactory implements Factory<PromoDiscoveryAnalyticTracker> {
    private final PromoDiscoveryModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> PlaceComponentResult;

    public static PromoDiscoveryAnalyticTracker getAuthRequestContext(PromoDiscoveryModule promoDiscoveryModule, Context context) {
        return (PromoDiscoveryAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(promoDiscoveryModule.PlaceComponentResult(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoDiscoveryAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}

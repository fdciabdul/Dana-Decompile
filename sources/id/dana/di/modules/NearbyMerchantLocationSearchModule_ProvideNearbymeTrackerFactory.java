package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NearbyMerchantLocationSearchModule_ProvideNearbymeTrackerFactory implements Factory<NearbyAnalyticTracker> {
    private final Provider<NearbyDefaultTracker> PlaceComponentResult;
    private final NearbyMerchantLocationSearchModule getAuthRequestContext;

    private NearbyMerchantLocationSearchModule_ProvideNearbymeTrackerFactory(NearbyMerchantLocationSearchModule nearbyMerchantLocationSearchModule, Provider<NearbyDefaultTracker> provider) {
        this.getAuthRequestContext = nearbyMerchantLocationSearchModule;
        this.PlaceComponentResult = provider;
    }

    public static NearbyMerchantLocationSearchModule_ProvideNearbymeTrackerFactory BuiltInFictitiousFunctionClassFactory(NearbyMerchantLocationSearchModule nearbyMerchantLocationSearchModule, Provider<NearbyDefaultTracker> provider) {
        return new NearbyMerchantLocationSearchModule_ProvideNearbymeTrackerFactory(nearbyMerchantLocationSearchModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}

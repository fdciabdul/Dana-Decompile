package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NearbyMeModule_ProvideNearbymeTrackerFactory implements Factory<NearbyAnalyticTracker> {
    private final Provider<NearbyDefaultTracker> BuiltInFictitiousFunctionClassFactory;
    private final NearbyMeModule KClassImpl$Data$declaredNonStaticMembers$2;

    private NearbyMeModule_ProvideNearbymeTrackerFactory(NearbyMeModule nearbyMeModule, Provider<NearbyDefaultTracker> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = nearbyMeModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static NearbyMeModule_ProvideNearbymeTrackerFactory getAuthRequestContext(NearbyMeModule nearbyMeModule, Provider<NearbyDefaultTracker> provider) {
        return new NearbyMeModule_ProvideNearbymeTrackerFactory(nearbyMeModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

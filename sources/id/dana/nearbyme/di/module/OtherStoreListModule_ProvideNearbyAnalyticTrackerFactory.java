package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class OtherStoreListModule_ProvideNearbyAnalyticTrackerFactory implements Factory<NearbyAnalyticTracker> {
    private final OtherStoreListModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<NearbyDefaultTracker> PlaceComponentResult;

    public static NearbyAnalyticTracker KClassImpl$Data$declaredNonStaticMembers$2(OtherStoreListModule otherStoreListModule, NearbyDefaultTracker nearbyDefaultTracker) {
        return (NearbyAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(otherStoreListModule.KClassImpl$Data$declaredNonStaticMembers$2(nearbyDefaultTracker));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}

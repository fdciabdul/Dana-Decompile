package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyReviewModule_ProvideNearbyAnalyticTrackerFactory implements Factory<NearbyAnalyticTracker> {
    private final Provider<NearbyDefaultTracker> PlaceComponentResult;
    private final MyReviewModule getAuthRequestContext;

    public static NearbyAnalyticTracker KClassImpl$Data$declaredNonStaticMembers$2(MyReviewModule myReviewModule, NearbyDefaultTracker nearbyDefaultTracker) {
        return (NearbyAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(myReviewModule.PlaceComponentResult(nearbyDefaultTracker));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}

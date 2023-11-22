package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class NewNearbyMeModule_ProvideNearbymeTrackerFactory implements Factory<NearbyAnalyticTracker> {
    private final NewNearbyMeModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<NearbyDefaultTracker> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}

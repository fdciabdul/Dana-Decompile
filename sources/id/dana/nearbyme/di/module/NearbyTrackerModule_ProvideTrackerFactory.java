package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NearbyTrackerModule_ProvideTrackerFactory implements Factory<NearbyAnalyticTracker> {
    private final Provider<NearbyDefaultTracker> BuiltInFictitiousFunctionClassFactory;
    private final NearbyTrackerModule getAuthRequestContext;

    private NearbyTrackerModule_ProvideTrackerFactory(NearbyTrackerModule nearbyTrackerModule, Provider<NearbyDefaultTracker> provider) {
        this.getAuthRequestContext = nearbyTrackerModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static NearbyTrackerModule_ProvideTrackerFactory MyBillsEntityDataFactory(NearbyTrackerModule nearbyTrackerModule, Provider<NearbyDefaultTracker> provider) {
        return new NearbyTrackerModule_ProvideTrackerFactory(nearbyTrackerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

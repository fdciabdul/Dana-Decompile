package id.dana.analytics.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;

/* loaded from: classes.dex */
public final class TrackerModule_ProvideFirebasePerformanceMonitorFactory implements Factory<FirebasePerformanceMonitor> {
    private final TrackerModule BuiltInFictitiousFunctionClassFactory;

    private TrackerModule_ProvideFirebasePerformanceMonitorFactory(TrackerModule trackerModule) {
        this.BuiltInFictitiousFunctionClassFactory = trackerModule;
    }

    public static TrackerModule_ProvideFirebasePerformanceMonitorFactory PlaceComponentResult(TrackerModule trackerModule) {
        return new TrackerModule_ProvideFirebasePerformanceMonitorFactory(trackerModule);
    }

    public static FirebasePerformanceMonitor getAuthRequestContext(TrackerModule trackerModule) {
        return (FirebasePerformanceMonitor) Preconditions.BuiltInFictitiousFunctionClassFactory(trackerModule.PlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FirebasePerformanceMonitor) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult());
    }
}

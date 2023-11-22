package id.dana.analytics.firebase;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.analytics.tracker.EventTrackerQueue;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class FirebaseAnalytics_Factory implements Factory<FirebaseAnalytics> {
    private final Provider<EventTrackerQueue> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<FirebasePerformanceMonitor> PlaceComponentResult;

    private FirebaseAnalytics_Factory(Provider<Context> provider, Provider<FirebasePerformanceMonitor> provider2, Provider<EventTrackerQueue> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static FirebaseAnalytics_Factory PlaceComponentResult(Provider<Context> provider, Provider<FirebasePerformanceMonitor> provider2, Provider<EventTrackerQueue> provider3) {
        return new FirebaseAnalytics_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FirebaseAnalytics(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

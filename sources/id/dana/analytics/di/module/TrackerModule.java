package id.dana.analytics.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.EventTrackerQueue;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/analytics/di/module/TrackerModule;", "", "Lid/dana/analytics/tracker/EventTrackerQueue;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/analytics/tracker/EventTrackerQueue;", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "PlaceComponentResult", "()Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes.dex */
public final class TrackerModule {
    @Provides
    public final FirebasePerformanceMonitor PlaceComponentResult() {
        return FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
    }

    @Provides
    public final EventTrackerQueue BuiltInFictitiousFunctionClassFactory() {
        EventTrackerQueue BuiltInFictitiousFunctionClassFactory;
        EventTrackerQueue.Companion companion = EventTrackerQueue.INSTANCE;
        BuiltInFictitiousFunctionClassFactory = EventTrackerQueue.Companion.BuiltInFictitiousFunctionClassFactory();
        return BuiltInFictitiousFunctionClassFactory;
    }
}

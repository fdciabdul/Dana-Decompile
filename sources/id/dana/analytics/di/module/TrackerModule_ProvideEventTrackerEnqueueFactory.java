package id.dana.analytics.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.analytics.tracker.EventTrackerQueue;

/* loaded from: classes.dex */
public final class TrackerModule_ProvideEventTrackerEnqueueFactory implements Factory<EventTrackerQueue> {
    private final TrackerModule PlaceComponentResult;

    private TrackerModule_ProvideEventTrackerEnqueueFactory(TrackerModule trackerModule) {
        this.PlaceComponentResult = trackerModule;
    }

    public static TrackerModule_ProvideEventTrackerEnqueueFactory MyBillsEntityDataFactory(TrackerModule trackerModule) {
        return new TrackerModule_ProvideEventTrackerEnqueueFactory(trackerModule);
    }

    public static EventTrackerQueue PlaceComponentResult(TrackerModule trackerModule) {
        return (EventTrackerQueue) Preconditions.BuiltInFictitiousFunctionClassFactory(trackerModule.BuiltInFictitiousFunctionClassFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (EventTrackerQueue) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
    }
}

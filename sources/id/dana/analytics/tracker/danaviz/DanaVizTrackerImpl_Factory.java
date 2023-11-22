package id.dana.analytics.tracker.danaviz;

import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanaVizTrackerImpl_Factory implements Factory<DanaVizTrackerImpl> {
    private final Provider<AnalyticsTrackerFactory> getAuthRequestContext;

    private DanaVizTrackerImpl_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.getAuthRequestContext = provider;
    }

    public static DanaVizTrackerImpl_Factory PlaceComponentResult(Provider<AnalyticsTrackerFactory> provider) {
        return new DanaVizTrackerImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaVizTrackerImpl(this.getAuthRequestContext.get());
    }
}

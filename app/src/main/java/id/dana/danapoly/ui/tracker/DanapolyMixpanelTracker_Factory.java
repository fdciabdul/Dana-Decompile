package id.dana.danapoly.ui.tracker;

import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyMixpanelTracker_Factory implements Factory<DanapolyMixpanelTracker> {
    private final Provider<AnalyticsTrackerFactory> getAuthRequestContext;

    private DanapolyMixpanelTracker_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.getAuthRequestContext = provider;
    }

    public static DanapolyMixpanelTracker_Factory getAuthRequestContext(Provider<AnalyticsTrackerFactory> provider) {
        return new DanapolyMixpanelTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyMixpanelTracker(this.getAuthRequestContext.get());
    }
}

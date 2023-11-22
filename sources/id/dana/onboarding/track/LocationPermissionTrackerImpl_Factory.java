package id.dana.onboarding.track;

import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LocationPermissionTrackerImpl_Factory implements Factory<LocationPermissionTrackerImpl> {
    private final Provider<AnalyticsTrackerFactory> getAuthRequestContext;

    private LocationPermissionTrackerImpl_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.getAuthRequestContext = provider;
    }

    public static LocationPermissionTrackerImpl_Factory MyBillsEntityDataFactory(Provider<AnalyticsTrackerFactory> provider) {
        return new LocationPermissionTrackerImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocationPermissionTrackerImpl(this.getAuthRequestContext.get());
    }
}

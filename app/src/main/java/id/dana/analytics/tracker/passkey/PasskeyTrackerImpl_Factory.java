package id.dana.analytics.tracker.passkey;

import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PasskeyTrackerImpl_Factory implements Factory<PasskeyTrackerImpl> {
    private final Provider<AnalyticsTrackerFactory> getAuthRequestContext;

    private PasskeyTrackerImpl_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.getAuthRequestContext = provider;
    }

    public static PasskeyTrackerImpl_Factory getAuthRequestContext(Provider<AnalyticsTrackerFactory> provider) {
        return new PasskeyTrackerImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PasskeyTrackerImpl(this.getAuthRequestContext.get());
    }
}

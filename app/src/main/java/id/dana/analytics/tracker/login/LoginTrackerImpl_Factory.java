package id.dana.analytics.tracker.login;

import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LoginTrackerImpl_Factory implements Factory<LoginTrackerImpl> {
    private final Provider<AnalyticsTrackerFactory> BuiltInFictitiousFunctionClassFactory;

    private LoginTrackerImpl_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static LoginTrackerImpl_Factory getAuthRequestContext(Provider<AnalyticsTrackerFactory> provider) {
        return new LoginTrackerImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LoginTrackerImpl(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

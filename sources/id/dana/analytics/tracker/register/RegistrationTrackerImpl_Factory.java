package id.dana.analytics.tracker.register;

import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RegistrationTrackerImpl_Factory implements Factory<RegistrationTrackerImpl> {
    private final Provider<AnalyticsTrackerFactory> MyBillsEntityDataFactory;

    private RegistrationTrackerImpl_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static RegistrationTrackerImpl_Factory BuiltInFictitiousFunctionClassFactory(Provider<AnalyticsTrackerFactory> provider) {
        return new RegistrationTrackerImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RegistrationTrackerImpl(this.MyBillsEntityDataFactory.get());
    }
}

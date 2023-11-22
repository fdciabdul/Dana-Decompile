package id.dana.analytics.tracker.createpin;

import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InputConfirmPinTrackerImpl_Factory implements Factory<InputConfirmPinTrackerImpl> {
    private final Provider<AnalyticsTrackerFactory> PlaceComponentResult;

    private InputConfirmPinTrackerImpl_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.PlaceComponentResult = provider;
    }

    public static InputConfirmPinTrackerImpl_Factory MyBillsEntityDataFactory(Provider<AnalyticsTrackerFactory> provider) {
        return new InputConfirmPinTrackerImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InputConfirmPinTrackerImpl(this.PlaceComponentResult.get());
    }
}

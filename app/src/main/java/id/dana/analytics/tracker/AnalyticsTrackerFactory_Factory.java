package id.dana.analytics.tracker;

import dagger.internal.Factory;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.fullstory.FullStoryAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AnalyticsTrackerFactory_Factory implements Factory<AnalyticsTrackerFactory> {
    private final Provider<FirebaseAnalytics> MyBillsEntityDataFactory;
    private final Provider<FullStoryAnalytics> PlaceComponentResult;
    private final Provider<MixpanelAnalytics> getAuthRequestContext;

    private AnalyticsTrackerFactory_Factory(Provider<FirebaseAnalytics> provider, Provider<MixpanelAnalytics> provider2, Provider<FullStoryAnalytics> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static AnalyticsTrackerFactory_Factory PlaceComponentResult(Provider<FirebaseAnalytics> provider, Provider<MixpanelAnalytics> provider2, Provider<FullStoryAnalytics> provider3) {
        return new AnalyticsTrackerFactory_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AnalyticsTrackerFactory(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}

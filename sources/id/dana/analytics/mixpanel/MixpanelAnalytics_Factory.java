package id.dana.analytics.mixpanel;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.analytics.tracker.EventTrackerQueue;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class MixpanelAnalytics_Factory implements Factory<MixpanelAnalytics> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<EventTrackerQueue> PlaceComponentResult;

    private MixpanelAnalytics_Factory(Provider<Context> provider, Provider<EventTrackerQueue> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.PlaceComponentResult = provider2;
    }

    public static MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<EventTrackerQueue> provider2) {
        return new MixpanelAnalytics_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MixpanelAnalytics(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}

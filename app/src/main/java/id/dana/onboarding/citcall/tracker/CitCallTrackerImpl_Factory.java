package id.dana.onboarding.citcall.tracker;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class CitCallTrackerImpl_Factory implements Factory<CitCallTrackerImpl> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AnalyticsTrackerFactory> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CitCallTrackerImpl(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

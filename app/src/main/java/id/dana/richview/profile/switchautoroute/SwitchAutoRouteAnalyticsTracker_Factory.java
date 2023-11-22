package id.dana.richview.profile.switchautoroute;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SwitchAutoRouteAnalyticsTracker_Factory implements Factory<SwitchAutoRouteAnalyticsTracker> {
    private final Provider<Context> PlaceComponentResult;

    private SwitchAutoRouteAnalyticsTracker_Factory(Provider<Context> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SwitchAutoRouteAnalyticsTracker_Factory getAuthRequestContext(Provider<Context> provider) {
        return new SwitchAutoRouteAnalyticsTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SwitchAutoRouteAnalyticsTracker(this.PlaceComponentResult.get());
    }
}

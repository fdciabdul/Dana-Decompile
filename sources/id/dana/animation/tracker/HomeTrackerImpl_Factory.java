package id.dana.animation.tracker;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class HomeTrackerImpl_Factory implements Factory<HomeTrackerImpl> {
    private final Provider<AnalyticsTrackerFactory> KClassImpl$Data$declaredNonStaticMembers$2;

    private HomeTrackerImpl_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static HomeTrackerImpl_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<AnalyticsTrackerFactory> provider) {
        return new HomeTrackerImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomeTrackerImpl(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}

package id.dana.animation.danaprotection.tracker;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DanaProtectionTrackerImpl_Factory implements Factory<DanaProtectionTrackerImpl> {
    private final Provider<AnalyticsTrackerFactory> KClassImpl$Data$declaredNonStaticMembers$2;

    private DanaProtectionTrackerImpl_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static DanaProtectionTrackerImpl_Factory MyBillsEntityDataFactory(Provider<AnalyticsTrackerFactory> provider) {
        return new DanaProtectionTrackerImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaProtectionTrackerImpl(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}

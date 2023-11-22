package id.dana.wallet_v3.tracker;

import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class WalletV3TrackerImpl_Factory implements Factory<WalletV3TrackerImpl> {
    private final Provider<AnalyticsTrackerFactory> anyAnalyticsFactoryProvider;

    public WalletV3TrackerImpl_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.anyAnalyticsFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final WalletV3TrackerImpl get() {
        return newInstance(this.anyAnalyticsFactoryProvider.get());
    }

    public static WalletV3TrackerImpl_Factory create(Provider<AnalyticsTrackerFactory> provider) {
        return new WalletV3TrackerImpl_Factory(provider);
    }

    public static WalletV3TrackerImpl newInstance(AnalyticsTrackerFactory analyticsTrackerFactory) {
        return new WalletV3TrackerImpl(analyticsTrackerFactory);
    }
}

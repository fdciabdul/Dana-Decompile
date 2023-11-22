package id.dana.transferaccount.tracker;

import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class TransferAccountTrackerImpl_Factory implements Factory<TransferAccountTrackerImpl> {
    private final Provider<AnalyticsTrackerFactory> getAuthRequestContext;

    private TransferAccountTrackerImpl_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.getAuthRequestContext = provider;
    }

    public static TransferAccountTrackerImpl_Factory MyBillsEntityDataFactory(Provider<AnalyticsTrackerFactory> provider) {
        return new TransferAccountTrackerImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferAccountTrackerImpl(this.getAuthRequestContext.get());
    }
}

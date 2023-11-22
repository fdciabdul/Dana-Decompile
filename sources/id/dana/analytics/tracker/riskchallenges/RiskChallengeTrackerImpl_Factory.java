package id.dana.analytics.tracker.riskchallenges;

import dagger.internal.Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RiskChallengeTrackerImpl_Factory implements Factory<RiskChallengeTrackerImpl> {
    private final Provider<AnalyticsTrackerFactory> getAuthRequestContext;

    private RiskChallengeTrackerImpl_Factory(Provider<AnalyticsTrackerFactory> provider) {
        this.getAuthRequestContext = provider;
    }

    public static RiskChallengeTrackerImpl_Factory getAuthRequestContext(Provider<AnalyticsTrackerFactory> provider) {
        return new RiskChallengeTrackerImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RiskChallengeTrackerImpl(this.getAuthRequestContext.get());
    }
}

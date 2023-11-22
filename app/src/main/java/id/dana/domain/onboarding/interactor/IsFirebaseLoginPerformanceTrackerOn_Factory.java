package id.dana.domain.onboarding.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsFirebaseLoginPerformanceTrackerOn_Factory implements Factory<IsFirebaseLoginPerformanceTrackerOn> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public IsFirebaseLoginPerformanceTrackerOn_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsFirebaseLoginPerformanceTrackerOn get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static IsFirebaseLoginPerformanceTrackerOn_Factory create(Provider<FeatureConfigRepository> provider) {
        return new IsFirebaseLoginPerformanceTrackerOn_Factory(provider);
    }

    public static IsFirebaseLoginPerformanceTrackerOn newInstance(FeatureConfigRepository featureConfigRepository) {
        return new IsFirebaseLoginPerformanceTrackerOn(featureConfigRepository);
    }
}

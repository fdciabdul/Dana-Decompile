package id.dana.domain.onboarding.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsFirebaseRegisterPerformanceTrackerOn_Factory implements Factory<IsFirebaseRegisterPerformanceTrackerOn> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public IsFirebaseRegisterPerformanceTrackerOn_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsFirebaseRegisterPerformanceTrackerOn get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static IsFirebaseRegisterPerformanceTrackerOn_Factory create(Provider<FeatureConfigRepository> provider) {
        return new IsFirebaseRegisterPerformanceTrackerOn_Factory(provider);
    }

    public static IsFirebaseRegisterPerformanceTrackerOn newInstance(FeatureConfigRepository featureConfigRepository) {
        return new IsFirebaseRegisterPerformanceTrackerOn(featureConfigRepository);
    }
}

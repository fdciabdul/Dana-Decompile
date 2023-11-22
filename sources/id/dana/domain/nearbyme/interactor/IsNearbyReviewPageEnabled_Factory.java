package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsNearbyReviewPageEnabled_Factory implements Factory<IsNearbyReviewPageEnabled> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public IsNearbyReviewPageEnabled_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsNearbyReviewPageEnabled get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static IsNearbyReviewPageEnabled_Factory create(Provider<FeatureConfigRepository> provider) {
        return new IsNearbyReviewPageEnabled_Factory(provider);
    }

    public static IsNearbyReviewPageEnabled newInstance(FeatureConfigRepository featureConfigRepository) {
        return new IsNearbyReviewPageEnabled(featureConfigRepository);
    }
}

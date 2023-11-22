package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckNearbyMeMapFeature_Factory implements Factory<CheckNearbyMeMapFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckNearbyMeMapFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckNearbyMeMapFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckNearbyMeMapFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckNearbyMeMapFeature_Factory(provider);
    }

    public static CheckNearbyMeMapFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckNearbyMeMapFeature(featureConfigRepository);
    }
}

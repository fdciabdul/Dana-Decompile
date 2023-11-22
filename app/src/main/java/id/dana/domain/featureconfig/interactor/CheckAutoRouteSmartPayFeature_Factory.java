package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckAutoRouteSmartPayFeature_Factory implements Factory<CheckAutoRouteSmartPayFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckAutoRouteSmartPayFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckAutoRouteSmartPayFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckAutoRouteSmartPayFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckAutoRouteSmartPayFeature_Factory(provider);
    }

    public static CheckAutoRouteSmartPayFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckAutoRouteSmartPayFeature(featureConfigRepository);
    }
}

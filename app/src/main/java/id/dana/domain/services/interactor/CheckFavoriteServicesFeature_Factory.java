package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckFavoriteServicesFeature_Factory implements Factory<CheckFavoriteServicesFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckFavoriteServicesFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckFavoriteServicesFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckFavoriteServicesFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckFavoriteServicesFeature_Factory(provider);
    }

    public static CheckFavoriteServicesFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckFavoriteServicesFeature(featureConfigRepository);
    }
}

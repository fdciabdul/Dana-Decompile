package id.dana.domain.promocenter.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetPromoAdsConfigFeature_Factory implements Factory<GetPromoAdsConfigFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetPromoAdsConfigFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPromoAdsConfigFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetPromoAdsConfigFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetPromoAdsConfigFeature_Factory(provider);
    }

    public static GetPromoAdsConfigFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetPromoAdsConfigFeature(featureConfigRepository);
    }
}

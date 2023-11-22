package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckInterstitialBannerFeature_Factory implements Factory<CheckInterstitialBannerFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckInterstitialBannerFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckInterstitialBannerFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckInterstitialBannerFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckInterstitialBannerFeature_Factory(provider);
    }

    public static CheckInterstitialBannerFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckInterstitialBannerFeature(featureConfigRepository);
    }
}

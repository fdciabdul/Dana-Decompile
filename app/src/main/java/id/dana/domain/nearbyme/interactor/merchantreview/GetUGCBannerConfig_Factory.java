package id.dana.domain.nearbyme.interactor.merchantreview;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUGCBannerConfig_Factory implements Factory<GetUGCBannerConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetUGCBannerConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUGCBannerConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetUGCBannerConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetUGCBannerConfig_Factory(provider);
    }

    public static GetUGCBannerConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetUGCBannerConfig(featureConfigRepository);
    }
}

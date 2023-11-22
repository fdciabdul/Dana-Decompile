package id.dana.domain.sendmoney.x2l.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSendToLinkBannerConfig_Factory implements Factory<GetSendToLinkBannerConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetSendToLinkBannerConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetSendToLinkBannerConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetSendToLinkBannerConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetSendToLinkBannerConfig_Factory(provider);
    }

    public static GetSendToLinkBannerConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetSendToLinkBannerConfig(featureConfigRepository);
    }
}

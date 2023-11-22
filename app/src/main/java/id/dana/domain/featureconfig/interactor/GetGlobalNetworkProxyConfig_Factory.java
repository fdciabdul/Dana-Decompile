package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetGlobalNetworkProxyConfig_Factory implements Factory<GetGlobalNetworkProxyConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetGlobalNetworkProxyConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetGlobalNetworkProxyConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetGlobalNetworkProxyConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetGlobalNetworkProxyConfig_Factory(provider);
    }

    public static GetGlobalNetworkProxyConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetGlobalNetworkProxyConfig(featureConfigRepository);
    }
}

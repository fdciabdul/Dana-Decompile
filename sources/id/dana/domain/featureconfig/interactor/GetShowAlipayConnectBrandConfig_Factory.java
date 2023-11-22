package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetShowAlipayConnectBrandConfig_Factory implements Factory<GetShowAlipayConnectBrandConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetShowAlipayConnectBrandConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetShowAlipayConnectBrandConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetShowAlipayConnectBrandConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetShowAlipayConnectBrandConfig_Factory(provider);
    }

    public static GetShowAlipayConnectBrandConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetShowAlipayConnectBrandConfig(featureConfigRepository);
    }
}

package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDanaProtectionWidgetConfig_Factory implements Factory<GetDanaProtectionWidgetConfig> {
    private final Provider<DanaProtectionInfoRepository> danaProtectionInfoRepositoryProvider;
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetDanaProtectionWidgetConfig_Factory(Provider<FeatureConfigRepository> provider, Provider<DanaProtectionInfoRepository> provider2) {
        this.featureConfigRepositoryProvider = provider;
        this.danaProtectionInfoRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetDanaProtectionWidgetConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get(), this.danaProtectionInfoRepositoryProvider.get());
    }

    public static GetDanaProtectionWidgetConfig_Factory create(Provider<FeatureConfigRepository> provider, Provider<DanaProtectionInfoRepository> provider2) {
        return new GetDanaProtectionWidgetConfig_Factory(provider, provider2);
    }

    public static GetDanaProtectionWidgetConfig newInstance(FeatureConfigRepository featureConfigRepository, DanaProtectionInfoRepository danaProtectionInfoRepository) {
        return new GetDanaProtectionWidgetConfig(featureConfigRepository, danaProtectionInfoRepository);
    }
}

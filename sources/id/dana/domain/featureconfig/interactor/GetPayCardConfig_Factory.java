package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.payasset.repository.PayAssetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPayCardConfig_Factory implements Factory<GetPayCardConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<PayAssetRepository> payAssetRepositoryProvider;

    public GetPayCardConfig_Factory(Provider<FeatureConfigRepository> provider, Provider<PayAssetRepository> provider2) {
        this.featureConfigRepositoryProvider = provider;
        this.payAssetRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetPayCardConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get(), this.payAssetRepositoryProvider.get());
    }

    public static GetPayCardConfig_Factory create(Provider<FeatureConfigRepository> provider, Provider<PayAssetRepository> provider2) {
        return new GetPayCardConfig_Factory(provider, provider2);
    }

    public static GetPayCardConfig newInstance(FeatureConfigRepository featureConfigRepository, PayAssetRepository payAssetRepository) {
        return new GetPayCardConfig(featureConfigRepository, payAssetRepository);
    }
}

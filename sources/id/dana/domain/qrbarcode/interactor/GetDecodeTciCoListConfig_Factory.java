package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDecodeTciCoListConfig_Factory implements Factory<GetDecodeTciCoListConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetDecodeTciCoListConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetDecodeTciCoListConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetDecodeTciCoListConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetDecodeTciCoListConfig_Factory(provider);
    }

    public static GetDecodeTciCoListConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetDecodeTciCoListConfig(featureConfigRepository);
    }
}

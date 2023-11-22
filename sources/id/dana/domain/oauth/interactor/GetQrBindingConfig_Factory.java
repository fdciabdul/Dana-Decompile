package id.dana.domain.oauth.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQrBindingConfig_Factory implements Factory<GetQrBindingConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetQrBindingConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQrBindingConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetQrBindingConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetQrBindingConfig_Factory(provider);
    }

    public static GetQrBindingConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetQrBindingConfig(featureConfigRepository);
    }
}

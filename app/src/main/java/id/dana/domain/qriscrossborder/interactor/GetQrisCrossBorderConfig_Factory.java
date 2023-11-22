package id.dana.domain.qriscrossborder.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQrisCrossBorderConfig_Factory implements Factory<GetQrisCrossBorderConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetQrisCrossBorderConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQrisCrossBorderConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetQrisCrossBorderConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetQrisCrossBorderConfig_Factory(provider);
    }

    public static GetQrisCrossBorderConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetQrisCrossBorderConfig(featureConfigRepository);
    }
}

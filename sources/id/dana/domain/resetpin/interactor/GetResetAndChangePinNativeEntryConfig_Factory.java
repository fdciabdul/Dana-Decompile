package id.dana.domain.resetpin.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetResetAndChangePinNativeEntryConfig_Factory implements Factory<GetResetAndChangePinNativeEntryConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetResetAndChangePinNativeEntryConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetResetAndChangePinNativeEntryConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetResetAndChangePinNativeEntryConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetResetAndChangePinNativeEntryConfig_Factory(provider);
    }

    public static GetResetAndChangePinNativeEntryConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetResetAndChangePinNativeEntryConfig(featureConfigRepository);
    }
}

package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetLoginRegisterConfig_Factory implements Factory<GetLoginRegisterConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetLoginRegisterConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetLoginRegisterConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetLoginRegisterConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetLoginRegisterConfig_Factory(provider);
    }

    public static GetLoginRegisterConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetLoginRegisterConfig(featureConfigRepository);
    }
}

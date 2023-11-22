package id.dana.domain.profilemenu.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetProfileRevampConfig_Factory implements Factory<GetProfileRevampConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetProfileRevampConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetProfileRevampConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetProfileRevampConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetProfileRevampConfig_Factory(provider);
    }

    public static GetProfileRevampConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetProfileRevampConfig(featureConfigRepository);
    }
}

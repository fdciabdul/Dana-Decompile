package id.dana.domain.maintenance.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetEmergencyNotifConfig_Factory implements Factory<GetEmergencyNotifConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetEmergencyNotifConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetEmergencyNotifConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetEmergencyNotifConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetEmergencyNotifConfig_Factory(provider);
    }

    public static GetEmergencyNotifConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetEmergencyNotifConfig(featureConfigRepository);
    }
}

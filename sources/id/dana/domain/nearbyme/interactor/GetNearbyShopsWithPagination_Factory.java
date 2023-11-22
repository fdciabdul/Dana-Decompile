package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.tracker.MixpanelRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetNearbyShopsWithPagination_Factory implements Factory<GetNearbyShopsWithPagination> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<MixpanelRepository> mixpanelRepositoryProvider;
    private final Provider<NearbyMeRepository> nearbyMeRepositoryProvider;

    public GetNearbyShopsWithPagination_Factory(Provider<NearbyMeRepository> provider, Provider<FeatureConfigRepository> provider2, Provider<MixpanelRepository> provider3) {
        this.nearbyMeRepositoryProvider = provider;
        this.featureConfigRepositoryProvider = provider2;
        this.mixpanelRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetNearbyShopsWithPagination get() {
        return newInstance(this.nearbyMeRepositoryProvider.get(), this.featureConfigRepositoryProvider.get(), this.mixpanelRepositoryProvider.get());
    }

    public static GetNearbyShopsWithPagination_Factory create(Provider<NearbyMeRepository> provider, Provider<FeatureConfigRepository> provider2, Provider<MixpanelRepository> provider3) {
        return new GetNearbyShopsWithPagination_Factory(provider, provider2, provider3);
    }

    public static GetNearbyShopsWithPagination newInstance(NearbyMeRepository nearbyMeRepository, FeatureConfigRepository featureConfigRepository, MixpanelRepository mixpanelRepository) {
        return new GetNearbyShopsWithPagination(nearbyMeRepository, featureConfigRepository, mixpanelRepository);
    }
}

package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.NearbyMeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetNearbyRankingConfig_Factory implements Factory<GetNearbyRankingConfig> {
    private final Provider<NearbyMeRepository> nearbyMeRepositoryProvider;

    public GetNearbyRankingConfig_Factory(Provider<NearbyMeRepository> provider) {
        this.nearbyMeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetNearbyRankingConfig get() {
        return newInstance(this.nearbyMeRepositoryProvider.get());
    }

    public static GetNearbyRankingConfig_Factory create(Provider<NearbyMeRepository> provider) {
        return new GetNearbyRankingConfig_Factory(provider);
    }

    public static GetNearbyRankingConfig newInstance(NearbyMeRepository nearbyMeRepository) {
        return new GetNearbyRankingConfig(nearbyMeRepository);
    }
}

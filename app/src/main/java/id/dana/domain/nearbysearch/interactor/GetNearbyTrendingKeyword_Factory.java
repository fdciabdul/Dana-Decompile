package id.dana.domain.nearbysearch.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.NearbyMeRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetNearbyTrendingKeyword_Factory implements Factory<GetNearbyTrendingKeyword> {
    private final Provider<NearbyMeRepository> nearbyMeRepositoryProvider;

    public GetNearbyTrendingKeyword_Factory(Provider<NearbyMeRepository> provider) {
        this.nearbyMeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetNearbyTrendingKeyword get() {
        return newInstance(this.nearbyMeRepositoryProvider.get());
    }

    public static GetNearbyTrendingKeyword_Factory create(Provider<NearbyMeRepository> provider) {
        return new GetNearbyTrendingKeyword_Factory(provider);
    }

    public static GetNearbyTrendingKeyword newInstance(NearbyMeRepository nearbyMeRepository) {
        return new GetNearbyTrendingKeyword(nearbyMeRepository);
    }
}

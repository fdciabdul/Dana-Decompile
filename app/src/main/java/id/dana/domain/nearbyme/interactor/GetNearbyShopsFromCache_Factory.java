package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.NearbyMeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetNearbyShopsFromCache_Factory implements Factory<GetNearbyShopsFromCache> {
    private final Provider<NearbyMeRepository> nearbyMeRepositoryProvider;

    public GetNearbyShopsFromCache_Factory(Provider<NearbyMeRepository> provider) {
        this.nearbyMeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetNearbyShopsFromCache get() {
        return newInstance(this.nearbyMeRepositoryProvider.get());
    }

    public static GetNearbyShopsFromCache_Factory create(Provider<NearbyMeRepository> provider) {
        return new GetNearbyShopsFromCache_Factory(provider);
    }

    public static GetNearbyShopsFromCache newInstance(NearbyMeRepository nearbyMeRepository) {
        return new GetNearbyShopsFromCache(nearbyMeRepository);
    }
}

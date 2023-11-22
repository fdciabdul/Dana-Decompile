package id.dana.domain.nearbyplaces.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetListNearbyLocation_Factory implements Factory<GetListNearbyLocation> {
    private final Provider<NearbyPlaceRepository> nearbyPlaceRepositoryProvider;

    public GetListNearbyLocation_Factory(Provider<NearbyPlaceRepository> provider) {
        this.nearbyPlaceRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetListNearbyLocation get() {
        return newInstance(this.nearbyPlaceRepositoryProvider.get());
    }

    public static GetListNearbyLocation_Factory create(Provider<NearbyPlaceRepository> provider) {
        return new GetListNearbyLocation_Factory(provider);
    }

    public static GetListNearbyLocation newInstance(NearbyPlaceRepository nearbyPlaceRepository) {
        return new GetListNearbyLocation(nearbyPlaceRepository);
    }
}

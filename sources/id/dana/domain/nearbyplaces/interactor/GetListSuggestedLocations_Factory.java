package id.dana.domain.nearbyplaces.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetListSuggestedLocations_Factory implements Factory<GetListSuggestedLocations> {
    private final Provider<NearbyPlaceRepository> nearbyPlaceRepositoryProvider;

    public GetListSuggestedLocations_Factory(Provider<NearbyPlaceRepository> provider) {
        this.nearbyPlaceRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetListSuggestedLocations get() {
        return newInstance(this.nearbyPlaceRepositoryProvider.get());
    }

    public static GetListSuggestedLocations_Factory create(Provider<NearbyPlaceRepository> provider) {
        return new GetListSuggestedLocations_Factory(provider);
    }

    public static GetListSuggestedLocations newInstance(NearbyPlaceRepository nearbyPlaceRepository) {
        return new GetListSuggestedLocations(nearbyPlaceRepository);
    }
}

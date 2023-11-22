package id.dana.domain.nearbyplaces.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetChainQueryResult_Factory implements Factory<GetChainQueryResult> {
    private final Provider<NearbyPlaceRepository> nearbyPlaceRepositoryProvider;

    public GetChainQueryResult_Factory(Provider<NearbyPlaceRepository> provider) {
        this.nearbyPlaceRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetChainQueryResult get() {
        return newInstance(this.nearbyPlaceRepositoryProvider.get());
    }

    public static GetChainQueryResult_Factory create(Provider<NearbyPlaceRepository> provider) {
        return new GetChainQueryResult_Factory(provider);
    }

    public static GetChainQueryResult newInstance(NearbyPlaceRepository nearbyPlaceRepository) {
        return new GetChainQueryResult(nearbyPlaceRepository);
    }
}

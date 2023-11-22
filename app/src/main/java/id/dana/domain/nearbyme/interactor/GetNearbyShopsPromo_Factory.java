package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.NearbyMeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetNearbyShopsPromo_Factory implements Factory<GetNearbyShopsPromo> {
    private final Provider<NearbyMeRepository> nearbyMeRepositoryProvider;

    public GetNearbyShopsPromo_Factory(Provider<NearbyMeRepository> provider) {
        this.nearbyMeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetNearbyShopsPromo get() {
        return newInstance(this.nearbyMeRepositoryProvider.get());
    }

    public static GetNearbyShopsPromo_Factory create(Provider<NearbyMeRepository> provider) {
        return new GetNearbyShopsPromo_Factory(provider);
    }

    public static GetNearbyShopsPromo newInstance(NearbyMeRepository nearbyMeRepository) {
        return new GetNearbyShopsPromo(nearbyMeRepository);
    }
}

package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.geocode.GeocodeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDistrictNameByLocation_Factory implements Factory<GetDistrictNameByLocation> {
    private final Provider<GeocodeRepository> geocodeRepositoryProvider;

    public GetDistrictNameByLocation_Factory(Provider<GeocodeRepository> provider) {
        this.geocodeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetDistrictNameByLocation get() {
        return newInstance(this.geocodeRepositoryProvider.get());
    }

    public static GetDistrictNameByLocation_Factory create(Provider<GeocodeRepository> provider) {
        return new GetDistrictNameByLocation_Factory(provider);
    }

    public static GetDistrictNameByLocation newInstance(GeocodeRepository geocodeRepository) {
        return new GetDistrictNameByLocation(geocodeRepository);
    }
}

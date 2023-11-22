package id.dana.domain.miniprogram.interactor;

import dagger.internal.Factory;
import id.dana.domain.geocode.GeocodeRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetReverseGeocodeByLocation_Factory implements Factory<GetReverseGeocodeByLocation> {
    private final Provider<GeocodeRepository> geocodeRepositoryProvider;

    public GetReverseGeocodeByLocation_Factory(Provider<GeocodeRepository> provider) {
        this.geocodeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetReverseGeocodeByLocation get() {
        return newInstance(this.geocodeRepositoryProvider.get());
    }

    public static GetReverseGeocodeByLocation_Factory create(Provider<GeocodeRepository> provider) {
        return new GetReverseGeocodeByLocation_Factory(provider);
    }

    public static GetReverseGeocodeByLocation newInstance(GeocodeRepository geocodeRepository) {
        return new GetReverseGeocodeByLocation(geocodeRepository);
    }
}

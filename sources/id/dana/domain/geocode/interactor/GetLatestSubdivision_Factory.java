package id.dana.domain.geocode.interactor;

import dagger.internal.Factory;
import id.dana.domain.geocode.GeocodeRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetLatestSubdivision_Factory implements Factory<GetLatestSubdivision> {
    private final Provider<GeocodeRepository> geocodeRepositoryProvider;

    public GetLatestSubdivision_Factory(Provider<GeocodeRepository> provider) {
        this.geocodeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetLatestSubdivision get() {
        return newInstance(this.geocodeRepositoryProvider.get());
    }

    public static GetLatestSubdivision_Factory create(Provider<GeocodeRepository> provider) {
        return new GetLatestSubdivision_Factory(provider);
    }

    public static GetLatestSubdivision newInstance(GeocodeRepository geocodeRepository) {
        return new GetLatestSubdivision(geocodeRepository);
    }
}

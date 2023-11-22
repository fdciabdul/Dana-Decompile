package id.dana.domain.geocode.interactor;

import dagger.internal.Factory;
import id.dana.domain.geocode.GeocodeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetIndoProvinceLandmark_Factory implements Factory<GetIndoProvinceLandmark> {
    private final Provider<GeocodeRepository> geocodeRepositoryProvider;

    public GetIndoProvinceLandmark_Factory(Provider<GeocodeRepository> provider) {
        this.geocodeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetIndoProvinceLandmark get() {
        return newInstance(this.geocodeRepositoryProvider.get());
    }

    public static GetIndoProvinceLandmark_Factory create(Provider<GeocodeRepository> provider) {
        return new GetIndoProvinceLandmark_Factory(provider);
    }

    public static GetIndoProvinceLandmark newInstance(GeocodeRepository geocodeRepository) {
        return new GetIndoProvinceLandmark(geocodeRepository);
    }
}

package id.dana.data.geocode.repository;

import dagger.internal.Factory;
import id.dana.data.geocode.repository.config.GeocodeConfigEntityDataFactory;
import id.dana.data.geocode.repository.source.GeocodeEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GeocodeEntityRepository_Factory implements Factory<GeocodeEntityRepository> {
    private final Provider<GeocodeConfigEntityDataFactory> geocodeConfigEntityDataFactoryProvider;
    private final Provider<GeocodeEntityDataFactory> geocodeEntityDataFactoryProvider;

    public GeocodeEntityRepository_Factory(Provider<GeocodeEntityDataFactory> provider, Provider<GeocodeConfigEntityDataFactory> provider2) {
        this.geocodeEntityDataFactoryProvider = provider;
        this.geocodeConfigEntityDataFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GeocodeEntityRepository get() {
        return newInstance(this.geocodeEntityDataFactoryProvider.get(), this.geocodeConfigEntityDataFactoryProvider.get());
    }

    public static GeocodeEntityRepository_Factory create(Provider<GeocodeEntityDataFactory> provider, Provider<GeocodeConfigEntityDataFactory> provider2) {
        return new GeocodeEntityRepository_Factory(provider, provider2);
    }

    public static GeocodeEntityRepository newInstance(GeocodeEntityDataFactory geocodeEntityDataFactory, GeocodeConfigEntityDataFactory geocodeConfigEntityDataFactory) {
        return new GeocodeEntityRepository(geocodeEntityDataFactory, geocodeConfigEntityDataFactory);
    }
}

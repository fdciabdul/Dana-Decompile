package id.dana.data.geocode.repository.config;

import dagger.internal.Factory;
import id.dana.data.geocode.repository.config.local.LocalGeocodeConfigEntityData;
import id.dana.data.geocode.repository.config.split.SplitGeocodeConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GeocodeConfigEntityDataFactory_Factory implements Factory<GeocodeConfigEntityDataFactory> {
    private final Provider<LocalGeocodeConfigEntityData> localGeocodeConfigEntityDataProvider;
    private final Provider<SplitGeocodeConfigEntityData> splitGeocodeConfigEntityDataProvider;

    public GeocodeConfigEntityDataFactory_Factory(Provider<SplitGeocodeConfigEntityData> provider, Provider<LocalGeocodeConfigEntityData> provider2) {
        this.splitGeocodeConfigEntityDataProvider = provider;
        this.localGeocodeConfigEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GeocodeConfigEntityDataFactory get() {
        return newInstance(this.splitGeocodeConfigEntityDataProvider.get(), this.localGeocodeConfigEntityDataProvider.get());
    }

    public static GeocodeConfigEntityDataFactory_Factory create(Provider<SplitGeocodeConfigEntityData> provider, Provider<LocalGeocodeConfigEntityData> provider2) {
        return new GeocodeConfigEntityDataFactory_Factory(provider, provider2);
    }

    public static GeocodeConfigEntityDataFactory newInstance(SplitGeocodeConfigEntityData splitGeocodeConfigEntityData, LocalGeocodeConfigEntityData localGeocodeConfigEntityData) {
        return new GeocodeConfigEntityDataFactory(splitGeocodeConfigEntityData, localGeocodeConfigEntityData);
    }
}

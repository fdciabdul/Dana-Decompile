package id.dana.data.geofence.repository.source;

import dagger.internal.Factory;
import id.dana.data.geofence.repository.source.cache.LocalPoiEntityData;
import id.dana.data.geofence.repository.source.network.NetworkPoiEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GeoFenceDataFactory_Factory implements Factory<GeoFenceDataFactory> {
    private final Provider<LocalPoiEntityData> localPoiEntityDataProvider;
    private final Provider<NetworkPoiEntityData> networkPoiEntityDataProvider;

    public GeoFenceDataFactory_Factory(Provider<NetworkPoiEntityData> provider, Provider<LocalPoiEntityData> provider2) {
        this.networkPoiEntityDataProvider = provider;
        this.localPoiEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GeoFenceDataFactory get() {
        return newInstance(this.networkPoiEntityDataProvider.get(), this.localPoiEntityDataProvider.get());
    }

    public static GeoFenceDataFactory_Factory create(Provider<NetworkPoiEntityData> provider, Provider<LocalPoiEntityData> provider2) {
        return new GeoFenceDataFactory_Factory(provider, provider2);
    }

    public static GeoFenceDataFactory newInstance(NetworkPoiEntityData networkPoiEntityData, LocalPoiEntityData localPoiEntityData) {
        return new GeoFenceDataFactory(networkPoiEntityData, localPoiEntityData);
    }
}

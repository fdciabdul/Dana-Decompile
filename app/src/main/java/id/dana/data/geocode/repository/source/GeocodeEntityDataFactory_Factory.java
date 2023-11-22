package id.dana.data.geocode.repository.source;

import dagger.internal.Factory;
import id.dana.data.geocode.repository.source.local.LocalGeocodeEntityData;
import id.dana.data.geocode.repository.source.network.NetworkGeocodeEntityData;
import id.dana.data.here.source.network.NetworkHereGeocodeEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GeocodeEntityDataFactory_Factory implements Factory<GeocodeEntityDataFactory> {
    private final Provider<LocalGeocodeEntityData> localGeocodeEntityDataProvider;
    private final Provider<NetworkGeocodeEntityData> networkGeocodeEntityDataProvider;
    private final Provider<NetworkHereGeocodeEntityData> networkHereGeocodeEntityDataProvider;

    public GeocodeEntityDataFactory_Factory(Provider<NetworkHereGeocodeEntityData> provider, Provider<NetworkGeocodeEntityData> provider2, Provider<LocalGeocodeEntityData> provider3) {
        this.networkHereGeocodeEntityDataProvider = provider;
        this.networkGeocodeEntityDataProvider = provider2;
        this.localGeocodeEntityDataProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GeocodeEntityDataFactory get() {
        return newInstance(this.networkHereGeocodeEntityDataProvider.get(), this.networkGeocodeEntityDataProvider.get(), this.localGeocodeEntityDataProvider.get());
    }

    public static GeocodeEntityDataFactory_Factory create(Provider<NetworkHereGeocodeEntityData> provider, Provider<NetworkGeocodeEntityData> provider2, Provider<LocalGeocodeEntityData> provider3) {
        return new GeocodeEntityDataFactory_Factory(provider, provider2, provider3);
    }

    public static GeocodeEntityDataFactory newInstance(NetworkHereGeocodeEntityData networkHereGeocodeEntityData, NetworkGeocodeEntityData networkGeocodeEntityData, LocalGeocodeEntityData localGeocodeEntityData) {
        return new GeocodeEntityDataFactory(networkHereGeocodeEntityData, networkGeocodeEntityData, localGeocodeEntityData);
    }
}

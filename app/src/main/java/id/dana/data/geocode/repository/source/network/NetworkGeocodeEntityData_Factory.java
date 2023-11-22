package id.dana.data.geocode.repository.source.network;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkGeocodeEntityData_Factory implements Factory<NetworkGeocodeEntityData> {
    private final Provider<GeocoderApi> geocoderApiProvider;

    public NetworkGeocodeEntityData_Factory(Provider<GeocoderApi> provider) {
        this.geocoderApiProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NetworkGeocodeEntityData get() {
        return newInstance(this.geocoderApiProvider.get());
    }

    public static NetworkGeocodeEntityData_Factory create(Provider<GeocoderApi> provider) {
        return new NetworkGeocodeEntityData_Factory(provider);
    }

    public static NetworkGeocodeEntityData newInstance(GeocoderApi geocoderApi) {
        return new NetworkGeocodeEntityData(geocoderApi);
    }
}

package id.dana.data.nearbyplaces.repository.source.network;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class NetworkNearbyPlaceEntityData_Factory implements Factory<NetworkNearbyPlaceEntityData> {
    private final Provider<NearbyPlacesApi> nearbyPlacesApiProvider;

    public NetworkNearbyPlaceEntityData_Factory(Provider<NearbyPlacesApi> provider) {
        this.nearbyPlacesApiProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NetworkNearbyPlaceEntityData get() {
        return newInstance(this.nearbyPlacesApiProvider.get());
    }

    public static NetworkNearbyPlaceEntityData_Factory create(Provider<NearbyPlacesApi> provider) {
        return new NetworkNearbyPlaceEntityData_Factory(provider);
    }

    public static NetworkNearbyPlaceEntityData newInstance(NearbyPlacesApi nearbyPlacesApi) {
        return new NetworkNearbyPlaceEntityData(nearbyPlacesApi);
    }
}

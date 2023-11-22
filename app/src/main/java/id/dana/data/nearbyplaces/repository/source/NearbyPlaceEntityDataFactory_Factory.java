package id.dana.data.nearbyplaces.repository.source;

import dagger.internal.Factory;
import id.dana.data.here.source.network.NetworkHereLocationEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NearbyPlaceEntityDataFactory_Factory implements Factory<NearbyPlaceEntityDataFactory> {
    private final Provider<NetworkHereLocationEntityData> networkNearbyPlaceEntityDataProvider;

    public NearbyPlaceEntityDataFactory_Factory(Provider<NetworkHereLocationEntityData> provider) {
        this.networkNearbyPlaceEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NearbyPlaceEntityDataFactory get() {
        return newInstance(this.networkNearbyPlaceEntityDataProvider.get());
    }

    public static NearbyPlaceEntityDataFactory_Factory create(Provider<NetworkHereLocationEntityData> provider) {
        return new NearbyPlaceEntityDataFactory_Factory(provider);
    }

    public static NearbyPlaceEntityDataFactory newInstance(NetworkHereLocationEntityData networkHereLocationEntityData) {
        return new NearbyPlaceEntityDataFactory(networkHereLocationEntityData);
    }
}

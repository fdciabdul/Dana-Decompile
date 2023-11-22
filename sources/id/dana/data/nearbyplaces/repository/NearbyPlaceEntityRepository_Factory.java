package id.dana.data.nearbyplaces.repository;

import dagger.internal.Factory;
import id.dana.data.nearbyplaces.repository.source.NearbyPlaceEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NearbyPlaceEntityRepository_Factory implements Factory<NearbyPlaceEntityRepository> {
    private final Provider<NearbyPlaceEntityDataFactory> nearbyPlaceEntityDataFactoryProvider;

    public NearbyPlaceEntityRepository_Factory(Provider<NearbyPlaceEntityDataFactory> provider) {
        this.nearbyPlaceEntityDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NearbyPlaceEntityRepository get() {
        return newInstance(this.nearbyPlaceEntityDataFactoryProvider.get());
    }

    public static NearbyPlaceEntityRepository_Factory create(Provider<NearbyPlaceEntityDataFactory> provider) {
        return new NearbyPlaceEntityRepository_Factory(provider);
    }

    public static NearbyPlaceEntityRepository newInstance(NearbyPlaceEntityDataFactory nearbyPlaceEntityDataFactory) {
        return new NearbyPlaceEntityRepository(nearbyPlaceEntityDataFactory);
    }
}

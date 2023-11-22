package id.dana.data.geofence.repository.source;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GeoFenceEntityRepository_Factory implements Factory<GeoFenceEntityRepository> {
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<GeneralPreferences> generalPreferencesProvider;
    private final Provider<GeoFenceDataFactory> geoFenceDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<SecuredAccountPreferences> securedAccountPreferencesProvider;

    public GeoFenceEntityRepository_Factory(Provider<GeoFenceDataFactory> provider, Provider<DeviceInformationProvider> provider2, Provider<SecuredAccountPreferences> provider3, Provider<GeneralPreferences> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        this.geoFenceDataFactoryProvider = provider;
        this.deviceInformationProvider = provider2;
        this.securedAccountPreferencesProvider = provider3;
        this.generalPreferencesProvider = provider4;
        this.holdLoginV1EntityRepositoryProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final GeoFenceEntityRepository get() {
        return newInstance(this.geoFenceDataFactoryProvider.get(), this.deviceInformationProvider.get(), this.securedAccountPreferencesProvider.get(), this.generalPreferencesProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static GeoFenceEntityRepository_Factory create(Provider<GeoFenceDataFactory> provider, Provider<DeviceInformationProvider> provider2, Provider<SecuredAccountPreferences> provider3, Provider<GeneralPreferences> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        return new GeoFenceEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static GeoFenceEntityRepository newInstance(GeoFenceDataFactory geoFenceDataFactory, DeviceInformationProvider deviceInformationProvider, SecuredAccountPreferences securedAccountPreferences, GeneralPreferences generalPreferences, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new GeoFenceEntityRepository(geoFenceDataFactory, deviceInformationProvider, securedAccountPreferences, generalPreferences, holdLoginV1EntityRepository);
    }
}

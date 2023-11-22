package id.dana.data.nearbyme.repository.source;

import dagger.internal.Factory;
import id.dana.data.nearbyme.repository.source.mock.MockNearbyMeEntityRepositoryData;
import id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData;
import id.dana.data.nearbyme.repository.source.session.LocalNearbyMeEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NearbyMeDataFactory_Factory implements Factory<NearbyMeDataFactory> {
    private final Provider<LocalNearbyMeEntityData> localNearbyMeEntityDataProvider;
    private final Provider<MockNearbyMeEntityRepositoryData> mockNearbyMeEntityRepositoryDataProvider;
    private final Provider<NetworkNearbyMeEntityData> networkNearbyMeEntityDataProvider;

    public NearbyMeDataFactory_Factory(Provider<NetworkNearbyMeEntityData> provider, Provider<MockNearbyMeEntityRepositoryData> provider2, Provider<LocalNearbyMeEntityData> provider3) {
        this.networkNearbyMeEntityDataProvider = provider;
        this.mockNearbyMeEntityRepositoryDataProvider = provider2;
        this.localNearbyMeEntityDataProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final NearbyMeDataFactory get() {
        return newInstance(this.networkNearbyMeEntityDataProvider.get(), this.mockNearbyMeEntityRepositoryDataProvider.get(), this.localNearbyMeEntityDataProvider.get());
    }

    public static NearbyMeDataFactory_Factory create(Provider<NetworkNearbyMeEntityData> provider, Provider<MockNearbyMeEntityRepositoryData> provider2, Provider<LocalNearbyMeEntityData> provider3) {
        return new NearbyMeDataFactory_Factory(provider, provider2, provider3);
    }

    public static NearbyMeDataFactory newInstance(NetworkNearbyMeEntityData networkNearbyMeEntityData, MockNearbyMeEntityRepositoryData mockNearbyMeEntityRepositoryData, LocalNearbyMeEntityData localNearbyMeEntityData) {
        return new NearbyMeDataFactory(networkNearbyMeEntityData, mockNearbyMeEntityRepositoryData, localNearbyMeEntityData);
    }
}

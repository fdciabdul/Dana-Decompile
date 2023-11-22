package id.dana.data.synccontact.repository.source;

import dagger.internal.Factory;
import id.dana.data.synccontact.repository.source.local.PreferencesSyncContactEntityData;
import id.dana.data.synccontact.repository.source.mock.MockSyncContactEntityData;
import id.dana.data.synccontact.repository.source.network.NetworkSyncContactEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SyncContactDataFactory_Factory implements Factory<SyncContactDataFactory> {
    private final Provider<MockSyncContactEntityData> mockSyncContactEntityDataProvider;
    private final Provider<NetworkSyncContactEntityData> networkSyncContactEntityDataProvider;
    private final Provider<PreferencesSyncContactEntityData> preferencesSyncContactEntityDataProvider;

    public SyncContactDataFactory_Factory(Provider<PreferencesSyncContactEntityData> provider, Provider<NetworkSyncContactEntityData> provider2, Provider<MockSyncContactEntityData> provider3) {
        this.preferencesSyncContactEntityDataProvider = provider;
        this.networkSyncContactEntityDataProvider = provider2;
        this.mockSyncContactEntityDataProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SyncContactDataFactory get() {
        return newInstance(this.preferencesSyncContactEntityDataProvider.get(), this.networkSyncContactEntityDataProvider.get(), this.mockSyncContactEntityDataProvider.get());
    }

    public static SyncContactDataFactory_Factory create(Provider<PreferencesSyncContactEntityData> provider, Provider<NetworkSyncContactEntityData> provider2, Provider<MockSyncContactEntityData> provider3) {
        return new SyncContactDataFactory_Factory(provider, provider2, provider3);
    }

    public static SyncContactDataFactory newInstance(PreferencesSyncContactEntityData preferencesSyncContactEntityData, NetworkSyncContactEntityData networkSyncContactEntityData, MockSyncContactEntityData mockSyncContactEntityData) {
        return new SyncContactDataFactory(preferencesSyncContactEntityData, networkSyncContactEntityData, mockSyncContactEntityData);
    }
}

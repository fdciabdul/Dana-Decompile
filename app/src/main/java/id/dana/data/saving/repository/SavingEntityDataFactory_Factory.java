package id.dana.data.saving.repository;

import dagger.internal.Factory;
import id.dana.data.saving.repository.source.mock.MockSavingEntityData;
import id.dana.data.saving.repository.source.network.NetworkSavingEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SavingEntityDataFactory_Factory implements Factory<SavingEntityDataFactory> {
    private final Provider<MockSavingEntityData> mockSavingEntityDataProvider;
    private final Provider<NetworkSavingEntityData> networkSavingEntityDataProvider;

    public SavingEntityDataFactory_Factory(Provider<NetworkSavingEntityData> provider, Provider<MockSavingEntityData> provider2) {
        this.networkSavingEntityDataProvider = provider;
        this.mockSavingEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SavingEntityDataFactory get() {
        return newInstance(this.networkSavingEntityDataProvider.get(), this.mockSavingEntityDataProvider.get());
    }

    public static SavingEntityDataFactory_Factory create(Provider<NetworkSavingEntityData> provider, Provider<MockSavingEntityData> provider2) {
        return new SavingEntityDataFactory_Factory(provider, provider2);
    }

    public static SavingEntityDataFactory newInstance(NetworkSavingEntityData networkSavingEntityData, MockSavingEntityData mockSavingEntityData) {
        return new SavingEntityDataFactory(networkSavingEntityData, mockSavingEntityData);
    }
}
